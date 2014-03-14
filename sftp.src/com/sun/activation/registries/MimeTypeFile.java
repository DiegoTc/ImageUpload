/*   1:    */ package com.sun.activation.registries;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.File;
/*   5:    */ import java.io.FileReader;
/*   6:    */ import java.io.IOException;
/*   7:    */ import java.io.InputStream;
/*   8:    */ import java.io.InputStreamReader;
/*   9:    */ import java.io.PrintStream;
/*  10:    */ import java.io.StringReader;
/*  11:    */ import java.util.Hashtable;
/*  12:    */ import java.util.StringTokenizer;
/*  13:    */ 
/*  14:    */ public class MimeTypeFile
/*  15:    */ {
/*  16:    */   private String fname;
/*  17: 29 */   private Hashtable type_hash = new Hashtable();
/*  18:    */   private static boolean DEBUG;
/*  19:    */   
/*  20:    */   public MimeTypeFile(String paramString)
/*  21:    */     throws IOException
/*  22:    */   {
/*  23: 38 */     File localFile = null;
/*  24: 39 */     FileReader localFileReader = null;
/*  25:    */     
/*  26: 41 */     this.fname = paramString;
/*  27:    */     
/*  28: 43 */     localFile = new File(this.fname);
/*  29:    */     
/*  30: 45 */     localFileReader = new FileReader(localFile);
/*  31:    */     try
/*  32:    */     {
/*  33: 48 */       parse(new BufferedReader(localFileReader));
/*  34:    */     }
/*  35:    */     finally
/*  36:    */     {
/*  37:    */       try
/*  38:    */       {
/*  39: 51 */         localFileReader.close();
/*  40:    */       }
/*  41:    */       catch (IOException localIOException) {}
/*  42:    */     }
/*  43:    */   }
/*  44:    */   
/*  45:    */   public MimeTypeFile(InputStream paramInputStream)
/*  46:    */     throws IOException
/*  47:    */   {
/*  48: 59 */     parse(new BufferedReader(new InputStreamReader(paramInputStream, "iso-8859-1")));
/*  49:    */   }
/*  50:    */   
/*  51:    */   public MimeTypeFile() {}
/*  52:    */   
/*  53:    */   public MimeTypeEntry getMimeTypeEntry(String paramString)
/*  54:    */   {
/*  55: 72 */     return (MimeTypeEntry)this.type_hash.get(paramString);
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getMIMETypeString(String paramString)
/*  59:    */   {
/*  60: 79 */     MimeTypeEntry localMimeTypeEntry = getMimeTypeEntry(paramString);
/*  61: 81 */     if (localMimeTypeEntry != null) {
/*  62: 82 */       return localMimeTypeEntry.getMIMEType();
/*  63:    */     }
/*  64: 84 */     return null;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void appendToRegistry(String paramString)
/*  68:    */   {
/*  69:    */     try
/*  70:    */     {
/*  71:104 */       parse(new BufferedReader(new StringReader(paramString)));
/*  72:    */     }
/*  73:    */     catch (IOException localIOException) {}
/*  74:    */   }
/*  75:    */   
/*  76:    */   private void parse(BufferedReader paramBufferedReader)
/*  77:    */     throws IOException
/*  78:    */   {
/*  79:114 */     String str1 = null;String str2 = null;
/*  80:116 */     while ((str1 = paramBufferedReader.readLine()) != null)
/*  81:    */     {
/*  82:117 */       if (str2 == null) {
/*  83:118 */         str2 = str1;
/*  84:    */       } else {
/*  85:120 */         str2 = str2 + str1;
/*  86:    */       }
/*  87:121 */       int i = str2.length();
/*  88:122 */       if ((str2.length() > 0) && (str2.charAt(i - 1) == '\\'))
/*  89:    */       {
/*  90:123 */         str2 = str2.substring(0, i - 1);
/*  91:    */       }
/*  92:    */       else
/*  93:    */       {
/*  94:126 */         parseEntry(str2);
/*  95:127 */         str2 = null;
/*  96:    */       }
/*  97:    */     }
/*  98:129 */     if (str2 != null) {
/*  99:130 */       parseEntry(str2);
/* 100:    */     }
/* 101:    */   }
/* 102:    */   
/* 103:    */   private void parseEntry(String paramString)
/* 104:    */   {
/* 105:137 */     Object localObject1 = null;
/* 106:138 */     String str1 = null;
/* 107:139 */     paramString = paramString.trim();
/* 108:141 */     if (paramString.length() == 0) {
/* 109:142 */       return;
/* 110:    */     }
/* 111:145 */     if (paramString.charAt(0) == '#') {
/* 112:    */       return;
/* 113:    */     }
/* 114:    */     Object localObject2;
/* 115:    */     Object localObject3;
/* 116:149 */     if (paramString.indexOf('=') > 0)
/* 117:    */     {
/* 118:151 */       localObject2 = new LineTokenizer(paramString);
/* 119:152 */       while (((LineTokenizer)localObject2).hasMoreTokens())
/* 120:    */       {
/* 121:153 */         String str2 = ((LineTokenizer)localObject2).nextToken();
/* 122:154 */         localObject3 = null;
/* 123:155 */         if ((((LineTokenizer)localObject2).hasMoreTokens()) && (((LineTokenizer)localObject2).nextToken().equals("=")) && 
/* 124:156 */           (((LineTokenizer)localObject2).hasMoreTokens())) {
/* 125:157 */           localObject3 = ((LineTokenizer)localObject2).nextToken();
/* 126:    */         }
/* 127:158 */         if (localObject3 == null)
/* 128:    */         {
/* 129:159 */           System.err.println("Bad .mime.types entry: " + paramString);
/* 130:160 */           return;
/* 131:    */         }
/* 132:162 */         if (str2.equals("type"))
/* 133:    */         {
/* 134:163 */           localObject1 = localObject3;
/* 135:    */         }
/* 136:164 */         else if (str2.equals("exts"))
/* 137:    */         {
/* 138:165 */           StringTokenizer localStringTokenizer = new StringTokenizer((String)localObject3, ",");
/* 139:166 */           while (localStringTokenizer.hasMoreTokens())
/* 140:    */           {
/* 141:167 */             str1 = localStringTokenizer.nextToken();
/* 142:168 */             MimeTypeEntry localMimeTypeEntry = 
/* 143:169 */               new MimeTypeEntry((String)localObject1, str1);
/* 144:170 */             this.type_hash.put(str1, localMimeTypeEntry);
/* 145:171 */             if (DEBUG) {
/* 146:172 */               System.out.println("Added: " + localMimeTypeEntry.toString());
/* 147:    */             }
/* 148:    */           }
/* 149:    */         }
/* 150:    */       }
/* 151:    */     }
/* 152:    */     else
/* 153:    */     {
/* 154:179 */       localObject2 = new StringTokenizer(paramString);
/* 155:180 */       int i = ((StringTokenizer)localObject2).countTokens();
/* 156:182 */       if (i == 0) {
/* 157:183 */         return;
/* 158:    */       }
/* 159:185 */       localObject1 = ((StringTokenizer)localObject2).nextToken();
/* 160:187 */       while (((StringTokenizer)localObject2).hasMoreTokens())
/* 161:    */       {
/* 162:188 */         localObject3 = null;
/* 163:    */         
/* 164:190 */         str1 = ((StringTokenizer)localObject2).nextToken();
/* 165:191 */         localObject3 = new MimeTypeEntry((String)localObject1, str1);
/* 166:192 */         this.type_hash.put(str1, localObject3);
/* 167:193 */         if (DEBUG) {
/* 168:194 */           System.out.println("Added: " + ((MimeTypeEntry)localObject3).toString());
/* 169:    */         }
/* 170:    */       }
/* 171:    */     }
/* 172:    */   }
/* 173:    */   
/* 174:    */   public static void main(String[] paramArrayOfString)
/* 175:    */     throws Exception
/* 176:    */   {
/* 177:201 */     DEBUG = true;
/* 178:202 */     MimeTypeFile localMimeTypeFile = new MimeTypeFile(paramArrayOfString[0]);
/* 179:203 */     System.out.println("ext " + paramArrayOfString[1] + " type " + 
/* 180:204 */       localMimeTypeFile.getMIMETypeString(paramArrayOfString[1]));
/* 181:205 */     System.exit(0);
/* 182:    */   }
/* 183:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.registries.MimeTypeFile
 * JD-Core Version:    0.7.0.1
 */
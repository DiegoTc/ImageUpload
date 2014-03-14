/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.io.DataInput;
/*   4:    */ import java.io.DataOutput;
/*   5:    */ import java.io.Externalizable;
/*   6:    */ import java.io.IOException;
/*   7:    */ import java.io.ObjectInput;
/*   8:    */ import java.io.ObjectOutput;
/*   9:    */ 
/*  10:    */ public class MimeType
/*  11:    */   implements Externalizable
/*  12:    */ {
/*  13:    */   private String primaryType;
/*  14:    */   private String subType;
/*  15:    */   private MimeTypeParameterList parameters;
/*  16:    */   private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
/*  17:    */   
/*  18:    */   public MimeType()
/*  19:    */   {
/*  20: 43 */     this.primaryType = "application";
/*  21: 44 */     this.subType = "*";
/*  22: 45 */     this.parameters = new MimeTypeParameterList();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public MimeType(String paramString)
/*  26:    */     throws MimeTypeParseException
/*  27:    */   {
/*  28: 54 */     parse(paramString);
/*  29:    */   }
/*  30:    */   
/*  31:    */   public MimeType(String paramString1, String paramString2)
/*  32:    */     throws MimeTypeParseException
/*  33:    */   {
/*  34: 66 */     if (isValidToken(paramString1)) {
/*  35: 67 */       this.primaryType = paramString1.toLowerCase();
/*  36:    */     } else {
/*  37: 69 */       throw new MimeTypeParseException("Primary type is invalid.");
/*  38:    */     }
/*  39: 73 */     if (isValidToken(paramString2)) {
/*  40: 74 */       this.subType = paramString2.toLowerCase();
/*  41:    */     } else {
/*  42: 76 */       throw new MimeTypeParseException("Sub type is invalid.");
/*  43:    */     }
/*  44: 79 */     this.parameters = new MimeTypeParameterList();
/*  45:    */   }
/*  46:    */   
/*  47:    */   private void parse(String paramString)
/*  48:    */     throws MimeTypeParseException
/*  49:    */   {
/*  50: 86 */     int i = paramString.indexOf('/');
/*  51: 87 */     int j = paramString.indexOf(';');
/*  52: 88 */     if ((i < 0) && (j < 0)) {
/*  53: 91 */       throw new MimeTypeParseException("Unable to find a sub type.");
/*  54:    */     }
/*  55: 92 */     if ((i < 0) && (j >= 0)) {
/*  56: 95 */       throw new MimeTypeParseException("Unable to find a sub type.");
/*  57:    */     }
/*  58: 96 */     if ((i >= 0) && (j < 0))
/*  59:    */     {
/*  60: 98 */       this.primaryType = paramString.substring(0, i).trim().toLowerCase();
/*  61: 99 */       this.subType = paramString.substring(i + 1).trim().toLowerCase();
/*  62:100 */       this.parameters = new MimeTypeParameterList();
/*  63:    */     }
/*  64:101 */     else if (i < j)
/*  65:    */     {
/*  66:103 */       this.primaryType = paramString.substring(0, i).trim().toLowerCase();
/*  67:104 */       this.subType = paramString.substring(i + 1, 
/*  68:105 */         j).trim().toLowerCase();
/*  69:106 */       this.parameters = new MimeTypeParameterList(paramString.substring(j));
/*  70:    */     }
/*  71:    */     else
/*  72:    */     {
/*  73:110 */       throw new MimeTypeParseException("Unable to find a sub type.");
/*  74:    */     }
/*  75:116 */     if (!isValidToken(this.primaryType)) {
/*  76:117 */       throw new MimeTypeParseException("Primary type is invalid.");
/*  77:    */     }
/*  78:120 */     if (!isValidToken(this.subType)) {
/*  79:121 */       throw new MimeTypeParseException("Sub type is invalid.");
/*  80:    */     }
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getPrimaryType()
/*  84:    */   {
/*  85:130 */     return this.primaryType;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setPrimaryType(String paramString)
/*  89:    */     throws MimeTypeParseException
/*  90:    */   {
/*  91:140 */     if (!isValidToken(this.primaryType)) {
/*  92:141 */       throw new MimeTypeParseException("Primary type is invalid.");
/*  93:    */     }
/*  94:142 */     this.primaryType = paramString.toLowerCase();
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getSubType()
/*  98:    */   {
/*  99:151 */     return this.subType;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setSubType(String paramString)
/* 103:    */     throws MimeTypeParseException
/* 104:    */   {
/* 105:161 */     if (!isValidToken(this.subType)) {
/* 106:162 */       throw new MimeTypeParseException("Sub type is invalid.");
/* 107:    */     }
/* 108:163 */     this.subType = paramString.toLowerCase();
/* 109:    */   }
/* 110:    */   
/* 111:    */   public MimeTypeParameterList getParameters()
/* 112:    */   {
/* 113:172 */     return this.parameters;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getParameter(String paramString)
/* 117:    */   {
/* 118:183 */     return this.parameters.get(paramString);
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setParameter(String paramString1, String paramString2)
/* 122:    */   {
/* 123:194 */     this.parameters.set(paramString1, paramString2);
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void removeParameter(String paramString)
/* 127:    */   {
/* 128:203 */     this.parameters.remove(paramString);
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String toString()
/* 132:    */   {
/* 133:210 */     return getBaseType() + this.parameters.toString();
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getBaseType()
/* 137:    */   {
/* 138:220 */     return this.primaryType + "/" + this.subType;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public boolean match(MimeType paramMimeType)
/* 142:    */   {
/* 143:232 */     return (this.primaryType.equals(paramMimeType.getPrimaryType())) && ((this.subType.equals("*")) || 
/* 144:233 */       (paramMimeType.getSubType().equals("*")) || 
/* 145:234 */       (this.subType.equals(paramMimeType.getSubType())));
/* 146:    */   }
/* 147:    */   
/* 148:    */   public boolean match(String paramString)
/* 149:    */     throws MimeTypeParseException
/* 150:    */   {
/* 151:245 */     return match(new MimeType(paramString));
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void writeExternal(ObjectOutput paramObjectOutput)
/* 155:    */     throws IOException
/* 156:    */   {
/* 157:258 */     paramObjectOutput.writeUTF(toString());
/* 158:259 */     paramObjectOutput.flush();
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void readExternal(ObjectInput paramObjectInput)
/* 162:    */     throws IOException, ClassNotFoundException
/* 163:    */   {
/* 164:    */     try
/* 165:    */     {
/* 166:276 */       parse(paramObjectInput.readUTF());
/* 167:    */     }
/* 168:    */     catch (MimeTypeParseException localMimeTypeParseException)
/* 169:    */     {
/* 170:278 */       throw new IOException(localMimeTypeParseException.toString());
/* 171:    */     }
/* 172:    */   }
/* 173:    */   
/* 174:    */   private static boolean isTokenChar(char paramChar)
/* 175:    */   {
/* 176:288 */     return (paramChar > ' ') && (paramChar < '') && ("()<>@,;:/[]?=\\\"".indexOf(paramChar) < 0);
/* 177:    */   }
/* 178:    */   
/* 179:    */   private boolean isValidToken(String paramString)
/* 180:    */   {
/* 181:295 */     int i = paramString.length();
/* 182:296 */     if (i > 0)
/* 183:    */     {
/* 184:297 */       for (int j = 0; j < i; j++)
/* 185:    */       {
/* 186:298 */         char c = paramString.charAt(j);
/* 187:299 */         if (!isTokenChar(c)) {
/* 188:300 */           return false;
/* 189:    */         }
/* 190:    */       }
/* 191:303 */       return true;
/* 192:    */     }
/* 193:305 */     return false;
/* 194:    */   }
/* 195:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.MimeType
 * JD-Core Version:    0.7.0.1
 */
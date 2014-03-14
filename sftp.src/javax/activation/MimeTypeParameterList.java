/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.util.Enumeration;
/*   4:    */ import java.util.Hashtable;
/*   5:    */ 
/*   6:    */ public class MimeTypeParameterList
/*   7:    */ {
/*   8:    */   private Hashtable parameters;
/*   9:    */   private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
/*  10:    */   
/*  11:    */   public MimeTypeParameterList()
/*  12:    */   {
/*  13: 46 */     this.parameters = new Hashtable();
/*  14:    */   }
/*  15:    */   
/*  16:    */   public MimeTypeParameterList(String paramString)
/*  17:    */     throws MimeTypeParseException
/*  18:    */   {
/*  19: 56 */     this.parameters = new Hashtable();
/*  20:    */     
/*  21:    */ 
/*  22: 59 */     parse(paramString);
/*  23:    */   }
/*  24:    */   
/*  25:    */   protected void parse(String paramString)
/*  26:    */     throws MimeTypeParseException
/*  27:    */   {
/*  28: 68 */     if (paramString == null) {
/*  29: 69 */       return;
/*  30:    */     }
/*  31: 71 */     int i = paramString.length();
/*  32: 72 */     if (i <= 0) {
/*  33:    */       return;
/*  34:    */     }
/*  35:    */     char c;
/*  36: 77 */     for (int j = skipWhiteSpace(paramString, 0); (j < i) && ((c = paramString.charAt(j)) == ';'); j = skipWhiteSpace(paramString, j))
/*  37:    */     {
/*  38: 85 */       j++;
/*  39:    */       
/*  40:    */ 
/*  41:    */ 
/*  42:    */ 
/*  43: 90 */       j = skipWhiteSpace(paramString, j);
/*  44: 92 */       if (j >= i) {
/*  45: 93 */         throw new MimeTypeParseException(
/*  46: 94 */           "Couldn't find parameter name");
/*  47:    */       }
/*  48: 97 */       int k = j;
/*  49: 98 */       while ((j < i) && (isTokenChar(paramString.charAt(j)))) {
/*  50: 99 */         j++;
/*  51:    */       }
/*  52:101 */       String str1 = paramString.substring(k, j).toLowerCase();
/*  53:    */       
/*  54:    */ 
/*  55:104 */       j = skipWhiteSpace(paramString, j);
/*  56:106 */       if ((j >= i) || (paramString.charAt(j) != '=')) {
/*  57:107 */         throw new MimeTypeParseException(
/*  58:108 */           "Couldn't find the '=' that separates a parameter name from its value.");
/*  59:    */       }
/*  60:112 */       j++;
/*  61:113 */       j = skipWhiteSpace(paramString, j);
/*  62:115 */       if (j >= i) {
/*  63:116 */         throw new MimeTypeParseException(
/*  64:117 */           "Couldn't find a value for parameter named " + str1);
/*  65:    */       }
/*  66:120 */       c = paramString.charAt(j);
/*  67:    */       String str2;
/*  68:121 */       if (c == '"')
/*  69:    */       {
/*  70:123 */         j++;
/*  71:124 */         if (j >= i) {
/*  72:125 */           throw new MimeTypeParseException(
/*  73:126 */             "Encountered unterminated quoted parameter value.");
/*  74:    */         }
/*  75:128 */         k = j;
/*  76:131 */         while (j < i)
/*  77:    */         {
/*  78:132 */           c = paramString.charAt(j);
/*  79:133 */           if (c == '"') {
/*  80:    */             break;
/*  81:    */           }
/*  82:135 */           if (c == '\\') {
/*  83:139 */             j++;
/*  84:    */           }
/*  85:141 */           j++;
/*  86:    */         }
/*  87:143 */         if (c != '"') {
/*  88:144 */           throw new MimeTypeParseException(
/*  89:145 */             "Encountered unterminated quoted parameter value.");
/*  90:    */         }
/*  91:147 */         str2 = unquote(paramString.substring(k, j));
/*  92:    */         
/*  93:149 */         j++;
/*  94:    */       }
/*  95:150 */       else if (isTokenChar(c))
/*  96:    */       {
/*  97:153 */         k = j;
/*  98:154 */         while ((j < i) && (isTokenChar(paramString.charAt(j)))) {
/*  99:155 */           j++;
/* 100:    */         }
/* 101:156 */         str2 = paramString.substring(k, j);
/* 102:    */       }
/* 103:    */       else
/* 104:    */       {
/* 105:159 */         throw new MimeTypeParseException(
/* 106:160 */           "Unexpected character encountered at index " + j);
/* 107:    */       }
/* 108:164 */       this.parameters.put(str1, str2);
/* 109:    */     }
/* 110:166 */     if (j < i) {
/* 111:167 */       throw new MimeTypeParseException(
/* 112:168 */         "More characters encountered in input than expected.");
/* 113:    */     }
/* 114:    */   }
/* 115:    */   
/* 116:    */   public int size()
/* 117:    */   {
/* 118:178 */     return this.parameters.size();
/* 119:    */   }
/* 120:    */   
/* 121:    */   public boolean isEmpty()
/* 122:    */   {
/* 123:187 */     return this.parameters.isEmpty();
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String get(String paramString)
/* 127:    */   {
/* 128:198 */     return (String)this.parameters.get(paramString.trim().toLowerCase());
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void set(String paramString1, String paramString2)
/* 132:    */   {
/* 133:209 */     this.parameters.put(paramString1.trim().toLowerCase(), paramString2);
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void remove(String paramString)
/* 137:    */   {
/* 138:218 */     this.parameters.remove(paramString.trim().toLowerCase());
/* 139:    */   }
/* 140:    */   
/* 141:    */   public Enumeration getNames()
/* 142:    */   {
/* 143:227 */     return this.parameters.keys();
/* 144:    */   }
/* 145:    */   
/* 146:    */   public String toString()
/* 147:    */   {
/* 148:234 */     StringBuffer localStringBuffer = new StringBuffer();
/* 149:235 */     localStringBuffer.ensureCapacity(this.parameters.size() * 16);
/* 150:    */     
/* 151:    */ 
/* 152:238 */     Enumeration localEnumeration = this.parameters.keys();
/* 153:239 */     while (localEnumeration.hasMoreElements())
/* 154:    */     {
/* 155:240 */       String str = (String)localEnumeration.nextElement();
/* 156:241 */       localStringBuffer.append("; ");
/* 157:242 */       localStringBuffer.append(str);
/* 158:243 */       localStringBuffer.append('=');
/* 159:244 */       localStringBuffer.append(quote((String)this.parameters.get(str)));
/* 160:    */     }
/* 161:247 */     return localStringBuffer.toString();
/* 162:    */   }
/* 163:    */   
/* 164:    */   private static boolean isTokenChar(char paramChar)
/* 165:    */   {
/* 166:256 */     return (paramChar > ' ') && (paramChar < '') && ("()<>@,;:/[]?=\\\"".indexOf(paramChar) < 0);
/* 167:    */   }
/* 168:    */   
/* 169:    */   private static int skipWhiteSpace(String paramString, int paramInt)
/* 170:    */   {
/* 171:264 */     int i = paramString.length();
/* 172:265 */     while ((paramInt < i) && (Character.isWhitespace(paramString.charAt(paramInt)))) {
/* 173:266 */       paramInt++;
/* 174:    */     }
/* 175:267 */     return paramInt;
/* 176:    */   }
/* 177:    */   
/* 178:    */   private static String quote(String paramString)
/* 179:    */   {
/* 180:274 */     int i = 0;
/* 181:    */     
/* 182:    */ 
/* 183:277 */     int j = paramString.length();
/* 184:278 */     for (int k = 0; (k < j) && (i == 0); k++) {
/* 185:279 */       i = isTokenChar(paramString.charAt(k)) ? 0 : 1;
/* 186:    */     }
/* 187:282 */     if (i != 0)
/* 188:    */     {
/* 189:283 */       StringBuffer localStringBuffer = new StringBuffer();
/* 190:284 */       localStringBuffer.ensureCapacity((int)(j * 1.5D));
/* 191:    */       
/* 192:    */ 
/* 193:287 */       localStringBuffer.append('"');
/* 194:290 */       for (int m = 0; m < j; m++)
/* 195:    */       {
/* 196:291 */         char c = paramString.charAt(m);
/* 197:292 */         if ((c == '\\') || (c == '"')) {
/* 198:293 */           localStringBuffer.append('\\');
/* 199:    */         }
/* 200:294 */         localStringBuffer.append(c);
/* 201:    */       }
/* 202:298 */       localStringBuffer.append('"');
/* 203:    */       
/* 204:300 */       return localStringBuffer.toString();
/* 205:    */     }
/* 206:302 */     return paramString;
/* 207:    */   }
/* 208:    */   
/* 209:    */   private static String unquote(String paramString)
/* 210:    */   {
/* 211:311 */     int i = paramString.length();
/* 212:312 */     StringBuffer localStringBuffer = new StringBuffer();
/* 213:313 */     localStringBuffer.ensureCapacity(i);
/* 214:    */     
/* 215:315 */     int j = 0;
/* 216:316 */     for (int k = 0; k < i; k++)
/* 217:    */     {
/* 218:317 */       char c = paramString.charAt(k);
/* 219:318 */       if ((j == 0) && (c != '\\'))
/* 220:    */       {
/* 221:319 */         localStringBuffer.append(c);
/* 222:    */       }
/* 223:320 */       else if (j != 0)
/* 224:    */       {
/* 225:321 */         localStringBuffer.append(c);
/* 226:322 */         j = 0;
/* 227:    */       }
/* 228:    */       else
/* 229:    */       {
/* 230:324 */         j = 1;
/* 231:    */       }
/* 232:    */     }
/* 233:328 */     return localStringBuffer.toString();
/* 234:    */   }
/* 235:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.MimeTypeParameterList
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package com.sun.activation.registries;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ 
/*   5:    */ public class MailcapTokenizer
/*   6:    */ {
/*   7:    */   public static final int UNKNOWN_TOKEN = 0;
/*   8:    */   public static final int START_TOKEN = 1;
/*   9:    */   public static final int STRING_TOKEN = 2;
/*  10:    */   public static final int EOI_TOKEN = 5;
/*  11:    */   public static final int SLASH_TOKEN = 47;
/*  12:    */   public static final int SEMICOLON_TOKEN = 59;
/*  13:    */   public static final int EQUALS_TOKEN = 61;
/*  14:    */   private String data;
/*  15:    */   private int dataIndex;
/*  16:    */   private int dataLength;
/*  17:    */   private int currentToken;
/*  18:    */   private String currentTokenValue;
/*  19:    */   private boolean isAutoquoting;
/*  20:    */   private char autoquoteChar;
/*  21:    */   
/*  22:    */   public MailcapTokenizer(String paramString)
/*  23:    */   {
/*  24: 25 */     this.data = paramString;
/*  25: 26 */     this.dataIndex = 0;
/*  26: 27 */     this.dataLength = paramString.length();
/*  27:    */     
/*  28: 29 */     this.currentToken = 1;
/*  29: 30 */     this.currentTokenValue = "";
/*  30:    */     
/*  31: 32 */     this.isAutoquoting = false;
/*  32: 33 */     this.autoquoteChar = ';';
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setIsAutoquoting(boolean paramBoolean)
/*  36:    */   {
/*  37: 47 */     this.isAutoquoting = paramBoolean;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setAutoquoteChar(char paramChar)
/*  41:    */   {
/*  42: 55 */     this.autoquoteChar = paramChar;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public int getCurrentToken()
/*  46:    */   {
/*  47: 65 */     return this.currentToken;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public static String nameForToken(int paramInt)
/*  51:    */   {
/*  52: 73 */     String str = "really unknown";
/*  53: 75 */     switch (paramInt)
/*  54:    */     {
/*  55:    */     case 0: 
/*  56: 78 */       str = "unknown";
/*  57: 79 */       break;
/*  58:    */     case 1: 
/*  59: 81 */       str = "start";
/*  60: 82 */       break;
/*  61:    */     case 2: 
/*  62: 84 */       str = "string";
/*  63: 85 */       break;
/*  64:    */     case 5: 
/*  65: 87 */       str = "EOI";
/*  66: 88 */       break;
/*  67:    */     case 47: 
/*  68: 90 */       str = "'/'";
/*  69: 91 */       break;
/*  70:    */     case 59: 
/*  71: 93 */       str = "';'";
/*  72: 94 */       break;
/*  73:    */     case 61: 
/*  74: 96 */       str = "'='";
/*  75: 97 */       break;
/*  76:    */     }
/*  77:100 */     return str;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getCurrentTokenValue()
/*  81:    */   {
/*  82:110 */     return this.currentTokenValue;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public int nextToken()
/*  86:    */   {
/*  87:120 */     if (this.dataIndex < this.dataLength)
/*  88:    */     {
/*  89:123 */       while ((this.dataIndex < this.dataLength) && (isWhiteSpaceChar(this.data.charAt(this.dataIndex)))) {
/*  90:125 */         this.dataIndex += 1;
/*  91:    */       }
/*  92:128 */       if (this.dataIndex < this.dataLength)
/*  93:    */       {
/*  94:131 */         char c = this.data.charAt(this.dataIndex);
/*  95:132 */         if (this.isAutoquoting)
/*  96:    */         {
/*  97:134 */           if (!isAutoquoteSpecialChar(c))
/*  98:    */           {
/*  99:136 */             processAutoquoteToken();
/* 100:    */           }
/* 101:138 */           else if ((c == ';') || (c == '='))
/* 102:    */           {
/* 103:140 */             this.currentToken = c;
/* 104:141 */             this.currentTokenValue = new Character(c).toString();
/* 105:142 */             this.dataIndex += 1;
/* 106:    */           }
/* 107:    */           else
/* 108:    */           {
/* 109:146 */             this.currentToken = 0;
/* 110:147 */             this.currentTokenValue = new Character(c).toString();
/* 111:148 */             this.dataIndex += 1;
/* 112:    */           }
/* 113:    */         }
/* 114:153 */         else if (isStringTokenChar(c))
/* 115:    */         {
/* 116:155 */           processStringToken();
/* 117:    */         }
/* 118:157 */         else if ((c == '/') || (c == ';') || (c == '='))
/* 119:    */         {
/* 120:159 */           this.currentToken = c;
/* 121:160 */           this.currentTokenValue = new Character(c).toString();
/* 122:161 */           this.dataIndex += 1;
/* 123:    */         }
/* 124:    */         else
/* 125:    */         {
/* 126:165 */           this.currentToken = 0;
/* 127:166 */           this.currentTokenValue = new Character(c).toString();
/* 128:167 */           this.dataIndex += 1;
/* 129:    */         }
/* 130:    */       }
/* 131:    */       else
/* 132:    */       {
/* 133:173 */         this.currentToken = 5;
/* 134:174 */         this.currentTokenValue = null;
/* 135:    */       }
/* 136:    */     }
/* 137:    */     else
/* 138:    */     {
/* 139:179 */       this.currentToken = 5;
/* 140:180 */       this.currentTokenValue = null;
/* 141:    */     }
/* 142:183 */     return this.currentToken;
/* 143:    */   }
/* 144:    */   
/* 145:    */   private void processStringToken()
/* 146:    */   {
/* 147:189 */     int i = this.dataIndex;
/* 148:192 */     while ((this.dataIndex < this.dataLength) && (isStringTokenChar(this.data.charAt(this.dataIndex)))) {
/* 149:194 */       this.dataIndex += 1;
/* 150:    */     }
/* 151:197 */     this.currentToken = 2;
/* 152:198 */     this.currentTokenValue = this.data.substring(i, this.dataIndex);
/* 153:    */   }
/* 154:    */   
/* 155:    */   private void processAutoquoteToken()
/* 156:    */   {
/* 157:204 */     int i = this.dataIndex;
/* 158:    */     
/* 159:    */ 
/* 160:207 */     int j = 0;
/* 161:208 */     while ((this.dataIndex < this.dataLength) && (j == 0))
/* 162:    */     {
/* 163:210 */       int k = this.data.charAt(this.dataIndex);
/* 164:211 */       if (k != this.autoquoteChar) {
/* 165:213 */         this.dataIndex += 1;
/* 166:    */       } else {
/* 167:217 */         j = 1;
/* 168:    */       }
/* 169:    */     }
/* 170:221 */     this.currentToken = 2;
/* 171:222 */     this.currentTokenValue = fixEscapeSequences(this.data.substring(i, this.dataIndex));
/* 172:    */   }
/* 173:    */   
/* 174:    */   public static boolean isSpecialChar(char paramChar)
/* 175:    */   {
/* 176:227 */     boolean bool = false;
/* 177:229 */     switch (paramChar)
/* 178:    */     {
/* 179:    */     case '"': 
/* 180:    */     case '(': 
/* 181:    */     case ')': 
/* 182:    */     case ',': 
/* 183:    */     case '/': 
/* 184:    */     case ':': 
/* 185:    */     case ';': 
/* 186:    */     case '<': 
/* 187:    */     case '=': 
/* 188:    */     case '>': 
/* 189:    */     case '?': 
/* 190:    */     case '@': 
/* 191:    */     case '[': 
/* 192:    */     case '\\': 
/* 193:    */     case ']': 
/* 194:246 */       bool = true;
/* 195:247 */       break;
/* 196:    */     }
/* 197:250 */     return bool;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public static boolean isAutoquoteSpecialChar(char paramChar)
/* 201:    */   {
/* 202:255 */     boolean bool = false;
/* 203:257 */     switch (paramChar)
/* 204:    */     {
/* 205:    */     case ';': 
/* 206:    */     case '=': 
/* 207:261 */       bool = true;
/* 208:262 */       break;
/* 209:    */     }
/* 210:265 */     return bool;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public static boolean isControlChar(char paramChar)
/* 214:    */   {
/* 215:270 */     return Character.isISOControl(paramChar);
/* 216:    */   }
/* 217:    */   
/* 218:    */   public static boolean isWhiteSpaceChar(char paramChar)
/* 219:    */   {
/* 220:275 */     return Character.isWhitespace(paramChar);
/* 221:    */   }
/* 222:    */   
/* 223:    */   public static boolean isStringTokenChar(char paramChar)
/* 224:    */   {
/* 225:280 */     return (!isSpecialChar(paramChar)) && (!isControlChar(paramChar)) && (!isWhiteSpaceChar(paramChar));
/* 226:    */   }
/* 227:    */   
/* 228:    */   private static String fixEscapeSequences(String paramString)
/* 229:    */   {
/* 230:285 */     int i = paramString.length();
/* 231:286 */     StringBuffer localStringBuffer = new StringBuffer();
/* 232:287 */     localStringBuffer.ensureCapacity(i);
/* 233:289 */     for (int j = 0; j < i; j++)
/* 234:    */     {
/* 235:291 */       char c1 = paramString.charAt(j);
/* 236:292 */       if (c1 != '\\')
/* 237:    */       {
/* 238:294 */         localStringBuffer.append(c1);
/* 239:    */       }
/* 240:298 */       else if (j < i - 1)
/* 241:    */       {
/* 242:300 */         char c2 = paramString.charAt(j + 1);
/* 243:301 */         localStringBuffer.append(c2);
/* 244:    */         
/* 245:    */ 
/* 246:304 */         j++;
/* 247:    */       }
/* 248:    */       else
/* 249:    */       {
/* 250:308 */         localStringBuffer.append(c1);
/* 251:    */       }
/* 252:    */     }
/* 253:313 */     return localStringBuffer.toString();
/* 254:    */   }
/* 255:    */   
/* 256:    */   public static void main(String[] paramArrayOfString)
/* 257:    */   {
/* 258:326 */     for (int i = 0; i < paramArrayOfString.length; i++)
/* 259:    */     {
/* 260:328 */       MailcapTokenizer localMailcapTokenizer = new MailcapTokenizer(paramArrayOfString[i]);
/* 261:    */       
/* 262:330 */       System.out.println("Original: |" + paramArrayOfString[i] + "|");
/* 263:    */       
/* 264:332 */       int j = localMailcapTokenizer.nextToken();
/* 265:333 */       while (j != 5)
/* 266:    */       {
/* 267:335 */         switch (j)
/* 268:    */         {
/* 269:    */         case 0: 
/* 270:338 */           System.out.println("  Unknown Token:           |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 271:339 */           break;
/* 272:    */         case 1: 
/* 273:341 */           System.out.println("  Start Token:             |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 274:342 */           break;
/* 275:    */         case 2: 
/* 276:344 */           System.out.println("  String Token:            |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 277:345 */           break;
/* 278:    */         case 5: 
/* 279:347 */           System.out.println("  EOI Token:               |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 280:348 */           break;
/* 281:    */         case 47: 
/* 282:350 */           System.out.println("  Slash Token:             |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 283:351 */           break;
/* 284:    */         case 59: 
/* 285:353 */           System.out.println("  Semicolon Token:         |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 286:354 */           break;
/* 287:    */         case 61: 
/* 288:356 */           System.out.println("  Equals Token:            |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 289:357 */           break;
/* 290:    */         default: 
/* 291:359 */           System.out.println("  Really Unknown Token:    |" + localMailcapTokenizer.getCurrentTokenValue() + "|");
/* 292:    */         }
/* 293:363 */         j = localMailcapTokenizer.nextToken();
/* 294:    */       }
/* 295:366 */       System.out.println("");
/* 296:    */     }
/* 297:    */   }
/* 298:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.registries.MailcapTokenizer
 * JD-Core Version:    0.7.0.1
 */
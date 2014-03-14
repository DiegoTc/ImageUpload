/*   1:    */ package com.sun.activation.registries;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.FileReader;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.InputStream;
/*   7:    */ import java.io.InputStreamReader;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.io.Reader;
/*  10:    */ import java.io.StringReader;
/*  11:    */ import java.util.Enumeration;
/*  12:    */ import java.util.Hashtable;
/*  13:    */ import java.util.Vector;
/*  14:    */ 
/*  15:    */ public class MailcapFile
/*  16:    */ {
/*  17:    */   private Hashtable type_hash;
/*  18:    */   private static boolean debug;
/*  19:    */   
/*  20:    */   static
/*  21:    */   {
/*  22:    */     try
/*  23:    */     {
/*  24: 34 */       debug = Boolean.getBoolean("javax.activation.debug");
/*  25:    */     }
/*  26:    */     catch (Throwable localThrowable) {}
/*  27:    */   }
/*  28:    */   
/*  29:    */   public MailcapFile(String paramString)
/*  30:    */     throws IOException
/*  31:    */   {
/*  32: 46 */     if (debug) {
/*  33: 47 */       System.out.println("new MailcapFile: file " + paramString);
/*  34:    */     }
/*  35: 48 */     FileReader localFileReader = null;
/*  36: 49 */     localFileReader = new FileReader(paramString);
/*  37: 50 */     this.type_hash = createMailcapHash(localFileReader);
/*  38:    */   }
/*  39:    */   
/*  40:    */   public MailcapFile(InputStream paramInputStream)
/*  41:    */     throws IOException
/*  42:    */   {
/*  43: 59 */     if (debug) {
/*  44: 60 */       System.out.println("new MailcapFile: InputStream");
/*  45:    */     }
/*  46: 61 */     this.type_hash = createMailcapHash(new InputStreamReader(paramInputStream, "iso-8859-1"));
/*  47:    */   }
/*  48:    */   
/*  49:    */   public MailcapFile()
/*  50:    */   {
/*  51: 68 */     if (debug) {
/*  52: 69 */       System.out.println("new MailcapFile: default");
/*  53:    */     }
/*  54: 71 */     this.type_hash = new Hashtable();
/*  55:    */   }
/*  56:    */   
/*  57:    */   public MailcapEntry getMailcapEntry(String paramString)
/*  58:    */   {
/*  59: 85 */     MailcapEntry localMailcapEntry = null;
/*  60:    */     
/*  61:    */ 
/*  62: 88 */     return localMailcapEntry;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public Hashtable getMailcapList(String paramString)
/*  66:    */   {
/*  67:100 */     Object localObject = null;
/*  68:101 */     Hashtable localHashtable = null;
/*  69:    */     
/*  70:    */ 
/*  71:104 */     localObject = (Hashtable)this.type_hash.get(paramString);
/*  72:    */     
/*  73:    */ 
/*  74:107 */     int i = paramString.indexOf('/');
/*  75:108 */     String str = paramString.substring(0, i + 1) + "*";
/*  76:109 */     localHashtable = (Hashtable)this.type_hash.get(str);
/*  77:111 */     if (localHashtable != null) {
/*  78:112 */       if (localObject != null) {
/*  79:113 */         localObject = mergeResults((Hashtable)localObject, localHashtable);
/*  80:    */       } else {
/*  81:115 */         localObject = localHashtable;
/*  82:    */       }
/*  83:    */     }
/*  84:117 */     return localObject;
/*  85:    */   }
/*  86:    */   
/*  87:    */   private Hashtable mergeResults(Hashtable paramHashtable1, Hashtable paramHashtable2)
/*  88:    */   {
/*  89:127 */     Enumeration localEnumeration1 = paramHashtable2.keys();
/*  90:128 */     Hashtable localHashtable = (Hashtable)paramHashtable1.clone();
/*  91:131 */     while (localEnumeration1.hasMoreElements())
/*  92:    */     {
/*  93:132 */       String str = (String)localEnumeration1.nextElement();
/*  94:133 */       Vector localVector1 = (Vector)localHashtable.get(str);
/*  95:134 */       if (localVector1 == null)
/*  96:    */       {
/*  97:135 */         localHashtable.put(str, paramHashtable2.get(str));
/*  98:    */       }
/*  99:    */       else
/* 100:    */       {
/* 101:138 */         Vector localVector2 = (Vector)paramHashtable2.get(str);
/* 102:139 */         Enumeration localEnumeration2 = localVector2.elements();
/* 103:140 */         localVector1 = (Vector)localVector1.clone();
/* 104:141 */         localHashtable.put(str, localVector1);
/* 105:142 */         while (localEnumeration2.hasMoreElements()) {
/* 106:143 */           localVector1.addElement(localEnumeration2.nextElement());
/* 107:    */         }
/* 108:    */       }
/* 109:    */     }
/* 110:147 */     return localHashtable;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void appendToMailcap(String paramString)
/* 114:    */   {
/* 115:161 */     if (debug) {
/* 116:162 */       System.out.println("appendToMailcap: " + paramString);
/* 117:    */     }
/* 118:    */     try
/* 119:    */     {
/* 120:164 */       parse(new StringReader(paramString), this.type_hash);
/* 121:    */     }
/* 122:    */     catch (IOException localIOException) {}
/* 123:    */   }
/* 124:    */   
/* 125:    */   private Hashtable createMailcapHash(Reader paramReader)
/* 126:    */     throws IOException
/* 127:    */   {
/* 128:174 */     Hashtable localHashtable = new Hashtable();
/* 129:    */     
/* 130:176 */     parse(paramReader, localHashtable);
/* 131:    */     
/* 132:178 */     return localHashtable;
/* 133:    */   }
/* 134:    */   
/* 135:    */   private void parse(Reader paramReader, Hashtable paramHashtable)
/* 136:    */     throws IOException
/* 137:    */   {
/* 138:185 */     BufferedReader localBufferedReader = new BufferedReader(paramReader);
/* 139:186 */     String str = null;
/* 140:187 */     Object localObject = null;
/* 141:189 */     while ((str = localBufferedReader.readLine()) != null)
/* 142:    */     {
/* 143:192 */       str = str.trim();
/* 144:    */       try
/* 145:    */       {
/* 146:195 */         if (str.charAt(0) != '#') {
/* 147:197 */           if (str.charAt(str.length() - 1) == '\\')
/* 148:    */           {
/* 149:198 */             if (localObject != null) {
/* 150:199 */               localObject = localObject + str.substring(0, str.length() - 1);
/* 151:    */             } else {
/* 152:201 */               localObject = str.substring(0, str.length() - 1);
/* 153:    */             }
/* 154:    */           }
/* 155:202 */           else if (localObject != null)
/* 156:    */           {
/* 157:204 */             localObject = localObject + str;
/* 158:    */             try
/* 159:    */             {
/* 160:207 */               parseLine((String)localObject, paramHashtable);
/* 161:    */             }
/* 162:    */             catch (MailcapParseException localMailcapParseException1) {}
/* 163:211 */             localObject = null;
/* 164:    */           }
/* 165:    */           else
/* 166:    */           {
/* 167:    */             try
/* 168:    */             {
/* 169:216 */               parseLine(str, paramHashtable);
/* 170:    */             }
/* 171:    */             catch (MailcapParseException localMailcapParseException2) {}
/* 172:    */           }
/* 173:    */         }
/* 174:    */       }
/* 175:    */       catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException) {}
/* 176:    */     }
/* 177:    */   }
/* 178:    */   
/* 179:    */   protected static void parseLine(String paramString, Hashtable paramHashtable)
/* 180:    */     throws MailcapParseException, IOException
/* 181:    */   {
/* 182:234 */     MailcapTokenizer localMailcapTokenizer = new MailcapTokenizer(paramString);
/* 183:235 */     localMailcapTokenizer.setIsAutoquoting(false);
/* 184:236 */     String str1 = "";
/* 185:237 */     String str2 = "*";
/* 186:238 */     String str3 = "";
/* 187:240 */     if (debug) {
/* 188:241 */       System.out.println("parse: " + paramString);
/* 189:    */     }
/* 190:243 */     int i = localMailcapTokenizer.nextToken();
/* 191:244 */     str3 = str3.concat(localMailcapTokenizer.getCurrentTokenValue());
/* 192:245 */     if (i != 2) {
/* 193:246 */       reportParseError(2, i, 
/* 194:247 */         localMailcapTokenizer.getCurrentTokenValue());
/* 195:    */     }
/* 196:249 */     str1 = localMailcapTokenizer.getCurrentTokenValue().toLowerCase();
/* 197:    */     
/* 198:    */ 
/* 199:    */ 
/* 200:253 */     i = localMailcapTokenizer.nextToken();
/* 201:254 */     str3 = str3.concat(localMailcapTokenizer.getCurrentTokenValue());
/* 202:255 */     if ((i != 47) && 
/* 203:256 */       (i != 59)) {
/* 204:257 */       reportParseError(47, 
/* 205:258 */         59, i, 
/* 206:259 */         localMailcapTokenizer.getCurrentTokenValue());
/* 207:    */     }
/* 208:263 */     if (i == 47)
/* 209:    */     {
/* 210:265 */       i = localMailcapTokenizer.nextToken();
/* 211:266 */       str3 = str3.concat(localMailcapTokenizer.getCurrentTokenValue());
/* 212:267 */       if (i != 2) {
/* 213:268 */         reportParseError(2, 
/* 214:269 */           i, localMailcapTokenizer.getCurrentTokenValue());
/* 215:    */       }
/* 216:271 */       str2 = localMailcapTokenizer.getCurrentTokenValue().toLowerCase();
/* 217:    */       
/* 218:    */ 
/* 219:274 */       i = localMailcapTokenizer.nextToken();
/* 220:275 */       str3 = str3.concat(localMailcapTokenizer.getCurrentTokenValue());
/* 221:    */     }
/* 222:278 */     if (debug) {
/* 223:279 */       System.out.println("  Type: " + str1 + "/" + str2);
/* 224:    */     }
/* 225:281 */     Hashtable localHashtable = 
/* 226:282 */       (Hashtable)paramHashtable.get(str1 + "/" + str2);
/* 227:283 */     if (localHashtable == null)
/* 228:    */     {
/* 229:284 */       localHashtable = new Hashtable();
/* 230:285 */       paramHashtable.put(str1 + "/" + str2, localHashtable);
/* 231:    */     }
/* 232:289 */     if (i != 59) {
/* 233:290 */       reportParseError(59, 
/* 234:291 */         i, localMailcapTokenizer.getCurrentTokenValue());
/* 235:    */     }
/* 236:296 */     localMailcapTokenizer.setIsAutoquoting(true);
/* 237:297 */     i = localMailcapTokenizer.nextToken();
/* 238:298 */     localMailcapTokenizer.setIsAutoquoting(false);
/* 239:299 */     str3 = str3.concat(localMailcapTokenizer.getCurrentTokenValue());
/* 240:300 */     if ((i != 2) && 
/* 241:301 */       (i != 59)) {
/* 242:303 */       reportParseError(2, 
/* 243:304 */         59, i, 
/* 244:305 */         localMailcapTokenizer.getCurrentTokenValue());
/* 245:    */     }
/* 246:310 */     if (i != 59) {
/* 247:311 */       i = localMailcapTokenizer.nextToken();
/* 248:    */     }
/* 249:316 */     if (i == 59)
/* 250:    */     {
/* 251:    */       do
/* 252:    */       {
/* 253:321 */         i = localMailcapTokenizer.nextToken();
/* 254:322 */         if (i != 2) {
/* 255:323 */           reportParseError(2, 
/* 256:324 */             i, localMailcapTokenizer.getCurrentTokenValue());
/* 257:    */         }
/* 258:326 */         String str4 = 
/* 259:327 */           localMailcapTokenizer.getCurrentTokenValue().toLowerCase();
/* 260:    */         
/* 261:    */ 
/* 262:330 */         i = localMailcapTokenizer.nextToken();
/* 263:331 */         if ((i != 61) && 
/* 264:332 */           (i != 59) && 
/* 265:333 */           (i != 5)) {
/* 266:334 */           reportParseError(61, 
/* 267:335 */             59, 
/* 268:336 */             5, 
/* 269:337 */             i, localMailcapTokenizer.getCurrentTokenValue());
/* 270:    */         }
/* 271:341 */         if (i == 61)
/* 272:    */         {
/* 273:345 */           localMailcapTokenizer.setIsAutoquoting(true);
/* 274:346 */           i = localMailcapTokenizer.nextToken();
/* 275:347 */           localMailcapTokenizer.setIsAutoquoting(false);
/* 276:348 */           if (i != 2) {
/* 277:349 */             reportParseError(2, 
/* 278:350 */               i, localMailcapTokenizer.getCurrentTokenValue());
/* 279:    */           }
/* 280:352 */           String str5 = 
/* 281:353 */             localMailcapTokenizer.getCurrentTokenValue();
/* 282:356 */           if (str4.startsWith("x-java-"))
/* 283:    */           {
/* 284:357 */             String str6 = str4.substring(7);
/* 285:361 */             if (debug) {
/* 286:362 */               System.out.println("    Command: " + str6 + 
/* 287:363 */                 ", Class: " + str5);
/* 288:    */             }
/* 289:364 */             Vector localVector = 
/* 290:365 */               (Vector)localHashtable.get(str6);
/* 291:366 */             if (localVector == null)
/* 292:    */             {
/* 293:367 */               localVector = new Vector();
/* 294:368 */               localHashtable.put(str6, localVector);
/* 295:    */             }
/* 296:371 */             localVector.insertElementAt(str5, 0);
/* 297:    */           }
/* 298:375 */           i = localMailcapTokenizer.nextToken();
/* 299:    */         }
/* 300:377 */       } while (i == 59);
/* 301:316 */       return;
/* 302:    */     }
/* 303:378 */     if (i != 5) {
/* 304:379 */       reportParseError(5, 
/* 305:380 */         59, 
/* 306:381 */         i, localMailcapTokenizer.getCurrentTokenValue());
/* 307:    */     }
/* 308:    */   }
/* 309:    */   
/* 310:    */   protected static void reportParseError(int paramInt1, int paramInt2, String paramString)
/* 311:    */     throws MailcapParseException
/* 312:    */   {
/* 313:387 */     throw new MailcapParseException("Encountered a " + 
/* 314:388 */       MailcapTokenizer.nameForToken(paramInt2) + " token (" + 
/* 315:389 */       paramString + ") while expecting a " + 
/* 316:390 */       MailcapTokenizer.nameForToken(paramInt1) + " token.");
/* 317:    */   }
/* 318:    */   
/* 319:    */   protected static void reportParseError(int paramInt1, int paramInt2, int paramInt3, String paramString)
/* 320:    */     throws MailcapParseException
/* 321:    */   {
/* 322:396 */     throw new MailcapParseException("Encountered a " + 
/* 323:397 */       MailcapTokenizer.nameForToken(paramInt3) + " token (" + 
/* 324:398 */       paramString + ") while expecting a " + 
/* 325:399 */       MailcapTokenizer.nameForToken(paramInt1) + " or a " + 
/* 326:400 */       MailcapTokenizer.nameForToken(paramInt2) + " token.");
/* 327:    */   }
/* 328:    */   
/* 329:    */   protected static void reportParseError(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
/* 330:    */     throws MailcapParseException
/* 331:    */   {
/* 332:406 */     if (debug) {
/* 333:407 */       System.out.println("PARSE ERROR: Encountered a " + 
/* 334:408 */         MailcapTokenizer.nameForToken(paramInt4) + " token (" + 
/* 335:409 */         paramString + ") while expecting a " + 
/* 336:410 */         MailcapTokenizer.nameForToken(paramInt1) + ", a " + 
/* 337:411 */         MailcapTokenizer.nameForToken(paramInt2) + ", or a " + 
/* 338:412 */         MailcapTokenizer.nameForToken(paramInt3) + " token.");
/* 339:    */     }
/* 340:413 */     throw new MailcapParseException("Encountered a " + 
/* 341:414 */       MailcapTokenizer.nameForToken(paramInt4) + " token (" + 
/* 342:415 */       paramString + ") while expecting a " + 
/* 343:416 */       MailcapTokenizer.nameForToken(paramInt1) + ", a " + 
/* 344:417 */       MailcapTokenizer.nameForToken(paramInt2) + ", or a " + 
/* 345:418 */       MailcapTokenizer.nameForToken(paramInt3) + " token.");
/* 346:    */   }
/* 347:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.registries.MailcapFile
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import com.sun.activation.registries.MailcapFile;
/*   4:    */ import java.io.File;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.InputStream;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.util.Enumeration;
/*   9:    */ import java.util.Hashtable;
/*  10:    */ import java.util.Vector;
/*  11:    */ 
/*  12:    */ public class MailcapCommandMap
/*  13:    */   extends CommandMap
/*  14:    */ {
/*  15:108 */   private static MailcapFile defDB = null;
/*  16:109 */   private MailcapFile[] DB = new MailcapFile[5];
/*  17:    */   private static final int PROG = 0;
/*  18:    */   private static final int HOME = 1;
/*  19:    */   private static final int SYS = 2;
/*  20:    */   private static final int JAR = 3;
/*  21:    */   private static final int DEF = 4;
/*  22:    */   private static boolean debug;
/*  23:    */   static Class class$javax$activation$MailcapCommandMap;
/*  24:    */   
/*  25:    */   static
/*  26:    */   {
/*  27:    */     try
/*  28:    */     {
/*  29:120 */       debug = Boolean.getBoolean("javax.activation.debug");
/*  30:    */     }
/*  31:    */     catch (Throwable localThrowable) {}
/*  32:    */   }
/*  33:    */   
/*  34:    */   public MailcapCommandMap()
/*  35:    */   {
/*  36:132 */     if (debug) {
/*  37:133 */       System.out.println("MailcapCommandMap: load HOME");
/*  38:    */     }
/*  39:    */     try
/*  40:    */     {
/*  41:135 */       ??? = System.getProperty("user.home");
/*  42:137 */       if (??? != null)
/*  43:    */       {
/*  44:138 */         String str = ??? + File.separator + ".mailcap";
/*  45:139 */         this.DB[1] = loadFile(str);
/*  46:    */       }
/*  47:    */     }
/*  48:    */     catch (SecurityException localSecurityException1) {}
/*  49:143 */     if (debug) {
/*  50:144 */       System.out.println("MailcapCommandMap: load SYS");
/*  51:    */     }
/*  52:    */     try
/*  53:    */     {
/*  54:147 */       ??? = 
/*  55:148 */         System.getProperty("java.home") + File.separator + "lib" + File.separator + "mailcap";
/*  56:149 */       this.DB[2] = loadFile((String)???);
/*  57:    */     }
/*  58:    */     catch (SecurityException localSecurityException2) {}
/*  59:152 */     if (debug) {
/*  60:153 */       System.out.println("MailcapCommandMap: load JAR");
/*  61:    */     }
/*  62:155 */     this.DB[3] = loadResource("/META-INF/mailcap");
/*  63:157 */     if (debug) {
/*  64:158 */       System.out.println("MailcapCommandMap: load DEF");
/*  65:    */     }
/*  66:159 */     synchronized (MailcapCommandMap.class$javax$activation$MailcapCommandMap = CommandMap.class$("javax.activation.MailcapCommandMap"))
/*  67:    */     {
/*  68:161 */       if (defDB == null) {
/*  69:162 */         defDB = loadResource("/META-INF/mailcap.default");
/*  70:    */       }
/*  71:    */     }
/*  72:165 */     this.DB[4] = defDB;
/*  73:    */   }
/*  74:    */   
/*  75:    */   private MailcapFile loadResource(String paramString)
/*  76:    */   {
/*  77:    */     try
/*  78:    */     {
/*  79:173 */       InputStream localInputStream = getClass().getResourceAsStream(paramString);
/*  80:174 */       if (localInputStream != null) {
/*  81:175 */         return new MailcapFile(localInputStream);
/*  82:    */       }
/*  83:    */     }
/*  84:    */     catch (IOException localIOException) {}
/*  85:179 */     return null;
/*  86:    */   }
/*  87:    */   
/*  88:    */   private MailcapFile loadFile(String paramString)
/*  89:    */   {
/*  90:186 */     MailcapFile localMailcapFile = null;
/*  91:    */     try
/*  92:    */     {
/*  93:189 */       localMailcapFile = new MailcapFile(paramString);
/*  94:    */     }
/*  95:    */     catch (IOException localIOException) {}
/*  96:193 */     return localMailcapFile;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public MailcapCommandMap(String paramString)
/* 100:    */     throws IOException
/* 101:    */   {
/* 102:203 */     this();
/* 103:205 */     if (debug) {
/* 104:206 */       System.out.println("MailcapCommandMap: load PROG from " + paramString);
/* 105:    */     }
/* 106:207 */     if (this.DB[0] == null) {
/* 107:208 */       this.DB[0] = new MailcapFile(paramString);
/* 108:    */     }
/* 109:    */   }
/* 110:    */   
/* 111:    */   public MailcapCommandMap(InputStream paramInputStream)
/* 112:    */   {
/* 113:220 */     this();
/* 114:222 */     if (debug) {
/* 115:223 */       System.out.println("MailcapCommandMap: load PROG");
/* 116:    */     }
/* 117:224 */     if (this.DB[0] == null) {
/* 118:    */       try
/* 119:    */       {
/* 120:226 */         this.DB[0] = new MailcapFile(paramInputStream);
/* 121:    */       }
/* 122:    */       catch (IOException localIOException) {}
/* 123:    */     }
/* 124:    */   }
/* 125:    */   
/* 126:    */   public synchronized CommandInfo[] getPreferredCommands(String paramString)
/* 127:    */   {
/* 128:247 */     Vector localVector = new Vector();
/* 129:249 */     for (int i = 0; i < this.DB.length; i++) {
/* 130:250 */       if (this.DB[i] != null)
/* 131:    */       {
/* 132:252 */         localObject = this.DB[i].getMailcapList(paramString);
/* 133:253 */         if (localObject != null) {
/* 134:254 */           appendPrefCmdsToVector((Hashtable)localObject, localVector);
/* 135:    */         }
/* 136:    */       }
/* 137:    */     }
/* 138:257 */     Object localObject = new CommandInfo[localVector.size()];
/* 139:258 */     localVector.copyInto((Object[])localObject);
/* 140:    */     
/* 141:260 */     return localObject;
/* 142:    */   }
/* 143:    */   
/* 144:    */   private void appendPrefCmdsToVector(Hashtable paramHashtable, Vector paramVector)
/* 145:    */   {
/* 146:267 */     Enumeration localEnumeration = paramHashtable.keys();
/* 147:269 */     while (localEnumeration.hasMoreElements())
/* 148:    */     {
/* 149:270 */       String str1 = (String)localEnumeration.nextElement();
/* 150:271 */       if (!checkForVerb(paramVector, str1))
/* 151:    */       {
/* 152:272 */         Vector localVector = (Vector)paramHashtable.get(str1);
/* 153:273 */         String str2 = (String)localVector.firstElement();
/* 154:274 */         paramVector.addElement(new CommandInfo(str1, str2));
/* 155:    */       }
/* 156:    */     }
/* 157:    */   }
/* 158:    */   
/* 159:    */   private boolean checkForVerb(Vector paramVector, String paramString)
/* 160:    */   {
/* 161:284 */     Enumeration localEnumeration = paramVector.elements();
/* 162:285 */     while (localEnumeration.hasMoreElements())
/* 163:    */     {
/* 164:286 */       String str = 
/* 165:287 */         ((CommandInfo)localEnumeration.nextElement()).getCommandName();
/* 166:288 */       if (str.equals(paramString)) {
/* 167:289 */         return true;
/* 168:    */       }
/* 169:    */     }
/* 170:291 */     return false;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public synchronized CommandInfo[] getAllCommands(String paramString)
/* 174:    */   {
/* 175:302 */     Vector localVector = new Vector();
/* 176:304 */     for (int i = 0; i < this.DB.length; i++) {
/* 177:305 */       if (this.DB[i] != null)
/* 178:    */       {
/* 179:307 */         localObject = this.DB[i].getMailcapList(paramString);
/* 180:308 */         if (localObject != null) {
/* 181:309 */           appendCmdsToVector((Hashtable)localObject, localVector);
/* 182:    */         }
/* 183:    */       }
/* 184:    */     }
/* 185:312 */     Object localObject = new CommandInfo[localVector.size()];
/* 186:313 */     localVector.copyInto((Object[])localObject);
/* 187:    */     
/* 188:315 */     return localObject;
/* 189:    */   }
/* 190:    */   
/* 191:    */   private void appendCmdsToVector(Hashtable paramHashtable, Vector paramVector)
/* 192:    */   {
/* 193:322 */     Enumeration localEnumeration1 = paramHashtable.keys();
/* 194:    */     Enumeration localEnumeration2;
/* 195:324 */     for (; localEnumeration1.hasMoreElements(); localEnumeration2.hasMoreElements())
/* 196:    */     {
/* 197:325 */       String str1 = (String)localEnumeration1.nextElement();
/* 198:326 */       Vector localVector = (Vector)paramHashtable.get(str1);
/* 199:327 */       localEnumeration2 = localVector.elements();
/* 200:    */       
/* 201:329 */       continue;
/* 202:330 */       String str2 = (String)localEnumeration2.nextElement();
/* 203:    */       
/* 204:332 */       paramVector.insertElementAt(new CommandInfo(str1, str2), 0);
/* 205:    */     }
/* 206:    */   }
/* 207:    */   
/* 208:    */   public synchronized CommandInfo getCommand(String paramString1, String paramString2)
/* 209:    */   {
/* 210:346 */     for (int i = 0; i < this.DB.length; i++) {
/* 211:347 */       if (this.DB[i] != null)
/* 212:    */       {
/* 213:349 */         Hashtable localHashtable = this.DB[i].getMailcapList(paramString1);
/* 214:350 */         if (localHashtable != null)
/* 215:    */         {
/* 216:352 */           Vector localVector = (Vector)localHashtable.get(paramString2);
/* 217:353 */           if (localVector != null)
/* 218:    */           {
/* 219:354 */             String str = (String)localVector.firstElement();
/* 220:356 */             if (str != null) {
/* 221:357 */               return new CommandInfo(paramString2, str);
/* 222:    */             }
/* 223:    */           }
/* 224:    */         }
/* 225:    */       }
/* 226:    */     }
/* 227:361 */     return null;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public synchronized void addMailcap(String paramString)
/* 231:    */   {
/* 232:375 */     if (debug) {
/* 233:376 */       System.out.println("MailcapCommandMap: add to PROG");
/* 234:    */     }
/* 235:377 */     if (this.DB[0] == null) {
/* 236:378 */       this.DB[0] = new MailcapFile();
/* 237:    */     }
/* 238:380 */     this.DB[0].appendToMailcap(paramString);
/* 239:    */   }
/* 240:    */   
/* 241:    */   public synchronized DataContentHandler createDataContentHandler(String paramString)
/* 242:    */   {
/* 243:391 */     if (debug) {
/* 244:392 */       System.out.println(
/* 245:393 */         "MailcapCommandMap: createDataContentHandler for " + paramString);
/* 246:    */     }
/* 247:394 */     for (int i = 0; i < this.DB.length; i++) {
/* 248:395 */       if (this.DB[i] != null)
/* 249:    */       {
/* 250:397 */         if (debug) {
/* 251:398 */           System.out.println("  search DB #" + i);
/* 252:    */         }
/* 253:399 */         Hashtable localHashtable = this.DB[i].getMailcapList(paramString);
/* 254:400 */         if (localHashtable != null)
/* 255:    */         {
/* 256:401 */           Vector localVector = (Vector)localHashtable.get("content-handler");
/* 257:402 */           if (localVector != null)
/* 258:    */           {
/* 259:403 */             if (debug) {
/* 260:404 */               System.out.println("    got content-handler");
/* 261:    */             }
/* 262:    */             try
/* 263:    */             {
/* 264:406 */               if (debug) {
/* 265:407 */                 System.out.println("      class " + 
/* 266:408 */                   (String)localVector.firstElement());
/* 267:    */               }
/* 268:409 */               return (DataContentHandler)Class.forName(
/* 269:410 */                 (String)localVector.firstElement()).newInstance();
/* 270:    */             }
/* 271:    */             catch (IllegalAccessException localIllegalAccessException) {}catch (ClassNotFoundException localClassNotFoundException) {}catch (InstantiationException localInstantiationException) {}
/* 272:    */           }
/* 273:    */         }
/* 274:    */       }
/* 275:    */     }
/* 276:418 */     return null;
/* 277:    */   }
/* 278:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.MailcapCommandMap
 * JD-Core Version:    0.7.0.1
 */
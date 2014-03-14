/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.awt.datatransfer.DataFlavor;
/*   4:    */ import java.awt.datatransfer.Transferable;
/*   5:    */ import java.awt.datatransfer.UnsupportedFlavorException;
/*   6:    */ import java.io.IOException;
/*   7:    */ import java.io.InputStream;
/*   8:    */ import java.io.OutputStream;
/*   9:    */ import java.io.PipedInputStream;
/*  10:    */ import java.io.PipedOutputStream;
/*  11:    */ import java.net.URL;
/*  12:    */ 
/*  13:    */ public class DataHandler
/*  14:    */   implements Transferable
/*  15:    */ {
/*  16:    */   private DataSource dataSource;
/*  17:    */   private DataSource objDataSource;
/*  18:    */   private Object object;
/*  19:    */   private String objectMimeType;
/*  20:    */   private CommandMap currentCommandMap;
/*  21: 86 */   private static final DataFlavor[] emptyFlavors = new DataFlavor[0];
/*  22: 87 */   private DataFlavor[] transferFlavors = emptyFlavors;
/*  23:    */   private DataContentHandler dataContentHandler;
/*  24:    */   private DataContentHandler factoryDCH;
/*  25: 94 */   private static DataContentHandlerFactory factory = null;
/*  26:    */   private DataContentHandlerFactory oldFactory;
/*  27:    */   private String shortType;
/*  28:    */   
/*  29:    */   public DataHandler(DataSource paramDataSource)
/*  30:    */   {
/*  31:108 */     this.dataSource = paramDataSource;
/*  32:109 */     this.oldFactory = factory;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public DataHandler(Object paramObject, String paramString)
/*  36:    */   {
/*  37:122 */     this.object = paramObject;
/*  38:123 */     this.objectMimeType = paramString;
/*  39:124 */     this.oldFactory = factory;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public DataHandler(URL paramURL)
/*  43:    */   {
/*  44:135 */     this.dataSource = new URLDataSource(paramURL);
/*  45:136 */     this.oldFactory = factory;
/*  46:    */   }
/*  47:    */   
/*  48:    */   private synchronized CommandMap getCommandMap()
/*  49:    */   {
/*  50:143 */     if (this.currentCommandMap != null) {
/*  51:144 */       return this.currentCommandMap;
/*  52:    */     }
/*  53:146 */     return CommandMap.getDefaultCommandMap();
/*  54:    */   }
/*  55:    */   
/*  56:    */   public DataSource getDataSource()
/*  57:    */   {
/*  58:164 */     if (this.dataSource == null)
/*  59:    */     {
/*  60:166 */       if (this.objDataSource == null) {
/*  61:167 */         this.objDataSource = new DataHandlerDataSource(this);
/*  62:    */       }
/*  63:168 */       return this.objDataSource;
/*  64:    */     }
/*  65:170 */     return this.dataSource;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getName()
/*  69:    */   {
/*  70:182 */     if (this.dataSource != null) {
/*  71:183 */       return this.dataSource.getName();
/*  72:    */     }
/*  73:185 */     return null;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getContentType()
/*  77:    */   {
/*  78:196 */     if (this.dataSource != null) {
/*  79:197 */       return this.dataSource.getContentType();
/*  80:    */     }
/*  81:199 */     return this.objectMimeType;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public InputStream getInputStream()
/*  85:    */     throws IOException
/*  86:    */   {
/*  87:227 */     Object localObject = null;
/*  88:229 */     if (this.dataSource != null)
/*  89:    */     {
/*  90:230 */       localObject = this.dataSource.getInputStream();
/*  91:    */     }
/*  92:    */     else
/*  93:    */     {
/*  94:232 */       DataContentHandler localDataContentHandler1 = getDataContentHandler();
/*  95:234 */       if (localDataContentHandler1 == null) {
/*  96:235 */         throw new UnsupportedDataTypeException(
/*  97:236 */           "no DCH for MIME type " + getBaseType());
/*  98:    */       }
/*  99:238 */       if (((localDataContentHandler1 instanceof ObjectDataContentHandler)) && 
/* 100:239 */         (((ObjectDataContentHandler)localDataContentHandler1).getDCH() == null)) {
/* 101:240 */         throw new UnsupportedDataTypeException(
/* 102:241 */           "no object DCH for MIME type " + getBaseType());
/* 103:    */       }
/* 104:244 */       DataContentHandler localDataContentHandler2 = localDataContentHandler1;
/* 105:    */       
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:252 */       PipedOutputStream localPipedOutputStream = new PipedOutputStream();
/* 113:253 */       PipedInputStream localPipedInputStream = new PipedInputStream(localPipedOutputStream);
/* 114:254 */       new Thread(
/* 115:255 */         new Runnable()
/* 116:    */         {
/* 117:    */           private final PipedOutputStream val$pos;
/* 118:    */           private final DataHandler this$0;
/* 119:    */           
/* 120:    */           public void run()
/* 121:    */           {
/* 122:    */             try
/* 123:    */             {
/* 124:258 */               DataHandler.this.writeTo(this.this$0.object, this.this$0.objectMimeType, this.val$pos);
/* 125:    */             }
/* 126:    */             catch (IOException localIOException1) {}finally
/* 127:    */             {
/* 128:    */               try
/* 129:    */               {
/* 130:263 */                 this.val$pos.close();
/* 131:    */               }
/* 132:    */               catch (IOException localIOException2) {}
/* 133:    */             }
/* 134:    */           }
/* 135:268 */         }, "DataHandler.getInputStream").start();
/* 136:269 */       localObject = localPipedInputStream;
/* 137:    */     }
/* 138:272 */     return localObject;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void writeTo(OutputStream paramOutputStream)
/* 142:    */     throws IOException
/* 143:    */   {
/* 144:    */     Object localObject;
/* 145:292 */     if (this.dataSource != null)
/* 146:    */     {
/* 147:293 */       localObject = null;
/* 148:294 */       byte[] arrayOfByte = new byte[8192];
/* 149:    */       
/* 150:    */ 
/* 151:297 */       localObject = this.dataSource.getInputStream();
/* 152:    */       int i;
/* 153:299 */       while ((i = ((InputStream)localObject).read(arrayOfByte)) > 0) {
/* 154:300 */         paramOutputStream.write(arrayOfByte, 0, i);
/* 155:    */       }
/* 156:302 */       ((InputStream)localObject).close();
/* 157:    */     }
/* 158:    */     else
/* 159:    */     {
/* 160:304 */       localObject = getDataContentHandler();
/* 161:305 */       ((DataContentHandler)localObject).writeTo(this.object, this.objectMimeType, paramOutputStream);
/* 162:    */     }
/* 163:    */   }
/* 164:    */   
/* 165:    */   public OutputStream getOutputStream()
/* 166:    */     throws IOException
/* 167:    */   {
/* 168:322 */     if (this.dataSource != null) {
/* 169:323 */       return this.dataSource.getOutputStream();
/* 170:    */     }
/* 171:325 */     return null;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public synchronized DataFlavor[] getTransferDataFlavors()
/* 175:    */   {
/* 176:353 */     if (factory != this.oldFactory) {
/* 177:354 */       this.transferFlavors = emptyFlavors;
/* 178:    */     }
/* 179:357 */     if (this.transferFlavors == emptyFlavors) {
/* 180:358 */       this.transferFlavors = getDataContentHandler().getTransferDataFlavors();
/* 181:    */     }
/* 182:359 */     return this.transferFlavors;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public boolean isDataFlavorSupported(DataFlavor paramDataFlavor)
/* 186:    */   {
/* 187:375 */     DataFlavor[] arrayOfDataFlavor = getTransferDataFlavors();
/* 188:377 */     for (int i = 0; i < arrayOfDataFlavor.length; i++) {
/* 189:378 */       if (arrayOfDataFlavor[i].equals(paramDataFlavor)) {
/* 190:379 */         return true;
/* 191:    */       }
/* 192:    */     }
/* 193:381 */     return false;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public Object getTransferData(DataFlavor paramDataFlavor)
/* 197:    */     throws UnsupportedFlavorException, IOException
/* 198:    */   {
/* 199:419 */     return getDataContentHandler().getTransferData(paramDataFlavor, this.dataSource);
/* 200:    */   }
/* 201:    */   
/* 202:    */   public synchronized void setCommandMap(CommandMap paramCommandMap)
/* 203:    */   {
/* 204:435 */     if ((paramCommandMap != this.currentCommandMap) || (paramCommandMap == null))
/* 205:    */     {
/* 206:437 */       this.transferFlavors = emptyFlavors;
/* 207:438 */       this.dataContentHandler = null;
/* 208:    */       
/* 209:440 */       this.currentCommandMap = paramCommandMap;
/* 210:    */     }
/* 211:    */   }
/* 212:    */   
/* 213:    */   public CommandInfo[] getPreferredCommands()
/* 214:    */   {
/* 215:458 */     return getCommandMap().getPreferredCommands(getBaseType());
/* 216:    */   }
/* 217:    */   
/* 218:    */   public CommandInfo[] getAllCommands()
/* 219:    */   {
/* 220:474 */     return getCommandMap().getAllCommands(getBaseType());
/* 221:    */   }
/* 222:    */   
/* 223:    */   public CommandInfo getCommand(String paramString)
/* 224:    */   {
/* 225:490 */     return getCommandMap().getCommand(getBaseType(), paramString);
/* 226:    */   }
/* 227:    */   
/* 228:    */   public Object getContent()
/* 229:    */     throws IOException
/* 230:    */   {
/* 231:511 */     return getDataContentHandler().getContent(getDataSource());
/* 232:    */   }
/* 233:    */   
/* 234:    */   public Object getBean(CommandInfo paramCommandInfo)
/* 235:    */   {
/* 236:527 */     Object localObject = null;
/* 237:    */     try
/* 238:    */     {
/* 239:531 */       localObject = paramCommandInfo.getCommandObject(this, getClass().getClassLoader());
/* 240:    */     }
/* 241:    */     catch (IOException localIOException) {}catch (ClassNotFoundException localClassNotFoundException) {}
/* 242:535 */     return localObject;
/* 243:    */   }
/* 244:    */   
/* 245:    */   private synchronized DataContentHandler getDataContentHandler()
/* 246:    */   {
/* 247:558 */     if (factory != this.oldFactory)
/* 248:    */     {
/* 249:559 */       this.oldFactory = factory;
/* 250:560 */       this.factoryDCH = null;
/* 251:561 */       this.dataContentHandler = null;
/* 252:562 */       this.transferFlavors = emptyFlavors;
/* 253:    */     }
/* 254:565 */     if (this.dataContentHandler != null) {
/* 255:566 */       return this.dataContentHandler;
/* 256:    */     }
/* 257:568 */     String str = getBaseType();
/* 258:570 */     if ((this.factoryDCH == null) && (factory != null)) {
/* 259:571 */       this.factoryDCH = factory.createDataContentHandler(str);
/* 260:    */     }
/* 261:573 */     if (this.factoryDCH != null) {
/* 262:574 */       this.dataContentHandler = this.factoryDCH;
/* 263:    */     }
/* 264:576 */     if (this.dataContentHandler == null) {
/* 265:577 */       this.dataContentHandler = 
/* 266:578 */         getCommandMap().createDataContentHandler(str);
/* 267:    */     }
/* 268:583 */     if (this.dataSource != null) {
/* 269:584 */       this.dataContentHandler = new DataSourceDataContentHandler(
/* 270:585 */         this.dataContentHandler, 
/* 271:586 */         this.dataSource);
/* 272:    */     } else {
/* 273:588 */       this.dataContentHandler = new ObjectDataContentHandler(
/* 274:589 */         this.dataContentHandler, 
/* 275:590 */         this.object, 
/* 276:591 */         this.objectMimeType);
/* 277:    */     }
/* 278:592 */     return this.dataContentHandler;
/* 279:    */   }
/* 280:    */   
/* 281:    */   private synchronized String getBaseType()
/* 282:    */   {
/* 283:600 */     if (this.shortType == null)
/* 284:    */     {
/* 285:601 */       String str = getContentType();
/* 286:    */       try
/* 287:    */       {
/* 288:603 */         MimeType localMimeType = new MimeType(str);
/* 289:604 */         this.shortType = localMimeType.getBaseType();
/* 290:    */       }
/* 291:    */       catch (MimeTypeParseException localMimeTypeParseException)
/* 292:    */       {
/* 293:606 */         this.shortType = str;
/* 294:    */       }
/* 295:    */     }
/* 296:609 */     return this.shortType;
/* 297:    */   }
/* 298:    */   
/* 299:    */   public static synchronized void setDataContentHandlerFactory(DataContentHandlerFactory paramDataContentHandlerFactory)
/* 300:    */   {
/* 301:627 */     if (factory != null) {
/* 302:628 */       throw new Error("DataContentHandlerFactory already defined");
/* 303:    */     }
/* 304:630 */     SecurityManager localSecurityManager = System.getSecurityManager();
/* 305:631 */     if (localSecurityManager != null) {
/* 306:    */       try
/* 307:    */       {
/* 308:634 */         localSecurityManager.checkSetFactory();
/* 309:    */       }
/* 310:    */       catch (SecurityException localSecurityException)
/* 311:    */       {
/* 312:639 */         if (DataHandler.class.getClassLoader() != 
/* 313:640 */           paramDataContentHandlerFactory.getClass().getClassLoader()) {
/* 314:641 */           throw localSecurityException;
/* 315:    */         }
/* 316:    */       }
/* 317:    */     }
/* 318:644 */     factory = paramDataContentHandlerFactory;
/* 319:    */   }
/* 320:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.DataHandler
 * JD-Core Version:    0.7.0.1
 */
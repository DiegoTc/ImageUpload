/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import com.sun.activation.registries.MimeTypeFile;
/*   4:    */ import java.io.File;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.InputStream;
/*   7:    */ 
/*   8:    */ public class MimetypesFileTypeMap
/*   9:    */   extends FileTypeMap
/*  10:    */ {
/*  11: 66 */   private static MimeTypeFile defDB = null;
/*  12: 67 */   private MimeTypeFile[] DB = new MimeTypeFile[5];
/*  13:    */   private static final int PROG = 0;
/*  14:    */   private static final int HOME = 1;
/*  15:    */   private static final int SYS = 2;
/*  16:    */   private static final int JAR = 3;
/*  17:    */   private static final int DEF = 4;
/*  18: 74 */   private static String defaultType = "application/octet-stream";
/*  19:    */   static Class class$javax$activation$MimetypesFileTypeMap;
/*  20:    */   
/*  21:    */   public MimetypesFileTypeMap()
/*  22:    */   {
/*  23:    */     try
/*  24:    */     {
/*  25: 81 */       ??? = System.getProperty("user.home");
/*  26: 83 */       if (??? != null)
/*  27:    */       {
/*  28: 84 */         String str = ??? + File.separator + ".mime.types";
/*  29: 85 */         this.DB[1] = loadFile(str);
/*  30:    */       }
/*  31:    */     }
/*  32:    */     catch (SecurityException localSecurityException1) {}
/*  33:    */     try
/*  34:    */     {
/*  35: 91 */       ??? = 
/*  36: 92 */         System.getProperty("java.home") + File.separator + "lib" + File.separator + "mime.types";
/*  37: 93 */       this.DB[2] = loadFile((String)???);
/*  38:    */     }
/*  39:    */     catch (SecurityException localSecurityException2) {}
/*  40: 97 */     this.DB[3] = loadResource("/META-INF/mime.types");
/*  41: 99 */     synchronized (MimetypesFileTypeMap.class$javax$activation$MimetypesFileTypeMap = FileTypeMap.class$("javax.activation.MimetypesFileTypeMap"))
/*  42:    */     {
/*  43:101 */       if (defDB == null) {
/*  44:102 */         defDB = loadResource("/META-INF/mimetypes.default");
/*  45:    */       }
/*  46:    */     }
/*  47:105 */     this.DB[4] = defDB;
/*  48:    */   }
/*  49:    */   
/*  50:    */   private MimeTypeFile loadResource(String paramString)
/*  51:    */   {
/*  52:    */     try
/*  53:    */     {
/*  54:113 */       InputStream localInputStream = getClass().getResourceAsStream(paramString);
/*  55:114 */       if (localInputStream != null) {
/*  56:115 */         return new MimeTypeFile(localInputStream);
/*  57:    */       }
/*  58:    */     }
/*  59:    */     catch (IOException localIOException) {}
/*  60:119 */     return null;
/*  61:    */   }
/*  62:    */   
/*  63:    */   private MimeTypeFile loadFile(String paramString)
/*  64:    */   {
/*  65:126 */     MimeTypeFile localMimeTypeFile = null;
/*  66:    */     try
/*  67:    */     {
/*  68:129 */       localMimeTypeFile = new MimeTypeFile(paramString);
/*  69:    */     }
/*  70:    */     catch (IOException localIOException) {}
/*  71:133 */     return localMimeTypeFile;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public MimetypesFileTypeMap(String paramString)
/*  75:    */     throws IOException
/*  76:    */   {
/*  77:143 */     this();
/*  78:144 */     this.DB[0] = new MimeTypeFile(paramString);
/*  79:    */   }
/*  80:    */   
/*  81:    */   public MimetypesFileTypeMap(InputStream paramInputStream)
/*  82:    */   {
/*  83:154 */     this();
/*  84:    */     try
/*  85:    */     {
/*  86:156 */       this.DB[0] = new MimeTypeFile(paramInputStream);
/*  87:    */     }
/*  88:    */     catch (IOException localIOException) {}
/*  89:    */   }
/*  90:    */   
/*  91:    */   public synchronized void addMimeTypes(String paramString)
/*  92:    */   {
/*  93:169 */     if (this.DB[0] == null) {
/*  94:170 */       this.DB[0] = new MimeTypeFile();
/*  95:    */     }
/*  96:172 */     this.DB[0].appendToRegistry(paramString);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getContentType(File paramFile)
/* 100:    */   {
/* 101:184 */     return getContentType(paramFile.getName());
/* 102:    */   }
/* 103:    */   
/* 104:    */   public synchronized String getContentType(String paramString)
/* 105:    */   {
/* 106:197 */     int i = paramString.lastIndexOf(".");
/* 107:199 */     if (i < 0) {
/* 108:200 */       return defaultType;
/* 109:    */     }
/* 110:202 */     String str1 = paramString.substring(i + 1);
/* 111:203 */     if (str1.length() == 0) {
/* 112:204 */       return defaultType;
/* 113:    */     }
/* 114:206 */     for (int j = 0; j < this.DB.length; j++) {
/* 115:207 */       if (this.DB[j] != null)
/* 116:    */       {
/* 117:209 */         String str2 = this.DB[j].getMIMETypeString(str1);
/* 118:210 */         if (str2 != null) {
/* 119:211 */           return str2;
/* 120:    */         }
/* 121:    */       }
/* 122:    */     }
/* 123:213 */     return defaultType;
/* 124:    */   }
/* 125:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.MimetypesFileTypeMap
 * JD-Core Version:    0.7.0.1
 */
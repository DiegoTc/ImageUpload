/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ 
/*   5:    */ public abstract class FileTypeMap
/*   6:    */ {
/*   7: 44 */   private static FileTypeMap defaultMap = null;
/*   8:    */   
/*   9:    */   public abstract String getContentType(File paramFile);
/*  10:    */   
/*  11:    */   public abstract String getContentType(String paramString);
/*  12:    */   
/*  13:    */   public static void setDefaultFileTypeMap(FileTypeMap paramFileTypeMap)
/*  14:    */   {
/*  15: 80 */     SecurityManager localSecurityManager = System.getSecurityManager();
/*  16: 81 */     if (localSecurityManager != null) {
/*  17:    */       try
/*  18:    */       {
/*  19: 84 */         localSecurityManager.checkSetFactory();
/*  20:    */       }
/*  21:    */       catch (SecurityException localSecurityException)
/*  22:    */       {
/*  23: 89 */         if (FileTypeMap.class.getClassLoader() != 
/*  24: 90 */           paramFileTypeMap.getClass().getClassLoader()) {
/*  25: 91 */           throw localSecurityException;
/*  26:    */         }
/*  27:    */       }
/*  28:    */     }
/*  29: 94 */     defaultMap = paramFileTypeMap;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public static FileTypeMap getDefaultFileTypeMap()
/*  33:    */   {
/*  34:108 */     if (defaultMap == null) {
/*  35:109 */       defaultMap = new MimetypesFileTypeMap();
/*  36:    */     }
/*  37:110 */     return defaultMap;
/*  38:    */   }
/*  39:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.FileTypeMap
 * JD-Core Version:    0.7.0.1
 */
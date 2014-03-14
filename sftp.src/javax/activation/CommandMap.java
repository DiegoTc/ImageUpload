/*  1:   */ package javax.activation;
/*  2:   */ 
/*  3:   */ public abstract class CommandMap
/*  4:   */ {
/*  5:34 */   private static CommandMap defaultCommandMap = null;
/*  6:   */   
/*  7:   */   public static CommandMap getDefaultCommandMap()
/*  8:   */   {
/*  9:54 */     if (defaultCommandMap == null) {
/* 10:55 */       defaultCommandMap = new MailcapCommandMap();
/* 11:   */     }
/* 12:57 */     return defaultCommandMap;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public static void setDefaultCommandMap(CommandMap paramCommandMap)
/* 16:   */   {
/* 17:69 */     SecurityManager localSecurityManager = System.getSecurityManager();
/* 18:70 */     if (localSecurityManager != null) {
/* 19:   */       try
/* 20:   */       {
/* 21:73 */         localSecurityManager.checkSetFactory();
/* 22:   */       }
/* 23:   */       catch (SecurityException localSecurityException)
/* 24:   */       {
/* 25:78 */         if (CommandMap.class.getClassLoader() != 
/* 26:79 */           paramCommandMap.getClass().getClassLoader()) {
/* 27:80 */           throw localSecurityException;
/* 28:   */         }
/* 29:   */       }
/* 30:   */     }
/* 31:83 */     defaultCommandMap = paramCommandMap;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public abstract CommandInfo[] getPreferredCommands(String paramString);
/* 35:   */   
/* 36:   */   public abstract CommandInfo[] getAllCommands(String paramString);
/* 37:   */   
/* 38:   */   public abstract CommandInfo getCommand(String paramString1, String paramString2);
/* 39:   */   
/* 40:   */   public abstract DataContentHandler createDataContentHandler(String paramString);
/* 41:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.CommandMap
 * JD-Core Version:    0.7.0.1
 */
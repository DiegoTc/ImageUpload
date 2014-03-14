/*  1:   */ package com.sun.activation.registries;
/*  2:   */ 
/*  3:   */ public class MimeTypeEntry
/*  4:   */ {
/*  5:   */   private String type;
/*  6:   */   private String extension;
/*  7:   */   
/*  8:   */   public MimeTypeEntry(String paramString1, String paramString2)
/*  9:   */   {
/* 10:31 */     this.type = paramString1;
/* 11:32 */     this.extension = paramString2;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getMIMEType()
/* 15:   */   {
/* 16:36 */     return this.type;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getFileExtension()
/* 20:   */   {
/* 21:40 */     return this.extension;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String toString()
/* 25:   */   {
/* 26:44 */     return "MIMETypeEntry: " + this.type + ", " + this.extension;
/* 27:   */   }
/* 28:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.registries.MimeTypeEntry
 * JD-Core Version:    0.7.0.1
 */
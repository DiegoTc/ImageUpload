/*  1:   */ package com.sun.activation.registries;
/*  2:   */ 
/*  3:   */ public class MailcapEntry
/*  4:   */ {
/*  5:   */   private String Mailcap;
/*  6:   */   private String Executable;
/*  7:   */   
/*  8:   */   public MailcapEntry(String paramString1, String paramString2)
/*  9:   */   {
/* 10:32 */     this.Mailcap = new String(paramString1);
/* 11:33 */     this.Executable = new String(paramString2);
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getMailcap()
/* 15:   */   {
/* 16:38 */     return this.Mailcap;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getExecutable()
/* 20:   */   {
/* 21:43 */     return this.Executable;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String toString()
/* 25:   */   {
/* 26:48 */     return new String("MailcapEntry: " + this.Mailcap + 
/* 27:49 */       ", " + this.Executable);
/* 28:   */   }
/* 29:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.registries.MailcapEntry
 * JD-Core Version:    0.7.0.1
 */
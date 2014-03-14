/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.beans.Beans;
/*   4:    */ import java.io.Externalizable;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.InputStream;
/*   7:    */ import java.io.ObjectInputStream;
/*   8:    */ 
/*   9:    */ public class CommandInfo
/*  10:    */ {
/*  11:    */   private String verb;
/*  12:    */   private String className;
/*  13:    */   
/*  14:    */   public CommandInfo(String paramString1, String paramString2)
/*  15:    */   {
/*  16: 50 */     this.verb = paramString1;
/*  17: 51 */     this.className = paramString2;
/*  18:    */   }
/*  19:    */   
/*  20:    */   public String getCommandName()
/*  21:    */   {
/*  22: 60 */     return this.verb;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public String getCommandClass()
/*  26:    */   {
/*  27: 74 */     return this.className;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public Object getCommandObject(DataHandler paramDataHandler, ClassLoader paramClassLoader)
/*  31:    */     throws IOException, ClassNotFoundException
/*  32:    */   {
/*  33:109 */     Object localObject = null;
/*  34:    */     
/*  35:    */ 
/*  36:112 */     localObject = Beans.instantiate(paramClassLoader, this.className);
/*  37:115 */     if (localObject != null) {
/*  38:116 */       if ((localObject instanceof CommandObject))
/*  39:    */       {
/*  40:117 */         ((CommandObject)localObject).setCommandContext(this.verb, paramDataHandler);
/*  41:    */       }
/*  42:118 */       else if (((localObject instanceof Externalizable)) && 
/*  43:119 */         (paramDataHandler != null))
/*  44:    */       {
/*  45:120 */         InputStream localInputStream = paramDataHandler.getInputStream();
/*  46:121 */         if (localInputStream != null) {
/*  47:122 */           ((Externalizable)localObject).readExternal(
/*  48:123 */             new ObjectInputStream(localInputStream));
/*  49:    */         }
/*  50:    */       }
/*  51:    */     }
/*  52:129 */     return localObject;
/*  53:    */   }
/*  54:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.CommandInfo
 * JD-Core Version:    0.7.0.1
 */
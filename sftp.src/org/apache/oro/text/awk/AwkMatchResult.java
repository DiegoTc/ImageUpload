/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.MatchResult;
/*   4:    */ 
/*   5:    */ final class AwkMatchResult
/*   6:    */   implements MatchResult
/*   7:    */ {
/*   8:    */   private int __matchBeginOffset;
/*   9:    */   private int __length;
/*  10:    */   private String __match;
/*  11:    */   
/*  12:    */   AwkMatchResult(String paramString, int paramInt)
/*  13:    */   {
/*  14:107 */     this.__match = paramString;
/*  15:108 */     this.__length = paramString.length();
/*  16:109 */     this.__matchBeginOffset = paramInt;
/*  17:    */   }
/*  18:    */   
/*  19:    */   public int length()
/*  20:    */   {
/*  21:116 */     return this.__length;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public int groups()
/*  25:    */   {
/*  26:126 */     return 1;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public String group(int paramInt)
/*  30:    */   {
/*  31:137 */     return paramInt == 0 ? this.__match : null;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public int begin(int paramInt)
/*  35:    */   {
/*  36:146 */     return paramInt == 0 ? 0 : -1;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public int end(int paramInt)
/*  40:    */   {
/*  41:155 */     return paramInt == 0 ? this.__length : -1;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public int beginOffset(int paramInt)
/*  45:    */   {
/*  46:168 */     return paramInt == 0 ? this.__matchBeginOffset : -1;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public int endOffset(int paramInt)
/*  50:    */   {
/*  51:182 */     return paramInt == 0 ? this.__matchBeginOffset + this.__length : -1;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String toString()
/*  55:    */   {
/*  56:191 */     return group(0);
/*  57:    */   }
/*  58:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.AwkMatchResult
 * JD-Core Version:    0.7.0.1
 */
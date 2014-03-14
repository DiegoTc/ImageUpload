/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   4:    */ import org.apache.oro.text.regex.Perl5Compiler;
/*   5:    */ import org.apache.oro.util.CacheLRU;
/*   6:    */ 
/*   7:    */ public final class PatternCacheLRU
/*   8:    */   extends GenericPatternCache
/*   9:    */ {
/*  10:    */   public PatternCacheLRU(int paramInt, PatternCompiler paramPatternCompiler)
/*  11:    */   {
/*  12: 89 */     super(new CacheLRU(paramInt), paramPatternCompiler);
/*  13:    */   }
/*  14:    */   
/*  15:    */   public PatternCacheLRU(PatternCompiler paramPatternCompiler)
/*  16:    */   {
/*  17: 99 */     this(20, paramPatternCompiler);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public PatternCacheLRU(int paramInt)
/*  21:    */   {
/*  22:110 */     this(paramInt, new Perl5Compiler());
/*  23:    */   }
/*  24:    */   
/*  25:    */   public PatternCacheLRU()
/*  26:    */   {
/*  27:120 */     this(20);
/*  28:    */   }
/*  29:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.PatternCacheLRU
 * JD-Core Version:    0.7.0.1
 */
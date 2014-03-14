/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   4:    */ import org.apache.oro.text.regex.Perl5Compiler;
/*   5:    */ import org.apache.oro.util.CacheFIFO;
/*   6:    */ 
/*   7:    */ public final class PatternCacheFIFO
/*   8:    */   extends GenericPatternCache
/*   9:    */ {
/*  10:    */   public PatternCacheFIFO(int paramInt, PatternCompiler paramPatternCompiler)
/*  11:    */   {
/*  12: 87 */     super(new CacheFIFO(paramInt), paramPatternCompiler);
/*  13:    */   }
/*  14:    */   
/*  15:    */   public PatternCacheFIFO(PatternCompiler paramPatternCompiler)
/*  16:    */   {
/*  17: 98 */     this(20, paramPatternCompiler);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public PatternCacheFIFO(int paramInt)
/*  21:    */   {
/*  22:109 */     this(paramInt, new Perl5Compiler());
/*  23:    */   }
/*  24:    */   
/*  25:    */   public PatternCacheFIFO()
/*  26:    */   {
/*  27:119 */     this(20);
/*  28:    */   }
/*  29:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.PatternCacheFIFO
 * JD-Core Version:    0.7.0.1
 */
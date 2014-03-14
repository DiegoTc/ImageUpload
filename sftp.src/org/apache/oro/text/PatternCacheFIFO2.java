/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   4:    */ import org.apache.oro.text.regex.Perl5Compiler;
/*   5:    */ import org.apache.oro.util.CacheFIFO2;
/*   6:    */ 
/*   7:    */ public final class PatternCacheFIFO2
/*   8:    */   extends GenericPatternCache
/*   9:    */ {
/*  10:    */   public PatternCacheFIFO2(int paramInt, PatternCompiler paramPatternCompiler)
/*  11:    */   {
/*  12: 94 */     super(new CacheFIFO2(paramInt), paramPatternCompiler);
/*  13:    */   }
/*  14:    */   
/*  15:    */   public PatternCacheFIFO2(PatternCompiler paramPatternCompiler)
/*  16:    */   {
/*  17:105 */     this(20, paramPatternCompiler);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public PatternCacheFIFO2(int paramInt)
/*  21:    */   {
/*  22:116 */     this(paramInt, new Perl5Compiler());
/*  23:    */   }
/*  24:    */   
/*  25:    */   public PatternCacheFIFO2()
/*  26:    */   {
/*  27:127 */     this(20);
/*  28:    */   }
/*  29:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.PatternCacheFIFO2
 * JD-Core Version:    0.7.0.1
 */
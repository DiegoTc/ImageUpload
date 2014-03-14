/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   4:    */ import org.apache.oro.text.regex.Perl5Compiler;
/*   5:    */ import org.apache.oro.util.CacheRandom;
/*   6:    */ 
/*   7:    */ public final class PatternCacheRandom
/*   8:    */   extends GenericPatternCache
/*   9:    */ {
/*  10:    */   public PatternCacheRandom(int paramInt, PatternCompiler paramPatternCompiler)
/*  11:    */   {
/*  12: 88 */     super(new CacheRandom(paramInt), paramPatternCompiler);
/*  13:    */   }
/*  14:    */   
/*  15:    */   public PatternCacheRandom(PatternCompiler paramPatternCompiler)
/*  16:    */   {
/*  17: 98 */     this(20, paramPatternCompiler);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public PatternCacheRandom(int paramInt)
/*  21:    */   {
/*  22:108 */     this(paramInt, new Perl5Compiler());
/*  23:    */   }
/*  24:    */   
/*  25:    */   public PatternCacheRandom()
/*  26:    */   {
/*  27:118 */     this(20);
/*  28:    */   }
/*  29:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.PatternCacheRandom
 * JD-Core Version:    0.7.0.1
 */
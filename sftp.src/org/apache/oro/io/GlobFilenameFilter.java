/*   1:    */ package org.apache.oro.io;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.GlobCompiler;
/*   4:    */ import org.apache.oro.text.PatternCache;
/*   5:    */ import org.apache.oro.text.PatternCacheLRU;
/*   6:    */ import org.apache.oro.text.regex.PatternMatcher;
/*   7:    */ import org.apache.oro.text.regex.Perl5Matcher;
/*   8:    */ 
/*   9:    */ public class GlobFilenameFilter
/*  10:    */   extends RegexFilenameFilter
/*  11:    */ {
/*  12: 78 */   private static final PatternMatcher __MATCHER = new Perl5Matcher();
/*  13: 80 */   private static final PatternCache __CACHE = new PatternCacheLRU(new GlobCompiler());
/*  14:    */   
/*  15:    */   public GlobFilenameFilter(String paramString, int paramInt)
/*  16:    */   {
/*  17: 96 */     super(__CACHE, __MATCHER, paramString, paramInt);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public GlobFilenameFilter(String paramString)
/*  21:    */   {
/*  22:101 */     super(__CACHE, __MATCHER, paramString);
/*  23:    */   }
/*  24:    */   
/*  25:    */   public GlobFilenameFilter()
/*  26:    */   {
/*  27:106 */     super(__CACHE, __MATCHER);
/*  28:    */   }
/*  29:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.io.GlobFilenameFilter
 * JD-Core Version:    0.7.0.1
 */
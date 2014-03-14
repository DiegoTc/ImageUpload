/*   1:    */ package org.apache.oro.io;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.PatternCache;
/*   4:    */ import org.apache.oro.text.PatternCacheLRU;
/*   5:    */ import org.apache.oro.text.regex.PatternMatcher;
/*   6:    */ import org.apache.oro.text.regex.Perl5Matcher;
/*   7:    */ 
/*   8:    */ public class Perl5FilenameFilter
/*   9:    */   extends RegexFilenameFilter
/*  10:    */ {
/*  11: 79 */   private static final PatternMatcher __MATCHER = new Perl5Matcher();
/*  12: 80 */   private static final PatternCache __CACHE = new PatternCacheLRU();
/*  13:    */   
/*  14:    */   public Perl5FilenameFilter(String paramString, int paramInt)
/*  15:    */   {
/*  16: 96 */     super(__CACHE, __MATCHER, paramString, paramInt);
/*  17:    */   }
/*  18:    */   
/*  19:    */   public Perl5FilenameFilter(String paramString)
/*  20:    */   {
/*  21:101 */     super(__CACHE, __MATCHER, paramString);
/*  22:    */   }
/*  23:    */   
/*  24:    */   public Perl5FilenameFilter()
/*  25:    */   {
/*  26:106 */     super(__CACHE, __MATCHER);
/*  27:    */   }
/*  28:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.io.Perl5FilenameFilter
 * JD-Core Version:    0.7.0.1
 */
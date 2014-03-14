/*   1:    */ package org.apache.oro.io;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.PatternCache;
/*   4:    */ import org.apache.oro.text.PatternCacheLRU;
/*   5:    */ import org.apache.oro.text.awk.AwkCompiler;
/*   6:    */ import org.apache.oro.text.awk.AwkMatcher;
/*   7:    */ import org.apache.oro.text.regex.PatternMatcher;
/*   8:    */ 
/*   9:    */ public class AwkFilenameFilter
/*  10:    */   extends RegexFilenameFilter
/*  11:    */ {
/*  12: 79 */   private static final PatternMatcher __MATCHER = new AwkMatcher();
/*  13: 81 */   private static final PatternCache __CACHE = new PatternCacheLRU(new AwkCompiler());
/*  14:    */   
/*  15:    */   public AwkFilenameFilter(String paramString, int paramInt)
/*  16:    */   {
/*  17: 97 */     super(__CACHE, __MATCHER, paramString, paramInt);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public AwkFilenameFilter(String paramString)
/*  21:    */   {
/*  22:102 */     super(__CACHE, __MATCHER, paramString);
/*  23:    */   }
/*  24:    */   
/*  25:    */   public AwkFilenameFilter()
/*  26:    */   {
/*  27:107 */     super(__CACHE, __MATCHER);
/*  28:    */   }
/*  29:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.io.AwkFilenameFilter
 * JD-Core Version:    0.7.0.1
 */
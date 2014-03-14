/*   1:    */ package org.apache.oro.io;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.FilenameFilter;
/*   5:    */ import org.apache.oro.text.MalformedCachePatternException;
/*   6:    */ import org.apache.oro.text.PatternCache;
/*   7:    */ import org.apache.oro.text.regex.Pattern;
/*   8:    */ import org.apache.oro.text.regex.PatternMatcher;
/*   9:    */ 
/*  10:    */ public abstract class RegexFilenameFilter
/*  11:    */   implements FilenameFilter
/*  12:    */ {
/*  13:    */   PatternCache _cache;
/*  14:    */   PatternMatcher _matcher;
/*  15:    */   Pattern _pattern;
/*  16:    */   
/*  17:    */   RegexFilenameFilter(PatternCache paramPatternCache, PatternMatcher paramPatternMatcher, String paramString)
/*  18:    */   {
/*  19: 83 */     this._cache = paramPatternCache;
/*  20: 84 */     this._matcher = paramPatternMatcher;
/*  21: 85 */     setFilterExpression(paramString);
/*  22:    */   }
/*  23:    */   
/*  24:    */   RegexFilenameFilter(PatternCache paramPatternCache, PatternMatcher paramPatternMatcher, String paramString, int paramInt)
/*  25:    */   {
/*  26: 91 */     this._cache = paramPatternCache;
/*  27: 92 */     this._matcher = paramPatternMatcher;
/*  28: 93 */     setFilterExpression(paramString);
/*  29:    */   }
/*  30:    */   
/*  31:    */   RegexFilenameFilter(PatternCache paramPatternCache, PatternMatcher paramPatternMatcher)
/*  32:    */   {
/*  33: 97 */     this(paramPatternCache, paramPatternMatcher, "");
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setFilterExpression(String paramString)
/*  37:    */     throws MalformedCachePatternException
/*  38:    */   {
/*  39:113 */     this._pattern = this._cache.getPattern(paramString);
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setFilterExpression(String paramString, int paramInt)
/*  43:    */     throws MalformedCachePatternException
/*  44:    */   {
/*  45:132 */     this._pattern = this._cache.getPattern(paramString, paramInt);
/*  46:    */   }
/*  47:    */   
/*  48:    */   public boolean accept(File paramFile, String paramString)
/*  49:    */   {
/*  50:144 */     synchronized (this._matcher)
/*  51:    */     {
/*  52:145 */       boolean bool = this._matcher.matches(paramString, this._pattern);return bool;
/*  53:    */     }
/*  54:    */   }
/*  55:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.io.RegexFilenameFilter
 * JD-Core Version:    0.7.0.1
 */
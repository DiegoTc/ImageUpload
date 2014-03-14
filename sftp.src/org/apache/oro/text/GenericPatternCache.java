/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.MalformedPatternException;
/*   4:    */ import org.apache.oro.text.regex.Pattern;
/*   5:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   6:    */ import org.apache.oro.util.Cache;
/*   7:    */ 
/*   8:    */ public abstract class GenericPatternCache
/*   9:    */   implements PatternCache
/*  10:    */ {
/*  11:    */   PatternCompiler _compiler;
/*  12:    */   Cache _cache;
/*  13:    */   public static final int DEFAULT_CAPACITY = 20;
/*  14:    */   
/*  15:    */   GenericPatternCache(Cache paramCache, PatternCompiler paramPatternCompiler)
/*  16:    */   {
/*  17:102 */     this._cache = paramCache;
/*  18:103 */     this._compiler = paramPatternCompiler;
/*  19:    */   }
/*  20:    */   
/*  21:    */   public final synchronized Pattern addPattern(String paramString, int paramInt)
/*  22:    */     throws MalformedPatternException
/*  23:    */   {
/*  24:138 */     Object localObject = this._cache.getElement(paramString);
/*  25:140 */     if (localObject != null)
/*  26:    */     {
/*  27:141 */       localPattern = (Pattern)localObject;
/*  28:143 */       if (localPattern.getOptions() == paramInt) {
/*  29:144 */         return localPattern;
/*  30:    */       }
/*  31:    */     }
/*  32:147 */     Pattern localPattern = this._compiler.compile(paramString, paramInt);
/*  33:148 */     this._cache.addElement(paramString, localPattern);
/*  34:    */     
/*  35:150 */     return localPattern;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public final synchronized Pattern addPattern(String paramString)
/*  39:    */     throws MalformedPatternException
/*  40:    */   {
/*  41:165 */     return addPattern(paramString, 0);
/*  42:    */   }
/*  43:    */   
/*  44:    */   public final synchronized Pattern getPattern(String paramString, int paramInt)
/*  45:    */     throws MalformedCachePatternException
/*  46:    */   {
/*  47:193 */     Pattern localPattern = null;
/*  48:    */     try
/*  49:    */     {
/*  50:196 */       localPattern = addPattern(paramString, paramInt);
/*  51:    */     }
/*  52:    */     catch (MalformedPatternException localMalformedPatternException)
/*  53:    */     {
/*  54:198 */       throw new MalformedCachePatternException("Invalid expression: " + 
/*  55:199 */         paramString + "\n" + 
/*  56:200 */         localMalformedPatternException.getMessage());
/*  57:    */     }
/*  58:203 */     return localPattern;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public final synchronized Pattern getPattern(String paramString)
/*  62:    */     throws MalformedCachePatternException
/*  63:    */   {
/*  64:216 */     return getPattern(paramString, 0);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public final int size()
/*  68:    */   {
/*  69:228 */     return this._cache.size();
/*  70:    */   }
/*  71:    */   
/*  72:    */   public final int capacity()
/*  73:    */   {
/*  74:235 */     return this._cache.capacity();
/*  75:    */   }
/*  76:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.GenericPatternCache
 * JD-Core Version:    0.7.0.1
 */
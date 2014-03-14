/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ import java.util.Vector;
/*   5:    */ 
/*   6:    */ public final class Util
/*   7:    */ {
/*   8:    */   public static final int SUBSTITUTE_ALL = -1;
/*   9:    */   public static final int SPLIT_ALL = 0;
/*  10:    */   
/*  11:    */   public static void split(List paramList, PatternMatcher paramPatternMatcher, Pattern paramPattern, String paramString, int paramInt)
/*  12:    */   {
/*  13:167 */     PatternMatcherInput localPatternMatcherInput = new PatternMatcherInput(paramString);
/*  14:168 */     int i = 0;
/*  15:    */     do
/*  16:    */     {
/*  17:171 */       MatchResult localMatchResult = paramPatternMatcher.getMatch();
/*  18:172 */       paramList.add(paramString.substring(i, 
/*  19:173 */         localMatchResult.beginOffset(0)));
/*  20:174 */       i = localMatchResult.endOffset(0);paramInt--;
/*  21:170 */     } while ((paramInt != 0) && (paramPatternMatcher.contains(localPatternMatcherInput, paramPattern)));
/*  22:177 */     paramList.add(paramString.substring(i, paramString.length()));
/*  23:    */   }
/*  24:    */   
/*  25:    */   public static void split(List paramList, PatternMatcher paramPatternMatcher, Pattern paramPattern, String paramString)
/*  26:    */   {
/*  27:218 */     split(paramList, paramPatternMatcher, paramPattern, paramString, 0);
/*  28:    */   }
/*  29:    */   
/*  30:    */   /**
/*  31:    */    * @deprecated
/*  32:    */    */
/*  33:    */   public static Vector split(PatternMatcher paramPatternMatcher, Pattern paramPattern, String paramString, int paramInt)
/*  34:    */   {
/*  35:268 */     Vector localVector = new Vector(20);
/*  36:    */     
/*  37:270 */     split(localVector, paramPatternMatcher, paramPattern, paramString, paramInt);
/*  38:    */     
/*  39:272 */     return localVector;
/*  40:    */   }
/*  41:    */   
/*  42:    */   /**
/*  43:    */    * @deprecated
/*  44:    */    */
/*  45:    */   public static Vector split(PatternMatcher paramPatternMatcher, Pattern paramPattern, String paramString)
/*  46:    */   {
/*  47:313 */     return split(paramPatternMatcher, paramPattern, paramString, 0);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public static String substitute(PatternMatcher paramPatternMatcher, Pattern paramPattern, Substitution paramSubstitution, String paramString, int paramInt)
/*  51:    */   {
/*  52:344 */     StringBuffer localStringBuffer = new StringBuffer(paramString.length());
/*  53:    */     
/*  54:346 */     PatternMatcherInput localPatternMatcherInput = new PatternMatcherInput(paramString);
/*  55:    */     int j;
/*  56:347 */     int i = j = 0;
/*  57:351 */     while ((paramInt != 0) && (paramPatternMatcher.contains(localPatternMatcherInput, paramPattern)))
/*  58:    */     {
/*  59:352 */       paramInt--;
/*  60:353 */       j++;
/*  61:354 */       MatchResult localMatchResult = paramPatternMatcher.getMatch();
/*  62:355 */       localStringBuffer.append(paramString.substring(i, 
/*  63:356 */         localMatchResult.beginOffset(0)));
/*  64:357 */       paramSubstitution.appendSubstitution(localStringBuffer, localMatchResult, j, 
/*  65:358 */         paramString, paramPatternMatcher, paramPattern);
/*  66:359 */       i = localMatchResult.endOffset(0);
/*  67:    */     }
/*  68:364 */     if (j == 0) {
/*  69:365 */       return paramString;
/*  70:    */     }
/*  71:367 */     localStringBuffer.append(paramString.substring(i, paramString.length()));
/*  72:    */     
/*  73:369 */     return localStringBuffer.toString();
/*  74:    */   }
/*  75:    */   
/*  76:    */   public static String substitute(PatternMatcher paramPatternMatcher, Pattern paramPattern, Substitution paramSubstitution, String paramString)
/*  77:    */   {
/*  78:394 */     return substitute(paramPatternMatcher, paramPattern, paramSubstitution, paramString, 1);
/*  79:    */   }
/*  80:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Util
 * JD-Core Version:    0.7.0.1
 */
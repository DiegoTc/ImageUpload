/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ public class StringSubstitution
/*   4:    */   implements Substitution
/*   5:    */ {
/*   6:    */   int _subLength;
/*   7:    */   String _substitution;
/*   8:    */   
/*   9:    */   public StringSubstitution()
/*  10:    */   {
/*  11: 83 */     this("");
/*  12:    */   }
/*  13:    */   
/*  14:    */   public StringSubstitution(String paramString)
/*  15:    */   {
/*  16: 92 */     setSubstitution(paramString);
/*  17:    */   }
/*  18:    */   
/*  19:    */   public void setSubstitution(String paramString)
/*  20:    */   {
/*  21:105 */     this._substitution = paramString;
/*  22:106 */     this._subLength = paramString.length();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public String getSubstitution()
/*  26:    */   {
/*  27:114 */     return this._substitution;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String toString()
/*  31:    */   {
/*  32:121 */     return getSubstitution();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void appendSubstitution(StringBuffer paramStringBuffer, MatchResult paramMatchResult, int paramInt, String paramString, PatternMatcher paramPatternMatcher, Pattern paramPattern)
/*  36:    */   {
/*  37:144 */     if (this._subLength == 0) {
/*  38:145 */       return;
/*  39:    */     }
/*  40:146 */     paramStringBuffer.append(this._substitution);
/*  41:    */   }
/*  42:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.StringSubstitution
 * JD-Core Version:    0.7.0.1
 */
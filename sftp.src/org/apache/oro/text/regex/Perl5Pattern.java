/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public final class Perl5Pattern
/*   6:    */   implements Pattern, Serializable, Cloneable
/*   7:    */ {
/*   8:    */   static final int _OPT_ANCH_BOL = 1;
/*   9:    */   static final int _OPT_ANCH_MBOL = 2;
/*  10:    */   static final int _OPT_SKIP = 4;
/*  11:    */   static final int _OPT_IMPLICIT = 8;
/*  12:    */   static final int _OPT_ANCH = 3;
/*  13:    */   String _expression;
/*  14:    */   char[] _program;
/*  15:    */   int _mustUtility;
/*  16:    */   int _back;
/*  17:    */   int _minLength;
/*  18:    */   int _numParentheses;
/*  19:    */   boolean _isCaseInsensitive;
/*  20:    */   boolean _isExpensive;
/*  21:    */   int _startClassOffset;
/*  22:    */   int _anchor;
/*  23:    */   int _options;
/*  24:    */   char[] _mustString;
/*  25:    */   char[] _startString;
/*  26:    */   
/*  27:    */   public String getPattern()
/*  28:    */   {
/*  29:123 */     return this._expression;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public int getOptions()
/*  33:    */   {
/*  34:132 */     return this._options;
/*  35:    */   }
/*  36:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Perl5Pattern
 * JD-Core Version:    0.7.0.1
 */
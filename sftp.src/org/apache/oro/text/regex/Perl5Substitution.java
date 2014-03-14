/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ import java.util.Vector;
/*   4:    */ 
/*   5:    */ public class Perl5Substitution
/*   6:    */   extends StringSubstitution
/*   7:    */ {
/*   8:    */   public static final int INTERPOLATE_ALL = 0;
/*   9:    */   public static final int INTERPOLATE_NONE = -1;
/*  10:    */   int _numInterpolations;
/*  11:    */   Vector _substitutions;
/*  12:    */   transient String _lastInterpolation;
/*  13:    */   
/*  14:    */   static Vector _parseSubs(String paramString)
/*  15:    */   {
/*  16:149 */     Vector localVector = new Vector(5);
/*  17:150 */     StringBuffer localStringBuffer1 = new StringBuffer(5);
/*  18:151 */     StringBuffer localStringBuffer2 = new StringBuffer(10);
/*  19:    */     
/*  20:153 */     char[] arrayOfChar = paramString.toCharArray();
/*  21:154 */     int k = 0;
/*  22:155 */     int i = 0;
/*  23:156 */     int j = 0;
/*  24:158 */     while (k < arrayOfChar.length)
/*  25:    */     {
/*  26:159 */       if ((i != 0) && (Character.isDigit(arrayOfChar[k])))
/*  27:    */       {
/*  28:160 */         localStringBuffer1.append(arrayOfChar[k]);
/*  29:162 */         if (localStringBuffer2.length() > 0)
/*  30:    */         {
/*  31:163 */           localVector.addElement(localStringBuffer2.toString());
/*  32:164 */           localStringBuffer2.setLength(0);
/*  33:    */         }
/*  34:    */       }
/*  35:    */       else
/*  36:    */       {
/*  37:167 */         if (i != 0)
/*  38:    */         {
/*  39:    */           try
/*  40:    */           {
/*  41:169 */             localVector.addElement(new Integer(localStringBuffer1.toString()));
/*  42:170 */             j = 1;
/*  43:    */           }
/*  44:    */           catch (NumberFormatException localNumberFormatException1)
/*  45:    */           {
/*  46:172 */             localVector.addElement(localStringBuffer1.toString());
/*  47:    */           }
/*  48:175 */           localStringBuffer1.setLength(0);
/*  49:176 */           i = 0;
/*  50:    */         }
/*  51:179 */         if ((arrayOfChar[k] == '$') && 
/*  52:180 */           (k + 1 < arrayOfChar.length) && (arrayOfChar[(k + 1)] != '0') && 
/*  53:181 */           (Character.isDigit(arrayOfChar[(k + 1)]))) {
/*  54:182 */           i = 1;
/*  55:    */         } else {
/*  56:184 */           localStringBuffer2.append(arrayOfChar[k]);
/*  57:    */         }
/*  58:    */       }
/*  59:187 */       k++;
/*  60:    */     }
/*  61:191 */     if (i != 0) {
/*  62:    */       try
/*  63:    */       {
/*  64:193 */         localVector.addElement(new Integer(localStringBuffer1.toString()));
/*  65:194 */         j = 1;
/*  66:    */       }
/*  67:    */       catch (NumberFormatException localNumberFormatException2)
/*  68:    */       {
/*  69:196 */         localVector.addElement(localStringBuffer1.toString());
/*  70:    */       }
/*  71:198 */     } else if (localStringBuffer2.length() > 0) {
/*  72:199 */       localVector.addElement(localStringBuffer2.toString());
/*  73:    */     }
/*  74:201 */     return j != 0 ? localVector : null;
/*  75:    */   }
/*  76:    */   
/*  77:    */   String _finalInterpolatedSub(MatchResult paramMatchResult)
/*  78:    */   {
/*  79:206 */     StringBuffer localStringBuffer = new StringBuffer(10);
/*  80:207 */     _calcSub(localStringBuffer, paramMatchResult);
/*  81:208 */     return localStringBuffer.toString();
/*  82:    */   }
/*  83:    */   
/*  84:    */   void _calcSub(StringBuffer paramStringBuffer, MatchResult paramMatchResult)
/*  85:    */   {
/*  86:217 */     int i = this._substitutions.size();
/*  87:219 */     for (int j = 0; j < i; j++)
/*  88:    */     {
/*  89:220 */       Object localObject = this._substitutions.elementAt(j);
/*  90:222 */       if ((localObject instanceof String))
/*  91:    */       {
/*  92:223 */         paramStringBuffer.append(localObject);
/*  93:    */       }
/*  94:    */       else
/*  95:    */       {
/*  96:225 */         Integer localInteger = (Integer)localObject;
/*  97:226 */         int k = localInteger.intValue();
/*  98:228 */         if ((k > 0) && (k < paramMatchResult.groups()))
/*  99:    */         {
/* 100:229 */           String str = paramMatchResult.group(k);
/* 101:231 */           if (str != null) {
/* 102:232 */             paramStringBuffer.append(str);
/* 103:    */           }
/* 104:    */         }
/* 105:    */         else
/* 106:    */         {
/* 107:234 */           paramStringBuffer.append('$');
/* 108:235 */           paramStringBuffer.append(k);
/* 109:    */         }
/* 110:    */       }
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Perl5Substitution()
/* 115:    */   {
/* 116:248 */     this("", 0);
/* 117:    */   }
/* 118:    */   
/* 119:    */   public Perl5Substitution(String paramString)
/* 120:    */   {
/* 121:259 */     this(paramString, 0);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public Perl5Substitution(String paramString, int paramInt)
/* 125:    */   {
/* 126:281 */     setSubstitution(paramString, paramInt);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setSubstitution(String paramString)
/* 130:    */   {
/* 131:296 */     setSubstitution(paramString, 0);
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setSubstitution(String paramString, int paramInt)
/* 135:    */   {
/* 136:322 */     super.setSubstitution(paramString);
/* 137:323 */     this._numInterpolations = paramInt;
/* 138:325 */     if ((paramInt != -1) && 
/* 139:326 */       (paramString.indexOf('$') != -1)) {
/* 140:327 */       this._substitutions = _parseSubs(paramString);
/* 141:    */     } else {
/* 142:329 */       this._substitutions = null;
/* 143:    */     }
/* 144:330 */     this._lastInterpolation = null;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void appendSubstitution(StringBuffer paramStringBuffer, MatchResult paramMatchResult, int paramInt, String paramString, PatternMatcher paramPatternMatcher, Pattern paramPattern)
/* 148:    */   {
/* 149:355 */     if (this._substitutions == null)
/* 150:    */     {
/* 151:356 */       super.appendSubstitution(paramStringBuffer, paramMatchResult, paramInt, 
/* 152:357 */         paramString, paramPatternMatcher, paramPattern);
/* 153:358 */       return;
/* 154:    */     }
/* 155:361 */     if ((this._numInterpolations < 1) || (paramInt < this._numInterpolations))
/* 156:    */     {
/* 157:362 */       _calcSub(paramStringBuffer, paramMatchResult);
/* 158:    */     }
/* 159:    */     else
/* 160:    */     {
/* 161:364 */       if (paramInt == this._numInterpolations) {
/* 162:365 */         this._lastInterpolation = _finalInterpolatedSub(paramMatchResult);
/* 163:    */       }
/* 164:366 */       paramStringBuffer.append(this._lastInterpolation);
/* 165:    */     }
/* 166:    */   }
/* 167:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Perl5Substitution
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.MalformedPatternException;
/*   4:    */ import org.apache.oro.text.regex.Pattern;
/*   5:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   6:    */ import org.apache.oro.text.regex.Perl5Compiler;
/*   7:    */ 
/*   8:    */ public final class GlobCompiler
/*   9:    */   implements PatternCompiler
/*  10:    */ {
/*  11:    */   public static final int DEFAULT_MASK = 0;
/*  12:    */   public static final int CASE_INSENSITIVE_MASK = 1;
/*  13:    */   public static final int STAR_CANNOT_MATCH_NULL_MASK = 2;
/*  14:    */   public static final int QUESTION_MATCHES_ZERO_OR_ONE_MASK = 4;
/*  15:    */   
/*  16:    */   private static boolean __isPerl5MetaCharacter(char paramChar)
/*  17:    */   {
/*  18:151 */     return (paramChar == '*') || (paramChar == '?') || (paramChar == '+') || (paramChar == '[') || (paramChar == ']') || 
/*  19:152 */       (paramChar == '(') || (paramChar == ')') || (paramChar == '|') || (paramChar == '^') || (paramChar == '$') || 
/*  20:153 */       (paramChar == '.') || (paramChar == '{') || (paramChar == '}') || (paramChar == '\\');
/*  21:    */   }
/*  22:    */   
/*  23:    */   private static boolean __isGlobMetaCharacter(char paramChar)
/*  24:    */   {
/*  25:157 */     return (paramChar == '*') || (paramChar == '?') || (paramChar == '[') || (paramChar == ']');
/*  26:    */   }
/*  27:    */   
/*  28:    */   public static String globToPerl5(char[] paramArrayOfChar, int paramInt)
/*  29:    */   {
/*  30:175 */     int j = 0;
/*  31:    */     
/*  32:    */ 
/*  33:    */ 
/*  34:179 */     StringBuffer localStringBuffer = new StringBuffer(2 * paramArrayOfChar.length);
/*  35:180 */     int i = 0;
/*  36:    */     
/*  37:182 */     int k = (paramInt & 0x4) == 0 ? 0 : 1;
/*  38:183 */     j = (paramInt & 0x2) == 0 ? 0 : 1;
/*  39:185 */     for (int m = 0; m < paramArrayOfChar.length; m++) {
/*  40:186 */       switch (paramArrayOfChar[m])
/*  41:    */       {
/*  42:    */       case '*': 
/*  43:188 */         if (i != 0) {
/*  44:189 */           localStringBuffer.append('*');
/*  45:191 */         } else if (j != 0) {
/*  46:192 */           localStringBuffer.append(".+");
/*  47:    */         } else {
/*  48:194 */           localStringBuffer.append(".*");
/*  49:    */         }
/*  50:196 */         break;
/*  51:    */       case '?': 
/*  52:198 */         if (i != 0) {
/*  53:199 */           localStringBuffer.append('?');
/*  54:201 */         } else if (k != 0) {
/*  55:202 */           localStringBuffer.append(".?");
/*  56:    */         } else {
/*  57:204 */           localStringBuffer.append('.');
/*  58:    */         }
/*  59:206 */         break;
/*  60:    */       case '[': 
/*  61:208 */         i = 1;
/*  62:209 */         localStringBuffer.append(paramArrayOfChar[m]);
/*  63:211 */         if (m + 1 < paramArrayOfChar.length) {
/*  64:212 */           switch (paramArrayOfChar[(m + 1)])
/*  65:    */           {
/*  66:    */           case '!': 
/*  67:    */           case '^': 
/*  68:215 */             localStringBuffer.append('^');
/*  69:216 */             m++;
/*  70:217 */             break;
/*  71:    */           case ']': 
/*  72:219 */             localStringBuffer.append(']');
/*  73:220 */             m++;
/*  74:    */           }
/*  75:    */         }
/*  76:221 */         break;
/*  77:    */       case ']': 
/*  78:226 */         i = 0;
/*  79:227 */         localStringBuffer.append(paramArrayOfChar[m]);
/*  80:228 */         break;
/*  81:    */       case '\\': 
/*  82:230 */         localStringBuffer.append('\\');
/*  83:231 */         if (m == paramArrayOfChar.length - 1) {
/*  84:232 */           localStringBuffer.append('\\');
/*  85:233 */         } else if (__isGlobMetaCharacter(paramArrayOfChar[(m + 1)])) {
/*  86:234 */           localStringBuffer.append(paramArrayOfChar[(++m)]);
/*  87:    */         } else {
/*  88:236 */           localStringBuffer.append('\\');
/*  89:    */         }
/*  90:237 */         break;
/*  91:    */       default: 
/*  92:239 */         if ((i == 0) && (__isPerl5MetaCharacter(paramArrayOfChar[m]))) {
/*  93:240 */           localStringBuffer.append('\\');
/*  94:    */         }
/*  95:241 */         localStringBuffer.append(paramArrayOfChar[m]);
/*  96:    */       }
/*  97:    */     }
/*  98:246 */     return localStringBuffer.toString();
/*  99:    */   }
/* 100:    */   
/* 101:255 */   private Perl5Compiler __perl5Compiler = new Perl5Compiler();
/* 102:    */   
/* 103:    */   public Pattern compile(char[] paramArrayOfChar, int paramInt)
/* 104:    */     throws MalformedPatternException
/* 105:    */   {
/* 106:286 */     int i = 0;
/* 107:287 */     if ((paramInt & 0x1) != 0) {
/* 108:288 */       i |= 0x1;
/* 109:    */     }
/* 110:289 */     return this.__perl5Compiler.compile(globToPerl5(paramArrayOfChar, paramInt), i);
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Pattern compile(char[] paramArrayOfChar)
/* 114:    */     throws MalformedPatternException
/* 115:    */   {
/* 116:303 */     return compile(paramArrayOfChar, 0);
/* 117:    */   }
/* 118:    */   
/* 119:    */   public Pattern compile(String paramString)
/* 120:    */     throws MalformedPatternException
/* 121:    */   {
/* 122:317 */     return compile(paramString.toCharArray(), 0);
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Pattern compile(String paramString, int paramInt)
/* 126:    */     throws MalformedPatternException
/* 127:    */   {
/* 128:347 */     return compile(paramString.toCharArray(), paramInt);
/* 129:    */   }
/* 130:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.GlobCompiler
 * JD-Core Version:    0.7.0.1
 */
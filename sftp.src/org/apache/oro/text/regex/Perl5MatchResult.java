/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ final class Perl5MatchResult
/*   4:    */   implements MatchResult
/*   5:    */ {
/*   6:    */   int _matchBeginOffset;
/*   7:    */   int[] _beginGroupOffset;
/*   8:    */   int[] _endGroupOffset;
/*   9:    */   String _match;
/*  10:    */   
/*  11:    */   Perl5MatchResult(int paramInt)
/*  12:    */   {
/*  13:115 */     this._beginGroupOffset = new int[paramInt];
/*  14:116 */     this._endGroupOffset = new int[paramInt];
/*  15:    */   }
/*  16:    */   
/*  17:    */   public int length()
/*  18:    */   {
/*  19:124 */     return this._match.length();
/*  20:    */   }
/*  21:    */   
/*  22:    */   public int groups()
/*  23:    */   {
/*  24:135 */     return this._beginGroupOffset.length;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public String group(int paramInt)
/*  28:    */   {
/*  29:149 */     if (paramInt < this._beginGroupOffset.length)
/*  30:    */     {
/*  31:150 */       int i = this._beginGroupOffset[paramInt];
/*  32:151 */       int j = this._endGroupOffset[paramInt];
/*  33:152 */       int k = this._match.length();
/*  34:154 */       if ((i >= 0) && (j >= 0))
/*  35:    */       {
/*  36:155 */         if ((i < k) && (j <= k) && (j > i)) {
/*  37:156 */           return this._match.substring(i, j);
/*  38:    */         }
/*  39:157 */         if (i <= j) {
/*  40:158 */           return "";
/*  41:    */         }
/*  42:    */       }
/*  43:    */     }
/*  44:162 */     return null;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public int begin(int paramInt)
/*  48:    */   {
/*  49:173 */     if (paramInt < this._beginGroupOffset.length)
/*  50:    */     {
/*  51:174 */       int i = this._beginGroupOffset[paramInt];
/*  52:175 */       int j = this._endGroupOffset[paramInt];
/*  53:177 */       if ((i >= 0) && (j >= 0)) {
/*  54:179 */         return i;
/*  55:    */       }
/*  56:    */     }
/*  57:182 */     return -1;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public int end(int paramInt)
/*  61:    */   {
/*  62:194 */     if (paramInt < this._beginGroupOffset.length)
/*  63:    */     {
/*  64:195 */       int i = this._beginGroupOffset[paramInt];
/*  65:196 */       int j = this._endGroupOffset[paramInt];
/*  66:198 */       if ((i >= 0) && (j >= 0)) {
/*  67:200 */         return j;
/*  68:    */       }
/*  69:    */     }
/*  70:202 */     return -1;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public int beginOffset(int paramInt)
/*  74:    */   {
/*  75:216 */     if (paramInt < this._beginGroupOffset.length)
/*  76:    */     {
/*  77:217 */       int i = this._beginGroupOffset[paramInt];
/*  78:218 */       int j = this._endGroupOffset[paramInt];
/*  79:220 */       if ((i >= 0) && (j >= 0)) {
/*  80:222 */         return this._matchBeginOffset + i;
/*  81:    */       }
/*  82:    */     }
/*  83:224 */     return -1;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int endOffset(int paramInt)
/*  87:    */   {
/*  88:239 */     if (paramInt < this._endGroupOffset.length)
/*  89:    */     {
/*  90:240 */       int i = this._beginGroupOffset[paramInt];
/*  91:241 */       int j = this._endGroupOffset[paramInt];
/*  92:243 */       if ((i >= 0) && (j >= 0)) {
/*  93:245 */         return this._matchBeginOffset + j;
/*  94:    */       }
/*  95:    */     }
/*  96:247 */     return -1;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String toString()
/* 100:    */   {
/* 101:257 */     return group(0);
/* 102:    */   }
/* 103:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Perl5MatchResult
 * JD-Core Version:    0.7.0.1
 */
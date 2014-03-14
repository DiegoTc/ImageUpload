/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ public final class PatternMatcherInput
/*   4:    */ {
/*   5:124 */   int _matchEndOffset = -1;
/*   6:124 */   int _matchBeginOffset = -1;
/*   7:    */   int _currentOffset;
/*   8:    */   int _endOffset;
/*   9:    */   int _beginOffset;
/*  10:    */   char[] _toLowerBuffer;
/*  11:    */   char[] _originalBuffer;
/*  12:    */   char[] _originalCharInput;
/*  13:    */   String _originalStringInput;
/*  14:    */   
/*  15:    */   public PatternMatcherInput(String paramString, int paramInt1, int paramInt2)
/*  16:    */   {
/*  17:141 */     setInput(paramString, paramInt1, paramInt2);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public PatternMatcherInput(String paramString)
/*  21:    */   {
/*  22:153 */     this(paramString, 0, paramString.length());
/*  23:    */   }
/*  24:    */   
/*  25:    */   public PatternMatcherInput(char[] paramArrayOfChar, int paramInt1, int paramInt2)
/*  26:    */   {
/*  27:173 */     setInput(paramArrayOfChar, paramInt1, paramInt2);
/*  28:    */   }
/*  29:    */   
/*  30:    */   public PatternMatcherInput(char[] paramArrayOfChar)
/*  31:    */   {
/*  32:185 */     this(paramArrayOfChar, 0, paramArrayOfChar.length);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public int length()
/*  36:    */   {
/*  37:195 */     return this._endOffset - this._beginOffset;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setInput(String paramString, int paramInt1, int paramInt2)
/*  41:    */   {
/*  42:213 */     this._originalStringInput = paramString;
/*  43:214 */     this._originalCharInput = null;
/*  44:215 */     this._toLowerBuffer = null;
/*  45:216 */     this._originalBuffer = paramString.toCharArray();
/*  46:217 */     setCurrentOffset(paramInt1);
/*  47:218 */     setBeginOffset(paramInt1);
/*  48:219 */     setEndOffset(this._beginOffset + paramInt2);
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setInput(String paramString)
/*  52:    */   {
/*  53:231 */     setInput(paramString, 0, paramString.length());
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setInput(char[] paramArrayOfChar, int paramInt1, int paramInt2)
/*  57:    */   {
/*  58:250 */     this._originalStringInput = null;
/*  59:251 */     this._toLowerBuffer = null;
/*  60:252 */     this._originalBuffer = (this._originalCharInput = paramArrayOfChar);
/*  61:253 */     setCurrentOffset(paramInt1);
/*  62:254 */     setBeginOffset(paramInt1);
/*  63:255 */     setEndOffset(this._beginOffset + paramInt2);
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setInput(char[] paramArrayOfChar)
/*  67:    */   {
/*  68:268 */     setInput(paramArrayOfChar, 0, paramArrayOfChar.length);
/*  69:    */   }
/*  70:    */   
/*  71:    */   public char charAt(int paramInt)
/*  72:    */   {
/*  73:283 */     return this._originalBuffer[(this._beginOffset + paramInt)];
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String substring(int paramInt1, int paramInt2)
/*  77:    */   {
/*  78:301 */     return new String(this._originalBuffer, this._beginOffset + paramInt1, 
/*  79:302 */       paramInt2 - paramInt1);
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String substring(int paramInt)
/*  83:    */   {
/*  84:318 */     paramInt += this._beginOffset;
/*  85:319 */     return new String(this._originalBuffer, paramInt, this._endOffset - paramInt);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Object getInput()
/*  89:    */   {
/*  90:334 */     if (this._originalStringInput == null) {
/*  91:335 */       return this._originalCharInput;
/*  92:    */     }
/*  93:336 */     return this._originalStringInput;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public char[] getBuffer()
/*  97:    */   {
/*  98:347 */     return this._originalBuffer;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public boolean endOfInput()
/* 102:    */   {
/* 103:355 */     return this._currentOffset >= this._endOffset;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public int getBeginOffset()
/* 107:    */   {
/* 108:363 */     return this._beginOffset;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public int getEndOffset()
/* 112:    */   {
/* 113:371 */     return this._endOffset;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public int getCurrentOffset()
/* 117:    */   {
/* 118:378 */     return this._currentOffset;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setBeginOffset(int paramInt)
/* 122:    */   {
/* 123:388 */     this._beginOffset = paramInt;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setEndOffset(int paramInt)
/* 127:    */   {
/* 128:398 */     this._endOffset = paramInt;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setCurrentOffset(int paramInt)
/* 132:    */   {
/* 133:411 */     this._currentOffset = paramInt;
/* 134:412 */     setMatchOffsets(-1, -1);
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String toString()
/* 138:    */   {
/* 139:422 */     return new String(this._originalBuffer, this._beginOffset, length());
/* 140:    */   }
/* 141:    */   
/* 142:    */   public String preMatch()
/* 143:    */   {
/* 144:434 */     return new String(this._originalBuffer, this._beginOffset, 
/* 145:435 */       this._matchBeginOffset - this._beginOffset);
/* 146:    */   }
/* 147:    */   
/* 148:    */   public String postMatch()
/* 149:    */   {
/* 150:447 */     return new String(this._originalBuffer, this._matchEndOffset, 
/* 151:448 */       this._endOffset - this._matchEndOffset);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String match()
/* 155:    */   {
/* 156:463 */     return new String(this._originalBuffer, this._matchBeginOffset, 
/* 157:464 */       this._matchEndOffset - this._matchBeginOffset);
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setMatchOffsets(int paramInt1, int paramInt2)
/* 161:    */   {
/* 162:485 */     this._matchBeginOffset = paramInt1;
/* 163:486 */     this._matchEndOffset = paramInt2;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public int getMatchBeginOffset()
/* 167:    */   {
/* 168:495 */     return this._matchBeginOffset;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public int getMatchEndOffset()
/* 172:    */   {
/* 173:502 */     return this._matchEndOffset;
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.PatternMatcherInput
 * JD-Core Version:    0.7.0.1
 */
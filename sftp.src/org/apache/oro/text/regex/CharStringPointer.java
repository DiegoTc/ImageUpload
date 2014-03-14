/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ final class CharStringPointer
/*   4:    */ {
/*   5:    */   static final char _END_OF_STRING = 'èøø';
/*   6:    */   int _offset;
/*   7:    */   char[] _array;
/*   8:    */   
/*   9:    */   CharStringPointer(char[] paramArrayOfChar, int paramInt)
/*  10:    */   {
/*  11: 75 */     this._array = paramArrayOfChar;
/*  12: 76 */     this._offset = paramInt;
/*  13:    */   }
/*  14:    */   
/*  15:    */   CharStringPointer(char[] paramArrayOfChar)
/*  16:    */   {
/*  17: 80 */     this(paramArrayOfChar, 0);
/*  18:    */   }
/*  19:    */   
/*  20:    */   char _getValue()
/*  21:    */   {
/*  22: 84 */     return _getValue(this._offset);
/*  23:    */   }
/*  24:    */   
/*  25:    */   char _getValue(int paramInt)
/*  26:    */   {
/*  27: 88 */     if ((paramInt < this._array.length) && (paramInt >= 0)) {
/*  28: 89 */       return this._array[paramInt];
/*  29:    */     }
/*  30: 90 */     return 65535;
/*  31:    */   }
/*  32:    */   
/*  33:    */   char _getValueRelative(int paramInt)
/*  34:    */   {
/*  35: 94 */     return _getValue(this._offset + paramInt);
/*  36:    */   }
/*  37:    */   
/*  38:    */   int _getLength()
/*  39:    */   {
/*  40: 97 */     return this._array.length;
/*  41:    */   }
/*  42:    */   
/*  43:    */   int _getOffset()
/*  44:    */   {
/*  45: 99 */     return this._offset;
/*  46:    */   }
/*  47:    */   
/*  48:    */   void _setOffset(int paramInt)
/*  49:    */   {
/*  50:101 */     this._offset = paramInt;
/*  51:    */   }
/*  52:    */   
/*  53:    */   boolean _isAtEnd()
/*  54:    */   {
/*  55:104 */     return this._offset >= this._array.length;
/*  56:    */   }
/*  57:    */   
/*  58:    */   char _increment(int paramInt)
/*  59:    */   {
/*  60:108 */     this._offset += paramInt;
/*  61:109 */     if (_isAtEnd())
/*  62:    */     {
/*  63:110 */       this._offset = this._array.length;
/*  64:111 */       return 65535;
/*  65:    */     }
/*  66:114 */     return this._array[this._offset];
/*  67:    */   }
/*  68:    */   
/*  69:    */   char _increment()
/*  70:    */   {
/*  71:117 */     return _increment(1);
/*  72:    */   }
/*  73:    */   
/*  74:    */   char _decrement(int paramInt)
/*  75:    */   {
/*  76:120 */     this._offset -= paramInt;
/*  77:121 */     if (this._offset < 0) {
/*  78:122 */       this._offset = 0;
/*  79:    */     }
/*  80:124 */     return this._array[this._offset];
/*  81:    */   }
/*  82:    */   
/*  83:    */   char _decrement()
/*  84:    */   {
/*  85:127 */     return _decrement(1);
/*  86:    */   }
/*  87:    */   
/*  88:    */   char _postIncrement()
/*  89:    */   {
/*  90:131 */     char c = _getValue();
/*  91:132 */     _increment();
/*  92:133 */     return c;
/*  93:    */   }
/*  94:    */   
/*  95:    */   char _postDecrement()
/*  96:    */   {
/*  97:138 */     char c = _getValue();
/*  98:139 */     _decrement();
/*  99:140 */     return c;
/* 100:    */   }
/* 101:    */   
/* 102:    */   String _toString(int paramInt)
/* 103:    */   {
/* 104:145 */     return new String(this._array, paramInt, this._array.length - paramInt);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String toString()
/* 108:    */   {
/* 109:149 */     return _toString(0);
/* 110:    */   }
/* 111:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.CharStringPointer
 * JD-Core Version:    0.7.0.1
 */
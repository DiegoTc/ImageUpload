/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ final class OpCode
/*   4:    */ {
/*   5:    */   static final char _END = '\000';
/*   6:    */   static final char _BOL = '\001';
/*   7:    */   static final char _MBOL = '\002';
/*   8:    */   static final char _SBOL = '\003';
/*   9:    */   static final char _EOL = '\004';
/*  10:    */   static final char _MEOL = '\005';
/*  11:    */   static final char _SEOL = '\006';
/*  12:    */   static final char _ANY = '\007';
/*  13:    */   static final char _SANY = '\b';
/*  14:    */   static final char _ANYOF = '\t';
/*  15:    */   static final char _CURLY = '\n';
/*  16:    */   static final char _CURLYX = '\013';
/*  17:    */   static final char _BRANCH = '\f';
/*  18:    */   static final char _BACK = '\r';
/*  19:    */   static final char _EXACTLY = '\016';
/*  20:    */   static final char _NOTHING = '\017';
/*  21:    */   static final char _STAR = '\020';
/*  22:    */   static final char _PLUS = '\021';
/*  23:    */   static final char _ALNUM = '\022';
/*  24:    */   static final char _NALNUM = '\023';
/*  25:    */   static final char _BOUND = '\024';
/*  26:    */   static final char _NBOUND = '\025';
/*  27:    */   static final char _SPACE = '\026';
/*  28:    */   static final char _NSPACE = '\027';
/*  29:    */   static final char _DIGIT = '\030';
/*  30:    */   static final char _NDIGIT = '\031';
/*  31:    */   static final char _REF = '\032';
/*  32:    */   static final char _OPEN = '\033';
/*  33:    */   static final char _CLOSE = '\034';
/*  34:    */   static final char _MINMOD = '\035';
/*  35:    */   static final char _GBOL = '\036';
/*  36:    */   static final char _IFMATCH = '\037';
/*  37:    */   static final char _UNLESSM = ' ';
/*  38:    */   static final char _SUCCEED = '!';
/*  39:    */   static final char _WHILEM = '"';
/*  40:113 */   static final int[] _operandLength = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
/*  41:114 */     2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
/*  42:115 */     1, 1, 1 };
/*  43:118 */   static final char[] _opType = { '\000', 
/*  44:119 */     '\001', '\001', '\001', '\004', '\004', '\004', '\007', '\007', '\t', '\n', 
/*  45:120 */     '\n', '\f', '\r', '\016', '\017', '\020', '\021', '\022', 
/*  46:121 */     '\023', '\024', '\025', '\026', '\027', '\030', '\031', '\032', 
/*  47:122 */     '\033', '\034', '\035', '\001', '\f', '\f', '\000''"' };
/*  48:125 */   static final char[] _opLengthVaries = {
/*  49:126 */     '\f', '\r', '\020', '\021', '\n', '\013', '\032', '"' };
/*  50:129 */   static final char[] _opLengthOne = {
/*  51:130 */     '\007', '\b', '\t', '\022', '\023', '\026', '\027', '\030', '\031' };
/*  52:    */   static final int _NULL_OFFSET = -1;
/*  53:    */   static final char _NULL_POINTER = '\000';
/*  54:    */   
/*  55:    */   static final int _getNextOffset(char[] paramArrayOfChar, int paramInt)
/*  56:    */   {
/*  57:137 */     return paramArrayOfChar[(paramInt + 1)];
/*  58:    */   }
/*  59:    */   
/*  60:    */   static final char _getArg1(char[] paramArrayOfChar, int paramInt)
/*  61:    */   {
/*  62:141 */     return paramArrayOfChar[(paramInt + 2)];
/*  63:    */   }
/*  64:    */   
/*  65:    */   static final char _getArg2(char[] paramArrayOfChar, int paramInt)
/*  66:    */   {
/*  67:145 */     return paramArrayOfChar[(paramInt + 3)];
/*  68:    */   }
/*  69:    */   
/*  70:    */   static final int _getOperand(int paramInt)
/*  71:    */   {
/*  72:149 */     return paramInt + 2;
/*  73:    */   }
/*  74:    */   
/*  75:    */   static final boolean _isInArray(char paramChar, char[] paramArrayOfChar, int paramInt)
/*  76:    */   {
/*  77:153 */     while (paramInt < paramArrayOfChar.length) {
/*  78:154 */       if (paramChar == paramArrayOfChar[(paramInt++)]) {
/*  79:155 */         return true;
/*  80:    */       }
/*  81:    */     }
/*  82:156 */     return false;
/*  83:    */   }
/*  84:    */   
/*  85:    */   static final int _getNextOperator(int paramInt)
/*  86:    */   {
/*  87:159 */     return paramInt + 2;
/*  88:    */   }
/*  89:    */   
/*  90:    */   static final int _getPrevOperator(int paramInt)
/*  91:    */   {
/*  92:160 */     return paramInt - 2;
/*  93:    */   }
/*  94:    */   
/*  95:    */   static final int _getNext(char[] paramArrayOfChar, int paramInt)
/*  96:    */   {
/*  97:165 */     if (paramArrayOfChar == null) {
/*  98:166 */       return -1;
/*  99:    */     }
/* 100:169 */     int i = _getNextOffset(paramArrayOfChar, paramInt);
/* 101:170 */     if (i == 0) {
/* 102:171 */       return -1;
/* 103:    */     }
/* 104:173 */     if (paramArrayOfChar[paramInt] == '\r') {
/* 105:174 */       return paramInt - i;
/* 106:    */     }
/* 107:176 */     return paramInt + i;
/* 108:    */   }
/* 109:    */   
/* 110:    */   static final boolean _isWordCharacter(char paramChar)
/* 111:    */   {
/* 112:182 */     return ((paramChar >= 'a') && (paramChar <= 'z')) || 
/* 113:183 */       ((paramChar >= 'A') && (paramChar <= 'Z')) || 
/* 114:184 */       ((paramChar >= '0') && (paramChar <= '9')) || 
/* 115:185 */       (paramChar == '_');
/* 116:    */   }
/* 117:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.OpCode
 * JD-Core Version:    0.7.0.1
 */
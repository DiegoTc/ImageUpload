/*   1:    */ package org.apache.oro.text.regex;
/*   2:    */ 
/*   3:    */ public final class Perl5Debug
/*   4:    */ {
/*   5:    */   public static String printProgram(Perl5Pattern paramPerl5Pattern)
/*   6:    */   {
/*   7:103 */     int i = 27;
/*   8:    */     
/*   9:    */ 
/*  10:106 */     char[] arrayOfChar = paramPerl5Pattern._program;
/*  11:107 */     int j = 1;
/*  12:108 */     StringBuffer localStringBuffer = new StringBuffer();
/*  13:110 */     while (i != 0)
/*  14:    */     {
/*  15:111 */       i = arrayOfChar[j];
/*  16:112 */       localStringBuffer.append(j);
/*  17:113 */       _printOperator(arrayOfChar, j, localStringBuffer);
/*  18:    */       
/*  19:115 */       int k = OpCode._getNext(arrayOfChar, j);
/*  20:116 */       j += OpCode._operandLength[i];
/*  21:    */       
/*  22:118 */       localStringBuffer.append("(" + k + ")");
/*  23:    */       
/*  24:120 */       j += 2;
/*  25:122 */       if (i == 9)
/*  26:    */       {
/*  27:123 */         j += 16;
/*  28:    */       }
/*  29:124 */       else if (i == 14)
/*  30:    */       {
/*  31:125 */         j++;
/*  32:126 */         localStringBuffer.append(" <");
/*  33:129 */         while (arrayOfChar[j] != 65535)
/*  34:    */         {
/*  35:132 */           localStringBuffer.append(arrayOfChar[j]);
/*  36:133 */           j++;
/*  37:    */         }
/*  38:135 */         localStringBuffer.append(">");
/*  39:136 */         j++;
/*  40:    */       }
/*  41:139 */       localStringBuffer.append('\n');
/*  42:    */     }
/*  43:143 */     if (paramPerl5Pattern._startString != null) {
/*  44:144 */       localStringBuffer.append("start `" + new String(paramPerl5Pattern._startString) + "' ");
/*  45:    */     }
/*  46:145 */     if (paramPerl5Pattern._startClassOffset != -1)
/*  47:    */     {
/*  48:146 */       localStringBuffer.append("stclass `");
/*  49:147 */       _printOperator(arrayOfChar, paramPerl5Pattern._startClassOffset, localStringBuffer);
/*  50:148 */       localStringBuffer.append("' ");
/*  51:    */     }
/*  52:150 */     if ((paramPerl5Pattern._anchor & 0x3) != 0) {
/*  53:151 */       localStringBuffer.append("anchored ");
/*  54:    */     }
/*  55:152 */     if ((paramPerl5Pattern._anchor & 0x4) != 0) {
/*  56:153 */       localStringBuffer.append("plus ");
/*  57:    */     }
/*  58:154 */     if ((paramPerl5Pattern._anchor & 0x8) != 0) {
/*  59:155 */       localStringBuffer.append("implicit ");
/*  60:    */     }
/*  61:156 */     if (paramPerl5Pattern._mustString != null) {
/*  62:157 */       localStringBuffer.append("must have \"" + new String(paramPerl5Pattern._mustString) + 
/*  63:158 */         "\" back " + paramPerl5Pattern._back + " ");
/*  64:    */     }
/*  65:159 */     localStringBuffer.append("minlen " + paramPerl5Pattern._minLength + '\n');
/*  66:    */     
/*  67:161 */     return localStringBuffer.toString();
/*  68:    */   }
/*  69:    */   
/*  70:    */   static void _printOperator(char[] paramArrayOfChar, int paramInt, StringBuffer paramStringBuffer)
/*  71:    */   {
/*  72:166 */     String str = null;
/*  73:    */     
/*  74:168 */     paramStringBuffer.append(":");
/*  75:170 */     switch (paramArrayOfChar[paramInt])
/*  76:    */     {
/*  77:    */     case '\001': 
/*  78:171 */       str = "BOL"; break;
/*  79:    */     case '\002': 
/*  80:172 */       str = "MBOL"; break;
/*  81:    */     case '\003': 
/*  82:173 */       str = "SBOL"; break;
/*  83:    */     case '\004': 
/*  84:174 */       str = "EOL"; break;
/*  85:    */     case '\005': 
/*  86:175 */       str = "MEOL"; break;
/*  87:    */     case '\007': 
/*  88:176 */       str = "ANY"; break;
/*  89:    */     case '\b': 
/*  90:177 */       str = "SANY"; break;
/*  91:    */     case '\t': 
/*  92:178 */       str = "ANYOF"; break;
/*  93:    */     case '\f': 
/*  94:193 */       str = "BRANCH"; break;
/*  95:    */     case '\016': 
/*  96:194 */       str = "EXACTLY"; break;
/*  97:    */     case '\017': 
/*  98:195 */       str = "NOTHING"; break;
/*  99:    */     case '\r': 
/* 100:196 */       str = "BACK"; break;
/* 101:    */     case '\000': 
/* 102:197 */       str = "END"; break;
/* 103:    */     case '\022': 
/* 104:198 */       str = "ALNUM"; break;
/* 105:    */     case '\023': 
/* 106:199 */       str = "NALNUM"; break;
/* 107:    */     case '\024': 
/* 108:200 */       str = "BOUND"; break;
/* 109:    */     case '\025': 
/* 110:201 */       str = "NBOUND"; break;
/* 111:    */     case '\026': 
/* 112:202 */       str = "SPACE"; break;
/* 113:    */     case '\027': 
/* 114:203 */       str = "NSPACE"; break;
/* 115:    */     case '\030': 
/* 116:204 */       str = "DIGIT"; break;
/* 117:    */     case '\031': 
/* 118:205 */       str = "NDIGIT"; break;
/* 119:    */     case '\n': 
/* 120:207 */       paramStringBuffer.append("CURLY {");
/* 121:208 */       paramStringBuffer.append(OpCode._getArg1(paramArrayOfChar, paramInt));
/* 122:209 */       paramStringBuffer.append(',');paramStringBuffer.append(OpCode._getArg2(paramArrayOfChar, paramInt));
/* 123:210 */       paramStringBuffer.append('}');
/* 124:211 */       break;
/* 125:    */     case '\013': 
/* 126:213 */       paramStringBuffer.append("CURLYX {");
/* 127:214 */       paramStringBuffer.append(OpCode._getArg1(paramArrayOfChar, paramInt));
/* 128:215 */       paramStringBuffer.append(',');paramStringBuffer.append(OpCode._getArg2(paramArrayOfChar, paramInt));
/* 129:216 */       paramStringBuffer.append('}');
/* 130:217 */       break;
/* 131:    */     case '\032': 
/* 132:219 */       paramStringBuffer.append("REF");paramStringBuffer.append(OpCode._getArg1(paramArrayOfChar, paramInt));
/* 133:220 */       break;
/* 134:    */     case '\033': 
/* 135:222 */       paramStringBuffer.append("OPEN");paramStringBuffer.append(OpCode._getArg1(paramArrayOfChar, paramInt));
/* 136:223 */       break;
/* 137:    */     case '\034': 
/* 138:225 */       paramStringBuffer.append("CLOSE");paramStringBuffer.append(OpCode._getArg1(paramArrayOfChar, paramInt));
/* 139:226 */       break;
/* 140:    */     case '\020': 
/* 141:227 */       str = "STAR"; break;
/* 142:    */     case '\021': 
/* 143:228 */       str = "PLUS"; break;
/* 144:    */     case '\035': 
/* 145:229 */       str = "MINMOD"; break;
/* 146:    */     case '\036': 
/* 147:230 */       str = "GBOL"; break;
/* 148:    */     case ' ': 
/* 149:231 */       str = "UNLESSM"; break;
/* 150:    */     case '\037': 
/* 151:232 */       str = "IFMATCH"; break;
/* 152:    */     case '!': 
/* 153:233 */       str = "SUCCEED"; break;
/* 154:    */     case '"': 
/* 155:234 */       str = "WHILEM"; break;
/* 156:    */     case '\006': 
/* 157:    */     default: 
/* 158:236 */       paramStringBuffer.append("Operator is unrecognized.  Faulty expression code!");
/* 159:    */     }
/* 160:240 */     if (str != null) {
/* 161:241 */       paramStringBuffer.append(str);
/* 162:    */     }
/* 163:    */   }
/* 164:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Perl5Debug
 * JD-Core Version:    0.7.0.1
 */
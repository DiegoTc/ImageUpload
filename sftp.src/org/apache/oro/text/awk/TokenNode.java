/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ class TokenNode
/*  4:   */   extends LeafNode
/*  5:   */ {
/*  6:   */   char _token;
/*  7:   */   
/*  8:   */   TokenNode(char paramChar, int paramInt)
/*  9:   */   {
/* 10:68 */     super(paramInt);
/* 11:69 */     this._token = paramChar;
/* 12:   */   }
/* 13:   */   
/* 14:   */   boolean _matches(char paramChar)
/* 15:   */   {
/* 16:72 */     return this._token == paramChar;
/* 17:   */   }
/* 18:   */   
/* 19:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 20:   */   {
/* 21:75 */     int tmp10_9 = 0; int[] tmp10_8 = paramArrayOfInt; int tmp12_11 = tmp10_8[tmp10_9];tmp10_8[tmp10_9] = (tmp12_11 + 1);return new TokenNode(this._token, tmp12_11);
/* 22:   */   }
/* 23:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.TokenNode
 * JD-Core Version:    0.7.0.1
 */
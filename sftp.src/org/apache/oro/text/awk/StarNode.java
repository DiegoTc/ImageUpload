/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ import java.util.BitSet;
/*  4:   */ 
/*  5:   */ class StarNode
/*  6:   */   extends SyntaxNode
/*  7:   */ {
/*  8:   */   SyntaxNode _left;
/*  9:   */   
/* 10:   */   StarNode(SyntaxNode paramSyntaxNode)
/* 11:   */   {
/* 12:70 */     this._left = paramSyntaxNode;
/* 13:   */   }
/* 14:   */   
/* 15:   */   boolean _nullable()
/* 16:   */   {
/* 17:73 */     return true;
/* 18:   */   }
/* 19:   */   
/* 20:   */   BitSet _firstPosition()
/* 21:   */   {
/* 22:75 */     return this._left._firstPosition();
/* 23:   */   }
/* 24:   */   
/* 25:   */   BitSet _lastPosition()
/* 26:   */   {
/* 27:77 */     return this._left._lastPosition();
/* 28:   */   }
/* 29:   */   
/* 30:   */   void _followPosition(BitSet[] paramArrayOfBitSet, SyntaxNode[] paramArrayOfSyntaxNode)
/* 31:   */   {
/* 32:83 */     this._left._followPosition(paramArrayOfBitSet, paramArrayOfSyntaxNode);
/* 33:   */     
/* 34:85 */     BitSet localBitSet1 = _lastPosition();
/* 35:86 */     BitSet localBitSet2 = _firstPosition();
/* 36:87 */     int i = localBitSet1.size();
/* 37:89 */     while (i-- > 0) {
/* 38:90 */       if (localBitSet1.get(i)) {
/* 39:91 */         paramArrayOfBitSet[i].or(localBitSet2);
/* 40:   */       }
/* 41:   */     }
/* 42:   */   }
/* 43:   */   
/* 44:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 45:   */   {
/* 46:95 */     return new StarNode(this._left._clone(paramArrayOfInt));
/* 47:   */   }
/* 48:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.StarNode
 * JD-Core Version:    0.7.0.1
 */
/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ import java.util.BitSet;
/*  4:   */ 
/*  5:   */ final class EpsilonNode
/*  6:   */   extends SyntaxNode
/*  7:   */ {
/*  8:67 */   BitSet _positionSet = new BitSet(1);
/*  9:   */   
/* 10:   */   boolean _nullable()
/* 11:   */   {
/* 12:69 */     return true;
/* 13:   */   }
/* 14:   */   
/* 15:   */   BitSet _firstPosition()
/* 16:   */   {
/* 17:70 */     return this._positionSet;
/* 18:   */   }
/* 19:   */   
/* 20:   */   BitSet _lastPosition()
/* 21:   */   {
/* 22:71 */     return this._positionSet;
/* 23:   */   }
/* 24:   */   
/* 25:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 26:   */   {
/* 27:76 */     return new EpsilonNode();
/* 28:   */   }
/* 29:   */   
/* 30:   */   void _followPosition(BitSet[] paramArrayOfBitSet, SyntaxNode[] paramArrayOfSyntaxNode) {}
/* 31:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.EpsilonNode
 * JD-Core Version:    0.7.0.1
 */
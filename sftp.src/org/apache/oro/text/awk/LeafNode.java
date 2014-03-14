/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ import java.util.BitSet;
/*  4:   */ 
/*  5:   */ abstract class LeafNode
/*  6:   */   extends SyntaxNode
/*  7:   */ {
/*  8:   */   static final int _NUM_TOKENS = 256;
/*  9:   */   static final int _END_MARKER_TOKEN = 256;
/* 10:   */   protected int _position;
/* 11:   */   protected BitSet _positionSet;
/* 12:   */   
/* 13:   */   LeafNode(int paramInt)
/* 14:   */   {
/* 15:74 */     this._position = paramInt;
/* 16:75 */     this._positionSet = new BitSet(paramInt + 1);
/* 17:76 */     this._positionSet.set(paramInt);
/* 18:   */   }
/* 19:   */   
/* 20:   */   final boolean _nullable()
/* 21:   */   {
/* 22:80 */     return false;
/* 23:   */   }
/* 24:   */   
/* 25:   */   final BitSet _firstPosition()
/* 26:   */   {
/* 27:81 */     return this._positionSet;
/* 28:   */   }
/* 29:   */   
/* 30:   */   final BitSet _lastPosition()
/* 31:   */   {
/* 32:82 */     return this._positionSet;
/* 33:   */   }
/* 34:   */   
/* 35:   */   final void _followPosition(BitSet[] paramArrayOfBitSet, SyntaxNode[] paramArrayOfSyntaxNode)
/* 36:   */   {
/* 37:84 */     paramArrayOfSyntaxNode[this._position] = this;
/* 38:   */   }
/* 39:   */   
/* 40:   */   abstract boolean _matches(char paramChar);
/* 41:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.LeafNode
 * JD-Core Version:    0.7.0.1
 */
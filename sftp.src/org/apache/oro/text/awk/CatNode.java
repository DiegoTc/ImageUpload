/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import java.util.BitSet;
/*   4:    */ 
/*   5:    */ final class CatNode
/*   6:    */   extends SyntaxNode
/*   7:    */ {
/*   8:    */   SyntaxNode _left;
/*   9:    */   SyntaxNode _right;
/*  10:    */   
/*  11:    */   boolean _nullable()
/*  12:    */   {
/*  13: 70 */     return (this._left._nullable()) && (this._right._nullable());
/*  14:    */   }
/*  15:    */   
/*  16:    */   BitSet _firstPosition()
/*  17:    */   {
/*  18: 74 */     if (this._left._nullable())
/*  19:    */     {
/*  20: 77 */       BitSet localBitSet1 = this._left._firstPosition();
/*  21: 78 */       BitSet localBitSet2 = this._right._firstPosition();
/*  22: 79 */       BitSet localBitSet3 = new BitSet(Math.max(localBitSet1.size(), localBitSet2.size()));
/*  23: 80 */       localBitSet3.or(localBitSet2);
/*  24: 81 */       localBitSet3.or(localBitSet1);
/*  25:    */       
/*  26: 83 */       return localBitSet3;
/*  27:    */     }
/*  28: 86 */     return this._left._firstPosition();
/*  29:    */   }
/*  30:    */   
/*  31:    */   BitSet _lastPosition()
/*  32:    */   {
/*  33: 90 */     if (this._right._nullable())
/*  34:    */     {
/*  35: 93 */       BitSet localBitSet1 = this._left._lastPosition();
/*  36: 94 */       BitSet localBitSet2 = this._right._lastPosition();
/*  37: 95 */       BitSet localBitSet3 = new BitSet(Math.max(localBitSet1.size(), localBitSet2.size()));
/*  38: 96 */       localBitSet3.or(localBitSet2);
/*  39: 97 */       localBitSet3.or(localBitSet1);
/*  40:    */       
/*  41: 99 */       return localBitSet3;
/*  42:    */     }
/*  43:102 */     return this._right._lastPosition();
/*  44:    */   }
/*  45:    */   
/*  46:    */   void _followPosition(BitSet[] paramArrayOfBitSet, SyntaxNode[] paramArrayOfSyntaxNode)
/*  47:    */   {
/*  48:110 */     this._left._followPosition(paramArrayOfBitSet, paramArrayOfSyntaxNode);
/*  49:111 */     this._right._followPosition(paramArrayOfBitSet, paramArrayOfSyntaxNode);
/*  50:    */     
/*  51:113 */     BitSet localBitSet1 = this._left._lastPosition();
/*  52:114 */     BitSet localBitSet2 = this._right._firstPosition();
/*  53:    */     
/*  54:116 */     int i = localBitSet1.size();
/*  55:117 */     while (i-- > 0) {
/*  56:118 */       if (localBitSet1.get(i)) {
/*  57:119 */         paramArrayOfBitSet[i].or(localBitSet2);
/*  58:    */       }
/*  59:    */     }
/*  60:    */   }
/*  61:    */   
/*  62:    */   SyntaxNode _clone(int[] paramArrayOfInt)
/*  63:    */   {
/*  64:125 */     CatNode localCatNode = new CatNode();
/*  65:126 */     localCatNode._left = this._left._clone(paramArrayOfInt);
/*  66:127 */     localCatNode._right = this._right._clone(paramArrayOfInt);
/*  67:    */     
/*  68:129 */     return localCatNode;
/*  69:    */   }
/*  70:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.CatNode
 * JD-Core Version:    0.7.0.1
 */
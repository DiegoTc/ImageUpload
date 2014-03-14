/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import java.util.BitSet;
/*   4:    */ 
/*   5:    */ class OrNode
/*   6:    */   extends SyntaxNode
/*   7:    */ {
/*   8:    */   SyntaxNode _left;
/*   9:    */   SyntaxNode _right;
/*  10:    */   
/*  11:    */   OrNode(SyntaxNode paramSyntaxNode1, SyntaxNode paramSyntaxNode2)
/*  12:    */   {
/*  13: 70 */     this._left = paramSyntaxNode1;
/*  14: 71 */     this._right = paramSyntaxNode2;
/*  15:    */   }
/*  16:    */   
/*  17:    */   boolean _nullable()
/*  18:    */   {
/*  19: 75 */     return (this._left._nullable()) || (this._right._nullable());
/*  20:    */   }
/*  21:    */   
/*  22:    */   BitSet _firstPosition()
/*  23:    */   {
/*  24: 81 */     BitSet localBitSet1 = this._left._firstPosition();
/*  25: 82 */     BitSet localBitSet2 = this._right._firstPosition();
/*  26: 83 */     BitSet localBitSet3 = new BitSet(Math.max(localBitSet1.size(), localBitSet2.size()));
/*  27: 84 */     localBitSet3.or(localBitSet2);
/*  28: 85 */     localBitSet3.or(localBitSet1);
/*  29:    */     
/*  30: 87 */     return localBitSet3;
/*  31:    */   }
/*  32:    */   
/*  33:    */   BitSet _lastPosition()
/*  34:    */   {
/*  35: 93 */     BitSet localBitSet1 = this._left._lastPosition();
/*  36: 94 */     BitSet localBitSet2 = this._right._lastPosition();
/*  37: 95 */     BitSet localBitSet3 = new BitSet(Math.max(localBitSet1.size(), localBitSet2.size()));
/*  38: 96 */     localBitSet3.or(localBitSet2);
/*  39: 97 */     localBitSet3.or(localBitSet1);
/*  40:    */     
/*  41: 99 */     return localBitSet3;
/*  42:    */   }
/*  43:    */   
/*  44:    */   void _followPosition(BitSet[] paramArrayOfBitSet, SyntaxNode[] paramArrayOfSyntaxNode)
/*  45:    */   {
/*  46:103 */     this._left._followPosition(paramArrayOfBitSet, paramArrayOfSyntaxNode);
/*  47:104 */     this._right._followPosition(paramArrayOfBitSet, paramArrayOfSyntaxNode);
/*  48:    */   }
/*  49:    */   
/*  50:    */   SyntaxNode _clone(int[] paramArrayOfInt)
/*  51:    */   {
/*  52:108 */     return new OrNode(this._left._clone(paramArrayOfInt), this._right._clone(paramArrayOfInt));
/*  53:    */   }
/*  54:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.OrNode
 * JD-Core Version:    0.7.0.1
 */
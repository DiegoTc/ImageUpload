/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import java.util.BitSet;
/*   4:    */ 
/*   5:    */ final class SyntaxTree
/*   6:    */ {
/*   7:    */   int _positions;
/*   8:    */   SyntaxNode _root;
/*   9:    */   LeafNode[] _nodes;
/*  10:    */   BitSet[] _followSet;
/*  11:    */   
/*  12:    */   SyntaxTree(SyntaxNode paramSyntaxNode, int paramInt)
/*  13:    */   {
/*  14: 78 */     this._root = paramSyntaxNode;
/*  15: 79 */     this._positions = paramInt;
/*  16:    */   }
/*  17:    */   
/*  18:    */   void _computeFollowPositions()
/*  19:    */   {
/*  20: 85 */     this._followSet = new BitSet[this._positions];
/*  21: 86 */     this._nodes = new LeafNode[this._positions];
/*  22: 87 */     int i = this._positions;
/*  23: 89 */     while (i-- > 0) {
/*  24: 90 */       this._followSet[i] = new BitSet(this._positions);
/*  25:    */     }
/*  26: 92 */     this._root._followPosition(this._followSet, this._nodes);
/*  27:    */   }
/*  28:    */   
/*  29:    */   private void __addToFastMap(BitSet paramBitSet, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
/*  30:    */   {
/*  31: 98 */     for (int j = 0; j < this._positions; j++) {
/*  32: 99 */       if ((paramBitSet.get(j)) && (paramArrayOfBoolean2[j] == 0))
/*  33:    */       {
/*  34:100 */         paramArrayOfBoolean2[j] = true;
/*  35:102 */         for (int i = 0; i < 256; i++) {
/*  36:103 */           if (paramArrayOfBoolean1[i] == 0) {
/*  37:104 */             paramArrayOfBoolean1[i] = this._nodes[j]._matches((char)i);
/*  38:    */           }
/*  39:    */         }
/*  40:    */       }
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   boolean[] createFastMap()
/*  45:    */   {
/*  46:114 */     boolean[] arrayOfBoolean1 = new boolean[256];
/*  47:115 */     boolean[] arrayOfBoolean2 = new boolean[this._positions];
/*  48:116 */     __addToFastMap(this._root._firstPosition(), arrayOfBoolean1, arrayOfBoolean2);
/*  49:    */     
/*  50:118 */     return arrayOfBoolean1;
/*  51:    */   }
/*  52:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.SyntaxTree
 * JD-Core Version:    0.7.0.1
 */
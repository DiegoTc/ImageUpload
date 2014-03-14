/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ final class PlusNode
/*  4:   */   extends StarNode
/*  5:   */ {
/*  6:   */   PlusNode(SyntaxNode paramSyntaxNode)
/*  7:   */   {
/*  8:67 */     super(paramSyntaxNode);
/*  9:   */   }
/* 10:   */   
/* 11:   */   boolean _nullable()
/* 12:   */   {
/* 13:70 */     return false;
/* 14:   */   }
/* 15:   */   
/* 16:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 17:   */   {
/* 18:73 */     return new PlusNode(this._left._clone(paramArrayOfInt));
/* 19:   */   }
/* 20:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.PlusNode
 * JD-Core Version:    0.7.0.1
 */
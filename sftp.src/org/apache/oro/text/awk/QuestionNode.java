/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ final class QuestionNode
/*  4:   */   extends OrNode
/*  5:   */ {
/*  6:65 */   static final SyntaxNode _epsilon = new EpsilonNode();
/*  7:   */   
/*  8:   */   QuestionNode(SyntaxNode paramSyntaxNode)
/*  9:   */   {
/* 10:68 */     super(paramSyntaxNode, _epsilon);
/* 11:   */   }
/* 12:   */   
/* 13:   */   boolean _nullable()
/* 14:   */   {
/* 15:71 */     return true;
/* 16:   */   }
/* 17:   */   
/* 18:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 19:   */   {
/* 20:74 */     return new QuestionNode(this._left._clone(paramArrayOfInt));
/* 21:   */   }
/* 22:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.QuestionNode
 * JD-Core Version:    0.7.0.1
 */
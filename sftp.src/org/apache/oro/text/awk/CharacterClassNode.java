/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ import java.util.BitSet;
/*  4:   */ 
/*  5:   */ class CharacterClassNode
/*  6:   */   extends LeafNode
/*  7:   */ {
/*  8:   */   CharacterClassNode(int paramInt)
/*  9:   */   {
/* 10:70 */     super(paramInt);
/* 11:   */   }
/* 12:   */   
/* 13:71 */   BitSet _characterSet = new BitSet(257);
/* 14:   */   
/* 15:   */   void _addToken(int paramInt)
/* 16:   */   {
/* 17:74 */     this._characterSet.set(paramInt);
/* 18:   */   }
/* 19:   */   
/* 20:   */   void _addTokenRange(int paramInt1, int paramInt2)
/* 21:   */   {
/* 22:77 */     while (paramInt1 <= paramInt2) {
/* 23:78 */       this._characterSet.set(paramInt1++);
/* 24:   */     }
/* 25:   */   }
/* 26:   */   
/* 27:   */   boolean _matches(char paramChar)
/* 28:   */   {
/* 29:81 */     return this._characterSet.get(paramChar);
/* 30:   */   }
/* 31:   */   
/* 32:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 33:   */   {
/* 34:86 */     int tmp6_5 = 0; int[] tmp6_4 = paramArrayOfInt; int tmp8_7 = tmp6_4[tmp6_5];tmp6_4[tmp6_5] = (tmp8_7 + 1);CharacterClassNode localCharacterClassNode = new CharacterClassNode(tmp8_7);
/* 35:87 */     localCharacterClassNode._characterSet = ((BitSet)this._characterSet.clone());
/* 36:88 */     return localCharacterClassNode;
/* 37:   */   }
/* 38:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.CharacterClassNode
 * JD-Core Version:    0.7.0.1
 */
/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ import java.util.BitSet;
/*  4:   */ 
/*  5:   */ final class NegativeCharacterClassNode
/*  6:   */   extends CharacterClassNode
/*  7:   */ {
/*  8:   */   NegativeCharacterClassNode(int paramInt)
/*  9:   */   {
/* 10:69 */     super(paramInt);
/* 11:   */     
/* 12:71 */     this._characterSet.set(256);
/* 13:   */   }
/* 14:   */   
/* 15:   */   boolean _matches(char paramChar)
/* 16:   */   {
/* 17:75 */     return this._characterSet.get(paramChar) ^ true;
/* 18:   */   }
/* 19:   */   
/* 20:   */   SyntaxNode _clone(int[] paramArrayOfInt)
/* 21:   */   {
/* 22:81 */     int tmp6_5 = 0; int[] tmp6_4 = paramArrayOfInt; int tmp8_7 = tmp6_4[tmp6_5];tmp6_4[tmp6_5] = (tmp8_7 + 1);NegativeCharacterClassNode localNegativeCharacterClassNode = new NegativeCharacterClassNode(tmp8_7);
/* 23:82 */     localNegativeCharacterClassNode._characterSet = ((BitSet)this._characterSet.clone());
/* 24:83 */     return localNegativeCharacterClassNode;
/* 25:   */   }
/* 26:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.NegativeCharacterClassNode
 * JD-Core Version:    0.7.0.1
 */
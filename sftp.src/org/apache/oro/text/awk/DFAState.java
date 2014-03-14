/*  1:   */ package org.apache.oro.text.awk;
/*  2:   */ 
/*  3:   */ import java.util.BitSet;
/*  4:   */ 
/*  5:   */ final class DFAState
/*  6:   */ {
/*  7:   */   int _stateNumber;
/*  8:   */   BitSet _state;
/*  9:   */   
/* 10:   */   DFAState(BitSet paramBitSet, int paramInt)
/* 11:   */   {
/* 12:71 */     this._state = paramBitSet;
/* 13:72 */     this._stateNumber = paramInt;
/* 14:   */   }
/* 15:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.DFAState
 * JD-Core Version:    0.7.0.1
 */
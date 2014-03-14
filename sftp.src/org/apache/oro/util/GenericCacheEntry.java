/*  1:   */ package org.apache.oro.util;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ final class GenericCacheEntry
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   int _index;
/*  9:   */   Object _value;
/* 10:   */   Object _key;
/* 11:   */   
/* 12:   */   GenericCacheEntry(int paramInt)
/* 13:   */   {
/* 14:77 */     this._index = paramInt;
/* 15:78 */     this._value = null;
/* 16:79 */     this._key = null;
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.GenericCacheEntry
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package org.apache.oro.util;
/*   2:    */ 
/*   3:    */ import java.util.Hashtable;
/*   4:    */ 
/*   5:    */ public final class CacheFIFO
/*   6:    */   extends GenericCache
/*   7:    */ {
/*   8: 76 */   private int __curent = 0;
/*   9:    */   
/*  10:    */   public CacheFIFO(int paramInt)
/*  11:    */   {
/*  12: 84 */     super(paramInt);
/*  13:    */   }
/*  14:    */   
/*  15:    */   public CacheFIFO()
/*  16:    */   {
/*  17: 95 */     this(20);
/*  18:    */   }
/*  19:    */   
/*  20:    */   public final synchronized void addElement(Object paramObject1, Object paramObject2)
/*  21:    */   {
/*  22:111 */     Object localObject = this._table.get(paramObject1);
/*  23:113 */     if (localObject != null)
/*  24:    */     {
/*  25:118 */       GenericCacheEntry localGenericCacheEntry = (GenericCacheEntry)localObject;
/*  26:119 */       localGenericCacheEntry._value = paramObject2;
/*  27:120 */       localGenericCacheEntry._key = paramObject1; return;
/*  28:    */     }
/*  29:    */     int i;
/*  30:126 */     if (!isFull())
/*  31:    */     {
/*  32:127 */       i = this._numEntries;
/*  33:128 */       this._numEntries += 1;
/*  34:    */     }
/*  35:    */     else
/*  36:    */     {
/*  37:132 */       i = this.__curent;
/*  38:134 */       if (++this.__curent >= this._cache.length) {
/*  39:135 */         this.__curent = 0;
/*  40:    */       }
/*  41:137 */       this._table.remove(this._cache[i]._key);
/*  42:    */     }
/*  43:140 */     this._cache[i]._value = paramObject2;
/*  44:141 */     this._cache[i]._key = paramObject1;
/*  45:142 */     this._table.put(paramObject1, this._cache[i]);
/*  46:    */   }
/*  47:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.CacheFIFO
 * JD-Core Version:    0.7.0.1
 */
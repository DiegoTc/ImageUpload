/*   1:    */ package org.apache.oro.util;
/*   2:    */ 
/*   3:    */ import java.util.Hashtable;
/*   4:    */ import java.util.Random;
/*   5:    */ 
/*   6:    */ public final class CacheRandom
/*   7:    */   extends GenericCache
/*   8:    */ {
/*   9:    */   public CacheRandom(int paramInt)
/*  10:    */   {
/*  11: 83 */     super(paramInt);
/*  12:    */   }
/*  13:    */   
/*  14: 84 */   private Random __random = new Random(System.currentTimeMillis());
/*  15:    */   
/*  16:    */   public CacheRandom()
/*  17:    */   {
/*  18: 94 */     this(20);
/*  19:    */   }
/*  20:    */   
/*  21:    */   public final synchronized void addElement(Object paramObject1, Object paramObject2)
/*  22:    */   {
/*  23:110 */     Object localObject = this._table.get(paramObject1);
/*  24:112 */     if (localObject != null)
/*  25:    */     {
/*  26:116 */       GenericCacheEntry localGenericCacheEntry = (GenericCacheEntry)localObject;
/*  27:117 */       localGenericCacheEntry._value = paramObject2;
/*  28:118 */       localGenericCacheEntry._key = paramObject1; return;
/*  29:    */     }
/*  30:    */     int i;
/*  31:126 */     if (!isFull())
/*  32:    */     {
/*  33:127 */       i = this._numEntries;
/*  34:128 */       this._numEntries += 1;
/*  35:    */     }
/*  36:    */     else
/*  37:    */     {
/*  38:131 */       i = (int)(this._cache.length * this.__random.nextFloat());
/*  39:132 */       this._table.remove(this._cache[i]._key);
/*  40:    */     }
/*  41:135 */     this._cache[i]._value = paramObject2;
/*  42:136 */     this._cache[i]._key = paramObject1;
/*  43:137 */     this._table.put(paramObject1, this._cache[i]);
/*  44:    */   }
/*  45:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.CacheRandom
 * JD-Core Version:    0.7.0.1
 */
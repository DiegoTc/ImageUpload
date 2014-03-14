/*   1:    */ package org.apache.oro.util;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Enumeration;
/*   5:    */ import java.util.Hashtable;
/*   6:    */ 
/*   7:    */ public abstract class GenericCache
/*   8:    */   implements Cache, Serializable
/*   9:    */ {
/*  10:    */   public static final int DEFAULT_CAPACITY = 20;
/*  11:    */   int _numEntries;
/*  12:    */   GenericCacheEntry[] _cache;
/*  13:    */   Hashtable _table;
/*  14:    */   
/*  15:    */   GenericCache(int paramInt)
/*  16:    */   {
/*  17:102 */     this._numEntries = 0;
/*  18:103 */     this._table = new Hashtable(paramInt);
/*  19:104 */     this._cache = new GenericCacheEntry[paramInt];
/*  20:    */     do
/*  21:    */     {
/*  22:107 */       this._cache[paramInt] = new GenericCacheEntry(paramInt);paramInt--;
/*  23:106 */     } while (paramInt >= 0);
/*  24:    */   }
/*  25:    */   
/*  26:    */   public synchronized Object getElement(Object paramObject)
/*  27:    */   {
/*  28:115 */     Object localObject = this._table.get(paramObject);
/*  29:117 */     if (localObject != null) {
/*  30:118 */       return ((GenericCacheEntry)localObject)._value;
/*  31:    */     }
/*  32:120 */     return null;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public final Enumeration keys()
/*  36:    */   {
/*  37:123 */     return this._table.keys();
/*  38:    */   }
/*  39:    */   
/*  40:    */   public final int size()
/*  41:    */   {
/*  42:133 */     return this._numEntries;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public final int capacity()
/*  46:    */   {
/*  47:140 */     return this._cache.length;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public final boolean isFull()
/*  51:    */   {
/*  52:142 */     return this._numEntries >= this._cache.length;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public abstract void addElement(Object paramObject1, Object paramObject2);
/*  56:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.GenericCache
 * JD-Core Version:    0.7.0.1
 */
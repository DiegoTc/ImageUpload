/*   1:    */ package org.apache.oro.util;
/*   2:    */ 
/*   3:    */ import java.util.Hashtable;
/*   4:    */ 
/*   5:    */ public final class CacheLRU
/*   6:    */   extends GenericCache
/*   7:    */ {
/*   8:    */   private int[] __prev;
/*   9:    */   private int[] __next;
/*  10: 76 */   private int __tail = 0;
/*  11: 76 */   private int __head = 0;
/*  12:    */   
/*  13:    */   public CacheLRU(int paramInt)
/*  14:    */   {
/*  15: 85 */     super(paramInt);
/*  16:    */     
/*  17:    */ 
/*  18:    */ 
/*  19: 89 */     this.__next = new int[this._cache.length];
/*  20: 90 */     this.__prev = new int[this._cache.length];
/*  21: 92 */     for (int i = 0; i < this.__next.length; i++)
/*  22:    */     {
/*  23: 93 */       byte tmp53_52 = -1;this.__prev[i] = tmp53_52;this.__next[i] = tmp53_52;
/*  24:    */     }
/*  25:    */   }
/*  26:    */   
/*  27:    */   public CacheLRU()
/*  28:    */   {
/*  29:104 */     this(20);
/*  30:    */   }
/*  31:    */   
/*  32:    */   private void __moveToFront(int paramInt)
/*  33:    */   {
/*  34:111 */     if (this.__head != paramInt)
/*  35:    */     {
/*  36:112 */       int i = this.__next[paramInt];
/*  37:113 */       int j = this.__prev[paramInt];
/*  38:    */       
/*  39:    */ 
/*  40:    */ 
/*  41:117 */       this.__next[j] = i;
/*  42:121 */       if (i >= 0) {
/*  43:122 */         this.__prev[i] = j;
/*  44:    */       } else {
/*  45:124 */         this.__tail = j;
/*  46:    */       }
/*  47:126 */       this.__prev[paramInt] = -1;
/*  48:127 */       this.__next[paramInt] = this.__head;
/*  49:128 */       this.__prev[this.__head] = paramInt;
/*  50:129 */       this.__head = paramInt;
/*  51:    */     }
/*  52:    */   }
/*  53:    */   
/*  54:    */   public synchronized Object getElement(Object paramObject)
/*  55:    */   {
/*  56:137 */     Object localObject = this._table.get(paramObject);
/*  57:139 */     if (localObject != null)
/*  58:    */     {
/*  59:142 */       GenericCacheEntry localGenericCacheEntry = (GenericCacheEntry)localObject;
/*  60:    */       
/*  61:144 */       __moveToFront(localGenericCacheEntry._index);
/*  62:    */       
/*  63:146 */       return localGenericCacheEntry._value;
/*  64:    */     }
/*  65:149 */     return null;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public final synchronized void addElement(Object paramObject1, Object paramObject2)
/*  69:    */   {
/*  70:165 */     Object localObject = this._table.get(paramObject1);
/*  71:167 */     if (localObject != null)
/*  72:    */     {
/*  73:171 */       GenericCacheEntry localGenericCacheEntry = (GenericCacheEntry)localObject;
/*  74:172 */       localGenericCacheEntry._value = paramObject2;
/*  75:173 */       localGenericCacheEntry._key = paramObject1;
/*  76:    */       
/*  77:175 */       __moveToFront(localGenericCacheEntry._index);
/*  78:    */       
/*  79:177 */       return;
/*  80:    */     }
/*  81:182 */     if (!isFull())
/*  82:    */     {
/*  83:183 */       if (this._numEntries > 0)
/*  84:    */       {
/*  85:184 */         this.__prev[this._numEntries] = this.__tail;
/*  86:185 */         this.__next[this._numEntries] = -1;
/*  87:186 */         __moveToFront(this._numEntries);
/*  88:    */       }
/*  89:188 */       this._numEntries += 1;
/*  90:    */     }
/*  91:    */     else
/*  92:    */     {
/*  93:191 */       this._table.remove(this._cache[this.__tail]._key);
/*  94:192 */       __moveToFront(this.__tail);
/*  95:    */     }
/*  96:195 */     this._cache[this.__head]._value = paramObject2;
/*  97:196 */     this._cache[this.__head]._key = paramObject1;
/*  98:197 */     this._table.put(paramObject1, this._cache[this.__head]);
/*  99:    */   }
/* 100:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.CacheLRU
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package org.apache.oro.util;
/*   2:    */ 
/*   3:    */ import java.util.Hashtable;
/*   4:    */ 
/*   5:    */ public final class CacheFIFO2
/*   6:    */   extends GenericCache
/*   7:    */ {
/*   8: 82 */   private int __current = 0;
/*   9:    */   
/*  10:    */   public CacheFIFO2(int paramInt)
/*  11:    */   {
/*  12: 91 */     super(paramInt);
/*  13:    */   }
/*  14:    */   
/*  15: 93 */   private boolean[] __tryAgain = new boolean[this._cache.length];
/*  16:    */   
/*  17:    */   public CacheFIFO2()
/*  18:    */   {
/*  19:104 */     this(20);
/*  20:    */   }
/*  21:    */   
/*  22:    */   public synchronized Object getElement(Object paramObject)
/*  23:    */   {
/*  24:111 */     Object localObject = this._table.get(paramObject);
/*  25:113 */     if (localObject != null)
/*  26:    */     {
/*  27:116 */       GenericCacheEntry localGenericCacheEntry = (GenericCacheEntry)localObject;
/*  28:    */       
/*  29:118 */       this.__tryAgain[localGenericCacheEntry._index] = true;
/*  30:119 */       return localGenericCacheEntry._value;
/*  31:    */     }
/*  32:122 */     return null;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public final synchronized void addElement(Object paramObject1, Object paramObject2)
/*  36:    */   {
/*  37:138 */     Object localObject = this._table.get(paramObject1);
/*  38:140 */     if (localObject != null)
/*  39:    */     {
/*  40:145 */       GenericCacheEntry localGenericCacheEntry = (GenericCacheEntry)localObject;
/*  41:146 */       localGenericCacheEntry._value = paramObject2;
/*  42:147 */       localGenericCacheEntry._key = paramObject1;
/*  43:    */       
/*  44:    */ 
/*  45:150 */       this.__tryAgain[localGenericCacheEntry._index] = true; return;
/*  46:    */     }
/*  47:    */     int i;
/*  48:156 */     if (!isFull())
/*  49:    */     {
/*  50:157 */       i = this._numEntries;
/*  51:158 */       this._numEntries += 1;
/*  52:    */     }
/*  53:    */     else
/*  54:    */     {
/*  55:161 */       i = this.__current;
/*  56:163 */       while (this.__tryAgain[i] != 0)
/*  57:    */       {
/*  58:164 */         this.__tryAgain[i] = false;
/*  59:165 */         i++;
/*  60:165 */         if (i >= this.__tryAgain.length) {
/*  61:166 */           i = 0;
/*  62:    */         }
/*  63:    */       }
/*  64:169 */       this.__current = (i + 1);
/*  65:170 */       if (this.__current >= this._cache.length) {
/*  66:171 */         this.__current = 0;
/*  67:    */       }
/*  68:173 */       this._table.remove(this._cache[i]._key);
/*  69:    */     }
/*  70:176 */     this._cache[i]._value = paramObject2;
/*  71:177 */     this._cache[i]._key = paramObject1;
/*  72:178 */     this._table.put(paramObject1, this._cache[i]);
/*  73:    */   }
/*  74:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.util.CacheFIFO2
 * JD-Core Version:    0.7.0.1
 */
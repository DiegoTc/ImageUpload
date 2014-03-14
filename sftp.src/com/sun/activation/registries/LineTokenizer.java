/*   1:    */ package com.sun.activation.registries;
/*   2:    */ 
/*   3:    */ import java.util.NoSuchElementException;
/*   4:    */ import java.util.Vector;
/*   5:    */ 
/*   6:    */ class LineTokenizer
/*   7:    */ {
/*   8:    */   private int currentPosition;
/*   9:    */   private int maxPosition;
/*  10:    */   private String str;
/*  11:213 */   private Vector stack = new Vector();
/*  12:    */   private static final String singles = "=";
/*  13:    */   
/*  14:    */   public LineTokenizer(String paramString)
/*  15:    */   {
/*  16:223 */     this.currentPosition = 0;
/*  17:224 */     this.str = paramString;
/*  18:225 */     this.maxPosition = paramString.length();
/*  19:    */   }
/*  20:    */   
/*  21:    */   private void skipWhiteSpace()
/*  22:    */   {
/*  23:232 */     while ((this.currentPosition < this.maxPosition) && 
/*  24:233 */       (Character.isWhitespace(this.str.charAt(this.currentPosition)))) {
/*  25:234 */       this.currentPosition += 1;
/*  26:    */     }
/*  27:    */   }
/*  28:    */   
/*  29:    */   public boolean hasMoreTokens()
/*  30:    */   {
/*  31:245 */     if (this.stack.size() > 0) {
/*  32:246 */       return true;
/*  33:    */     }
/*  34:247 */     skipWhiteSpace();
/*  35:248 */     return this.currentPosition < this.maxPosition;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String nextToken()
/*  39:    */   {
/*  40:259 */     int i = this.stack.size();
/*  41:260 */     if (i > 0)
/*  42:    */     {
/*  43:261 */       String str1 = (String)this.stack.elementAt(i - 1);
/*  44:262 */       this.stack.removeElementAt(i - 1);
/*  45:263 */       return str1;
/*  46:    */     }
/*  47:265 */     skipWhiteSpace();
/*  48:267 */     if (this.currentPosition >= this.maxPosition) {
/*  49:268 */       throw new NoSuchElementException();
/*  50:    */     }
/*  51:271 */     int j = this.currentPosition;
/*  52:272 */     char c = this.str.charAt(j);
/*  53:273 */     if (c == '"')
/*  54:    */     {
/*  55:274 */       this.currentPosition += 1;
/*  56:275 */       int k = 0;
/*  57:276 */       while (this.currentPosition < this.maxPosition)
/*  58:    */       {
/*  59:277 */         c = this.str.charAt(this.currentPosition++);
/*  60:278 */         if (c == '\\')
/*  61:    */         {
/*  62:279 */           this.currentPosition += 1;
/*  63:280 */           k = 1;
/*  64:    */         }
/*  65:281 */         else if (c == '"')
/*  66:    */         {
/*  67:    */           String str2;
/*  68:284 */           if (k != 0)
/*  69:    */           {
/*  70:285 */             StringBuffer localStringBuffer = new StringBuffer();
/*  71:286 */             for (int m = j + 1; m < this.currentPosition - 1; m++)
/*  72:    */             {
/*  73:287 */               c = this.str.charAt(m);
/*  74:288 */               if (c != '\\') {
/*  75:289 */                 localStringBuffer.append(c);
/*  76:    */               }
/*  77:    */             }
/*  78:291 */             str2 = localStringBuffer.toString();
/*  79:    */           }
/*  80:    */           else
/*  81:    */           {
/*  82:293 */             str2 = this.str.substring(j + 1, this.currentPosition - 1);
/*  83:    */           }
/*  84:294 */           return str2;
/*  85:    */         }
/*  86:    */       }
/*  87:    */     }
/*  88:297 */     else if ("=".indexOf(c) >= 0)
/*  89:    */     {
/*  90:298 */       this.currentPosition += 1;
/*  91:    */     }
/*  92:    */     else
/*  93:    */     {
/*  94:300 */       while ((this.currentPosition < this.maxPosition) && 
/*  95:301 */         ("=".indexOf(this.str.charAt(this.currentPosition)) < 0) && 
/*  96:302 */         (!Character.isWhitespace(this.str.charAt(this.currentPosition)))) {
/*  97:303 */         this.currentPosition += 1;
/*  98:    */       }
/*  99:    */     }
/* 100:306 */     return this.str.substring(j, this.currentPosition);
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void pushToken(String paramString)
/* 104:    */   {
/* 105:310 */     this.stack.addElement(paramString);
/* 106:    */   }
/* 107:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.registries.LineTokenizer
 * JD-Core Version:    0.7.0.1
 */
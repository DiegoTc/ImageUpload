/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.util.BitSet;
/*   5:    */ import org.apache.oro.text.regex.MatchResult;
/*   6:    */ import org.apache.oro.text.regex.Pattern;
/*   7:    */ import org.apache.oro.text.regex.PatternMatcher;
/*   8:    */ import org.apache.oro.text.regex.PatternMatcherInput;
/*   9:    */ 
/*  10:    */ public final class AwkMatcher
/*  11:    */   implements PatternMatcher
/*  12:    */ {
/*  13:    */   private int __lastMatchedBufferOffset;
/*  14: 85 */   private AwkMatchResult __lastMatchResult = null;
/*  15:    */   private AwkStreamInput __scratchBuffer;
/*  16:    */   private AwkStreamInput __streamSearchBuffer;
/*  17:    */   private AwkPattern __awkPattern;
/*  18: 88 */   private int[] __offsets = new int[2];
/*  19:    */   
/*  20:    */   public AwkMatcher()
/*  21:    */   {
/*  22: 91 */     this.__scratchBuffer = new AwkStreamInput();
/*  23: 92 */     this.__scratchBuffer._endOfStreamReached = true;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public boolean matchesPrefix(char[] paramArrayOfChar, Pattern paramPattern, int paramInt)
/*  27:    */   {
/*  28:114 */     int i = -1;
/*  29:    */     
/*  30:116 */     this.__awkPattern = ((AwkPattern)paramPattern);
/*  31:    */     
/*  32:118 */     this.__scratchBuffer._buffer = paramArrayOfChar;
/*  33:119 */     this.__scratchBuffer._bufferSize = paramArrayOfChar.length;
/*  34:120 */     this.__scratchBuffer._bufferOffset = 0;
/*  35:121 */     this.__scratchBuffer._endOfStreamReached = true;
/*  36:122 */     this.__streamSearchBuffer = this.__scratchBuffer;
/*  37:123 */     this.__offsets[0] = paramInt;
/*  38:    */     try
/*  39:    */     {
/*  40:125 */       i = __streamMatchPrefix();
/*  41:    */     }
/*  42:    */     catch (IOException localIOException)
/*  43:    */     {
/*  44:128 */       i = -1;
/*  45:    */     }
/*  46:131 */     if (i < 0)
/*  47:    */     {
/*  48:132 */       this.__lastMatchResult = null;
/*  49:133 */       return false;
/*  50:    */     }
/*  51:136 */     this.__lastMatchResult = 
/*  52:137 */       new AwkMatchResult(new String(paramArrayOfChar, 0, i), paramInt);
/*  53:    */     
/*  54:139 */     return true;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public boolean matchesPrefix(char[] paramArrayOfChar, Pattern paramPattern)
/*  58:    */   {
/*  59:158 */     return matchesPrefix(paramArrayOfChar, paramPattern, 0);
/*  60:    */   }
/*  61:    */   
/*  62:    */   public boolean matchesPrefix(String paramString, Pattern paramPattern)
/*  63:    */   {
/*  64:176 */     return matchesPrefix(paramString.toCharArray(), paramPattern, 0);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public boolean matchesPrefix(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern)
/*  68:    */   {
/*  69:199 */     int i = -1;
/*  70:    */     
/*  71:201 */     this.__awkPattern = ((AwkPattern)paramPattern);
/*  72:202 */     this.__scratchBuffer._buffer = paramPatternMatcherInput.getBuffer();
/*  73:203 */     this.__scratchBuffer._bufferOffset = paramPatternMatcherInput.getBeginOffset();
/*  74:204 */     this.__offsets[0] = paramPatternMatcherInput.getCurrentOffset();
/*  75:    */     
/*  76:206 */     this.__scratchBuffer._bufferSize = paramPatternMatcherInput.length();
/*  77:207 */     this.__scratchBuffer._endOfStreamReached = true;
/*  78:208 */     this.__streamSearchBuffer = this.__scratchBuffer;
/*  79:    */     try
/*  80:    */     {
/*  81:210 */       i = __streamMatchPrefix();
/*  82:    */     }
/*  83:    */     catch (IOException localIOException)
/*  84:    */     {
/*  85:213 */       i = -1;
/*  86:    */     }
/*  87:216 */     if (i < 0)
/*  88:    */     {
/*  89:217 */       this.__lastMatchResult = null;
/*  90:218 */       return false;
/*  91:    */     }
/*  92:221 */     this.__lastMatchResult = 
/*  93:222 */       new AwkMatchResult(new String(this.__scratchBuffer._buffer, this.__offsets[0], 
/*  94:223 */       i), this.__offsets[0]);
/*  95:    */     
/*  96:225 */     return true;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public boolean matches(char[] paramArrayOfChar, Pattern paramPattern)
/* 100:    */   {
/* 101:249 */     int i = -1;
/* 102:    */     
/* 103:251 */     this.__awkPattern = ((AwkPattern)paramPattern);
/* 104:252 */     this.__scratchBuffer._buffer = paramArrayOfChar;
/* 105:253 */     this.__scratchBuffer._bufferSize = paramArrayOfChar.length;
/* 106:254 */     this.__scratchBuffer._bufferOffset = 0;
/* 107:255 */     this.__scratchBuffer._endOfStreamReached = true;
/* 108:256 */     this.__streamSearchBuffer = this.__scratchBuffer;
/* 109:257 */     this.__offsets[0] = 0;
/* 110:    */     try
/* 111:    */     {
/* 112:259 */       i = __streamMatchPrefix();
/* 113:    */     }
/* 114:    */     catch (IOException localIOException)
/* 115:    */     {
/* 116:262 */       i = -1;
/* 117:    */     }
/* 118:265 */     if (i != paramArrayOfChar.length)
/* 119:    */     {
/* 120:266 */       this.__lastMatchResult = null;
/* 121:267 */       return false;
/* 122:    */     }
/* 123:270 */     this.__lastMatchResult = 
/* 124:271 */       new AwkMatchResult(new String(paramArrayOfChar, 0, i), 0);
/* 125:    */     
/* 126:273 */     return true;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public boolean matches(String paramString, Pattern paramPattern)
/* 130:    */   {
/* 131:297 */     return matches(paramString.toCharArray(), paramPattern);
/* 132:    */   }
/* 133:    */   
/* 134:    */   public boolean matches(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern)
/* 135:    */   {
/* 136:326 */     int i = -1;
/* 137:    */     
/* 138:328 */     this.__awkPattern = ((AwkPattern)paramPattern);
/* 139:329 */     this.__scratchBuffer._buffer = paramPatternMatcherInput.getBuffer();
/* 140:330 */     this.__scratchBuffer._bufferSize = paramPatternMatcherInput.length();
/* 141:331 */     this.__scratchBuffer._bufferOffset = paramPatternMatcherInput.getBeginOffset();
/* 142:332 */     this.__offsets[0] = paramPatternMatcherInput.getBeginOffset();
/* 143:333 */     this.__scratchBuffer._endOfStreamReached = true;
/* 144:334 */     this.__streamSearchBuffer = this.__scratchBuffer;
/* 145:    */     try
/* 146:    */     {
/* 147:336 */       i = __streamMatchPrefix();
/* 148:    */     }
/* 149:    */     catch (IOException localIOException)
/* 150:    */     {
/* 151:339 */       i = -1;
/* 152:    */     }
/* 153:342 */     if (i != this.__scratchBuffer._bufferSize)
/* 154:    */     {
/* 155:343 */       this.__lastMatchResult = null;
/* 156:344 */       return false;
/* 157:    */     }
/* 158:347 */     this.__lastMatchResult = 
/* 159:348 */       new AwkMatchResult(new String(this.__scratchBuffer._buffer, this.__offsets[0], 
/* 160:349 */       this.__scratchBuffer._bufferSize), this.__offsets[0]);
/* 161:    */     
/* 162:351 */     return true;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public boolean contains(char[] paramArrayOfChar, Pattern paramPattern)
/* 166:    */   {
/* 167:381 */     this.__awkPattern = ((AwkPattern)paramPattern);
/* 168:384 */     if ((this.__awkPattern._hasBeginAnchor) && (this.__awkPattern._fastMap[paramArrayOfChar[0]] == 0))
/* 169:    */     {
/* 170:385 */       this.__lastMatchResult = null;
/* 171:386 */       return false;
/* 172:    */     }
/* 173:389 */     this.__scratchBuffer._buffer = paramArrayOfChar;
/* 174:390 */     this.__scratchBuffer._bufferSize = paramArrayOfChar.length;
/* 175:391 */     this.__scratchBuffer._bufferOffset = 0;
/* 176:392 */     this.__scratchBuffer._endOfStreamReached = true;
/* 177:393 */     this.__streamSearchBuffer = this.__scratchBuffer;
/* 178:394 */     this.__lastMatchedBufferOffset = 0;
/* 179:    */     try
/* 180:    */     {
/* 181:396 */       _search();
/* 182:    */     }
/* 183:    */     catch (IOException localIOException) {}
/* 184:400 */     return this.__lastMatchResult != null;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public boolean contains(String paramString, Pattern paramPattern)
/* 188:    */   {
/* 189:428 */     return contains(paramString.toCharArray(), paramPattern);
/* 190:    */   }
/* 191:    */   
/* 192:    */   public boolean contains(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern)
/* 193:    */   {
/* 194:497 */     this.__awkPattern = ((AwkPattern)paramPattern);
/* 195:498 */     this.__scratchBuffer._buffer = paramPatternMatcherInput.getBuffer();
/* 196:499 */     this.__scratchBuffer._bufferOffset = paramPatternMatcherInput.getBeginOffset();
/* 197:500 */     this.__lastMatchedBufferOffset = paramPatternMatcherInput.getCurrentOffset();
/* 198:504 */     if (this.__awkPattern._hasBeginAnchor)
/* 199:    */     {
/* 200:507 */       int i = paramPatternMatcherInput.getBeginOffset();
/* 201:508 */       if ((i != this.__lastMatchedBufferOffset) || 
/* 202:509 */         (this.__awkPattern._fastMap[this.__scratchBuffer._buffer[i]] == 0))
/* 203:    */       {
/* 204:510 */         this.__lastMatchResult = null;
/* 205:511 */         return false;
/* 206:    */       }
/* 207:    */     }
/* 208:515 */     this.__scratchBuffer._bufferSize = paramPatternMatcherInput.length();
/* 209:516 */     this.__scratchBuffer._endOfStreamReached = true;
/* 210:517 */     this.__streamSearchBuffer = this.__scratchBuffer;
/* 211:    */     try
/* 212:    */     {
/* 213:519 */       _search();
/* 214:    */     }
/* 215:    */     catch (IOException localIOException) {}
/* 216:523 */     paramPatternMatcherInput.setCurrentOffset(this.__lastMatchedBufferOffset);
/* 217:525 */     if (this.__lastMatchResult == null) {
/* 218:526 */       return false;
/* 219:    */     }
/* 220:528 */     paramPatternMatcherInput.setMatchOffsets(this.__lastMatchResult.beginOffset(0), 
/* 221:529 */       this.__lastMatchResult.endOffset(0));
/* 222:    */     
/* 223:531 */     return true;
/* 224:    */   }
/* 225:    */   
/* 226:    */   public boolean contains(AwkStreamInput paramAwkStreamInput, Pattern paramPattern)
/* 227:    */     throws IOException
/* 228:    */   {
/* 229:594 */     this.__awkPattern = ((AwkPattern)paramPattern);
/* 230:597 */     if (this.__awkPattern._hasBeginAnchor) {
/* 231:599 */       if (paramAwkStreamInput._bufferOffset == 0)
/* 232:    */       {
/* 233:600 */         if ((paramAwkStreamInput.read()) && (this.__awkPattern._fastMap[paramAwkStreamInput._buffer[0]] == 0))
/* 234:    */         {
/* 235:601 */           this.__lastMatchResult = null;
/* 236:602 */           return false;
/* 237:    */         }
/* 238:    */       }
/* 239:    */       else
/* 240:    */       {
/* 241:605 */         this.__lastMatchResult = null;
/* 242:606 */         return false;
/* 243:    */       }
/* 244:    */     }
/* 245:610 */     this.__lastMatchedBufferOffset = paramAwkStreamInput._currentOffset;
/* 246:611 */     this.__streamSearchBuffer = paramAwkStreamInput;
/* 247:612 */     _search();
/* 248:613 */     paramAwkStreamInput._currentOffset = this.__lastMatchedBufferOffset;
/* 249:614 */     return this.__lastMatchResult != null;
/* 250:    */   }
/* 251:    */   
/* 252:    */   private int __streamMatchPrefix()
/* 253:    */     throws IOException
/* 254:    */   {
/* 255:619 */     int j = 1;
/* 256:    */     
/* 257:621 */     int i1 = -1;
/* 258:    */     int n;
/* 259:624 */     int m = n = this.__offsets[0];
/* 260:626 */     while (m < this.__streamSearchBuffer._bufferSize)
/* 261:    */     {
/* 262:627 */       int i = this.__streamSearchBuffer._buffer[(m++)];
/* 263:629 */       if (j >= this.__awkPattern._numStates) {
/* 264:    */         break;
/* 265:    */       }
/* 266:630 */       int k = j;
/* 267:631 */       int[] arrayOfInt = this.__awkPattern._getStateArray(j);
/* 268:632 */       j = arrayOfInt[i];
/* 269:634 */       if (j == 0)
/* 270:    */       {
/* 271:635 */         this.__awkPattern._createNewState(k, i, arrayOfInt);
/* 272:636 */         j = arrayOfInt[i];
/* 273:    */       }
/* 274:638 */       if (j == -1) {
/* 275:    */         break;
/* 276:    */       }
/* 277:641 */       if (this.__awkPattern._endStates.get(j)) {
/* 278:642 */         i1 = m;
/* 279:    */       }
/* 280:644 */       if (m == this.__streamSearchBuffer._bufferSize)
/* 281:    */       {
/* 282:645 */         m = this.__streamSearchBuffer._reallocate(n);
/* 283:648 */         if (m != this.__streamSearchBuffer._bufferSize)
/* 284:    */         {
/* 285:649 */           if (i1 != -1) {
/* 286:650 */             i1 -= n;
/* 287:    */           }
/* 288:651 */           n = 0;
/* 289:    */         }
/* 290:    */       }
/* 291:    */     }
/* 292:660 */     this.__offsets[0] = n;
/* 293:661 */     this.__offsets[1] = (i1 - 1);
/* 294:663 */     if ((i1 == -1) && (this.__awkPattern._matchesNullString)) {
/* 295:664 */       return 0;
/* 296:    */     }
/* 297:667 */     if ((this.__awkPattern._hasEndAnchor) && (
/* 298:668 */       (!this.__streamSearchBuffer._endOfStreamReached) || 
/* 299:669 */       (i1 < this.__streamSearchBuffer._bufferSize))) {
/* 300:670 */       return -1;
/* 301:    */     }
/* 302:672 */     return i1 - n;
/* 303:    */   }
/* 304:    */   
/* 305:    */   void _search()
/* 306:    */     throws IOException
/* 307:    */   {
/* 308:682 */     this.__lastMatchResult = null;
/* 309:    */     for (;;)
/* 310:    */     {
/* 311:685 */       if (this.__lastMatchedBufferOffset >= this.__streamSearchBuffer._bufferSize)
/* 312:    */       {
/* 313:686 */         if (this.__streamSearchBuffer._endOfStreamReached)
/* 314:    */         {
/* 315:688 */           this.__streamSearchBuffer = null;
/* 316:689 */           return;
/* 317:    */         }
/* 318:691 */         if (!this.__streamSearchBuffer.read()) {
/* 319:692 */           return;
/* 320:    */         }
/* 321:693 */         this.__lastMatchedBufferOffset = 0;
/* 322:    */       }
/* 323:697 */       for (int i = this.__lastMatchedBufferOffset; i < this.__streamSearchBuffer._bufferSize; i = this.__offsets[0] + 1)
/* 324:    */       {
/* 325:701 */         this.__offsets[0] = i;
/* 326:    */         int j;
/* 327:702 */         if ((this.__awkPattern._fastMap[this.__streamSearchBuffer._buffer[i]] != 0) && 
/* 328:703 */           ((j = __streamMatchPrefix()) > -1))
/* 329:    */         {
/* 330:705 */           this.__lastMatchResult = new AwkMatchResult(
/* 331:706 */             new String(this.__streamSearchBuffer._buffer, this.__offsets[0], 
/* 332:707 */             j), 
/* 333:708 */             this.__offsets[0] + this.__streamSearchBuffer._bufferOffset);
/* 334:    */           
/* 335:710 */           this.__lastMatchedBufferOffset = 
/* 336:711 */             (j > 0 ? this.__offsets[1] + 1 : this.__offsets[0] + 1);
/* 337:    */           
/* 338:713 */           return;
/* 339:    */         }
/* 340:714 */         if (this.__awkPattern._matchesNullString)
/* 341:    */         {
/* 342:715 */           this.__lastMatchResult = new AwkMatchResult(new String(), 
/* 343:716 */             i + this.__streamSearchBuffer._bufferOffset);
/* 344:    */           
/* 345:718 */           this.__lastMatchedBufferOffset = (i + 1);
/* 346:    */           
/* 347:720 */           return;
/* 348:    */         }
/* 349:    */       }
/* 350:724 */       this.__lastMatchedBufferOffset = i;
/* 351:    */     }
/* 352:    */   }
/* 353:    */   
/* 354:    */   public MatchResult getMatch()
/* 355:    */   {
/* 356:738 */     return this.__lastMatchResult;
/* 357:    */   }
/* 358:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.AwkMatcher
 * JD-Core Version:    0.7.0.1
 */
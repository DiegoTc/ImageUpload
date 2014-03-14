/*    1:     */ package org.apache.oro.text.regex;
/*    2:     */ 
/*    3:     */ import java.util.Stack;
/*    4:     */ import java.util.Vector;
/*    5:     */ 
/*    6:     */ public final class Perl5Matcher
/*    7:     */   implements PatternMatcher
/*    8:     */ {
/*    9:  78 */   private boolean __lastSuccess = false;
/*   10:  78 */   private boolean __multiline = false;
/*   11:  86 */   private Stack __stack = new Stack();
/*   12:  87 */   private Perl5MatchResult __lastMatchResult = null;
/*   13:     */   
/*   14:     */   private static boolean __compare(char[] paramArrayOfChar1, int paramInt1, char[] paramArrayOfChar2, int paramInt2, int paramInt3)
/*   15:     */   {
/*   16:  94 */     for (int i = 0; i < paramInt3; paramInt2++)
/*   17:     */     {
/*   18:  95 */       if (paramInt1 >= paramArrayOfChar1.length) {
/*   19:  96 */         return false;
/*   20:     */       }
/*   21:  97 */       if (paramInt2 >= paramArrayOfChar2.length) {
/*   22:  98 */         return false;
/*   23:     */       }
/*   24:  99 */       if (paramArrayOfChar1[paramInt1] != paramArrayOfChar2[paramInt2]) {
/*   25: 100 */         return false;
/*   26:     */       }
/*   27:  94 */       i++;paramInt1++;
/*   28:     */     }
/*   29: 103 */     return true;
/*   30:     */   }
/*   31:     */   
/*   32:     */   private static int __findFirst(char[] paramArrayOfChar1, int paramInt1, int paramInt2, char[] paramArrayOfChar2)
/*   33:     */   {
/*   34: 113 */     if (paramArrayOfChar1.length == 0) {
/*   35: 114 */       return paramInt2;
/*   36:     */     }
/*   37: 116 */     int k = paramArrayOfChar2[0];
/*   38: 118 */     while (paramInt1 < paramInt2)
/*   39:     */     {
/*   40: 119 */       if (k == paramArrayOfChar1[paramInt1])
/*   41:     */       {
/*   42: 120 */         int j = paramInt1;
/*   43: 121 */         int i = 0;
/*   44: 123 */         while ((paramInt1 < paramInt2) && (i < paramArrayOfChar2.length))
/*   45:     */         {
/*   46: 124 */           if (paramArrayOfChar2[i] != paramArrayOfChar1[paramInt1]) {
/*   47:     */             break;
/*   48:     */           }
/*   49: 126 */           i++;
/*   50: 127 */           paramInt1++;
/*   51:     */         }
/*   52: 130 */         paramInt1 = j;
/*   53: 132 */         if (i >= paramArrayOfChar2.length) {
/*   54:     */           break;
/*   55:     */         }
/*   56:     */       }
/*   57: 135 */       paramInt1++;
/*   58:     */     }
/*   59: 138 */     return paramInt1;
/*   60:     */   }
/*   61:     */   
/*   62:     */   private void __pushState(int paramInt)
/*   63:     */   {
/*   64: 146 */     int i = 3 * (this.__expSize - paramInt);
/*   65:     */     int[] arrayOfInt;
/*   66: 147 */     if (i <= 0) {
/*   67: 148 */       arrayOfInt = new int[3];
/*   68:     */     } else {
/*   69: 150 */       arrayOfInt = new int[i + 3];
/*   70:     */     }
/*   71: 152 */     arrayOfInt[0] = this.__expSize;
/*   72: 153 */     arrayOfInt[1] = this.__lastParen;
/*   73: 154 */     arrayOfInt[2] = this.__inputOffset;
/*   74: 156 */     for (int j = this.__expSize; j > paramInt; i -= 3)
/*   75:     */     {
/*   76: 157 */       arrayOfInt[i] = this.__endMatchOffsets[j];
/*   77: 158 */       arrayOfInt[(i + 1)] = this.__beginMatchOffsets[j];
/*   78: 159 */       arrayOfInt[(i + 2)] = j;j -= 3;
/*   79:     */     }
/*   80: 162 */     this.__stack.push(arrayOfInt);
/*   81:     */   }
/*   82:     */   
/*   83:     */   private void __popState()
/*   84:     */   {
/*   85: 170 */     int[] arrayOfInt = (int[])this.__stack.pop();
/*   86:     */     
/*   87: 172 */     this.__expSize = arrayOfInt[0];
/*   88: 173 */     this.__lastParen = arrayOfInt[1];
/*   89: 174 */     this.__inputOffset = arrayOfInt[2];
/*   90: 176 */     for (int i = 3; i < arrayOfInt.length; i += 3)
/*   91:     */     {
/*   92: 177 */       j = arrayOfInt[(i + 2)];
/*   93: 178 */       this.__beginMatchOffsets[j] = arrayOfInt[(i + 1)];
/*   94: 180 */       if (j <= this.__lastParen) {
/*   95: 181 */         this.__endMatchOffsets[j] = arrayOfInt[i];
/*   96:     */       }
/*   97:     */     }
/*   98: 184 */     for (int j = this.__lastParen + 1; j <= this.__numParentheses; j++)
/*   99:     */     {
/*  100: 185 */       if (j > this.__expSize) {
/*  101: 186 */         this.__beginMatchOffsets[j] = -1;
/*  102:     */       }
/*  103: 187 */       this.__endMatchOffsets[j] = -1;
/*  104:     */     }
/*  105:     */   }
/*  106:     */   
/*  107:     */   private void __initInterpreterGlobals(Perl5Pattern paramPerl5Pattern, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
/*  108:     */   {
/*  109: 197 */     this.__input = paramArrayOfChar;
/*  110: 198 */     this.__endOffset = paramInt2;
/*  111: 199 */     this.__currentRep = new Perl5Repetition();
/*  112: 200 */     this.__currentRep._numInstances = 0;
/*  113: 201 */     this.__currentRep._lastRepetition = null;
/*  114: 202 */     this.__program = paramPerl5Pattern._program;
/*  115: 203 */     this.__stack.setSize(0);
/*  116: 209 */     if ((paramInt3 == paramInt1) || (paramInt3 <= 0))
/*  117:     */     {
/*  118: 210 */       this.__previousChar = '\n';
/*  119:     */     }
/*  120:     */     else
/*  121:     */     {
/*  122: 212 */       this.__previousChar = paramArrayOfChar[(paramInt3 - 1)];
/*  123: 213 */       if ((!this.__multiline) && (this.__previousChar == '\n')) {
/*  124: 214 */         this.__previousChar = '\000';
/*  125:     */       }
/*  126:     */     }
/*  127: 217 */     this.__numParentheses = paramPerl5Pattern._numParentheses;
/*  128: 218 */     this.__currentOffset = paramInt3;
/*  129:     */     
/*  130: 220 */     this.__bol = paramInt1;
/*  131: 221 */     this.__eol = paramInt2;
/*  132:     */     
/*  133:     */ 
/*  134: 224 */     paramInt2 = this.__numParentheses + 1;
/*  135: 225 */     if ((this.__beginMatchOffsets == null) || (paramInt2 > this.__beginMatchOffsets.length))
/*  136:     */     {
/*  137: 226 */       if (paramInt2 < 20) {
/*  138: 227 */         paramInt2 = 20;
/*  139:     */       }
/*  140: 228 */       this.__beginMatchOffsets = new int[paramInt2];
/*  141: 229 */       this.__endMatchOffsets = new int[paramInt2];
/*  142:     */     }
/*  143:     */   }
/*  144:     */   
/*  145:     */   private void __setLastMatchResult()
/*  146:     */   {
/*  147: 240 */     this.__lastMatchResult = new Perl5MatchResult(this.__numParentheses + 1);
/*  148: 243 */     if (this.__endMatchOffsets[0] > this.__originalInput.length) {
/*  149: 244 */       throw new ArrayIndexOutOfBoundsException();
/*  150:     */     }
/*  151: 246 */     this.__lastMatchResult._match = 
/*  152: 247 */       new String(this.__originalInput, this.__beginMatchOffsets[0], 
/*  153: 248 */       this.__endMatchOffsets[0] - this.__beginMatchOffsets[0]);
/*  154:     */     
/*  155: 250 */     this.__lastMatchResult._matchBeginOffset = this.__beginMatchOffsets[0];
/*  156: 252 */     while (this.__numParentheses >= 0)
/*  157:     */     {
/*  158: 253 */       int i = this.__beginMatchOffsets[this.__numParentheses];
/*  159: 255 */       if (i >= 0) {
/*  160: 256 */         this.__lastMatchResult._beginGroupOffset[this.__numParentheses] = 
/*  161: 257 */           (i - this.__lastMatchResult._matchBeginOffset);
/*  162:     */       } else {
/*  163: 259 */         this.__lastMatchResult._beginGroupOffset[this.__numParentheses] = 
/*  164: 260 */           -1;
/*  165:     */       }
/*  166: 262 */       i = this.__endMatchOffsets[this.__numParentheses];
/*  167: 264 */       if (i >= 0) {
/*  168: 265 */         this.__lastMatchResult._endGroupOffset[this.__numParentheses] = 
/*  169: 266 */           (i - this.__lastMatchResult._matchBeginOffset);
/*  170:     */       } else {
/*  171: 268 */         this.__lastMatchResult._endGroupOffset[this.__numParentheses] = 
/*  172: 269 */           -1;
/*  173:     */       }
/*  174: 271 */       this.__numParentheses -= 1;
/*  175:     */     }
/*  176: 275 */     this.__originalInput = null;
/*  177:     */   }
/*  178:     */   
/*  179:     */   private boolean __interpret(Perl5Pattern paramPerl5Pattern, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
/*  180:     */   {
/*  181: 289 */     int i = 0;int j = 0;
/*  182:     */     
/*  183:     */ 
/*  184: 292 */     __initInterpreterGlobals(paramPerl5Pattern, paramArrayOfChar, paramInt1, paramInt2, 
/*  185: 293 */       paramInt3);
/*  186:     */     
/*  187: 295 */     boolean bool1 = false;
/*  188: 296 */     char[] arrayOfChar = paramPerl5Pattern._mustString;
/*  189: 301 */     if ((arrayOfChar != null) && (
/*  190: 302 */       ((paramPerl5Pattern._anchor & 0x3) == 0) || (
/*  191: 303 */       ((this.__multiline) || 
/*  192: 304 */       ((paramPerl5Pattern._anchor & 0x2) != 0)) && 
/*  193: 305 */       (paramPerl5Pattern._back >= 0))))
/*  194:     */     {
/*  195: 308 */       this.__currentOffset = 
/*  196: 309 */         __findFirst(this.__input, this.__currentOffset, paramInt2, arrayOfChar);
/*  197: 311 */       if (this.__currentOffset >= paramInt2)
/*  198:     */       {
/*  199: 312 */         if ((paramPerl5Pattern._options & 0x8000) == 0) {
/*  200: 313 */           paramPerl5Pattern._mustUtility += 1;
/*  201:     */         }
/*  202: 314 */         bool1 = false;
/*  203:     */         break label1577;
/*  204:     */       }
/*  205: 316 */       if (paramPerl5Pattern._back >= 0)
/*  206:     */       {
/*  207: 317 */         this.__currentOffset -= paramPerl5Pattern._back;
/*  208: 318 */         if (this.__currentOffset < paramInt1) {
/*  209: 319 */           this.__currentOffset = paramInt1;
/*  210:     */         }
/*  211: 320 */         i = paramPerl5Pattern._back + arrayOfChar.length;
/*  212:     */       }
/*  213:     */       else
/*  214:     */       {
/*  215: 321 */         if ((!paramPerl5Pattern._isExpensive) && 
/*  216: 322 */           ((paramPerl5Pattern._options & 0x8000) == 0)) {
/*  217: 323 */           if (--paramPerl5Pattern._mustUtility < 0)
/*  218:     */           {
/*  219: 327 */             arrayOfChar = paramPerl5Pattern._mustString = null;
/*  220: 328 */             this.__currentOffset = paramInt1;
/*  221:     */             break label220;
/*  222:     */           }
/*  223:     */         }
/*  224: 330 */         this.__currentOffset = paramInt1;
/*  225: 331 */         i = arrayOfChar.length;
/*  226:     */       }
/*  227:     */     }
/*  228:     */     label220:
/*  229: 335 */     if ((paramPerl5Pattern._anchor & 0x3) != 0)
/*  230:     */     {
/*  231: 336 */       if (__tryExpression(paramPerl5Pattern, paramInt1))
/*  232:     */       {
/*  233: 337 */         bool1 = true;
/*  234:     */       }
/*  235: 339 */       else if ((this.__multiline) || 
/*  236: 340 */         ((paramPerl5Pattern._anchor & 0x2) != 0) || 
/*  237: 341 */         ((paramPerl5Pattern._anchor & 0x8) != 0))
/*  238:     */       {
/*  239: 343 */         if (i > 0) {
/*  240: 344 */           j = i - 1;
/*  241:     */         }
/*  242: 345 */         paramInt2 -= j;
/*  243: 347 */         if (this.__currentOffset > paramInt1) {
/*  244: 348 */           this.__currentOffset -= 1;
/*  245:     */         }
/*  246: 350 */         while (this.__currentOffset < paramInt2) {
/*  247: 351 */           if ((this.__input[(this.__currentOffset++)] == '\n') && 
/*  248: 352 */             (this.__currentOffset < paramInt2) && 
/*  249: 353 */             (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  250:     */           {
/*  251: 354 */             bool1 = true;
/*  252: 355 */             break;
/*  253:     */           }
/*  254:     */         }
/*  255:     */       }
/*  256:     */     }
/*  257:     */     else
/*  258:     */     {
/*  259:     */       int m;
/*  260: 365 */       if (paramPerl5Pattern._startString != null)
/*  261:     */       {
/*  262: 366 */         arrayOfChar = paramPerl5Pattern._startString;
/*  263: 367 */         if ((paramPerl5Pattern._anchor & 0x4) != 0)
/*  264:     */         {
/*  265: 368 */           m = arrayOfChar[0];
/*  266: 370 */           while (this.__currentOffset < paramInt2)
/*  267:     */           {
/*  268: 371 */             if (m == this.__input[this.__currentOffset])
/*  269:     */             {
/*  270: 372 */               if (__tryExpression(paramPerl5Pattern, this.__currentOffset))
/*  271:     */               {
/*  272: 373 */                 bool1 = true;
/*  273: 374 */                 break;
/*  274:     */               }
/*  275: 376 */               this.__currentOffset += 1;
/*  276: 377 */               while ((this.__currentOffset < paramInt2) && 
/*  277: 378 */                 (this.__input[this.__currentOffset] == m)) {
/*  278: 379 */                 this.__currentOffset += 1;
/*  279:     */               }
/*  280:     */             }
/*  281: 381 */             this.__currentOffset += 1;
/*  282:     */           }
/*  283:     */         }
/*  284:     */         else
/*  285:     */         {
/*  286: 387 */           while ((this.__currentOffset = __findFirst(this.__input, this.__currentOffset, paramInt2, arrayOfChar)) < paramInt2)
/*  287:     */           {
/*  288: 388 */             if (__tryExpression(paramPerl5Pattern, this.__currentOffset))
/*  289:     */             {
/*  290: 389 */               bool1 = true;
/*  291: 390 */               break;
/*  292:     */             }
/*  293: 392 */             this.__currentOffset += 1;
/*  294:     */           }
/*  295:     */         }
/*  296:     */       }
/*  297:     */       else
/*  298:     */       {
/*  299:     */         int k;
/*  300:     */         boolean bool2;
/*  301:     */         boolean bool3;
/*  302: 399 */         if ((k = paramPerl5Pattern._startClassOffset) != -1)
/*  303:     */         {
/*  304: 402 */           bool2 = (paramPerl5Pattern._anchor & 0x4) == 0;
/*  305: 404 */           if (i > 0) {
/*  306: 405 */             j = i - 1;
/*  307:     */           }
/*  308: 406 */           paramInt2 -= j;
/*  309: 407 */           bool3 = true;
/*  310:     */         }
/*  311:     */         char c;
/*  312: 409 */         switch (this.__program[k])
/*  313:     */         {
/*  314:     */         case '\t': 
/*  315: 411 */           k = OpCode._getOperand(k);
/*  316: 412 */           while (this.__currentOffset < paramInt2)
/*  317:     */           {
/*  318: 413 */             m = this.__input[this.__currentOffset];
/*  319: 415 */             if ((m < 256) && 
/*  320: 416 */               ((this.__program[(k + (m >> 4))] & 1 << (m & 0xF)) == 0))
/*  321:     */             {
/*  322: 417 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  323:     */               {
/*  324: 418 */                 bool1 = true;
/*  325: 419 */                 break;
/*  326:     */               }
/*  327: 421 */               bool3 = bool2;
/*  328:     */             }
/*  329:     */             else
/*  330:     */             {
/*  331: 423 */               bool3 = true;
/*  332:     */             }
/*  333: 424 */             this.__currentOffset += 1;
/*  334:     */           }
/*  335: 427 */           break;
/*  336:     */         case '\024': 
/*  337: 430 */           if (i > 0)
/*  338:     */           {
/*  339: 431 */             j++;
/*  340: 432 */             paramInt2--;
/*  341:     */           }
/*  342: 435 */           if (this.__currentOffset != paramInt1)
/*  343:     */           {
/*  344: 436 */             m = this.__input[(this.__currentOffset - 1)];
/*  345: 437 */             bool3 = OpCode._isWordCharacter(m);
/*  346:     */           }
/*  347:     */           else
/*  348:     */           {
/*  349: 439 */             bool3 = OpCode._isWordCharacter(this.__previousChar);
/*  350:     */           }
/*  351: 441 */           while (this.__currentOffset < paramInt2)
/*  352:     */           {
/*  353: 442 */             c = this.__input[this.__currentOffset];
/*  354: 443 */             if (bool3 != OpCode._isWordCharacter(c))
/*  355:     */             {
/*  356: 444 */               bool3 ^= true;
/*  357: 445 */               if (__tryExpression(paramPerl5Pattern, this.__currentOffset))
/*  358:     */               {
/*  359: 446 */                 bool1 = true;
/*  360: 447 */                 break;
/*  361:     */               }
/*  362:     */             }
/*  363: 450 */             this.__currentOffset += 1;
/*  364:     */           }
/*  365: 453 */           if (((i > 0) || (bool3)) && 
/*  366: 454 */             (__tryExpression(paramPerl5Pattern, this.__currentOffset))) {
/*  367: 455 */             bool1 = true;
/*  368:     */           }
/*  369: 456 */           break;
/*  370:     */         case '\025': 
/*  371: 461 */           if (i > 0)
/*  372:     */           {
/*  373: 462 */             j++;
/*  374: 463 */             paramInt2--;
/*  375:     */           }
/*  376: 466 */           if (this.__currentOffset != paramInt1)
/*  377:     */           {
/*  378: 467 */             c = this.__input[(this.__currentOffset - 1)];
/*  379: 468 */             bool3 = OpCode._isWordCharacter(c);
/*  380:     */           }
/*  381:     */           else
/*  382:     */           {
/*  383: 470 */             bool3 = OpCode._isWordCharacter(this.__previousChar);
/*  384:     */           }
/*  385: 472 */           while (this.__currentOffset < paramInt2)
/*  386:     */           {
/*  387: 473 */             c = this.__input[this.__currentOffset];
/*  388: 474 */             if (bool3 != OpCode._isWordCharacter(c))
/*  389:     */             {
/*  390: 475 */               bool3 ^= true;
/*  391:     */             }
/*  392: 476 */             else if (__tryExpression(paramPerl5Pattern, this.__currentOffset))
/*  393:     */             {
/*  394: 477 */               bool1 = true;
/*  395: 478 */               break;
/*  396:     */             }
/*  397: 481 */             this.__currentOffset += 1;
/*  398:     */           }
/*  399: 484 */           if (((i > 0) || (!bool3)) && 
/*  400: 485 */             (__tryExpression(paramPerl5Pattern, this.__currentOffset))) {
/*  401: 486 */             bool1 = true;
/*  402:     */           }
/*  403: 487 */           break;
/*  404:     */         case '\022': 
/*  405:     */           do
/*  406:     */           {
/*  407: 493 */             c = this.__input[this.__currentOffset];
/*  408: 494 */             if (OpCode._isWordCharacter(c))
/*  409:     */             {
/*  410: 495 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  411:     */               {
/*  412: 496 */                 bool1 = true;
/*  413: 497 */                 break;
/*  414:     */               }
/*  415: 499 */               bool3 = bool2;
/*  416:     */             }
/*  417:     */             else
/*  418:     */             {
/*  419: 501 */               bool3 = true;
/*  420:     */             }
/*  421: 502 */             this.__currentOffset += 1;
/*  422: 492 */           } while (this.__currentOffset < paramInt2);
/*  423: 504 */           break;
/*  424:     */         case '\023': 
/*  425:     */           do
/*  426:     */           {
/*  427: 508 */             c = this.__input[this.__currentOffset];
/*  428: 509 */             if (!OpCode._isWordCharacter(c))
/*  429:     */             {
/*  430: 510 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  431:     */               {
/*  432: 511 */                 bool1 = true;
/*  433: 512 */                 break;
/*  434:     */               }
/*  435: 514 */               bool3 = bool2;
/*  436:     */             }
/*  437:     */             else
/*  438:     */             {
/*  439: 516 */               bool3 = true;
/*  440:     */             }
/*  441: 517 */             this.__currentOffset += 1;
/*  442: 507 */           } while (this.__currentOffset < paramInt2);
/*  443: 519 */           break;
/*  444:     */         case '\026': 
/*  445:     */           do
/*  446:     */           {
/*  447: 523 */             if (Character.isWhitespace(this.__input[this.__currentOffset]))
/*  448:     */             {
/*  449: 524 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  450:     */               {
/*  451: 525 */                 bool1 = true;
/*  452: 526 */                 break;
/*  453:     */               }
/*  454: 528 */               bool3 = bool2;
/*  455:     */             }
/*  456:     */             else
/*  457:     */             {
/*  458: 530 */               bool3 = true;
/*  459:     */             }
/*  460: 531 */             this.__currentOffset += 1;
/*  461: 522 */           } while (this.__currentOffset < paramInt2);
/*  462: 533 */           break;
/*  463:     */         case '\027': 
/*  464:     */           do
/*  465:     */           {
/*  466: 537 */             if (!Character.isWhitespace(this.__input[this.__currentOffset]))
/*  467:     */             {
/*  468: 538 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  469:     */               {
/*  470: 539 */                 bool1 = true;
/*  471: 540 */                 break;
/*  472:     */               }
/*  473: 542 */               bool3 = bool2;
/*  474:     */             }
/*  475:     */             else
/*  476:     */             {
/*  477: 544 */               bool3 = true;
/*  478:     */             }
/*  479: 545 */             this.__currentOffset += 1;
/*  480: 536 */           } while (this.__currentOffset < paramInt2);
/*  481: 547 */           break;
/*  482:     */         case '\030': 
/*  483:     */           do
/*  484:     */           {
/*  485: 551 */             if (Character.isDigit(this.__input[this.__currentOffset]))
/*  486:     */             {
/*  487: 552 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  488:     */               {
/*  489: 553 */                 bool1 = true;
/*  490: 554 */                 break;
/*  491:     */               }
/*  492: 556 */               bool3 = bool2;
/*  493:     */             }
/*  494:     */             else
/*  495:     */             {
/*  496: 558 */               bool3 = true;
/*  497:     */             }
/*  498: 559 */             this.__currentOffset += 1;
/*  499: 550 */           } while (this.__currentOffset < paramInt2);
/*  500: 561 */           break;
/*  501:     */         case '\031': 
/*  502:     */           do
/*  503:     */           {
/*  504: 566 */             if (!Character.isDigit(this.__input[this.__currentOffset]))
/*  505:     */             {
/*  506: 567 */               if ((bool3) && (__tryExpression(paramPerl5Pattern, this.__currentOffset)))
/*  507:     */               {
/*  508: 568 */                 bool1 = true;
/*  509: 569 */                 break;
/*  510:     */               }
/*  511: 571 */               bool3 = bool2;
/*  512:     */             }
/*  513:     */             else
/*  514:     */             {
/*  515: 573 */               bool3 = true;
/*  516:     */             }
/*  517: 574 */             this.__currentOffset += 1;
/*  518: 565 */           } while (this.__currentOffset < paramInt2);
/*  519: 576 */           break;
/*  520: 580 */           if (i > 0) {
/*  521: 581 */             j = i - 1;
/*  522:     */           }
/*  523: 582 */           paramInt2 -= j;
/*  524:     */           for (;;)
/*  525:     */           {
/*  526: 585 */             if (__tryExpression(paramPerl5Pattern, this.__currentOffset)) {
/*  527: 586 */               bool1 = true;
/*  528: 589 */             } else if (this.__currentOffset++ >= paramInt2) {
/*  529:     */               break;
/*  530:     */             }
/*  531:     */           }
/*  532:     */         }
/*  533:     */       }
/*  534:     */     }
/*  535:     */     label1577:
/*  536: 597 */     this.__lastSuccess = bool1;
/*  537: 598 */     this.__lastMatchResult = null;
/*  538:     */     
/*  539: 600 */     return bool1;
/*  540:     */   }
/*  541:     */   
/*  542:     */   private boolean __tryExpression(Perl5Pattern paramPerl5Pattern, int paramInt)
/*  543:     */   {
/*  544: 607 */     this.__inputOffset = paramInt;
/*  545: 608 */     this.__lastParen = 0;
/*  546: 609 */     this.__expSize = 0;
/*  547: 611 */     if (this.__numParentheses > 0) {
/*  548: 612 */       for (int i = 0; i <= this.__numParentheses; i++)
/*  549:     */       {
/*  550: 613 */         this.__beginMatchOffsets[i] = -1;
/*  551: 614 */         this.__endMatchOffsets[i] = -1;
/*  552:     */       }
/*  553:     */     }
/*  554: 618 */     if (__match(1))
/*  555:     */     {
/*  556: 619 */       this.__beginMatchOffsets[0] = paramInt;
/*  557: 620 */       this.__endMatchOffsets[0] = this.__inputOffset;
/*  558: 621 */       return true;
/*  559:     */     }
/*  560: 624 */     return false;
/*  561:     */   }
/*  562:     */   
/*  563:     */   private int __repeat(int paramInt1, int paramInt2)
/*  564:     */   {
/*  565: 632 */     int i = this.__inputOffset;
/*  566: 633 */     int j = this.__eol;
/*  567: 635 */     if ((paramInt2 != 65535) && (paramInt2 < j - i)) {
/*  568: 636 */       j = i + paramInt2;
/*  569:     */     }
/*  570: 638 */     int k = OpCode._getOperand(paramInt1);
/*  571: 640 */     switch (this.__program[paramInt1])
/*  572:     */     {
/*  573:     */     case '\007': 
/*  574:     */       do
/*  575:     */       {
/*  576: 644 */         i++;
/*  577: 643 */         if (i >= j) {
/*  578:     */           break;
/*  579:     */         }
/*  580: 643 */       } while (this.__input[i] != '\n');
/*  581: 645 */       break;
/*  582:     */     case '\b': 
/*  583: 648 */       i = j;
/*  584: 649 */       break;
/*  585:     */     case '\016': 
/*  586: 652 */       k++;
/*  587:     */       do
/*  588:     */       {
/*  589: 654 */         i++;
/*  590: 653 */         if (i >= j) {
/*  591:     */           break;
/*  592:     */         }
/*  593: 653 */       } while (this.__program[k] == this.__input[i]);
/*  594:     */     case '\t': 
/*  595:     */       int n;
/*  596: 655 */       if ((goto 409) && 
/*  597:     */       
/*  598:     */ 
/*  599: 658 */         (i < j) && ((n = this.__input[i]) < 'Ä€')) {
/*  600: 659 */         while ((this.__program[(k + (n >> 4))] & 1 << (n & 0xF)) == 0)
/*  601:     */         {
/*  602: 660 */           i++;
/*  603: 660 */           if (i >= j) {
/*  604:     */             break;
/*  605:     */           }
/*  606: 661 */           n = this.__input[i];
/*  607:     */         }
/*  608:     */       }
/*  609: 666 */       break;
/*  610:     */     case '\022': 
/*  611:     */       do
/*  612:     */       {
/*  613: 670 */         i++;
/*  614: 669 */         if (i >= j) {
/*  615:     */           break;
/*  616:     */         }
/*  617: 669 */       } while (OpCode._isWordCharacter(this.__input[i]));
/*  618: 671 */       break;
/*  619:     */     case '\023': 
/*  620:     */       do
/*  621:     */       {
/*  622: 675 */         i++;
/*  623: 674 */         if (i >= j) {
/*  624:     */           break;
/*  625:     */         }
/*  626: 674 */       } while (!OpCode._isWordCharacter(this.__input[i]));
/*  627: 676 */       break;
/*  628:     */     case '\026': 
/*  629:     */       do
/*  630:     */       {
/*  631: 680 */         i++;
/*  632: 679 */         if (i >= j) {
/*  633:     */           break;
/*  634:     */         }
/*  635: 679 */       } while (Character.isWhitespace(this.__input[i]));
/*  636: 681 */       break;
/*  637:     */     case '\027': 
/*  638:     */       do
/*  639:     */       {
/*  640: 685 */         i++;
/*  641: 684 */         if (i >= j) {
/*  642:     */           break;
/*  643:     */         }
/*  644: 684 */       } while (!Character.isWhitespace(this.__input[i]));
/*  645: 686 */       break;
/*  646:     */     case '\030': 
/*  647:     */       do
/*  648:     */       {
/*  649: 690 */         i++;
/*  650: 689 */         if (i >= j) {
/*  651:     */           break;
/*  652:     */         }
/*  653: 689 */       } while (Character.isDigit(this.__input[i]));
/*  654: 691 */       break;
/*  655:     */     case '\031': 
/*  656:     */       for (;;)
/*  657:     */       {
/*  658: 695 */         i++;
/*  659: 694 */         if (i < j) {
/*  660: 694 */           if (Character.isDigit(this.__input[i])) {
/*  661:     */             break;
/*  662:     */           }
/*  663:     */         }
/*  664:     */       }
/*  665:     */     }
/*  666: 703 */     int m = i - this.__inputOffset;
/*  667: 704 */     this.__inputOffset = i;
/*  668:     */     
/*  669: 706 */     return m;
/*  670:     */   }
/*  671:     */   
/*  672:     */   private boolean __match(int paramInt)
/*  673:     */   {
/*  674: 713 */     int i2 = 1;int i3 = 0;
/*  675:     */     
/*  676:     */ 
/*  677:     */ 
/*  678: 717 */     int n = this.__inputOffset;
/*  679: 718 */     i2 = n >= this.__endOffset ? 0 : 1;
/*  680: 719 */     int i = i2 != 0 ? this.__input[n] : 65535;
/*  681:     */     
/*  682: 721 */     int k = paramInt;
/*  683: 722 */     int i1 = this.__program.length;
/*  684:     */     break label2555;
/*  685: 725 */     int m = OpCode._getNext(this.__program, k);
/*  686:     */     int j;
/*  687: 727 */     switch (j = this.__program[k])
/*  688:     */     {
/*  689:     */     case '\001': 
/*  690: 730 */       if (this.__previousChar != '\n') {
/*  691: 731 */         if ((!this.__multiline) || ((i2 == 0) && (n >= this.__eol)) || 
/*  692: 732 */           (this.__input[(n - 1)] != '\n')) {
/*  693: 731 */           tmpTernaryOp = (n == this.__bol ? 0 : 0;
/*  694:     */         }
/*  695:     */       }
/*  696:     */       break;
/*  697:     */     }
/*  698:     */   }
/*  699:     */   
/*  700:     */   public void setMultiline(boolean paramBoolean)
/*  701:     */   {
/*  702:1200 */     this.__multiline = paramBoolean;
/*  703:     */   }
/*  704:     */   
/*  705:     */   public boolean isMultiline()
/*  706:     */   {
/*  707:1208 */     return this.__multiline;
/*  708:     */   }
/*  709:     */   
/*  710:     */   char[] _toLower(char[] paramArrayOfChar)
/*  711:     */   {
/*  712:1219 */     char[] arrayOfChar = new char[paramArrayOfChar.length];
/*  713:1220 */     System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramArrayOfChar.length);
/*  714:1221 */     paramArrayOfChar = arrayOfChar;
/*  715:1224 */     for (int i = 0; i < paramArrayOfChar.length; i++) {
/*  716:1225 */       if (Character.isUpperCase(paramArrayOfChar[i])) {
/*  717:1226 */         paramArrayOfChar[i] = Character.toLowerCase(paramArrayOfChar[i]);
/*  718:     */       }
/*  719:     */     }
/*  720:1228 */     return paramArrayOfChar;
/*  721:     */   }
/*  722:     */   
/*  723:     */   public boolean matchesPrefix(char[] paramArrayOfChar, Pattern paramPattern, int paramInt)
/*  724:     */   {
/*  725:1250 */     Perl5Pattern localPerl5Pattern = (Perl5Pattern)paramPattern;
/*  726:1251 */     this.__originalInput = paramArrayOfChar;
/*  727:1252 */     if (localPerl5Pattern._isCaseInsensitive) {
/*  728:1253 */       paramArrayOfChar = _toLower(paramArrayOfChar);
/*  729:     */     }
/*  730:1255 */     __initInterpreterGlobals(localPerl5Pattern, paramArrayOfChar, 0, paramArrayOfChar.length, paramInt);
/*  731:     */     
/*  732:1257 */     this.__lastSuccess = __tryExpression(localPerl5Pattern, paramInt);
/*  733:1258 */     this.__lastMatchResult = null;
/*  734:     */     
/*  735:1260 */     return this.__lastSuccess;
/*  736:     */   }
/*  737:     */   
/*  738:     */   public boolean matchesPrefix(char[] paramArrayOfChar, Pattern paramPattern)
/*  739:     */   {
/*  740:1279 */     return matchesPrefix(paramArrayOfChar, paramPattern, 0);
/*  741:     */   }
/*  742:     */   
/*  743:     */   public boolean matchesPrefix(String paramString, Pattern paramPattern)
/*  744:     */   {
/*  745:1297 */     return matchesPrefix(paramString.toCharArray(), paramPattern, 0);
/*  746:     */   }
/*  747:     */   
/*  748:     */   public boolean matchesPrefix(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern)
/*  749:     */   {
/*  750:1323 */     Perl5Pattern localPerl5Pattern = (Perl5Pattern)paramPattern;
/*  751:     */     
/*  752:1325 */     this.__originalInput = paramPatternMatcherInput._originalBuffer;
/*  753:     */     char[] arrayOfChar;
/*  754:1326 */     if (localPerl5Pattern._isCaseInsensitive)
/*  755:     */     {
/*  756:1327 */       if (paramPatternMatcherInput._toLowerBuffer == null) {
/*  757:1328 */         paramPatternMatcherInput._toLowerBuffer = _toLower(this.__originalInput);
/*  758:     */       }
/*  759:1329 */       arrayOfChar = paramPatternMatcherInput._toLowerBuffer;
/*  760:     */     }
/*  761:     */     else
/*  762:     */     {
/*  763:1331 */       arrayOfChar = this.__originalInput;
/*  764:     */     }
/*  765:1333 */     __initInterpreterGlobals(localPerl5Pattern, arrayOfChar, paramPatternMatcherInput._beginOffset, 
/*  766:1334 */       paramPatternMatcherInput._endOffset, paramPatternMatcherInput._currentOffset);
/*  767:1335 */     this.__lastSuccess = __tryExpression(localPerl5Pattern, paramPatternMatcherInput._currentOffset);
/*  768:1336 */     this.__lastMatchResult = null;
/*  769:     */     
/*  770:1338 */     return this.__lastSuccess;
/*  771:     */   }
/*  772:     */   
/*  773:     */   public boolean matches(char[] paramArrayOfChar, Pattern paramPattern)
/*  774:     */   {
/*  775:1384 */     Perl5Pattern localPerl5Pattern = (Perl5Pattern)paramPattern;
/*  776:1385 */     this.__originalInput = paramArrayOfChar;
/*  777:1386 */     if (localPerl5Pattern._isCaseInsensitive) {
/*  778:1387 */       paramArrayOfChar = _toLower(paramArrayOfChar);
/*  779:     */     }
/*  780:1395 */     __initInterpreterGlobals(localPerl5Pattern, paramArrayOfChar, 0, paramArrayOfChar.length, 0);
/*  781:1396 */     this.__lastSuccess = ((__tryExpression(localPerl5Pattern, 0)) && 
/*  782:1397 */       (this.__endMatchOffsets[0] == paramArrayOfChar.length));
/*  783:1398 */     this.__lastMatchResult = null;
/*  784:     */     
/*  785:1400 */     return this.__lastSuccess;
/*  786:     */   }
/*  787:     */   
/*  788:     */   public boolean matches(String paramString, Pattern paramPattern)
/*  789:     */   {
/*  790:1442 */     return matches(paramString.toCharArray(), paramPattern);
/*  791:     */   }
/*  792:     */   
/*  793:     */   public boolean matches(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern)
/*  794:     */   {
/*  795:1494 */     Perl5Pattern localPerl5Pattern = (Perl5Pattern)paramPattern;
/*  796:     */     
/*  797:1496 */     this.__originalInput = paramPatternMatcherInput._originalBuffer;
/*  798:     */     char[] arrayOfChar;
/*  799:1497 */     if (localPerl5Pattern._isCaseInsensitive)
/*  800:     */     {
/*  801:1498 */       if (paramPatternMatcherInput._toLowerBuffer == null) {
/*  802:1499 */         paramPatternMatcherInput._toLowerBuffer = _toLower(this.__originalInput);
/*  803:     */       }
/*  804:1500 */       arrayOfChar = paramPatternMatcherInput._toLowerBuffer;
/*  805:     */     }
/*  806:     */     else
/*  807:     */     {
/*  808:1502 */       arrayOfChar = this.__originalInput;
/*  809:     */     }
/*  810:1524 */     __initInterpreterGlobals(localPerl5Pattern, arrayOfChar, paramPatternMatcherInput._beginOffset, 
/*  811:1525 */       paramPatternMatcherInput._endOffset, paramPatternMatcherInput._beginOffset);
/*  812:     */     
/*  813:1527 */     this.__lastMatchResult = null;
/*  814:1529 */     if ((__tryExpression(localPerl5Pattern, paramPatternMatcherInput._beginOffset)) && (
/*  815:1530 */       (this.__endMatchOffsets[0] == paramPatternMatcherInput._endOffset) || 
/*  816:1531 */       (paramPatternMatcherInput.length() == 0) || (paramPatternMatcherInput._beginOffset == paramPatternMatcherInput._endOffset)))
/*  817:     */     {
/*  818:1532 */       this.__lastSuccess = true;
/*  819:1533 */       return true;
/*  820:     */     }
/*  821:1537 */     this.__lastSuccess = false;
/*  822:     */     
/*  823:1539 */     return false;
/*  824:     */   }
/*  825:     */   
/*  826:     */   public boolean contains(String paramString, Pattern paramPattern)
/*  827:     */   {
/*  828:1582 */     return contains(paramString.toCharArray(), paramPattern);
/*  829:     */   }
/*  830:     */   
/*  831:     */   public boolean contains(char[] paramArrayOfChar, Pattern paramPattern)
/*  832:     */   {
/*  833:1613 */     Perl5Pattern localPerl5Pattern = (Perl5Pattern)paramPattern;
/*  834:     */     
/*  835:1615 */     this.__originalInput = paramArrayOfChar;
/*  836:1617 */     if (localPerl5Pattern._isCaseInsensitive) {
/*  837:1618 */       paramArrayOfChar = _toLower(paramArrayOfChar);
/*  838:     */     }
/*  839:1620 */     return __interpret(localPerl5Pattern, paramArrayOfChar, 0, paramArrayOfChar.length, 0);
/*  840:     */   }
/*  841:     */   
/*  842:1625 */   private int __lastMatchInputEndOffset = -100;
/*  843:     */   private static final char __EOS = 'ð¿¿';
/*  844:     */   private static final int __INITIAL_NUM_OFFSETS = 20;
/*  845:     */   private char __previousChar;
/*  846:     */   private char[] __input;
/*  847:     */   private char[] __originalInput;
/*  848:     */   private Perl5Repetition __currentRep;
/*  849:     */   private int __numParentheses;
/*  850:     */   private int __bol;
/*  851:     */   private int __eol;
/*  852:     */   private int __currentOffset;
/*  853:     */   private int __endOffset;
/*  854:     */   private char[] __program;
/*  855:     */   private int __expSize;
/*  856:     */   private int __inputOffset;
/*  857:     */   private int __lastParen;
/*  858:     */   private int[] __beginMatchOffsets;
/*  859:     */   private int[] __endMatchOffsets;
/*  860:     */   private static final int __DEFAULT_LAST_MATCH_END_OFFSET = -100;
/*  861:     */   
/*  862:     */   public boolean contains(PatternMatcherInput paramPatternMatcherInput, Pattern paramPattern)
/*  863:     */   {
/*  864:1698 */     if (paramPatternMatcherInput._currentOffset > paramPatternMatcherInput._endOffset) {
/*  865:1699 */       return false;
/*  866:     */     }
/*  867:1705 */     Perl5Pattern localPerl5Pattern = (Perl5Pattern)paramPattern;
/*  868:1706 */     this.__originalInput = paramPatternMatcherInput._originalBuffer;
/*  869:     */     
/*  870:     */ 
/*  871:     */ 
/*  872:     */ 
/*  873:     */ 
/*  874:     */ 
/*  875:1713 */     this.__originalInput = paramPatternMatcherInput._originalBuffer;
/*  876:     */     char[] arrayOfChar;
/*  877:1714 */     if (localPerl5Pattern._isCaseInsensitive)
/*  878:     */     {
/*  879:1715 */       if (paramPatternMatcherInput._toLowerBuffer == null) {
/*  880:1716 */         paramPatternMatcherInput._toLowerBuffer = _toLower(this.__originalInput);
/*  881:     */       }
/*  882:1717 */       arrayOfChar = paramPatternMatcherInput._toLowerBuffer;
/*  883:     */     }
/*  884:     */     else
/*  885:     */     {
/*  886:1719 */       arrayOfChar = this.__originalInput;
/*  887:     */     }
/*  888:1721 */     this.__lastMatchInputEndOffset = paramPatternMatcherInput.getMatchEndOffset();
/*  889:     */     
/*  890:1723 */     boolean bool = 
/*  891:1724 */       __interpret(localPerl5Pattern, arrayOfChar, paramPatternMatcherInput._beginOffset, paramPatternMatcherInput._endOffset, 
/*  892:1725 */       paramPatternMatcherInput._currentOffset);
/*  893:1727 */     if (bool)
/*  894:     */     {
/*  895:1728 */       paramPatternMatcherInput.setCurrentOffset(this.__endMatchOffsets[0]);
/*  896:1729 */       paramPatternMatcherInput.setMatchOffsets(this.__beginMatchOffsets[0], this.__endMatchOffsets[0]);
/*  897:     */     }
/*  898:     */     else
/*  899:     */     {
/*  900:1731 */       paramPatternMatcherInput.setCurrentOffset(paramPatternMatcherInput._endOffset + 1);
/*  901:     */     }
/*  902:1735 */     this.__lastMatchInputEndOffset = -100;
/*  903:     */     
/*  904:1737 */     return bool;
/*  905:     */   }
/*  906:     */   
/*  907:     */   public MatchResult getMatch()
/*  908:     */   {
/*  909:1757 */     if (!this.__lastSuccess) {
/*  910:1758 */       return null;
/*  911:     */     }
/*  912:1760 */     if (this.__lastMatchResult == null) {
/*  913:1761 */       __setLastMatchResult();
/*  914:     */     }
/*  915:1763 */     return this.__lastMatchResult;
/*  916:     */   }
/*  917:     */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Perl5Matcher
 * JD-Core Version:    0.7.0.1
 */
/*    1:     */ package org.apache.oro.text.regex;
/*    2:     */ 
/*    3:     */ public final class Perl5Compiler
/*    4:     */   implements PatternCompiler
/*    5:     */ {
/*    6:     */   private static final int __WORSTCASE = 0;
/*    7:     */   private static final int __NONNULL = 1;
/*    8:     */   private static final int __SIMPLE = 2;
/*    9:     */   private static final int __SPSTART = 4;
/*   10:     */   private static final int __TRYAGAIN = 8;
/*   11:     */   private static final char __CASE_INSENSITIVE = '\001';
/*   12:     */   private static final char __GLOBAL = '\002';
/*   13:     */   private static final char __KEEP = '\004';
/*   14:     */   private static final char __MULTILINE = '\b';
/*   15:     */   private static final char __SINGLELINE = '\020';
/*   16:     */   private static final char __EXTENDED = ' ';
/*   17:     */   private static final char __READ_ONLY = 'ËÄÄ';
/*   18:     */   private static final String __META_CHARS = "^$.[()|?+*\\";
/*   19:     */   private static final String __HEX_DIGIT = "0123456789abcdef0123456789ABCDEFx";
/*   20:     */   private CharStringPointer __input;
/*   21:     */   private boolean __sawBackreference;
/*   22:  94 */   private char[] __modifierFlags = new char[1];
/*   23:     */   private int __numParentheses;
/*   24:     */   private int __programSize;
/*   25:     */   private int __cost;
/*   26:     */   private char[] __program;
/*   27:     */   public static final int DEFAULT_MASK = 0;
/*   28:     */   public static final int CASE_INSENSITIVE_MASK = 1;
/*   29:     */   public static final int MULTILINE_MASK = 8;
/*   30:     */   public static final int SINGLELINE_MASK = 16;
/*   31:     */   public static final int EXTENDED_MASK = 32;
/*   32:     */   public static final int READ_ONLY_MASK = 32768;
/*   33:     */   
/*   34:     */   public static final String quotemeta(char[] paramArrayOfChar)
/*   35:     */   {
/*   36: 209 */     StringBuffer localStringBuffer = new StringBuffer(2 * paramArrayOfChar.length);
/*   37: 210 */     for (int i = 0; i < paramArrayOfChar.length; i++)
/*   38:     */     {
/*   39: 211 */       if (!OpCode._isWordCharacter(paramArrayOfChar[i])) {
/*   40: 212 */         localStringBuffer.append('\\');
/*   41:     */       }
/*   42: 213 */       localStringBuffer.append(paramArrayOfChar[i]);
/*   43:     */     }
/*   44: 216 */     return localStringBuffer.toString();
/*   45:     */   }
/*   46:     */   
/*   47:     */   public static final String quotemeta(String paramString)
/*   48:     */   {
/*   49: 234 */     return quotemeta(paramString.toCharArray());
/*   50:     */   }
/*   51:     */   
/*   52:     */   private static boolean __isSimpleRepetitionOp(char paramChar)
/*   53:     */   {
/*   54: 238 */     return (paramChar == '*') || (paramChar == '+') || (paramChar == '?');
/*   55:     */   }
/*   56:     */   
/*   57:     */   private static boolean __isComplexRepetitionOp(char[] paramArrayOfChar, int paramInt)
/*   58:     */   {
/*   59: 242 */     if ((paramInt < paramArrayOfChar.length) && (paramInt >= 0)) {
/*   60: 243 */       return (paramArrayOfChar[paramInt] == '*') || (paramArrayOfChar[paramInt] == '+') || (paramArrayOfChar[paramInt] == '?') || (
/*   61: 244 */         (paramArrayOfChar[paramInt] == '{') && (__parseRepetition(paramArrayOfChar, paramInt)));
/*   62:     */     }
/*   63: 245 */     return false;
/*   64:     */   }
/*   65:     */   
/*   66:     */   private static boolean __parseRepetition(char[] paramArrayOfChar, int paramInt)
/*   67:     */   {
/*   68: 250 */     if (paramArrayOfChar[paramInt] != '{') {
/*   69: 251 */       return false;
/*   70:     */     }
/*   71: 252 */     paramInt++;
/*   72: 254 */     if ((paramInt >= paramArrayOfChar.length) || (!Character.isDigit(paramArrayOfChar[paramInt]))) {
/*   73: 255 */       return false;
/*   74:     */     }
/*   75: 257 */     while ((paramInt < paramArrayOfChar.length) && (Character.isDigit(paramArrayOfChar[paramInt]))) {
/*   76: 258 */       paramInt++;
/*   77:     */     }
/*   78: 260 */     if ((paramInt < paramArrayOfChar.length) && (paramArrayOfChar[paramInt] == ',')) {
/*   79: 261 */       paramInt++;
/*   80:     */     }
/*   81: 263 */     while ((paramInt < paramArrayOfChar.length) && (Character.isDigit(paramArrayOfChar[paramInt]))) {
/*   82: 264 */       paramInt++;
/*   83:     */     }
/*   84: 266 */     if ((paramInt >= paramArrayOfChar.length) || (paramArrayOfChar[paramInt] != '}')) {
/*   85: 267 */       return false;
/*   86:     */     }
/*   87: 269 */     return true;
/*   88:     */   }
/*   89:     */   
/*   90:     */   private static int __parseHex(char[] paramArrayOfChar, int paramInt1, int paramInt2, int[] paramArrayOfInt)
/*   91:     */   {
/*   92: 275 */     int i = 0;
/*   93:     */     
/*   94: 277 */     paramArrayOfInt[0] = 0;
/*   95:     */     int j;
/*   96: 278 */     while ((paramInt1 < paramArrayOfChar.length) && (paramInt2-- > 0) && 
/*   97: 279 */       ((j = "0123456789abcdef0123456789ABCDEFx".indexOf(paramArrayOfChar[paramInt1])) != -1))
/*   98:     */     {
/*   99: 280 */       i <<= 4;
/*  100: 281 */       i |= j & 0xF;
/*  101: 282 */       paramInt1++;
/*  102: 283 */       paramArrayOfInt[0] += 1;
/*  103:     */     }
/*  104: 286 */     return i;
/*  105:     */   }
/*  106:     */   
/*  107:     */   private static int __parseOctal(char[] paramArrayOfChar, int paramInt1, int paramInt2, int[] paramArrayOfInt)
/*  108:     */   {
/*  109: 292 */     int i = 0;
/*  110:     */     
/*  111: 294 */     paramArrayOfInt[0] = 0;
/*  112: 295 */     while ((paramInt1 < paramArrayOfChar.length) && 
/*  113: 296 */       (paramInt2 > 0) && (paramArrayOfChar[paramInt1] >= '0') && (paramArrayOfChar[paramInt1] <= '7'))
/*  114:     */     {
/*  115: 297 */       i <<= 3;
/*  116: 298 */       i |= paramArrayOfChar[paramInt1] - '0';
/*  117: 299 */       paramInt2--;
/*  118: 300 */       paramInt1++;
/*  119: 301 */       paramArrayOfInt[0] += 1;
/*  120:     */     }
/*  121: 304 */     return i;
/*  122:     */   }
/*  123:     */   
/*  124:     */   private static void __setModifierFlag(char[] paramArrayOfChar, char paramChar)
/*  125:     */   {
/*  126: 308 */     switch (paramChar)
/*  127:     */     {
/*  128:     */     case 'i': 
/*  129: 309 */       int tmp90_89 = 0;paramArrayOfChar[tmp90_89] = ((char)(paramArrayOfChar[tmp90_89] | 0x1)); return;
/*  130:     */     case 'g': 
/*  131: 310 */       int tmp99_98 = 0;paramArrayOfChar[tmp99_98] = ((char)(paramArrayOfChar[tmp99_98] | 0x2)); return;
/*  132:     */     case 'o': 
/*  133: 311 */       int tmp108_107 = 0;paramArrayOfChar[tmp108_107] = ((char)(paramArrayOfChar[tmp108_107] | 0x4)); return;
/*  134:     */     case 'm': 
/*  135: 312 */       int tmp117_116 = 0;paramArrayOfChar[tmp117_116] = ((char)(paramArrayOfChar[tmp117_116] | 0x8)); return;
/*  136:     */     case 's': 
/*  137: 313 */       int tmp127_126 = 0;paramArrayOfChar[tmp127_126] = ((char)(paramArrayOfChar[tmp127_126] | 0x10)); return;
/*  138:     */     case 'x': 
/*  139: 314 */       int tmp137_136 = 0;paramArrayOfChar[tmp137_136] = ((char)(paramArrayOfChar[tmp137_136] | 0x20)); return;
/*  140:     */     }
/*  141:     */   }
/*  142:     */   
/*  143:     */   private void __emitCode(char paramChar)
/*  144:     */   {
/*  145: 321 */     if (this.__program != null) {
/*  146: 322 */       this.__program[this.__programSize] = paramChar;
/*  147:     */     }
/*  148: 324 */     this.__programSize += 1;
/*  149:     */   }
/*  150:     */   
/*  151:     */   private int __emitNode(char paramChar)
/*  152:     */   {
/*  153: 333 */     int i = this.__programSize;
/*  154: 335 */     if (this.__program == null)
/*  155:     */     {
/*  156: 336 */       this.__programSize += 2;
/*  157:     */     }
/*  158:     */     else
/*  159:     */     {
/*  160: 338 */       this.__program[(this.__programSize++)] = paramChar;
/*  161: 339 */       this.__program[(this.__programSize++)] = '\000';
/*  162:     */     }
/*  163: 342 */     return i;
/*  164:     */   }
/*  165:     */   
/*  166:     */   private int __emitArgNode(char paramChar1, char paramChar2)
/*  167:     */   {
/*  168: 351 */     int i = this.__programSize;
/*  169: 353 */     if (this.__program == null)
/*  170:     */     {
/*  171: 354 */       this.__programSize += 3;
/*  172:     */     }
/*  173:     */     else
/*  174:     */     {
/*  175: 356 */       this.__program[(this.__programSize++)] = paramChar1;
/*  176: 357 */       this.__program[(this.__programSize++)] = '\000';
/*  177: 358 */       this.__program[(this.__programSize++)] = paramChar2;
/*  178:     */     }
/*  179: 361 */     return i;
/*  180:     */   }
/*  181:     */   
/*  182:     */   private void __programInsertOperator(char paramChar, int paramInt)
/*  183:     */   {
/*  184: 369 */     int k = OpCode._opType[paramChar] == '\n' ? 2 : 0;
/*  185: 372 */     if (this.__program == null)
/*  186:     */     {
/*  187: 373 */       this.__programSize += 2 + k;
/*  188: 374 */       return;
/*  189:     */     }
/*  190: 377 */     int i = this.__programSize;
/*  191: 378 */     this.__programSize += 2 + k;
/*  192: 379 */     int j = this.__programSize;
/*  193: 381 */     while (i > paramInt)
/*  194:     */     {
/*  195: 382 */       i--;
/*  196: 383 */       j--;
/*  197: 384 */       this.__program[j] = this.__program[i];
/*  198:     */     }
/*  199: 387 */     this.__program[(paramInt++)] = paramChar;
/*  200: 388 */     this.__program[(paramInt++)] = '\000';
/*  201: 390 */     while (k-- > 0) {
/*  202: 391 */       this.__program[(paramInt++)] = '\000';
/*  203:     */     }
/*  204:     */   }
/*  205:     */   
/*  206:     */   private void __programAddTail(int paramInt1, int paramInt2)
/*  207:     */   {
/*  208: 400 */     if ((this.__program == null) || (paramInt1 == -1)) {
/*  209: 401 */       return;
/*  210:     */     }
/*  211: 403 */     int i = paramInt1;
/*  212:     */     for (;;)
/*  213:     */     {
/*  214: 406 */       int j = OpCode._getNext(this.__program, i);
/*  215: 407 */       if (j == -1) {
/*  216:     */         break;
/*  217:     */       }
/*  218: 409 */       i = j;
/*  219:     */     }
/*  220:     */     int k;
/*  221: 412 */     if (this.__program[i] == '\r') {
/*  222: 413 */       k = i - paramInt2;
/*  223:     */     } else {
/*  224: 415 */       k = paramInt2 - i;
/*  225:     */     }
/*  226: 417 */     this.__program[(i + 1)] = ((char)k);
/*  227:     */   }
/*  228:     */   
/*  229:     */   private void __programAddOperatorTail(int paramInt1, int paramInt2)
/*  230:     */   {
/*  231: 422 */     if ((this.__program == null) || (paramInt1 == -1) || 
/*  232: 423 */       (OpCode._opType[this.__program[paramInt1]] != '\f')) {
/*  233: 424 */       return;
/*  234:     */     }
/*  235: 425 */     __programAddTail(OpCode._getNextOperator(paramInt1), paramInt2);
/*  236:     */   }
/*  237:     */   
/*  238:     */   private char __getNextChar()
/*  239:     */   {
/*  240: 432 */     char c = this.__input._postIncrement();
/*  241:     */     for (;;)
/*  242:     */     {
/*  243: 435 */       int i = this.__input._getValue();
/*  244: 437 */       if ((i == 40) && (this.__input._getValueRelative(1) == '?') && 
/*  245: 438 */         (this.__input._getValueRelative(2) == '#'))
/*  246:     */       {
/*  247: 440 */         while ((i != 65535) && (i != 41)) {
/*  248: 441 */           i = this.__input._increment();
/*  249:     */         }
/*  250: 442 */         this.__input._increment();
/*  251:     */       }
/*  252:     */       else
/*  253:     */       {
/*  254: 446 */         if ((this.__modifierFlags[0] & 0x20) == 0) {
/*  255:     */           break;
/*  256:     */         }
/*  257: 447 */         if (Character.isWhitespace(i))
/*  258:     */         {
/*  259: 448 */           this.__input._increment();
/*  260:     */         }
/*  261:     */         else
/*  262:     */         {
/*  263: 450 */           if (i != 35) {
/*  264:     */             break;
/*  265:     */           }
/*  266:     */           int j;
/*  267: 451 */           while ((j != 65535) && (j != 10)) {
/*  268: 452 */             j = this.__input._increment();
/*  269:     */           }
/*  270: 453 */           this.__input._increment();
/*  271:     */         }
/*  272:     */       }
/*  273:     */     }
/*  274: 461 */     return c;
/*  275:     */   }
/*  276:     */   
/*  277:     */   private int __parseAlternation(int[] paramArrayOfInt)
/*  278:     */     throws MalformedPatternException
/*  279:     */   {
/*  280: 471 */     int m = 0;
/*  281:     */     
/*  282:     */ 
/*  283: 474 */     paramArrayOfInt[0] = 0;
/*  284:     */     
/*  285: 476 */     int j = __emitNode('\f');
/*  286:     */     
/*  287: 478 */     int i = -1;
/*  288: 480 */     if (this.__input._getOffset() == 0)
/*  289:     */     {
/*  290: 481 */       this.__input._setOffset(-1);
/*  291: 482 */       __getNextChar();
/*  292:     */     }
/*  293:     */     else
/*  294:     */     {
/*  295: 484 */       this.__input._decrement();
/*  296: 485 */       __getNextChar();
/*  297:     */     }
/*  298: 488 */     int n = this.__input._getValue();
/*  299: 490 */     while ((n != 65535) && 
/*  300: 491 */       (n != 124) && (n != 41))
/*  301:     */     {
/*  302: 492 */       m &= 0xFFFFFFF7;
/*  303: 493 */       int k = __parseBranch(paramArrayOfInt);
/*  304: 495 */       if (k == -1)
/*  305:     */       {
/*  306: 496 */         if ((m & 0x8) != 0) {
/*  307: 497 */           n = this.__input._getValue();
/*  308:     */         } else {
/*  309: 500 */           return -1;
/*  310:     */         }
/*  311:     */       }
/*  312:     */       else
/*  313:     */       {
/*  314: 503 */         paramArrayOfInt[0] |= m & 0x1;
/*  315: 505 */         if (i == -1)
/*  316:     */         {
/*  317: 506 */           paramArrayOfInt[0] |= m & 0x4;
/*  318:     */         }
/*  319:     */         else
/*  320:     */         {
/*  321: 508 */           this.__cost += 1;
/*  322: 509 */           __programAddTail(i, k);
/*  323:     */         }
/*  324: 511 */         i = k;
/*  325: 512 */         n = this.__input._getValue();
/*  326:     */       }
/*  327:     */     }
/*  328: 516 */     if (i == -1) {
/*  329: 517 */       __emitNode('\017');
/*  330:     */     }
/*  331: 519 */     return j;
/*  332:     */   }
/*  333:     */   
/*  334:     */   private int __parseAtom(int[] paramArrayOfInt)
/*  335:     */     throws MalformedPatternException
/*  336:     */   {
/*  337: 526 */     int[] arrayOfInt1 = new int[1];
/*  338:     */     
/*  339:     */ 
/*  340: 529 */     paramArrayOfInt[0] = 0;
/*  341: 530 */     int i = 0;
/*  342: 531 */     int j = -1;
/*  343:     */     char c1;
/*  344:     */     int k;
/*  345:     */     for (;;)
/*  346:     */     {
/*  347: 536 */       c1 = this.__input._getValue();
/*  348: 538 */       switch (c1)
/*  349:     */       {
/*  350:     */       case '^': 
/*  351: 540 */         __getNextChar();
/*  352: 543 */         if ((this.__modifierFlags[0] & 0x8) != 0) {
/*  353: 544 */           j = __emitNode('\002');
/*  354: 545 */         } else if ((this.__modifierFlags[0] & 0x10) != 0) {
/*  355: 546 */           j = __emitNode('\003');
/*  356:     */         } else {
/*  357: 548 */           j = __emitNode('\001');
/*  358:     */         }
/*  359: 549 */         break;
/*  360:     */       case '$': 
/*  361: 552 */         __getNextChar();
/*  362: 555 */         if ((this.__modifierFlags[0] & 0x8) != 0) {
/*  363: 556 */           j = __emitNode('\005');
/*  364: 557 */         } else if ((this.__modifierFlags[0] & 0x10) != 0) {
/*  365: 558 */           j = __emitNode('\006');
/*  366:     */         } else {
/*  367: 560 */           j = __emitNode('\004');
/*  368:     */         }
/*  369: 561 */         break;
/*  370:     */       case '.': 
/*  371: 564 */         __getNextChar();
/*  372: 567 */         if ((this.__modifierFlags[0] & 0x10) != 0) {
/*  373: 568 */           j = __emitNode('\b');
/*  374:     */         } else {
/*  375: 570 */           j = __emitNode('\007');
/*  376:     */         }
/*  377: 571 */         this.__cost += 1;
/*  378: 572 */         paramArrayOfInt[0] |= 0x3;
/*  379: 573 */         break;
/*  380:     */       case '[': 
/*  381: 576 */         this.__input._increment();
/*  382: 577 */         j = __parseCharacterClass();
/*  383: 578 */         paramArrayOfInt[0] |= 0x3;
/*  384: 579 */         break;
/*  385:     */       case '(': 
/*  386: 582 */         __getNextChar();
/*  387: 583 */         j = __parseExpression(true, arrayOfInt1);
/*  388: 584 */         if (j == -1)
/*  389:     */         {
/*  390: 585 */           if ((arrayOfInt1[0] & 0x8) == 0) {
/*  391: 587 */             return -1;
/*  392:     */           }
/*  393:     */         }
/*  394:     */         else {
/*  395: 589 */           paramArrayOfInt[0] |= arrayOfInt1[0] & 0x5;
/*  396:     */         }
/*  397: 590 */         break;
/*  398:     */       case ')': 
/*  399:     */       case '|': 
/*  400: 594 */         if ((arrayOfInt1[0] & 0x8) != 0)
/*  401:     */         {
/*  402: 595 */           paramArrayOfInt[0] |= 0x8;
/*  403: 596 */           return -1;
/*  404:     */         }
/*  405: 599 */         throw new MalformedPatternException("Error in expression at " + 
/*  406: 600 */           this.__input._toString(this.__input._getOffset()));
/*  407:     */       case '*': 
/*  408:     */       case '+': 
/*  409:     */       case '?': 
/*  410: 606 */         throw new MalformedPatternException(
/*  411: 607 */           "?+* follows nothing in expression");
/*  412:     */       case '\\': 
/*  413: 611 */         c1 = this.__input._increment();
/*  414: 613 */         switch (c1)
/*  415:     */         {
/*  416:     */         case 'A': 
/*  417: 615 */           j = __emitNode('\003');
/*  418: 616 */           paramArrayOfInt[0] |= 0x2;
/*  419: 617 */           __getNextChar();
/*  420: 618 */           break;
/*  421:     */         case 'G': 
/*  422: 620 */           j = __emitNode('\036');
/*  423: 621 */           paramArrayOfInt[0] |= 0x2;
/*  424: 622 */           __getNextChar();
/*  425: 623 */           break;
/*  426:     */         case 'Z': 
/*  427: 625 */           j = __emitNode('\006');
/*  428: 626 */           paramArrayOfInt[0] |= 0x2;
/*  429: 627 */           __getNextChar();
/*  430: 628 */           break;
/*  431:     */         case 'w': 
/*  432: 630 */           j = __emitNode('\022');
/*  433: 631 */           paramArrayOfInt[0] |= 0x3;
/*  434: 632 */           __getNextChar();
/*  435: 633 */           break;
/*  436:     */         case 'W': 
/*  437: 635 */           j = __emitNode('\023');
/*  438: 636 */           paramArrayOfInt[0] |= 0x3;
/*  439: 637 */           __getNextChar();
/*  440: 638 */           break;
/*  441:     */         case 'b': 
/*  442: 640 */           j = __emitNode('\024');
/*  443: 641 */           paramArrayOfInt[0] |= 0x2;
/*  444: 642 */           __getNextChar();
/*  445: 643 */           break;
/*  446:     */         case 'B': 
/*  447: 645 */           j = __emitNode('\025');
/*  448: 646 */           paramArrayOfInt[0] |= 0x2;
/*  449: 647 */           __getNextChar();
/*  450: 648 */           break;
/*  451:     */         case 's': 
/*  452: 650 */           j = __emitNode('\026');
/*  453: 651 */           paramArrayOfInt[0] |= 0x3;
/*  454: 652 */           __getNextChar();
/*  455: 653 */           break;
/*  456:     */         case 'S': 
/*  457: 655 */           j = __emitNode('\027');
/*  458: 656 */           paramArrayOfInt[0] |= 0x3;
/*  459: 657 */           __getNextChar();
/*  460: 658 */           break;
/*  461:     */         case 'd': 
/*  462: 660 */           j = __emitNode('\030');
/*  463: 661 */           paramArrayOfInt[0] |= 0x3;
/*  464: 662 */           __getNextChar();
/*  465: 663 */           break;
/*  466:     */         case 'D': 
/*  467: 665 */           j = __emitNode('\031');
/*  468: 666 */           paramArrayOfInt[0] |= 0x3;
/*  469: 667 */           __getNextChar();
/*  470: 668 */           break;
/*  471:     */         case '0': 
/*  472:     */         case 'a': 
/*  473:     */         case 'c': 
/*  474:     */         case 'e': 
/*  475:     */         case 'f': 
/*  476:     */         case 'n': 
/*  477:     */         case 'r': 
/*  478:     */         case 't': 
/*  479:     */         case 'x': 
/*  480: 671 */           i = 1;
/*  481: 672 */           break;
/*  482:     */         case '1': 
/*  483:     */         case '2': 
/*  484:     */         case '3': 
/*  485:     */         case '4': 
/*  486:     */         case '5': 
/*  487:     */         case '6': 
/*  488:     */         case '7': 
/*  489:     */         case '8': 
/*  490:     */         case '9': 
/*  491: 676 */           StringBuffer localStringBuffer1 = new StringBuffer(10);
/*  492:     */           
/*  493: 678 */           k = 0;
/*  494: 679 */           c1 = this.__input._getValueRelative(k);
/*  495: 681 */           while (Character.isDigit(c1))
/*  496:     */           {
/*  497: 682 */             localStringBuffer1.append(c1);
/*  498: 683 */             k++;
/*  499: 684 */             c1 = this.__input._getValueRelative(k);
/*  500:     */           }
/*  501:     */           try
/*  502:     */           {
/*  503: 688 */             k = Integer.parseInt(localStringBuffer1.toString());
/*  504:     */           }
/*  505:     */           catch (NumberFormatException localNumberFormatException1)
/*  506:     */           {
/*  507: 690 */             throw new MalformedPatternException(
/*  508: 691 */               "Unexpected number format exception.  Please report this bug.NumberFormatException message: " + 
/*  509: 692 */               localNumberFormatException1.getMessage());
/*  510:     */           }
/*  511: 695 */           if ((k > 9) && (k >= this.__numParentheses))
/*  512:     */           {
/*  513: 696 */             i = 1;
/*  514:     */           }
/*  515:     */           else
/*  516:     */           {
/*  517: 700 */             if (k >= this.__numParentheses) {
/*  518: 701 */               throw new MalformedPatternException("Invalid backreference: \\" + 
/*  519: 702 */                 k);
/*  520:     */             }
/*  521: 703 */             this.__sawBackreference = true;
/*  522: 704 */             j = __emitArgNode('\032', (char)k);
/*  523: 705 */             paramArrayOfInt[0] |= 0x1;
/*  524:     */             
/*  525: 707 */             c1 = this.__input._getValue();
/*  526: 708 */             while (Character.isDigit(c1)) {
/*  527: 709 */               c1 = this.__input._increment();
/*  528:     */             }
/*  529: 711 */             this.__input._decrement();
/*  530: 712 */             __getNextChar();
/*  531:     */           }
/*  532: 714 */           break;
/*  533:     */         case '\000': 
/*  534:     */         case 'èøø': 
/*  535: 717 */           if (this.__input._isAtEnd()) {
/*  536: 718 */             throw new MalformedPatternException(
/*  537: 719 */               "Trailing \\ in expression.");
/*  538:     */           }
/*  539:     */           break;
/*  540:     */         }
/*  541: 722 */         i = 1;
/*  542: 723 */         break;
/*  543:     */       case '#': 
/*  544: 729 */         if ((this.__modifierFlags[0] & 0x20) != 0)
/*  545:     */         {
/*  546: 730 */           while ((!this.__input._isAtEnd()) && (this.__input._getValue() != '\n')) {
/*  547: 731 */             this.__input._increment();
/*  548:     */           }
/*  549: 732 */           if (!this.__input._isAtEnd()) {
/*  550:     */             continue;
/*  551:     */           }
/*  552:     */         }
/*  553:     */       default: 
/*  554: 737 */         this.__input._increment();
/*  555: 738 */         i = 1;
/*  556:     */         break label1281;
/*  557:     */       }
/*  558:     */     }
/*  559:     */     label1281:
/*  560: 744 */     if (i != 0)
/*  561:     */     {
/*  562: 748 */       j = __emitNode('\016');
/*  563:     */       
/*  564:     */ 
/*  565: 751 */       __emitCode(65535);
/*  566:     */       
/*  567:     */ 
/*  568: 754 */       int m = 0;int n = this.__input._getOffset() - 1;
/*  569: 755 */       int i1 = this.__input._getLength();
/*  570: 756 */       for (; (m < 127) && (n < i1); m++)
/*  571:     */       {
/*  572: 758 */         int i2 = n;
/*  573: 759 */         c1 = this.__input._getValue(n);
/*  574:     */         char c2;
/*  575: 761 */         switch (c1)
/*  576:     */         {
/*  577:     */         case '\\': 
/*  578: 766 */           c1 = this.__input._getValue(++n);
/*  579:     */           int[] arrayOfInt2;
/*  580: 768 */           switch (c1)
/*  581:     */           {
/*  582:     */           case 'A': 
/*  583:     */           case 'B': 
/*  584:     */           case 'D': 
/*  585:     */           case 'G': 
/*  586:     */           case 'S': 
/*  587:     */           case 'W': 
/*  588:     */           case 'Z': 
/*  589:     */           case 'b': 
/*  590:     */           case 'd': 
/*  591:     */           case 's': 
/*  592:     */           case 'w': 
/*  593: 771 */             n--;
/*  594: 772 */             break;
/*  595:     */           case 'n': 
/*  596: 774 */             k = 10;
/*  597: 775 */             n++;
/*  598: 776 */             break;
/*  599:     */           case 'r': 
/*  600: 778 */             k = 13;
/*  601: 779 */             n++;
/*  602: 780 */             break;
/*  603:     */           case 't': 
/*  604: 782 */             k = 9;
/*  605: 783 */             n++;
/*  606: 784 */             break;
/*  607:     */           case 'f': 
/*  608: 786 */             k = 12;
/*  609: 787 */             n++;
/*  610: 788 */             break;
/*  611:     */           case 'e': 
/*  612: 790 */             k = 27;
/*  613: 791 */             n++;
/*  614: 792 */             break;
/*  615:     */           case 'a': 
/*  616: 794 */             k = 7;
/*  617: 795 */             n++;
/*  618: 796 */             break;
/*  619:     */           case 'x': 
/*  620: 798 */             arrayOfInt2 = new int[1];
/*  621: 799 */             k = (char)__parseHex(this.__input._array, ++n, 2, arrayOfInt2);
/*  622: 800 */             n += arrayOfInt2[0];
/*  623: 801 */             break;
/*  624:     */           case 'c': 
/*  625: 803 */             n++;
/*  626: 804 */             k = this.__input._getValue(n++);
/*  627: 805 */             if (Character.isLowerCase(k)) {
/*  628: 806 */               c2 = Character.toUpperCase(k);
/*  629:     */             }
/*  630: 807 */             c2 = (char)(c2 ^ 0x40);
/*  631: 808 */             break;
/*  632:     */           case '0': 
/*  633:     */           case '1': 
/*  634:     */           case '2': 
/*  635:     */           case '3': 
/*  636:     */           case '4': 
/*  637:     */           case '5': 
/*  638:     */           case '6': 
/*  639:     */           case '7': 
/*  640:     */           case '8': 
/*  641:     */           case '9': 
/*  642: 811 */             int i3 = 0;
/*  643: 812 */             c1 = this.__input._getValue(n);
/*  644: 814 */             if (c1 == '0') {
/*  645: 815 */               i3 = 1;
/*  646:     */             }
/*  647: 816 */             c1 = this.__input._getValue(n + 1);
/*  648: 818 */             if (Character.isDigit(c1))
/*  649:     */             {
/*  650: 820 */               StringBuffer localStringBuffer2 = new StringBuffer(10);
/*  651:     */               
/*  652: 822 */               int i4 = n;
/*  653: 823 */               c1 = this.__input._getValue(i4);
/*  654: 825 */               while (Character.isDigit(c1))
/*  655:     */               {
/*  656: 826 */                 localStringBuffer2.append(c1);
/*  657: 827 */                 i4++;
/*  658: 828 */                 c1 = this.__input._getValue(i4);
/*  659:     */               }
/*  660:     */               try
/*  661:     */               {
/*  662: 832 */                 i4 = Integer.parseInt(localStringBuffer2.toString());
/*  663:     */               }
/*  664:     */               catch (NumberFormatException localNumberFormatException2)
/*  665:     */               {
/*  666: 834 */                 throw new MalformedPatternException(
/*  667: 835 */                   "Unexpected number format exception.  Please report this bug.NumberFormatException message: " + 
/*  668: 836 */                   localNumberFormatException2.getMessage());
/*  669:     */               }
/*  670: 839 */               if (i3 == 0) {
/*  671: 840 */                 i3 = i4 < this.__numParentheses ? 0 : 1;
/*  672:     */               }
/*  673:     */             }
/*  674: 843 */             if (i3 != 0)
/*  675:     */             {
/*  676: 844 */               arrayOfInt2 = new int[1];
/*  677: 845 */               c2 = (char)__parseOctal(this.__input._array, n, 3, arrayOfInt2);
/*  678: 846 */               n += arrayOfInt2[0];
/*  679:     */               break label2205;
/*  680:     */             }
/*  681: 848 */             n--;
/*  682: 849 */             break;
/*  683:     */           case '\000': 
/*  684:     */           case 'èøø': 
/*  685: 855 */             if (n >= i1) {
/*  686: 856 */               throw new MalformedPatternException(
/*  687: 857 */                 "Trailing \\ in expression.");
/*  688:     */             }
/*  689:     */             break;
/*  690:     */           }
/*  691: 860 */           c2 = this.__input._getValue(n++);
/*  692: 861 */           break;
/*  693:     */         case '#': 
/*  694: 866 */           if ((this.__modifierFlags[0] & 0x20) != 0) {
/*  695: 867 */             while ((n < i1) && (this.__input._getValue(n) != '\n')) {
/*  696: 868 */               n++;
/*  697:     */             }
/*  698:     */           }
/*  699:     */         case '\t': 
/*  700:     */         case '\n': 
/*  701:     */         case '\013': 
/*  702:     */         case '\f': 
/*  703:     */         case '\r': 
/*  704:     */         case ' ': 
/*  705: 872 */           if ((this.__modifierFlags[0] & 0x20) != 0)
/*  706:     */           {
/*  707: 873 */             n++;
/*  708: 874 */             m--;
/*  709:     */           }
/*  710: 875 */           break;
/*  711:     */         default: 
/*  712: 879 */           c2 = this.__input._getValue(n++);
/*  713:     */           label2205:
/*  714: 884 */           if (((this.__modifierFlags[0] & 0x1) != 0) && 
/*  715: 885 */             (Character.isUpperCase(c2))) {
/*  716: 886 */             c2 = Character.toLowerCase(c2);
/*  717:     */           }
/*  718: 888 */           if ((n < i1) && (__isComplexRepetitionOp(this.__input._array, n)))
/*  719:     */           {
/*  720: 889 */             if (m > 0)
/*  721:     */             {
/*  722: 890 */               n = i2;
/*  723:     */               break label2300;
/*  724:     */             }
/*  725: 892 */             m++;
/*  726: 893 */             __emitCode(c2);
/*  727:     */             break label2300;
/*  728:     */           }
/*  729: 898 */           __emitCode(c2);
/*  730:     */         }
/*  731:     */       }
/*  732:     */       label2300:
/*  733: 904 */       this.__input._setOffset(n - 1);
/*  734: 905 */       __getNextChar();
/*  735: 907 */       if (m < 0) {
/*  736: 908 */         throw new MalformedPatternException(
/*  737: 909 */           "Unexpected compilation failure.  Please report this bug!");
/*  738:     */       }
/*  739: 910 */       if (m > 0) {
/*  740: 911 */         paramArrayOfInt[0] |= 0x1;
/*  741:     */       }
/*  742: 912 */       if (m == 1) {
/*  743: 913 */         paramArrayOfInt[0] |= 0x2;
/*  744:     */       }
/*  745: 914 */       if (this.__program != null) {
/*  746: 915 */         this.__program[OpCode._getOperand(j)] = ((char)m);
/*  747:     */       }
/*  748: 917 */       __emitCode(65535);
/*  749:     */     }
/*  750: 920 */     return j;
/*  751:     */   }
/*  752:     */   
/*  753:     */   private void __setCharacterClassBits(char[] paramArrayOfChar, int paramInt, char paramChar1, char paramChar2)
/*  754:     */   {
/*  755: 928 */     if ((this.__program == null) || (paramChar2 >= 'ƒÄ')) {
/*  756: 929 */       return;
/*  757:     */     }
/*  758: 930 */     paramChar2 = (char)(paramChar2 & 0xFFFF);
/*  759: 932 */     if (paramChar1 == 0)
/*  760:     */     {
/*  761: 933 */       int tmp35_34 = (paramInt + (paramChar2 >> '\004')); char[] tmp35_28 = paramArrayOfChar;tmp35_28[tmp35_34] = ((char)(tmp35_28[tmp35_34] | '\001' << (paramChar2 & 0xF)));
/*  762:     */     }
/*  763:     */     else
/*  764:     */     {
/*  765: 935 */       int tmp57_56 = (paramInt + (paramChar2 >> '\004')); char[] tmp57_50 = paramArrayOfChar;tmp57_50[tmp57_56] = ((char)(tmp57_50[tmp57_56] & ('\001' << (paramChar2 & 0xF) ^ 0xFFFFFFFF)));
/*  766:     */     }
/*  767:     */   }
/*  768:     */   
/*  769:     */   private int __parseCharacterClass()
/*  770:     */     throws MalformedPatternException
/*  771:     */   {
/*  772: 941 */     int i = 0;
/*  773: 942 */     int i6 = 65535;
/*  774: 943 */     int[] arrayOfInt = new int[1];
/*  775:     */     
/*  776: 945 */     int i8 = __emitNode('\t');
/*  777:     */     int i5;
/*  778: 947 */     if (this.__input._getValue() == '^')
/*  779:     */     {
/*  780: 948 */       this.__cost += 1;
/*  781: 949 */       this.__input._increment();
/*  782: 950 */       i5 = 0;
/*  783:     */     }
/*  784:     */     else
/*  785:     */     {
/*  786: 952 */       i5 = 65535;
/*  787:     */     }
/*  788: 955 */     int i9 = this.__programSize;
/*  789: 956 */     for (int k = 0; k < 16; k = (char)(k + 1)) {
/*  790: 957 */       __emitCode(i5);
/*  791:     */     }
/*  792: 959 */     k = this.__input._getValue();
/*  793:     */     int j;
/*  794: 961 */     if ((k == 93) || (k == 45)) {
/*  795: 962 */       j = 1;
/*  796:     */     } else {
/*  797: 964 */       j = 0;
/*  798:     */     }
/*  799:     */     int i4;
/*  800: 966 */     while (((!this.__input._isAtEnd()) && ((i4 = this.__input._getValue()) != ']')) || 
/*  801: 967 */       (j != 0))
/*  802:     */     {
/*  803: 969 */       j = 0;
/*  804: 970 */       this.__input._increment();
/*  805:     */       int i3;
/*  806: 971 */       if (k == 92)
/*  807:     */       {
/*  808: 972 */         k = this.__input._postIncrement();
/*  809:     */         int i2;
/*  810: 974 */         switch (k)
/*  811:     */         {
/*  812:     */         case 119: 
/*  813: 976 */           for (k = 0; k < 256; k = (char)(k + 1)) {
/*  814: 977 */             if (OpCode._isWordCharacter(k)) {
/*  815: 978 */               __setCharacterClassBits(this.__program, i9, i5, k);
/*  816:     */             }
/*  817:     */           }
/*  818: 979 */           i6 = 65535;
/*  819: 980 */           break;
/*  820:     */         case 87: 
/*  821: 982 */           for (int m = 0; m < 256; m = (char)(m + 1)) {
/*  822: 983 */             if (!OpCode._isWordCharacter(m)) {
/*  823: 984 */               __setCharacterClassBits(this.__program, i9, i5, m);
/*  824:     */             }
/*  825:     */           }
/*  826: 985 */           i6 = 65535;
/*  827: 986 */           break;
/*  828:     */         case 115: 
/*  829: 988 */           for (int n = 0; n < 256; n = (char)(n + 1)) {
/*  830: 989 */             if (Character.isWhitespace(n)) {
/*  831: 990 */               __setCharacterClassBits(this.__program, i9, i5, n);
/*  832:     */             }
/*  833:     */           }
/*  834: 991 */           i6 = 65535;
/*  835: 992 */           break;
/*  836:     */         case 83: 
/*  837: 994 */           for (int i1 = 0; i1 < 256; i1 = (char)(i1 + 1)) {
/*  838: 995 */             if (!Character.isWhitespace(i1)) {
/*  839: 996 */               __setCharacterClassBits(this.__program, i9, i5, i1);
/*  840:     */             }
/*  841:     */           }
/*  842: 997 */           i6 = 65535;
/*  843: 998 */           break;
/*  844:     */         case 100: 
/*  845:1000 */           for (i2 = 48; i2 <= 57; i2 = (char)(i2 + 1)) {
/*  846:1001 */             __setCharacterClassBits(this.__program, i9, i5, i2);
/*  847:     */           }
/*  848:1002 */           i6 = 65535;
/*  849:1003 */           break;
/*  850:     */         case 68: 
/*  851:1005 */           for (i2 = 0; i2 < 48; i2 = (char)(i2 + 1)) {
/*  852:1006 */             __setCharacterClassBits(this.__program, i9, i5, i2);
/*  853:     */           }
/*  854:1007 */           for (i2 = 58; i2 < 256; i2 = (char)(i2 + 1)) {
/*  855:1008 */             __setCharacterClassBits(this.__program, i9, i5, i2);
/*  856:     */           }
/*  857:1009 */           i6 = 65535;
/*  858:1010 */           break;
/*  859:     */         case 110: 
/*  860:1012 */           i3 = 10;
/*  861:1013 */           break;
/*  862:     */         case 114: 
/*  863:1015 */           i3 = 13;
/*  864:1016 */           break;
/*  865:     */         case 116: 
/*  866:1018 */           i3 = 9;
/*  867:1019 */           break;
/*  868:     */         case 102: 
/*  869:1021 */           i3 = 12;
/*  870:1022 */           break;
/*  871:     */         case 98: 
/*  872:1024 */           i3 = 8;
/*  873:1025 */           break;
/*  874:     */         case 101: 
/*  875:1027 */           i3 = 27;
/*  876:1028 */           break;
/*  877:     */         case 97: 
/*  878:1030 */           i3 = 7;
/*  879:1031 */           break;
/*  880:     */         case 120: 
/*  881:1033 */           i3 = (char)__parseHex(this.__input._array, this.__input._getOffset(), 2, 
/*  882:1034 */             arrayOfInt);
/*  883:1035 */           this.__input._increment(arrayOfInt[0]);
/*  884:1036 */           break;
/*  885:     */         case 99: 
/*  886:1038 */           i3 = this.__input._postIncrement();
/*  887:1039 */           if (Character.isLowerCase(i3)) {
/*  888:1040 */             i3 = Character.toUpperCase(i3);
/*  889:     */           }
/*  890:1041 */           i3 = (char)(i3 ^ 0x40);
/*  891:1042 */           break;
/*  892:     */         case 48: 
/*  893:     */         case 49: 
/*  894:     */         case 50: 
/*  895:     */         case 51: 
/*  896:     */         case 52: 
/*  897:     */         case 53: 
/*  898:     */         case 54: 
/*  899:     */         case 55: 
/*  900:     */         case 56: 
/*  901:     */         case 57: 
/*  902:1045 */           i3 = (char)__parseOctal(this.__input._array, this.__input._getOffset() - 1, 
/*  903:1046 */             3, arrayOfInt);
/*  904:1047 */           this.__input._increment(arrayOfInt[0] - 1);
/*  905:1048 */           break;
/*  906:     */         }
/*  907:     */       }
/*  908:1052 */       if (i != 0)
/*  909:     */       {
/*  910:1053 */         if (i6 > i3) {
/*  911:1054 */           throw new MalformedPatternException(
/*  912:1055 */             "Invalid [] range in expression.");
/*  913:     */         }
/*  914:1056 */         i = 0;
/*  915:     */       }
/*  916:     */       else
/*  917:     */       {
/*  918:1058 */         i6 = i3;
/*  919:1060 */         if ((this.__input._getValue() == '-') && 
/*  920:1061 */           (this.__input._getOffset() + 1 < this.__input._getLength()) && 
/*  921:1062 */           (this.__input._getValueRelative(1) != ']'))
/*  922:     */         {
/*  923:1063 */           this.__input._increment();
/*  924:1064 */           i = 1;
/*  925:1065 */           continue;
/*  926:     */         }
/*  927:     */       }
/*  928:1069 */       while (i7 <= i3)
/*  929:     */       {
/*  930:1070 */         __setCharacterClassBits(this.__program, i9, i5, i6);
/*  931:1071 */         if (((this.__modifierFlags[0] & 0x1) != 0) && 
/*  932:1072 */           (Character.isUpperCase(i6))) {
/*  933:1073 */           __setCharacterClassBits(this.__program, i9, i5, 
/*  934:1074 */             Character.toLowerCase(i6));
/*  935:     */         }
/*  936:1076 */         i7 = (char)(i6 + 1);
/*  937:     */       }
/*  938:1079 */       int i7 = i3;
/*  939:     */     }
/*  940:1082 */     if (this.__input._getValue() != ']') {
/*  941:1083 */       throw new MalformedPatternException("Unmatched [] in expression.");
/*  942:     */     }
/*  943:1085 */     __getNextChar();
/*  944:     */     
/*  945:1087 */     return i8;
/*  946:     */   }
/*  947:     */   
/*  948:     */   private int __parseBranch(int[] paramArrayOfInt)
/*  949:     */     throws MalformedPatternException
/*  950:     */   {
/*  951:1092 */     int i = 0;int j = 0;
/*  952:1093 */     int[] arrayOfInt = new int[1];
/*  953:     */     
/*  954:     */ 
/*  955:1096 */     int n = 0;
/*  956:1097 */     int i1 = 65535;
/*  957:1098 */     int k = __parseAtom(arrayOfInt);
/*  958:1100 */     if (k == -1)
/*  959:     */     {
/*  960:1101 */       if ((arrayOfInt[0] & 0x8) != 0) {
/*  961:1102 */         paramArrayOfInt[0] |= 0x8;
/*  962:     */       }
/*  963:1103 */       return -1;
/*  964:     */     }
/*  965:1106 */     int i2 = this.__input._getValue();
/*  966:1108 */     if ((i2 == 40) && (this.__input._getValueRelative(1) == '?') && 
/*  967:1109 */       (this.__input._getValueRelative(2) == '#'))
/*  968:     */     {
/*  969:1110 */       while ((i2 != 65535) && (i2 != 41)) {
/*  970:1111 */         i2 = this.__input._increment();
/*  971:     */       }
/*  972:1113 */       if (i2 != 65535)
/*  973:     */       {
/*  974:1114 */         __getNextChar();
/*  975:1115 */         i2 = this.__input._getValue();
/*  976:     */       }
/*  977:     */     }
/*  978:1119 */     if ((i2 == 123) && 
/*  979:1120 */       (__parseRepetition(this.__input._array, this.__input._getOffset())))
/*  980:     */     {
/*  981:1123 */       int m = this.__input._getOffset() + 1;
/*  982:     */       int i3;
/*  983:1124 */       int i4 = i3 = this.__input._getLength();
/*  984:     */       
/*  985:1126 */       char c = this.__input._getValue(m);
/*  986:1128 */       while ((Character.isDigit(c)) || (c == ','))
/*  987:     */       {
/*  988:1129 */         if (c == ',')
/*  989:     */         {
/*  990:1130 */           if (i4 != i3) {
/*  991:     */             break;
/*  992:     */           }
/*  993:1133 */           i4 = m;
/*  994:     */         }
/*  995:1135 */         m++;
/*  996:1136 */         c = this.__input._getValue(m);
/*  997:     */       }
/*  998:1139 */       if (c == '}')
/*  999:     */       {
/* 1000:1141 */         StringBuffer localStringBuffer = new StringBuffer(10);
/* 1001:1143 */         if (i4 == i3) {
/* 1002:1144 */           i4 = m;
/* 1003:     */         }
/* 1004:1145 */         this.__input._increment();
/* 1005:     */         
/* 1006:1147 */         int i5 = this.__input._getOffset();
/* 1007:1148 */         c = this.__input._getValue(i5);
/* 1008:1150 */         while (Character.isDigit(c))
/* 1009:     */         {
/* 1010:1151 */           localStringBuffer.append(c);
/* 1011:1152 */           i5++;
/* 1012:1153 */           c = this.__input._getValue(i5);
/* 1013:     */         }
/* 1014:     */         try
/* 1015:     */         {
/* 1016:1157 */           n = Integer.parseInt(localStringBuffer.toString());
/* 1017:     */         }
/* 1018:     */         catch (NumberFormatException localNumberFormatException1)
/* 1019:     */         {
/* 1020:1159 */           throw new MalformedPatternException(
/* 1021:1160 */             "Unexpected number format exception.  Please report this bug.NumberFormatException message: " + 
/* 1022:1161 */             localNumberFormatException1.getMessage());
/* 1023:     */         }
/* 1024:1164 */         c = this.__input._getValue(i4);
/* 1025:1165 */         if (c == ',') {
/* 1026:1166 */           i4++;
/* 1027:     */         } else {
/* 1028:1168 */           i4 = this.__input._getOffset();
/* 1029:     */         }
/* 1030:1170 */         i5 = i4;
/* 1031:1171 */         localStringBuffer = new StringBuffer(10);
/* 1032:     */         
/* 1033:1173 */         c = this.__input._getValue(i5);
/* 1034:1175 */         while (Character.isDigit(c))
/* 1035:     */         {
/* 1036:1176 */           localStringBuffer.append(c);
/* 1037:1177 */           i5++;
/* 1038:1178 */           c = this.__input._getValue(i5);
/* 1039:     */         }
/* 1040:     */         try
/* 1041:     */         {
/* 1042:1182 */           if (i5 != i4) {
/* 1043:1183 */             i1 = Integer.parseInt(localStringBuffer.toString());
/* 1044:     */           }
/* 1045:     */         }
/* 1046:     */         catch (NumberFormatException localNumberFormatException2)
/* 1047:     */         {
/* 1048:1185 */           throw new MalformedPatternException(
/* 1049:1186 */             "Unexpected number format exception.  Please report this bug.NumberFormatException message: " + 
/* 1050:1187 */             localNumberFormatException2.getMessage());
/* 1051:     */         }
/* 1052:1192 */         if ((i1 == 0) && (this.__input._getValue(i4) != '0')) {
/* 1053:1193 */           i1 = 65535;
/* 1054:     */         }
/* 1055:1194 */         this.__input._setOffset(m);
/* 1056:1195 */         __getNextChar();
/* 1057:     */         
/* 1058:     */ 
/* 1059:     */ 
/* 1060:1199 */         i = 1;
/* 1061:1200 */         j = 1;
/* 1062:     */       }
/* 1063:     */     }
/* 1064:1204 */     if (i == 0)
/* 1065:     */     {
/* 1066:1205 */       j = 0;
/* 1067:1207 */       if (!__isSimpleRepetitionOp(i2))
/* 1068:     */       {
/* 1069:1208 */         paramArrayOfInt[0] = arrayOfInt[0];
/* 1070:1209 */         return k;
/* 1071:     */       }
/* 1072:1212 */       __getNextChar();
/* 1073:     */       
/* 1074:1214 */       paramArrayOfInt[0] = (i2 != 43 ? 
/* 1075:1215 */         4 : 1);
/* 1076:1217 */       if ((i2 == 42) && ((arrayOfInt[0] & 0x2) != 0))
/* 1077:     */       {
/* 1078:1218 */         __programInsertOperator('\020', k);
/* 1079:1219 */         this.__cost += 4;
/* 1080:     */       }
/* 1081:1220 */       else if (i2 == 42)
/* 1082:     */       {
/* 1083:1221 */         n = 0;
/* 1084:1222 */         j = 1;
/* 1085:     */       }
/* 1086:1223 */       else if ((i2 == 43) && ((arrayOfInt[0] & 0x2) != 0))
/* 1087:     */       {
/* 1088:1224 */         __programInsertOperator('\021', k);
/* 1089:1225 */         this.__cost += 3;
/* 1090:     */       }
/* 1091:1226 */       else if (i2 == 43)
/* 1092:     */       {
/* 1093:1227 */         n = 1;
/* 1094:1228 */         j = 1;
/* 1095:     */       }
/* 1096:1229 */       else if (i2 == 63)
/* 1097:     */       {
/* 1098:1230 */         n = 0;
/* 1099:1231 */         i1 = 1;
/* 1100:1232 */         j = 1;
/* 1101:     */       }
/* 1102:     */     }
/* 1103:1236 */     if (j != 0)
/* 1104:     */     {
/* 1105:1239 */       if ((arrayOfInt[0] & 0x2) != 0)
/* 1106:     */       {
/* 1107:1240 */         this.__cost += (2 + this.__cost) / 2;
/* 1108:1241 */         __programInsertOperator('\n', k);
/* 1109:     */       }
/* 1110:     */       else
/* 1111:     */       {
/* 1112:1243 */         this.__cost += 4 + this.__cost;
/* 1113:1244 */         __programAddTail(k, __emitNode('"'));
/* 1114:1245 */         __programInsertOperator('\013', k);
/* 1115:1246 */         __programAddTail(k, __emitNode('\017'));
/* 1116:     */       }
/* 1117:1249 */       if (n > 0) {
/* 1118:1250 */         paramArrayOfInt[0] = 1;
/* 1119:     */       }
/* 1120:1252 */       if ((i1 != 0) && (i1 < n)) {
/* 1121:1253 */         throw new MalformedPatternException(
/* 1122:1254 */           "Invalid interval {" + n + "," + i1 + "}");
/* 1123:     */       }
/* 1124:1256 */       if (this.__program != null)
/* 1125:     */       {
/* 1126:1257 */         this.__program[(k + 2)] = ((char)n);
/* 1127:1258 */         this.__program[(k + 3)] = ((char)i1);
/* 1128:     */       }
/* 1129:     */     }
/* 1130:1263 */     if (this.__input._getValue() == '?')
/* 1131:     */     {
/* 1132:1264 */       __getNextChar();
/* 1133:1265 */       __programInsertOperator('\035', k);
/* 1134:1266 */       __programAddTail(k, k + 2);
/* 1135:     */     }
/* 1136:1269 */     if (__isComplexRepetitionOp(this.__input._array, this.__input._getOffset())) {
/* 1137:1270 */       throw new MalformedPatternException(
/* 1138:1271 */         "Nested repetitions *?+ in expression");
/* 1139:     */     }
/* 1140:1273 */     return k;
/* 1141:     */   }
/* 1142:     */   
/* 1143:     */   private int __parseExpression(boolean paramBoolean, int[] paramArrayOfInt)
/* 1144:     */     throws MalformedPatternException
/* 1145:     */   {
/* 1146:1280 */     int m = -1;int n = 0;
/* 1147:1281 */     int[] arrayOfInt = new int[1];
/* 1148:1282 */     String str = "iogmsx";
/* 1149:     */     
/* 1150:     */ 
/* 1151:     */ 
/* 1152:1286 */     paramArrayOfInt[0] = 1;
/* 1153:     */     int k;
/* 1154:     */     int i;
/* 1155:1288 */     if (paramBoolean)
/* 1156:     */     {
/* 1157:1289 */       k = 1;
/* 1158:1290 */       if (this.__input._getValue() == '?')
/* 1159:     */       {
/* 1160:1291 */         this.__input._increment();
/* 1161:1292 */         k = i = this.__input._postIncrement();
/* 1162:     */       }
/* 1163:     */     }
/* 1164:1294 */     switch (i)
/* 1165:     */     {
/* 1166:     */     case 35: 
/* 1167:1299 */       i = this.__input._getValue();
/* 1168:1300 */       while ((i != 65535) && (i != 41)) {
/* 1169:1301 */         i = this.__input._increment();
/* 1170:     */       }
/* 1171:1302 */       if (i != 41) {
/* 1172:1303 */         throw new MalformedPatternException(
/* 1173:1304 */           "Sequence (?#... not terminated");
/* 1174:     */       }
/* 1175:1305 */       __getNextChar();
/* 1176:1306 */       paramArrayOfInt[0] = 8;
/* 1177:1307 */       return -1;
/* 1178:     */     default: 
/* 1179:1309 */       this.__input._decrement();
/* 1180:1310 */       i = this.__input._getValue();
/* 1181:     */       int j;
/* 1182:1311 */       while ((j != 65535) && 
/* 1183:1312 */         (str.indexOf(j) != -1))
/* 1184:     */       {
/* 1185:1313 */         __setModifierFlag(this.__modifierFlags, i);
/* 1186:1314 */         j = this.__input._increment();
/* 1187:     */       }
/* 1188:1316 */       if (j != 41) {
/* 1189:1317 */         throw new MalformedPatternException(
/* 1190:1318 */           "Sequence (?" + j + "...) not recognized");
/* 1191:     */       }
/* 1192:1319 */       __getNextChar();
/* 1193:1320 */       paramArrayOfInt[0] = 8;
/* 1194:1321 */       return -1;
/* 1195:     */       
/* 1196:     */ 
/* 1197:1324 */       n = this.__numParentheses;
/* 1198:1325 */       this.__numParentheses += 1;
/* 1199:1326 */       m = __emitArgNode('\033', (char)n);break;
/* 1200:     */       
/* 1201:     */ 
/* 1202:1329 */       k = 0;
/* 1203:     */     }
/* 1204:1331 */     int i1 = __parseAlternation(arrayOfInt);
/* 1205:1333 */     if (i1 == -1) {
/* 1206:1334 */       return -1;
/* 1207:     */     }
/* 1208:1336 */     if (m != -1) {
/* 1209:1337 */       __programAddTail(m, i1);
/* 1210:     */     } else {
/* 1211:1339 */       m = i1;
/* 1212:     */     }
/* 1213:1341 */     if ((arrayOfInt[0] & 0x1) == 0) {
/* 1214:1342 */       paramArrayOfInt[0] &= 0xFFFFFFFE;
/* 1215:     */     }
/* 1216:1344 */     paramArrayOfInt[0] |= arrayOfInt[0] & 0x4;
/* 1217:1346 */     while (this.__input._getValue() == '|')
/* 1218:     */     {
/* 1219:1347 */       __getNextChar();
/* 1220:1348 */       i1 = __parseAlternation(arrayOfInt);
/* 1221:1350 */       if (i1 == -1) {
/* 1222:1351 */         return -1;
/* 1223:     */       }
/* 1224:1353 */       __programAddTail(m, i1);
/* 1225:1355 */       if ((arrayOfInt[0] & 0x1) == 0) {
/* 1226:1356 */         paramArrayOfInt[0] &= 0xFFFFFFFE;
/* 1227:     */       }
/* 1228:1358 */       paramArrayOfInt[0] |= arrayOfInt[0] & 0x4;
/* 1229:     */     }
/* 1230:     */     int i2;
/* 1231:1361 */     switch (k)
/* 1232:     */     {
/* 1233:     */     case 58: 
/* 1234:1363 */       i2 = __emitNode('\017');
/* 1235:1364 */       break;
/* 1236:     */     case 1: 
/* 1237:1366 */       i2 = __emitArgNode('\034', (char)n);
/* 1238:1367 */       break;
/* 1239:     */     case 33: 
/* 1240:     */     case 61: 
/* 1241:1370 */       i2 = __emitNode('!');
/* 1242:1371 */       paramArrayOfInt[0] &= 0xFFFFFFFE;
/* 1243:1372 */       break;
/* 1244:     */     case 0: 
/* 1245:     */     default: 
/* 1246:1375 */       i2 = __emitNode('\000');
/* 1247:     */     }
/* 1248:1379 */     __programAddTail(m, i2);
/* 1249:1381 */     for (i1 = m; i1 != -1; i1 = OpCode._getNext(this.__program, i1)) {
/* 1250:1383 */       __programAddOperatorTail(i1, i2);
/* 1251:     */     }
/* 1252:1385 */     if (k == 61)
/* 1253:     */     {
/* 1254:1386 */       __programInsertOperator('\037', m);
/* 1255:1387 */       __programAddTail(m, __emitNode('\017'));
/* 1256:     */     }
/* 1257:1388 */     else if (k == 33)
/* 1258:     */     {
/* 1259:1389 */       __programInsertOperator(' ', m);
/* 1260:1390 */       __programAddTail(m, __emitNode('\017'));
/* 1261:     */     }
/* 1262:1393 */     if ((k != 0) && ((this.__input._isAtEnd()) || (__getNextChar() != ')'))) {
/* 1263:1394 */       throw new MalformedPatternException("Unmatched parentheses.");
/* 1264:     */     }
/* 1265:1395 */     if ((k == 0) && (!this.__input._isAtEnd()))
/* 1266:     */     {
/* 1267:1396 */       if (this.__input._getValue() == ')') {
/* 1268:1397 */         throw new MalformedPatternException("Unmatched parentheses.");
/* 1269:     */       }
/* 1270:1400 */       throw new MalformedPatternException(
/* 1271:1401 */         "Unreached characters at end of expression.  Please report this bug!");
/* 1272:     */     }
/* 1273:1405 */     return m;
/* 1274:     */   }
/* 1275:     */   
/* 1276:     */   public Pattern compile(char[] paramArrayOfChar, int paramInt)
/* 1277:     */     throws MalformedPatternException
/* 1278:     */   {
/* 1279:1437 */     int[] arrayOfInt = new int[1];
/* 1280:     */     
/* 1281:     */ 
/* 1282:     */ 
/* 1283:     */ 
/* 1284:     */ 
/* 1285:1443 */     int m = 0;int n = 0;
/* 1286:     */     
/* 1287:     */ 
/* 1288:1446 */     int i2 = 0;
/* 1289:     */     
/* 1290:     */ 
/* 1291:1449 */     this.__input = new CharStringPointer(paramArrayOfChar);
/* 1292:     */     
/* 1293:1451 */     int i = paramInt & 0x1;
/* 1294:1452 */     this.__modifierFlags[0] = ((char)paramInt);
/* 1295:1453 */     this.__sawBackreference = false;
/* 1296:1454 */     this.__numParentheses = 1;
/* 1297:1455 */     this.__programSize = 0;
/* 1298:1456 */     this.__cost = 0;
/* 1299:1457 */     this.__program = null;
/* 1300:     */     
/* 1301:1459 */     __emitCode('\000');
/* 1302:1460 */     if (__parseExpression(false, arrayOfInt) == -1) {
/* 1303:1463 */       throw new MalformedPatternException("Unknown compilation error.");
/* 1304:     */     }
/* 1305:1468 */     if (this.__programSize >= 65534) {
/* 1306:1469 */       throw new MalformedPatternException("Expression is too large.");
/* 1307:     */     }
/* 1308:1472 */     this.__program = new char[this.__programSize];
/* 1309:1473 */     Perl5Pattern localPerl5Pattern = new Perl5Pattern();
/* 1310:     */     
/* 1311:1475 */     localPerl5Pattern._program = this.__program;
/* 1312:1476 */     localPerl5Pattern._expression = new String(paramArrayOfChar);
/* 1313:     */     
/* 1314:1478 */     this.__input._setOffset(0);
/* 1315:     */     
/* 1316:1480 */     this.__numParentheses = 1;
/* 1317:1481 */     this.__programSize = 0;
/* 1318:1482 */     this.__cost = 0;
/* 1319:     */     
/* 1320:1484 */     __emitCode('\000');
/* 1321:1485 */     if (__parseExpression(false, arrayOfInt) == -1) {
/* 1322:1488 */       throw new MalformedPatternException("Unknown compilation error.");
/* 1323:     */     }
/* 1324:1493 */     i = this.__modifierFlags[0] & 0x1;
/* 1325:     */     
/* 1326:1495 */     localPerl5Pattern._isExpensive = (this.__cost >= 10);
/* 1327:1496 */     localPerl5Pattern._startClassOffset = -1;
/* 1328:1497 */     localPerl5Pattern._anchor = 0;
/* 1329:1498 */     localPerl5Pattern._back = -1;
/* 1330:1499 */     localPerl5Pattern._options = paramInt;
/* 1331:1500 */     localPerl5Pattern._startString = null;
/* 1332:1501 */     localPerl5Pattern._mustString = null;
/* 1333:1502 */     String str1 = null;
/* 1334:1503 */     String str2 = null;
/* 1335:     */     
/* 1336:1505 */     int j = 1;
/* 1337:1506 */     if (this.__program[OpCode._getNext(this.__program, j)] == 0)
/* 1338:     */     {
/* 1339:1510 */       int k = j = OpCode._getNextOperator(j);
/* 1340:1511 */       char c = this.__program[k];
/* 1341:1513 */       while (((c == '\033') && ((m = 1) != 0)) || 
/* 1342:1514 */         ((c == '\f') && 
/* 1343:1515 */         (this.__program[OpCode._getNext(this.__program, k)] != '\f')) || 
/* 1344:1516 */         (c == '\021') || (c == '\035') || (
/* 1345:1517 */         (OpCode._opType[c] == '\n') && 
/* 1346:1518 */         (OpCode._getArg1(this.__program, k) > 0)))
/* 1347:     */       {
/* 1348:1519 */         if (c == '\021') {
/* 1349:1520 */           n = 1;
/* 1350:     */         } else {
/* 1351:1522 */           k += OpCode._operandLength[c];
/* 1352:     */         }
/* 1353:1524 */         k = OpCode._getNextOperator(k);
/* 1354:1525 */         c = this.__program[k];
/* 1355:     */       }
/* 1356:1528 */       int i6 = 1;
/* 1357:1530 */       while (i6 != 0)
/* 1358:     */       {
/* 1359:1531 */         i6 = 0;
/* 1360:1532 */         c = this.__program[k];
/* 1361:1534 */         if (c == '\016')
/* 1362:     */         {
/* 1363:1535 */           str2 = 
/* 1364:1536 */             new String(this.__program, OpCode._getOperand(k + 1), 
/* 1365:1537 */             this.__program[OpCode._getOperand(k)]);
/* 1366:     */         }
/* 1367:1539 */         else if (OpCode._isInArray(c, OpCode._opLengthOne, 2))
/* 1368:     */         {
/* 1369:1540 */           localPerl5Pattern._startClassOffset = k;
/* 1370:     */         }
/* 1371:1541 */         else if ((c == '\024') || (c == '\025'))
/* 1372:     */         {
/* 1373:1542 */           localPerl5Pattern._startClassOffset = k;
/* 1374:     */         }
/* 1375:1543 */         else if (OpCode._opType[c] == '\001')
/* 1376:     */         {
/* 1377:1544 */           if (c == '\001') {
/* 1378:1545 */             localPerl5Pattern._anchor = 1;
/* 1379:1546 */           } else if (c == '\002') {
/* 1380:1547 */             localPerl5Pattern._anchor = 2;
/* 1381:     */           } else {
/* 1382:1549 */             localPerl5Pattern._anchor = 3;
/* 1383:     */           }
/* 1384:1550 */           k = OpCode._getNextOperator(k);
/* 1385:1551 */           i6 = 1;
/* 1386:     */         }
/* 1387:1553 */         else if ((c == '\020') && 
/* 1388:1554 */           (OpCode._opType[this.__program[OpCode._getNextOperator(k)]] == 
/* 1389:1555 */           '\007') && ((localPerl5Pattern._anchor & 0x3) != 0))
/* 1390:     */         {
/* 1391:1557 */           localPerl5Pattern._anchor = 11;
/* 1392:1558 */           k = OpCode._getNextOperator(k);
/* 1393:1559 */           i6 = 1;
/* 1394:     */         }
/* 1395:     */       }
/* 1396:1564 */       if ((n != 0) && ((m == 0) || (!this.__sawBackreference))) {
/* 1397:1565 */         localPerl5Pattern._anchor |= 0x4;
/* 1398:     */       }
/* 1399:1577 */       StringBuffer localStringBuffer1 = new StringBuffer();
/* 1400:1578 */       StringBuffer localStringBuffer2 = new StringBuffer();
/* 1401:1579 */       int i1 = 0;
/* 1402:1580 */       i2 = 0;
/* 1403:1581 */       int i3 = 0;
/* 1404:1582 */       int i4 = 0;
/* 1405:1583 */       int i5 = 0;
/* 1406:1585 */       while ((j > 0) && ((c = this.__program[j]) != 0)) {
/* 1407:1587 */         if (c == '\f')
/* 1408:     */         {
/* 1409:1588 */           if (this.__program[OpCode._getNext(this.__program, j)] == '\f')
/* 1410:     */           {
/* 1411:1589 */             i3 = -30000;
/* 1412:1590 */             while (this.__program[j] == '\f') {
/* 1413:1591 */               j = OpCode._getNext(this.__program, j);
/* 1414:     */             }
/* 1415:     */           }
/* 1416:     */           else
/* 1417:     */           {
/* 1418:1593 */             j = OpCode._getNextOperator(j);
/* 1419:     */           }
/* 1420:     */         }
/* 1421:1597 */         else if (c == ' ')
/* 1422:     */         {
/* 1423:1598 */           i3 = -30000;
/* 1424:1599 */           j = OpCode._getNext(this.__program, j);
/* 1425:     */         }
/* 1426:     */         else
/* 1427:     */         {
/* 1428:1603 */           if (c == '\016')
/* 1429:     */           {
/* 1430:1606 */             k = j;
/* 1431:1607 */             while (this.__program[(i7 = OpCode._getNext(this.__program, j))] == 
/* 1432:1608 */               '\034') {
/* 1433:1609 */               j = i7;
/* 1434:     */             }
/* 1435:1611 */             i2 += this.__program[OpCode._getOperand(k)];
/* 1436:     */             
/* 1437:1613 */             int i7 = this.__program[OpCode._getOperand(k)];
/* 1438:1615 */             if (i3 - i4 == i1)
/* 1439:     */             {
/* 1440:1616 */               localStringBuffer1.append(new String(this.__program, OpCode._getOperand(k) + 1, 
/* 1441:1617 */                 i7));
/* 1442:1618 */               i1 += i7;
/* 1443:1619 */               i3 += i7;
/* 1444:1620 */               k = OpCode._getNext(this.__program, j);
/* 1445:     */             }
/* 1446:1621 */             else if (i7 >= i1 + (i3 >= 0 ? 1 : 0))
/* 1447:     */             {
/* 1448:1622 */               i1 = i7;
/* 1449:1623 */               localStringBuffer1 = 
/* 1450:1624 */                 new StringBuffer(new String(this.__program, 
/* 1451:1625 */                 OpCode._getOperand(k) + 1, i7));
/* 1452:1626 */               i4 = i3;
/* 1453:1627 */               i3 += i1;
/* 1454:1628 */               k = OpCode._getNext(this.__program, j);
/* 1455:     */             }
/* 1456:     */             else
/* 1457:     */             {
/* 1458:1630 */               i3 += i7;
/* 1459:     */             }
/* 1460:     */           }
/* 1461:1631 */           else if (OpCode._isInArray(c, OpCode._opLengthVaries, 0))
/* 1462:     */           {
/* 1463:1632 */             i3 = -30000;
/* 1464:1633 */             i1 = 0;
/* 1465:1635 */             if (localStringBuffer1.length() > localStringBuffer2.length())
/* 1466:     */             {
/* 1467:1636 */               localStringBuffer2 = localStringBuffer1;
/* 1468:1637 */               i5 = i4;
/* 1469:     */             }
/* 1470:1640 */             localStringBuffer1 = new StringBuffer();
/* 1471:1642 */             if ((c == '\021') && 
/* 1472:1643 */               (OpCode._isInArray(this.__program[OpCode._getNextOperator(j)], 
/* 1473:1644 */               OpCode._opLengthOne, 0))) {
/* 1474:1645 */               i2++;
/* 1475:1646 */             } else if ((OpCode._opType[c] == '\n') && 
/* 1476:1647 */               (OpCode._isInArray(this.__program[(OpCode._getNextOperator(j) + 2)], 
/* 1477:1648 */               OpCode._opLengthOne, 0))) {
/* 1478:1649 */               i2 += OpCode._getArg1(this.__program, j);
/* 1479:     */             }
/* 1480:     */           }
/* 1481:1650 */           else if (OpCode._isInArray(c, OpCode._opLengthOne, 0))
/* 1482:     */           {
/* 1483:1651 */             i3++;
/* 1484:1652 */             i2++;
/* 1485:1653 */             i1 = 0;
/* 1486:1654 */             if (localStringBuffer1.length() > localStringBuffer2.length())
/* 1487:     */             {
/* 1488:1655 */               localStringBuffer2 = localStringBuffer1;
/* 1489:1656 */               i5 = i4;
/* 1490:     */             }
/* 1491:1658 */             localStringBuffer1 = new StringBuffer();
/* 1492:     */           }
/* 1493:1661 */           j = OpCode._getNext(this.__program, j);
/* 1494:     */         }
/* 1495:     */       }
/* 1496:1665 */       if (localStringBuffer1.length() + (OpCode._opType[this.__program[k]] == '\004' ? 1 : 0) > 
/* 1497:1666 */         localStringBuffer2.length())
/* 1498:     */       {
/* 1499:1667 */         localStringBuffer2 = localStringBuffer1;
/* 1500:1668 */         i5 = i4;
/* 1501:     */       }
/* 1502:     */       else
/* 1503:     */       {
/* 1504:1670 */         localStringBuffer1 = new StringBuffer();
/* 1505:     */       }
/* 1506:1672 */       if ((localStringBuffer2.length() > 0) && (str2 == null))
/* 1507:     */       {
/* 1508:1673 */         str1 = localStringBuffer2.toString();
/* 1509:1674 */         if (i5 < 0) {
/* 1510:1675 */           i5 = -1;
/* 1511:     */         }
/* 1512:1676 */         localPerl5Pattern._back = i5;
/* 1513:     */       }
/* 1514:     */       else
/* 1515:     */       {
/* 1516:1686 */         localStringBuffer2 = null;
/* 1517:     */       }
/* 1518:     */     }
/* 1519:1690 */     localPerl5Pattern._isCaseInsensitive = ((i & 0x1) != 0);
/* 1520:1691 */     localPerl5Pattern._numParentheses = (this.__numParentheses - 1);
/* 1521:1692 */     localPerl5Pattern._minLength = i2;
/* 1522:1694 */     if (str1 != null)
/* 1523:     */     {
/* 1524:1695 */       localPerl5Pattern._mustString = str1.toCharArray();
/* 1525:1696 */       localPerl5Pattern._mustUtility = 100;
/* 1526:     */     }
/* 1527:1699 */     if (str2 != null) {
/* 1528:1700 */       localPerl5Pattern._startString = str2.toCharArray();
/* 1529:     */     }
/* 1530:1702 */     return localPerl5Pattern;
/* 1531:     */   }
/* 1532:     */   
/* 1533:     */   public Pattern compile(char[] paramArrayOfChar)
/* 1534:     */     throws MalformedPatternException
/* 1535:     */   {
/* 1536:1716 */     return compile(paramArrayOfChar, 0);
/* 1537:     */   }
/* 1538:     */   
/* 1539:     */   public Pattern compile(String paramString)
/* 1540:     */     throws MalformedPatternException
/* 1541:     */   {
/* 1542:1731 */     return compile(paramString.toCharArray(), 0);
/* 1543:     */   }
/* 1544:     */   
/* 1545:     */   public Pattern compile(String paramString, int paramInt)
/* 1546:     */     throws MalformedPatternException
/* 1547:     */   {
/* 1548:1763 */     return compile(paramString.toCharArray(), paramInt);
/* 1549:     */   }
/* 1550:     */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.regex.Perl5Compiler
 * JD-Core Version:    0.7.0.1
 */
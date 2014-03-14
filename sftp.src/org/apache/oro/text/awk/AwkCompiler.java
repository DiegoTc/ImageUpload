/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import org.apache.oro.text.regex.MalformedPatternException;
/*   4:    */ import org.apache.oro.text.regex.Pattern;
/*   5:    */ import org.apache.oro.text.regex.PatternCompiler;
/*   6:    */ 
/*   7:    */ public final class AwkCompiler
/*   8:    */   implements PatternCompiler
/*   9:    */ {
/*  10:    */   public static final int DEFAULT_MASK = 0;
/*  11:    */   public static final int CASE_INSENSITIVE_MASK = 1;
/*  12:    */   static final char _END_OF_INPUT = 'ð¿¿';
/*  13:    */   private boolean __inCharacterClass;
/*  14:    */   private boolean __caseSensitive;
/*  15:    */   private boolean __beginAnchor;
/*  16:    */   private boolean __endAnchor;
/*  17:    */   private char __lookahead;
/*  18:    */   private int __position;
/*  19:    */   private int __bytesRead;
/*  20:    */   private int __expressionLength;
/*  21:    */   private char[] __regularExpression;
/*  22:    */   private int __openParen;
/*  23:    */   private int __closeParen;
/*  24:    */   
/*  25:    */   private static boolean __isMetachar(char paramChar)
/*  26:    */   {
/*  27:161 */     return (paramChar == '*') || (paramChar == '?') || (paramChar == '+') || 
/*  28:162 */       (paramChar == '[') || (paramChar == ']') || (paramChar == '(') || 
/*  29:163 */       (paramChar == ')') || (paramChar == '|') || 
/*  30:164 */       (paramChar == '.');
/*  31:    */   }
/*  32:    */   
/*  33:    */   static boolean _isWordCharacter(char paramChar)
/*  34:    */   {
/*  35:168 */     return ((paramChar >= 'a') && (paramChar <= 'z')) || 
/*  36:169 */       ((paramChar >= 'A') && (paramChar <= 'Z')) || 
/*  37:170 */       ((paramChar >= '0') && (paramChar <= '9')) || 
/*  38:171 */       (paramChar == '_');
/*  39:    */   }
/*  40:    */   
/*  41:    */   static boolean _isLowerCase(char paramChar)
/*  42:    */   {
/*  43:175 */     return (paramChar >= 'a') && (paramChar <= 'z');
/*  44:    */   }
/*  45:    */   
/*  46:    */   static boolean _isUpperCase(char paramChar)
/*  47:    */   {
/*  48:179 */     return (paramChar >= 'A') && (paramChar <= 'Z');
/*  49:    */   }
/*  50:    */   
/*  51:    */   static char _toggleCase(char paramChar)
/*  52:    */   {
/*  53:183 */     if (_isUpperCase(paramChar)) {
/*  54:184 */       return (char)(paramChar + ' ');
/*  55:    */     }
/*  56:185 */     if (_isLowerCase(paramChar)) {
/*  57:186 */       return (char)(paramChar - ' ');
/*  58:    */     }
/*  59:188 */     return paramChar;
/*  60:    */   }
/*  61:    */   
/*  62:    */   private void __match(char paramChar)
/*  63:    */     throws MalformedPatternException
/*  64:    */   {
/*  65:193 */     if (paramChar == this.__lookahead)
/*  66:    */     {
/*  67:194 */       if (this.__bytesRead < this.__expressionLength) {
/*  68:195 */         this.__lookahead = this.__regularExpression[(this.__bytesRead++)];
/*  69:    */       } else {
/*  70:197 */         this.__lookahead = 65535;
/*  71:    */       }
/*  72:    */     }
/*  73:    */     else {
/*  74:200 */       throw new MalformedPatternException("token: " + paramChar + 
/*  75:201 */         " does not match lookahead: " + 
/*  76:202 */         this.__lookahead + " at position: " + 
/*  77:203 */         this.__bytesRead);
/*  78:    */     }
/*  79:    */   }
/*  80:    */   
/*  81:    */   private void __putback()
/*  82:    */   {
/*  83:207 */     if (this.__lookahead != 65535) {
/*  84:208 */       this.__bytesRead -= 1;
/*  85:    */     }
/*  86:209 */     this.__lookahead = this.__regularExpression[(this.__bytesRead - 1)];
/*  87:    */   }
/*  88:    */   
/*  89:    */   private SyntaxNode __regex()
/*  90:    */     throws MalformedPatternException
/*  91:    */   {
/*  92:215 */     SyntaxNode localSyntaxNode = __branch();
/*  93:217 */     if (this.__lookahead == '|')
/*  94:    */     {
/*  95:218 */       __match('|');
/*  96:219 */       return new OrNode(localSyntaxNode, __regex());
/*  97:    */     }
/*  98:222 */     return localSyntaxNode;
/*  99:    */   }
/* 100:    */   
/* 101:    */   private SyntaxNode __branch()
/* 102:    */     throws MalformedPatternException
/* 103:    */   {
/* 104:230 */     SyntaxNode localSyntaxNode = __piece();
/* 105:232 */     if (this.__lookahead == ')')
/* 106:    */     {
/* 107:233 */       if (this.__openParen > this.__closeParen) {
/* 108:234 */         return localSyntaxNode;
/* 109:    */       }
/* 110:236 */       throw 
/* 111:237 */         new MalformedPatternException(
/* 112:238 */         "Parse error: close parenthesis without matching open parenthesis at position " + this.__bytesRead);
/* 113:    */     }
/* 114:239 */     if ((this.__lookahead == '|') || (this.__lookahead == 65535)) {
/* 115:240 */       return localSyntaxNode;
/* 116:    */     }
/* 117:    */     CatNode localCatNode1;
/* 118:242 */     CatNode localCatNode2 = localCatNode1 = new CatNode();
/* 119:243 */     localCatNode1._left = localSyntaxNode;
/* 120:    */     for (;;)
/* 121:    */     {
/* 122:246 */       localSyntaxNode = __piece();
/* 123:248 */       if (this.__lookahead == ')')
/* 124:    */       {
/* 125:249 */         if (this.__openParen > this.__closeParen)
/* 126:    */         {
/* 127:250 */           localCatNode1._right = localSyntaxNode;
/* 128:251 */           break;
/* 129:    */         }
/* 130:254 */         throw 
/* 131:255 */           new MalformedPatternException(
/* 132:256 */           "Parse error: close parenthesis without matching open parenthesis at position " + this.__bytesRead);
/* 133:    */       }
/* 134:257 */       if ((this.__lookahead == '|') || (this.__lookahead == 65535))
/* 135:    */       {
/* 136:258 */         localCatNode1._right = localSyntaxNode;
/* 137:259 */         break;
/* 138:    */       }
/* 139:262 */       localCatNode1._right = new CatNode();
/* 140:263 */       localCatNode1 = (CatNode)localCatNode1._right;
/* 141:264 */       localCatNode1._left = localSyntaxNode;
/* 142:    */     }
/* 143:267 */     return localCatNode2;
/* 144:    */   }
/* 145:    */   
/* 146:    */   private SyntaxNode __piece()
/* 147:    */     throws MalformedPatternException
/* 148:    */   {
/* 149:274 */     SyntaxNode localSyntaxNode = __atom();
/* 150:276 */     switch (this.__lookahead)
/* 151:    */     {
/* 152:    */     case '+': 
/* 153:277 */       __match('+');return new PlusNode(localSyntaxNode);
/* 154:    */     case '?': 
/* 155:278 */       __match('?');return new QuestionNode(localSyntaxNode);
/* 156:    */     case '*': 
/* 157:279 */       __match('*');return new StarNode(localSyntaxNode);
/* 158:    */     case '{': 
/* 159:280 */       return __repetition(localSyntaxNode);
/* 160:    */     }
/* 161:283 */     return localSyntaxNode;
/* 162:    */   }
/* 163:    */   
/* 164:    */   private int __parseUnsignedInteger(int paramInt1, int paramInt2, int paramInt3)
/* 165:    */     throws MalformedPatternException
/* 166:    */   {
/* 167:289 */     int j = 0;
/* 168:    */     
/* 169:    */ 
/* 170:    */ 
/* 171:293 */     StringBuffer localStringBuffer = new StringBuffer(4);
/* 172:295 */     while ((Character.digit(this.__lookahead, paramInt1) != -1) && (j < paramInt3))
/* 173:    */     {
/* 174:296 */       localStringBuffer.append(this.__lookahead);
/* 175:297 */       __match(this.__lookahead);
/* 176:298 */       j++;
/* 177:    */     }
/* 178:301 */     if ((j < paramInt2) || (j > paramInt3)) {
/* 179:302 */       throw 
/* 180:303 */         new MalformedPatternException(
/* 181:304 */         "Parse error: unexpected number of digits at position " + this.__bytesRead);
/* 182:    */     }
/* 183:    */     int i;
/* 184:    */     try
/* 185:    */     {
/* 186:307 */       i = Integer.parseInt(localStringBuffer.toString(), paramInt1);
/* 187:    */     }
/* 188:    */     catch (NumberFormatException localNumberFormatException)
/* 189:    */     {
/* 190:309 */       throw 
/* 191:310 */         new MalformedPatternException("Parse error: numeric value at position " + 
/* 192:311 */         this.__bytesRead + " is invalid");
/* 193:    */     }
/* 194:314 */     return i;
/* 195:    */   }
/* 196:    */   
/* 197:    */   private SyntaxNode __repetition(SyntaxNode paramSyntaxNode)
/* 198:    */     throws MalformedPatternException
/* 199:    */   {
/* 200:321 */     CatNode localCatNode1 = null;
/* 201:    */     
/* 202:    */ 
/* 203:324 */     __match('{');
/* 204:    */     
/* 205:326 */     int i = __parseUnsignedInteger(10, 1, 2147483647);
/* 206:327 */     int[] arrayOfInt = new int[1];
/* 207:328 */     arrayOfInt[0] = this.__position;
/* 208:    */     CatNode localCatNode2;
/* 209:330 */     if (this.__lookahead == '}')
/* 210:    */     {
/* 211:332 */       __match('}');
/* 212:334 */       if (i == 0) {
/* 213:335 */         throw 
/* 214:336 */           new MalformedPatternException(
/* 215:337 */           "Parse error: Superfluous interval specified at position " + 
/* 216:338 */           this.__bytesRead + ".  Number of occurences was set to zero.");
/* 217:    */       }
/* 218:340 */       if (i == 1) {
/* 219:341 */         return paramSyntaxNode;
/* 220:    */       }
/* 221:343 */       localCatNode1 = localCatNode2 = new CatNode();
/* 222:344 */       localCatNode2._left = paramSyntaxNode;
/* 223:    */       do
/* 224:    */       {
/* 225:347 */         paramSyntaxNode = paramSyntaxNode._clone(arrayOfInt);
/* 226:    */         
/* 227:349 */         localCatNode2._right = new CatNode();
/* 228:350 */         localCatNode2 = (CatNode)localCatNode2._right;
/* 229:351 */         localCatNode2._left = paramSyntaxNode;i--;
/* 230:346 */       } while (i > 1);
/* 231:354 */       localCatNode2._right = paramSyntaxNode._clone(arrayOfInt);
/* 232:    */     }
/* 233:355 */     else if (this.__lookahead == ',')
/* 234:    */     {
/* 235:356 */       __match(',');
/* 236:358 */       if (this.__lookahead == '}')
/* 237:    */       {
/* 238:360 */         __match('}');
/* 239:362 */         if (i == 0) {
/* 240:363 */           return new StarNode(paramSyntaxNode);
/* 241:    */         }
/* 242:365 */         if (i == 1) {
/* 243:366 */           return new PlusNode(paramSyntaxNode);
/* 244:    */         }
/* 245:368 */         localCatNode1 = localCatNode2 = new CatNode();
/* 246:369 */         localCatNode2._left = paramSyntaxNode;
/* 247:    */         do
/* 248:    */         {
/* 249:372 */           paramSyntaxNode = paramSyntaxNode._clone(arrayOfInt);
/* 250:    */           
/* 251:374 */           localCatNode2._right = new CatNode();
/* 252:375 */           localCatNode2 = (CatNode)localCatNode2._right;
/* 253:376 */           localCatNode2._left = paramSyntaxNode;i--;
/* 254:371 */         } while (i > 0);
/* 255:379 */         localCatNode2._right = new StarNode(paramSyntaxNode._clone(arrayOfInt));
/* 256:    */       }
/* 257:    */       else
/* 258:    */       {
/* 259:382 */         int j = __parseUnsignedInteger(10, 1, 2147483647);
/* 260:383 */         __match('}');
/* 261:385 */         if (j < i) {
/* 262:386 */           throw 
/* 263:387 */             new MalformedPatternException("Parse error: invalid interval; " + 
/* 264:388 */             j + " is less than " + i + " at position " + this.__bytesRead);
/* 265:    */         }
/* 266:389 */         if (j == 0) {
/* 267:390 */           throw 
/* 268:391 */             new MalformedPatternException(
/* 269:392 */             "Parse error: Superfluous interval specified at position " + 
/* 270:393 */             this.__bytesRead + ".  Number of occurences was set to zero.");
/* 271:    */         }
/* 272:395 */         if (i == 0)
/* 273:    */         {
/* 274:396 */           if (j == 1) {
/* 275:397 */             return new QuestionNode(paramSyntaxNode);
/* 276:    */           }
/* 277:399 */           localCatNode1 = localCatNode2 = new CatNode();
/* 278:400 */           paramSyntaxNode = new QuestionNode(paramSyntaxNode);
/* 279:401 */           localCatNode2._left = paramSyntaxNode;
/* 280:    */           do
/* 281:    */           {
/* 282:404 */             paramSyntaxNode = paramSyntaxNode._clone(arrayOfInt);
/* 283:    */             
/* 284:406 */             localCatNode2._right = new CatNode();
/* 285:407 */             localCatNode2 = (CatNode)localCatNode2._right;
/* 286:408 */             localCatNode2._left = paramSyntaxNode;j--;
/* 287:403 */           } while (j > 1);
/* 288:411 */           localCatNode2._right = paramSyntaxNode._clone(arrayOfInt);
/* 289:    */         }
/* 290:412 */         else if (i == j)
/* 291:    */         {
/* 292:413 */           if (i == 1) {
/* 293:414 */             return paramSyntaxNode;
/* 294:    */           }
/* 295:416 */           localCatNode1 = localCatNode2 = new CatNode();
/* 296:417 */           localCatNode2._left = paramSyntaxNode;
/* 297:    */           do
/* 298:    */           {
/* 299:420 */             paramSyntaxNode = paramSyntaxNode._clone(arrayOfInt);
/* 300:    */             
/* 301:422 */             localCatNode2._right = new CatNode();
/* 302:423 */             localCatNode2 = (CatNode)localCatNode2._right;
/* 303:424 */             localCatNode2._left = paramSyntaxNode;i--;
/* 304:419 */           } while (i > 1);
/* 305:427 */           localCatNode2._right = paramSyntaxNode._clone(arrayOfInt);
/* 306:    */         }
/* 307:    */         else
/* 308:    */         {
/* 309:431 */           localCatNode1 = localCatNode2 = new CatNode();
/* 310:432 */           localCatNode2._left = paramSyntaxNode;
/* 311:434 */           for (int k = 1; k < i; k++)
/* 312:    */           {
/* 313:435 */             paramSyntaxNode = paramSyntaxNode._clone(arrayOfInt);
/* 314:    */             
/* 315:437 */             localCatNode2._right = new CatNode();
/* 316:438 */             localCatNode2 = (CatNode)localCatNode2._right;
/* 317:439 */             localCatNode2._left = paramSyntaxNode;
/* 318:    */           }
/* 319:442 */           paramSyntaxNode = new QuestionNode(paramSyntaxNode._clone(arrayOfInt));
/* 320:    */           
/* 321:444 */           k = j - i;
/* 322:446 */           if (k == 1)
/* 323:    */           {
/* 324:447 */             localCatNode2._right = paramSyntaxNode;
/* 325:    */           }
/* 326:    */           else
/* 327:    */           {
/* 328:449 */             localCatNode2._right = new CatNode();
/* 329:450 */             localCatNode2 = (CatNode)localCatNode2._right;
/* 330:451 */             localCatNode2._left = paramSyntaxNode;
/* 331:    */             do
/* 332:    */             {
/* 333:454 */               paramSyntaxNode = paramSyntaxNode._clone(arrayOfInt);
/* 334:    */               
/* 335:456 */               localCatNode2._right = new CatNode();
/* 336:457 */               localCatNode2 = (CatNode)localCatNode2._right;
/* 337:458 */               localCatNode2._left = paramSyntaxNode;k--;
/* 338:453 */             } while (k > 1);
/* 339:461 */             localCatNode2._right = paramSyntaxNode._clone(arrayOfInt);
/* 340:    */           }
/* 341:    */         }
/* 342:    */       }
/* 343:    */     }
/* 344:    */     else
/* 345:    */     {
/* 346:466 */       throw 
/* 347:467 */         new MalformedPatternException("Parse error: unexpected character " + 
/* 348:468 */         this.__lookahead + " in interval at position " + this.__bytesRead);
/* 349:    */     }
/* 350:469 */     this.__position = arrayOfInt[0];
/* 351:470 */     return localCatNode1;
/* 352:    */   }
/* 353:    */   
/* 354:    */   private SyntaxNode __backslashToken()
/* 355:    */     throws MalformedPatternException
/* 356:    */   {
/* 357:479 */     __match('\\');
/* 358:    */     Object localObject1;
/* 359:481 */     if (this.__lookahead == 'x')
/* 360:    */     {
/* 361:482 */       __match('x');
/* 362:    */       
/* 363:484 */       localObject1 = _newTokenNode((char)__parseUnsignedInteger(16, 2, 2), 
/* 364:485 */         this.__position++);
/* 365:    */     }
/* 366:    */     else
/* 367:    */     {
/* 368:    */       char c;
/* 369:486 */       if (this.__lookahead == 'c')
/* 370:    */       {
/* 371:487 */         __match('c');
/* 372:    */         
/* 373:489 */         c = Character.toUpperCase(this.__lookahead);
/* 374:490 */         c = (char)(c > '?' ? c - '@' : c + '@');
/* 375:491 */         localObject1 = new TokenNode(c, this.__position++);
/* 376:492 */         __match(this.__lookahead);
/* 377:    */       }
/* 378:493 */       else if ((this.__lookahead >= '0') && (this.__lookahead <= '9'))
/* 379:    */       {
/* 380:494 */         __match(this.__lookahead);
/* 381:    */         int i;
/* 382:496 */         if ((this.__lookahead >= '0') && (this.__lookahead <= '9'))
/* 383:    */         {
/* 384:499 */           __putback();
/* 385:500 */           i = __parseUnsignedInteger(10, 2, 3);
/* 386:501 */           i = Integer.parseInt(Integer.toString(i), 8);
/* 387:502 */           localObject1 = _newTokenNode((char)i, this.__position++);
/* 388:    */         }
/* 389:    */         else
/* 390:    */         {
/* 391:505 */           __putback();
/* 392:506 */           if (this.__lookahead == '0')
/* 393:    */           {
/* 394:508 */             __match('0');
/* 395:509 */             localObject1 = new TokenNode('\000', this.__position++);
/* 396:    */           }
/* 397:    */           else
/* 398:    */           {
/* 399:512 */             i = Character.digit(this.__lookahead, 10);
/* 400:513 */             localObject1 = _newTokenNode(this.__lookahead, this.__position++);
/* 401:514 */             __match(this.__lookahead);
/* 402:    */           }
/* 403:    */         }
/* 404:    */       }
/* 405:517 */       else if (this.__lookahead == 'b')
/* 406:    */       {
/* 407:522 */         localObject1 = new TokenNode('\b', this.__position++);
/* 408:    */         
/* 409:    */ 
/* 410:    */ 
/* 411:    */ 
/* 412:    */ 
/* 413:528 */         __match('b');
/* 414:    */       }
/* 415:    */       else
/* 416:    */       {
/* 417:535 */         c = this.__lookahead;
/* 418:537 */         switch (this.__lookahead)
/* 419:    */         {
/* 420:    */         case 'n': 
/* 421:538 */           c = '\n'; break;
/* 422:    */         case 'r': 
/* 423:539 */           c = '\r'; break;
/* 424:    */         case 't': 
/* 425:540 */           c = '\t'; break;
/* 426:    */         case 'f': 
/* 427:541 */           c = '\f'; break;
/* 428:    */         }
/* 429:    */         Object localObject2;
/* 430:544 */         switch (c)
/* 431:    */         {
/* 432:    */         case 'd': 
/* 433:546 */           localObject2 = new CharacterClassNode(this.__position++);
/* 434:547 */           ((CharacterClassNode)localObject2)._addTokenRange(48, 57);
/* 435:548 */           localObject1 = localObject2;
/* 436:549 */           break;
/* 437:    */         case 'D': 
/* 438:551 */           localObject2 = new NegativeCharacterClassNode(this.__position++);
/* 439:552 */           ((CharacterClassNode)localObject2)._addTokenRange(48, 57);
/* 440:553 */           localObject1 = localObject2;
/* 441:554 */           break;
/* 442:    */         case 'w': 
/* 443:556 */           localObject2 = new CharacterClassNode(this.__position++);
/* 444:557 */           ((CharacterClassNode)localObject2)._addTokenRange(48, 57);
/* 445:558 */           ((CharacterClassNode)localObject2)._addTokenRange(97, 122);
/* 446:559 */           ((CharacterClassNode)localObject2)._addTokenRange(65, 90);
/* 447:560 */           ((CharacterClassNode)localObject2)._addToken(95);
/* 448:561 */           localObject1 = localObject2;
/* 449:562 */           break;
/* 450:    */         case 'W': 
/* 451:564 */           localObject2 = new NegativeCharacterClassNode(this.__position++);
/* 452:565 */           ((CharacterClassNode)localObject2)._addTokenRange(48, 57);
/* 453:566 */           ((CharacterClassNode)localObject2)._addTokenRange(97, 122);
/* 454:567 */           ((CharacterClassNode)localObject2)._addTokenRange(65, 90);
/* 455:568 */           ((CharacterClassNode)localObject2)._addToken(95);
/* 456:569 */           localObject1 = localObject2;
/* 457:570 */           break;
/* 458:    */         case 's': 
/* 459:572 */           localObject2 = new CharacterClassNode(this.__position++);
/* 460:573 */           ((CharacterClassNode)localObject2)._addToken(32);
/* 461:574 */           ((CharacterClassNode)localObject2)._addToken(12);
/* 462:575 */           ((CharacterClassNode)localObject2)._addToken(10);
/* 463:576 */           ((CharacterClassNode)localObject2)._addToken(13);
/* 464:577 */           ((CharacterClassNode)localObject2)._addToken(9);
/* 465:578 */           localObject1 = localObject2;
/* 466:579 */           break;
/* 467:    */         case 'S': 
/* 468:581 */           localObject2 = new NegativeCharacterClassNode(this.__position++);
/* 469:582 */           ((CharacterClassNode)localObject2)._addToken(32);
/* 470:583 */           ((CharacterClassNode)localObject2)._addToken(12);
/* 471:584 */           ((CharacterClassNode)localObject2)._addToken(10);
/* 472:585 */           ((CharacterClassNode)localObject2)._addToken(13);
/* 473:586 */           ((CharacterClassNode)localObject2)._addToken(9);
/* 474:587 */           localObject1 = localObject2;
/* 475:588 */           break;
/* 476:    */         default: 
/* 477:589 */           localObject1 = _newTokenNode(c, this.__position++);
/* 478:    */         }
/* 479:592 */         __match(this.__lookahead);
/* 480:    */       }
/* 481:    */     }
/* 482:595 */     return localObject1;
/* 483:    */   }
/* 484:    */   
/* 485:    */   private SyntaxNode __atom()
/* 486:    */     throws MalformedPatternException
/* 487:    */   {
/* 488:    */     Object localObject;
/* 489:601 */     if (this.__lookahead == '(')
/* 490:    */     {
/* 491:602 */       __match('(');
/* 492:603 */       this.__openParen += 1;
/* 493:604 */       localObject = __regex();
/* 494:605 */       __match(')');
/* 495:606 */       this.__closeParen += 1;
/* 496:    */     }
/* 497:607 */     else if (this.__lookahead == '[')
/* 498:    */     {
/* 499:608 */       localObject = __characterClass();
/* 500:    */     }
/* 501:609 */     else if (this.__lookahead == '.')
/* 502:    */     {
/* 503:612 */       __match('.');
/* 504:613 */       NegativeCharacterClassNode localNegativeCharacterClassNode = new NegativeCharacterClassNode(this.__position++);
/* 505:614 */       localNegativeCharacterClassNode._addToken(10);
/* 506:615 */       localObject = localNegativeCharacterClassNode;
/* 507:    */     }
/* 508:616 */     else if (this.__lookahead == '\\')
/* 509:    */     {
/* 510:617 */       localObject = __backslashToken();
/* 511:    */     }
/* 512:626 */     else if (!__isMetachar(this.__lookahead))
/* 513:    */     {
/* 514:627 */       localObject = _newTokenNode(this.__lookahead, this.__position++);
/* 515:628 */       __match(this.__lookahead);
/* 516:    */     }
/* 517:    */     else
/* 518:    */     {
/* 519:630 */       throw 
/* 520:631 */         new MalformedPatternException("Parse error: unexpected character " + 
/* 521:632 */         this.__lookahead + " at position " + this.__bytesRead);
/* 522:    */     }
/* 523:634 */     return localObject;
/* 524:    */   }
/* 525:    */   
/* 526:    */   private SyntaxNode __characterClass()
/* 527:    */     throws MalformedPatternException
/* 528:    */   {
/* 529:643 */     __match('[');
/* 530:644 */     this.__inCharacterClass = true;
/* 531:    */     Object localObject;
/* 532:646 */     if (this.__lookahead == '^')
/* 533:    */     {
/* 534:647 */       __match('^');
/* 535:648 */       localObject = new NegativeCharacterClassNode(this.__position++);
/* 536:    */     }
/* 537:    */     else
/* 538:    */     {
/* 539:650 */       localObject = new CharacterClassNode(this.__position++);
/* 540:    */     }
/* 541:652 */     while ((this.__lookahead != ']') && (this.__lookahead != 65535))
/* 542:    */     {
/* 543:    */       SyntaxNode localSyntaxNode;
/* 544:    */       char c1;
/* 545:654 */       if (this.__lookahead == '\\')
/* 546:    */       {
/* 547:655 */         localSyntaxNode = __backslashToken();
/* 548:656 */         this.__position -= 1;
/* 549:660 */         if ((localSyntaxNode instanceof TokenNode))
/* 550:    */         {
/* 551:661 */           c1 = ((TokenNode)localSyntaxNode)._token;
/* 552:662 */           ((CharacterClassNode)localObject)._addToken(c1);
/* 553:663 */           if (!this.__caseSensitive) {
/* 554:664 */             ((CharacterClassNode)localObject)._addToken(_toggleCase(c1));
/* 555:    */           }
/* 556:    */         }
/* 557:    */         else
/* 558:    */         {
/* 559:667 */           CharacterClassNode localCharacterClassNode = (CharacterClassNode)localSyntaxNode;
/* 560:671 */           for (int i = 0; i < 256; i = (char)(i + 1)) {
/* 561:672 */             if (localCharacterClassNode._matches(i)) {
/* 562:673 */               ((CharacterClassNode)localObject)._addToken(i);
/* 563:    */             }
/* 564:    */           }
/* 565:680 */           continue;
/* 566:    */         }
/* 567:    */       }
/* 568:    */       else
/* 569:    */       {
/* 570:683 */         c1 = this.__lookahead;
/* 571:684 */         ((CharacterClassNode)localObject)._addToken(this.__lookahead);
/* 572:685 */         if (!this.__caseSensitive) {
/* 573:686 */           ((CharacterClassNode)localObject)._addToken(_toggleCase(this.__lookahead));
/* 574:    */         }
/* 575:687 */         __match(this.__lookahead);
/* 576:    */       }
/* 577:697 */       if (this.__lookahead == '-')
/* 578:    */       {
/* 579:698 */         __match('-');
/* 580:699 */         if (this.__lookahead == ']')
/* 581:    */         {
/* 582:700 */           ((CharacterClassNode)localObject)._addToken(45);
/* 583:701 */           break;
/* 584:    */         }
/* 585:    */         char c2;
/* 586:702 */         if (this.__lookahead == '\\')
/* 587:    */         {
/* 588:703 */           localSyntaxNode = __backslashToken();
/* 589:704 */           this.__position -= 1;
/* 590:705 */           if ((localSyntaxNode instanceof TokenNode)) {
/* 591:706 */             c2 = ((TokenNode)localSyntaxNode)._token;
/* 592:    */           } else {
/* 593:708 */             throw new MalformedPatternException(
/* 594:709 */               "Parse error: invalid range specified at position " + this.__bytesRead);
/* 595:    */           }
/* 596:    */         }
/* 597:    */         else
/* 598:    */         {
/* 599:711 */           c2 = this.__lookahead;
/* 600:712 */           __match(this.__lookahead);
/* 601:    */         }
/* 602:715 */         if (c2 < c1) {
/* 603:716 */           throw new MalformedPatternException(
/* 604:717 */             "Parse error: invalid range specified at position " + this.__bytesRead);
/* 605:    */         }
/* 606:718 */         ((CharacterClassNode)localObject)._addTokenRange(c1 + '\001', c2);
/* 607:719 */         if (!this.__caseSensitive) {
/* 608:720 */           ((CharacterClassNode)localObject)._addTokenRange(_toggleCase((char)(c1 + '\001')), 
/* 609:721 */             _toggleCase(c2));
/* 610:    */         }
/* 611:    */       }
/* 612:    */     }
/* 613:725 */     __match(']');
/* 614:726 */     this.__inCharacterClass = false;
/* 615:727 */     return localObject;
/* 616:    */   }
/* 617:    */   
/* 618:    */   SyntaxNode _newTokenNode(char paramChar, int paramInt)
/* 619:    */   {
/* 620:732 */     if ((!this.__inCharacterClass) && (!this.__caseSensitive) && (
/* 621:733 */       (_isUpperCase(paramChar)) || (_isLowerCase(paramChar))))
/* 622:    */     {
/* 623:734 */       CharacterClassNode localCharacterClassNode = new CharacterClassNode(paramInt);
/* 624:735 */       localCharacterClassNode._addToken(paramChar);
/* 625:736 */       localCharacterClassNode._addToken(_toggleCase(paramChar));
/* 626:737 */       return localCharacterClassNode;
/* 627:    */     }
/* 628:740 */     return new TokenNode(paramChar, paramInt);
/* 629:    */   }
/* 630:    */   
/* 631:    */   SyntaxTree _parse(char[] paramArrayOfChar)
/* 632:    */     throws MalformedPatternException
/* 633:    */   {
/* 634:747 */     this.__openParen = (this.__closeParen = 0);
/* 635:748 */     this.__regularExpression = paramArrayOfChar;
/* 636:749 */     this.__bytesRead = 0;
/* 637:750 */     this.__expressionLength = paramArrayOfChar.length;
/* 638:751 */     this.__inCharacterClass = false;
/* 639:    */     
/* 640:753 */     this.__position = 0;
/* 641:754 */     __match(this.__lookahead);
/* 642:756 */     if (this.__lookahead == '^')
/* 643:    */     {
/* 644:757 */       this.__beginAnchor = true;
/* 645:758 */       __match(this.__lookahead);
/* 646:    */     }
/* 647:761 */     if ((this.__expressionLength > 0) && (paramArrayOfChar[(this.__expressionLength - 1)] == '$'))
/* 648:    */     {
/* 649:762 */       this.__expressionLength -= 1;
/* 650:763 */       this.__endAnchor = true;
/* 651:    */     }
/* 652:    */     SyntaxTree localSyntaxTree;
/* 653:766 */     if ((this.__expressionLength > 1) || ((this.__expressionLength == 1) && (!this.__beginAnchor)))
/* 654:    */     {
/* 655:768 */       CatNode localCatNode = new CatNode();
/* 656:769 */       localCatNode._left = __regex();
/* 657:    */       
/* 658:771 */       localCatNode._right = 
/* 659:772 */         new TokenNode('Ä€', this.__position++);
/* 660:773 */       localSyntaxTree = new SyntaxTree(localCatNode, this.__position);
/* 661:    */     }
/* 662:    */     else
/* 663:    */     {
/* 664:775 */       localSyntaxTree = new SyntaxTree(
/* 665:776 */         new TokenNode('Ä€', 0), 1);
/* 666:    */     }
/* 667:778 */     localSyntaxTree._computeFollowPositions();
/* 668:    */     
/* 669:780 */     return localSyntaxTree;
/* 670:    */   }
/* 671:    */   
/* 672:    */   public Pattern compile(char[] paramArrayOfChar, int paramInt)
/* 673:    */     throws MalformedPatternException
/* 674:    */   {
/* 675:804 */     this.__beginAnchor = (this.__endAnchor = 0);
/* 676:805 */     this.__caseSensitive = ((paramInt & 0x1) == 0);
/* 677:806 */     SyntaxTree localSyntaxTree = _parse(paramArrayOfChar);
/* 678:807 */     AwkPattern localAwkPattern = new AwkPattern(new String(paramArrayOfChar), localSyntaxTree);
/* 679:808 */     localAwkPattern._options = paramInt;
/* 680:809 */     localAwkPattern._hasBeginAnchor = this.__beginAnchor;
/* 681:810 */     localAwkPattern._hasEndAnchor = this.__endAnchor;
/* 682:    */     
/* 683:812 */     return localAwkPattern;
/* 684:    */   }
/* 685:    */   
/* 686:    */   public Pattern compile(String paramString, int paramInt)
/* 687:    */     throws MalformedPatternException
/* 688:    */   {
/* 689:836 */     this.__beginAnchor = (this.__endAnchor = 0);
/* 690:837 */     this.__caseSensitive = ((paramInt & 0x1) == 0);
/* 691:838 */     SyntaxTree localSyntaxTree = _parse(paramString.toCharArray());
/* 692:839 */     AwkPattern localAwkPattern = new AwkPattern(paramString, localSyntaxTree);
/* 693:840 */     localAwkPattern._options = paramInt;
/* 694:841 */     localAwkPattern._hasBeginAnchor = this.__beginAnchor;
/* 695:842 */     localAwkPattern._hasEndAnchor = this.__endAnchor;
/* 696:    */     
/* 697:844 */     return localAwkPattern;
/* 698:    */   }
/* 699:    */   
/* 700:    */   public Pattern compile(char[] paramArrayOfChar)
/* 701:    */     throws MalformedPatternException
/* 702:    */   {
/* 703:858 */     return compile(paramArrayOfChar, 0);
/* 704:    */   }
/* 705:    */   
/* 706:    */   public Pattern compile(String paramString)
/* 707:    */     throws MalformedPatternException
/* 708:    */   {
/* 709:873 */     return compile(paramString, 0);
/* 710:    */   }
/* 711:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.AwkCompiler
 * JD-Core Version:    0.7.0.1
 */
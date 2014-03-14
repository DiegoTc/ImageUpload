/*    1:     */ package org.apache.oro.text.perl;
/*    2:     */ 
/*    3:     */ import java.util.List;
/*    4:     */ import java.util.Vector;
/*    5:     */ import org.apache.oro.text.PatternCache;
/*    6:     */ import org.apache.oro.text.PatternCacheLRU;
/*    7:     */ import org.apache.oro.text.regex.MalformedPatternException;
/*    8:     */ import org.apache.oro.text.regex.MatchResult;
/*    9:     */ import org.apache.oro.text.regex.Pattern;
/*   10:     */ import org.apache.oro.text.regex.PatternMatcherInput;
/*   11:     */ import org.apache.oro.text.regex.Perl5Compiler;
/*   12:     */ import org.apache.oro.text.regex.Perl5Matcher;
/*   13:     */ import org.apache.oro.text.regex.Perl5Substitution;
/*   14:     */ import org.apache.oro.text.regex.Util;
/*   15:     */ import org.apache.oro.util.Cache;
/*   16:     */ import org.apache.oro.util.CacheLRU;
/*   17:     */ 
/*   18:     */ public final class Perl5Util
/*   19:     */   implements MatchResult
/*   20:     */ {
/*   21:     */   private static final String __matchExpression = "m?(\\W)(.*)\\1([imsx]*)";
/*   22:     */   private PatternCache __patternCache;
/*   23:     */   private Cache __expressionCache;
/*   24: 167 */   private Perl5Matcher __matcher = new Perl5Matcher();
/*   25:     */   private Pattern __matchPattern;
/*   26:     */   private MatchResult __lastMatch;
/*   27:     */   private Object __originalInput;
/*   28:     */   private int __inputBeginOffset;
/*   29:     */   private int __inputEndOffset;
/*   30:     */   private static final String __nullString = "";
/*   31:     */   public static final int SPLIT_ALL = 0;
/*   32:     */   
/*   33:     */   public Perl5Util(PatternCache paramPatternCache)
/*   34:     */   {
/*   35: 215 */     this.__patternCache = paramPatternCache;
/*   36: 216 */     this.__expressionCache = new CacheLRU(paramPatternCache.capacity());
/*   37: 217 */     __compilePatterns();
/*   38:     */   }
/*   39:     */   
/*   40:     */   public Perl5Util()
/*   41:     */   {
/*   42: 228 */     this(new PatternCacheLRU());
/*   43:     */   }
/*   44:     */   
/*   45:     */   private void __compilePatterns()
/*   46:     */   {
/*   47: 236 */     Perl5Compiler localPerl5Compiler = new Perl5Compiler();
/*   48:     */     try
/*   49:     */     {
/*   50: 239 */       this.__matchPattern = 
/*   51: 240 */         localPerl5Compiler.compile("m?(\\W)(.*)\\1([imsx]*)", 16);
/*   52:     */     }
/*   53:     */     catch (MalformedPatternException localMalformedPatternException)
/*   54:     */     {
/*   55: 244 */       throw new RuntimeException(localMalformedPatternException.getMessage());
/*   56:     */     }
/*   57:     */   }
/*   58:     */   
/*   59:     */   private Pattern __parseMatchExpression(String paramString)
/*   60:     */     throws MalformedPerl5PatternException
/*   61:     */   {
/*   62: 268 */     Object localObject = this.__expressionCache.getElement(paramString);
/*   63:     */     try
/*   64:     */     {
/*   65: 274 */       if (localObject != null) {
/*   66: 275 */         return (Pattern)localObject;
/*   67:     */       }
/*   68:     */     }
/*   69:     */     catch (ClassCastException localClassCastException)
/*   70:     */     {
/*   71: 280 */       if (!this.__matcher.matches(paramString, this.__matchPattern)) {
/*   72: 281 */         throw new MalformedPerl5PatternException(
/*   73: 282 */           "Invalid expression: " + 
/*   74: 283 */           paramString);
/*   75:     */       }
/*   76: 285 */       MatchResult localMatchResult = this.__matcher.getMatch();
/*   77:     */       
/*   78: 287 */       String str2 = localMatchResult.group(2);
/*   79: 288 */       int j = 0;
/*   80:     */       
/*   81: 290 */       String str1 = localMatchResult.group(3);
/*   82: 292 */       if (str1 != null)
/*   83:     */       {
/*   84: 293 */         int i = str1.length();
/*   85: 295 */         while (i-- > 0) {
/*   86: 296 */           switch (str1.charAt(i))
/*   87:     */           {
/*   88:     */           case 'i': 
/*   89: 298 */             j |= 0x1;
/*   90: 299 */             break;
/*   91:     */           case 'm': 
/*   92: 300 */             j |= 0x8; break;
/*   93:     */           case 's': 
/*   94: 301 */             j |= 0x10; break;
/*   95:     */           case 'x': 
/*   96: 302 */             j |= 0x20; break;
/*   97:     */           default: 
/*   98: 304 */             throw new MalformedPerl5PatternException(
/*   99: 305 */               "Invalid options: " + str1);
/*  100:     */           }
/*  101:     */         }
/*  102:     */       }
/*  103: 310 */       Pattern localPattern = this.__patternCache.getPattern(str2, j);
/*  104: 311 */       this.__expressionCache.addElement(paramString, localPattern);
/*  105:     */       
/*  106: 313 */       return localPattern;
/*  107:     */     }
/*  108:     */   }
/*  109:     */   
/*  110:     */   public synchronized boolean match(String paramString, char[] paramArrayOfChar)
/*  111:     */     throws MalformedPerl5PatternException
/*  112:     */   {
/*  113: 351 */     __parseMatchExpression(paramString);
/*  114:     */     
/*  115: 353 */     boolean bool = this.__matcher.contains(paramArrayOfChar, __parseMatchExpression(paramString));
/*  116: 355 */     if (bool)
/*  117:     */     {
/*  118: 356 */       this.__lastMatch = this.__matcher.getMatch();
/*  119: 357 */       this.__originalInput = paramArrayOfChar;
/*  120: 358 */       this.__inputBeginOffset = 0;
/*  121: 359 */       this.__inputEndOffset = paramArrayOfChar.length;
/*  122:     */     }
/*  123: 362 */     return bool;
/*  124:     */   }
/*  125:     */   
/*  126:     */   public synchronized boolean match(String paramString1, String paramString2)
/*  127:     */     throws MalformedPerl5PatternException
/*  128:     */   {
/*  129: 400 */     return match(paramString1, paramString2.toCharArray());
/*  130:     */   }
/*  131:     */   
/*  132:     */   public synchronized boolean match(String paramString, PatternMatcherInput paramPatternMatcherInput)
/*  133:     */     throws MalformedPerl5PatternException
/*  134:     */   {
/*  135: 445 */     boolean bool = this.__matcher.contains(paramPatternMatcherInput, __parseMatchExpression(paramString));
/*  136: 447 */     if (bool)
/*  137:     */     {
/*  138: 448 */       this.__lastMatch = this.__matcher.getMatch();
/*  139: 449 */       this.__originalInput = paramPatternMatcherInput.getInput();
/*  140: 450 */       this.__inputBeginOffset = paramPatternMatcherInput.getBeginOffset();
/*  141: 451 */       this.__inputEndOffset = paramPatternMatcherInput.getEndOffset();
/*  142:     */     }
/*  143: 454 */     return bool;
/*  144:     */   }
/*  145:     */   
/*  146:     */   public synchronized MatchResult getMatch()
/*  147:     */   {
/*  148: 470 */     return this.__lastMatch;
/*  149:     */   }
/*  150:     */   
/*  151:     */   public synchronized String substitute(String paramString1, String paramString2)
/*  152:     */     throws MalformedPerl5PatternException
/*  153:     */   {
/*  154: 561 */     Object localObject = this.__expressionCache.getElement(paramString1);
/*  155: 564 */     if (localObject != null)
/*  156:     */     {
/*  157:     */       try
/*  158:     */       {
/*  159: 570 */         localParsedSubstitutionEntry = (ParsedSubstitutionEntry)localObject;
/*  160:     */       }
/*  161:     */       catch (ClassCastException localClassCastException)
/*  162:     */       {
/*  163:     */         break label70;
/*  164:     */       }
/*  165: 575 */       str = Util.substitute(this.__matcher, localParsedSubstitutionEntry._pattern, localParsedSubstitutionEntry._substitution, 
/*  166: 576 */         paramString2, localParsedSubstitutionEntry._numSubstitutions);
/*  167:     */       
/*  168: 578 */       this.__lastMatch = this.__matcher.getMatch();
/*  169:     */       
/*  170: 580 */       return str;
/*  171:     */     }
/*  172:     */     label70:
/*  173: 583 */     char[] arrayOfChar = paramString1.toCharArray();
/*  174: 586 */     if ((arrayOfChar.length < 4) || (arrayOfChar[0] != 's') || (Character.isLetterOrDigit(arrayOfChar[1])) || 
/*  175: 587 */       (arrayOfChar[1] == '-')) {
/*  176: 588 */       throw new MalformedPerl5PatternException(
/*  177: 589 */         "Invalid expression: " + paramString1);
/*  178:     */     }
/*  179: 590 */     int i5 = arrayOfChar[1];
/*  180: 591 */     int i2 = 2;
/*  181:     */     int i4;
/*  182: 592 */     int i3 = i4 = -1;
/*  183: 593 */     int i = 0;
/*  184: 596 */     for (int k = i2; k < arrayOfChar.length; k++) {
/*  185: 597 */       if (arrayOfChar[k] == '\\')
/*  186:     */       {
/*  187: 598 */         i ^= 0x1;
/*  188:     */       }
/*  189:     */       else
/*  190:     */       {
/*  191: 599 */         if ((arrayOfChar[k] == i5) && (i == 0))
/*  192:     */         {
/*  193: 600 */           i3 = k;
/*  194: 601 */           break;
/*  195:     */         }
/*  196: 602 */         if (i != 0) {
/*  197: 603 */           i ^= 0x1;
/*  198:     */         }
/*  199:     */       }
/*  200:     */     }
/*  201: 606 */     if ((i3 == -1) || (i3 == arrayOfChar.length - 1)) {
/*  202: 607 */       throw new MalformedPerl5PatternException(
/*  203: 608 */         "Invalid expression: " + paramString1);
/*  204:     */     }
/*  205: 612 */     i = 0;
/*  206: 613 */     int j = 1;
/*  207: 614 */     StringBuffer localStringBuffer = new StringBuffer(arrayOfChar.length - i3);
/*  208: 615 */     for (k = i3 + 1; k < arrayOfChar.length; k++)
/*  209:     */     {
/*  210: 616 */       if (arrayOfChar[k] == '\\')
/*  211:     */       {
/*  212: 617 */         i ^= 0x1;
/*  213: 623 */         if ((i != 0) && (k + 1 < arrayOfChar.length) && (arrayOfChar[(k + 1)] == i5) && 
/*  214: 624 */           (paramString1.lastIndexOf(i5, arrayOfChar.length - 1) != k + 1))
/*  215:     */         {
/*  216: 626 */           j = 0;
/*  217: 627 */           continue;
/*  218:     */         }
/*  219:     */       }
/*  220:     */       else
/*  221:     */       {
/*  222: 629 */         if ((arrayOfChar[k] == i5) && (j != 0))
/*  223:     */         {
/*  224: 630 */           i4 = k;
/*  225: 631 */           break;
/*  226:     */         }
/*  227: 633 */         i = 0;
/*  228: 634 */         j = 1;
/*  229:     */       }
/*  230: 637 */       localStringBuffer.append(arrayOfChar[k]);
/*  231:     */     }
/*  232: 640 */     if (i4 == -1) {
/*  233: 641 */       throw new MalformedPerl5PatternException(
/*  234: 642 */         "Invalid expression: " + paramString1);
/*  235:     */     }
/*  236: 644 */     int m = 0;
/*  237: 645 */     int n = 1;
/*  238:     */     int i1;
/*  239: 648 */     if (i5 != 39) {
/*  240: 649 */       i1 = 0;
/*  241:     */     } else {
/*  242: 651 */       i1 = -1;
/*  243:     */     }
/*  244: 654 */     for (k = i4 + 1; k < arrayOfChar.length; k++) {
/*  245: 655 */       switch (arrayOfChar[k])
/*  246:     */       {
/*  247:     */       case 'i': 
/*  248: 657 */         m |= 0x1;
/*  249: 658 */         break;
/*  250:     */       case 'm': 
/*  251: 659 */         m |= 0x8; break;
/*  252:     */       case 's': 
/*  253: 660 */         m |= 0x10; break;
/*  254:     */       case 'x': 
/*  255: 661 */         m |= 0x20; break;
/*  256:     */       case 'g': 
/*  257: 662 */         n = -1; break;
/*  258:     */       case 'o': 
/*  259: 663 */         i1 = 1; break;
/*  260:     */       case 'h': 
/*  261:     */       case 'j': 
/*  262:     */       case 'k': 
/*  263:     */       case 'l': 
/*  264:     */       case 'n': 
/*  265:     */       case 'p': 
/*  266:     */       case 'q': 
/*  267:     */       case 'r': 
/*  268:     */       case 't': 
/*  269:     */       case 'u': 
/*  270:     */       case 'v': 
/*  271:     */       case 'w': 
/*  272:     */       default: 
/*  273: 665 */         throw new MalformedPerl5PatternException(
/*  274: 666 */           "Invalid option: " + arrayOfChar[k]);
/*  275:     */       }
/*  276:     */     }
/*  277: 670 */     Pattern localPattern = 
/*  278: 671 */       this.__patternCache.getPattern(new String(arrayOfChar, i2, 
/*  279: 672 */       i3 - i2), 
/*  280: 673 */       m);
/*  281: 674 */     Perl5Substitution localPerl5Substitution = 
/*  282: 675 */       new Perl5Substitution(localStringBuffer.toString(), i1);
/*  283: 676 */     ParsedSubstitutionEntry localParsedSubstitutionEntry = new ParsedSubstitutionEntry(localPattern, localPerl5Substitution, 
/*  284: 677 */       n);
/*  285: 678 */     this.__expressionCache.addElement(paramString1, localParsedSubstitutionEntry);
/*  286:     */     
/*  287: 680 */     String str = Util.substitute(this.__matcher, localPattern, localPerl5Substitution, 
/*  288: 681 */       paramString2, n);
/*  289:     */     
/*  290: 683 */     this.__lastMatch = this.__matcher.getMatch();
/*  291:     */     
/*  292: 685 */     return str;
/*  293:     */   }
/*  294:     */   
/*  295:     */   public synchronized void split(List paramList, String paramString1, String paramString2, int paramInt)
/*  296:     */     throws MalformedPerl5PatternException
/*  297:     */   {
/*  298: 756 */     MatchResult localMatchResult = null;
/*  299:     */     
/*  300:     */ 
/*  301:     */ 
/*  302: 760 */     Pattern localPattern = __parseMatchExpression(paramString1);
/*  303:     */     
/*  304: 762 */     PatternMatcherInput localPatternMatcherInput = new PatternMatcherInput(paramString2);
/*  305: 763 */     int i = 0;
/*  306:     */     do
/*  307:     */     {
/*  308: 766 */       localMatchResult = this.__matcher.getMatch();
/*  309:     */       
/*  310: 768 */       paramList.add(paramString2.substring(i, 
/*  311: 769 */         localMatchResult.beginOffset(0)));
/*  312:     */       int j;
/*  313: 770 */       if ((j = localMatchResult.groups()) > 1) {
/*  314: 771 */         for (int k = 1; k < j; k++)
/*  315:     */         {
/*  316: 772 */           String str = localMatchResult.group(k);
/*  317: 773 */           if ((str != null) && (str.length() > 0)) {
/*  318: 774 */             paramList.add(str);
/*  319:     */           }
/*  320:     */         }
/*  321:     */       }
/*  322: 778 */       i = localMatchResult.endOffset(0);paramInt--;
/*  323: 765 */     } while ((paramInt != 0) && (this.__matcher.contains(localPatternMatcherInput, localPattern)));
/*  324: 781 */     paramList.add(paramString2.substring(i, paramString2.length()));
/*  325:     */     
/*  326:     */ 
/*  327: 784 */     this.__lastMatch = localMatchResult;
/*  328:     */   }
/*  329:     */   
/*  330:     */   public synchronized void split(List paramList, String paramString1, String paramString2)
/*  331:     */     throws MalformedPerl5PatternException
/*  332:     */   {
/*  333: 796 */     split(paramList, paramString1, paramString2, 0);
/*  334:     */   }
/*  335:     */   
/*  336:     */   /**
/*  337:     */    * @deprecated
/*  338:     */    */
/*  339:     */   public synchronized Vector split(String paramString1, String paramString2, int paramInt)
/*  340:     */     throws MalformedPerl5PatternException
/*  341:     */   {
/*  342: 866 */     Vector localVector = new Vector(20);
/*  343: 867 */     MatchResult localMatchResult = null;
/*  344:     */     
/*  345:     */ 
/*  346:     */ 
/*  347: 871 */     Pattern localPattern = __parseMatchExpression(paramString1);
/*  348:     */     
/*  349: 873 */     PatternMatcherInput localPatternMatcherInput = new PatternMatcherInput(paramString2);
/*  350: 874 */     int i = 0;
/*  351:     */     do
/*  352:     */     {
/*  353: 877 */       localMatchResult = this.__matcher.getMatch();
/*  354:     */       
/*  355: 879 */       localVector.addElement(paramString2.substring(i, 
/*  356: 880 */         localMatchResult.beginOffset(0)));
/*  357:     */       int j;
/*  358: 881 */       if ((j = localMatchResult.groups()) > 1) {
/*  359: 882 */         for (int k = 1; k < j; k++)
/*  360:     */         {
/*  361: 883 */           String str = localMatchResult.group(k);
/*  362: 884 */           if ((str != null) && (str.length() > 0)) {
/*  363: 885 */             localVector.addElement(str);
/*  364:     */           }
/*  365:     */         }
/*  366:     */       }
/*  367: 889 */       i = localMatchResult.endOffset(0);paramInt--;
/*  368: 876 */     } while ((paramInt != 0) && (this.__matcher.contains(localPatternMatcherInput, localPattern)));
/*  369: 892 */     localVector.addElement(paramString2.substring(i, paramString2.length()));
/*  370:     */     
/*  371:     */ 
/*  372: 895 */     this.__lastMatch = localMatchResult;
/*  373:     */     
/*  374: 897 */     return localVector;
/*  375:     */   }
/*  376:     */   
/*  377:     */   /**
/*  378:     */    * @deprecated
/*  379:     */    */
/*  380:     */   public synchronized Vector split(String paramString1, String paramString2)
/*  381:     */     throws MalformedPerl5PatternException
/*  382:     */   {
/*  383: 911 */     return split(paramString1, paramString2, 0);
/*  384:     */   }
/*  385:     */   
/*  386:     */   public synchronized Vector split(String paramString)
/*  387:     */     throws MalformedPerl5PatternException
/*  388:     */   {
/*  389: 924 */     return split("/\\s+/", paramString);
/*  390:     */   }
/*  391:     */   
/*  392:     */   public synchronized int length()
/*  393:     */   {
/*  394: 937 */     return this.__lastMatch.length();
/*  395:     */   }
/*  396:     */   
/*  397:     */   public synchronized int groups()
/*  398:     */   {
/*  399: 947 */     return this.__lastMatch.groups();
/*  400:     */   }
/*  401:     */   
/*  402:     */   public synchronized String group(int paramInt)
/*  403:     */   {
/*  404: 963 */     return this.__lastMatch.group(paramInt);
/*  405:     */   }
/*  406:     */   
/*  407:     */   public synchronized int begin(int paramInt)
/*  408:     */   {
/*  409: 979 */     return this.__lastMatch.begin(paramInt);
/*  410:     */   }
/*  411:     */   
/*  412:     */   public synchronized int end(int paramInt)
/*  413:     */   {
/*  414: 994 */     return this.__lastMatch.end(paramInt);
/*  415:     */   }
/*  416:     */   
/*  417:     */   public synchronized int beginOffset(int paramInt)
/*  418:     */   {
/*  419:1009 */     return this.__lastMatch.beginOffset(paramInt);
/*  420:     */   }
/*  421:     */   
/*  422:     */   public synchronized int endOffset(int paramInt)
/*  423:     */   {
/*  424:1024 */     return this.__lastMatch.endOffset(paramInt);
/*  425:     */   }
/*  426:     */   
/*  427:     */   public synchronized String toString()
/*  428:     */   {
/*  429:1033 */     return this.__lastMatch.toString();
/*  430:     */   }
/*  431:     */   
/*  432:     */   public synchronized String preMatch()
/*  433:     */   {
/*  434:1045 */     if (this.__originalInput == null) {
/*  435:1046 */       return "";
/*  436:     */     }
/*  437:1048 */     int i = this.__lastMatch.beginOffset(0);
/*  438:1050 */     if (i <= 0) {
/*  439:1051 */       return "";
/*  440:     */     }
/*  441:     */     Object localObject;
/*  442:1053 */     if ((this.__originalInput instanceof char[]))
/*  443:     */     {
/*  444:1056 */       localObject = (char[])this.__originalInput;
/*  445:1060 */       if (i > localObject.length) {
/*  446:1061 */         i = localObject.length;
/*  447:     */       }
/*  448:1063 */       return new String((char[])localObject, this.__inputBeginOffset, i);
/*  449:     */     }
/*  450:1064 */     if ((this.__originalInput instanceof String))
/*  451:     */     {
/*  452:1067 */       localObject = (String)this.__originalInput;
/*  453:1071 */       if (i > ((String)localObject).length()) {
/*  454:1072 */         i = ((String)localObject).length();
/*  455:     */       }
/*  456:1074 */       return ((String)localObject).substring(this.__inputBeginOffset, i);
/*  457:     */     }
/*  458:1077 */     return "";
/*  459:     */   }
/*  460:     */   
/*  461:     */   public synchronized String postMatch()
/*  462:     */   {
/*  463:1089 */     if (this.__originalInput == null) {
/*  464:1090 */       return "";
/*  465:     */     }
/*  466:1092 */     int i = this.__lastMatch.endOffset(0);
/*  467:1094 */     if (i < 0) {
/*  468:1095 */       return "";
/*  469:     */     }
/*  470:     */     Object localObject;
/*  471:1097 */     if ((this.__originalInput instanceof char[]))
/*  472:     */     {
/*  473:1100 */       localObject = (char[])this.__originalInput;
/*  474:1103 */       if (i >= localObject.length) {
/*  475:1104 */         return "";
/*  476:     */       }
/*  477:1106 */       return new String((char[])localObject, i, this.__inputEndOffset - i);
/*  478:     */     }
/*  479:1107 */     if ((this.__originalInput instanceof String))
/*  480:     */     {
/*  481:1110 */       localObject = (String)this.__originalInput;
/*  482:1114 */       if (i >= ((String)localObject).length()) {
/*  483:1115 */         return "";
/*  484:     */       }
/*  485:1117 */       return ((String)localObject).substring(i, this.__inputEndOffset);
/*  486:     */     }
/*  487:1120 */     return "";
/*  488:     */   }
/*  489:     */   
/*  490:     */   public synchronized char[] preMatchCharArray()
/*  491:     */   {
/*  492:1135 */     char[] arrayOfChar = null;
/*  493:1137 */     if (this.__originalInput == null) {
/*  494:1138 */       return null;
/*  495:     */     }
/*  496:1140 */     int i = this.__lastMatch.beginOffset(0);
/*  497:1142 */     if (i <= 0) {
/*  498:1143 */       return null;
/*  499:     */     }
/*  500:     */     Object localObject;
/*  501:1145 */     if ((this.__originalInput instanceof char[]))
/*  502:     */     {
/*  503:1148 */       localObject = (char[])this.__originalInput;
/*  504:1152 */       if (i >= localObject.length) {
/*  505:1153 */         i = localObject.length;
/*  506:     */       }
/*  507:1155 */       arrayOfChar = new char[i - this.__inputBeginOffset];
/*  508:1156 */       System.arraycopy(localObject, this.__inputBeginOffset, arrayOfChar, 0, arrayOfChar.length);
/*  509:     */     }
/*  510:1157 */     else if ((this.__originalInput instanceof String))
/*  511:     */     {
/*  512:1160 */       localObject = (String)this.__originalInput;
/*  513:1164 */       if (i >= ((String)localObject).length()) {
/*  514:1165 */         i = ((String)localObject).length();
/*  515:     */       }
/*  516:1167 */       arrayOfChar = new char[i - this.__inputBeginOffset];
/*  517:1168 */       ((String)localObject).getChars(this.__inputBeginOffset, i, arrayOfChar, 0);
/*  518:     */     }
/*  519:1171 */     return arrayOfChar;
/*  520:     */   }
/*  521:     */   
/*  522:     */   public synchronized char[] postMatchCharArray()
/*  523:     */   {
/*  524:1186 */     char[] arrayOfChar1 = null;
/*  525:1188 */     if (this.__originalInput == null) {
/*  526:1189 */       return null;
/*  527:     */     }
/*  528:1191 */     int i = this.__lastMatch.endOffset(0);
/*  529:1193 */     if (i < 0) {
/*  530:1194 */       return null;
/*  531:     */     }
/*  532:1196 */     if ((this.__originalInput instanceof char[]))
/*  533:     */     {
/*  534:1200 */       char[] arrayOfChar2 = (char[])this.__originalInput;
/*  535:1203 */       if (i >= arrayOfChar2.length) {
/*  536:1204 */         return null;
/*  537:     */       }
/*  538:1206 */       int j = this.__inputEndOffset - i;
/*  539:1207 */       arrayOfChar1 = new char[j];
/*  540:1208 */       System.arraycopy(arrayOfChar2, i, arrayOfChar1, 0, j);
/*  541:     */     }
/*  542:1209 */     else if ((this.__originalInput instanceof String))
/*  543:     */     {
/*  544:1212 */       String str = (String)this.__originalInput;
/*  545:1216 */       if (i >= this.__inputEndOffset) {
/*  546:1217 */         return null;
/*  547:     */       }
/*  548:1219 */       arrayOfChar1 = new char[this.__inputEndOffset - i];
/*  549:1220 */       str.getChars(i, this.__inputEndOffset, arrayOfChar1, 0);
/*  550:     */     }
/*  551:1223 */     return arrayOfChar1;
/*  552:     */   }
/*  553:     */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.perl.Perl5Util
 * JD-Core Version:    0.7.0.1
 */
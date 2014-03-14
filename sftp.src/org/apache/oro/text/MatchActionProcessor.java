/*   1:    */ package org.apache.oro.text;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.InputStream;
/*   6:    */ import java.io.InputStreamReader;
/*   7:    */ import java.io.LineNumberReader;
/*   8:    */ import java.io.OutputStream;
/*   9:    */ import java.io.PrintWriter;
/*  10:    */ import java.util.Vector;
/*  11:    */ import org.apache.oro.text.regex.MalformedPatternException;
/*  12:    */ import org.apache.oro.text.regex.Pattern;
/*  13:    */ import org.apache.oro.text.regex.PatternCompiler;
/*  14:    */ import org.apache.oro.text.regex.PatternMatcher;
/*  15:    */ import org.apache.oro.text.regex.Perl5Compiler;
/*  16:    */ import org.apache.oro.text.regex.Perl5Matcher;
/*  17:    */ import org.apache.oro.text.regex.Util;
/*  18:    */ 
/*  19:    */ public final class MatchActionProcessor
/*  20:    */ {
/*  21:142 */   private Pattern __fieldSeparator = null;
/*  22:    */   private PatternCompiler __compiler;
/*  23:    */   private PatternMatcher __matcher;
/*  24:146 */   private Vector __patterns = new Vector();
/*  25:147 */   private Vector __actions = new Vector();
/*  26:149 */   private MatchAction __defaultAction = new DefaultMatchAction();
/*  27:    */   
/*  28:    */   public MatchActionProcessor(PatternCompiler paramPatternCompiler, PatternMatcher paramPatternMatcher)
/*  29:    */   {
/*  30:164 */     this.__compiler = paramPatternCompiler;
/*  31:165 */     this.__matcher = paramPatternMatcher;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public MatchActionProcessor()
/*  35:    */   {
/*  36:175 */     this(new Perl5Compiler(), new Perl5Matcher());
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void addAction(String paramString, int paramInt, MatchAction paramMatchAction)
/*  40:    */     throws MalformedPatternException
/*  41:    */   {
/*  42:192 */     if (paramString != null) {
/*  43:193 */       this.__patterns.addElement(this.__compiler.compile(paramString, paramInt));
/*  44:    */     } else {
/*  45:195 */       this.__patterns.addElement(null);
/*  46:    */     }
/*  47:196 */     this.__actions.addElement(paramMatchAction);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void addAction(String paramString, int paramInt)
/*  51:    */     throws MalformedPatternException
/*  52:    */   {
/*  53:212 */     addAction(paramString, paramInt, this.__defaultAction);
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void addAction(String paramString)
/*  57:    */     throws MalformedPatternException
/*  58:    */   {
/*  59:224 */     addAction(paramString, 0);
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void addAction(String paramString, MatchAction paramMatchAction)
/*  63:    */     throws MalformedPatternException
/*  64:    */   {
/*  65:239 */     addAction(paramString, 0, paramMatchAction);
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setFieldSeparator(String paramString, int paramInt)
/*  69:    */     throws MalformedPatternException
/*  70:    */   {
/*  71:254 */     if (paramString == null)
/*  72:    */     {
/*  73:255 */       this.__fieldSeparator = null;
/*  74:256 */       return;
/*  75:    */     }
/*  76:258 */     this.__fieldSeparator = this.__compiler.compile(paramString, paramInt);
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setFieldSeparator(String paramString)
/*  80:    */     throws MalformedPatternException
/*  81:    */   {
/*  82:273 */     setFieldSeparator(paramString, 0);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void processMatches(InputStream paramInputStream, OutputStream paramOutputStream)
/*  86:    */     throws IOException
/*  87:    */   {
/*  88:304 */     LineNumberReader localLineNumberReader = 
/*  89:305 */       new LineNumberReader(new InputStreamReader(paramInputStream));
/*  90:306 */     PrintWriter localPrintWriter = new PrintWriter(paramOutputStream);
/*  91:307 */     MatchActionInfo localMatchActionInfo = new MatchActionInfo();
/*  92:    */     
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97:313 */     localMatchActionInfo.matcher = this.__matcher;
/*  98:314 */     localMatchActionInfo.fieldSeparator = this.__fieldSeparator;
/*  99:315 */     localMatchActionInfo.input = localLineNumberReader;
/* 100:316 */     localMatchActionInfo.output = localPrintWriter;
/* 101:317 */     localMatchActionInfo.fields = null;
/* 102:318 */     int i = this.__patterns.size();
/* 103:    */     
/* 104:320 */     localMatchActionInfo.lineNumber = 0;
/* 105:    */     int j;
/* 106:322 */     for (; (localMatchActionInfo.line = localLineNumberReader.readLine()) != null; j < i)
/* 107:    */     {
/* 108:323 */       localMatchActionInfo.charLine = localMatchActionInfo.line.toCharArray();
/* 109:324 */       j = 0; continue;
/* 110:325 */       Object localObject = this.__patterns.elementAt(j);
/* 111:    */       MatchAction localMatchAction;
/* 112:327 */       if (localObject != null)
/* 113:    */       {
/* 114:328 */         Pattern localPattern = (Pattern)this.__patterns.elementAt(j);
/* 115:329 */         if (this.__matcher.contains(localMatchActionInfo.charLine, localPattern))
/* 116:    */         {
/* 117:330 */           localMatchActionInfo.match = this.__matcher.getMatch();
/* 118:331 */           localMatchActionInfo.lineNumber = localLineNumberReader.getLineNumber();
/* 119:332 */           if (this.__fieldSeparator != null) {
/* 120:333 */             localMatchActionInfo.fields = Util.split(this.__matcher, this.__fieldSeparator, localMatchActionInfo.line);
/* 121:    */           }
/* 122:334 */           localMatchAction = (MatchAction)this.__actions.elementAt(j);
/* 123:335 */           localMatchAction.processMatch(localMatchActionInfo);
/* 124:    */         }
/* 125:    */       }
/* 126:    */       else
/* 127:    */       {
/* 128:338 */         localMatchActionInfo.match = null;
/* 129:339 */         localMatchActionInfo.lineNumber = localLineNumberReader.getLineNumber();
/* 130:340 */         if (this.__fieldSeparator != null) {
/* 131:341 */           localMatchActionInfo.fields = Util.split(this.__matcher, this.__fieldSeparator, localMatchActionInfo.line);
/* 132:    */         }
/* 133:342 */         localMatchAction = (MatchAction)this.__actions.elementAt(j);
/* 134:343 */         localMatchAction.processMatch(localMatchActionInfo);
/* 135:    */       }
/* 136:324 */       j++;
/* 137:    */     }
/* 138:349 */     localPrintWriter.flush();
/* 139:350 */     localLineNumberReader.close();
/* 140:    */   }
/* 141:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.MatchActionProcessor
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.BitSet;
/*   5:    */ import java.util.Hashtable;
/*   6:    */ import java.util.Vector;
/*   7:    */ import org.apache.oro.text.regex.Pattern;
/*   8:    */ 
/*   9:    */ public final class AwkPattern
/*  10:    */   implements Pattern, Serializable
/*  11:    */ {
/*  12:103 */   boolean _hasEndAnchor = false;
/*  13:103 */   boolean _hasBeginAnchor = false;
/*  14:    */   boolean[] _fastMap;
/*  15:    */   boolean _matchesNullString;
/*  16:    */   Hashtable _stateMap;
/*  17:    */   BitSet _endStates;
/*  18:    */   BitSet[] _followSet;
/*  19:    */   BitSet _emptySet;
/*  20:    */   BitSet _U;
/*  21:    */   Vector _stateList;
/*  22:    */   Vector[] _nodeList;
/*  23:    */   Vector _Dtrans;
/*  24:    */   String _expression;
/*  25:    */   int _options;
/*  26:    */   int _endPosition;
/*  27:    */   int _numStates;
/*  28:    */   static final int _START_STATE = 1;
/*  29:    */   static final int _INVALID_STATE = -1;
/*  30:    */   
/*  31:    */   AwkPattern(String paramString, SyntaxTree paramSyntaxTree)
/*  32:    */   {
/*  33:109 */     this._expression = paramString;
/*  34:    */     
/*  35:    */ 
/*  36:112 */     this._endPosition = (paramSyntaxTree._positions - 1);
/*  37:113 */     this._followSet = paramSyntaxTree._followSet;
/*  38:    */     
/*  39:115 */     this._Dtrans = new Vector();
/*  40:116 */     this._stateList = new Vector();
/*  41:117 */     this._endStates = new BitSet();
/*  42:    */     
/*  43:119 */     this._U = new BitSet(paramSyntaxTree._positions);
/*  44:120 */     this._U.or(paramSyntaxTree._root._firstPosition());
/*  45:    */     
/*  46:122 */     int[] arrayOfInt = new int[256];
/*  47:123 */     this._Dtrans.addElement(arrayOfInt);
/*  48:    */     
/*  49:125 */     this._Dtrans.addElement(arrayOfInt);
/*  50:    */     
/*  51:127 */     this._numStates = 1;
/*  52:128 */     if (this._U.get(this._endPosition)) {
/*  53:129 */       this._endStates.set(this._numStates);
/*  54:    */     }
/*  55:130 */     DFAState localDFAState = new DFAState((BitSet)this._U.clone(), this._numStates);
/*  56:131 */     this._stateMap = new Hashtable();
/*  57:132 */     this._stateMap.put(localDFAState._state, localDFAState);
/*  58:133 */     this._stateList.addElement(localDFAState);
/*  59:    */     
/*  60:135 */     this._stateList.addElement(localDFAState);
/*  61:136 */     this._numStates += 1;
/*  62:    */     
/*  63:138 */     this._U.xor(this._U);
/*  64:139 */     this._emptySet = new BitSet(paramSyntaxTree._positions);
/*  65:    */     
/*  66:141 */     this._nodeList = new Vector[256];
/*  67:142 */     for (int i = 0; i < 256; i++)
/*  68:    */     {
/*  69:143 */       this._nodeList[i] = new Vector();
/*  70:144 */       for (int j = 0; j < paramSyntaxTree._positions; j++) {
/*  71:145 */         if (paramSyntaxTree._nodes[j]._matches((char)i)) {
/*  72:146 */           this._nodeList[i].addElement(paramSyntaxTree._nodes[j]);
/*  73:    */         }
/*  74:    */       }
/*  75:    */     }
/*  76:149 */     this._fastMap = paramSyntaxTree.createFastMap();
/*  77:150 */     this._matchesNullString = this._endStates.get(1);
/*  78:    */   }
/*  79:    */   
/*  80:    */   void _createNewState(int paramInt1, int paramInt2, int[] paramArrayOfInt)
/*  81:    */   {
/*  82:158 */     DFAState localDFAState1 = (DFAState)this._stateList.elementAt(paramInt1);
/*  83:159 */     int i = this._nodeList[paramInt2].size();
/*  84:160 */     this._U.xor(this._U);
/*  85:161 */     while (i-- > 0)
/*  86:    */     {
/*  87:162 */       int j = ((LeafNode)this._nodeList[paramInt2].elementAt(i))._position;
/*  88:163 */       if (localDFAState1._state.get(j)) {
/*  89:164 */         this._U.or(this._followSet[j]);
/*  90:    */       }
/*  91:    */     }
/*  92:167 */     if (!this._stateMap.containsKey(this._U))
/*  93:    */     {
/*  94:168 */       DFAState localDFAState2 = new DFAState((BitSet)this._U.clone(), this._numStates++);
/*  95:169 */       this._stateList.addElement(localDFAState2);
/*  96:170 */       this._stateMap.put(localDFAState2._state, localDFAState2);
/*  97:171 */       this._Dtrans.addElement(new int[256]);
/*  98:173 */       if (!this._U.equals(this._emptySet))
/*  99:    */       {
/* 100:174 */         paramArrayOfInt[paramInt2] = (this._numStates - 1);
/* 101:176 */         if (this._U.get(this._endPosition)) {
/* 102:177 */           this._endStates.set(this._numStates - 1);
/* 103:    */         }
/* 104:    */       }
/* 105:    */       else
/* 106:    */       {
/* 107:179 */         paramArrayOfInt[paramInt2] = -1;
/* 108:    */       }
/* 109:    */     }
/* 110:181 */     else if (this._U.equals(this._emptySet))
/* 111:    */     {
/* 112:182 */       paramArrayOfInt[paramInt2] = -1;
/* 113:    */     }
/* 114:    */     else
/* 115:    */     {
/* 116:184 */       paramArrayOfInt[paramInt2] = ((DFAState)this._stateMap.get(this._U))._stateNumber;
/* 117:    */     }
/* 118:    */   }
/* 119:    */   
/* 120:    */   int[] _getStateArray(int paramInt)
/* 121:    */   {
/* 122:188 */     return (int[])this._Dtrans.elementAt(paramInt);
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getPattern()
/* 126:    */   {
/* 127:197 */     return this._expression;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public int getOptions()
/* 131:    */   {
/* 132:206 */     return this._options;
/* 133:    */   }
/* 134:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.AwkPattern
 * JD-Core Version:    0.7.0.1
 */
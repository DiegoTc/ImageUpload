/*   1:    */ package org.apache.oro.text.awk;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.io.Reader;
/*   5:    */ 
/*   6:    */ public final class AwkStreamInput
/*   7:    */ {
/*   8:    */   static final int _DEFAULT_BUFFER_INCREMENT = 2048;
/*   9:    */   private Reader __searchStream;
/*  10:    */   private int __bufferIncrementUnit;
/*  11:    */   boolean _endOfStreamReached;
/*  12:    */   int _bufferSize;
/*  13:    */   int _bufferOffset;
/*  14:    */   int _currentOffset;
/*  15:    */   char[] _buffer;
/*  16:    */   
/*  17:    */   AwkStreamInput()
/*  18:    */   {
/*  19:106 */     this._currentOffset = 0;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public AwkStreamInput(Reader paramReader, int paramInt)
/*  23:    */   {
/*  24:121 */     this.__searchStream = paramReader;
/*  25:122 */     this.__bufferIncrementUnit = paramInt;
/*  26:123 */     this._buffer = new char[paramInt];
/*  27:124 */     this._bufferOffset = (this._bufferSize = this._currentOffset = 0);
/*  28:125 */     this._endOfStreamReached = false;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public AwkStreamInput(Reader paramReader)
/*  32:    */   {
/*  33:137 */     this(paramReader, 2048);
/*  34:    */   }
/*  35:    */   
/*  36:    */   int _reallocate(int paramInt)
/*  37:    */     throws IOException
/*  38:    */   {
/*  39:145 */     if (this._endOfStreamReached) {
/*  40:146 */       return this._bufferSize;
/*  41:    */     }
/*  42:148 */     int i = this._bufferSize - paramInt;
/*  43:149 */     char[] arrayOfChar = new char[i + this.__bufferIncrementUnit];
/*  44:    */     
/*  45:151 */     int j = 
/*  46:152 */       this.__searchStream.read(arrayOfChar, i, this.__bufferIncrementUnit);
/*  47:154 */     if (j <= 0)
/*  48:    */     {
/*  49:155 */       this._endOfStreamReached = true;
/*  50:160 */       if (j == 0) {
/*  51:161 */         throw new IOException("read from input stream returned 0 bytes.");
/*  52:    */       }
/*  53:162 */       return this._bufferSize;
/*  54:    */     }
/*  55:164 */     this._bufferOffset += paramInt;
/*  56:165 */     this._bufferSize = (i + j);
/*  57:    */     
/*  58:167 */     System.arraycopy(this._buffer, paramInt, arrayOfChar, 0, i);
/*  59:168 */     this._buffer = arrayOfChar;
/*  60:    */     
/*  61:    */ 
/*  62:171 */     return i;
/*  63:    */   }
/*  64:    */   
/*  65:    */   boolean read()
/*  66:    */     throws IOException
/*  67:    */   {
/*  68:175 */     this._bufferOffset += this._bufferSize;
/*  69:176 */     this._bufferSize = this.__searchStream.read(this._buffer);
/*  70:177 */     this._endOfStreamReached = (this._bufferSize == -1);
/*  71:178 */     return this._endOfStreamReached ^ true;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public boolean endOfStream()
/*  75:    */   {
/*  76:181 */     return this._endOfStreamReached;
/*  77:    */   }
/*  78:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.AwkStreamInput
 * JD-Core Version:    0.7.0.1
 */
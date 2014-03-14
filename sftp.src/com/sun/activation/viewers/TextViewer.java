/*  1:   */ package com.sun.activation.viewers;
/*  2:   */ 
/*  3:   */ import java.awt.Container;
/*  4:   */ import java.awt.Dimension;
/*  5:   */ import java.awt.GridLayout;
/*  6:   */ import java.awt.Panel;
/*  7:   */ import java.awt.TextArea;
/*  8:   */ import java.awt.TextComponent;
/*  9:   */ import java.io.ByteArrayOutputStream;
/* 10:   */ import java.io.File;
/* 11:   */ import java.io.IOException;
/* 12:   */ import java.io.InputStream;
/* 13:   */ import javax.activation.CommandObject;
/* 14:   */ import javax.activation.DataHandler;
/* 15:   */ 
/* 16:   */ public class TextViewer
/* 17:   */   extends Panel
/* 18:   */   implements CommandObject
/* 19:   */ {
/* 20:   */   private TextArea text_area;
/* 21:   */   private File text_file;
/* 22:   */   private String text_buffer;
/* 23:   */   private DataHandler _dh;
/* 24:39 */   private boolean DEBUG = false;
/* 25:   */   
/* 26:   */   public TextViewer()
/* 27:   */   {
/* 28:44 */     setLayout(new GridLayout(1, 1));
/* 29:   */     
/* 30:46 */     this.text_area = new TextArea("", 24, 80, 
/* 31:47 */       1);
/* 32:48 */     this.text_area.setEditable(false);
/* 33:   */     
/* 34:50 */     add(this.text_area);
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setCommandContext(String paramString, DataHandler paramDataHandler)
/* 38:   */     throws IOException
/* 39:   */   {
/* 40:55 */     this._dh = paramDataHandler;
/* 41:56 */     setInputStream(this._dh.getInputStream());
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setInputStream(InputStream paramInputStream)
/* 45:   */     throws IOException
/* 46:   */   {
/* 47:66 */     int i = 0;
/* 48:   */     
/* 49:68 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 50:69 */     byte[] arrayOfByte = new byte[1024];
/* 51:71 */     while ((i = paramInputStream.read(arrayOfByte)) > 0) {
/* 52:72 */       localByteArrayOutputStream.write(arrayOfByte, 0, i);
/* 53:   */     }
/* 54:74 */     paramInputStream.close();
/* 55:   */     
/* 56:   */ 
/* 57:   */ 
/* 58:78 */     this.text_buffer = localByteArrayOutputStream.toString();
/* 59:   */     
/* 60:   */ 
/* 61:81 */     this.text_area.setText(this.text_buffer);
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void addNotify()
/* 65:   */   {
/* 66:86 */     super.addNotify();
/* 67:87 */     invalidate();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public Dimension getPreferredSize()
/* 71:   */   {
/* 72:91 */     return this.text_area.getMinimumSize(24, 80);
/* 73:   */   }
/* 74:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.viewers.TextViewer
 * JD-Core Version:    0.7.0.1
 */
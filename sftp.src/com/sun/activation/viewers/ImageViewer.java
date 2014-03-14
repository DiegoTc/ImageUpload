/*   1:    */ package com.sun.activation.viewers;
/*   2:    */ 
/*   3:    */ import java.awt.Component;
/*   4:    */ import java.awt.Container;
/*   5:    */ import java.awt.Dimension;
/*   6:    */ import java.awt.Image;
/*   7:    */ import java.awt.MediaTracker;
/*   8:    */ import java.awt.Panel;
/*   9:    */ import java.awt.Toolkit;
/*  10:    */ import java.io.ByteArrayOutputStream;
/*  11:    */ import java.io.IOException;
/*  12:    */ import java.io.InputStream;
/*  13:    */ import java.io.PrintStream;
/*  14:    */ import javax.activation.CommandObject;
/*  15:    */ import javax.activation.DataHandler;
/*  16:    */ 
/*  17:    */ public class ImageViewer
/*  18:    */   extends Panel
/*  19:    */   implements CommandObject
/*  20:    */ {
/*  21:    */   private ImageViewerCanvas canvas;
/*  22:    */   private Image image;
/*  23:    */   private DataHandler _dh;
/*  24: 39 */   private boolean DEBUG = false;
/*  25:    */   
/*  26:    */   public ImageViewer()
/*  27:    */   {
/*  28: 46 */     this.canvas = new ImageViewerCanvas();
/*  29: 47 */     add(this.canvas);
/*  30:    */   }
/*  31:    */   
/*  32:    */   public void setCommandContext(String paramString, DataHandler paramDataHandler)
/*  33:    */     throws IOException
/*  34:    */   {
/*  35: 54 */     this._dh = paramDataHandler;
/*  36: 55 */     setInputStream(this._dh.getInputStream());
/*  37:    */   }
/*  38:    */   
/*  39:    */   private void setInputStream(InputStream paramInputStream)
/*  40:    */     throws IOException
/*  41:    */   {
/*  42: 64 */     MediaTracker localMediaTracker = new MediaTracker(this);
/*  43: 65 */     int i = 0;
/*  44: 66 */     byte[] arrayOfByte = new byte[1024];
/*  45: 67 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/*  46: 69 */     while ((i = paramInputStream.read(arrayOfByte)) > 0) {
/*  47: 70 */       localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*  48:    */     }
/*  49: 71 */     paramInputStream.close();
/*  50:    */     
/*  51:    */ 
/*  52: 74 */     this.image = getToolkit().createImage(localByteArrayOutputStream.toByteArray());
/*  53:    */     
/*  54: 76 */     localMediaTracker.addImage(this.image, 0);
/*  55:    */     try
/*  56:    */     {
/*  57: 79 */       localMediaTracker.waitForID(0);
/*  58: 80 */       localMediaTracker.waitForAll();
/*  59: 81 */       if (localMediaTracker.statusID(0, true) != 8) {
/*  60: 82 */         System.out.println("Error occured in image loading = " + 
/*  61: 83 */           localMediaTracker.getErrorsID(0));
/*  62:    */       }
/*  63:    */     }
/*  64:    */     catch (InterruptedException localInterruptedException)
/*  65:    */     {
/*  66: 89 */       throw new IOException("Error reading image data");
/*  67:    */     }
/*  68: 92 */     this.canvas.setImage(this.image);
/*  69: 93 */     if (this.DEBUG) {
/*  70: 94 */       System.out.println("calling invalidate");
/*  71:    */     }
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void addNotify()
/*  75:    */   {
/*  76: 99 */     super.addNotify();
/*  77:100 */     invalidate();
/*  78:101 */     validate();
/*  79:102 */     doLayout();
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Dimension getPreferredSize()
/*  83:    */   {
/*  84:106 */     return this.canvas.getPreferredSize();
/*  85:    */   }
/*  86:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.viewers.ImageViewer
 * JD-Core Version:    0.7.0.1
 */
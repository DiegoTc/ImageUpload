/*  1:   */ package com.sun.activation.viewers;
/*  2:   */ 
/*  3:   */ import java.awt.Canvas;
/*  4:   */ import java.awt.Component;
/*  5:   */ import java.awt.Dimension;
/*  6:   */ import java.awt.Graphics;
/*  7:   */ import java.awt.Image;
/*  8:   */ 
/*  9:   */ public class ImageViewerCanvas
/* 10:   */   extends Canvas
/* 11:   */ {
/* 12:   */   private Image canvas_image;
/* 13:   */   
/* 14:   */   public void setImage(Image paramImage)
/* 15:   */   {
/* 16:44 */     this.canvas_image = paramImage;
/* 17:45 */     invalidate();
/* 18:46 */     repaint();
/* 19:   */   }
/* 20:   */   
/* 21:   */   public Dimension getPreferredSize()
/* 22:   */   {
/* 23:54 */     Dimension localDimension = null;
/* 24:56 */     if (this.canvas_image == null) {
/* 25:58 */       localDimension = new Dimension(200, 200);
/* 26:   */     } else {
/* 27:61 */       localDimension = new Dimension(this.canvas_image.getWidth(this), 
/* 28:62 */         this.canvas_image.getHeight(this));
/* 29:   */     }
/* 30:64 */     return localDimension;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void paint(Graphics paramGraphics)
/* 34:   */   {
/* 35:72 */     if (this.canvas_image != null) {
/* 36:73 */       paramGraphics.drawImage(this.canvas_image, 0, 0, this);
/* 37:   */     }
/* 38:   */   }
/* 39:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.viewers.ImageViewerCanvas
 * JD-Core Version:    0.7.0.1
 */
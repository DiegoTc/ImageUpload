/*   1:    */ package com.sun.activation.viewers;
/*   2:    */ 
/*   3:    */ import java.awt.Button;
/*   4:    */ import java.awt.Component;
/*   5:    */ import java.awt.Container;
/*   6:    */ import java.awt.Dimension;
/*   7:    */ import java.awt.FlowLayout;
/*   8:    */ import java.awt.GridBagConstraints;
/*   9:    */ import java.awt.GridBagLayout;
/*  10:    */ import java.awt.Panel;
/*  11:    */ import java.awt.TextArea;
/*  12:    */ import java.awt.TextComponent;
/*  13:    */ import java.awt.event.ActionEvent;
/*  14:    */ import java.awt.event.ActionListener;
/*  15:    */ import java.io.ByteArrayOutputStream;
/*  16:    */ import java.io.File;
/*  17:    */ import java.io.FileInputStream;
/*  18:    */ import java.io.IOException;
/*  19:    */ import java.io.InputStream;
/*  20:    */ import java.io.OutputStream;
/*  21:    */ import java.io.PrintStream;
/*  22:    */ import java.util.EventObject;
/*  23:    */ import javax.activation.CommandObject;
/*  24:    */ import javax.activation.DataHandler;
/*  25:    */ 
/*  26:    */ public class TextEditor
/*  27:    */   extends Panel
/*  28:    */   implements CommandObject, ActionListener
/*  29:    */ {
/*  30:    */   private TextArea text_area;
/*  31:    */   private GridBagLayout panel_gb;
/*  32:    */   private Panel button_panel;
/*  33:    */   private Button save_button;
/*  34:    */   private File text_file;
/*  35:    */   private String text_buffer;
/*  36:    */   private InputStream data_ins;
/*  37:    */   private FileInputStream fis;
/*  38:    */   private DataHandler _dh;
/*  39: 45 */   private boolean DEBUG = false;
/*  40:    */   
/*  41:    */   public TextEditor()
/*  42:    */   {
/*  43: 50 */     this.panel_gb = new GridBagLayout();
/*  44: 51 */     setLayout(this.panel_gb);
/*  45:    */     
/*  46: 53 */     this.button_panel = new Panel();
/*  47:    */     
/*  48: 55 */     this.button_panel.setLayout(new FlowLayout());
/*  49: 56 */     this.save_button = new Button("SAVE");
/*  50: 57 */     this.button_panel.add(this.save_button);
/*  51: 58 */     addGridComponent(this, 
/*  52: 59 */       this.button_panel, 
/*  53: 60 */       this.panel_gb, 
/*  54: 61 */       0, 0, 
/*  55: 62 */       1, 1, 
/*  56: 63 */       1, 0);
/*  57:    */     
/*  58:    */ 
/*  59: 66 */     this.text_area = new TextArea("This is text", 24, 80, 
/*  60: 67 */       1);
/*  61:    */     
/*  62: 69 */     this.text_area.setEditable(true);
/*  63:    */     
/*  64: 71 */     addGridComponent(this, 
/*  65: 72 */       this.text_area, 
/*  66: 73 */       this.panel_gb, 
/*  67: 74 */       0, 1, 
/*  68: 75 */       1, 2, 
/*  69: 76 */       1, 1);
/*  70:    */     
/*  71:    */ 
/*  72: 79 */     this.save_button.addActionListener(this);
/*  73:    */   }
/*  74:    */   
/*  75:    */   private void addGridComponent(Container paramContainer, Component paramComponent, GridBagLayout paramGridBagLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
/*  76:    */   {
/*  77: 96 */     GridBagConstraints localGridBagConstraints = new GridBagConstraints();
/*  78: 97 */     localGridBagConstraints.gridx = paramInt1;
/*  79: 98 */     localGridBagConstraints.gridy = paramInt2;
/*  80: 99 */     localGridBagConstraints.gridwidth = paramInt3;
/*  81:100 */     localGridBagConstraints.gridheight = paramInt4;
/*  82:101 */     localGridBagConstraints.fill = 1;
/*  83:102 */     localGridBagConstraints.weighty = paramInt6;
/*  84:103 */     localGridBagConstraints.weightx = paramInt5;
/*  85:104 */     localGridBagConstraints.anchor = 10;
/*  86:105 */     paramGridBagLayout.setConstraints(paramComponent, localGridBagConstraints);
/*  87:106 */     paramContainer.add(paramComponent);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setCommandContext(String paramString, DataHandler paramDataHandler)
/*  91:    */     throws IOException
/*  92:    */   {
/*  93:111 */     this._dh = paramDataHandler;
/*  94:112 */     setInputStream(this._dh.getInputStream());
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setInputStream(InputStream paramInputStream)
/*  98:    */     throws IOException
/*  99:    */   {
/* 100:123 */     byte[] arrayOfByte = new byte[1024];
/* 101:124 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 102:125 */     int i = 0;
/* 103:128 */     while ((i = paramInputStream.read(arrayOfByte)) > 0) {
/* 104:129 */       localByteArrayOutputStream.write(arrayOfByte, 0, i);
/* 105:    */     }
/* 106:130 */     paramInputStream.close();
/* 107:    */     
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:135 */     this.text_buffer = localByteArrayOutputStream.toString();
/* 112:    */     
/* 113:    */ 
/* 114:138 */     this.text_area.setText(this.text_buffer);
/* 115:    */   }
/* 116:    */   
/* 117:    */   private void performSaveOperation()
/* 118:    */   {
/* 119:142 */     OutputStream localOutputStream = null;
/* 120:    */     try
/* 121:    */     {
/* 122:144 */       localOutputStream = this._dh.getOutputStream();
/* 123:    */     }
/* 124:    */     catch (Exception localException) {}
/* 125:147 */     String str = this.text_area.getText();
/* 126:150 */     if (localOutputStream == null)
/* 127:    */     {
/* 128:151 */       System.out.println("Invalid outputstream in TextEditor!");
/* 129:152 */       System.out.println("not saving!");
/* 130:    */     }
/* 131:    */     try
/* 132:    */     {
/* 133:156 */       localOutputStream.write(str.getBytes());
/* 134:157 */       localOutputStream.flush();
/* 135:158 */       localOutputStream.close();
/* 136:    */     }
/* 137:    */     catch (IOException localIOException)
/* 138:    */     {
/* 139:161 */       System.out.println("TextEditor Save Operation failed with: " + localIOException);
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void addNotify()
/* 144:    */   {
/* 145:167 */     super.addNotify();
/* 146:168 */     invalidate();
/* 147:    */   }
/* 148:    */   
/* 149:    */   public Dimension getPreferredSize()
/* 150:    */   {
/* 151:172 */     return this.text_area.getMinimumSize(24, 80);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void actionPerformed(ActionEvent paramActionEvent)
/* 155:    */   {
/* 156:177 */     if (paramActionEvent.getSource() == this.save_button) {
/* 157:180 */       performSaveOperation();
/* 158:    */     }
/* 159:    */   }
/* 160:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.sun.activation.viewers.TextEditor
 * JD-Core Version:    0.7.0.1
 */
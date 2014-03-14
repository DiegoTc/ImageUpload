/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.awt.datatransfer.DataFlavor;
/*   4:    */ import java.awt.datatransfer.UnsupportedFlavorException;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.OutputStream;
/*   7:    */ 
/*   8:    */ class ObjectDataContentHandler
/*   9:    */   implements DataContentHandler
/*  10:    */ {
/*  11:    */   private DataFlavor[] transferFlavors;
/*  12:    */   private Object obj;
/*  13:    */   private String mimeType;
/*  14:    */   private DataContentHandler dch;
/*  15:    */   
/*  16:    */   public ObjectDataContentHandler(DataContentHandler paramDataContentHandler, Object paramObject, String paramString)
/*  17:    */   {
/*  18:791 */     this.obj = paramObject;
/*  19:792 */     this.mimeType = paramString;
/*  20:793 */     this.dch = paramDataContentHandler;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public DataContentHandler getDCH()
/*  24:    */   {
/*  25:801 */     return this.dch;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public DataFlavor[] getTransferDataFlavors()
/*  29:    */   {
/*  30:809 */     if (this.transferFlavors == null) {
/*  31:810 */       if (this.dch != null)
/*  32:    */       {
/*  33:811 */         this.transferFlavors = this.dch.getTransferDataFlavors();
/*  34:    */       }
/*  35:    */       else
/*  36:    */       {
/*  37:813 */         this.transferFlavors = new DataFlavor[1];
/*  38:814 */         this.transferFlavors[0] = new ActivationDataFlavor(this.obj.getClass(), 
/*  39:815 */           this.mimeType, this.mimeType);
/*  40:    */       }
/*  41:    */     }
/*  42:818 */     return this.transferFlavors;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Object getTransferData(DataFlavor paramDataFlavor, DataSource paramDataSource)
/*  46:    */     throws UnsupportedFlavorException, IOException
/*  47:    */   {
/*  48:830 */     if (this.dch != null) {
/*  49:831 */       return this.dch.getTransferData(paramDataFlavor, paramDataSource);
/*  50:    */     }
/*  51:832 */     if (paramDataFlavor.equals(this.transferFlavors[0])) {
/*  52:833 */       return this.obj;
/*  53:    */     }
/*  54:835 */     throw new UnsupportedFlavorException(paramDataFlavor);
/*  55:    */   }
/*  56:    */   
/*  57:    */   public Object getContent(DataSource paramDataSource)
/*  58:    */   {
/*  59:840 */     return this.obj;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void writeTo(Object paramObject, String paramString, OutputStream paramOutputStream)
/*  63:    */     throws IOException
/*  64:    */   {
/*  65:848 */     if (this.dch != null) {
/*  66:849 */       this.dch.writeTo(paramObject, paramString, paramOutputStream);
/*  67:    */     } else {
/*  68:851 */       throw new UnsupportedDataTypeException(
/*  69:852 */         "no object DCH for MIME type " + this.mimeType);
/*  70:    */     }
/*  71:    */   }
/*  72:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.ObjectDataContentHandler
 * JD-Core Version:    0.7.0.1
 */
/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.awt.datatransfer.DataFlavor;
/*   4:    */ import java.awt.datatransfer.UnsupportedFlavorException;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.io.OutputStream;
/*   7:    */ 
/*   8:    */ class DataSourceDataContentHandler
/*   9:    */   implements DataContentHandler
/*  10:    */ {
/*  11:    */   private DataSource ds;
/*  12:    */   private DataFlavor[] transferFlavors;
/*  13:    */   private DataContentHandler dch;
/*  14:    */   
/*  15:    */   public DataSourceDataContentHandler(DataContentHandler paramDataContentHandler, DataSource paramDataSource)
/*  16:    */   {
/*  17:712 */     this.ds = paramDataSource;
/*  18:713 */     this.dch = paramDataContentHandler;
/*  19:    */   }
/*  20:    */   
/*  21:    */   public DataFlavor[] getTransferDataFlavors()
/*  22:    */   {
/*  23:722 */     if (this.transferFlavors == null) {
/*  24:723 */       if (this.dch != null)
/*  25:    */       {
/*  26:724 */         this.transferFlavors = this.dch.getTransferDataFlavors();
/*  27:    */       }
/*  28:    */       else
/*  29:    */       {
/*  30:726 */         this.transferFlavors = new DataFlavor[1];
/*  31:727 */         this.transferFlavors[0] = 
/*  32:728 */           new ActivationDataFlavor(this.ds.getContentType(), 
/*  33:729 */           this.ds.getContentType());
/*  34:    */       }
/*  35:    */     }
/*  36:732 */     return this.transferFlavors;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public Object getTransferData(DataFlavor paramDataFlavor, DataSource paramDataSource)
/*  40:    */     throws UnsupportedFlavorException, IOException
/*  41:    */   {
/*  42:744 */     if (this.dch != null) {
/*  43:745 */       return this.dch.getTransferData(paramDataFlavor, paramDataSource);
/*  44:    */     }
/*  45:746 */     if (paramDataFlavor.equals(this.transferFlavors[0])) {
/*  46:747 */       return paramDataSource.getInputStream();
/*  47:    */     }
/*  48:749 */     throw new UnsupportedFlavorException(paramDataFlavor);
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Object getContent(DataSource paramDataSource)
/*  52:    */     throws IOException
/*  53:    */   {
/*  54:754 */     if (this.dch != null) {
/*  55:755 */       return this.dch.getContent(paramDataSource);
/*  56:    */     }
/*  57:757 */     return paramDataSource.getInputStream();
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void writeTo(Object paramObject, String paramString, OutputStream paramOutputStream)
/*  61:    */     throws IOException
/*  62:    */   {
/*  63:765 */     if (this.dch != null) {
/*  64:766 */       this.dch.writeTo(paramObject, paramString, paramOutputStream);
/*  65:    */     } else {
/*  66:768 */       throw new UnsupportedDataTypeException(
/*  67:769 */         "no DCH for content type " + this.ds.getContentType());
/*  68:    */     }
/*  69:    */   }
/*  70:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.DataSourceDataContentHandler
 * JD-Core Version:    0.7.0.1
 */
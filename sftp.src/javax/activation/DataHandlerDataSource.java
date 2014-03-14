/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.io.InputStream;
/*   5:    */ import java.io.OutputStream;
/*   6:    */ 
/*   7:    */ class DataHandlerDataSource
/*   8:    */   implements DataSource
/*   9:    */ {
/*  10:    */   DataHandler dataHandler;
/*  11:    */   
/*  12:    */   public DataHandlerDataSource(DataHandler paramDataHandler)
/*  13:    */   {
/*  14:660 */     this.dataHandler = paramDataHandler;
/*  15:    */   }
/*  16:    */   
/*  17:    */   public InputStream getInputStream()
/*  18:    */     throws IOException
/*  19:    */   {
/*  20:668 */     return this.dataHandler.getInputStream();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public OutputStream getOutputStream()
/*  24:    */     throws IOException
/*  25:    */   {
/*  26:676 */     return this.dataHandler.getOutputStream();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public String getContentType()
/*  30:    */   {
/*  31:684 */     return this.dataHandler.getContentType();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getName()
/*  35:    */   {
/*  36:692 */     return this.dataHandler.getName();
/*  37:    */   }
/*  38:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.DataHandlerDataSource
 * JD-Core Version:    0.7.0.1
 */
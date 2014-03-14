/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import java.io.InputStream;
/*   5:    */ import java.io.OutputStream;
/*   6:    */ import java.net.URL;
/*   7:    */ import java.net.URLConnection;
/*   8:    */ 
/*   9:    */ public class URLDataSource
/*  10:    */   implements DataSource
/*  11:    */ {
/*  12:    */   private URL url;
/*  13:    */   private URLConnection url_conn;
/*  14:    */   
/*  15:    */   public URLDataSource(URL paramURL)
/*  16:    */   {
/*  17: 52 */     this.url = paramURL;
/*  18:    */   }
/*  19:    */   
/*  20:    */   public String getContentType()
/*  21:    */   {
/*  22: 67 */     String str = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 70 */       if (this.url_conn == null) {
/*  26: 71 */         this.url_conn = this.url.openConnection();
/*  27:    */       }
/*  28:    */     }
/*  29:    */     catch (IOException localIOException) {}
/*  30: 74 */     if (this.url_conn != null) {
/*  31: 75 */       str = this.url_conn.getContentType();
/*  32:    */     }
/*  33: 77 */     if (str == null) {
/*  34: 78 */       str = "application/octet-stream";
/*  35:    */     }
/*  36: 80 */     return str;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getName()
/*  40:    */   {
/*  41: 90 */     return this.url.getFile();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public InputStream getInputStream()
/*  45:    */     throws IOException
/*  46:    */   {
/*  47:100 */     return this.url.openStream();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public OutputStream getOutputStream()
/*  51:    */     throws IOException
/*  52:    */   {
/*  53:113 */     this.url_conn = this.url.openConnection();
/*  54:115 */     if (this.url_conn != null) {
/*  55:116 */       return this.url_conn.getOutputStream();
/*  56:    */     }
/*  57:118 */     return null;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public URL getURL()
/*  61:    */   {
/*  62:127 */     return this.url;
/*  63:    */   }
/*  64:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.URLDataSource
 * JD-Core Version:    0.7.0.1
 */
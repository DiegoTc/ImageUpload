/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.FileInputStream;
/*   5:    */ import java.io.FileOutputStream;
/*   6:    */ import java.io.IOException;
/*   7:    */ import java.io.InputStream;
/*   8:    */ import java.io.OutputStream;
/*   9:    */ 
/*  10:    */ public class FileDataSource
/*  11:    */   implements DataSource
/*  12:    */ {
/*  13:    */   private File _file;
/*  14:    */   private FileTypeMap typeMap;
/*  15:    */   
/*  16:    */   public FileDataSource(File paramFile)
/*  17:    */   {
/*  18: 67 */     this._file = paramFile;
/*  19:    */   }
/*  20:    */   
/*  21:    */   public FileDataSource(String paramString)
/*  22:    */   {
/*  23: 79 */     this(new File(paramString));
/*  24:    */   }
/*  25:    */   
/*  26:    */   public InputStream getInputStream()
/*  27:    */     throws IOException
/*  28:    */   {
/*  29: 91 */     return new FileInputStream(this._file);
/*  30:    */   }
/*  31:    */   
/*  32:    */   public OutputStream getOutputStream()
/*  33:    */     throws IOException
/*  34:    */   {
/*  35:103 */     return new FileOutputStream(this._file);
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getContentType()
/*  39:    */   {
/*  40:119 */     if (this.typeMap == null) {
/*  41:120 */       return FileTypeMap.getDefaultFileTypeMap().getContentType(this._file);
/*  42:    */     }
/*  43:122 */     return this.typeMap.getContentType(this._file);
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getName()
/*  47:    */   {
/*  48:133 */     return this._file.getName();
/*  49:    */   }
/*  50:    */   
/*  51:    */   public File getFile()
/*  52:    */   {
/*  53:141 */     return this._file;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setFileTypeMap(FileTypeMap paramFileTypeMap)
/*  57:    */   {
/*  58:150 */     this.typeMap = paramFileTypeMap;
/*  59:    */   }
/*  60:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.FileDataSource
 * JD-Core Version:    0.7.0.1
 */
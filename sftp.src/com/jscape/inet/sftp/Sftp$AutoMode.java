package com.jscape.inet.sftp;

import com.jscape.inet.file.JFile;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.activation.MimetypesFileTypeMap;

final class Sftp$AutoMode
  extends Sftp.TransferMode
{
  private static final int b = 0;
  final Sftp c;
  private static final String z = -1;
  
  public Sftp$AutoMode(Sftp paramSftp)
  {
    super(paramSftp, 0);
  }
  
  public void download(JFile paramJFile1, JFile paramJFile2, long paramLong)
    throws SftpException
  {
    Sftp.TransferMode localTransferMode = a(this.fileName);
    localTransferMode.download(paramJFile1, paramJFile2, paramLong);
  }
  
  public void download(JFile paramJFile, OutputStream paramOutputStream, long paramLong)
    throws SftpException
  {
    Sftp.TransferMode localTransferMode = a(this.fileName);
    localTransferMode.download(paramJFile, paramOutputStream, paramLong);
  }
  
  public void upload(JFile paramJFile1, JFile paramJFile2, long paramLong)
    throws SftpException
  {
    Sftp.TransferMode localTransferMode = a(this.fileName);
    localTransferMode.upload(paramJFile1, paramJFile2, paramLong);
  }
  
  public void upload(InputStream paramInputStream, JFile paramJFile, long paramLong)
    throws SftpException
  {
    Sftp.TransferMode localTransferMode = a(this.fileName);
    localTransferMode.upload(paramInputStream, paramJFile, paramLong);
  }
  
  private Sftp.TransferMode a(String paramString)
  {
    return b(paramString) ? new Sftp.TextMode(this.c) : new Sftp.BinaryMode(this.c);
  }
  
  private boolean b(String paramString)
  {
    MimetypesFileTypeMap localMimetypesFileTypeMap = new MimetypesFileTypeMap();
    String str = localMimetypesFileTypeMap.getContentType(paramString);
    try
    {
      MimeType localMimeType = new MimeType(str);
      return localMimeType.getPrimaryType().equals(z);
    }
    catch (MimeTypeParseException localMimeTypeParseException) {}
    return false;
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.Sftp.AutoMode
 * JD-Core Version:    0.7.0.1
 */
package com.jscape.inet.ftps;

import com.jscape.inet.ftp.FtpException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.activation.MimetypesFileTypeMap;

class Ftps$AutoMode
  extends Ftps.TransferMode
{
  final Ftps c;
  private static final String z = -1;
  
  public Ftps$AutoMode(Ftps paramFtps)
  {
    super(paramFtps, 0, null);
  }
  
  public long transmit(InputStream paramInputStream, OutputStream paramOutputStream, String paramString, int paramInt, long paramLong1, long paramLong2)
    throws FtpException
  {
    Ftps.TransferMode localTransferMode = a(paramString);
    return localTransferMode.transmit(paramInputStream, paramOutputStream, paramString, paramInt, paramLong1, paramLong2);
  }
  
  private Ftps.TransferMode a(String paramString)
  {
    return b(paramString) ? new Ftps.TextMode(this.c) : new Ftps.BinaryMode(this.c);
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
    break label115;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftps.Ftps.AutoMode
 * JD-Core Version:    0.7.0.1
 */
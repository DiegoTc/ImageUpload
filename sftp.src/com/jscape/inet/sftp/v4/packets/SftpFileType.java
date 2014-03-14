package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.file.JFileType;
import com.jscape.inet.ssh.types.SshByte;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SftpFileType
{
  protected static final int SSH_FILEXFER_TYPE_REGULAR = 1;
  protected static final int SSH_FILEXFER_TYPE_DIRECTORY = 2;
  protected static final int SSH_FILEXFER_TYPE_SYMLINK = 3;
  protected static final int SSH_FILEXFER_TYPE_SPECIAL = 4;
  protected static final int SSH_FILEXFER_TYPE_UNKNOWN = 5;
  protected static Map codeMap = new HashMap();
  
  public static JFileType readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    int i = SshByte.readIntFrom(paramInputStream);
    return findTypeFor(i);
  }
  
  public static void writeTypeTo(JFileType paramJFileType, OutputStream paramOutputStream)
    throws IOException
  {
    u.a(paramJFileType);
    u.a(paramOutputStream);
    int i = ((Integer)codeMap.get(paramJFileType)).intValue();
    SshByte.writeIntTo(i, paramOutputStream);
  }
  
  protected static JFileType findTypeFor(int paramInt)
  {
    int j = SftpFileAttributes2.j;
    Iterator localIterator = codeMap.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i = ((Integer)localEntry.getValue()).intValue();
      if (i == paramInt) {
        return (JFileType)localEntry.getKey();
      }
    } while (j == 0);
    return JFileType.UNKNOWN;
  }
  
  static
  {
    codeMap.put(JFileType.REGULAR, new Integer(1));
    codeMap.put(JFileType.DIRECTORY, new Integer(2));
    codeMap.put(JFileType.SYMBOLIC, new Integer(3));
    codeMap.put(JFileType.SOCKET, new Integer(4));
    codeMap.put(JFileType.BLOCK_ORIENTED, new Integer(4));
    codeMap.put(JFileType.CHAR_ORIENTED, new Integer(4));
    codeMap.put(JFileType.FIFO, new Integer(4));
    codeMap.put(JFileType.UNKNOWN, new Integer(5));
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SftpFileType
 * JD-Core Version:    0.7.0.1
 */
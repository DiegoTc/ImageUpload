package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.file.JAcl.Mask;
import com.jscape.inet.file.JFileOpenFlags;
import com.jscape.inet.sftp.packets.SftpFileOpenFlags;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SftpFileOpenFlags2
  extends SftpFileOpenFlags
{
  protected static final int SSH_FXF_TEXT = 64;
  protected boolean text = false;
  
  public static SftpFileOpenFlags readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    SftpFileOpenFlags2 localSftpFileOpenFlags2 = new SftpFileOpenFlags2();
    int i = SshUint32.readIntFrom(paramInputStream);
    if (j == 0) {}
    localSftpFileOpenFlags2.setReading((i & 0x1) != 0);
    if (j == 0) {}
    localSftpFileOpenFlags2.setWriting((i & 0x2) != 0);
    if (j == 0) {}
    localSftpFileOpenFlags2.setAppending((i & 0x4) != 0);
    if (j == 0) {}
    if (j == 0) {}
    if (j == 0) {}
    localSftpFileOpenFlags2.setCreating((i & 0x8) != 0, (i & 0x10) != 0, (i & 0x20) != 0);
    if (j == 0) {}
    localSftpFileOpenFlags2.setText((i & 0x40) != 0);
    return localSftpFileOpenFlags2;
  }
  
  public static void writeFlagsTo(JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask, OutputStream paramOutputStream)
    throws IOException
  {
    flagsFor(paramJFileOpenFlags, paramMask).writeTo(paramOutputStream);
  }
  
  protected static SftpFileOpenFlags flagsFor(JFileOpenFlags paramJFileOpenFlags, JAcl.Mask paramMask)
  {
    int i = SftpFileAttributes2.j;
    u.a(paramJFileOpenFlags);
    u.a(paramMask);
    if (i == 0) {
      if (!paramJFileOpenFlags.createNew())
      {
        if (i != 0) {
          break label50;
        }
        if (!paramJFileOpenFlags.createTruncate()) {
          if (i != 0) {
            break label50;
          }
        }
      }
    }
    label50:
    boolean bool1 = paramJFileOpenFlags.openOrCreate();
    boolean bool2 = paramJFileOpenFlags.createTruncate();
    boolean bool3 = paramJFileOpenFlags.createNew();
    SftpFileOpenFlags2 localSftpFileOpenFlags2 = new SftpFileOpenFlags2();
    localSftpFileOpenFlags2.setCreating(bool1, bool2, bool3);
    localSftpFileOpenFlags2.setReading(paramMask.readData());
    localSftpFileOpenFlags2.setWriting(paramMask.writeData());
    localSftpFileOpenFlags2.setAppending(paramMask.appendData());
    localSftpFileOpenFlags2.setText(paramJFileOpenFlags.text());
    return localSftpFileOpenFlags2;
  }
  
  public boolean text()
  {
    return this.text;
  }
  
  public void setText(boolean paramBoolean)
  {
    this.text = paramBoolean;
  }
  
  protected int asInteger()
  {
    int i = super.asInteger();
    if (SftpFileAttributes2.j == 0) {
      if (text()) {
        i |= 0x40;
      }
    }
    return i;
  }
  
  public JFileOpenFlags asOpenFlags()
  {
    JFileOpenFlags localJFileOpenFlags = super.asOpenFlags();
    localJFileOpenFlags.setText(text());
    return localJFileOpenFlags;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SftpFileOpenFlags2
 * JD-Core Version:    0.7.0.1
 */
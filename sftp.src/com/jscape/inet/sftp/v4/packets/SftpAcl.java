package com.jscape.inet.sftp.v4.packets;

import com.jscape.inet.file.JAcl;
import com.jscape.inet.file.JAcl.Flag;
import com.jscape.inet.file.JAcl.Mask;
import com.jscape.inet.file.JAcl.Type;
import com.jscape.inet.ssh.types.SshString;
import com.jscape.inet.ssh.types.SshUint32;
import com.jscape.util.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SftpAcl
{
  protected static final int ACE4_ACCESS_ALLOWED_ACE_TYPE = 0;
  protected static final int ACE4_ACCESS_DENIED_ACE_TYPE = 1;
  protected static final int ACE4_SYSTEM_AUDIT_ACE_TYPE = 2;
  protected static final int ACE4_SYSTEM_ALARM_ACE_TYPE = 3;
  protected static final int ACE4_FILE_INHERIT_ACE = 1;
  protected static final int ACE4_DIRECTORY_INHERIT_ACE = 2;
  protected static final int ACE4_NO_PROPAGATE_INHERIT_ACE = 4;
  protected static final int ACE4_INHERIT_ONLY_ACE = 8;
  protected static final int ACE4_SUCCESSFUL_ACCESS_ACE_FLAG = 16;
  protected static final int ACE4_FAILED_ACCESS_ACE_FLAG = 32;
  protected static final int ACE4_IDENTIFIER_GROUP = 64;
  protected static final int ACE4_READ_DATA = 1;
  protected static final int ACE4_LIST_DIRECTORY = 1;
  protected static final int ACE4_WRITE_DATA = 2;
  protected static final int ACE4_ADD_FILE = 2;
  protected static final int ACE4_APPEND_DATA = 4;
  protected static final int ACE4_ADD_SUBDIRECTORY = 4;
  protected static final int ACE4_READ_NAMED_ATTRS = 8;
  protected static final int ACE4_WRITE_NAMED_ATTRS = 16;
  protected static final int ACE4_EXECUTE = 32;
  protected static final int ACE4_DELETE_CHILD = 64;
  protected static final int ACE4_READ_ATTRIBUTES = 128;
  protected static final int ACE4_WRITE_ATTRIBUTES = 256;
  protected static final int ACE4_DELETE = 65536;
  protected static final int ACE4_READ_ACL = 131072;
  protected static final int ACE4_WRITE_ACL = 262144;
  protected static final int ACE4_WRITE_OWNER = 524288;
  protected static final int ACE4_SYNCHRONIZE = 1048576;
  private static final String z = -1;
  
  public static JAcl[] readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    int k = SftpFileAttributes2.j;
    u.a(paramInputStream);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(SshString.readValue(paramInputStream));
    int i = SshUint32.readIntFrom(localByteArrayInputStream);
    JAcl[] arrayOfJAcl = new JAcl[i];
    int j = 0;
    do
    {
      if (j >= i) {
        break;
      }
      if (k != 0) {
        break label66;
      }
      arrayOfJAcl[j] = readAclFrom(localByteArrayInputStream, paramString);
      j++;
    } while (k == 0);
    label66:
    return arrayOfJAcl;
  }
  
  protected static JAcl readAclFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    JAcl.Type localType = readAclTypeFrom(paramInputStream);
    JAcl.Flag localFlag = readAclFlagFrom(paramInputStream);
    JAcl.Mask localMask = readAclMaskFrom(paramInputStream);
    String str = SshString.readValue(paramInputStream, paramString);
    return new JAcl(localType, localFlag, localMask, str);
  }
  
  protected static JAcl.Type readAclTypeFrom(InputStream paramInputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    int i = SshUint32.readIntFrom(paramInputStream);
    if (j == 0) {
      if (i == 0) {
        return JAcl.Type.ACCESS_ALLOWED;
      }
    }
    if (j == 0) {
      if (i == 1) {
        return JAcl.Type.ACCESS_DENIED;
      }
    }
    if (j == 0) {
      if (i == 2) {
        return JAcl.Type.SYSTEM_AUDIT;
      }
    }
    if (i == 3) {
      return JAcl.Type.SYSTEM_ALARM;
    }
    throw new IllegalArgumentException(z);
  }
  
  protected static JAcl.Flag readAclFlagFrom(InputStream paramInputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    JAcl.Flag localFlag = new JAcl.Flag();
    int i = SshUint32.readIntFrom(paramInputStream);
    if (j == 0) {}
    localFlag.setFileInherit((i & 0x1) != 0);
    if (j == 0) {}
    localFlag.setDirectoryInherit((i & 0x2) != 0);
    if (j == 0) {}
    localFlag.setNoPropagateInherit((i & 0x4) != 0);
    if (j == 0) {}
    localFlag.setInheritOnly((i & 0x8) != 0);
    if (j == 0) {}
    localFlag.setSuccessfulAccess((i & 0x10) != 0);
    if (j == 0) {}
    localFlag.setFailedAccess((i & 0x20) != 0);
    if (j == 0) {}
    localFlag.setIdentifierGroup((i & 0x40) != 0);
    return localFlag;
  }
  
  protected static JAcl.Mask readAclMaskFrom(InputStream paramInputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    JAcl.Mask localMask = new JAcl.Mask();
    int i = SshUint32.readIntFrom(paramInputStream);
    if (j == 0) {}
    localMask.setReadData((i & 0x1) != 0);
    if (j == 0) {}
    localMask.setListDirectory((i & 0x1) != 0);
    if (j == 0) {}
    localMask.setWriteData((i & 0x2) != 0);
    if (j == 0) {}
    localMask.setAddFile((i & 0x2) != 0);
    if (j == 0) {}
    localMask.setAppendData((i & 0x4) != 0);
    if (j == 0) {}
    localMask.setAddSubdirectory((i & 0x4) != 0);
    if (j == 0) {}
    localMask.setReadNamedAttrs((i & 0x8) != 0);
    if (j == 0) {}
    localMask.setWriteNamedAttrs((i & 0x10) != 0);
    if (j == 0) {}
    localMask.setExecute((i & 0x20) != 0);
    if (j == 0) {}
    localMask.setDeleteChild((i & 0x40) != 0);
    if (j == 0) {}
    localMask.setReadAttributes((i & 0x80) != 0);
    if (j == 0) {}
    localMask.setWriteAttributes((i & 0x100) != 0);
    if (j == 0) {}
    localMask.setDelete((i & 0x10000) != 0);
    if (j == 0) {}
    localMask.setReadAcl((i & 0x20000) != 0);
    if (j == 0) {}
    localMask.setWriteAcl((i & 0x40000) != 0);
    if (j == 0) {}
    localMask.setWriteOwner((i & 0x80000) != 0);
    if (j == 0) {}
    localMask.setSynchronize((i & 0x100000) != 0);
    if (j != 0) {
      u.a = !u.a;
    }
    return localMask;
  }
  
  public static void writeTo(JAcl[] paramArrayOfJAcl, String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    u.a(paramArrayOfJAcl);
    u.a(paramOutputStream);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    do
    {
      if (i >= paramArrayOfJAcl.length) {
        break;
      }
      writeAclTo(paramArrayOfJAcl[i], paramString, paramOutputStream);
      i++;
      if (j != 0) {
        return;
      }
    } while (j == 0);
    SshString.writeValue(localByteArrayOutputStream.toByteArray(), paramOutputStream);
  }
  
  protected static void writeAclTo(JAcl paramJAcl, String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    writeAclTypeTo(paramJAcl.getType(), paramOutputStream);
    writeAclFlagTo(paramJAcl.getFlag(), paramOutputStream);
    writeAclMaskTo(paramJAcl.getMask(), paramOutputStream);
    SshString.writeValue(paramJAcl.getWho(), paramString, paramOutputStream);
  }
  
  protected static void writeAclTypeTo(JAcl.Type paramType, OutputStream paramOutputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    int i = 0;
    if (j == 0) {
      if (paramType == JAcl.Type.ACCESS_ALLOWED)
      {
        i = 0;
        if (j == 0) {
          break label55;
        }
      }
    }
    if (j == 0) {
      if (paramType == JAcl.Type.ACCESS_DENIED)
      {
        i = 1;
        if (j == 0) {
          break label55;
        }
      }
    }
    if (paramType == JAcl.Type.SYSTEM_AUDIT)
    {
      i = 2;
      if (j == 0) {}
    }
    else
    {
      i = 3;
    }
    label55:
    SshUint32.writeIntTo(i, paramOutputStream);
  }
  
  protected static void writeAclFlagTo(JAcl.Flag paramFlag, OutputStream paramOutputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    int i = 0;
    if (j == 0) {
      if (paramFlag.fileInherit()) {
        i |= 0x1;
      }
    }
    if (j == 0) {
      if (paramFlag.directoryInherit()) {
        i |= 0x2;
      }
    }
    if (j == 0) {
      if (paramFlag.noPropagateInherit()) {
        i |= 0x4;
      }
    }
    if (j == 0) {
      if (paramFlag.inheritOnly()) {
        i |= 0x8;
      }
    }
    if (j == 0) {
      if (paramFlag.successfulAccess()) {
        i |= 0x10;
      }
    }
    if (j == 0) {
      if (paramFlag.failedAccess()) {
        i |= 0x20;
      }
    }
    if (j == 0) {
      if (paramFlag.identifierGroup()) {
        i |= 0x40;
      }
    }
    SshUint32.writeIntTo(i, paramOutputStream);
  }
  
  protected static void writeAclMaskTo(JAcl.Mask paramMask, OutputStream paramOutputStream)
    throws IOException
  {
    int j = SftpFileAttributes2.j;
    int i = 0;
    if (j == 0) {
      if (paramMask.readData()) {
        i |= 0x1;
      }
    }
    if (j == 0) {
      if (paramMask.listDirectory()) {
        i |= 0x1;
      }
    }
    if (j == 0) {
      if (paramMask.writeData()) {
        i |= 0x2;
      }
    }
    if (j == 0) {
      if (paramMask.addFile()) {
        i |= 0x2;
      }
    }
    if (j == 0) {
      if (paramMask.appendData()) {
        i |= 0x4;
      }
    }
    if (j == 0) {
      if (paramMask.addSubdirectory()) {
        i |= 0x4;
      }
    }
    if (j == 0) {
      if (paramMask.readNamedAttrs()) {
        i |= 0x8;
      }
    }
    if (j == 0) {
      if (paramMask.writeNamedAttrs()) {
        i |= 0x10;
      }
    }
    if (j == 0) {
      if (paramMask.execute()) {
        i |= 0x20;
      }
    }
    if (j == 0) {
      if (paramMask.deleteChild()) {
        i |= 0x40;
      }
    }
    if (j == 0) {
      if (paramMask.readAttributes()) {
        i |= 0x80;
      }
    }
    if (j == 0) {
      if (paramMask.writeAttributes()) {
        i |= 0x100;
      }
    }
    if (j == 0) {
      if (paramMask.delete()) {
        i |= 0x10000;
      }
    }
    if (j == 0) {
      if (paramMask.readAcl()) {
        i |= 0x20000;
      }
    }
    if (j == 0) {
      if (paramMask.writeAcl()) {
        i |= 0x40000;
      }
    }
    if (j == 0) {
      if (paramMask.writeOwner()) {
        i |= 0x80000;
      }
    }
    if (j == 0) {
      if (paramMask.synchronize()) {
        i |= 0x100000;
      }
    }
    SshUint32.writeIntTo(i, paramOutputStream);
    if (u.a)
    {
      j++;
      SftpFileAttributes2.j = j;
    }
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.sftp.v4.packets.SftpAcl
 * JD-Core Version:    0.7.0.1
 */
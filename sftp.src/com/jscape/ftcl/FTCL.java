package com.jscape.ftcl;

import com.jscape.filetransfer.Protocol;
import com.jscape.ftcl.b.a.b;
import com.jscape.ftcl.b.a.cf;
import com.jscape.ftcl.b.d;
import com.jscape.ftcl.b.e;
import com.jscape.util.a.j;
import com.jscape.util.bc;
import com.jscape.util.mb;
import com.jscape.util.qb;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class FTCL
{
  private final com.jscape.ftcl.b.f interpretationService;
  private final d transferParameters;
  private final cf variables;
  private static final String z = -1;
  
  public static void main(String[] paramArrayOfString)
  {
    j localj = j.b();
    try
    {
      k localk = k.a(paramArrayOfString);
      execute(localk);
      System.exit(0);
    }
    catch (com.jscape.util.a.a.f localf)
    {
      showUsage(localj);
      System.exit(1);
    }
    catch (Throwable localThrowable)
    {
      showError(localj, localThrowable);
      System.exit(1);
    }
  }
  
  public static void execute(k paramk)
    throws Exception
  {
    PrintStream localPrintStream = null;
    try
    {
      com.jscape.ftcl.b.f localf = e.b();
      d locald = paramk.c();
      localPrintStream = debugStreamFor(paramk.w);
      locald.setDebugStream(localPrintStream);
      cf localcf = paramk.x;
      b.a(locald, localcf);
      FTCL localFTCL = new FTCL(localf, locald, localcf);
      localFTCL.execute(new File(paramk.n));
    }
    finally
    {
      close(localPrintStream);
    }
  }
  
  private static PrintStream debugStreamFor(String paramString)
    throws Exception
  {
    if (paramString == null) {
      return System.out;
    }
    File localFile1 = new File(paramString);
    File localFile2 = localFile1.getParentFile();
    if ((c.b) || (!localFile2.exists())) {
      mb.a(localFile2);
    }
    return new PrintStream(new FileOutputStream(localFile1, true), true, Charset.defaultCharset().name());
  }
  
  private static void showUsage(j paramj)
  {
    paramj.b(z);
  }
  
  private static void showError(j paramj, Throwable paramThrowable)
  {
    paramj.a(paramThrowable);
  }
  
  private static void close(PrintStream paramPrintStream)
  {
    if ((c.b) || (paramPrintStream != System.out)) {
      qb.a(paramPrintStream);
    }
  }
  
  public FTCL(com.jscape.ftcl.b.f paramf, d paramd, cf paramcf)
  {
    bc.a(paramf);
    this.interpretationService = paramf;
    bc.a(paramd);
    this.transferParameters = paramd;
    bc.a(paramcf);
    this.variables = paramcf;
  }
  
  public FTCL()
  {
    this(e.b(), new d(Protocol.FTP, null, null, null, null, null, null, null, Boolean.valueOf(true), System.out, null, null, null, null, null, null, null, null, null, null, null, null, null), new cf());
  }
  
  public void setDebugStream(PrintStream paramPrintStream)
  {
    this.transferParameters.setDebugStream(paramPrintStream);
  }
  
  public void execute(InputStream paramInputStream)
    throws FTCLException
  {
    try
    {
      this.interpretationService.a(paramInputStream, this.transferParameters, this.variables);
    }
    catch (Throwable localThrowable)
    {
      throw new FTCLException(localThrowable.getMessage(), localThrowable);
    }
  }
  
  public void execute(File paramFile)
    throws FTCLException
  {
    FileInputStream localFileInputStream = null;
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      execute(localFileInputStream);
    }
    catch (IOException localIOException)
    {
      throw new FTCLException(localIOException.getMessage(), localIOException);
    }
    finally
    {
      qb.a(localFileInputStream);
    }
  }
  
  public void execute(byte[] paramArrayOfByte)
    throws FTCLException
  {
    execute(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  static
  {
    break label13;
    break label116;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.ftcl.FTCL
 * JD-Core Version:    0.7.0.1
 */
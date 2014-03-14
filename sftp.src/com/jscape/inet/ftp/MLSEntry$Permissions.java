package com.jscape.inet.ftp;

public final class MLSEntry$Permissions
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  
  public MLSEntry$Permissions() {}
  
  public MLSEntry$Permissions(Permissions paramPermissions)
  {
    this.a = paramPermissions.a;
    this.b = paramPermissions.b;
    this.c = paramPermissions.c;
    this.d = paramPermissions.d;
    this.e = paramPermissions.e;
    this.f = paramPermissions.f;
    this.g = paramPermissions.g;
    this.h = paramPermissions.h;
    this.i = paramPermissions.i;
    this.j = paramPermissions.j;
  }
  
  public boolean isFileAppendingAllowed()
  {
    return this.a;
  }
  
  public void setFileAppendingAllowed(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean isFileCreationAllowed()
  {
    return this.b;
  }
  
  public void setFileCreationAllowed(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean isDeletionAllowed()
  {
    return this.c;
  }
  
  public void setDeletionAllowed(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean isDirectoryEnteringAllowed()
  {
    return this.d;
  }
  
  public void setDirectoryEnteringAllowed(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean isRenamingAllowed()
  {
    return this.e;
  }
  
  public void setRenamingAllowed(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean isListingAllowed()
  {
    return this.f;
  }
  
  public void setListingAllowed(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean isDirectoryCreationAllowed()
  {
    return this.g;
  }
  
  public void setDirectoryCreationAllowed(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean isDirectoryPurgingAllowed()
  {
    return this.h;
  }
  
  public void setDirectoryPurgingAllowed(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean isFileReadingAllowed()
  {
    return this.i;
  }
  
  public void setFileReadingAllowed(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean isFileWritingAllowed()
  {
    return this.j;
  }
  
  public void setFileWritingAllowed(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.ftp.MLSEntry.Permissions
 * JD-Core Version:    0.7.0.1
 */
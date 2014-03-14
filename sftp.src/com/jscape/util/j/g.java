package com.jscape.util.j;

import com.jscape.util.b.a;
import com.jscape.util.b.r;
import com.jscape.util.f.z;
import java.net.NetworkInterface;
import java.util.List;

class g
  extends z<NetworkInterface, j>
{
  public j a(NetworkInterface paramNetworkInterface)
  {
    List localList = a.a(r.a(paramNetworkInterface.getInetAddresses(), new f(null)));
    return new j(paramNetworkInterface.getName(), paramNetworkInterface.getDisplayName() != null ? paramNetworkInterface.getDisplayName() : paramNetworkInterface.getName(), localList);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.util.j.g
 * JD-Core Version:    0.7.0.1
 */
package com.jscape.inet.a.a.b;

import java.util.Comparator;

public class zb
  implements Comparator<yb>
{
  public int a(yb paramyb1, yb paramyb2)
  {
    int i = o.a;
    if (i == 0) {
      if (paramyb1.b())
      {
        if (i != 0) {
          break label32;
        }
        if (!paramyb2.b()) {
          return -1;
        }
      }
    }
    label32:
    if (i == 0) {
      if (paramyb2.b())
      {
        if (i != 0) {
          break label63;
        }
        if (!paramyb1.b()) {
          return 1;
        }
      }
    }
    label63:
    return paramyb1.a.compareTo(paramyb2.a);
  }
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     com.jscape.inet.a.a.b.zb
 * JD-Core Version:    0.7.0.1
 */
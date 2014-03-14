package org.apache.oro.text.awk;

import java.util.BitSet;

abstract class SyntaxNode
{
  abstract SyntaxNode _clone(int[] paramArrayOfInt);
  
  abstract BitSet _firstPosition();
  
  abstract void _followPosition(BitSet[] paramArrayOfBitSet, SyntaxNode[] paramArrayOfSyntaxNode);
  
  abstract BitSet _lastPosition();
  
  abstract boolean _nullable();
}


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.awk.SyntaxNode
 * JD-Core Version:    0.7.0.1
 */
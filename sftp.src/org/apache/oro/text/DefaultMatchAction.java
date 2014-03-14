/*  1:   */ package org.apache.oro.text;
/*  2:   */ 
/*  3:   */ import java.io.PrintWriter;
/*  4:   */ 
/*  5:   */ final class DefaultMatchAction
/*  6:   */   implements MatchAction
/*  7:   */ {
/*  8:   */   public void processMatch(MatchActionInfo paramMatchActionInfo)
/*  9:   */   {
/* 10:71 */     paramMatchActionInfo.output.println(paramMatchActionInfo.line);
/* 11:   */   }
/* 12:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.DefaultMatchAction
 * JD-Core Version:    0.7.0.1
 */
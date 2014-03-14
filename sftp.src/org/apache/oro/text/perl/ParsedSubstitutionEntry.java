/*  1:   */ package org.apache.oro.text.perl;
/*  2:   */ 
/*  3:   */ import org.apache.oro.text.regex.Pattern;
/*  4:   */ import org.apache.oro.text.regex.Perl5Substitution;
/*  5:   */ 
/*  6:   */ final class ParsedSubstitutionEntry
/*  7:   */ {
/*  8:   */   int _numSubstitutions;
/*  9:   */   Pattern _pattern;
/* 10:   */   Perl5Substitution _substitution;
/* 11:   */   
/* 12:   */   ParsedSubstitutionEntry(Pattern paramPattern, Perl5Substitution paramPerl5Substitution, int paramInt)
/* 13:   */   {
/* 14:74 */     this._numSubstitutions = paramInt;
/* 15:75 */     this._substitution = paramPerl5Substitution;
/* 16:76 */     this._pattern = paramPattern;
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     org.apache.oro.text.perl.ParsedSubstitutionEntry
 * JD-Core Version:    0.7.0.1
 */
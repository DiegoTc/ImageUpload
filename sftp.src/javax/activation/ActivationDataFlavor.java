/*   1:    */ package javax.activation;
/*   2:    */ 
/*   3:    */ import java.awt.datatransfer.DataFlavor;
/*   4:    */ 
/*   5:    */ public class ActivationDataFlavor
/*   6:    */   extends DataFlavor
/*   7:    */ {
/*   8:    */   private String mimeType;
/*   9:    */   private MimeType mimeObject;
/*  10:    */   private String humanPresentableName;
/*  11:    */   private Class representationClass;
/*  12:    */   
/*  13:    */   static Class class$(String paramString)
/*  14:    */   {
/*  15:    */     try
/*  16:    */     {
/*  17: 37 */       return Class.forName(paramString);
/*  18:    */     }
/*  19:    */     catch (ClassNotFoundException localClassNotFoundException)
/*  20:    */     {
/*  21: 37 */       throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
/*  22:    */     }
/*  23:    */   }
/*  24:    */   
/*  25:    */   public ActivationDataFlavor(Class paramClass, String paramString1, String paramString2)
/*  26:    */   {
/*  27: 75 */     super(paramString1, paramString2);
/*  28:    */     
/*  29:    */ 
/*  30: 78 */     this.mimeType = paramString1;
/*  31: 79 */     this.humanPresentableName = paramString2;
/*  32: 80 */     this.representationClass = paramClass;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public ActivationDataFlavor(Class paramClass, String paramString)
/*  36:    */   {
/*  37:102 */     super(paramClass, paramString);
/*  38:103 */     this.mimeType = super.getMimeType();
/*  39:104 */     this.representationClass = paramClass;
/*  40:105 */     this.humanPresentableName = paramString;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public ActivationDataFlavor(String paramString1, String paramString2)
/*  44:    */   {
/*  45:124 */     super(paramString1, paramString2);
/*  46:125 */     this.mimeType = paramString1;
/*  47:126 */     this.representationClass = (DataFlavor.class$java$io$InputStream = class$("java.io.InputStream"));
/*  48:127 */     this.humanPresentableName = paramString2;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getMimeType()
/*  52:    */   {
/*  53:136 */     return this.mimeType;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Class getRepresentationClass()
/*  57:    */   {
/*  58:145 */     return this.representationClass;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getHumanPresentableName()
/*  62:    */   {
/*  63:154 */     return this.humanPresentableName;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setHumanPresentableName(String paramString)
/*  67:    */   {
/*  68:163 */     this.humanPresentableName = paramString;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public boolean equals(DataFlavor paramDataFlavor)
/*  72:    */   {
/*  73:175 */     return (isMimeTypeEqual(paramDataFlavor)) && 
/*  74:176 */       (paramDataFlavor.getRepresentationClass() == this.representationClass);
/*  75:    */   }
/*  76:    */   
/*  77:    */   public boolean isMimeTypeEqual(String paramString)
/*  78:    */   {
/*  79:192 */     MimeType localMimeType = null;
/*  80:    */     try
/*  81:    */     {
/*  82:194 */       if (this.mimeObject == null) {
/*  83:195 */         this.mimeObject = new MimeType(this.mimeType);
/*  84:    */       }
/*  85:196 */       localMimeType = new MimeType(paramString);
/*  86:    */     }
/*  87:    */     catch (MimeTypeParseException localMimeTypeParseException) {}
/*  88:199 */     return this.mimeObject.match(localMimeType);
/*  89:    */   }
/*  90:    */   
/*  91:    */   protected String normalizeMimeTypeParameter(String paramString1, String paramString2)
/*  92:    */   {
/*  93:217 */     return paramString1 + "=" + paramString2;
/*  94:    */   }
/*  95:    */   
/*  96:    */   protected String normalizeMimeType(String paramString)
/*  97:    */   {
/*  98:231 */     return paramString;
/*  99:    */   }
/* 100:    */ }


/* Location:           C:\Users\dturcios\Documents\NetBeansProjects\ImageUploader\dist\lib\sftp.jar
 * Qualified Name:     javax.activation.ActivationDataFlavor
 * JD-Core Version:    0.7.0.1
 */
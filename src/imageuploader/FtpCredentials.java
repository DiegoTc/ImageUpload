/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageuploader;
import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import com.jscape.inet.ftp.*;
import com.jscape.inet.ftps.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
/**
 *
 * @author dturcios
 */
public class FtpCredentials extends FtpAdapter{
    private String hostname;
    private String username;
    private String password;
    private String connectionType;
    private int port;
    private static FtpCredentials credentials=null;
    private Ftps client;
    private FtpCredentials(){
        
    }
    
    public static FtpCredentials getInstancia(){
        if(credentials == null){
            credentials= new FtpCredentials();
        }
        return credentials;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connect() throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FtpException{
        client= new Ftps("209.202.136.20", this.username, this.password);
        client.setConnectionType(Ftps.IMPLICIT_SSL);
        client.addFtpListener(this);
	client.setPort(990);
        client.connect();
    }

    public Ftps getClient() {
        return client;
    }
    
    
    public void copyImage(ArrayList<File> listF) throws FtpException {
        client.setBlockTransferSize(128*8192);
        for(int i=0;i<listF.size();i++){
            client.upload(listF.get(i));
        }

    }
  
    
}

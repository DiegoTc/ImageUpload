/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageuploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.apache.commons.net.util.TrustManagerUtils;

/**
 *
 * @author dturcios
 */
public class FtpApacheCredentials {

    private String hostname;
    private String username;
    private String password;
    private String connectionType;
    private int port;
    private static FtpApacheCredentials credentials = null;
    private FTPSClient client;

    private FtpApacheCredentials() {
        
    }

    public static FtpApacheCredentials getInstancia() {
        if (credentials == null) {
            credentials = new FtpApacheCredentials();
        }
        return credentials;
    }

    public FTPSClient getClient() {
        return client;
    }

    public void setClient(FTPSClient client) {
        this.client = client;
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

    public void connect() throws IOException {

        client.connect("209.202.136.20", 990);
    }

    public void login() throws IOException {

        client.login("myron", "my45627");
        //ftps.
    }

    public boolean copytoServer(String name,File path) throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(path);
        InputStream input = new FileInputStream(path);
        boolean upload = client.storeFile(name, input);
        return upload;
    }
}

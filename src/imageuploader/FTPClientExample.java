/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageuploader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
public class FTPClientExample {
    boolean storeFile = false, binaryTransfer = false, error = false, listFiles = false, listNames = false, hidden = false;
        boolean localActive = false, useEpsvWithIPv4 = false, feat = false, printHash = false;
        boolean mlst = false, mlsd = false;
        boolean lenient = false;
        long keepAliveTimeout = -1;
        int controlKeepAliveReplyTimeout = -1;
        int minParams = 5; // listings require 3 params
        String protocol = null; // SSL protocol
        String doCommand = null;
        String trustmgr = null;
        String proxyHost = null;
        int proxyPort = 80;
        String proxyUser = null;
        String proxyPassword = null;
        String username = null;
        String password = null;
        FTPSClient ftps;
        
        FTPClientExample(String user, String pass){
            username=user;
            password=pass;
            ftps = new FTPSClient("TLS",true);
        }
        
        public void connect() throws IOException{
           
            ftps.connect("209.202.136.20", 990);
        }
        
        public void login() throws IOException{
            
            ftps.login("myron", "my45627");
            //ftps.
        }
        
         public boolean copytoServer(String name,File path) throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(path);
       // InputStream input = new FileInputStream(path);
        boolean upload = ftps.storeFile(name, inputStream);
        return upload;
    }
        
        
}

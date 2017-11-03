package persistencia.conexion;

import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Properties;

public class ConexionFTP{
    private FTPClient ftpClient;

    private Properties properties;

    private int port;
    private String ip;
    private String username;
    private String password;

    public ConexionFTP() {
        ftpClient = new FTPClient();
        properties = new Properties();
    }

    public void connect(){
        try {
            retrieveProperties();
            ftpClient.setConnectTimeout(10000); //10 segundos de connection TimeOut

            ftpClient.connect(ip,port);
            ftpClient.login(username, password);

            //ftpClient.enterLocalPassiveMode();
        } catch (SocketTimeoutException t){
            t.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(ftpClient.isConnected());
    }

    public String serverReplay(){
        return ftpClient.getReplyString();
    }

    public void close(){
        try {
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FTPClient getClient() {
        return ftpClient;
    }

    private void retrieveProperties(){
        try {
            FileInputStream fileInput = new FileInputStream("config/ftpserver.properties");
            properties.load(fileInput);

            username = properties.getProperty("username");
            password = properties.getProperty("password");
            ip = properties.getProperty("ip");
            port = Integer.valueOf(properties.getProperty("port"));

            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

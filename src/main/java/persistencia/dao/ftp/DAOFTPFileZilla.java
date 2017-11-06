package persistencia.dao.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import persistencia.conexion.ConexionFTP;
import persistencia.dao.iface.DAOftp;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DAOFTPFileZilla implements DAOftp{

    private ConexionFTP conexion;
    private FTPClient cliente;

    public DAOFTPFileZilla() {
        conexion = new ConexionFTP();
        cliente = conexion.getClient();
    }

    public void storeFile(File file, String fileName){
        if(file == null)
            return;

        innitConnection();
        try {
            cliente.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
            InputStream inputStream = new FileInputStream(file);

            cliente.storeFile(fileName, inputStream); //Retorna boolean
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeConnection();
    }
    
    public void deleteFile(String remoteFile) {
        if(remoteFile == null)
            return;

        innitConnection();
        try {
        	cliente.deleteFile(remoteFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public void retrieveFile(String remoteFileName, String newFilePath){
        innitConnection();
        File dowloadedFile = new File(newFilePath);
        try {
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(dowloadedFile));
            cliente.retrieveFile(remoteFileName, outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public List<String> listFiles(){
        List<String> toRet = null;
        FTPFile[] files = null;

        innitConnection();
        try {
            cliente.listFiles();
            files = cliente.listFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (files != null && files.length != 0) {
            List<FTPFile> files1 = Arrays.asList(files);
            toRet = files1.stream().map(FTPFile::getName).collect(Collectors.toList());
        }
        closeConnection();
        return toRet;
    }

    private void innitConnection(){
        conexion.connect();
    }

    private void closeConnection(){
        conexion.close();
    }

}

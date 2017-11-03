package persistencia.dao.ftp;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DAOFTPFileZillaTest {

    @Test
    public void testingFiles() {
        DAOFTPFileZilla daoftp = new DAOFTPFileZilla();
        System.out.println(daoftp.listFiles());
        File file = new File("/home/lucas/Escritorio/jeje.txt");
        daoftp.storeFile(file, "jeje1.txt");
    }


}
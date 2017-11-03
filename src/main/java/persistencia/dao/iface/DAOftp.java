package persistencia.dao.iface;

import java.io.File;
import java.util.List;

public interface DAOftp {

    public void storeFile(File file, String fileName);

    public void retrieveFile(String remoteFile, String newFilePathAndName);

    public List<String> listFiles();
}

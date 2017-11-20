package persistencia.backup;

import model.LogicaNegocioException;
import org.zeroturnaround.zip.commons.FileUtils;
import persistencia.conexion.DBCredentialsEditor;
import persistencia.dao.ftp.DAOFTPFileZilla;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BackUper {
    private Zipper zipper;
    private DAOFTPFileZilla fileZilla;
    private DBCredentialsEditor credentials;

    private final String DIRECTORY_NAME = "BackUp";
    private final String PHOTOS_DIRECTORY = DIRECTORY_NAME + File.separatorChar + "FTPServer" + File.separatorChar;//Este no necesariamente tiene que ponerse en properties
    private final String DATABASE_DIRECTORY = DIRECTORY_NAME + File.separatorChar + "DataBase" + File.separatorChar;
    private final String DATABASE_SQL_NAME = "inmo_backup.sql";
    private final String DATABASE_SCRIPT_EXPORT = "export.bat";
    private final String DATABASE_SCRIPT_IMPORT = "import.bat";

    public BackUper() {
        zipper = new Zipper();
        fileZilla = new DAOFTPFileZilla();
        credentials = DBCredentialsEditor.getEditor();
    }

    public void exportBackUp(File exportDirectory, String backUpName) throws LogicaNegocioException {
        if (!existDirectory(exportDirectory))
            throw new LogicaNegocioException("El elemento seleccionado no es un directorio");

        String givenDirectory = exportDirectory.getAbsolutePath();

        createNewDirectory(DIRECTORY_NAME);
        createNewDirectory(PHOTOS_DIRECTORY);
        createNewDirectory(DATABASE_DIRECTORY);

        copyPhotosFromFTP(PHOTOS_DIRECTORY);
        executeCommandLineScript(DATABASE_SCRIPT_EXPORT + " " + credentials.getUsuario() + " " + credentials.getPass() +
                " " + credentials.getIP() + " " + DATABASE_DIRECTORY + DATABASE_SQL_NAME);
        zipper.zipIt(givenDirectory + File.separatorChar + backUpName + ".zip", DIRECTORY_NAME);

        deleteDirectory(DIRECTORY_NAME);
    }

    public void importBackUp(File archivoZip) throws LogicaNegocioException {
        String temporaryDirectory = DATABASE_DIRECTORY + DATABASE_SQL_NAME;
        temporaryDirectory = temporaryDirectory.replace("\\", "/");

        if (!archivoZip.isFile())
            throw new LogicaNegocioException("No se ha seleccionado un archivo");

        createNewDirectory(DIRECTORY_NAME);

        zipper.unzipIt(archivoZip.getAbsolutePath(), DIRECTORY_NAME);
        copyPhotosToFTP(PHOTOS_DIRECTORY);
        executeCommandLineScript(DATABASE_SCRIPT_IMPORT + " " + credentials.getUsuario() + " "
                + credentials.getPass() + " " + credentials.getIP() + " " + temporaryDirectory);

        deleteDirectory(DIRECTORY_NAME);
    }

    private boolean existDirectory(File directory_name) {
        return directory_name.isDirectory() && directory_name.exists();
    }

    private void createNewDirectory(String directory) {

        File direct = new File(directory);
        direct.mkdir();
    }

    private void copyPhotosFromFTP(String toDirectory) {
        List<String> filesName = fileZilla.listFiles();
        System.out.println(toDirectory);
        System.out.println(filesName);

        filesName.forEach(fname -> fileZilla.retrieveFile(fname, toDirectory + fname));
    }

    private void copyPhotosToFTP(String fromDirectory) {
        File from = new File(fromDirectory);
        List<File> allFiles = Arrays.asList(from.listFiles());

        allFiles.forEach(file -> fileZilla.storeFile(file, file.getName()));
    }

    private void deleteDirectory(String directory) {
        File direc = new File(directory);
        try {
            FileUtils.deleteDirectory(direc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeCommandLineScript(String script) {
        //TODO se puede cachear el int de la salida del proceso
        System.out.println(script);
        try {
            //Runtime.getRuntime().exec("sh " + script).waitFor(); //Linux
            Runtime.getRuntime().exec("cmd /c \"\" " + script).waitFor(); //Windows
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

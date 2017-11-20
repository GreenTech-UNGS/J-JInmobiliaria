package persistencia.backup;

import model.LogicaNegocioException;
import org.zeroturnaround.zip.commons.FileUtils;
import persistencia.dao.ftp.DAOFTPFileZilla;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BackUper {
    private Zipper zipper;
    private DAOFTPFileZilla fileZilla;

    private final String DIRECTORY_NAME = "BackUp";
    private final String PHOTOS_DIRECTORY = DIRECTORY_NAME + File.separatorChar + "FTPServer";//Este no necesariamente tiene que ponerse en properties
    private final String DATABASE_DIRECTORY = DIRECTORY_NAME + File.separatorChar + "DataBase";
    private final String DATABASE_SCRIPT_EXPORT = "export.sh";
    private final String DATABASE_SCRIPT_IMPORT = "import.sh";

    public BackUper(){
        zipper = new Zipper();
        fileZilla = new DAOFTPFileZilla();
    }

    public void exportBackUp(File exportDirectory, String backUpName) throws LogicaNegocioException {
        if (!existDirectory(exportDirectory))
            throw new LogicaNegocioException("No existe archivo");

        String givenDirectory = exportDirectory.getAbsolutePath();

        createNewDirectory(DIRECTORY_NAME);

        //crear directorio de las fotos;
        createNewDirectory(PHOTOS_DIRECTORY);

        //copiar fotos al directorio
        copyPhotosFromFTP(PHOTOS_DIRECTORY);

        //crear directorio de la base de datos
        createNewDirectory(DATABASE_DIRECTORY);

        //hacer backup de la base de datos y copiarlo en la carpeta
        executeCommandLineScript(DATABASE_SCRIPT_EXPORT);

        //Zipear
        zipper.zipIt(givenDirectory + File.separatorChar + backUpName +".zip", DIRECTORY_NAME);

        //Borrar el directorio
        deleteDirectory(DIRECTORY_NAME);
    }

    public void importBackUp(File archivoZip) throws LogicaNegocioException {

        if(!archivoZip.isFile())
            throw new LogicaNegocioException("No se ha seleccionado un archivo");

        createNewDirectory(DIRECTORY_NAME);

        zipper.unzipIt(archivoZip.getAbsolutePath(), DIRECTORY_NAME);
        copyPhotosToFTP(PHOTOS_DIRECTORY);
        executeCommandLineScript(DATABASE_SCRIPT_IMPORT);

        deleteDirectory(DIRECTORY_NAME);
    }

    private boolean existDirectory(File directory_name) {
        return directory_name.isDirectory() && directory_name.exists();
    }

    private void createNewDirectory(String directory) {

        File direct = new File(directory);
        direct.mkdir();
    }

    private void copyPhotosFromFTP(String toDirectory){
        List<String> filesName = fileZilla.listFiles();
        System.out.println(toDirectory);
        System.out.println(filesName);

        filesName.forEach(fname -> fileZilla.retrieveFile(fname, toDirectory + File.separatorChar +
        fname));
    }

    private void copyPhotosToFTP(String fromDirectory){
        File from = new File(fromDirectory);
        List<File> allFiles = Arrays.asList(from.listFiles());

        allFiles.forEach(file -> fileZilla.storeFile(file, file.getName()));
    }

    private void deleteDirectory(String directory){
        File direc = new File(directory);
        try {
            FileUtils.deleteDirectory(direc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeCommandLineScript(String script){
        //PARA WINDOWS Runtime.getRuntime().exec("cmd /c start \"\" build.bat");
        //TODO se puede cachear el int de la salida del proceso
        System.out.println(script);
        try {
            Runtime.getRuntime().exec("sh " + script).waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package persistencia.backup;

import org.zeroturnaround.zip.commons.FileUtils;

import java.io.File;
import java.io.IOException;

public class BackUper {
    private Zipper zipper;
    private final String DIRECTORY_NAME = "BackUp"; //TODO: esto podría ser un propperties
    private final String PHOTOS_DIRECTORY = DIRECTORY_NAME + File.separatorChar + "FTPServer";//Este no necesariamente tiene que ponerse en properties
    private final String OUTPUT_COMPRESS_FILE = "backUp.zip";
    private final String FTP_FOLDER = "/home/lucas/Documentos/test";
    private final String DATABASE_DIRECTORY = DIRECTORY_NAME + File.separatorChar + "DataBase";
    private final String DATABASE_SCRIPT_EXPORT = "inmo_exporter.sh";
    private final String DATABASE_SCRIPT_IMPORT = "inmo_importer.sh";

    public BackUper(){
        zipper = new Zipper();
    }

    public void exportBackUp(File exportDirectory){
        if (!existDirectory(exportDirectory))
            throw new RuntimeException("No existe archivo"); //TODO cambiar por lógica de negocio exception

        String givenDirectory = exportDirectory.getAbsolutePath();

        createNewDirectory(DIRECTORY_NAME);

        //crear directorio de las fotos;
        createNewDirectory(PHOTOS_DIRECTORY);

        //copiar fotos al directorio
        copyPhotos(FTP_FOLDER, PHOTOS_DIRECTORY);

        //crear directorio de la base de datos
        createNewDirectory(DATABASE_DIRECTORY);

        //hacer backup de la base de datos y copiarlo en la carpeta
        executeCommandLineScript(DATABASE_SCRIPT_EXPORT);

        //Zipear
        zipper.zipIt(givenDirectory + File.separatorChar + OUTPUT_COMPRESS_FILE, DIRECTORY_NAME);

        //Borrar el directorio
        deleteDirectory(DIRECTORY_NAME);
    }

    public void importBackUp(File archivoZip){
        //crear carpeta
        createNewDirectory(DIRECTORY_NAME);
        //Corroborrar que sea un archivo .zip
        //UNZIP the file
        zipper.unzipIt(archivoZip.getAbsolutePath(), DIRECTORY_NAME);
        //Copiar imágenes en la carpeta de FTP
        copyPhotos(PHOTOS_DIRECTORY, FTP_FOLDER);
        //Correr script para cargar base de datos
        executeCommandLineScript(DATABASE_SCRIPT_IMPORT);
        //Borrar directorio
        deleteDirectory(DIRECTORY_NAME);
    }

    private boolean existDirectory(File directory_name) {
        return directory_name.isDirectory() && directory_name.exists();
    }

    private void createNewDirectory(String directory) {

        File direct = new File(directory);
        direct.mkdir();
    }

    private void copyPhotos(String fromDirectory, String toDirectory){
        File fromDirect= new File(fromDirectory);
        File toDirect = new File(toDirectory);
        try {
            FileUtils.copyDirectory(fromDirect, toDirect);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try {
            Runtime.getRuntime().exec("sh "+ script).waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

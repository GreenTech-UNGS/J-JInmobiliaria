package persistencia.backup;

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

public class Zipper{

    //TODO si existe el archivo, que borre el anterior
    public void zipIt(String outputName, String folderToZip){
        File root = new File(folderToZip);
        File result = new File(outputName);

        ZipUtil.pack(root, result);
    }

    public void unzipIt(String targetZip, String outputFolder ){

        File target = new File(targetZip);
        File output = new File(outputFolder);
        ZipUtil.unpack(target, output);
    }
}

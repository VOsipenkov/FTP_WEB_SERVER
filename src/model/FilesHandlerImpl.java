package model;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 21cmPC on 14.03.2017.
 */
public class FilesHandlerImpl implements FileHandler {
    private static final String filesPath = "C:\\workspace\\FTP_WEB_SERVER\\files";

    @Override
    public List<String> getFilesNames() {
        File filesFolder = new File(filesPath);

        if (filesFolder != null && filesFolder.exists()) {
            return getAllFilesInDir(filesFolder);
        } else if (filesFolder != null) {
            boolean success = filesFolder.mkdir();
            if (!success) {
                System.err.println("can't create files folder");
                return new LinkedList<>();
            }

            return getAllFilesInDir(filesFolder);
        }

        return new LinkedList<>();
    }

    private List<String> getAllFilesInDir(File file) {
        List list = new LinkedList();
        for (String item : file.list()) {
            list.add(item + "\n");
        }
        return list;
    }

    @Override
    public File getFile(String fileName) {
        return null;
    }

    @Override
    public boolean deleteFile(String fileName) {
        return false;
    }

    @Override
    public boolean addFile(File file) {
        return false;
    }
}

package model;

import java.io.*;
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

    @Override
    public boolean addFile(String name, InputStream inputStream) {
        File file = new File(filesPath + name);
        if (file.exists()) {
            file.delete();
        }

        try {
            boolean success = file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, read);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}

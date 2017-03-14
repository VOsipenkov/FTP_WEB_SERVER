package model;

import java.io.File;
import java.util.List;

/**
 * Created by 21cmPC on 14.03.2017.
 */
public class FilesHandlerImpl implements FileHandler {
    @Override
    public List<String> getFiles() {
        return null;
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

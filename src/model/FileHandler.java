package model;

import java.io.File;
import java.util.List;

/**
 * Created by 21cmPC on 14.03.2017.
 */
public interface FileHandler {

    public List<String> getFiles();

    public File getFile(String fileName);

    public boolean deleteFile(String fileName);

    public boolean addFile(File file);
}

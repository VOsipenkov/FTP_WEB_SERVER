package model;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by 21cmPC on 14.03.2017.
 */
public interface FileHandler {

    public List<String> getFilesNames();

    public byte[] getFile(String fileName);

    public boolean deleteFile(String fileName);

    public boolean addFile(String name, InputStream inputStream);
}

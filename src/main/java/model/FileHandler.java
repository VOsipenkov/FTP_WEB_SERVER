package model;

import java.io.InputStream;
import java.util.List;

public interface FileHandler {

    public List<String> getFilesNames();

    public List<String> getFilesNames(Filter filter);

    public byte[] getFile(String fileName);

    public boolean deleteFile(String fileName);

    public boolean addFile(String name, InputStream inputStream, Long size, String author);
}

package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 21cmPC on 29.03.2017.
 */
public class FileLoggerImpl implements FileLogger {
    private String path;

    public FileLoggerImpl(String path){
        this.path = path;
    }

    @Override
    public void log(String message) {
        try {
            Files.write(Paths.get(path), message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

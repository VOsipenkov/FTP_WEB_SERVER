package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoggerImpl implements FileLogger {
    private String path;

    public FileLoggerImpl(String path){
        this.path = path;
    }

    @Override
    public void log(String message) {
        try {
            Files.write(Paths.get(path), message.getBytes());
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

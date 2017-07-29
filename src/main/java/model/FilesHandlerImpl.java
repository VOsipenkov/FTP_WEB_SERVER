package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FilesHandlerImpl implements FileHandler {
    private String filesPath;

    public FilesHandlerImpl(String filesPath) {
        this.filesPath = filesPath;
    }

    @Override
    public List<String> getFilesNames() {
        File filesFolder = new File(filesPath);

        if (filesFolder != null && filesFolder.exists()) {
            return getAllFilesInDir(filesFolder);
        } else if (filesFolder != null) {
            boolean isSuccess = filesFolder.mkdir();
            if (!isSuccess) {
                System.err.println("can't create files folder");
                return Collections.emptyList();
            }

            return getAllFilesInDir(filesFolder);
        }

        return Collections.emptyList();
    }

    @Override
    public List<String> getFilesNames(Filter filter) {
        List<String> filteredNames = getFilesNames();

        if (filter.isContainsNumber()) {
            List<String> pointResult = new ArrayList<>();
            for (String name : filteredNames){
                if (name.matches(".*\\d+.*\n*")){
                    pointResult.add(name);
                }
            }
            filteredNames = pointResult;
        }
        if (filter.isContainsChar()){
            List<String> pointResult = new ArrayList<>();
            for (String name : filteredNames){
                if (name.matches(".*\\D+.*\n*")){
                    pointResult.add(name);
                }
            }
            filteredNames = pointResult;
        }
        if (filter.getContainsWord() != null){
            List<String> pointResult = new ArrayList<>();
            for (String name : filteredNames){
                if (name.contains(filter.getContainsWord())){
                    pointResult.add(name);
                }
            }
            filteredNames = pointResult;
        }

        return filteredNames;
    }

    private List<String> getAllFilesInDir(File file) {
        List list = new LinkedList();
        for (String item : file.list()) {
            list.add(item + "\n");
        }
        return list;
    }

    @Override
    public byte[] getFile(String fileName) {
        fileName = fileName.replace("\r", "").replace("\n", "").trim();
        Path path = Paths.get(filesPath + fileName);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[1];
    }

    @Override
    public boolean deleteFile(String fileName) {
        fileName = fileName.replace("\r", "").replace("\n", "").trim();
        File file = new File(filesPath + fileName);
        if (file.exists()) {
            return file.delete();
        }

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
            fileOutputStream.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

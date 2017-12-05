package model.DataBase;

import model.FileHandler;
import model.Filter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DbFileHandlerImpl implements FileHandler {
    private Connection connection;

    public DbFileHandlerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<String> getFilesNames() {
        List<String> fileNames = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_FILE_NAMES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fileNames.add(resultSet.getString("name_f"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fileNames;
    }

    @Override
    public List<String> getFilesNames(Filter filter) {
        return null;
    }

    @Override
    public byte[] getFile(String fileName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_FILE);
            preparedStatement.setString(1, fileName.trim());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Blob blob = resultSet.getBlob("file");
            InputStream inputStreamFromDb = blob.getBinaryStream();
            byte[] bytes = IOUtils.toByteArray(inputStreamFromDb);
//todo but how can I read .exe and .dll???
            return bytes;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    @Override
    public boolean deleteFile(String fileName) {
        return false;
    }

    @Override
    public boolean addFile(String name, InputStream inputStream, Long size, String author) {
        boolean status = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_FILE);
            preparedStatement.setString(1, name);
            preparedStatement.setBlob(2, inputStream);
            preparedStatement.setLong(4, size);
            preparedStatement.setString(5, author);

            Date date = new Date();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            preparedStatement.setLong(3, timestamp.getTime());

            preparedStatement.executeUpdate();
            System.out.print("File successful added in database..");
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}

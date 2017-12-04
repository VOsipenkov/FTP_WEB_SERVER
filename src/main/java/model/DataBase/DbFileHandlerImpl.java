package model.DataBase;

import model.FileHandler;
import model.Filter;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DbFileHandlerImpl implements FileHandler {
    private Connection connection;

    public DbFileHandlerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<String> getFilesNames() {
        return null;
    }

    @Override
    public List<String> getFilesNames(Filter filter) {
        return null;
    }

    @Override
    public byte[] getFile(String fileName) {
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

package model.DataBase;

public class Queries {
    public static final String ADD_FILE = "INSERT INTO files (name_f, file, date_update, size, author) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_AUTHOR = "SELECT * FORM users WHERE login = ?";
    public static final String ADD_AUTHOR = "INSERT INTO users (login) VALUES (?)s";
}


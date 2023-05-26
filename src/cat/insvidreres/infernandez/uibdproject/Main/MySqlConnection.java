package cat.insvidreres.infernandez.uibdproject.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnection {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try (FileInputStream fis = new FileInputStream("C:\\IdeaProjects\\UI-BD-Project\\src\\cat\\insvidreres\\infernandez\\uibdproject\\connection.properties")) {
            //TODO
            Properties pros = new Properties();
            pros.load(fis);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");

            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            System.out.println("I/O Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}

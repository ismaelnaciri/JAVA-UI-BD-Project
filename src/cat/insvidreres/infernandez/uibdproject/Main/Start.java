package cat.insvidreres.infernandez.uibdproject.Main;

import cat.insvidreres.infernandez.uibdproject.UI.WindowManager;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Start {

    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        connection = MySqlConnection.getConnection();

        try {
            System.out.printf("Conected to database %s" + " successfully. %n", connection.getCatalog());


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("GG");

            if (connection.isClosed())
                System.out.println("Connection closed");
        }


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new WindowManager();
                } catch (SQLException | IOException e) {
                    System.out.println("Error running the program: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    public static Connection getConnection() { return connection; }
}

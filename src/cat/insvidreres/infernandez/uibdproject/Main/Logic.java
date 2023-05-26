package cat.insvidreres.infernandez.uibdproject.Main;

import cat.insvidreres.infernandez.uibdproject.Classes.ReservationList;
import cat.insvidreres.infernandez.uibdproject.Classes.ReservationMaker;
import cat.insvidreres.infernandez.uibdproject.Classes.ReservationSearcher;

import static cat.insvidreres.infernandez.uibdproject.Classes.ReservationSearcher.*;
import static cat.insvidreres.infernandez.uibdproject.Classes.ReservationList.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Logic implements ActionListener {

    private static Connection connection = Start.getConnection();
    private static String SQLsentence;
    private PreparedStatement preparedStatement;
    private int idDiscriminator = 0;
    public static Statement statement;
    public static ResultSet resultSet;


//    public List<String> nameList = new ArrayList<String>();
//    public List<String> emailList = new ArrayList<String>();
//    public List<String> phoneList = new ArrayList<String>();

    public Logic(ActionEvent e){
        this.actionPerformed(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed");
        if (e.getActionCommand().equals("Make Reservation")) {
            try {
            String tempName = ReservationMaker.getNameField().getText();
            String tempEmail = ReservationMaker.getEmailField().getText();
            String tempPhone = ReservationMaker.getPhoneField().getText();
            postReservation(tempName, tempEmail, tempPhone);
            } catch (SQLException | IOException err) {
                System.out.println("Error: " + err.getMessage());
                err.printStackTrace();
            }
        }
        if (e.getActionCommand().equals("Search")) {
            try {
                String tempName = ReservationSearcher.searchInput.getText();
                this.searchByName(tempName);
            } catch (SQLException err) {
                System.out.println("Error: " + err.getMessage());
                err.printStackTrace();
            }
        }
        if (e.getActionCommand().equals("Get All Reservations")) {
            show();
        }
    }

    private void show() {
        System.out.println("TEST");
        table.setVisible(true);
        scrollPane.setVisible(true);
        panel3.setVisible(true);
    }

    public void postReservation(String name, String phone, String email) throws SQLException, IOException {
        System.out.println("DEBUG");
        idDiscriminator = getHighestIndex();
        idDiscriminator++;

        SQLsentence = "INSERT INTO `project-java-bd`.reservelist "
                    + "VALUES (?, ?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(SQLsentence);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, idDiscriminator);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, email);

        byte[] fileContent = ReservationMaker.convertFileToByte();
        Blob temp = ReservationMaker.getImg();
        temp = connection.createBlob();
        temp.setBytes(1, fileContent);

        preparedStatement.setBlob(5, temp);

        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing insert statement: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("End of insert");
        commonPart();
        preparedStatement.close();
    }

    public void commonPart() throws SQLException {
        if (!connection.isClosed())
            System.out.println("Connected successfully");
    }

    public int getHighestIndex() throws SQLException {
        int index = 0;
        SQLsentence = "SELECT MAX(id) FROM reservelist";

        statement = connection.createStatement();
        resultSet = statement.executeQuery(SQLsentence);

        while (resultSet.next()) {
            index = resultSet.getInt(1);
        }
        return index;
    }

    public void searchByName(String name) throws SQLException {
        SQLsentence = "SELECT * FROM reservelist WHERE nom = ?";
        preparedStatement = connection.prepareStatement(SQLsentence);

        preparedStatement.setString(1, name.toLowerCase());
        resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            String nomTrobat = resultSet.getString("nom");
            String emailTrobat = resultSet.getString("email");
            String telefonTrobat = resultSet.getString("telefon");
            byte[] foto = resultSet.getBytes("imatge");

            ReservationSearcher.name.setText(nomTrobat);
            email.setText(emailTrobat);
            phone.setText(telefonTrobat);
            imageIcon = new ImageIcon(foto);
            image = ReservationSearcher.imageIcon.getImage()
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            resizedImage = new ImageIcon(ReservationSearcher.image);
            iconLabel.setIcon(ReservationSearcher.resizedImage);
            iconLabel.setPreferredSize(new Dimension(300, 150));


            showResultsOfQuery();
        }

    }

    public void showResultsOfQuery() {
        nameLabel.setVisible(true);
        emailLabel.setVisible(true);
        phoneLabel.setVisible(true);
        imageLabel.setVisible(true);

        ReservationSearcher.name.setVisible(true);
        email.setVisible(true);
        phone.setVisible(true);
        iconLabel.setVisible(true);

        panel2.setVisible(true);
    }

    public static DefaultTableModel buildTableModel() throws SQLException {
        SQLsentence = "SELECT * FROM reservelist";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(SQLsentence);
        
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<String>();
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(metaData.getColumnLabel(i + 1));
        }

        List<Vector<Object>> data = new ArrayList<>();

        while (resultSet.next()) {
            Vector<Object> rowData = new Vector<>();
            for (int i = 0; i < columnCount; i++) {
                rowData.add(resultSet.getObject(i + 1));
            }
            data.add(rowData);
        }

        return new DefaultTableModel(new Vector<>(data), columnNames);
    }

}

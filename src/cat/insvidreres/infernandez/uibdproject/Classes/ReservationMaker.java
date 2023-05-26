package cat.insvidreres.infernandez.uibdproject.Classes;

import cat.insvidreres.infernandez.uibdproject.Main.Logic;
import cat.insvidreres.infernandez.uibdproject.Main.MySqlConnection;
import cat.insvidreres.infernandez.uibdproject.UI.WindowManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class ReservationMaker extends JPanel {

    static JLabel nameLabel, emailLabel, phoneLabel, passwordLabel, imageLabel;
    static JTextField nameField, emailField, phoneField;
    static JPasswordField passwordField;
    static Blob img;
    static JButton imgChooser, sendButton;
    static File selectedFile;
    static JFileChooser fileChooser;

    public Logic logic;


    public ReservationMaker(JPanel panel) {
        panel.setLayout(new GridLayout(6, 2));
        nameLabel = new JLabel("Name: ");
        panel.add(nameLabel);
        nameField = new JTextField("name placeholder");
        panel.add(nameField);
        emailLabel = new JLabel("Email: ");
        panel.add(emailLabel);
        emailField = new JTextField("email placeholder");
        panel.add(emailField);
        phoneLabel = new JLabel("Phone: ");
        panel.add(phoneLabel);
        phoneField = new JTextField("phone placeholder");
        panel.add(phoneField);
        passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);
        passwordField = new JPasswordField("placeholder");
        panel.add(passwordField);
        imageLabel = new JLabel("Image: ");
        panel.add(imageLabel);
        imgChooser = new JButton("Choose image");
        imgChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imgChooserActionPerformed(e);
            }
        });
        panel.add(imgChooser);

        panel.add(new JLabel());
        sendButton = new JButton("Make Reservation");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                logic = new Logic(e);
                if (e.getActionCommand().equals("Make Reservation")) {
                    logic = new Logic(e);
                }
            }
        });
        panel.add(sendButton);

        add(panel);
        panel.repaint();
    }

    private void imgChooserActionPerformed(ActionEvent e) {
        fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

    }

    public static byte[] convertFileToByte() throws IOException {
        byte[] data = new byte[(int) selectedFile.length()];
        try (FileInputStream fis = new FileInputStream(selectedFile)){
            fis.read(data);
            img = MySqlConnection.getConnection().createBlob();
            img.setBytes(1, data);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }


    public static JLabel getNameLabel() {
        return nameLabel;
    }

    public static JLabel getEmailLabel() {
        return emailLabel;
    }

    public static JLabel getPhoneLabel() {
        return phoneLabel;
    }

    public static JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public static JLabel getImageLabel() {
        return imageLabel;
    }

    public static JTextField getNameField() {
        return nameField;
    }

    public static JTextField getEmailField() {
        return emailField;
    }

    public static JTextField getPhoneField() {
        return phoneField;
    }

    public static JPasswordField getPasswordField() {
        return passwordField;
    }

    public static Blob getImg() {
        return img;
    }

    public static JButton getImgChooser() {
        return imgChooser;
    }

    public static JButton getSendButton() {
        return sendButton;
    }

    public static File getSelectedFile() {
        return selectedFile;
    }

}

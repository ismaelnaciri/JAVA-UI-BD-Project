package cat.insvidreres.infernandez.uibdproject.Classes;

import cat.insvidreres.infernandez.uibdproject.Main.Logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class ReservationSearcher extends JPanel {

    private JLabel searchLabel;
    public static JLabel name, email, phone;
    public static JLabel nameLabel, emailLabel, phoneLabel, imageLabel;
    public static JTextField searchInput;
    private JButton searchButton;
    Logic logic;
    public static ImageIcon imageIcon, resizedImage;
    public static Image image;
    public static JPanel panel2;
    public static JLabel iconLabel;


    public ReservationSearcher(JPanel panel) throws SQLException, IOException {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        searchLabel = new JLabel("Search by name: ");
        panel.add(searchLabel);
        searchInput = new JTextField();
        searchInput.setPreferredSize(new Dimension(200, 30));
        panel.add(searchInput);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Search")) {
                    logic = new Logic(e);
                }
            }
        });
        panel.add(searchButton);


        panel2 = new JPanel(new GridLayout(4, 2));
        panel2.setPreferredSize(new Dimension(2 * 100, 4 * 50));

        nameLabel = new JLabel("Name: ");
        nameLabel.setVisible(false);
        panel2.add(nameLabel);

        name = new JLabel();
        name.setVisible(false);
        panel2.add(name);

        emailLabel = new JLabel("Email: ");
        emailLabel.setVisible(false);
        panel2.add(emailLabel);

        email = new JLabel();
        email.setVisible(false);
        panel2.add(email);

        phoneLabel = new JLabel("Phone: ");
        phoneLabel.setVisible(false);
        panel2.add(phoneLabel);

        phone = new JLabel();
        phone.setVisible(false);
        panel2.add(phone);

        imageLabel = new JLabel("Image: ");
        imageLabel.setVisible(false);
        panel2.add(imageLabel);

        iconLabel = new JLabel();
        iconLabel.setVisible(false);
        panel2.add(iconLabel);

        panel2.setVisible(false);

        panel.add(panel2);
        add(panel);
    }

}

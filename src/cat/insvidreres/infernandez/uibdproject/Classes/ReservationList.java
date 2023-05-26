package cat.insvidreres.infernandez.uibdproject.Classes;

import cat.insvidreres.infernandez.uibdproject.Main.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReservationList extends JPanel {

    String[] headers = { "Name", "Reservation ID", "Telefon"};

//    Object[][] data = new Object[][];
    public static boolean showTable = false;

    public static JTable table;
    public static JScrollPane scrollPane;
    public JButton showListButton;
    private Logic logic;

    public static JPanel panel3;

    public ReservationList(JPanel panel) throws SQLException {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        showListButton = new JButton("Get All Reservations");
        showListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic = new Logic(e);
            }
        });
        panel.add(showListButton);

        panel3 = new JPanel();

        table = new JTable(Logic.buildTableModel());
        table.setVisible(false);

        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 100));
        scrollPane.setVisible(false);
        panel3.add(scrollPane);

        panel3.setVisible(false);

        panel.add(panel3);
        add(panel);
    }

}

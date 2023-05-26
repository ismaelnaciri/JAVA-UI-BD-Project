package cat.insvidreres.infernandez.uibdproject.UI;

import cat.insvidreres.infernandez.uibdproject.Classes.ReservationList;
import cat.insvidreres.infernandez.uibdproject.Classes.ReservationMaker;
import cat.insvidreres.infernandez.uibdproject.Classes.ReservationSearcher;
import cat.insvidreres.infernandez.uibdproject.Main.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class WindowManager implements ActionListener {
    public static JFrame frame;

    Font font = new Font("Serif", Font.BOLD, 14);

    public JPanel panel1 = new JPanel(new GridLayout(5, 2, 10, 10));
    public JPanel panel2 = new JPanel(new GridLayout(3, 2, 10, 10));
    public JPanel panel3 = new JPanel();
    public ReservationMaker firstTab = new ReservationMaker(panel1);
    public ReservationSearcher secondTab = new ReservationSearcher(panel2);
    public ReservationList thirdTab = new ReservationList(panel3);
    public static Logic logic;

    public static JTabbedPane tabbedPane;
    public WindowManager() throws SQLException, IOException {
        frame = new JFrame("Java-UI-Project");
        Color color = new Color(147, 191, 192);
        frame.setBackground(color);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);

        tabbedPane = new JTabbedPane();


        tabbedPane.addTab("Fer Reserva", firstTab);

        tabbedPane.addTab("Reserva", secondTab);
        tabbedPane.addTab("Llista", thirdTab);

        frame.add(tabbedPane);
        frame.setSize(900, 500);
//        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        logic = new Logic(e);
    }


}

package cat.insvidreres.infernandez.uibdproject.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign Up Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton signUpButton = new JButton("Sign Up");

        // Create panel and set layout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(signUpButton);

        // Add panel to the frame
        frame.getContentPane().add(panel);

        // Add sign-up button action listener
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform sign-up logic here
                String name = nameField.getText();
                String email = emailField.getText();
                char[] password = passwordField.getPassword();

                // Display a message dialog with sign-up details
                String message = "Name: " + name + "\nEmail: " + email + "\nPassword: " + new String(password);
                JOptionPane.showMessageDialog(frame, message, "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE);

                // Clear form fields after sign-up
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}

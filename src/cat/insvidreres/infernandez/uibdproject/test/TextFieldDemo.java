// Use a text field.
package cat.insvidreres.infernandez.uibdproject.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldDemo implements ActionListener {

	JTextField jtf;
	JButton jbtnRev;
	JLabel jlabPrompt, jlabContents;
	
	TextFieldDemo() {
		
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("Use a Text Field");
		
		// Specify FlowLayout for the layout manager.
		jfrm.setLayout(new FlowLayout());
				
		// Give the frame an initial size.
		jfrm.setSize(240, 120);
				
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a text field.
		jtf = new JTextField(10);
		
		// Set the action commands for the text field.
		jtf.setActionCommand("myTextField");
		
		// Create the Reverse button.
		JButton jbtnRev = new JButton("Reverse");
		
		// Add action listeners.
		jtf.addActionListener(this);
		jbtnRev.addActionListener(this);
		
		// Create labels.
		jlabPrompt = new JLabel("Enter text: ");
		jlabContents = new JLabel("");
		
		// Add components to the content pane.
		jfrm.add(jlabPrompt);
		jfrm.add(jtf);
		jfrm.add(jbtnRev);
		jfrm.add(jlabContents);
		
		// Display the frame.
		jfrm.setVisible(true);
	}
	
	// Handle action events.
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Reverse")) {
			// The Reverse button was pressed.
			String orgStr = jtf.getText();
			String resStr = "";
			
			// Reverse the string in the text field.
			for(int i = orgStr.length()-1; i >= 0; i--)
				resStr += orgStr.charAt(i);
			
			// Store the reversed string in the text field.
			jtf.setText(resStr);
		} else
			// Enter was pressed while focus was in the text field
			jlabContents.setText("You pressed ENTER. Text is: " +
								 jtf.getText());
	}
	
	public static void main(String[] args) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TextFieldDemo();		
			}
		});
	}
}




// Demonstrate a simple JList.
package cat.insvidreres.infernandez.uibdproject.test;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo implements ListSelectionListener {
	
	JList<String> jlst;
	JLabel jlab;
	JScrollPane jscrlp;
	
	// Create an array of names.
	String names[] = {	"Alex", "Pau", "Dani",
						"Òscar", "Salihu", "Arnau",
						"Aram", "Isma", "Marc",
						"Ian", "Gerard", "Hèctor"};
	ListDemo() {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("JList Demo");
		
		// Specify FlowLayout for the layout manager.
		jfrm.setLayout(new FlowLayout());
				
		// Give the frame an initial size.
		jfrm.setSize(200, 160);
				
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a JList.
		jlst = new JList<String>(names);
		
		// Set the list selection mode to single-selection.
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Add list to scroll pane.
		jscrlp = new JScrollPane(jlst);
		
		// Set preferred size of the scroll pane.
		jscrlp.setPreferredSize(new Dimension(120, 90));
		
		// Make a label that displays the selection.
		jlab = new JLabel("Please choose a name");
		
		// Add list selection handler.
		jlst.addListSelectionListener(this);
		
		// Add the list and label to the content pane.
		jfrm.add(jscrlp);
		jfrm.add(jlab);
		
		// Display the frame.
		jfrm.setVisible(true);
	}
	
	// Handle list selection events.
	@Override
	public void valueChanged(ListSelectionEvent le) {
		// Get the index of the changed item.
		int idx = jlst.getSelectedIndex();
		
		// Display selection, if item was selected.
		if(idx != -1)
			jlab.setText("Current selection: " + names[idx]);
		else // Otherwise, reprompt.
			jlab.setText("Please choose a name");
	}
	
	public static void main(String[] args) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ListDemo();		
			}
		});
	}
}



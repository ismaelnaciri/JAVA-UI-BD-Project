// Demonstrate JTable.
package cat.insvidreres.infernandez.uibdproject.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class JTableDemo {
	
	// Initialize column headings.
	String[] colHeads = { "Name", "Extension", "ID#"};
	
	// Initialize data.
	Object[][] data = {
		{ "Alex", "4567", "865" },
		{ "Pau", "7566", "555" },
		{ "Dani", "5634", "587" },
		{ "Òscar", "1356", "922" },
		{ "Arnau", "5656", "333" },
		{ "Aram", "5672", "314" },
		{ "Isma", "6741", "217" },
		{ "Marc", "9023", "444" },
		{ "Ian", "1134", "519" },
		{ "Gerard", "9030", "532" },
		{ "Hèctor", "6751", "112" }
	};
	
	public JTableDemo() {

		// Set up the JFrame. Use the default BorderLayout.
		JFrame jfrm = new JFrame("JTreeDemo");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(300, 200);
		
		// Create the table.
		JTable table = new JTable(data, colHeads);
		
		// Add the table to a scroll pane.
		JScrollPane jsp =  new JScrollPane(table);
		
		// Add the scroll to the content pane.
		jfrm.add(jsp);
		
		// Display the frame.
		jfrm.setVisible(true);
	}
	
	public static void main(String[] args) {
		// Create the frame on the event dispatching thread.
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JTableDemo();
			}
		});

	}

}

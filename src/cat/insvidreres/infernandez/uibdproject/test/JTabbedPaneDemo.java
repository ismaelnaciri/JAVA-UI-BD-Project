// Demonstrate JTabbedPane.
package cat.insvidreres.infernandez.uibdproject.test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedPaneDemo {
	
	public JTabbedPaneDemo() {

		// Set up the JFrame.
		JFrame jfrm = new JFrame("JTabbedPaneDemo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(400, 200);
		
		// Create a tabbed pane.
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Cities", new CitiesPanel());
		jtp.addTab("Colors", new ColorsPanel());
		jtp.addTab("Flavours", new FlavorsPanel());
		jfrm.add(jtp);
		
		// Display the frame.
		jfrm.setVisible(true);
	}
	
	public static void main(String[] args) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JTabbedPaneDemo();
			}
		});
	}
}

// Make the panels that will be added to the tabbed pane.
class CitiesPanel extends JPanel {
	
	public CitiesPanel() {
		JButton b1 = new JButton("New York");
		add(b1);
		JButton b2 = new JButton("London");
		add(b2);
		JButton b3 = new JButton("Hong Kong");
		add(b3);
		JButton b4 = new JButton("Tokyo");
		add(b4);
	}
	
}

class ColorsPanel extends JPanel {
	
	public ColorsPanel() {
		JCheckBox cb1 = new JCheckBox("Red");
		add(cb1);
		JCheckBox cb2 = new JCheckBox("Green");
		add(cb2);
		JCheckBox cb3 = new JCheckBox("Blue");
		add(cb3);
	}
}

class FlavorsPanel extends JPanel {
	
	public FlavorsPanel() {
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Vanilla");
		jcb.addItem("Chocolate");
		jcb.addItem("Strawberry");
		add(jcb);
	}
}

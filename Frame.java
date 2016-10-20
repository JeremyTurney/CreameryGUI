import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;


public class Frame extends JFrame {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame f = new JFrame();
		f.setTitle("MP Creamery: Order Entry");
		f.setSize(350, 350);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel main = new JPanel();
		f.getContentPane().add(main);
		
		JPanel size = new JPanel();
		size.setBorder(new TitledBorder(null, "Size", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JRadioButton small = new JRadioButton("Small");
		size.add(small);
		
		JRadioButton large = new JRadioButton("Large");
		size.add(large);
		
		JPanel tops = new JPanel();
		tops.setBorder(new TitledBorder(null, "Toppings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JCheckBox chckbxPeanuts = new JCheckBox("Peanuts");
		tops.add(chckbxPeanuts);
		
		JCheckBox chckbxHotFudge = new JCheckBox("Hot Fudge");
		tops.add(chckbxHotFudge);
		
		JCheckBox chckbxWhippedCream = new JCheckBox("Whipped Cream");
		tops.add(chckbxWhippedCream);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setAction(action);
		
		JButton btnDoneForThe = new JButton("Done for the day");
		GroupLayout gl_main = new GroupLayout(main);
		gl_main.setHorizontalGroup(
			gl_main.createParallelGroup(Alignment.TRAILING)
				.addComponent(tops, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_main.createSequentialGroup()
					.addComponent(btnSubmit)
					.addGap(18)
					.addComponent(btnDoneForThe)
					.addGap(47))
				.addGroup(gl_main.createSequentialGroup()
					.addComponent(size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);
		gl_main.setVerticalGroup(
			gl_main.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_main.createSequentialGroup()
					.addComponent(size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(tops, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnDoneForThe))
					.addGap(139))
		);
		main.setLayout(gl_main);
		f.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{f.getContentPane(), main, size, small, large, tops, chckbxPeanuts, chckbxHotFudge, chckbxWhippedCream, btnSubmit, btnDoneForThe}));
		
		
		
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

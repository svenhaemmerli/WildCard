//package ch.fhnw.haggis.deprecated;
//
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//class SelectServerDialog extends JDialog {
//	public SelectServerDialog(JFrame parent) {
//		super(parent, "Server-IP", true);
//		Container cp = getContentPane();
//		cp.setLayout(new FlowLayout());
//		cp.add(new JLabel("Your servers IP:"));
//		JButton ok = new JButton("OK");
//		ok.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose(); // Closes the dialog
//			}
//		});
//		cp.add(ok);
//		setSize(150, 125);
//	}
//}
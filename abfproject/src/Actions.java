import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Actions extends JFrame implements ActionListener{
	
	Container contentPane = getContentPane();
	
	JPanel pnl=new JPanel();
	JPanel pnlB=new JPanel();
	
	JLabel info=new JLabel("<html>Name:  IIT Bank and Trust Company<br>"
		+"Location:  3300 S. Federal, Chicago, IL 60616<br>"
		+"Telephone: 312-567-3000 <br>"
		+"Contact Person: Katherine Papademas"
		+ "</html>", SwingConstants.CENTER);
	JButton btn=new JButton("Start");
	
	public Actions(){
		super("Swing Window");
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		
		pnl.add(info);
		pnlB.add(btn);
		
		btn.addActionListener(this);
		
		contentPane.add("North", pnl );
		contentPane.add("South", pnlB );
		
		add(pnl);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		new PinPad();
	}
}

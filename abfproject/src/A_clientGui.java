import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class A_clientGui extends JFrame implements ActionListener{	
	JLabel ques=new JLabel("In what account would you like to make transaction?", SwingConstants.CENTER);
	
	JPanel pnl=new JPanel();
	JPanel quesAndB=new JPanel();
	JPanel buttons=new JPanel();
	
	JButton checki=new JButton("Checking");
	JButton savi=new JButton("Savings");
	JButton loa=new JButton("Loan Payment");
	
	public A_clientGui(){
		super("Swing Window");
		setSize(350,180);
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		
		buttons.add(checki);
		buttons.add(savi);
		buttons.add(loa);
		
		quesAndB.setLayout(new BorderLayout());
		quesAndB.add(ques, BorderLayout.CENTER);
		quesAndB.add(buttons, BorderLayout.SOUTH);
		
		pnl.setLayout(new BorderLayout());
		pnl.add(quesAndB);
		
		checki.addActionListener(this);
		savi.addActionListener(this);
		loa.addActionListener(this);
		
		add(pnl);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==checki){
			JOptionPane.showMessageDialog(new JFrame(),"<html>"+Z_Client.displayCheck()+"<br>"+Z_Client.displaySav()+"<br>"+Z_Client.displayLoan()+"</html>");
			new B_checkingGui();
		}
		else if(arg0.getSource()==savi){
			JOptionPane.showMessageDialog(new JFrame(),"<html>"+Z_Client.displayCheck()+"<br>"+Z_Client.displaySav()+"<br>"+Z_Client.displayLoan()+"</html>");
			new C_savingGui();
		}
		else if(arg0.getSource()==loa){
			JOptionPane.showMessageDialog(new JFrame(),"<html>"+Z_Client.displayCheck()+"<br>"+Z_Client.displaySav()+"<br>"+Z_Client.displayLoan()+"</html>");
			new D_loanGui();
		}
	}
}

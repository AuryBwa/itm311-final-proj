import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class D_loanGui extends JFrame implements ActionListener{
	JLabel lbl=new JLabel("Are you making a payment on your loan",SwingConstants.CENTER);
	
	
	JPanel pnlC=new JPanel();
	JPanel buttons=new JPanel();
	
	JButton y=new JButton("Yes");
	JButton n=new JButton("No");
	public D_loanGui(){
		super("Loan Payment");
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlC.setLayout(new BorderLayout());
		pnlC.add(lbl, BorderLayout.CENTER);
		pnlC.add(buttons, BorderLayout.SOUTH);
		
		buttons.add(y);
		buttons.add(n);
		
		y.addActionListener(this);
		n.addActionListener(this);
		
		add(pnlC);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==y){
			String input=JOptionPane.showInputDialog(new JFrame(), "How much are you paying on your loan?");
			if(input!=null){
				Double res=Double.parseDouble(input);	
				Z_Client.makeLoanPayment(res);
				JOptionPane.showMessageDialog(new JFrame(),Z_Client.displayLoan());
				int selectedOption = JOptionPane.showConfirmDialog(null, 
					"Are you done with your transaction?", 
					"Choose", 
					JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(),"<html>"+Z_Client.displayCheck()+"<br>"+Z_Client.displaySav()+"<br>"+Z_Client.displayLoan()+"</html>");
				}
			}
		}
		else if(e.getSource()==n){
			this.dispose();
		}
	}	
}

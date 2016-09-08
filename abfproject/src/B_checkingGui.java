import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class B_checkingGui extends JFrame implements ActionListener{
	JLabel lbl=new JLabel("Do you want to withdraw or deposit?",SwingConstants.CENTER);
	
	JPanel pnlC=new JPanel();
	JPanel buttons=new JPanel();
	
	JButton withdraw=new JButton("Withdraw");
	JButton deposit=new JButton("Deposit");
	JButton cancel=new JButton("Cancel");
	
	public B_checkingGui(){
		super("Checkings Account");
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlC.setLayout(new BorderLayout());
		pnlC.add(lbl, BorderLayout.CENTER);
		pnlC.add(buttons, BorderLayout.SOUTH);
		
		buttons.add(withdraw);
		buttons.add(deposit);
		buttons.add(cancel);
		
		withdraw.addActionListener(this);
		deposit.addActionListener(this);
		cancel.addActionListener(this);
		
		add(pnlC);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw){
			String input=JOptionPane.showInputDialog(new JFrame(), "How much are you withdrawing from your checking account?");
			if(input!=null){
				Double res=Double.parseDouble(input);	
				Z_Client.withdrawCheck(res);
				if(Z_Client.getBalanceCheck()>500){
					JOptionPane.showMessageDialog(new JFrame(),Z_Client.displayCheck());
					int selectedOption = JOptionPane.showConfirmDialog(null, 
						"Are you done with your transactions?", 
						"Choose", 
						JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"<html>"+Z_Client.displayCheck()+"<br>"+Z_Client.displaySav()+"<br>"+Z_Client.displayLoan()+"</html>");
					}
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "Your balance has gone below $500.00", "Warning", JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(new JFrame(),Z_Client.displayCheck());
				}
			}
		}
		else if(e.getSource()==deposit){
			String input=JOptionPane.showInputDialog(new JFrame(), "How much are you depositing to your checking account?");
			if(input!=null){
				Double res=Double.parseDouble(input);	
				Z_Client.depositCheck(res);
				JOptionPane.showMessageDialog(new JFrame(),Z_Client.displayCheck());
				int selectedOption = JOptionPane.showConfirmDialog(null, 
					"Are you done with your transactions?", 
					"Choose", 
					JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(),"<html>"+Z_Client.displayCheck()+"<br>"+Z_Client.displaySav()+"<br>"+Z_Client.displayLoan()+"</html>");
				}
			}
		}
		
		else if(e.getSource()==cancel){
			this.dispose();
		}
	}	
}

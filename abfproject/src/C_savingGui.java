import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class C_savingGui extends JFrame implements ActionListener{
	JLabel lbl=new JLabel("Do you want to with or dep?",SwingConstants.CENTER);
	
	Z_Client Z_Client=new Z_Client();
	
	JPanel pnlC=new JPanel();
	JPanel buttons=new JPanel();
	
	JButton with=new JButton("Withdraw");
	JButton dep=new JButton("Deposit");
	JButton canc=new JButton("Cancel");
	
	public C_savingGui(){
		super("Savings Account");
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlC.setLayout(new BorderLayout());
		pnlC.add(lbl, BorderLayout.CENTER);
		pnlC.add(buttons, BorderLayout.SOUTH);
		
		buttons.add(with);
		buttons.add(dep);
		buttons.add(canc);
		
		with.addActionListener(this);
		dep.addActionListener(this);
		canc.addActionListener(this);
		
		add(pnlC);
		
		setVisible(true);
	}
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==with){
			String input=JOptionPane.showInputDialog(new JFrame(), "How much are you withdrawing from your checking account?");
			if(input!=null){
				Double res=Double.parseDouble(input);	
				Z_Client.withdrawSav(res);
				if(Z_Client.getBalanceCheck()>500){
					JOptionPane.showMessageDialog(new JFrame(),Z_Client.displaySav());
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
					JOptionPane.showMessageDialog(new JFrame(),Z_Client.displaySav());
				}
			}
		}
		else if(e.getSource()==dep){
			String input=JOptionPane.showInputDialog(new JFrame(), "How much are you depositing to your checking account?");
			if(input!=null){
				Double res=Double.parseDouble(input);	
				Z_Client.depositSav(res);
				JOptionPane.showMessageDialog(new JFrame(),Z_Client.displaySav());
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
		
		else if(e.getSource()==canc){
			this.dispose();
		}
	}	
}

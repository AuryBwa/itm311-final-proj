import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class PinPad extends JFrame implements ActionListener{
	JPanel mainP=new JPanel();
	JPanel lablP=new JPanel();
	JPanel pnlN=new JPanel();
	JPanel buttonP=new JPanel();
	JLabel pinL=new JLabel("Enter PIN: ",SwingConstants.CENTER);
	JLabel welc=new JLabel("Welcome to IIT Trust Bank!",SwingConstants.CENTER);
	JPasswordField pw=new JPasswordField(4);
	
	JButton button0=new JButton(0+"");
	JButton button1=new JButton(1+"");
	JButton button2=new JButton(2+"");
	JButton button3=new JButton(3+"");
	JButton button4=new JButton(4+"");
	JButton button5=new JButton(5+"");
	JButton button6=new JButton(6+"");
	JButton button7=new JButton(7+"");
	JButton button8=new JButton(8+"");
	JButton button9=new JButton(9+"");
	JButton ent=new JButton("Enter");
	JButton backsp=new JButton("<--");
	
	public PinPad() {
		super("Swing Window");
		setSize(300,210);
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		
		lablP.setLayout(new BorderLayout());
		lablP.add(welc,BorderLayout.NORTH);
		lablP.add(pinL,BorderLayout.CENTER);
		lablP.add(pw,BorderLayout.SOUTH);
		
		buttonP.add(button1);
		buttonP.add(button2);
		buttonP.add(button3);
		buttonP.add(button4);
		buttonP.add(button5);
		buttonP.add(button6);
		buttonP.add(button7);
		buttonP.add(button8);
		buttonP.add(button9);
		buttonP.add(ent);
		buttonP.add(button0);
		buttonP.add(backsp);
		
		buttonP.setLayout(new GridLayout(4,3,8,2));
		
		mainP.setLayout(new BorderLayout());
		mainP.add(lablP,BorderLayout.CENTER);
		mainP.add(buttonP,BorderLayout.SOUTH);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		ent.addActionListener(this);
		backsp.addActionListener(this);
		add(mainP);
		
		setVisible(true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button0){
			pw.replaceSelection(button0.getText());
		}
		else if(e.getSource()==button1){
			pw.replaceSelection(button1.getText());
		}
		else if(e.getSource()==button2){
			pw.replaceSelection(button2.getText());
		}
		else if(e.getSource()==button3){
			pw.replaceSelection(button3.getText());
		}
		else if(e.getSource()==button4){
			pw.replaceSelection(button4.getText());
		}
		else if(e.getSource()==button5){
			pw.replaceSelection(button5.getText());
		}
		else if(e.getSource()==button6){
			pw.replaceSelection(button6.getText());
		}
		else if(e.getSource()==button7){
			pw.replaceSelection(button7.getText());
		}
		else if(e.getSource()==button8){
			pw.replaceSelection(button8.getText());
		}
		else if(e.getSource()==button9){
			pw.replaceSelection(button9.getText());
		}
		else if(e.getSource()==ent){
			int result = Integer.parseInt(pw.getText());
			if(result == 1234){
				JOptionPane.showMessageDialog(new JFrame(),"Correct PIN!");
				this.dispose();
				new A_clientGui();
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Wrong PIN!");
		}
		else if(e.getSource()==backsp){
			pw.setText (pw.getText ().substring (0, pw.getText ().length () - 1));
		}
		
		
	}
}

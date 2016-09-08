import java.text.DecimalFormat;

public class Y_methods{
	public static double balanceCheck=3000;
	public static double balanceSav=3000;
	public static double loanPayment=10000;
	static DecimalFormat fmt=new DecimalFormat("'$'0,000.00");
	
	public static double withdrawCheck(double a){
		balanceCheck=balanceCheck-a;		
		return balanceCheck;
	}
	
	public static double depositCheck(double a){
		balanceCheck=balanceCheck+a;
		return balanceCheck;
	}
	
	public static String displayCheck(){
		return("Your checking balance is: "+ fmt.format(balanceCheck));
	}
	public static double withdrawSav(double a){
		balanceSav=balanceSav-a;		
		return balanceSav;
	}
	
	public static double depositSav(double a){
		balanceSav=balanceSav+a;
		return balanceSav;
	}
	
	public static String displaySav(){
		return("Your savings balance is: "+ fmt.format(balanceSav));
	}
	
	public static double makeLoanPayment(double a){
		loanPayment=loanPayment-a;
		return loanPayment;
	}
	
	public static String displayLoan(){
		return("After payment, your loan is down to "+ fmt.format(loanPayment));
	}
}

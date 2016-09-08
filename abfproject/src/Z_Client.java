public class Z_Client extends Y_methods{
	
	public Z_Client() {
		balanceCheck=3000;
		balanceSav=3000;
		loanPayment=10000;
	}
	public static double getBalanceCheck() {
		return balanceCheck;
	}
	public static double getBalanceSav() {
		return balanceSav;
	}
	public double getLoanPayment() {
		return loanPayment;
	}
	public static void setBalanceCheck(double a) {
		balanceCheck = a;
	}
	public static void setBalanceSav(double a) {
		balanceSav = a;
	}
	public void setLoanPayment(double a) {
		loanPayment = a;
	}
	
}

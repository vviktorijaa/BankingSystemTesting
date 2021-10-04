package Bank;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class SavingsAccount extends BankAccount {

	private static final long serialVersionUID = 1L;
	float rate = .05f;
	double maxWithLimit;
	
	public SavingsAccount(String name, double balance,double maxWithLimit) {
		super(name, balance, 2000);
		this.maxWithLimit= maxWithLimit;
	}
	
	public double getNetBalance() {
		double NetBalance= getBalance()+(getBalance()*rate);
		return NetBalance;
	}
	
	public double withdraw(double amount) throws MaxWithdraw, MaxBalance {
		if(amount<maxWithLimit) {
			super.withdraw(amount);
		}
		else {
			throw new MaxWithdraw("Maximum Withdraw Limit Exceed");
		}
        return amount;
    }
}

package Bank;
import java.io.Serializable;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	private double balance;
	double min_balance;
	String acc_num;

	public BankAccount(){}
	
	public BankAccount(String name, double balance, double min_balance) {
		this.name = name;
		this.balance = balance;
		this.min_balance = min_balance;
		acc_num = 10000 + (int)(Math.random()*89999) + "";
	}

	public void setName(String name){
		this.name=name;
	}

	public void setBalance(double balance){
		this.balance=balance;
	}

	public void setMinBalance(double min_balance){
		this.min_balance=min_balance;
	}

	public String getAccNumber(){
		return acc_num;
	}

	public String getName(){
		return name;
	}

	public double getBalance(){
		return balance;
	}

	public double getMinBalance(){
		return min_balance;
	}

	public double deposit(double amount) {
		balance+=amount;
		return balance;
	}
	
	public double withdraw(double amount) throws MaxWithdraw, MaxBalance {
		if((balance-amount)>=min_balance && amount<balance) {
			balance-=amount;
			return balance;
		}
		else {
			throw new MaxBalance("Insufficient Balance");
		}
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Id: " + acc_num + ", Balance: " + balance +", Type: "+this.getClass();
	}
}

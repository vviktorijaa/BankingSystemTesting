package Bank;

import java.io.Serializable;
import javax.swing.DefaultListModel;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	private BankAccount[] accounts = new BankAccount[100];
	public int addAccount(BankAccount acc)
	{
		int i=0;
		for(i=0;i<100;i++) {
			if(getAccounts()[i]==null) {
				break;
			}
		}
		getAccounts()[i]=acc;
		return i;
	}
	
	public int addAccount(String name, double balance, double maxWithLimit) {
		SavingsAccount acc=new SavingsAccount(name, balance, maxWithLimit);
		return this.addAccount(acc);
	}
	
	public int addAccount(String name, double balance, String tradeLicense) throws Exception {
		CurrentAccount acc = new CurrentAccount(name, balance,tradeLicense);
		return this.addAccount(acc);
	}
	
	public int addAccount(String name, String  institutionName, double balance, double min_balance){
		StudentAccount acc= new StudentAccount(name,balance,institutionName);
		return this.addAccount(acc);
	}
	
	public BankAccount findAccount(String accountNum) {
		int i;
		for(i=0;i<100;i++) {
			if(getAccounts()[i]==null) {
				break;
			}
			if(getAccounts()[i].acc_num.equals(accountNum)) {
				return getAccounts()[i];
			}
		}
		return null;
	}
	
	public void deposit(String accountNum, double amt) throws InvalidAmount, AccNotFound {
		if(amt<0) {
			throw new InvalidAmount("Invalid Deposit amount");
		}
		BankAccount temp=findAccount(accountNum);
		if(temp==null) {
			throw new AccNotFound("Account Not Found");
		}
		else {
			temp.deposit(amt);
		}
	}
	
	
	public void withdraw(String accountNum, double amt) throws MaxBalance,AccNotFound, MaxWithdraw, InvalidAmount {
		BankAccount temp=findAccount(accountNum);
		if(temp==null) {
			throw new AccNotFound("Account Not Found");
		}
		else {
			temp.withdraw(amt);
		}
		if(amt<=0) {
			throw new InvalidAmount("Invalid Amount");
		}
		if(amt>temp.getBalance()) {
			throw new MaxBalance("Insufficient Balance");
		}
	}
	
	public DefaultListModel<String> display() {
		DefaultListModel<String> list=new DefaultListModel<String>();
		int i;
		for(i=0;i<100;i++) {
			if(getAccounts()[i]==null) {
				break;
			}
			list.addElement(getAccounts()[i].toString());
		}
		return list;
	}

	public BankAccount[] getAccounts() {
		return accounts;
	}

	public void setAccounts(BankAccount[] accounts) {
		this.accounts = accounts;
	}
}

package atmproject;

import java.util.ArrayList;

public class Account {
	private User holder;
	
	private String name;
	
	private String accountId;
	
	private ArrayList<Transaction> transactions;
	
	
	/**
	 * Creating a new account and initializing it's properties
	 * @param name name of the account(saving/checking) for example
	 * @param holder holder of the account
	 * @param theBank the bank where the account is from
	 */
	public Account(String name, User holder, Bank theBank) {
		this.name=name;
		this.holder=holder;
		this.accountId=theBank.getNewAccountID();
		this.transactions= new ArrayList<Transaction>();
		
		
		
	}
	
	
	/**
	 * Returns this account's id, balance and name
	 * @return
	 */
	public String getSummaryLine() {
		//get the account's balance
		double balance=this.getBalance();
		
		//format the summary line according to it's balance
		if(balance>=0) {
			return String.format("%s : $%.02f : %s", this.accountId,balance,this.name);
		}else {
			return String.format("%s : $(%.02f) : %s", this.accountId,balance,this.name);
		}
		
		
	}
	
	/**
	 * Get balance of the account
	 * @return
	 */
	public double getBalance() {
		double balance=0;
		
		for(Transaction t: this.transactions) {
			balance+=t.getAmount();
			
		}
		return balance;
	}
	
	/**
	 * print transaction History
	 */
	public void printTransHistory() {
		
		System.out.printf("\nTransactions history for account %s\n ", this.accountId);
		for(int t= this.transactions.size()-1; t >=0 ;t--) {
			System.out.printf(this.transactions.get(t).getSummaryLine());
		}
		
	}
	
	/**
	 * Add a new transactions in this account
	 * @param amount the amount transacted
	 * @param memo the transaction memo
	 */
	public void addTransaction(double amount,String memo) {
		Transaction trans=new Transaction(amount,memo,this);
		this.transactions.add(trans);
	}
	
	
	
	
	

	/**
	 * @return the holder
	 */
	public User getUsername() {
		return holder;
	}

	/**
	 * @param username the holder to set
	 */
	public void setUsername(User username) {
		this.holder = username;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountid() {
		return accountId;
	}

	/**
	 * @param accountid the accountId to set
	 */
	public void setAccountid(String accountid) {
		this.accountId = accountid;
	}



	/**
	 * @return the transaction
	 */
	public ArrayList<Transaction> getTransaction() {
		return transactions;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(ArrayList<Transaction> transaction) {
		this.transactions = transaction;
	}
	
	
	
	
	
}

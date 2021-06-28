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

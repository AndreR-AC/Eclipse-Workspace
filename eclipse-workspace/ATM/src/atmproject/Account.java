package atmproject;

import java.util.ArrayList;

public class Account {
	private User username;
	
	private String name;
	
	private String accountid;
	
	private double balance;
	
	private ArrayList<Transaction> transaction;

	/**
	 * @return the username
	 */
	public User getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(User username) {
		this.username = username;
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
	 * @return the accountid
	 */
	public String getAccountid() {
		return accountid;
	}

	/**
	 * @param accountid the accountid to set
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the transaction
	 */
	public ArrayList<Transaction> getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(ArrayList<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
	
	
	
}

package atmproject;

import java.util.Date;

public class Transaction {
	
	private double amount;
	
	private Date timeStamp;
	
	private String memo;
	
	private Account inAccount;
	
	/**
	 * Create a transaction with no memo
	 * @param amount
	 * @param inAccount
	 */
	public Transaction(double amount, Account inAccount) {
		this.amount=amount;
		this.inAccount=inAccount;
		this.timeStamp= new Date();
		this.memo="";
	}
	
	/**
	 * Create a transaction with a memo
	 * @param amount
	 * @param memo
	 * @param inAccount
	 */
	public Transaction(double amount,String memo, Account inAccount) {
		//using first constructor to avoid boiler plate
		this(amount,inAccount);
		this.memo=memo;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the inAccount
	 */
	public Account getInAccount() {
		return inAccount;
	}

	/**
	 * @param inAccount the inAccount to set
	 */
	public void setInAccount(Account inAccount) {
		this.inAccount = inAccount;
	}
	
	
	
	
}

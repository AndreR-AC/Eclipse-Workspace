package atmproject;

import java.util.Date;

public class Transaction {
	
	private double amount;
	
	private Date timeStamp;
	
	private String memo;
	
	private Account inAccount;

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

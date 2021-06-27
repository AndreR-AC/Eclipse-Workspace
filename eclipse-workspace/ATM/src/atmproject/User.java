package atmproject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
	private String firstName;
	
	private String lastName;
	
	private String userId;
	
	private byte[] pinHash;
	
	private ArrayList<Account> accountList;
	
	
	public User(String firstName, String lastName, String pin, Bank bank) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.pinHash=this.hashUserPin(pin);
		this.userId=bank.getNewUserId();
		this.accountList= new ArrayList<Account>();
		
		System.out.printf("New user %s,#s with ID %s created. \n",lastName,firstName,this.userId);
	}
	
	public byte[] hashUserPin(String pin) {
		byte[] pinHash=null;
		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("MD5");
			pinHash=md.digest(pin.getBytes());
		}catch(NoSuchAlgorithmException e) {
			System.err.print("Error, NoSuchAlgorithmException");
			System.exit(1);
		}
		return pinHash;
		
	}
	
	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the pinHash
	 */
	public byte[] getPinHash() {
		return pinHash;
	}


	/**
	 * @return the accountList
	 */
	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	
	
	
	
	
}

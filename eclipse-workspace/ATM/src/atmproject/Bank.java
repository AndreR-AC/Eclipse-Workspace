package atmproject;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
	private String name;
	
	private ArrayList<User> userList;
	
	private ArrayList<Account> accountList;
	
	
	/**
	 * Create a Bank object with empty lists of users and accounts
	 * @param name the name of the bank
	 */
	public Bank(String name) {
		this.name=name;
		this.userList=new ArrayList<User>();
		this.accountList= new ArrayList<Account>();
	}
		
	
	/**
	 * Generate a unique ID for a user
	 * @return userId
	 */
	public String getNewUserId() {
		String userId;
		Random rand= new Random();
		boolean nonUnique=false;
		int range=6;
		do {
			//generate a random Id
			userId="";
			for(int i=0;i<range;i++) {
				userId+=((Integer)rand.nextInt(10)).toString();
			}
			
			//check if it's unique
			for(User user: this.userList) {
				if(userId.compareTo(user.getUserId())==0) {
					System.out.println("This id is already taken!!");
					nonUnique=true;
					break;
				}
			}
			
		}while(nonUnique);
		
		
		return userId;
	}
	
	
	/**
	 * Generates a unique ID for a Account
	 * @return accountId
	 */
	public String getNewAccountID() {
		String accountId;
		Random rand= new Random();
		boolean nonUnique=false;
		int range=6;
		do {
			//generate a random Id
			accountId="";
			for(int i=0;i<range;i++) {
				accountId+=((Integer)rand.nextInt(10)).toString();
			}
			
			//check if it's unique
			for(Account acct: this.accountList) {
				if(accountId.compareTo(acct.getAccountid())==0) {
					System.out.println("This id is already taken!!");
					nonUnique=true;
					break;
				}
			}
			
		}while(nonUnique);
		
		
		return accountId;
	}
	
	
	/**
	 * Create a new User and add it the to bank
	 * @param firstName first name of the user
	 * @param lastName	last name of the user
	 * @param pin	user pin
	 * @return newUser
	 */
	public User addUser(String firstName,String lastName,String pin) {
		//create new user and add it to our list
		User newUser= new User(firstName,lastName,pin,this);
		this.userList.add(newUser);
		
		//create saves account for the user
		Account newAccount= new Account("Savings",newUser,this);
		
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		
		return newUser;
		
		
	}
	
	/**
	 * User logs in with his credentials
	 * @param userId
	 * @param pin
	 * @return return the user who is logging in
	 */
	public User userLogin(String userId,String pin) {
		for(User user: this.userList) {
			if(userId.compareTo(user.getUserId())==0 && user.validatePin(pin)) {
				return user;
			}
			
		}
		//if pin is invalid or ping doesn't exist
		
		return null;
	}
	
	
	/**
	 * Add an account to the account list
	 * @param anAccount account to add
	 */
	public void addAccount(Account anAccount) {
		this.accountList.add(anAccount);
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
	 * @return the userList
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
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

package atmproject;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		Bank bank= new Bank("Santander");
		
		User aUser= bank.addUser("John", "Travolta", "1234");
		
		Account newAcc= new Account("Checking",aUser,bank);
		
		bank.addAccount(newAcc);
		aUser.addAccount(newAcc);
		
		User curUser;
		
		while(true) {
			//login prompt until successful login
			
			curUser= ATM.mainMenuPrompt(bank,sc);
			
			ATM.printUserMenu(curUser,sc);
			
		}

	}
	
	
	/**
	 * Generate mainMenuPrompt to login
	 * @param aBank the bank of the user
	 * @param sc input scanner
	 * @return authenticated user if successful
	 */
	public static User mainMenuPrompt(Bank aBank, Scanner sc) {
		String userID;
		String pin;
		User authUser;
		
		//ask for user ID/PIN combo until successful login
		do {
			
			System.out.printf("\n\nWelcome to %s\n\n", aBank.getName());
			System.out.print("Enter user ID: ");
			userID= sc.nextLine();
			System.out.print("Enter pin: ");
			pin= sc.nextLine();
			
			authUser=aBank.userLogin(userID, pin);
			
			if(authUser==null) {
				System.out.println("Incorrect ID/pin combination. "+"Please try again.");
			}
			
		}while(authUser==null);//continue loop until successful login
		
		return authUser;
	}
	
	
	
	/**
	 * Opens the user menu 
	 * @param theUser user logged in
	 * @param sc user input scanner
	 */
	public static void printUserMenu(User theUser, Scanner sc) {
		theUser.printAccountsSummary();
		
		int choice;
		
		
		do {
			System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
			System.out.println("   1)Show account transaction history");
			System.out.println("   2)Withdraw");
			System.out.println("   3)Deposit");
			System.out.println("   4)Transfer");
			System.out.println("   5)Quit");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			
			if(choice<1 || choice>5 ) {
				System.out.println("Invalid choice. Only numbers from 1-5.");
			}
			
		}while(choice<1 || choice>5);
		
		switch (choice) {
		case 1: 
			ATM.showTransHistory(theUser,sc);
			break;
		case 2:
			ATM.withdrawFunds(theUser,sc);
			break;
		case 3:
			ATM.depositFunds(theUser,sc);
			break;
		case 4:
			ATM.transferFunds(theUser,sc);
			break;
		}
		
		//redisplay menu until user quits
		if(choice!=5) {
			ATM.printUserMenu(theUser, sc);
		}
		
		
	}
	
	/**
	 * Show user transfer history from specific account
	 * @param theUser user who is logged in
	 * @param sc user input scanner
	 */
	public static void showTransHistory(User theUser, Scanner sc) {
		int theAcct;
		
		do {
			System.out.printf("Enter the number (1-%d) of the account whose"+
					" transactions you want to see: ", theUser.numAccounts());
			theAcct=sc.nextInt()-1;
			if(theAcct<0 || theAcct>=theUser.numAccounts()) {
				System.out.println("The account you entered is invalid.");
			}
			
		}while(theAcct<0 || theAcct>=theUser.numAccounts());
		
		theUser.printAccountTransHistory(theAcct);
	}
	
	/**
	 * Transfer funds from one account to another
	 * @param theUser user who is logged in
	 * @param sc user input scanner
	 */
	public static void transferFunds(User theUser, Scanner sc) {
		
		int fromAccount;
		int toAccount;
		double amount;
		double acctBalance;
		
		//ask user the account to transfer from
		do {
			System.out.printf("Enter the number (1-%d) of the account\n "
					+"to transfer from: ",theUser.numAccounts());
			fromAccount=sc.nextInt()-1;
			if(fromAccount<0 || fromAccount>=theUser.numAccounts()) {
				System.out.println("The account you entered is invalid.");
			}
			
			
		}while(fromAccount<0 || fromAccount>=theUser.numAccounts());
		
		acctBalance=theUser.getAccountBalance(fromAccount);
		
		//ask user the account to transfer to
		do {
			System.out.printf("Enter the number (1-%d) of the account\n "
					+"to transfer to: ",theUser.numAccounts());
			toAccount=sc.nextInt()-1;
			if(toAccount<0 || toAccount>=theUser.numAccounts()) {
				System.out.println("The account you entered is invalid.");
			}
			
			
		}while(toAccount<0 || toAccount>=theUser.numAccounts());
		
		//amount to transfer
		do {
			System.out.printf("Enter the amount to transfer (max $%.02f): $",
					acctBalance);
			amount=sc.nextDouble();
			
			if(amount<0) {
				System.out.println("Amount less than zero");
			}else if(amount>acctBalance) {
				System.out.printf("Amount must not greater than balance of $%.02f. \n",acctBalance);
			}
			
			
		}while(amount<0 || amount>acctBalance);

		theUser.addAcctTransaction(fromAccount, -1*amount,String.format("Transfer to account %s",
				theUser.getAccountId(toAccount)));
		theUser.addAcctTransaction(toAccount, amount,String.format("Transfer to account %s",
				theUser.getAccountId(fromAccount)));
		
	}
	
	public static void withdrawFunds(User theUser, Scanner sc) {

		
		int fromAccount;
		String memo;
		double amount;
		double acctBalance;
		
		//ask user the account to transfer from
		do {
			System.out.printf("Enter the number (1-%d) of the account\n "
					+"to withdrawal from: ",theUser.numAccounts());
			fromAccount=sc.nextInt()-1;
			if(fromAccount<0 || fromAccount>=theUser.numAccounts()) {
				System.out.println("The account you entered is invalid.");
			}
			
			
		}while(fromAccount<0 || fromAccount>=theUser.numAccounts());
		
		acctBalance=theUser.getAccountBalance(fromAccount);
		
		//amount to withdraw
		do {
			System.out.printf("Enter the amount to transfer (max $%.02f): $",
					acctBalance);
			amount=sc.nextDouble();
			
			if(amount<0) {
				System.out.println("Amount less than zero");
			}else if(amount>acctBalance) {
				System.out.printf("Amount must not greater than balance of $%.02f. \n",acctBalance);
			}
			
			
		}while(amount<0 || amount>acctBalance);
		
		sc.nextLine();
		
		//get a memo
		System.out.println("Enter a memo: ");
		memo=sc.nextLine();
		
		//make withdrawal
		theUser.addAcctTransaction(fromAccount, -1*amount, memo);
		
}
	
	
/**
 * Deposit funds
 * @param theUser
 * @param sc
 */
public static void depositFunds(User theUser, Scanner sc) {
		
		int toAccount;
		String memo;
		double amount;
		double acctBalance;
		
		//ask user the account to transfer from
		do {
			System.out.printf("Enter the number (1-%d) of the account\n "+
					"to deposit in: ", theUser.numAccounts());
			toAccount=sc.nextInt()-1;
			if(toAccount<0 || toAccount>=theUser.numAccounts()) {
				System.out.println("The account you entered is invalid.");
			}
			
			
		}while(toAccount<0 || toAccount>=theUser.numAccounts());
		
		acctBalance=theUser.getAccountBalance(toAccount);
		
		//amount to withdraw
		do {
			System.out.printf("Enter the amount to transfer (max $%.02f): $",
					acctBalance);
			
			amount=sc.nextDouble();
			
			if(amount<0) {
				System.out.println("Amount less than zero");
			}
			
			
		}while(amount<0);
		
		sc.nextLine();
		
		//get a memo
		System.out.println("Enter a memo: ");
		memo=sc.nextLine();
		
		//make deposit
		theUser.addAcctTransaction(toAccount, amount, memo);
	
	
	
	
}
	

}

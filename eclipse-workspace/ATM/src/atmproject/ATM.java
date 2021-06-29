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
	
	public static void printUserMenu(User theUser, Scanner sc) {
		theUser.printAccountSummary();
		
		int choice;
		
		
		do {
			System.out.printf("Welcome %s, what would you like to do?", theUser.getFirstName());
			System.out.println("   1)Show account transaction history");
			System.out.println("   2)Withdraw");
			System.out.println("   3)Deposit");
			System.out.println("   4)Transfer");
			System.out.println("   5)Quit");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			
			if(choice<1 || choice>5 || !sc.hasNextInt()) {
				System.out.println("Invalid choice. Only numbers from 1-5.");
			}
			
		}while(choice<1 || choice>5 || !sc.hasNextInt());
		
		switch (choice) {
		case 1: 
			ATM.showTransHistory(theUser,sc);
		case 2:
			ATM.withdrawlFunds(theUser,sc);
		case 3:
			ATM.depositFunds(theUser,sc);
		case 4:
			ATM.transferFunds(theUser,sc);
		}
		
		//redisplay menu until user quits
		if(choice!=5) {
			ATM.printUserMenu(theUser, sc);
		}
		
		
	}
	
	

}

//Programmer: Samuel Greenlee
//Program: Java01 Program Assignment
//Description: This program allows a user to purchase tickets
//Date Created On: 2/2/2020

import java.util.*;

public class TicketPurchaser {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		 String answer = "";
		 
		//Continues until the user enters anything by "y"
	  	 do
		 {
		 	String customerName = checkName(sc);
		 	String  customerEmailAddress = checkEmailAddress(sc); 	
		 	int customerZipCode = checkZipCode(sc);
		 	String nameOfEvent = checkEventName(sc);
		 	int numOfTickets = checkTickets(sc);
		 	int ticketType = checkTicketType(sc);
		 	long creditCardNumber = checkCreditCard(sc);
		 	String expirationDate = checkDate(sc);		 
		 	
		 	//Calculates and then displays the output
			calcDisplay(customerName, customerEmailAddress, customerZipCode,
					nameOfEvent, numOfTickets, ticketType, creditCardNumber,
					expirationDate);
			
		 	System.out.print("Do you wish to continue? ");
		 	
	     	answer = sc.nextLine();
	     	
		}while(answer.equalsIgnoreCase("y")); //Continues until the user enters anything by "y" 
	}//Ends main method
	
	//This method gets the customer name, then checks it	
	public static String checkName(Scanner sc)
	{
		String customerName = "";
		boolean errorCheck = false;
		
			do
	  		{
	 			System.out.print("customer name: ");
	 			customerName = sc.nextLine();
	 			errorCheck = Validation.isStringPresent(customerName, "Customer name");
	 		
	  		}while(!errorCheck);

			return customerName;
	}
	
	//This method gets the email address, and then checks it	
	public static String checkEmailAddress(Scanner sc)
	{
		String customerEmailAddress = "";
		boolean errorCheck = false;
		
			do
	  		{
	 			System.out.print("Customer e-mail Address: ");
	 			customerEmailAddress = sc.nextLine();
	 			errorCheck = Validation.isStringPresent(customerEmailAddress, "Customer e-mail Address");
	 		
	  		}while(!errorCheck);

			return customerEmailAddress;
	}
	
	//This method gets the zip code, and then checks it	
	public static int checkZipCode(Scanner sc)
	{
			 String customerZipCode = "";
			 int min = 11111;
			 int max = 99999;
			 boolean errorCheck = false;
			
			do
		 	{   
	  	 		System.out.print("Customer Zip Code: ");
	  	 		customerZipCode = sc.nextLine();
	  	 		errorCheck = Validation.isInteger(customerZipCode, "Zip Code")&&  
			     		     Validation.isWithinRangeInteger(customerZipCode, min, max,"Zip Code");
			
	    	}while(!errorCheck);
     	 		return Integer.parseInt(customerZipCode);		 			
	}
	
	//This method gets the name of the event, and then checks it	
	public static String checkEventName(Scanner sc)
	{
		String nameOfEvent = "";
		boolean errorCheck = false;
		
			do
	  		{
	 			System.out.print("Name of event: ");
	 			nameOfEvent = sc.nextLine();
	 			errorCheck = Validation.isStringPresent(nameOfEvent, "Name of event");

	 		
	  		}while(!errorCheck);

			return nameOfEvent;
	}
	
	//This method gets the number of tickets the customer wants, and checks it	
	public static int checkTickets(Scanner sc)
	{
			 String numOfTickets = "";
			 int min = 1;
			 int max = 20;
			 boolean errorCheck = false;
			
			do
		 	{   
	  	 		System.out.print("Number of Tickets: ");
	  	 		numOfTickets = sc.nextLine();
	  	 		errorCheck = Validation.isInteger(numOfTickets, "Number of Tickets")&&  
			     		     Validation.isWithinRangeInteger(numOfTickets, min, max,"Number of Tickets");
			
	    	}while(!errorCheck);
     	 		return Integer.parseInt(numOfTickets);		 			
	}
	
	//This method gets the type of the tickets ordered, and checks it	
	public static int checkTicketType(Scanner sc)
	{
		
		String ticketType = "";
		int min = 1;
		int max = 3;
		boolean errorCheck = false;

		do
	 	{   
  	 		System.out.print("Ticket Type: ");
  	 		ticketType = sc.nextLine();
  	 		errorCheck = Validation.isInteger(ticketType, "Ticket type Number")&&  
		     		     Validation.isWithinRangeInteger(ticketType, min, max,"Ticket type Number");
    	}while(!errorCheck);
			return Integer.parseInt(ticketType);
	}
	
	// This method gets the credit card number, and then checks it	
	public static long checkCreditCard(Scanner sc)
	{
			 String creditCardNumber = "";
			 long min = 1111111111111111L;
			 long max = 9999999999999999L;
			 boolean errorCheck = false;
			
			do
		 	{   
	  	 		System.out.print("Credit Card Number: ");
	  	 		creditCardNumber = sc.nextLine();
	  	 		errorCheck = Validation.isLong(creditCardNumber, "Credit Card Number")&&  
			     		     Validation.isWithinRangeLong(creditCardNumber, min, max,"Credit Card Number");
			
	    	}while(!errorCheck);
     	 		return Long.parseLong(creditCardNumber);		 			
	}
	
	// This method gets the expiration date on the customer's credit card, then checks it	
	public static String checkDate(Scanner sc)
	{
  	/*This method asks the user to enter a date, then calls the isDateValid method in the Validation
      class to test for a valid date.*/
		String expirationDate = "";
		boolean errorCheck = false;
		
			do
	  		{
	 			System.out.print("Please enter the date the the card expires on in this format yyyy-mm-dd: "); 			
	 			expirationDate = sc.nextLine();
	 			errorCheck = Validation.isDateValid(expirationDate); 		
	  		}while(!errorCheck);
		
			return expirationDate;
		}
	
	//This method calculates the order total then displays the output for the user 	
	public static void calcDisplay(String customerName, String customerEmailAddress, int customerZipCode,
			String nameOfEvent, int numOfTickets, int ticketType, long creditCardNumber,
			String expirationDate)
	{
		//Calculates the orderTotal
		float orderTotal = 0;
		
		if(ticketType == 1)
		{
			orderTotal = (131.00F + 18.50F) *  numOfTickets;
		}
		else if (ticketType == 2)
		{
			orderTotal = (94.00F + 17.50F) * numOfTickets;
		}
		else if (ticketType == 3)
		{
			orderTotal = (86.00F + 16.50F) * numOfTickets;
		}
		
		//Displays the output for what the customer needs from the program
		System.out.println("Thank your for your business, please verify the information: " + 
		  		"\nCustomer Name: " + customerName + " \nCustomer Email Address: " + customerEmailAddress
		  		+ " \nCustomer Zip Code: " + customerZipCode + " \nName Of Event: " + nameOfEvent +
		  		" \nNumber Of Tickets: " + numOfTickets + " \nTicket Type: " + ticketType + 
		  		" \nCredit Card Number: " + creditCardNumber + " \nExpiration Date: " + expirationDate +
		  		" \nOrder Total: " + Validation.formatAndRound(orderTotal));		
	}
}

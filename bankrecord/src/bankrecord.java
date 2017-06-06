/**
 * @author Haroon Qahtan
 * Program name: bankrecord.java
 * Due Date: Feb 25, 2017
 *  
 *  Purpose of program:
 *  	This program maintains a list of records containing names and phone numbers. 
 *  	The program will prompt the user for a command, execute the command, then prompt 
 *  	the user for another command. The commands that users are able to choose from this 
 *  	program are: Show all records, Delete a selected record, Change the first name of 
 *  	a selected record, Change the last name of a selected record, Add a new record, Change 
 *  	the phone number of a selected record, Withdraw an amount requested by the record, Add 
 *  	a deposit for a selected record, and finally Quit. The program uses the LinkedList library 
 *  	which helps with the organization of the customer object in each record. Many methods are 
 *  	created as functions to perform the activities of the featured commands.
 *  
 *  Solution for the problem and algorithms used:
 *  	The solution for this problem was mainly creating a lot of methods that use the LinkedList 
 *  	library to perform every function provided in the menu feature. At the beginning of the program
 *  	there is a switch statement which takes in the input of the user to determine what function to perform.
 *  	Each case in the switch statement is tied to a specific method. The first command uses the showAllRecords 
 *  	method where the method loops through the LinkedList object and prints out every one of them. The second command
 *  	deleteRecord deletes a record based on the first and last name provided, and it does this by looping through all the 
 *  	objects in the LinkedList and finding the correct needed one and deleting it. The third command calls the changeFirstName 
 *  	method that asks for a first and last name of the record and then loops through all the objects in the LinkedList to find
 *  	the needed record to change the first name for and thus asks the user for the new first name. The fourth command changeLastName 
 *  	is much like the third method in that it uses the same type of function, however, it asks the user for a new last name in order 
 *  	to change it. The fifth command calls the addRecord method which asks the user for a first and last name, as well as a phone number 
 *  	and balance in order to input all 4 of these inputs in a new Customer Object and add it to the end of the LinkedList as record.
 *  	The sixth command calls the changePhonenNumber method which asks the user for a first and last name and then loops through the
 *  	LinkedList in order to find the requested record and then changes the phone number by using the setPhoneNumber method provided by the
 *  	Customer class. The seventh command class the withDraw method which asks the user for a first and last name in order to loop through
 *  	the LinkedList and find the requested record and then asks for the withdraw amount and thus use the getBalance and setBalance method 
 *  	in order to withdraw the requested amount from the user. The eighth command calls the addDeposit method which is much like the withdraw
 *  	method only instead of asking the user for the withdraw amount it asks them for the add deposit amount and then uses the get and setBalance
 *  	methods from the Customer class in order to update the balance. Finally the ninth command quits the program. Also for the delete, 
 *  	changeFirstName/LastName, if there are two records in the LinkedList with the same first and last name, then the program asks the user for the 
 *  	phone number in order to get the correct record to edit.
 *  
 *  Data Structures used in this solution:
 *  	LinkedLists were used in the making of this program.
 *  
 *  Expected Input/Output:
 * 		Expected input are the command numbers that are being inputed by the user as well as Strings for 
 * 		the commands that request to add or change first/last names/ phone numbers, and also a double number 
 * 		that is inputed when setting or modifying a balance. Expected outputs are the menu screen as well as 
 * 		the current records and contents in the records in the LinkedList. 
 * 
 * Purpose of this class:
 * 		This class is the main method class for this program which contains all the methods (functions) that are going to be called by the 
 * 		inputed commands from the user.  
 */

import java.util.Scanner;
import java.util.LinkedList;

public class bankrecord {
	/**
	 * The beginning of the program and main method where 
	 * a scanner asks the user for the inputed command and 
	 * a switch statement calls the correct method based on 
	 * the user command. 
	 * @param args
	 */
    public static void main(String[] args) {
    	
        LinkedList<Customer> myLinkedList = new LinkedList<Customer>();
        Scanner scan = new Scanner(System.in);
        menu();
        int option = 0;
        String command = scan.nextLine().trim();
        while (command != "9") {
            try{
            	option = Integer.parseInt(command);
            }
            catch(Exception e){
            	println("Illegal command");
            	println("Enter a command from the list above (9 to quit): ");
            	command = scan.nextLine().trim();
            }
        	switch (option) { 
                case 1:
                	showAllRecords(myLinkedList);
                    break;
                case 2:
                	deleteRecord(myLinkedList, scan);
                    break;
                case 3:
                	changeFirstName(myLinkedList, scan);
                	break;
                case 4:
                	changeLastName(myLinkedList, scan);
                	break;
                case 5:
                	addRecord(myLinkedList, scan);
                	break;
                case 6:
                	changePhoneNumber(myLinkedList, scan);
                	break;
                case 7:
                	withDraw(myLinkedList, scan);
                	break;
                case 8:
                	addDeposit(myLinkedList, scan);
                	break;
            }
            menu();
            command = scan.nextLine().trim();
    }
        }
    /**
     * @param T
     * This method accepts a LinkedList as a parameter and 
     * it uses it in order to loop through it and print out all the 
     * Customer objects that are contained in it.
     */
    public static void showAllRecords(LinkedList<Customer> T){
    	if(T.size() == 0){
    		println("\nThere are no records\n");
    	}else{
    		for(int i =0;i<T.size();i++){
        		println(T.get(i)+"");
        	}	
    	}
    }
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, phone number, and balance. 
     */
    public static void addRecord(LinkedList<Customer> T, Scanner scan){
        println("Enter first name: ");
        String firstName = scan.nextLine().trim();
        println("Enter last name: ");
        String lastName = scan.nextLine().trim();
        println("Enter phone number: ");
        String phoneNumber = scan.nextLine();
        while(!phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")){
    		println("Invalid phone number, please try again: ");
    		phoneNumber = scan.nextLine();
    	}
        println("Enter balance: $");
        double balance = scan.nextDouble();
        scan.nextLine();
        Customer customerRec = new Customer(firstName, lastName, phoneNumber,  balance);
        T.add(customerRec);
    }
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last names inputed.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, and potentially phone number. This is then used 
     * to match the correct Customer object in the LinkedList T.  
     */
    public static void deleteRecord(LinkedList<Customer > T, Scanner scan){
    	showAllRecords(T);
    	println("Enter First Name you want to delete: ");
    	String firstName = scan.nextLine().trim();
    	println("Enter Last Name you want to delete: ");
    	String lastName = scan.nextLine().trim();
    	
    	if(searchAndReturn(T,  firstName,  lastName) == -1){
    		println("\nThe record you requested was not found.\n");
    	}else if(searchAndReturn(T,  firstName,  lastName) == -2){
    		println("\nTwo records were found with the same last and first name, please enter the phone number: ");
    		String phoneNum = scan.nextLine();
            while(!phoneNum.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")){
        		println("Invalid phone number, please try again: ");
        		phoneNum = scan.nextLine();
        	}
    		T.remove(searchAndReturnWphone(T,  firstName,  lastName, phoneNum));
    	}
    	else{
    		T.remove(searchAndReturn(T,  firstName,  lastName));	
    	}
    }
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last names inputed.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, and new first name. This is then used 
     * to match the correct Customer object in the LinkedList T and modify the first name.
     */
    public static void changeFirstName(LinkedList<Customer> T, Scanner scan){
    	showAllRecords(T);
    	println("Enter the First name of the record you want to change the first name of: ");
    	String firstName = scan.nextLine().trim();
    	println("Enter the First name of the record you want to change the first name of: ");
    	String lastName = scan.nextLine().trim();
    	println("\nNow enter the new First name: ");
    	String newFirstname = scan.nextLine().trim();
    	if(searchAndReturn(T,  firstName,  lastName) == -1){
    		println("The record you requested was not found.");
    	}else if(searchAndReturn(T,  firstName,  lastName) == -2){
    		println("Two records were found with the same last and first name, please enter the phone number: ");
    		String phoneNum = scan.nextLine();
    		T.get(searchAndReturnWphone(T,  firstName,  lastName, phoneNum)).setFirstName(newFirstname);
    	}
    	else{
    		T.get(searchAndReturn(T,  firstName,  lastName)).setFirstName(newFirstname);	
    	}
    }
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last names inputed.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, and new last name. This is then used 
     * to match the correct Customer object in the LinkedList T and modify the last name.
     */
    public static void changeLastName(LinkedList<Customer> T, Scanner scan){
    	showAllRecords(T);
    	println("Enter the First name of the record you want to change the last name of: ");
    	String firstName = scan.nextLine().trim();
    	println("Enter the First name of the record you want to change the last name of: ");
    	String lastName = scan.nextLine().trim();
    	println("\nNow enter the new last name: ");
    	String newLastname = scan.nextLine().trim();
    	if(searchAndReturn(T,  firstName,  lastName) == -1){
    		println("The record you requested was not found.");
    	}else if(searchAndReturn(T,  firstName,  lastName) == -2){
    		println("Two records were found with the same last and first name, please enter the phone number: ");
    		String phoneNum = scan.nextLine();
    		T.get(searchAndReturnWphone(T,  firstName,  lastName, phoneNum)).setLastName(newLastname);
    	}
    	else{
    		T.get(searchAndReturn(T,  firstName,  lastName)).setLastName(newLastname);	
    	}
    }
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last name and phone number.
     * @param firstName
     * Accepts a string which is used to find the object containing the same first name.
     * @param lastName
     * Accepts a string which is used to find the object containing the same last name.
     * @param phoneNum
     * Accepts a string which is used to find the object containing the same phone number.
     * @return
     * Returns a -1 if nothing was found in the LinkedList, and a positive number of the position of the object found.
     */
    public static int searchAndReturnWphone(LinkedList<Customer> T, String firstName, String lastName, String phoneNum){
    	int j = -1;
    	for (int i = 0; i < T.size(); i++) {
                if(T.get(i).getFirstName().equals(firstName) && T.get(i).getLastName().equals(lastName) && T.get(i).getPhoneNumber().equals(phoneNum)){
                    j = i;
            	 }	
    	}
    	return j;
    } 
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last name.
     * Accepts a string which is used to find the object containing the same first name.
     * @param lastName
     * Accepts a string which is used to find the object containing the same last name.
     * @return
     * returns the postion of the object in the LinkedList
     */
    public static int searchAndReturn(LinkedList<Customer> T, String firstName, String lastName){
    	int j = -1;
    	int count = 0;
    	for (int i = 0; i < T.size(); i++) {
                if(T.get(i).getFirstName().equals(firstName) && T.get(i).getLastName().equals(lastName)){
                    j = i;
                    count++;
                    if(count>1){
            			j = -2;
            		break;
                    }
            	 }	    
    	}
    	return j;
    } 
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last names inputed.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, and new last name. This is then used 
     * to match the correct Customer object in the LinkedList T and modify the phone number.
     */
    public static void changePhoneNumber(LinkedList<Customer > T, Scanner scan){
    	showAllRecords(T);
    	println("Enter First Name of the record you want to change the phone number for: ");
    	String firstName = scan.nextLine().trim();
    	println("Now enter the last name: ");
    	String lastName = scan.nextLine().trim();
    	println("Enter the new phone number of the record you want to change: ");
    	String newPhome = scan.nextLine();
    	while(!newPhome.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")){
    		println("Invalid phone number, please try again: ");
    		newPhome = scan.nextLine();
    	}
    	T.get(searchAndReturn(T, firstName, lastName)).setPhoneNumber(newPhome);
    	
    }
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last names inputed.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, and new last name. This is then used 
     * to match the correct Customer object in the LinkedList T and modify balance.
     */
    public static void addDeposit(LinkedList<Customer > T, Scanner scan){
    	showAllRecords(T);
    	println("Enter First Name of the record you want to add deposit for: ");
    	String firstName = scan.nextLine().trim();
    	println("Now enter the last name: ");
    	String lastName = scan.nextLine().trim();
    	println("Enter the amount of the deposit: ");
    	double deposit = scan.nextDouble();
    	for (int i = 0; i < T.size(); i++) {
            if(T.get(i).getFirstName().equals(firstName) && T.get(i).getLastName().equals(lastName)){
            	T.get(i).setBalance(T.get(i).getBalance() + deposit);
    	}
            }
    }
    
    /**
     * 
     * @param T
     * Accepts a LinkedList object and uses it in order to loop through 
     * all the contents matching the first and last names inputed.
     * @param scan
     * Also accepts a Scanner object which is used to ask the user to 
     * input first, last name, and new last name. This is then used 
     * to match the correct Customer object in the LinkedList T and modify balance.
     */
    public static void withDraw(LinkedList<Customer > T, Scanner scan){
    	showAllRecords(T);
    	println("Enter First Name of the record you want to withdraw from: ");
    	String firstName = scan.nextLine().trim();
    	println("Now enter the last name: ");
    	String lastName = scan.nextLine().trim();
    	println("Enter the amount to be withdrawn: ");
    	double withdrawl;
    	try{
        	 withdrawl = scan.nextDouble();
        	scan.nextLine();
    	}catch(Exception e){
    		println("Error please try again: ");
        	 withdrawl = scan.nextDouble();
        	scan.nextLine();
    	}
    	try{T.get(searchAndReturn(T, firstName, lastName)).setBalance(T.get(searchAndReturn(T, firstName, lastName)).getBalance()-withdrawl);
        println("The record now has $" + T.get(searchAndReturn(T, firstName, lastName)).getBalance());}
    	catch(Exception e){
    		println("\nThere was an Error\n");
    	}
    	
        
    }

/**
 * Displays the menu
 */
    public static void menu(){
		println("1. Show all records");
		println("2. Delete a selected record");
		println("3. Change the first name of a selected record");
		println("4. Change the last name of a selected record");
		println("5. Add a new record");
		println("6. Change the phone number of a selected record");
		println("7. Withdraw an amount requested by the record");
		println("8. Add a deposit for a selected record");
		println("9. Quit.");
		println("Enter a command from the list above (9 to quit): ");
    }
/**
 * 
 * @param x
 * Takes in a string in order to print it out as a line
 */
	public static void println(String x){ // takes in String x and just prints line the text to make it easier for me
		 System.out.println(x);
	}
	/**
	 * 
	 * @param x
	 * Takes in a string in order to print it
	 */
	public static void print(String x){ // takes in String x and just prints the text to make it easier for me
		 System.out.print(x);
	}
	}
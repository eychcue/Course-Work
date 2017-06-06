/**
 * 
 * @author Haroon Qahtan
 * Purpose of this class:
 * 		This class is meant to be a customer object for the LinkedList class, and it is going to be used to store
 * 		customer information such as first and last name, as well as their phone number, and balance. Each customer 
 * 		object will be kept as a separate record in the created LinkedList.
 *
 */
public class Customer {

	private String firstName, lastName, phoneNumber;	
	private double balance;
	
	public Customer(){
		 
	}
	/**
	 * 
	 * @param firstName
	 * String first name of the object
	 * @param lastName
	 * String last name of the object
	 * @param phoneNumber
	 * String phone number of the object
	 * @param balance
	 * Double - balance of the object
	 */
	public Customer(String firstName, String lastName, String phoneNumber, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}
	/**
	 * 
	 * @return
	 * Returns the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @param firstName
	 * sets the first name by accepting a string
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return
	 * Returns the last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param lastName
	 * sets the last name by accepting a string
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 
	 * @return
	 * returns the current phone number of the object
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 
	 * @param phoneNumber
	 * sets the phone number of the object by accpeting a string
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 
	 * @param balance
	 * sets the balance by accepting a double
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 
	 * @return
	 * returns the balance as a double
	 */
	public double getBalance() {
		return balance;
	}
	@Override
	/**
	 * toString method returns the string form of the content in the object
	 */
	public String toString() {

		String str1 = String.format("%-20s %-20s %-20s %-20s\n", "First Name", "Last Name", "Phone Number:", "Balance.");
		String str2 = String.format("%-20s %-20s %-20s %-20s\n", "-------------", "-------------", "-------------", "-------------");
		String str3 = String.format("%-20s %-20s %-20s %-20s\n", firstName, lastName, phoneNumber, balance);
		
		return str1+str2+str3;           
	}
	
	
}


/*
 * Haroon Qahtan
 * 2720 - HW2
 * Due: Feb 12, 2017 
 * 
 * This HW assignment also includes the classes: Card.java, testarray.java, and this class ArrayList.java
 * 
 * Purpose of the program:
 * 		This ArrayList class creates that is similar to the ArrayList data Structure that exist in the java library. 
 * 		The class is written to accept any type of Objects. There are two constructors in this class, a default one 
 * 		that initializes the array of a size 10, and the other constructor allows you to pick a size. There are two 
 * 		methods that allow you to add an object to the array, one adding the object to the end of the array and the 
 * 		other allowing you to choose an index. There is a method that will allow you to get the size of the array, 
 * 		also there is a method that will allow you to retrieve an object by providing it with an index. There is also 
 * 		a method that will allow the user to remove an object from the array. There are two boolean based methods, one 
 * 		being able to tell the user if the array is empty, and the other allowing the user to know if an object is available 
 * 		in the array. There is also an extra shuffle function that will randomize the objects in the array, and this is used 
 * 		for shuffling the deck of cards in the testarray.java class. The driver program, testarray.java makes use of a Card 
 * 		class, and fills an "ArrayList" with the Card objects, in which then a shuffle method is called to shuffle the card 
 * 		objects and after that a demonstration of the method to show that they work.
 * 
 * Solution for the Problem and Algorithms:
 * 		The solution for this problem was mainly creating many small methods that completed small functions that can be 
 * 		very useful and efficient. For example, many of these methods use a for loop that loops through the array in order 
 * 		to add an object, remove an object, find an object, etc. As to how the driver program (testarray.java) uses this class 
 * 		is first, a for loop that loads the card objects into the ArrayList. After that a shuffle function is used to shuffle 
 * 		the Objects in the Array and then the output is being printed on the screen as well as the output for other small methods 
 * 		from the ArrayList class.  		
 * 
 * Data Structures:
 * 		The data structures that were used in this homework are Arrays.
 * 
 * Expected Input/Output:
 * 		Expected input are the objects that are being passed through to 
 * 		the ArrayList class as well as other values such as integers for 
 * 		index variables, and the expected output is the array with the 
 * 		objects printed on the screen. 
 * 
 */
public class ArrayList {	
	static final int START = 10; 
	Object arry[]; // the ArrayList
	int numLength; // number of objects in array
	int capasity; // how big the array is 

	//Constructors 
	public ArrayList() {  // these two constructors will initialize the array with null values 
		arry = new Object[START];
	}
	
	public ArrayList(int n) { //needs to be given an int
		
		this.capasity = n;
		arry = new Object[this.capasity];
		numLength=0;
	}
	
	//Setters
	public void add(Object x) { //adds an object at the end of the ArrayList 
		if(numLength == capasity){
			Object[] temp = new Object[numLength+10];
			 for (int i = 0; i < numLength; i++) {
		 	 	 temp[i] = arry[i];
			 }
			 arry = temp;
			 capasity = capasity +10;
		}
		arry[numLength] = x;
	 	numLength = numLength+1;
	}
	
	

	public void add(int index, Object x) { // adds an object into the ArrayList at a specific index. Accepts an integer and an Object.
		
		Object[] temp = new Object[capasity+1];
		for (int i = 0; i < index; i++){
			temp[i] = arry[i];
		}
		
		temp[index] = x;
		
		for(int i = index++; i < arry.length; i++){
			temp[i] = arry[i-1];
		}
		arry = temp;
	
	}

	public Object get(int index) { //Returns the object of the inputed index value. Needs an integer to be passed in in order to return the object. 
		Object ReturnValue = arry[index];

		return ReturnValue;
	}

	public int size() { // returns the size of the Array in an integer
		int count =0;
		for(int i=0;i<this.arry.length;i++){
			if(this.arry[i]==null){
				count++;
			}
		}
		return arry.length-count;
	}

	public boolean isEmpty() { //checks to see if the ArrayList is empty, if it is then it will return true (boolean) and vise versa.
		boolean ReturnValue;
		int nullNum=0;
		for(int i =0; i<arry.length;i++){
			if(arry[i]==null){
				nullNum++;
			}
		}
		if(nullNum==arry.length){
			ReturnValue = true; 
		}else{
			ReturnValue = false;
		}
		
		return ReturnValue;
	}

	public boolean isIn(Object ob) { //checks to see if the passed object parameter is in the ArrayList and it then returns a boolean true if there is and false if there isn't.
		boolean ReturnValue = false;
		for(int i =0; i<arry.length;i++){
			if(arry[i]==ob){
				ReturnValue = true;
			}
		}
		return ReturnValue;
	}

	public int find(Object n) { // Searches the Array for the object that had been passed through the parameters and returns the location of the first occurrence of an Object or returns (-1) if the object is not in the Array.
		int ReturnValue = -1;
		for(int i =0; i<arry.length;i++){
			if(arry[i]==n){
				ReturnValue = i;
				break;
			}
		}
		return ReturnValue;
	}

	public void remove(Object n) { //accepts an object as a parameter and removes the first occurrence of that object
		
		Object[] temp1 = new Object[capasity-1];
		
	     int j = 0;
	     for(int i = 0;i<arry.length;i++) {
	        if(arry[i] !=n)
	           temp1[j++] = arry[i];
	     }
	     arry = temp1;
	
	}
	
	public void shuffle(){ // shuffles the Array randomly 
		
		for ( int i = arry.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Object temp = arry[i];
            arry[i] = arry[rand];
            arry[rand] = temp;
		}
	
	}

	public String toString() {

		return arry+"";
	}
}
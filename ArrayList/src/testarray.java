/*
 * Haroon Qahtan
 * 2720 - HW2
 * Due: Feb 12, 2017
 * 
 * This class is the main method of the program which 
 * uses the created class ArrayList which is similar 
 * to the java ArrayList library. In this class, the 
 * card.java and the ArrayList.java classes are used 
 * to create a deck of card that can be manipulated by 
 * the ArrayList.java class functions.This class is a 
 * driver to show that the ArrayList.java class works.  
 * 
 * */

public class testarray {
	public static void main(String[] args) { 
		
		ArrayList DeckOfCards = new ArrayList(); // Initializing an ArrayList object 

		String [] suit = {"Clubs","Spades", "Diamonds", "Hearts"};
		
		for (int i=0; i<4; i++){
			
			for (int j = 1; j <= 13; j++){	
				DeckOfCards.add(new Card(j, suit[i])); // adding cards to the ArrayList 
			}
		}

		println("Deck of cards: "); // printing out the deck of cards array 
		displayArray(DeckOfCards);
		
		println("\n\nDeck of cards after shuffle: ");// printing out the deck of cards array after it is shuffled 
		DeckOfCards.shuffle();
		displayArray(DeckOfCards);

		println("\n\nSize of the ArrayList: " + DeckOfCards.size()); // prints the size of the ArrayList

		Object c = DeckOfCards.get(17); //Initializing an object because I will need to use it to demonstrate the outputs of some methods.
		println("\nIs the object 17 in the ArrayList (Deck)? " + DeckOfCards.isIn(c)); // prints whether the inputed object is currently in the ArrayList

		println("\nObject at index 17 is: " + DeckOfCards.get(17)); // gets the object at the index 17
		println("Is the ArrayList empty? " + DeckOfCards.isEmpty()); // prints out if the ArrayList is empty or not
				
		println("Now we add an object into the ArrayList (Deck)... "); 
		DeckOfCards.add(17);									// Adds an object to the ArrayList, here its adding 17 to the ArrayList
		println("Now we check the size of the ArrayList to make sure the object was added: " + "Size = "+DeckOfCards.size()); // prints the size of the ArrayList
		
		println("Now we remove an object from the ArrayList (Deck)...");
		DeckOfCards.remove(c);										// removes an object from the ArrayList
		println("Now we use the Find method to look for (-1) in the object, if its true then the object has been previously removed.");
		
		if(DeckOfCards.find(c) == -1){								// Checks to see if the object is still in the ArrayList
			
			println("Object is NOT in the ArrayList");
			println("ArrayList (Deck) Size: "+DeckOfCards.size());	// prints out the ArrayList size to prove that the object was removed
			
			
		println("\nOne last thing to do is initialize an ArrayList with a predetermined number of indexes to show that it works: ");
		ArrayList DeckOfCards2 = new ArrayList(52); // Initializing an ArrayList object 

		String [] suit2 = {"Clubs","Spades", "Diamonds", "Hearts"};
		
		for (int i=0; i<4; i++){
			
			for (int j = 1; j <= 13; j++){	
				DeckOfCards2.add(new Card(j, suit2[i])); // adding cards to the ArrayList 
			}
		}
		
		println("Now we print the second ArrayList: ");
		displayArray(DeckOfCards2);  // printing the second ArrayList (Deck of cards)
		}
		
		
	} // end of main method
	
	
	public static void displayArray(ArrayList DeckOfCards){ // method that takes in an ArrayList object in which it is then printed
		System.out.print("[");
		for(int i =0; i<DeckOfCards.size()-1;i++){
			print(" "+DeckOfCards.get(i)+", ");
		}
		print(" "+DeckOfCards.get(DeckOfCards.size()-1)+" ]");		
	}
	
	public static void println(String x){ // takes in String x and just prints line the text to make it easier for me
		 System.out.println(x);
	}
	public static void print(String x){ // takes in String x and just prints the text to make it easier for me
		 System.out.print(x);
	}
	
}
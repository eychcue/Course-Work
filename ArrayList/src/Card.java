/*
 * Haroon Qahtan
 * 
 * This card class was done in Lab 2 however, we are instructed to use it for the second homework assignment. 
 * 
 * This class called "Card" which contains two variables, 
 * an integer for the rank and a String for the suit. Default constructor 
 * will output "Ace of Spades" and other inputs will display the rank and 
 * also the suit of the card.
 * 
 * 
 * */
public class Card {
	private int rank;
	private String suit;
	
	
	public Card() { // default sets rank to 14 and suit to "Ace of Spades"
		this.rank = 14;
		this.suit = "Ace of Spades";
	}
	
	public Card(int rank, String suit) { // sets the rank and suit of the card
		this.rank = rank;
		this.suit = suit;
	}

	//getters
	public int getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}
	
	//Setters
	public void setRank(int rank) {
		this.rank = rank;
	}


	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String toString(){
		switch(rank) { // This switch statement switches through values from 11 to 14 in order to change the number of the card to a word
		   case 11 :
			   return "Jack of " + suit;		      
		   case 12:
			   return "Queen of " + suit;		      
		   case 13:
			   return "King of " + suit;
		   case 14:
			   return "Ace of " + suit;
			   }
		if(rank > 13){ // in case users input a nonexistent card rank
			return "Invalid card rank";
		}else{
			return rank + " of "+ suit; // returns rank of card and also the suit
	
		}
		}
	
}
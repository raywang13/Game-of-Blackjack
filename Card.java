//Ray Wang
//Project 2
//Card.java

public class Card {

	String suit, rank;
	int value;
	boolean dealt = false;

	//Constructor
	Card(String rank, String suit, int value, boolean dealt) {
		this.rank = rank;
		this.suit = suit;
		this.value = value;
		this.dealt = dealt;
	}


	//Getters
	String getSuit() {
		return suit;
	}
	String getRank() {
		return rank;
	}
	int getValue() {
		return value;
	}
	boolean getDealt() {
		return dealt;
	}


	//Setters
	void setSuit() {
		this.suit = suit;
	}
	void setRank() {
		this.rank = rank;
	}
	void setValue() {
		this.value = value;
	}
	void setDealt(boolean isDealt) {
		this.dealt = isDealt;
	}


	//toString
	public String toString() {
		String outputstring = getRank()+ " of " +getSuit();

		return outputstring;
	}
}
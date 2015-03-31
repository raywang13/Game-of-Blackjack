//Ray Wang
//Project 2
//BlackJackPlayer.java

import java.security.SecureRandom;
import java.util.Scanner;

public class BlackJackPlayer {

	private static final SecureRandom randomNum = new SecureRandom();

	public static void main(String[] args) {
		//creates new scanner
		Scanner scan = new Scanner(System.in);

		//creates array of suits
		String [] suits = {
			new String("Clubs"), new String("Diamonds"), new String("Hearts"), new String("Spades")
		} ;

		//creates array of ranks
		String [] ranks = {
			new String("Ace"), new String("2"), new String("3"), new String("4"),
			new String("5"), new String("6"), new String("7"), new String("8"),
			new String("9"), new String("10"), new String("Jack"), new String("Queen"),
			new String("King")
		} ;

		//creates array for deck of card
		Card [] deck = new Card[52];
		
		//counts number of cards in array deck
		int countIndex = 0;

		//assigns each element in the deck to a rank, suit, value, and boolean dealt
		for(int i = 0; i < suits.length; i++) {
			int cardVal = 1; //gives value of the card
			for(int j = 0; j < ranks.length; j++) { //designates card value
				if(j > 9) { //sets 10 through King to value 10
					cardVal = 10;
				}
				if(cardVal == 1) { //sets Ace to value 11
					deck[countIndex] = new Card(ranks[j], suits[i], 11, false);
				}
				else{
					deck[countIndex] = new Card(ranks[j], suits[i], cardVal, false);
				}
				cardVal++;
				countIndex++;
			}
		}

		shuffleDeck(deck);

		// printDeck(deck);

		Player a = new Player(1);
		Player b = new Player(2);

		System.out.println("\nCards are now being dealt.");
		
		//deals two cards to each player
		a.getCardfromDeck(deck);
		a.getCardfromDeck(deck);
		b.getCardfromDeck(deck);
		b.getCardfromDeck(deck);


		//displays each players hand and hand total
		System.out.print("Player 1's hand:\n");
		a.displayHand();
		a.getPlayerTotal();
		int x = a.getPlayerTotal();
		System.out.println("Player 1's total is: " +x);
		//checks if player has BlackJack
		if(a.getPlayerTotal() == 21) {
			System.out.println("Player 1 wins!");
			System.exit(0);
		}
		

		//displays each players hand and hand total
		System.out.print("\nDealer's hand:\n");
		b.displayHand();
		b.getPlayerTotal();
		int y = b.getPlayerTotal();
		System.out.println("Dealers's total is: " +y);
		//checks if player has BlackJack
		if(b.getPlayerTotal() == 21) {
			System.out.println("Dealer wins!");
			System.exit(0);
		}

		//asks if player 1 wants another card. if player 1's input is not "yes" or "no", program will exit.
		//if player 1 says "yes", then player 1 will be dealt another card
		//if player 1's hand total goes over 21, then player 1 loses. 
		System.out.println("\nPlayer 1, your current total is: " +a.getPlayerTotal());
		System.out.println("Player 1, would you like to hit? (Yes/No)");
		String p1choice = scan.next();
		if(!p1choice.equalsIgnoreCase("no") && !p1choice.equalsIgnoreCase("yes")) {
			System.out.println("Inavlid input. Exiting program.");
			System.exit(0);
		}
		while(p1choice.equalsIgnoreCase("yes")) {
				a.getCardfromDeck(deck);
				a.displayHand();
				x = a.getPlayerTotal();
				System.out.println("Player 1's total is: " +x);
				if(a.getPlayerTotal() > 21) {
					System.out.println("Player 1, you lose. Dealer wins. #sadlyfe");
					System.exit(0);
				}
				System.out.println("Would you like to hit again? (Yes/No)");
				p1choice = scan.next();
		}


		//dealer will be dealt another card as long as dealer's hand total is less than 16
		//dealer will stop receiving cards if dealer's hand total is greater than 16 and
		//less than 21. if dealer's hand total is over 21, dealers loses.
		System.out.println("\nDealer, your current total is: " +b.getPlayerTotal());
		while(b.getPlayerTotal() < 16 || b.getPlayerTotal() < a.getPlayerTotal()) {
				System.out.println("Dealer will be dealt another card.");
				b.getCardfromDeck(deck);
				b.displayHand();
				y = b.getPlayerTotal();
				System.out.println("Dealer's total is: " +y);
				if(b.getPlayerTotal() > 21) {
					System.out.println("Dealer loses. Player 1 wins. #impossibru!");
					System.exit(0);
				}
		}

		//determines winner if neither player 1 or dealer busts
		if(b.getPlayerTotal() > a.getPlayerTotal()) {
			System.out.println("Player 1 loses. Dealer wins. #GGn00b");
		}
		else if(a.getPlayerTotal() == b.getPlayerTotal()) {
			System.out.println("It's a tie. Well played.");
		}

		

	} //end of main

	//prints deck
	public static void printDeck(Card [] deck) {
		System.out.println("The cards in the deck (after shuffling) are: ");
		for(Card aCard : deck) {
			System.out.println(aCard);
		}
	}

	//shuffles the deck
	public static void shuffleDeck(Card [] deck) {
		for(int first = 0; first < deck.length; first++) {
			int second = randomNum.nextInt(52);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

} //end of class
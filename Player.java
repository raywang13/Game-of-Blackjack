//Ray Wang
//Project 2
//Player.java

import java.util.Random;

public class Player {
		
		int playerID;
		int indexCounter = 0; //counts number of elements in array pCards
		private Card [] pCards = new Card [12]; //array of player's cards

		//constructor for player
		Player(int playerID) {
			this.playerID = playerID;
		}

		//adds card to player hand
		public void addCard(Card dealt) {
			pCards[indexCounter] = dealt;
			indexCounter++;
		}

		//displays player hand
		public void displayHand() {
			for(int i = 0; i < indexCounter; i++) {
				System.out.println(pCards[i]);
			}
		}

		//takes random card from deck, checks to see if it's been dealt,
		//if dealt, then another card is picked. if the card has not been dealt,
		//the addCard method will be called, adding the selected card to the player's handb
		public void getCardfromDeck(Card [] deck) {
			Random rn = new Random();
			Card aCard = deck[rn.nextInt(52)];
			while(aCard.getDealt() == true) {
				aCard = deck[rn.nextInt(52)];
			}
			this.addCard(aCard);
			aCard.setDealt(true);
		}

		//calculates and prints the total value of the cards in the player's hand
		public int getPlayerTotal() {
			int total = 0;
			int aceCounter = 0;
			for(int i = 0; i < indexCounter; i++) {
				if(pCards[i].getValue() == 11) {
					aceCounter++;
				}
				total += pCards[i].getValue();
			}
			//if player draws an ace and player's total is greater than 21, then
			//we subtract 10 * the number of aces to get the new total. this would
			//give us the same total as if ace was set to 1.
			if(total > 21 && aceCounter > 0) {
				total -= 10*aceCounter;
			}
			return total;
		}


		//toString for cards in player's hand
		public String toString() {
			String returnString = ""; 
			for(int i = 0; i < indexCounter; i++) {
				returnString = returnString.concat(pCards[i].toString());
			}
			return returnString; 
		}

}
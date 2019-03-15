package gamepack;

import java.util.Scanner;

public class Drive{	
	Deck deck = new Deck();				//create new deck of card
	Scanner scn = new Scanner(System.in);
	Hand player = new Hand();			// create a person
	Hand computer = new Hand();				// create a Computer
	Card topCard = new Card();			// create a topCard variable to keep track what card are on the table
	

	
	/**
	 * so when the person/player and the computer is created
	 * this method will shuffle the deck and give the both
	 * player and computer 7 cards from the deck
	 */
	void initialize(){
		deck.shuffle();			// shuffle the new deck
		
		
		// deal card for player and computer
		deck.dealCard(7, player);	
		deck.dealCard(7, computer);
		
		
		//sort player Cards
		player.sortBySuit();
		player.sortByValue();
		
		System.out.println("Your Card on hand: ");
		player.showCard();
		
		
		topCard = deck.dealCard();
	
		playGame();
	}
	/**
	 * this method is the root of the whole game
	 * it sets the rules for the whole game as well as 
	 * validate whether and System.out.println(); whatever is necessary
	 */
	void playGame(){
		while(player.getCardCount() != 0 && computer.getCardCount() != 0){
			System.out.println("\nthe card on top is: " + topCard.toString());
			System.out.println("Here is your options: ");
			System.out.println("\nSuits:");
			int numOptions = player.optionsForSuit(topCard); // shows option by Suits
			System.out.println("\nValue:");
			numOptions += player.optionsForValue(topCard); // show option by Rank
			
			if(numOptions == 0){
				
				
				//if they player can't play anycard.
				
				/*
				 * I don't have enough time to figuring out the 4 
				 * card pick up, rule of crazy egith yet
				 * */
				
				
				System.out.println("You have to draw");
				deck.dealCard(1, player);
				System.out.println("New Card on hand is: ");
				player.showCard();
			}
			else{
				System.out.println("\n\nDo you want to play a card: (1 = suit, 2 = value)");
				int in = scn.nextInt();			
				if(in == 1){
					topCard = player.removeBySuit(topCard);
				}
				else if(in == 2) {
					topCard = player.removeByValue(topCard);
				}
				
				System.out.println("You new card on hand is: ");
				player.showCard();
				System.out.println("the new Top Card is: " +topCard.toString());
			}
			System.out.println("\n\nComputeruter's turn....");
			topCard = computer.computerPlay(topCard);

		}
		if(computer.getCardCount() == 0){
			System.out.println("\n computeruter won!");
		}
		else{
			System.out.println("\n you won!");
		}
	}
	
	

}
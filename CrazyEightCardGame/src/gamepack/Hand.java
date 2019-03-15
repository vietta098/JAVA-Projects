package gamepack;
import java.util.ArrayList;


/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */
public class Hand {
    private ArrayList<Card> hand;   // The cards in the hand.

    /**
     * Create a hand that is initially empty.
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * Remove all cards from the hand, leaving it empty.
     */
    public void clear() {
        hand.clear();
    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param c the non-null card to be added.
     * @throws NullPointerException if the parameter c is null.
     */
    public void addCard(Card c) {
        if (c == null)
            throw new NullPointerException("Can't add a null card to a hand.");
        hand.add(c);
    }

    /**
     * Remove a card from the hand, if present.
     * @param c the card to be removed.  If c is null or if the card is not in 
     * the hand, then nothing is done.
     */
    public void removeCard(Card c) {
        hand.remove(c);
    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void removeCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: "
                    + position);
        hand.remove(position);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int getCardCount() {
        return hand.size();
    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size())
            throw new IllegalArgumentException("Position does not exist in hand: " + position);
        return hand.get(position);
    }

    /**
     * Sorts the cards in the hand so that cards of the same suit are
     * grouped together, and within a suit the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1. --- sorting is similar to "selection sort"
     */
    public void sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
       // Collections.sort(list, c);
        hand = newHand;
        //Collections.sort(list, c);
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by suit.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Card c1 = hand.get(i);
                if ( c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
    /*
     * =========================================================
     * 														   =
     * 			Student part								   =
     * 	method to show all the card in hand					   =
     * 														   =
     * 														   =
     * */
    public void showCard() {
    	for(int i = 1; i < hand.size(); i++)
    		System.out.println("\t" + i + ")" + this.getCard(i-1).toString());
    }
    
    /*
     * =========================================================
     * 														   =
     * 			Student part								   =
     * 	method to compare suit and give suggestion			   =
     * 														   =
     * 														   =
     * */
    public int optionsForSuit(Card topCard) {	//sending in card on top to compare
    	int numOptions = 0;
    	
    	for(int i = 0; i < hand.size(); i++) {
    		if(hand.get(i).getSuit() == topCard.getSuit()) {
    			System.out.print((i+1) + ") " + hand.get(i) + "\t");
    			numOptions++;
    		}
    	}
    	
    	return numOptions;
    }
    
    /*
     * =========================================================
     * 														   =
     * 			Student part								   =
     * 	method to compare value and give suggestion			   =
     * 														   =
     * 														   =
     * */
    public int optionsForValue(Card topCard) {
    	int numOptions = 0;
    	for(int i = 0; i < hand.size(); i++) {
    		if(hand.get(i).getValue() == topCard.getValue()) {
    			System.out.print((i+1) + ") " + hand.get(i) + "\t");
    			numOptions++;
    		}
    	}
    	return numOptions;
    }
    
    /*
     * =========================================================
     * 														   =
     * 			Student part								   =
     * 	method to remove rank or suits depends on 			   =
     * 	player options, replace the topCard with the option	   =
     * 														   =
     * */
    
    public Card removeBySuit(Card topCard) {
    	for(int i = 0; i< hand.size(); i++) {
    		if(hand.get(i).getSuit() == topCard.getSuit()) {
    			topCard = hand.get(i);
    			hand.remove(i);
    			i = 0; // this is to remove a pile of cards, keep finding card with same suit
    			
    		}
    	}
    	return topCard; //after the card been choose, replace the topCard.
    }
    
    public Card removeByValue(Card topCard) {
    	for(int i = 0; i< hand.size(); i++) {
    		if(hand.get(i).getValue() == topCard.getValue()) {
    			topCard = hand.get(i);
    			hand.remove(i);
    			i = 0; // this is to remove a pile of cards, keep finding card with same suit
    			
    		}
    	}
    	return topCard; //after the card been choose, replace the topCard.
    }
    
    
    /*
     * =========================================================
     * 														   =
     * 			Student part								   =
     * 	method to let player play with machine first rather	   =
     * 	than 2 humans.										   =	
     * 													       =
     *														   =
     * Note: have to consult another student for this part	   =
     * */
    Card computerPlay(Card topCard){
		int numOfOptionsByRank = 0;
		int numOfOptionsBySuit = 0;
    	for(int  i= 0; i < hand.size(); i++){
    		if(hand.get(i).getSuit() == topCard.getSuit()){
    			numOfOptionsBySuit++;
    		}
    	}
    	for(int  i= 0; i < hand.size(); i++){
    		if(hand.get(i).getValue() == topCard.getValue()){
    			numOfOptionsByRank++;
    		}
    	}
    	if(numOfOptionsByRank >= numOfOptionsBySuit){
    		topCard = removeByValue(topCard);
    	}
    	else{
    		topCard = removeBySuit(topCard);
    	}	
    	return topCard;
    }
    
    
    
}//end of class Hand

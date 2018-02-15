/**
 * \file Hand.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Hand.java
 *
 * \brief Sets the Hands of the Player
 *
 * This class implements the Hand object which collaborates with the Player class and
 * with the class Card and forms an array of cards that this hand has. 
 * This class is responsible to insert and reset the cards in the hand but also 
 * to evaluate the points from the cards in the hand 
 */
/**
 *Begin Hand class
 */

package blackJack;

public class Hand{

	private int Points; // The sum from the value of the cars that the hand has
	private int NumCards; // Number of the cards that the hand holds
	private Card[] cards; // the array of the card that the hand holds
	
 /**This constructor implements the Hand object and initiates the object with
 * the default values
 */
	
	public Hand() {
		cards = new Card[12];
		NumCards = 0;
		Points = 0;
	}
	
 /**This method inserts a cards in the hand , increases the NumCards ,
 * updates the points which the hand holds and returns false. If the the array
 * of the cards is full , the card is not inserted and returns false;
 *\ param card
 *\ return boolean
 */	
	public boolean getCard(Card card) { 
		if(this.cards.length > this.NumCards) {
		this.cards[NumCards++] = card; 
		this.Points = this.getHandPoints();
		return true;
		}
		else
		return false;
		}
	
 /**This method returns an array of the cards that the hand holds.
 *\ return cards
 */	

	public Card[] getCards() {
		Card[] cards = new Card[this.NumCards];
		if(this.NumCards != 0 )
		for( int i = 0 ; i < this.NumCards ; i++)
			cards[i]=this.cards[i];
		else
			System.out.println("No cards");
		return cards;
	}
	
 /**This method returns the sum of the points from the Value of the cards 
  * that the hand holds.
 *\ return points
 */		
	public int getHandPoints() {
		int points = 0;
		for(int i = 0 ; i < this.NumCards ; i++)
			points+=this.cards[i].getValue(); 
		return points;
	}
	
 /**This method returns the number of cards the given rank the hand holds
 *\ param rank  
 *\ return counter
 */		
	public int getNumberOf(final String rank) {
		int counter = 0;
		for(int i = 0 ; i < this.NumCards ; i++)
				if(this.cards[i].checkFor(rank))
					counter++; 
		return counter;
	}
	
 /**This method evaluates the cards that the hand holds and decides if the 
  * hand is bust or not. The hand is bust if the sum is above 21. Also ,It considers
  * property of the Ace to count as 11 or 1.
 *\  
 *\ return boolean (decision)
 */
	
	public boolean checkBust() {
		this.resetPoints();
		this.Points = this.getHandPoints();
		if(this.Points > 21) {
			int Aces = this.getNumberOf("Ace");
		for(int i = 0 ; i < Aces ; i++)
			{
			this.subtractPoints(10);
			if(this.Points <= 21)
				break;
			}
	}
		if(this.getPoints() > 21)
			return true;
		else
			return false;
	}

 /**This method returns the card that which corresponds to the given index number
 *\ return card
 */
		
	public Card getCard(int index) { return this.getCards()[index]; } 
	
 /**This method resets the number of the cards that the hand holds
 *\ 
 */
	
	public void resetHand() { this.NumCards = 0 ; }

 /**This method returns the number of the cards that the hand holds
 *\ return NumCards
 */	
	
	public int getNumCards() { return NumCards; }
	
 /**This method returns the Points that all ready the hand has
 *\ return Points
 */		
	
	public int getPoints() { return this.Points; }
	
 /**This method adds Points to the hand and return true if the current and the inserted 
  * points are positive it returns true . Otherwise it return false .
 *\ param (int)points
 *\ return boolean
 */
	
	public boolean addPoints(int points) { 
		if(this.Points > 0 && points > 0) {
		this.Points += points; 
		return true;
		}
		else
		return false;
	}
	
 /**This method subtract Points to the hand and return true if the current and the inserted 
 * points are positive and negative respectively it returns true . Otherwise it return false .
 *\ param (int)points
 *\ return boolean
 */
	
	public boolean subtractPoints(int points) { 
		if(this.Points > 0 && points < 0) {
		this.Points -= points; 
		return true;
		}
		else
		return false;
	}
	
/** This method resets the points from the hand
 */
 public void resetPoints() { 
	 this.Points = 0 ; 
	 }

}

/**
 * \file Lock.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see Lock.java
 *
 * \brief Sets lock in the game
 *
 * This class implements the lock and collaborates with the class Card
 */
/**
 *Begin Lock class
 */

package blackJack;
public class Lock { 
	
	private int lockSize; // Number of Cards in the lock
	private Card[] cards; // Array of Cards in the lock
	private int usedCards; // Number of used cards;
	private int numberOfDecks; // Number of decks that form the lock

 /**This constructor implements the lock and initiates the the lock
 * .It sets the number of the decks in the lock , 
 * the difficulty of the dealer and a list with the names
 *\ param numberOfDecks
 */

	public Lock (int numberOfDecks){
		this.numberOfDecks=numberOfDecks;
		this.usedCards = 0;
		int counter = 0;
		this.lockSize = this.numberOfDecks * 52; 	
		cards = new Card[this.lockSize];
		
		for(int k = 1 ; k <= numberOfDecks ; k++) {
		for(int i = 0 ; i < 4 ; i++) 
			for(int j = 0 ; j < 13 ; j++)
				{
				this.cards[counter] = new Card(i , j ,k);
			//	this.cards[counter].printCard();
				counter++;
				}
		}
		}
		
 /**This  method returns the number of the cards are in the lock
  *\return lockSize
  */
	public int getlockSize() {return this.lockSize;}

 /**This  method returns the number of the cards are in the lock
 *\return numberOfDecks
 */
	public int getnumberOfDecks() {return this.numberOfDecks; } 
	
 /**This  method returns the number of the Used cards are in the lock
 *\return usedCards
 */
	public int getUsedCards () {return this.usedCards; }

 /**This method resets the the used Cards in the Lock
  */
	public void resetLock () { this.usedCards = 0; } // Resets lock

 /**This method shuffles only the cards that they are after the index number 
  * and returns a true or false if the shuffling is done without or with problems
  * respectively
 *\ param index
 *\ return boolean
 */
		
	public boolean ShufflleNext(int intex){
		if(intex >= this.lockSize )
			return false;
		for (int i = intex; i < this.lockSize; i++) {
			int r = i + (int) (Math. random() * (intex-i));
				if(this.cards[r] == null && this.cards[i] == null)
					return false;
		Card Temporary = this.cards[r];
		this.cards[r] = this.cards[i];
		this.cards[i] = Temporary;
		}
		return true;
	}
		
 /**This method shuffles only the cards that they are after the number of usedCards 
  * and returns a true or false if the shuffling is done without or with problems
  * respectively
 *\ return boolean
 */
		
	public boolean ShufflleNext(){ return this.ShufflleNext(this.usedCards); }
		
 /**This method gets the top card of the lock and increases the number of usedCards
 * by one
 *\ return Card
 */
		
		public Card getTopCard() {
			if(this.usedCards <= this.lockSize)
				return this.cards[this.usedCards++];
			else 
				return new Card ("RunOut","OfCards");
			}
		
 /**This method prints all the details of all cards in the lock.
 */
		
		public void printLock() {
			for(int i = 0 ; i < this.lockSize ; i++)
				this.cards[i].printCard();
		}

 /**This method gets the number of the usedCards , it compares with the inserted
 * number of cards and resets the lock when the number of the usedCards is below
 * the numberCards. It returns a boolean function if the lock is shuffled
 *\ param numberCards
 *\ return (boolean)
 */
		
		public boolean checkLock(int numberCards) {
			int remainCards = this.lockSize - this.usedCards;
			System.out.println("Remain Cards : "+ remainCards);
			if ( numberCards > remainCards ) {
				this.resetLock();
				System.out.println("The Lock is reset");
			return true;
			}
			else
			return false;
		}
}

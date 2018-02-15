/**
 * \file BlackJack.java
 * \author Georgios Papageorgiou
 * \date 14 February 2018
 * \see BlackJack.java
 *
 * \brief Sets the Black Jack Game
 *
 * This class implements the game of the black Jack . It is super class of
 * Round and HighScore and collaborates with Player , Lock and Print classes
 */
/**
 *Begin BlackJack class
 */

package blackJack;

public class BlackJack{

	protected Player[] players; // array of the objects Players
	private Lock lock; // a lock of Cards
	public Print out;// class prints all the details of the players
	protected int currentRound; // number of the current rounds
	public Logic logic; // this class evaluates and estimates the results 
	
/**This constructor implements the game of BlackJack and initiates the
* parameters of the game. It sets the players and the number of the deck
* wich the lock will contains .
*\ param players
*\ param numberDecks
*/	
	
	public BlackJack (Player [] players, int numberDecks) {
		 this.players = players;
		 this.lock = new Lock(numberDecks);
		 this.out = new Print(players);
		 this.logic = new Logic(players);
		 this.currentRound=1;
		}	
	
/**This method sets the players who will play the game 
*\ param players
*/
	
	public void setPlayerList(Player[] players) {
	this.players =  players; 
	}	
	
/**The play method implements the core of the game. It uses the objects
* Initialized by the constructor and runs a single round of the game
*\ return currentRound
*/
	
	public int play() {
		System.out.println("************* Rounds : " + this.currentRound++ + 
				"***********************************");
		for(int i = 0 ; i < players.length ; i++ ) {
			this.players[i].hand.resetPoints();
			this.players[i].hand.resetHand();
			this.players[i].resetBust();
		}
		lock.ShufflleNext();
		for(int i = 0 ; i < players.length ; i++ ) {
			players[i].hand.getCard(lock.getTopCard());
			players[i].hand.getCard(lock.getTopCard());
		}

		for(int i = 0 ; i < players.length ; i++ ) {
			if(lock.checkLock(25))
				lock.ShufflleNext();
			this.out.printAllStatus();
			
			while (!this.players[i].getBust()) {
				this.players[i].printStatus();
				if(this.players[i].getDecition()) 
				{
				this.players[i].hand.getCard(lock.getTopCard());
				if(this.players[i].hand.checkBust())
				this.players[i].setBust();
				}
				else 
				break;
			}//end while
		}//end for
		this.out.printAllStatus();
		this.logic.shareScore();
		this.out.printPointList();
		this.out.printScoreList();
		return this.currentRound;
		}	
	}
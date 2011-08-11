package com.genesisengine.playingcards;

import java.util.ArrayList;
import java.util.Random;


public class Deck
{
	public ArrayList<String> alistDeck;
    /**
     * @todo
     * Create a Deck class
     * pull aces from their locations
     * organize into 4 rows.  how do i do that?
     */
	/**
	 * Representations
	 * - as state
	 *   Aces are removed.  Markers are inserted for new rows.
	 *   Need to be able to write these to a file.  With date.
	 *     <date>;<state>
	 *   Newlines are not necessary.
	 * - in deal file
	 *   This is different because it shows the aces in their initial places.
	 *   
	 */
	/*
	 * Maybe I need a card class
	 * suit
	 * value
	 * translation routines
	 * get color
	 * toString [^K][^Q][^J][^0][^9]...[^2][^A]
	 * ^ diamonds
	 * & spades
	 * % clubs
	 * $ hearts
	 */
	/*
	 * Deck would have a get value of previous, get value of next
	 * get card based upon suit and value.  this will need to be overriden
	 * in ParadeDeck.  get card position, based upon suit & value
	 */
	/*
	* Maybe have a ParadeDeck class that extends deck.
	* It would provide the proper representation of a deck as layed out in
	* the game.
	*  - pulls out aces
	*  - toString
	*  
	* array of ArrayLists
	*/
	
    public ArrayList<String> initialize() {
        ArrayList<String> alist = new ArrayList<String>(52);
        // Spades
        alist.add("@1");
        alist.add("@K");
        alist.add("@Q");
        alist.add("@J");
        alist.add("@0");
        alist.add("@9");
        alist.add("@8");
        alist.add("@7");
        alist.add("@6");
        alist.add("@5"); 
        alist.add("@4");
        alist.add("@3");
        alist.add("@2");
        // Hearts
        alist.add("$1");
        alist.add("$K");
        alist.add("$Q");
        alist.add("$J");
        alist.add("$0");
        alist.add("$9");
        alist.add("$8");
        alist.add("$7");
        alist.add("$6");
        alist.add("$5"); 
        alist.add("$4");
        alist.add("$3");
        alist.add("$2");
        // Diamonds
        alist.add("#1");
        alist.add("#K");
        alist.add("#Q");
        alist.add("#J");
        alist.add("#0");
        alist.add("#9");
        alist.add("#8");
        alist.add("#7");
        alist.add("#6");
        alist.add("#5"); 
        alist.add("#4");
        alist.add("#3");
        alist.add("#2");
        // Clubs
        alist.add("%1");
        alist.add("%K");
        alist.add("%Q");
        alist.add("%J");
        alist.add("%0");
        alist.add("%9");
        alist.add("%8");
        alist.add("%7");
        alist.add("%6");
        alist.add("%5"); 
        alist.add("%4");
        alist.add("%3");
        alist.add("%2");

        return alist;
    }

    public ArrayList<String> shuffle( ArrayList<String> alistOriginal ) {
    	int n = alistOriginal.size();
    	ArrayList<Integer> alist    = new ArrayList<Integer>(n);
    	ArrayList<String> alistDeck = new ArrayList<String>(n);
    	for( int i=0; i < n; ++i )
    		alist.add(new Integer(i));
    	
    	Random rand = null;
    	int ind = -1;
    	while( alist.size() > 0 ) {
    		rand = new Random();
    		// Randomly select item based upon current count of array.
    		ind  = rand.nextInt(alist.size());
    		// Get that item; use that item, an index, to pull from deck.
    		alistDeck.add( alistOriginal.get(alist.get(ind).intValue()) );
    		// remove item from list.  now it can't be used again.
    		alist.remove(ind);	
    	}

    	return alistDeck;
    }
}

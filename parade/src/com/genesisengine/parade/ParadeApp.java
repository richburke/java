package com.genesisengine.parade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

import com.genesisengine.playingcards.*;
/**
 * github test.
 */

/*
dev@net:~/workspace/parade$ javac -d bin src/com/genesisengine/parade/*.java
dev@net:~/workspace/parade$ java -classpath .:bin com.genesisengine.parade.ParadeApp

 */

/**
 * deal out the rows
 * pull out aces, place in front
 * add current state to Set
 * determine 4 possible moves
 *  - are any of the results in our success file?
 *    if so, print succeeds
 *  - are any of the results in the failure file?
 *    if so, do not proceed down line
 *  - do any succeed (but are not in file)?
 *    if so, add to success file & print succeeds
 *  - do any fail (but are not in file)?
 *    if so, add to failure file
 
 * Determining possible moves=
 * if there the slot is at the end of the row,
 *    that move fails, move to next
 * look at the card in the previous slot
 * what is it's suit?
 * what is it's value?
 * is there a value that follows it (value != 2)?
 * if not,
 *    that move fails, move to next
 
 * Print successes with date
 */
public class ParadeApp
{
	private final static String sFileNameFailure = "failure.txt";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
        	deal();
        }
        catch (IOException e) { System.err.println(e.getMessage()); }
    }
	    
    /**
     *
     */
    public static void deal() throws IOException {
        Deck deck = new Deck();
        deck.alistDeck = deck.shuffle(deck.initialize());    
        writeToFailureFile( deck.alistDeck.toString() );
    }

    /** A convenience method to throw an exception */
    private static void abort(String msg) throws IOException { 
        throw new IOException("FileCopy: " + msg); 
    }
    
    /*
     * Read from the failure file into state
     * Write to the success file
     * Read from the success file into state
     * Determine if the failure file exists
     * 	If not, create it.
     * Determine if the success file exists
     * 	If not, create it.
     */
    private static void writeToFailureFile( String s ) throws IOException {
    	// Format the string in the form used by the failure file.
    	Date dt = new Date();
        SimpleDateFormat dtformat = new SimpleDateFormat("yyyy:MM:dd HH:mm");
        s = s.substring(1, s.length()-1);
    	s = dtformat.format(dt) + ";" + s + "\n";
    	
    	File f = new File(sFileNameFailure);
     
         // If we've gotten this far, then everything is okay.
         // So we copy the file, a buffer of bytes at a time.
         FileOutputStream fs = null;   // Stream to write to destination
         try {
             fs = new FileOutputStream(f);     // Create output stream
             fs.write( s.getBytes() );
         }
         catch( IOException ex ) { throw ex; }
         // Always close the streams, even if exceptions were thrown
         finally {
             if( fs != null ) try { fs.close(); } catch( IOException e ) { ; }
         }
    }
    
    public void start( ArrayList<String> alist ) {
    	
    }
}

package tictactoe;

/**
 * Created by Vegard Seim Karstang on 10.04.16.
 */
public class Utils {

	// Return the x position given a number from 0 to 8 inclusive
	public static int getBoardX(int pos) {
		return pos % 3;
	}

	// Return the y position given a number from 0 to 8 inclusive
	public static int getBoardY(int pos) {
		return (int) Math.floor(pos / 3.0);
	}

	public static get
}

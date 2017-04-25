/*
 * Dare Roulette version 0.1
 * 4/21/2017
 * by Sam Speake and Jack Allen
 */
public class DareRoulette {
	
	private static boolean adult;
	//1 = mild, 2 = moderate, 3 = spicy
	private static int difficulty;
	public static String latestCustomDare;
	
	public DareRoulette(boolean adult, int difficulty) {
		this.adult = adult;
		this.difficulty = difficulty;
	}
	
	//returns whether or not the game is in adult mode
	public static boolean isAdult() {
		return adult;
	}
	
	//set's the game to be in or not in adult mode
	public static boolean setAdult(boolean o) {
		adult = o;
		return adult;
	}
	
	//returns the game's current difficulty
	public static int getDifficulty() {
		return difficulty;
	}
	
	//sets the game's current difficulty IF you pass it a setting from 1 to 3
	public static int setDifficulty(int o) {
		if (1 <= o && o <= 3) {
			difficulty = o;
		} else {
			System.out.println("You're trying to pass a difficulty setting that isn't real!");
		}
		return difficulty;
	}
	
	public static String customDare(String o) {
		System.out.println(o);
		return o;
	}
	
	//resets all settings
	public static void reset() {
		adult = false;
		difficulty = 1;
	}
}

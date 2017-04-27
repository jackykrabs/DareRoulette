/*
 * Dare Roulette version 0.1
 * 4/21/2017
 * by Sam Speake and Jack Allen
 */

public class DareRoulette {
	
	DareList myDl;
	
	private boolean adult;
	//1 = mild, 2 = moderate, 3 = spicy
	private int difficulty;
	public String latestCustomDare;
	
	public DareRoulette(boolean adult, int difficulty) {
		this.adult = adult;
		this.difficulty = difficulty;
		myDl = new DareList();
	}
	
	//returns whether or not the game is in adult mode
	public boolean isAdult() {
		return adult;
	}
	
	//set's the game to be in or not in adult mode
	public boolean setAdult(boolean o) {
		adult = o;
		return adult;
	}
	
	//get a dare given the criteria boiiii
	public Dare retrieveDare(){
		return myDl.retrieveDare(difficulty, adult);
	}
	
	//returns the game's current difficulty
	public int getDifficulty() {
		return difficulty;
	}
	
	//sets the game's current difficulty IF you pass it a setting from 1 to 3
	public int setDifficulty(int o) {
		if (1 <= o && o <= 3) {
			difficulty = o;
		} else {
			System.out.println("You're trying to pass a difficulty setting that isn't real!");
		}
		return difficulty;
	}
	
	public void customDare(String o) {
		System.out.println(o);
		myDl.addDare(new Dare(o, 1, false, true));
	}
	
	//resets all settings
	public void reset() {
		adult = false;
		difficulty = 1;
		for (int i = myDl.dares.size() - 1; i >= 0; i--) {
			if (myDl.dares.get(i).isCustom()) {
				myDl.removeDare(myDl.dares.get(i));
			}
		}
	}
}

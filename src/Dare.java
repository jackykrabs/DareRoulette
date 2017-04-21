
public class Dare {

	String phrase = new String();
	int difficulty;
	boolean adult;
	
	public Dare(String phrase, int difficulty, boolean adult){
		this.phrase = phrase;
		this.difficulty = difficulty;
		this.adult = adult;
	}
	
	//getters 
	public String getPhrase(){
		return phrase;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public boolean getAdult(){
		return adult;
	}
}

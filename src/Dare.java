
public class Dare {

	String phrase = new String();
	int difficulty;
	boolean adult;
	boolean custom;
	
	public Dare(String phrase, int difficulty, boolean adult, boolean custom){
		this.phrase = phrase;
		this.difficulty = difficulty;
		this.adult = adult;
		this.custom = custom;
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
	
	public boolean isCustom() {
		return custom;
	}
}

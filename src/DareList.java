import java.util.ArrayList;
import java.util.Random;

public class DareList {

	ArrayList<Dare> dares;
	
	public DareList(){
		//TODO: Create the .json file to hold all the dares, and then query them and load them into this list
		dares = new ArrayList<Dare>();
	}
	
	//method to return a random dare given the parameters
	public Dare retrieveDare(int difficulty, boolean isAdult){
		
		//go through the full list of dares and pull out the ones that meet the specific criteria
		ArrayList<Dare> tempDares = new ArrayList<Dare>();
		for (Dare currentDare: dares) {
			if(currentDare.getAdult() == isAdult && currentDare.getDifficulty() == difficulty){
				tempDares.add(currentDare);
			}
		}
		
		//return a random dare that fits the criteria
		Random rand = new Random();
		
		return tempDares.get(rand.nextInt(tempDares.size()));
	}
	
}

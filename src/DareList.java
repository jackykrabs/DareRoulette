import java.util.ArrayList;
import java.util.Random;

public class DareList {

	ArrayList<Dare> dares;
	
	public DareList(){
		//TODO: Create the .json file to hold all the dares, and then query them and load them into this list
		dares = new ArrayList<Dare>();
		initDares();
	}
	
	//method to return a random dare given the parameters
	public Dare retrieveDare(int difficulty, boolean isAdult, boolean isCustom){
		
		//go through the full list of dares and pull out the ones that meet the specific criteria
		ArrayList<Dare> tempDares = new ArrayList<Dare>();
		for (Dare currentDare: dares) {
			if (isCustom) {
				if(currentDare.isCustom() == isCustom){
					tempDares.add(currentDare);
				}
			} else {
				if(currentDare.getAdult() == isAdult && currentDare.getDifficulty() == difficulty){
					tempDares.add(currentDare);
				}
			}
		}
		
		if (tempDares.size() == 0) {
			return null;
		}
		
		//return a random dare that fits the criteria
		Random rand = new Random();
		
		return tempDares.get(rand.nextInt(tempDares.size()));
	}
	
	//method to add dare to list, given a dare
	public void addDare(Dare d){
		dares.add(d);
	}
	
	//method to remove a dare from the list, given a dare
	public void removeDare(Dare d) {
		dares.remove(d);
	}
	
	//method to add dare to list, given the parameters of a dare
	public void addDare(String phrase, int difficulty, boolean adult, boolean custom){
		addDare(new Dare(phrase, difficulty, adult, custom));
	}
	
	//method to initialize the dare list with the default dares
	private void initDares(){
		addDare("Tell the most embarassing thing that's happened to you in the last week.", 1, false, false);
		addDare("Take a Shot.", 2, true, false);
		addDare("Shotgun a soda!", 3, false, false);
		addDare("Shotgun a beer!", 3, true, false);
		addDare("Run down to the end of the street and back in just your underwear", 3, false, false);
		addDare("Cover your chest in peanut butter.", 2, false, false);
		addDare("If you could sleep with anyone in the room who would it be?",2,true, false);
		addDare("Give your phone to the person to the right of you and let them call whoever they want in"
				+ " your contacts.", 3, false, false);
		addDare("Tenessee Chugger!!!", 3, true, false);
		addDare("Call Alex Webber: 573 489 7801, and say 'eeeeaccck'", 1, false, false);
		addDare("Call Alex Webber: 573 489 7801, and say 'eeeeaccck'", 2, false, false);
		addDare("Call Alex Webber: 573 489 7801, and say 'eeeeaccck'", 3, false, false);
		addDare("Call Alex Webber: 573 489 7801, and say 'eeeeaccck'", 1, true, false);
		addDare("Call Alex Webber: 573 489 7801, and say 'eeeeaccck'", 2, true, false);
		addDare("Call Alex Webber: 573 489 7801, and say 'eeeeaccck'", 3, true, false);
		addDare("Eat the booty like groceries.", 1, false, false);
		addDare("Switch clothes with the person of your choice.", 2, false, false);
		addDare("Switch clothes with the person of the opposite gender of your choice.", 2, true, false);
		addDare("Eat a banana with the peel on.", 3, false, false);
		addDare("Get spanked by the person of your choice.", 2, false, false);
		addDare("Do two rounds of 20 crunches and 10 burpees with push up!", 3, false, false);
		addDare("Wet your hair and apply shampoo, but don't wash it off!", 2, false, false);
		addDare("Brush the teeth of the person next to you.", 2, false, false);
		addDare("Post a thousand word facebook status for no reason.", 2 ,false, false);
		addDare("Let the person to your left make your facebook/twitter/instagram profile picture "
				+ "(has to be of you) of their choice.", 2, false, false);
		addDare("Go to your neighbor and ask for a spare condom.", 3, true, false);
		addDare("Walk around the nearest store in nothing but a bathrobe and wet hair.", 3, true, false);
		addDare("Send a dirty email to a person in the group of your choice.", 1, true, false);
		addDare("Apply for Boudoir by Sasser", 2, true, false);
		addDare("Apply for FarmersOnly.com", 2, true, false);
		
		
	}
}

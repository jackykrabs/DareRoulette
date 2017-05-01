import java.util.ArrayList;
import java.util.Random;
/*
class to encapsulate a collection of dares, and provide a method for
for retrieving them
NOTE: Custom Dares are always all pooled together, regardless of 
difficulty or adult content.  
 * */
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
	
	//method for jack and I to know how many dares we have of each kind
	int mild, moderate, spicy, mildAdult, moderateAdult, spicyAdult;
	public void countDares() {
		for (Dare currentDare: dares) {
			if (currentDare.getAdult()) {
				if (currentDare.getDifficulty() == 1) {
					mildAdult++;
				} else if (currentDare.getDifficulty() == 2) {
					moderateAdult++;
				} else if (currentDare.getDifficulty() == 3) {
					spicyAdult++;
				}
			} else {
				if (currentDare.getDifficulty() == 1) {
					mild++;
				} else if (currentDare.getDifficulty() == 2) {
					moderate++;
				} else if (currentDare.getDifficulty() == 3) {
					spicy++;
				}
			}
		}
		System.out.println("Mild: " + mild + " Moderate: " + moderate + " Spicy: " + spicy +
		" Mild Adult: " + mildAdult + " Moderate Adult: " + moderateAdult + " Spicy Adult: " + spicyAdult);
	}
	
	//method to initialize the dare list with the default dares
	//because we're too lazy to make a .json file and parser
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
		addDare("Eat the booty like groceries.", 1, true, false);
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
		addDare("Who was your first kiss?", 1, false, false);
		addDare("Blindfold yourself and slow dance with someone. Try to guess who it is!", 3, false, false);
		addDare("Go to the kitchen and eat the spiciest thing you can find!", 1, false, false);
		addDare("Go 'commando' for the rest of the game!", 1, false, false);
		addDare("Touch your nose with your tongue. If you can't do it, touch another player's nose" +
		" with your tongue.", 1, false, false);
		addDare("Let a player write something on your forehead, then try to guess what they wrote.", 2, false, false);
		addDare("Give a piggyback ride to the player to your right.", 1, false, false);
		addDare("Pick a random contact in your phone, call them, and ask them on a date!", 2, false, false);
		addDare("Put an ice cube in your pocket, and keep it there until it melts.", 1, false, false);
		addDare("Put an ice cube in your gooch, and leave it there until it melts.", 2, true, false);
		addDare("Have another player tie or tape your hands together for the next three rounds.", 1, false, false);
		addDare("Put lipstick on another player, but you're not allowed to use your hands.", 3, false, false);
		addDare("Have another player select a food from the kitchen for you to eat without your hands.", 1, false, false);
		addDare("Poke someone you don't know on Facebook.", 1, false, false);
		addDare("Go to your neighbors and ask to borrow an umbrella.", 1, false, false);
		addDare("Go to your neighbors and ask to borrow a tampon.", 1, true, false);
		addDare("Go to your neighbors and ask to borrow a condom.", 2, true, false);
		addDare("Put on a blindfold and feel another players face. Try to guess who it is!", 1, false, false);
		addDare("Pick a player and repeate everything they say for the next 3 rounds.", 1, false, false);
		addDare("For the rest of your evening, wear some kind of helmet.", 1, false, false);
		addDare("Place both your hands in another players pockets and keep them there for 5 minutes.", 2, false, false);
		addDare("Have another player tie your ankles together and keep them there for the rest of the game.", 3, false, false);
		addDare("Brush someone else's teeth.", 2, false, false);
		addDare("Belly dance to a country song.", 1, true, false);
		addDare("Do a strip tease to a Christmas song.", 2, true, false);
		addDare("Tie a cherry stem with your tongue.", 1, true, false);
		addDare("Twerk", 1, true, false);
		addDare("Lick the nipple of the person to your right!", 3, true, false);
		addDare("Unzip the person to your left's zipper with your teeth.", 2, true, false);
		addDare("Put your hand down someone's pants for the next 2 rounds.", 1, true, false);
		addDare("Make out with the person across from you.", 2, true, false);
		addDare("Kiss the person across from you.", 1, true, false);
		addDare("Eat some kind of food off of someone in the group.", 2, true, false);
		addDare("Masturbate with your clothes on in front of the group.", 3, true, false);
		addDare("Blindfold yourself, spin around for 5 seconds, take off the blindfold and" +
		" enjoy 7 minutes in heaven with whoever you're facing!", 2, true, false);
		addDare("Take a naked selfie and send it to one person in the group!", 3, true, false);
		addDare("Pull up your favorite porn site on your phone!", 1, true, false);
		addDare("Send a nude to your ex!", 3, true, false);
		addDare("Pick a partner and make a porno in front of the group. (With clothes on)", 3, true, false);
		addDare("Kiss a tree.", 1, false, false);
		countDares();		
	}
}

/*
 * Class to import music and sounds into the game (originally used for Jack Allen Asteroids)
 */

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

	FloatControl gainControl;
	float changer;
	Clip clip;
	String fileName;
	boolean loop;
	
	//constructor takes filename (.wav), if the sound loops, and the value of which
	//you want to modify the volume (default is 0)
	public Sound(String fileName, boolean loop, float changer){
		this.fileName = fileName;
		this.loop = loop;
		this.changer = changer;
	}
	
	//plays the sound
	public synchronized void playSound() {
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		    	//get the sound
		        clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        		new File(fileName));
		        clip.open(inputStream);
		        
		        //decide whether to loop
		        if(loop)
		        	clip.loop(Clip.LOOP_CONTINUOUSLY);
		        
		        //change the sound
		        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		        gainControl.setValue(changer);
		        
		        //start the sound
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	
	//stops the sound
	public void stop(){
		clip.stop();
	}
}

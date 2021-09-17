package 小小五子棋;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class loopmusic {
	
	private Clip clip;
	void playMusic(String musicLocation)
	{
		try
		{
			File musicPath = new File(musicLocation);
			
			if(musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else
			{
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	void stop() {
		clip.stop();
	}
	
	void start() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);		
	}
	void playOnce(String musicLocation) {
		try
		{
			File musicPath = new File(musicLocation);
			
			if(musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else
			{
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}


/*播放函数
*		String filepath = "chicken.wav";
		musicStuff musicObject = new musicStuff();
		musicObject.playMusic(filepath);
*/


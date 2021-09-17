package 小小五子棋;


import java.io.BufferedInputStream;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javazoom.jl.decoder.JavaLayerException; 
import javazoom.jl.player.*; 


public class music extends Thread {
	
    Player player;
    String music;
    public music(String file) {
        this.music = file;
    }
     public void run() {
        try {
            play();   
        } catch (FileNotFoundException | JavaLayerException e) {
             e.printStackTrace();
        }
    }

	public void play() throws FileNotFoundException, JavaLayerException { 
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music)); 
        player = new Player(buffer); 
        player.play(); 
    } 
	
	public void Play(String file){
		this.music = file;
		if(player!=null) {
			try {
				play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}	
	
	
	public void Stop(){
		if(player!=null) {
			player.close();
		}		
	}



}

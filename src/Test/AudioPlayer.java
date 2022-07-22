package Test;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {

    public static Map<String,Sound> soundMap=new HashMap<String, Sound>();
    public static Map<String, Music> musicMap=new HashMap<String,Music>();

    public static void load(){

        try {
            soundMap.put("menu_sound",new Sound("res/Beep.wav"));
            soundMap.put("attack_sound",new Sound("res/Attack.wav"));
            soundMap.put("end_sound",new Sound("res/End.wav"));

            musicMap.put("music",new Music("res/GameSound.wav"));
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    public  static Music getMusic(String key){
        return musicMap.get(key);
    }

    public static Sound getSound(String key){
        return soundMap.get(key);
    }
}

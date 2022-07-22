package Test;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sprite;

    public SpriteSheet(BufferedImage ss){
        this.sprite=ss;
    }

    public BufferedImage grabImage(){
        BufferedImage img=sprite;
        return img;
    }
}

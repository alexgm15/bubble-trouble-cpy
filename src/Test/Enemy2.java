package Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy2 extends GameObject{

    private BufferedImage enemy2_image;

    public Enemy2(int x, int y, ID id) {
        super(x, y, id);
        velX= (float) 0.7;
        velY= (float) 2.2;

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet8);
        enemy2_image=ss.grabImage();
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y,50,50);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y<=Game.HEIGHT-300||y>=Game.HEIGHT-109)
            velY*=-1;
        if (x<=18||x>=Game.WIDTH-80)
            velX*=-1;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemy2_image, (int) x, (int) y,null);
    }
}


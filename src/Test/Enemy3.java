package Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy3 extends GameObject{

    private BufferedImage enemy3_image;

    public Enemy3(int x, int y, ID id) {
        super(x, y, id);
        velX= (float) 2;
        velY= (float) 2.2;

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet9);
        enemy3_image=ss.grabImage();
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y,100,100);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y<=Game.HEIGHT-300||y>=Game.HEIGHT-160)
            velY*=-1;
        if (x<=20||x>=Game.WIDTH-130)
            velX*=-1;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemy3_image, (int) x, (int) y,null);
    }
}


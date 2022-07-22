package Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject{

    private BufferedImage enemy_image;

    public Enemy(int x, int y, ID id) {
        super(x, y, id);
        velX= (float) -1.8;
        velY= (float) 2;

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet7);
        enemy_image=ss.grabImage();
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y,20,20);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y<=Game.HEIGHT-300||y>=Game.HEIGHT-90)
            velY*=-1;
        if (x<=20||x>=Game.WIDTH-63)
            velX*=-1;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemy_image, (int) x, (int) y,null);
    }
}

package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
    Handler handler;

    private BufferedImage player_image;
    private BufferedImage player_image_left;
    private BufferedImage player_image_right;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        //velX=1;

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet);
        player_image=ss.grabImage();

        SpriteSheet ss_left=new SpriteSheet(Game.sprite_sheet5);
        player_image_left=ss_left.grabImage();

        SpriteSheet ss_right=new SpriteSheet(Game.sprite_sheet6);
        player_image_right=ss_right.grabImage();
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x,(int)y-24,42,99);
    }

    @Override
    public void tick() {
        x+=velX;
        //y+=velY;

        x=Game.border((int) x,19,Game.WIDTH-75);

        collision();
    }

    private void collision(){
        for (int i=0;i<handler.object.size();i++){
            GameObject tempObject=handler.object.get(i);
            if (tempObject.getID()==ID.Enemy||tempObject.getID()==ID.Enemy2||tempObject.getID()==ID.Enemy3){
                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH-=1;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        for (int i=0;i<handler.object.size();i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID()==ID.Player)
                if (tempObject.getVelY()==1){
                    g.drawImage(player_image_left,(int) x,(int) y-24,null);
                } else if (tempObject.getVelY()==0) {
                    g.drawImage(player_image_right,(int) x,(int) y-24,null);
                } else if (tempObject.getVelY()==2){
                    g.drawImage(player_image,(int) x,(int) y-20,null);
                }
        }

    }
}

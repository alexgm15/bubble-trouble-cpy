package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerAttack extends GameObject{

    Handler handler;

    private BufferedImage attack_image;

    public PlayerAttack(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=0;
        velY=5;

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet2);
        attack_image=ss.grabImage();
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x, (int) y,4,Game.HEIGHT-25);
    }

    @Override
    public void tick() {
        y-=velY;

        collision();
    }

    private void collision(){
        for (int i=0;i<handler.object.size();i++){

            GameObject tempObject=handler.object.get(i);
            if (tempObject.getID()==ID.Enemy){
                if (getBounds().intersects(tempObject.getBounds())){
                    handler.removeObj(tempObject);

                    for (int j=0;j<handler.object.size();j++) {
                        GameObject tempObject2 = handler.object.get(j);
                        if (tempObject2.getID()==ID.PlayerAttack){
                            handler.removeObj(tempObject2);
                            break;
                        }
                    }
                }
            }else if (tempObject.getID()==ID.Enemy2){
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.addObj(new Enemy((int) (tempObject.getX()), (int) (tempObject.getY()), ID.Enemy));
                    Enemy e=new Enemy((int) (tempObject.getX()), (int) (tempObject.getY()), ID.Enemy);
                    e.setVelX((float)1.5);
                    handler.addObj(e);
                    handler.removeObj(tempObject);

                    for (int j = 0; j < handler.object.size(); j++) {
                        GameObject tempObject2 = handler.object.get(j);
                        if (tempObject2.getID() == ID.PlayerAttack) {
                            handler.removeObj(tempObject2);
                            break;
                        }
                    }
                }
            }else if (tempObject.getID()==ID.Enemy3) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.addObj(new Enemy2((int) (tempObject.getX()), (int) (tempObject.getY()), ID.Enemy2));
                    Enemy2 e=new Enemy2((int) (tempObject.getX()), (int) (tempObject.getY()), ID.Enemy2);
                    e.setVelX((float)-0.7);
                    handler.addObj(e);
                    handler.removeObj(tempObject);

                    for (int j = 0; j < handler.object.size(); j++) {
                        GameObject tempObject2 = handler.object.get(j);
                        if (tempObject2.getID() == ID.PlayerAttack) {
                            handler.removeObj(tempObject2);
                            break;
                        }
                    }
                }
            }
                if(tempObject.getID()==ID.PlayerAttack){
                    if(tempObject.getY()<=25){
                        handler.removeObj(tempObject);
                    }
                }
        }
    }

    @Override
    public void render(Graphics g) {

        //g.setColor(Color.CYAN);
        g.drawImage(attack_image, (int) x, (int) y,null);
    }
}


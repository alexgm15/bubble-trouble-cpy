package Test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class KeyInput extends KeyAdapter {

    int x,y;
    public boolean ok=true;
    private Handler handler;
    private boolean[] keyDown=new boolean[2];

    Game game;

    public KeyInput(Handler handler,Game game){
        this.game=game;
        this.handler=handler;
        keyDown[0]=false;
        keyDown[1]=false;
    }

    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();

        for (int i=0;i<handler.object.size();i++){
            GameObject tempObject=handler.object.get(i);

            if(tempObject.getID()==ID.Player){
                if(key==KeyEvent.VK_A) {tempObject.setVelX(-5);keyDown[0]=true;tempObject.setVelY(1);}
                if(key==KeyEvent.VK_D) {tempObject.setVelX(5);keyDown[1]=true;tempObject.setVelY(0);}
                if(key==KeyEvent.VK_SPACE && ok){
                    handler.addObj(new PlayerAttack((int) (tempObject.getX()+14), (int) (tempObject.getY()-5), ID.PlayerAttack,handler));
                    tempObject.setVelY(2);
                    AudioPlayer.load();
                    AudioPlayer.getSound("attack_sound").play();
                }
            }

            if(tempObject.getID()==ID.PlayerAttack){
                if (tempObject.getY()<=20){
                    ok=true;
                    return;
                }else if(tempObject.getY()>20){
                    ok=false;
                    return;
                }
            }
        }
        ok=true;

        if (key== KeyEvent.VK_P){
            if (game.gameState== Game.STATE.GAME){
                if (Game.paused) Game.paused=false;
                else Game.paused=true;
            }
        }
        if (key==KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();

        for (int i=0;i<handler.object.size();i++){
            GameObject tempObject=handler.object.get(i);

            if(tempObject.getID()==ID.Player){
                if(key==KeyEvent.VK_A) keyDown[0]=false;//tempObject.setVelX(0);
                if(key==KeyEvent.VK_D) keyDown[1]=false;//tempObject.setVelX(0);

                if(!keyDown[0] && !keyDown[1]) tempObject.setVelX(0);
            }
        }
    }
}

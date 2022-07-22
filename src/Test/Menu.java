package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Menu extends MouseAdapter {

    Game game;
    private Handler handler;
    private HUD hud;
    private Random r=new Random();
    Image bg;

    private BufferedImage background_image;

    public Menu(Game game,Handler handler,HUD hud){
        this.game=game;
        this.handler=handler;
        this.hud=hud;

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet3);
        background_image=ss.grabImage();
    }

    public void mouseReleased(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();


        //play button
        if (game.gameState== Game.STATE.MENU)
            if (mouseOver(mx,my,Game.WIDTH/2-150,260,300,50)){
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();

                game.gameState= Game.STATE.SELECT;
                return;
            }

        //help button
        if (game.gameState== Game.STATE.MENU)
            if (mouseOver(mx,my,Game.WIDTH/2-150,360,300,50)){
                game.gameState= Game.STATE.HELP;
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();
            }

        //quit button
        if (game.gameState== Game.STATE.MENU)
            if (mouseOver(mx,my,Game.WIDTH/2-150,460,300,50)){
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();
                System.exit(1);
            }

        //back button for help
        if (game.gameState == Game.STATE.HELP){
            if (mouseOver(mx,my,Game.WIDTH/2-150,600,300,50)){
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();
                game.gameState= Game.STATE.MENU;
                return;
            }
        }


        //select difficulty menu
        if (game.gameState == Game.STATE.SELECT){

            //normal difficulty button
            if (mouseOver(mx,my,Game.WIDTH/2-150,260,300,50)){
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();

                game.gameState= Game.STATE.GAME;
                game.diff=0;

                handler.addObj(new Player(Game.WIDTH/2-15,Game.HEIGHT-109,ID.Player,handler));
                handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                game.diff=0;
            }

            //hard difficulty button
            if (mouseOver(mx,my,Game.WIDTH/2-150,360,300,50)){
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();

                game.diff=1;

                game.gameState= Game.STATE.GAME;
                handler.addObj(new Player(Game.WIDTH/2-15,Game.HEIGHT-109,ID.Player,handler));
                handler.addObj(new Enemy3(50,Game.HEIGHT-300,ID.Enemy3));
                game.diff=1;
            }

            //back button for difficulty
                if (mouseOver(mx,my,Game.WIDTH/2-150,460,300,50)){
                    AudioPlayer.load();
                    AudioPlayer.getSound("menu_sound").play();

                    game.gameState= Game.STATE.MENU;
                    return;
                }
        }

        if (game.gameState == Game.STATE.END){
            if (mouseOver(mx,my,Game.WIDTH/2-150,460,300,50)){
                AudioPlayer.load();
                AudioPlayer.getSound("menu_sound").play();

                game.gameState= Game.STATE.SELECT;
                return;
            }
        }
    }

    private boolean mouseOver(int mx,int my,int x,int y,int width,int height){
        if (mx>x && mx<x+width){
            if(my>y && my<y+height){
                return true;
            } else return false;
        }else return false;
    }

    public void tick(){

    }

    public void render(Graphics g){

        g.drawImage(background_image, 0, 0, null);

        if (game.gameState== Game.STATE.MENU){

            Font fnt=new Font("monospaced",3,75);
            Font fnt2=new Font("monospaced",3,25);
            g.setFont(fnt);
            g.setColor(Color.ORANGE);
            g.drawString("Menu",Game.WIDTH/2-85,150);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,260,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,260,300,50);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,360,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,360,300,50);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,460,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,460,300,50);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawString("PLAY",Game.WIDTH/2-35,290);
            g.drawString("HELP",Game.WIDTH/2-35,390);
            g.drawString("QUIT",Game.WIDTH/2-35,490);
        } else if (game.gameState== Game.STATE.HELP) {

            Font fnt=new Font("monospaced",3,75);
            Font fnt2=new Font("monospaced",3,25);
            Font fnt3=new Font("monospaced",3,20);
            g.setFont(fnt);
            g.setColor(Color.ORANGE);
            g.drawString("HELP",Game.WIDTH/2-100,150);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,600,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,600,300,50);

            g.setColor(Color.red);
            g.fillRect(150,180,700,380);
            g.setColor(Color.YELLOW);
            g.drawRect(150,180,700,380);
            g.setFont(fnt3);
            g.setColor(Color.WHITE);
            g.drawString("Use A D keys to move and SPACE to shoot.",210,250);
            g.drawString("The Big Ball splits up into two Medium Balls.",210,280);
            g.drawString("The Medium Ball splits up into two Small Balls.",210,310);
            g.drawString("You can choose between NORMAL and HARD mode.",210,350);
            g.drawString("Hold in there as long as you can.",210,400);
            g.drawString("GOOD LUCK!",210,440);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawString("BACK",Game.WIDTH/2-35,630);
        }else if (game.gameState== Game.STATE.SELECT){

            Font fnt=new Font("monospaced",3,45);
            Font fnt2=new Font("monospaced",3,25);
            g.setFont(fnt);
            g.setColor(Color.ORANGE);
            g.drawString("SELECT DIFFICULTY",Game.WIDTH/2-230,150);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,260,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,260,300,50);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,360,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,360,300,50);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,460,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,460,300,50);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawString("NORMAL",Game.WIDTH/2-40,290);
            g.drawString("HARD",Game.WIDTH/2-30,390);
            g.drawString("BACK",Game.WIDTH/2-30,490);
        }else if (game.gameState== Game.STATE.END) {

            Font fnt=new Font("monospaced",3,45);
            g.setFont(fnt);
            g.setColor(Color.ORANGE);
            g.drawString("GAME OVER",Game.WIDTH/2-125,150);

            Font fnt2=new Font("monospaced",3,25);
            g.setFont(fnt2);
            g.setColor(Color.ORANGE);
            g.drawString("You lost with a score of: "+hud.getScore(),Game.WIDTH/2-220,100);

            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2-150,460,300,50);
            g.setColor(Color.YELLOW);
            g.drawRect(Game.WIDTH/2-150,460,300,50);

            g.setFont(fnt2);
            g.setColor(Color.WHITE);
            g.drawString("TRY AGAIN",Game.WIDTH/2-70,490);
        }
    }
}

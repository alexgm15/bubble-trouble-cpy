package Test;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH=1024, HEIGHT=WIDTH/12*9;
    private Thread thread;
    private boolean running=false;

    public static boolean paused=false;
    public int diff=0;
    // 0=normal
    // 1=hard

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE{
        MENU,
        HELP,
        GAME,
        SELECT,
        END
    };
    public STATE gameState=STATE.MENU;

    public static BufferedImage sprite_sheet;
    public static BufferedImage sprite_sheet2;
    public static BufferedImage sprite_sheet3;
    public static BufferedImage sprite_sheet4;
    public static BufferedImage sprite_sheet5;
    public static BufferedImage sprite_sheet6;
    public static BufferedImage sprite_sheet7;
    public static BufferedImage sprite_sheet8;
    public static BufferedImage sprite_sheet9;
    private BufferedImage background;

    public Game(){

        BufferedImageLoader loader=new BufferedImageLoader();

        sprite_sheet=loader.loadImage("res/Player.png");
        sprite_sheet2=loader.loadImage("res/Bow.jpg");
        sprite_sheet3=loader.loadImage("res/OuterFrame.jpg");
        sprite_sheet4=loader.loadImage("res/Background.jpg");
        sprite_sheet5=loader.loadImage("res/Man_L.png");
        sprite_sheet6=loader.loadImage("res/Man_R.png");
        sprite_sheet7=loader.loadImage("res/ball_small.png");
        sprite_sheet8=loader.loadImage("res/ball_medium.png");
        sprite_sheet9=loader.loadImage("res/ball_big.png");

        SpriteSheet ss=new SpriteSheet(Game.sprite_sheet4);
        background=ss.grabImage();


        handler=new Handler();
        hud=new HUD();
        menu=new Menu(this,handler,hud);
        this.addKeyListener(new KeyInput(handler,this));
        this.addMouseListener(menu);

        new Window(WIDTH,HEIGHT, "Bubble Trouble",this);

        spawner=new Spawn(handler,hud, menu.game);
    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime=System.nanoTime();
        double amountofTicks=60.0;
        double ns=1000000000/amountofTicks;
        double delta=0;
        long timer=System.currentTimeMillis();
        int frames=0;
        while (running){
            long now=System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime=now;
            while (delta>=1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                //System.out.println("FPS: "+frames);
                frames=0;
            }
        }
        stop();
    }

    private void tick() {

        if (gameState==STATE.GAME){
            if (!paused){
                hud.tick();
                spawner.tick();
                handler.tick();

                if (HUD.HEALTH<=0){
                    HUD.HEALTH=100;
                    AudioPlayer.load();
                    AudioPlayer.getSound("end_sound").play();
                    handler.clearEnemys();
                    gameState=STATE.END;
                }
            }
        }else if (gameState==STATE.MENU || gameState==STATE.END || gameState==STATE.SELECT){
            menu.tick();
            handler.tick();
        }

    }

    private void render() {
        BufferStrategy bs=this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();

        g.drawImage(background,0,0,null);

        handler.render(g);

        if(paused){
            Font fnt=new Font("monospaced",3,15);
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("PAUSED",150,93);
        }

        if (gameState==STATE.GAME){
            hud.render(g);
        }else if (gameState==STATE.MENU || gameState==STATE.END || gameState==STATE.HELP || gameState==STATE.SELECT){
            menu.render(g);
        }

        g.dispose();
        bs.show();

    }

    public static int border(int var,int min,int max){
        if (var>=max)
            return var=max;
        else if (var<=min)
            return var=min;
        else
            return var;
    }

    public static void main(String args[]){
        new Game();

    }
}

package Test;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Game game;
    private Random r=new Random();

    private int scoreKeep=0;

    public Spawn(Handler handler,HUD hud,Game game) {
        this.handler = handler;
        this.game=game;
        this.hud=hud;
    }

    public void tick(){
        scoreKeep++;
        if (scoreKeep>=200) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);

            if (game.diff==0){
                if (hud.getLevel()==1){
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                }
                if (hud.getLevel()==2){
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                } else if (hud.getLevel()==3) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==4) {
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                } else if (hud.getLevel()==5) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==6) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==7) {
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                } else if (hud.getLevel()==8) {
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==9) {
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                } else if (hud.getLevel()==10) {
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                }
            } else if (game.diff==1) {
                if (hud.getLevel()==2){
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                } else if (hud.getLevel()==3) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==4) {
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                } else if (hud.getLevel()==5) {
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                } else if (hud.getLevel()==6) {
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                    handler.addObj(new Enemy(r.nextInt(Game.WIDTH-100),Game.HEIGHT-150,ID.Enemy));
                } else if (hud.getLevel()==7) {
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                } else if (hud.getLevel()==8) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==9) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy3(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy3));
                } else if (hud.getLevel()==10) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                } else if (hud.getLevel()==11) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                }else if (hud.getLevel()==12) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                }else if (hud.getLevel()==13) {
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                    handler.addObj(new Enemy2(r.nextInt(Game.WIDTH-100),Game.HEIGHT-300,ID.Enemy2));
                }
            }
        }
    }

}

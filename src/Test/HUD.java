package Test;

import java.awt.*;

public class HUD {

    public static int HEALTH=100;

    private int score=0;
    private int level=1;
    public void tick(){
        //HEALTH--;
        HEALTH=Game.border(HEALTH,0,100);
        score++;
    }

    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(30,35,200,32);
        g.setColor(Color.RED);
        g.fillRect(30,35,HEALTH*2,32);
        g.setColor(Color.WHITE);
        g.drawRect(30,35,200,32);

        Font fnt=new Font("monospaced",3,15);
        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("Score:"+score,30,80);
        g.drawString("Level:"+level,30,93);
    }

    public void score(int score){
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

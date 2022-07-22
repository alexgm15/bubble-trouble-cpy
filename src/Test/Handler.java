package Test;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object=new LinkedList<GameObject>();

    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject tempObj=object.get(i);

            tempObj.tick();
        }
    }

    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            GameObject tempObj=object.get(i);

            tempObj.render(g);
        }
    }

    public void addObj(GameObject object){
        this.object.add(object);
    }

    public void removeObj(GameObject object){
        this.object.remove(object);
    }

    public void  clearEnemys(){
        for (int i=0;i<object.size();i++){
            object.clear();
        }
    }
}

import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byFence extends  NPC {

    npc_plains_E9_byFence( ){
        setName("Steven");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(21);
        setMapPos(550,450);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(){

    }

    public void drawConvo(Graphics2D g){
        super.drawConvo(g);
        drawText(110,425,"Hello Darkness my old friend", "Times New Roman",20,g);
    }



}

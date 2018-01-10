import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_oldman extends  NPC {

    npc_plains_f8_oldman( ){
        setName("Julian");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(200,200);
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
        drawText(110,425,"Hello Dear, nice to meet you!", "Times New Roman",20,g);
    }






}

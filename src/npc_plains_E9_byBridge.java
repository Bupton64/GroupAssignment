import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byBridge extends  NPC {

    npc_plains_E9_byBridge( ){
        setName("Sally");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,364,144,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(21);
        setMapPos(475,200);
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
        drawText(110,450,"Yala 420 Blaze it fgt", "Times New Roman",20,g);
    }



}

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
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, String playerName,Quest currentQuest){
        super.drawConvo(g,playerName, currentQuest);
        drawText(110,450,"You must be " + playerName + " right? I'm so sorry to hear what happened to your", "Times New Roman",20,g);
        drawText(110,475,"town. Hopefully the Wizard in the North will be able to help you!", "Times New Roman",20,g);
    }



}

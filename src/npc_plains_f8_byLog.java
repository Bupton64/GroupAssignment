import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_byLog extends  NPC {

    npc_plains_f8_byLog( ){
        setName("Link");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(650,85);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, String playerName, Quest currentQuest){
        super.drawConvo(g,playerName, currentQuest);
        drawText(110,450,"What do you want? Can't you see i'm busy!?", "Times New Roman",20,g);
    }



}

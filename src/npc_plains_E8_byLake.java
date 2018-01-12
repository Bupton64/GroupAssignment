import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byLake extends  NPC {

    npc_plains_E8_byLake( ){
        setName("Sam On");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,208,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
        setMapPos(700,480);
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
        super.drawConvo(g,playerName,currentQuest);
        drawText(110,450,"Man, that Wizard up North is an interesting fellow... I just hope he's", "Times New Roman",20,g);
        drawText(110,475,"watching over us.", "Times New Roman",20,g);
    }



}

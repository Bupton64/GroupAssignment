import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byLake extends  NPC {

    npc_plains_E8_byLake(){
        setName("Cyd");
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

    public void drawConvo(Graphics2D g, Character player){
        super.drawConvo(g, player);
        drawText(110,450,"You're going out of town? Be careful, if a monster stores a lot of energy ", "Times New Roman",20,g);
        drawText(110,475,"in a fight they might release a powerful attack!", "Times New Roman",20,g);
    }



}

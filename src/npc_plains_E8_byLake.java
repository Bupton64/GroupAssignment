import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byLake extends  NPC {

    npc_plains_E8_byLake( ){
        setName("Sam On");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,208,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
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





}

import java.awt.*;
import java.awt.event.*;


public class npc_plains_E11 extends  NPC {

    npc_plains_E11( ){
        setName("Andrew");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(300,70);
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

import java.awt.*;
import java.awt.event.*;


public class npc_plains_G7 extends  NPC {

    npc_plains_G7( ){
        setName("Timothy");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(33);
        setMapPos(400,300);
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

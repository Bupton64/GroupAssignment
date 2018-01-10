import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byHouse extends  NPC {

    npc_plains_E8_byHouse( ){
        setName("Tim Burr");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
        setMapPos(80,180);
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
        drawText(110,425,"Hey there I'm Tim Burr. Hi there I am Tim Burr. HI THERE IM TIM BR", "Times New Roman",20,g);
    }



}

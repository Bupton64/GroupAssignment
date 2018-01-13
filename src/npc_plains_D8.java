import java.awt.*;
import java.awt.event.*;


public class npc_plains_D8 extends  NPC {

    npc_plains_D8(){
        setName("Andrew");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,520,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(12);
        setMapPos(200,200);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g){
        super.drawConvo(g);
        drawText(110,450,"It's looking good so far lads, definitely A+ worthy!", "Times New Roman",20,g);
    }





}

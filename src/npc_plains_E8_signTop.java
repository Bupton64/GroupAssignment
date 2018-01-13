import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_signTop extends  NPC {

    npc_plains_E8_signTop( ){
        setName("Sign");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,50,0,1,1);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
        setMapPos(427,15);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        //collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, Character player){
        super.drawConvo(g, player);
        drawText(110,450,"You are now leaving Hurnville. This path leads to the great ones", "Times New Roman",20,g);
        drawText(110,475,"residence. ", "Times New Roman",20,g);
    }



}

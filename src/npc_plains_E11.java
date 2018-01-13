import java.awt.*;
import java.awt.event.*;


public class npc_plains_E11 extends  NPC {

    npc_plains_E11(Character playerMan){
        setName("Francis");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(23);
        setMapPos(400,400);
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
        drawText(110,450,"Be careful venturing below... anyone who's gone up against such strength...", "Times New Roman",20,g);
        drawText(110,475,"well let's just say it never ended well...", "Times New Roman",20,g);
    }




}

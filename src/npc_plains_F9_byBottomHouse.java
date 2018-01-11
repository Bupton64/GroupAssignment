import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_byBottomHouse extends  NPC {

    npc_plains_F9_byBottomHouse( ){
        setName("Tyran");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,520,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(29);
        setMapPos(150,450);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, String playerName){
        super.drawConvo(g,playerName);
        drawText(110,450,"Huh... you found me... woopty dooo...", "Times New Roman",20,g);
    }



}

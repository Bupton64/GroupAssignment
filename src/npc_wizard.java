import java.awt.*;
import java.awt.event.*;


public class npc_wizard extends  NPC {

    npc_wizard( ){
        setName("THE GREAT WIZARD OF THE NORTH... TIM");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(17);
        setMapPos(400,250);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(){

    }

    public void drawConvo(Graphics2D g, String playerMan){
        super.drawConvo(g,playerMan);
        drawText(110,450,"If i'm honest i'm a bit lost. There's so many monsters around here,", "Times New Roman",20,g);
        drawText(110,475,"thankfully I have these potions to save me!", "Times New Roman",20,g);
    }





}

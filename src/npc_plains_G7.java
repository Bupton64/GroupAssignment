import java.awt.*;
import java.awt.event.*;

//MOVED TO H9
public class npc_plains_G7 extends  NPC {

    Character player;

    npc_plains_G7(Character playerMan){
        setName("Camrath");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(39);
        setMapPos(400,300);
        setHostile(false);
        this.player = playerMan;
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
        drawText(110,450,"If i'm honest i'm a bit lost. There's so many monsters around here,", "Times New Roman",20,g);
        drawText(110,475,"thankfully I have these potions to save me!", "Times New Roman",20,g);
    }





}

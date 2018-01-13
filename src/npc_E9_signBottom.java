import java.awt.*;
import java.awt.event.*;


public class npc_E9_signBottom extends  NPC {

    npc_E9_signBottom(){
        setName("Town Sign");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,50,0,1,1);
        setHeight(70);
        setWidth(50);
        setMapLocation(21);
        setMapPos(375,495);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        //collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"Welcome to Hurnville, a safe haven for all.", "Times New Roman",20,g);
    }



}

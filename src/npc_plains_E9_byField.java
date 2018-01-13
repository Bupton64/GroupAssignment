import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byField extends  NPC {

    npc_plains_E9_byField(){
        setName("Titus");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(21);
        setMapPos(100,450);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"We've always had monsters nearby but it was never this bad... Sevar", "Times New Roman",20,g);
        drawText(110,475,"the Wizard protected us well, but now Therox has turned attention to ", "Times New Roman",20,g);
        drawText(110,500,"us... Well I just don't feel safe anymore.", "Times New Roman",20,g);
    }



}

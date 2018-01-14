import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_byPath extends  NPC {



    npc_plains_F9_byPath(){
        setName("Gerald");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,0,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(29);
        setMapPos(600,350);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"If you follow this path upwards, you'll find the Wizards hut... Be Careful", "Times New Roman",20,g);
        drawText(110,475,"though, you're all alone outside of town.", "Times New Roman",20,g);
    }



}

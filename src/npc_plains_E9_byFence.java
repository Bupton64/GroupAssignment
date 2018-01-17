import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byFence extends  NPC {

    npc_plains_E9_byFence(){
        setName("Talon");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setMapPosX(550);
        setMapPosY(450);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){

    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){
        super.drawConvo(g, playerName,currentState, questName, questStage);
        drawText(110,450,"He's bound to come to our town... if only there was someone to protect us!", "Times New Roman",20,g);
    }



}

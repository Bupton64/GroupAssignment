import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_byLog extends  NPC {

    npc_plains_f8_byLog(){
        setName("Link");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setMapPosX(650);
        setMapPosY(85);
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

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"Can't you see I'm busy!? Camrath sent me to fetch wood!", "Times New Roman",20,g);
    }



}

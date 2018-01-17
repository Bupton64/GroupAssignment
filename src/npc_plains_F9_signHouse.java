import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_signHouse extends  NPC {


    npc_plains_F9_signHouse(){
        setName("Supermarket");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,50,0,1,1);
        setMapPosX(620);
        setMapPosY(220);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        //collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
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

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName,int questStage){
        super.drawConvo(g, playerName,currentState, questName,questStage);;
        drawText(110,450,"Closed.", "Times New Roman",20,g);
    }



}

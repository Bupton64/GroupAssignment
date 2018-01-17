import java.awt.*;
import java.awt.event.*;


public class npc_E9_signBottom extends  NPC {

    npc_E9_signBottom(){
        setName("Town Sign");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,50,0,1,1);
        setMapPosX(375);
        setMapPosY(495);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        //collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){

    }

    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName,int questStage){
        super.drawConvo(g, playerName,currentState, questName,questStage);
        drawText(110,450,"Welcome to Hurnville, a safe haven for all.", "Times New Roman",20,g);
    }



}

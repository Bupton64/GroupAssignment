import java.awt.*;
import java.awt.event.*;


public class npc_plains_E11 extends  NPC {

    npc_plains_E11(){
        setName("Francis");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(400);
        setMapPosY(400);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
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
        drawText(110,450,"Be careful venturing below... anyone who's gone up against such strength...", "Times New Roman",20,g);
        drawText(110,475,"well let's just say it never ended well...", "Times New Roman",20,g);
    }




}

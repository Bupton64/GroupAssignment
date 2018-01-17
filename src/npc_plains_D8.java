import java.awt.*;
import java.awt.event.*;


public class npc_plains_D8 extends  NPC {

    npc_plains_D8(){
        setName("Andrew");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,520,288,56,72);
        setMapPosX(200);
        setMapPosY(200);
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
        drawText(110,450,"It's looking good so far lads, definitely A+ worthy!", "Times New Roman",20,g);
    }





}

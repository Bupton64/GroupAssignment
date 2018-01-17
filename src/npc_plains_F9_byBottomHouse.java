import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_byBottomHouse extends  NPC {



    npc_plains_F9_byBottomHouse(){
        setName("Tyran");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,520,288,56,72);
        setMapPosX(150);
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
        drawText(110,450,"Therox's witches have been driving packs of wolves at the town. The ", "Times New Roman",20,g);
        drawText(110,475,"militia can't handle it, they've already lost two good men!", "Times New Roman",20,g);
    }



}

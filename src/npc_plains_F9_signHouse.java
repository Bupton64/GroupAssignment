import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_signHouse extends  NPC {


    npc_plains_F9_signHouse(){
        setName("Supermarket");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,50,0,1,1);
        setMapPosX(620);
        setMapPosY(220);

        initDialogue();
        loadDialogue = true;
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

    Dialogue listOne;

    Dialogue listTwo;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Closed.","","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"Open","","","");
        listTwo = d2;
    }

    public void updateDialogue(int questStage){
        if(questStage < 5) {
            currentDialogue = listOne;
        }else{
            currentDialogue = listTwo;
        }

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }




}

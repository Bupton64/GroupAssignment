import java.awt.*;
import java.awt.event.*;


public class npc_plains_D8 extends  NPC {

    npc_plains_D8(){
        setName("Andrew");
        spriteSheet = loadImage("military2.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setMapPosX(200);
        setMapPosY(200);

        initDialogue();
        loadDialogue = true;
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

    Dialogue listOne;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"It's looking good so far lads, definitely A+ worthy!","","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }





}

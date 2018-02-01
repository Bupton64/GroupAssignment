import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byLake extends  NPC {

    npc_plains_E8_byLake(){
        setName("Cyd");
        spriteSheet = loadImage("Image/chara2.png");
        sprite = subImage(spriteSheet,208,288,56,72);
        setMapPosX(700);
        setMapPosY(480);

        turnArray = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            turnArray[i] = subImage(spriteSheet,208,288 + (i * 72),56,72);
        }
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
        turn();
    }

    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;

    Dialogue listTwo;

    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"You're going out of town? Be careful, if a monster stores a lot of energy ","in a fight they might release a powerful attack!","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"It won't be long until the forest is completely gone! Everything will be","just like before.","","");
        listTwo = d2;
    }

    public void updateDialogue( int questStage){
        if(questStage == 33){
            currentDialogue = listTwo;
        } else {
            currentDialogue = listOne;
        }
    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }


}

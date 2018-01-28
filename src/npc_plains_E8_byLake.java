import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byLake extends  NPC {

    npc_plains_E8_byLake(){
        setName("Cyd");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,208,288,56,72);
        setMapPosX(700);
        setMapPosY(480);

        spriteDown = new Image[3];
        spriteUp = new Image[3];
        spriteRight = new Image[3];
        spriteLeft = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet, 156+(52 * i), 288,52,72);
            spriteLeft[i] = subImage(spriteSheet,156+(52 * i), 360,52,72);
            spriteRight[i] = subImage(spriteSheet,156+(52 * i), 432,52,72);
            spriteUp[i] = subImage(spriteSheet,156+(52 * i), 504,52,72);
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

    }

    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"You're going out of town? Be careful, if a monster stores a lot of energy ","in a fight they might release a powerful attack!","","");
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

import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byFence extends  NPC {

    npc_plains_E9_byFence(){
        setName("Talon");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setMapPosX(550);
        setMapPosY(450);

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
            spriteDown[i] = subImage(spriteSheet, (52 * i), 0,52,72);
            spriteLeft[i] = subImage(spriteSheet,(52 * i), 72,52,72);
            spriteRight[i] = subImage(spriteSheet,(52 * i), 144,52,72);
            spriteUp[i] = subImage(spriteSheet,(52 * i), 216,52,72);
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
        Dialogue d1 = new Dialogue(null,false,true,"He's bound to come to our town... if only there was someone to protect us!","","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }




}

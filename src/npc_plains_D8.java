import java.awt.*;
import java.awt.event.*;


public class npc_plains_D8 extends  NPC {

    npc_plains_D8(){
        setName("Andrew");
        spriteSheet = loadImage("military2.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setMapPosX(200);
        setMapPosY(200);

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
    Dialogue listTwo;

    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"It's looking good so far lads, definitely A+ worthy!","","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"","","","");
        listTwo = d2;
    }

    public void updateDialogue(Quest.questState  currentState){
        if(questStage == 33){
            currentDialogue = listTwo;
        } else {
            currentDialogue = listOne;
        }
    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }





}

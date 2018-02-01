import java.awt.*;
import java.awt.event.*;


public class npc_plains_D8 extends  NPC {

    npc_plains_D8(int posX, int posY){
        setName("Andrew");
        spriteSheet = loadImage("Image/military2.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setMapPosX(posX);
        setMapPosY(posY);

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
        Dialogue d1 = new Dialogue(null,false,true,"This isn't CounterStrike!? Let's see how it goes!","","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"It looks good lads, definitely A+ worthy!","","","");
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

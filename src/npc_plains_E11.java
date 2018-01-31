import java.awt.*;
import java.awt.event.*;


public class npc_plains_E11 extends  NPC {

    npc_plains_E11(){
        setName("Turing");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(400);
        setMapPosY(400);

        spriteDown = new Image[3];
        spriteUp = new Image[3];
        spriteRight = new Image[3];
        spriteLeft = new Image[3];


        loadImages();
       

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
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet, (52 * i), 288,52,72);
            spriteLeft[i] = subImage(spriteSheet,(52 * i), 360,52,72);
            spriteRight[i] = subImage(spriteSheet,(52 * i), 432,52,72);
            spriteUp[i] = subImage(spriteSheet,(52 * i), 504,52,72);
        }
    }



    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;

    Dialogue listTwo;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Be careful venturing below... anyone who's gone up against such strength...","well let's just say it never ended well...","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"There are less monsters out here these days. The forest is receding and ","Sepla is returning to its former glory!","","");
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

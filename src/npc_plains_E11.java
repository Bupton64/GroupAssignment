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
        initPath();

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

    public void initPath() {
        setMapPosX(600);
        setMapPosY(400);
        setMoveTimer(0);
        setMoveDelay(0.2);
        numOfLocations = 2;
        currentLocation= 0;

        Location = new NpcLocation[2];
        for(int i = 0; i < numOfLocations;i++){
            Location[i] = new NpcLocation();
        }
        Location[0].setUp(0,600,450, "left",500,1,60);
        Location[1].setUp(1,100,450,"right",300,0,60);


        walkDuration = 0.32;
    }

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

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){
        setMoveTimer(getMoveTimer() + dt);

        if(getMoveTimer() > getMoveDelay()){
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);

            if(startMovement(dt)){
                currentLocation = Location[currentLocation].getNextLocation();
            }

            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
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

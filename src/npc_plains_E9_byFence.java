import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byFence extends  NPC {

    npc_plains_E9_byFence(){
        setName("Edgar");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,52,0,56,72);
        setMapPosX(550);
        setMapPosY(450);

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
        setMapPosX(480);
        setMapPosY(450);
        setMoveTimer(0);
        setMoveDelay(0.2);
        numOfLocations = 6;
        currentLocation= 0;

        Location = new NpcLocation[6];
        for(int i = 0; i < numOfLocations;i++){
            Location[i] = new NpcLocation();
        }
        Location[0].setUp(0,480,450, "left",100,1,60);
        Location[1].setUp(1,380,450,"right",100,2,60);
        Location[2].setUp(2,380,350,"up",100,3,60);
        Location[3].setUp(3,180,350,"left",200,4,60);
        Location[4].setUp(4,180,450,"down",100,5,60);
        Location[5].setUp(5,380,450,"right",200,0,60);

       // Location[4].setUp(4,380,450,"right",100,0,60);

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

        walkDuration = 0.32;
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
        Dialogue d1 = new Dialogue(null,false,true,"He's bound to come to our town... if only there was someone to protect","us!","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"Your power astounds me! I can sleep peacefully knowing you're watching","over us.","","");
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

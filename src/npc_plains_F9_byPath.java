import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_byPath extends  NPC {



    npc_plains_F9_byPath(){
        setName("Gerald");
        spriteSheet = loadImage("npc1.png");
        sprite = subImage(spriteSheet,364,0,56,72);
        setMapPosX(600);
        setMapPosY(350);

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
        setMapPosY(350);
        setMoveTimer(0);
        setMoveDelay(0.2);
        numOfLocations = 2;
        currentLocation= 0;

        Location = new NpcLocation[2];
        for(int i = 0; i < numOfLocations;i++){
            Location[i] = new NpcLocation();
        }
        Location[0].setUp(0,600,450, "left",180,1,60);
        Location[1].setUp(1,420,450,"right",180,0,60);


        walkDuration = 0.32;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,312 + (52 * i), 0,52,72);
            spriteLeft[i] = subImage(spriteSheet,312 + (52 * i), 72,52,72);
            spriteRight[i] = subImage(spriteSheet,312 + (52 * i), 144,52,72);
            spriteUp[i] = subImage(spriteSheet,312 + (52 * i), 216,52,72);
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
        Dialogue d1 = new Dialogue(null,false,true,"If you follow this path upwards, you'll find the Wizards hut... Be careful","though, you're all alone outside of town.","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"That was incredible! I'm starting a petition to erect a statue in your ","honor!","","");
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

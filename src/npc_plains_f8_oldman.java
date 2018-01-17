import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_oldman extends  NPC {

    npc_plains_f8_oldman(){
        setName("Julian");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,288,56,72);


        initPath();
        loadImages();

        initDialogue(); //new
        loadDialogue = true; // new
    }


    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    //////////////////////////////
    ///
    ///    Movement
    ///
    //////////////////////////////

    public void initPath(){
        setMoveTimer(2);
        setMoveDelay(3);
        setMapPosX(200);
        setMapPosY(200);


        Location = new NpcLocation[4];
        currentLocation = 0;
        numOfLocations = 4;
        for(int i = 0; i < numOfLocations;i++){
            Location[i] = new NpcLocation();
        }
        Location[0].setUp(0,200,200, "down",100,1,20);
        Location[1].setUp(1,200,300,"up",100,2,40);
        Location[2].setUp(2,130,300,"left",70,3,70);
        Location[3].setUp(3,200,300,"right",70,0,20);
    }

    @Override
    public void loadImages(){
        super.loadImages();
        spriteUp = new Image[3];
        spriteDown = new Image[3];
        spriteLeft = new Image[3];
        spriteRight = new Image[3];
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,312 + (52 * i), 288,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteUp[i] = subImage(spriteSheet,312 + (52 * i), 504,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteLeft[i] = subImage(spriteSheet,312 + (52 * i), 360,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteRight[i] = subImage(spriteSheet,312 + (52 * i), 432,52,72);
        }


        walkDuration = 0.32;
        npcDirection = Direction.down;

    }





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


    //////////////////////////////
    ///
    ///    Convo
    ///
    //////////////////////////////

    Dialogue listOne;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"I'm Julian, the oldest NPC... uh I mean villager in this Town.","","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

            currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){
        super.drawConvo(g, playerName,currentState, questName,questStage);
        if(loadDialogue) {
            updateDialogue(currentState);

            loadDialogue = false;
        }
        currentDialogue.display(g);
    }







}





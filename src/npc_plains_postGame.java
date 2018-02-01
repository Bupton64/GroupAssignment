import java.awt.*;
import java.awt.event.*;


public class npc_plains_postGame extends  NPC {



    npc_plains_postGame(){
        setName("Callum");
        spriteSheet = loadImage("Image/npc1.png");
        sprite = subImage(spriteSheet,520,288,56,72);
        setMapPosX(600);
        setMapPosY(350);

        turnArray = new Image[3];

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
        setMapPosX(400);
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
            turnArray[i] = subImage(spriteSheet,520,288 + (i*72),56,72);
        }
    }



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


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"GRRRRRR.","","","");
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

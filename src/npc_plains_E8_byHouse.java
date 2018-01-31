import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byHouse extends  NPC {

    npc_plains_E8_byHouse(){
        setName("Alyx");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,196,288,56,72);
        setMapPosX(80);
        setMapPosY(480);

        initPath();
        spriteLeft = new Image[3];
        spriteRight = new Image[3];
        loadImages();

        currentLocation= 1;

        initDialogue();
        loadDialogue = true;
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

    public void initPath() {
        setMapPosX(80);
        setMapPosY(480);
        setMoveTimer(0);
        setMoveDelay(0.2);
        numOfLocations = 2;
        currentLocation= 0;

        Location = new NpcLocation[2];
        for(int i = 0; i < numOfLocations;i++){
            Location[i] = new NpcLocation();
        }
        Location[0].setUp(0,260,480, "left",180,1,60);
        Location[1].setUp(1,80,480,"right",180,0,60);

    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteRight[i] = subImage(spriteSheet,144 + (52 * i), 432,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteLeft[i] = subImage(spriteSheet,144 + (52 * i), 360,52,72);
        }


        walkDuration = 0.32;
        npcDirection = Direction.down;
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



    //////////////////////////////
    ///
    ///    Convo
    ///
    //////////////////////////////

    Dialogue listOne;

    Dialogue listTwo;

    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Curse Therox! When his forces first reached us, my brother fought","to defend Sepla! He fell, so we could live. Therox must pay!","I hope you can bring him to justice and avenge my brother.","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"I can't even begin to express how thankful I am! My brother no","longer died in vain!","","");
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

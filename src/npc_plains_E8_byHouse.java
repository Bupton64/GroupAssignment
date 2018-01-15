import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byHouse extends  NPC {

    npc_plains_E8_byHouse(){
        setName("Alyx");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(80);
        setMapPosY(180);

        initPath();
        spriteLeft = new Image[3];
        spriteRight = new Image[3];
        loadImages();

        currentLocation= 1;
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
        setMapPosY(180);
        setMoveTimer(0);
        setMoveDelay(0.2);
        numOfLocations = 2;
        currentLocation= 0;

        Location = new NpcLocation[2];
        for(int i = 0; i < numOfLocations;i++){
            Location[i] = new NpcLocation();
        }
        Location[0].setUp(0,260,180, "left",180,1,60);
        Location[1].setUp(1,80,180,"right",180,0,60);

    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteRight[i] = subImage(spriteSheet,0 + (52 * i), 432,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteLeft[i] = subImage(spriteSheet,0 + (52 * i), 360,52,72);
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

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        drawText(110,450,"My business is ruined! I can't get any new supplies from the city", "Times New Roman",20,g);
        drawText(110,475,"now that Sevar has boxed us in!", "Times New Roman",20,g);
    }



}

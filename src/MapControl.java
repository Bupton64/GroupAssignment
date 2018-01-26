import java.awt.*;
import java.awt.event.*;


public class MapControl extends extraFunctions {


    MapControl(Character playerMan,Collision collision) {
        this.playerMan = playerMan;
        this.collisionDetector = collision;
        swapMap = true;
        firstMap = true;
        mapNpcs = new NPC[10];
        numOfNpc = 0;
        clicks = loadAudio("clicks.wav");

        initNPC();
    }




    ///////////////////////////////////
    ///
    /// Map Control
    ///
    //////////////////////////////////


    /**
     * try in to follow my format under your own Level.
     */
    private boolean firstMap; //< Checks if this the first map to load when game starts
    private boolean swapMap; //< checks if map should be changed


    private Map currentMap; //< Holds current map data
    private NPC[] mapNpcs; //< Objects to hold NPC data
    private int numOfNpc; //<Number of NPC's loaded into map

    private Character playerMan;

    private Collision collisionDetector;



    public void drawMap(Graphics g) {
        if (!firstMap) {
            drawImage(currentMap.backgroundImage, 0, 0, 800, 600, g);

            drawNPC(g);

        }
    }




    public void updateMap() {

        if (!firstMap) {
            swapMap = currentMap.updateMapMovement(collisionDetector, playerMan);
            if(reloadMap) {
                swapMap = true;
            }
        }

        if (swapMap) {

            if (!firstMap ) {
                currentMap.setUpCollision(collisionDetector);
                if(reloadMap){
                    reloadMap = false;
                }else {
                    for (int i = 0; i < numOfNpc; i++) {
                        mapNpcs[i].setUpCollision(collisionDetector, currentMap);
                    }
                }

            }

            for (int i = 0; i < numOfNpc; i++) {
                mapNpcs[i] = new npc_empty();
            }

            if(reloadMap) {

                reloadMap = false;
            }

            swapMap = false;
            firstMap = false;
            numOfNpc = 0;
            switch ((int) playerMan.getCurrentMapLocation()) {
                case 0:
                    currentMap = new plains_A9();
                    break;
                case 1:
                    currentMap = new plains_B8();
                    break;
                case 2:
                    currentMap = new plains_B9();
                    break;
                case 3:
                    currentMap = new plains_B10();
                    break;
                case 4:
                    currentMap = new plains_C7();
                    break;
                case 5:
                    currentMap = new plains_C8();
                    break;
                case 6:
                    currentMap = new plains_C9();
                    break;
                case 7:
                    currentMap = new plains_C10();
                    break;
                case 8:
                    currentMap = new plains_C11();
                    break;
                case 10:
                    currentMap = new plains_D6();
                    break;
                case 11:
                    currentMap = new plains_D7();
                    break;
                case 12:
                    currentMap = new plains_D8();
                    mapNpcs[0] = new npc_plains_D8();
                    numOfNpc = 1;
                    break;
                case 13:
                    currentMap = new plains_D9();
                    break;
                case 14:
                    currentMap = new plains_D10();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(6)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(200, 350);
                            numOfNpc = 1;
                        }
                    }
                    break;
                case 15:
                    currentMap = new plains_D11();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(5)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(399, 399);
                            numOfNpc = 1;
                        }
                    }
                    break;
                case 16:
                    currentMap = new plains_D12();
                    break;
                case 17:
                    currentMap = new plains_E5();
                    if(playerMan.getQuestStage() < 15) {
                        mapNpcs[0] = new npc_wizard(400, 250);
                        numOfNpc = 1;
                    }
                    break;
                case 18:
                    currentMap = new plains_E6();
                    break;
                case 19:
                    currentMap = new plains_E7();
                    break;
                case 20:
                    currentMap = new plains_E8();
                    mapNpcs[0] = new npc_plains_E8_byHouse();
                    mapNpcs[1] = new npc_plains_E8_byLake();
                    mapNpcs[2] = new npc_plains_E8_signTop();
                    mapNpcs[3] = new npc_plains_E8_signGrave();
                    numOfNpc = 4;
                    break;
                case 21:
                    currentMap = new plains_E9();
                    mapNpcs[0] = new npc_plains_E9_byBridge(475,200);
                    mapNpcs[1] = new npc_plains_E9_byFence();
                    mapNpcs[2] = new npc_plains_E9_byField();
                    mapNpcs[3] = new npc_E9_signBottom();
                    numOfNpc = 4;
                    if(playerMan.getQuestStage() >= 15) {
                        mapNpcs[0] = new npc_wizard(200, 230);
                    }
                    break;
                case 22:
                    currentMap = new plains_E10();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(4)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(700, 300);
                            numOfNpc = 1;
                        }
                    }
                    break;
                case 23:
                    currentMap = new plains_E11();
                    mapNpcs[0] = new npc_plains_E11();
                    numOfNpc = 1;
                    break;
                case 24:
                    currentMap = new plains_E12();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(3)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(100, 150);
                            numOfNpc = 1;
                        }
                    }
                    break;
                case 25:
                    currentMap = new plains_E13();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(2)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(400, 370);
                            numOfNpc = 1;
                            if (playerMan.isValliardAlive()) {
                                mapNpcs[1] = new npc_plains_E13_Valliard();
                                numOfNpc = 2;
                            }
                        }
                    }
                    break;
                case 26:
                    currentMap = new plains_F6();
                    break;
                case 27:
                    currentMap = new plains_F7();
                    break;
                case 28:

                    currentMap = new plains_F8();
                    if(playerMan.getQuestStage() < 14) {
                        mapNpcs[0] = new npc_plains_f8_oldman(200, 200);
                    }
                    if(playerMan.getQuestStage() < 7) {
                        mapNpcs[1] = new npc_plains_f8_byLog();
                        numOfNpc = 2;
                    }else{
                         numOfNpc = 1;
                    }

                    if(playerMan.getQuestStage() == 14) {

                        mapNpcs[0] = new npc_plains_f8_oldman(420,200);
                        mapNpcs[1] = new npc_plains_priest(480,200);
                        numOfNpc = 2;
                    }else if(playerMan.getQuestStage() >= 15) {
                        mapNpcs[0] = new npc_plains_f8_oldman(420,200);

                        numOfNpc = 1;
                    }

                    break;
                case 29:
                    currentMap = new plains_F9();
                    mapNpcs[0] = new npc_plains_F9_byBottomHouse();
                    mapNpcs[1] = new npc_plains_F9_byPath();
                    mapNpcs[2] = new npc_plains_F9_signHouse();
                    numOfNpc = 3;
                    break;
                case 30:
                    currentMap = new plains_F10();
                    break;
                case 31:
                    currentMap = new plains_F11();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(1)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(400, 300);
                            numOfNpc = 1;
                        }
                    }
                    break;
                case 32:
                    currentMap = new plains_F12();
                    if(playerMan.getQuestStage() == 10){
                        if(!playerMan.getCollectableState(0)) {
                            mapNpcs[0] = new npc_plains_quest_collectable(450, 200);
                            numOfNpc = 1;
                        }
                    }
                    break;
                case 33:
                    currentMap = new plains_G7();
                    mapNpcs[0] = new npc_plains_G7();
                    numOfNpc = 1;
                    break;
                case 34:
                    currentMap = new plains_G8();
                    break;
                case 35:
                    currentMap = new plains_G9();
                    break;
                case 36:
                    currentMap = new plains_G10();
                    break;
                case 37:
                    currentMap = new plains_G11();
                    break;
                case 38:
                    currentMap = new plains_H8();
                    if(playerMan.getQuestStage() == 16){
                        mapNpcs[0] = new npc_plains_quest5_collectable(350,290);
                        numOfNpc = 1;
                    }
                    break;
                case 39:
                    currentMap = new plains_H9();
                    mapNpcs[0] = new npc_plains_H9(playerMan.getGpTotal());
                    numOfNpc = 1;
                    break;
                case 40:
                    currentMap = new plains_H10();
                    break;
                case 41:
                    currentMap = new plains_I9();
                    break;
                case 42:
                    currentMap = new plains_F9_shop();
                    if(playerMan.getQuestStage() >= 7) {
                        mapNpcs[0] = new npc_plains_F9_StoreLink();
                        mapNpcs[1] = new npc_plains_F9_StoreBabbage();
                        numOfNpc = 2;
                    }
                    break;
                case 43:
                    currentMap = new plains_E9_bottomHouse();
                    break;
                case 44:
                    currentMap = new plains_E9_topLeftHouse();
                    break;
                case 45:
                    currentMap = new plains_E9_topRightHouse();
                    break;
                case 46:
                    currentMap = new plains_E8_topRightHouse();
                    break;
                case 47:
                    currentMap = new plains_F8_House();
                    break;
                case 48:
                    currentMap = new plains_F9_bottomLeftHouse();
                    break;
                case 49:
                    currentMap = new plains_F9_bottomRightHouse();
                    break;
                case 50:
                    currentMap = new plains_E8_topLeftHouse();
                    if(playerMan.getQuestStage() < 12) {
                        mapNpcs[0] = new npc_plains_priest(600,350);
                        numOfNpc = 1;
                    }
                    if(playerMan.getQuestStage() == 12){
                        if(!playerMan.getCollectableState(0)) {
                            mapNpcs[0] = new npc_plains_quest4_collectable(360, 160);
                            numOfNpc = 1;
                        }
                    }

                    break;
                case 51:
                    currentMap = new plains_A9_church();
                    if(playerMan.getQuestStage() == 19){
                        mapNpcs[0] = new npc_plains_E9_byBridge(170,170);
                        numOfNpc = 1;

                    }
                    if(playerMan.getQuestStage() == 18){
                        mapNpcs[0] = new npc_plains_E9_byBridge(170,170);
                        mapNpcs[1] = new npc_plains_priest(320,200);

                        numOfNpc = 2;
                    }
                    break;
                case 52:
                    currentMap = new plains_H9_blackSmith();
                    break;
                case 53:
                    currentMap = new plains_C8_farm();
                    break;
            }
        }


        for(int i = 0; i < numOfNpc; i++) {
            mapNpcs[i].setUpCollision(collisionDetector, currentMap);
        }
        currentMap.setUpCollision(collisionDetector);
    }

    ///////////////////////////////////
    ///
    /// NPC Controls
    ///
    //////////////////////////////////

    private boolean reloadMap;
    private int updateQuestState;
    private int currentNpcInteraction;
    private boolean checkQuestChange;
    private boolean rewardDisplay;
    private boolean changeConvoState;


    public void initNPC(){
        reloadMap = false;
        rewardDisplay = false;
        checkQuestChange = false;
        updateQuestState = 0;
        changeConvoState = false;

        currentNpcInteraction = -1;
    }

    public void drawNPC(Graphics g){
        for(int i = 0; i < numOfNpc; i++) {
            mapNpcs[i].drawNpcMovement(g);
        }
    }

    public boolean npcCheck(Character player, NPC other){
        if(player.getMapPosX() >= other.getMapPosX() -20 && player.getMapPosX() <= other.getMapPosX() + 20){
            if(player.getMapPosY() >= other.getMapPosY() -50 && player.getMapPosY() <= other.getMapPosY() + 20){
                return true;
            }
        }
            return false;
    }

    public void checkRangeNPC(Character playerMan) {
        for(int i = 0; i < numOfNpc; i++) {
            if (npcCheck(playerMan, mapNpcs[i])) {
                currentNpcInteraction = i;
                playerMan.setInConvo(true);
                return;
            }
        }
    }

    public void updateNPC(double dt,Collision collisionDetector){
        for(int i = 0; i < numOfNpc; i++) {
            mapNpcs[i].updateNpcMovement(dt,collisionDetector);
        }



    }





    public int updateQuest(double dt){

        //Quest Check
        if (checkQuestChange && currentNpcInteraction != -1) {
            updateQuestState = mapNpcs[currentNpcInteraction].updateConvo();

            if(updateQuestState == 99) {
                playerMan.setCombatActive(true);

                if (playerMan.getCurrentQuestName() == "The Missing Peices") {
                    playerMan.setMonsterGen(1);
                    playerMan.setValliardAlive(false);
                } else if (playerMan.getCurrentQuestName() == "A Spy In The Clutches") {
                    playerMan.setMonsterGen(2);
                    playerMan.setQuestStage(15);
                    playerMan.changeQuest();
                } else if (playerMan.getCurrentQuestName() == "No Escape From Reality"){
                    playerMan.setMonsterGen(2);
                    playerMan.setQuestStage(19);
                    playerMan.changeQuest();
                }

                reloadMap = true;
                mapNpcs[1].undoCollision(collisionDetector);
                updateQuestState = 0;
                return 2;
            }else if(updateQuestState == 98){
                switch((int)playerMan.getCurrentMapLocation()){
                    case 38:
                    case 50:
                        playerMan.setCollectableState(0,true);
                        reloadMap = true;
                        break;
                    case 14:
                        playerMan.setCollectableState(6,true);
                        reloadMap = true;
                        break;
                    case 15:
                        playerMan.setCollectableState(5,true);
                        reloadMap = true;
                        break;
                    case 22:
                        playerMan.setCollectableState(4,true);
                        reloadMap = true;
                        break;
                    case 24:
                        playerMan.setCollectableState(3,true);
                        reloadMap = true;
                        break;
                    case 25:
                        playerMan.setCollectableState(2,true);
                        reloadMap = true;
                        break;
                    case 31:
                        playerMan.setCollectableState(1,true);
                        reloadMap = true;
                        break;
                    case 32:
                        playerMan.setCollectableState(0,true);

                        reloadMap = true;
                        break;
                }
                playerMan.setCollectableNum(playerMan.getCollectableNum() + 1);
                mapNpcs[0].undoCollision(collisionDetector);

                updateQuestState = 0;
            }else if(updateQuestState == 97) {
                playerMan.setCurrentShopActive(0);
                updateQuestState = 0;
                return 6;
            }else if(updateQuestState == 96) {
                playerMan.setCurrentShopActive(1);
                updateQuestState = 0;
                return 6;
            }else if(updateQuestState != 0) {
                playerMan.setQuestStage(updateQuestState);
                playerMan.changeQuest();
                updateQuestState = 0;
                rewardDisplay = true;



            }
            checkQuestChange = false;
        }

        if(rewardDisplay){
            rewardDisplay = playerMan.updateQuestReward(dt);

        }
        return 0;
    }



    public void drawNPCInteraction(Graphics2D g){
        if(playerMan.isInConvo()) {
            mapNpcs[currentNpcInteraction].drawConvo(g,playerMan.getName(), playerMan.getCurrentQuestState(),playerMan.getCurrentQuestName(),playerMan.getQuestStage());
        }
    }



    public void keyPressed(KeyEvent e) {

        if(!playerMan.isInConvo()) {

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                playAudio(clicks);
                    checkRangeNPC(playerMan);


            }
        }else {
            changeConvoState = mapNpcs[currentNpcInteraction].keyPressed(e);
            if(e.getKeyCode() == KeyEvent.VK_SPACE){


                playerMan.setInConvo(changeConvoState);
                checkQuestChange = true;
            }

        }

    }

}


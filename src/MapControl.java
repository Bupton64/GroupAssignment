import java.awt.*;
import java.awt.event.*;


public class MapControl extends extraFunctions {


    MapControl(Character playerMan) {
        this.playerMan = playerMan;
        swapMap = true;
        firstMap = true;
        mapNpcs = new NPC[10];
        numOfNpc = 0;
    }


    ///////////////////////////////////
    ///
    /// Map Control
    ///
    //////////////////////////////////


    /**
     * try in to follow my format under your own Level.
     */
    boolean firstMap; //< Checks if this the first map to load when game starts
    boolean swapMap; //< checks if map should be changed

    enum Level {Forest, Plains}; //< enum to hold what level the game is on

    Level levelController = Level.Plains;  //< Change from desert to yours to get your map running

    extraFunctions currentMap; //< Holds current map data
    NPC[] mapNpcs; //< Objects to hold NPC data
    int numOfNpc; //<Number of NPC's loaded into map

    Character playerMan;



    public void drawMap(Graphics g) {
        if (!firstMap) {
            drawImage(currentMap.backgroundImage, 0, 0, 800, 600, g);


            for(int i = 0; i < numOfNpc; i++) {
                drawImage(mapNpcs[i].sprite, mapNpcs[i].getMapPosX(), mapNpcs[i].getMapPosY(), mapNpcs[i].getWidth(), mapNpcs[i].getHeight(), g);
            }


        }
    }




    public void updateMap(Collision collisionDetector) {

        if (!firstMap) {
            swapMap = currentMap.updateMapMovement(collisionDetector, playerMan);

        }

        if (swapMap) {

            if (!firstMap) {
                currentMap.setUpCollision(collisionDetector);
                for (int i = 0; i < numOfNpc; i++) {
                    mapNpcs[i].setUpCollision(collisionDetector, currentMap);
                }
            }

            for (int i = 0; i < numOfNpc; i++) {
                mapNpcs[i] = new npc_empty();
            }

            swapMap = false;
            firstMap = false;
            numOfNpc = 0;
            if (levelController == Level.Plains) {
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
                        break;
                    case 15:
                        currentMap = new plains_D11();
                        break;
                    case 16:
                        currentMap = new plains_D12();
                        break;
                    case 17:
                        currentMap = new plains_E5();
                        mapNpcs[0] = new npc_wizard(playerMan);
                        numOfNpc = 1;
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
                        mapNpcs[0] = new npc_plains_E9_byBridge(playerMan);
                        mapNpcs[1] = new npc_plains_E9_byFence();
                        mapNpcs[2] = new npc_plains_E9_byField();
                        mapNpcs[3] = new npc_E9_signBottom();
                        numOfNpc = 4;
                        break;
                    case 22:
                        currentMap = new plains_E10();
                        break;
                    case 23:
                        currentMap = new plains_E11();
                        mapNpcs[0] = new npc_plains_E11();
                        numOfNpc = 1;
                        break;
                    case 24:
                        currentMap = new plains_E12();
                        break;
                    case 25:
                        currentMap = new plains_E13();
                        break;
                    case 26:
                        currentMap = new plains_F6();
                        break;
                    case 27:
                        currentMap = new plains_F7();
                        break;
                    case 28:
                        currentMap = new plains_F8();
                        mapNpcs[0] = new npc_plains_f8_oldman();
                        mapNpcs[1] = new npc_plains_f8_byLog();
                        numOfNpc = 2;
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
                        break;
                    case 32:
                        currentMap = new plains_F12();
                        break;
                    case 33:
                        currentMap = new plains_G7();
                        mapNpcs[0] = new npc_plains_G7(playerMan);
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
                        break;
                    case 39:
                        currentMap = new plains_H9();
                        mapNpcs[0] = new npc_plains_H9(playerMan);
                        numOfNpc = 1;
                        break;
                    case 40:
                        currentMap = new plains_H10();
                        break;
                    case 41:
                        currentMap = new plains_I9();
                        break;
                }
            }
        }

//            } else if (levelController == Level.Forest) {
//                switch ((int) playerMan.getCurrentMapLocation()) {
//                    case 0:
//                        currentMap = new forest_A4();
//                        break;
//                    case 1:
//                        currentMap = new forest_A5();
//                        break;
//                    case 2:
//                        currentMap = new forest_B3();
//                        break;
//                    case 3:
//                        currentMap = new forest_B4();
//                        break;
//                    case 4:
//                        currentMap = new forest_B5();
//                        break;
//                    case 5:
//                        currentMap = new forest_B6();
//                        break;
//                    case 6:
//                        currentMap = new forest_C2();
//                        break;
//                    case 7:
//                        currentMap = new forest_C3();
//                        break;
//                    case 8:
//                        currentMap = new forest_C4();
//                        break;
//                    case 9:
//                        currentMap = new forest_C5();
//                        break;
//                    case 10:
//                        currentMap = new forest_C6();
//                        break;
//                    case 11:
//                        currentMap = new forest_C7();
//                        break;
//                    case 12:
//                        currentMap = new forest_D1();
//                        break;
//                    case 13:
//                        currentMap = new forest_D2();
//                        break;
//                    case 14:
//                        currentMap = new forest_D3();
//                        break;
//                    case 15:
//                        currentMap = new forest_D4();
//                        break;
//                    case 16:
//                        currentMap = new forest_D5();
//                        break;
//                    case 17:
//                        currentMap = new forest_D6();
//                        break;
//                    case 18:
//                        currentMap = new forest_D7();
//                        break;
//                    case 19:
//                        currentMap = new forest_D8();
//                        break;
//                    case 20:
//                        currentMap = new forest_E1();
//                        break;
//                    case 21:
//                        currentMap = new forest_E2();
//                        break;
//                    case 22:
//                        currentMap = new forest_E3();
//                        break;
//                    case 23:
//                        currentMap = new forest_E4();
//                        break;
//                    case 24:
//                        currentMap = new forest_E5();
//                        break;
//                    case 25:
//                        currentMap = new forest_E6();
//                        break;
//                    case 26:
//                        currentMap = new forest_E7();
//                        break;
//                    case 27:
//                        currentMap = new forest_E8();
//                        break;
//                    case 28:
//                        currentMap = new forest_F2();
//                        break;
//                    case 29:
//                        currentMap = new forest_F3();
//                        break;
//                    case 30:
//                        currentMap = new forest_F4();
//                        break;
//                    case 31:
//                        currentMap = new forest_F5();
//                        break;
//                    case 32:
//                        currentMap = new forest_F6();
//                        break;
//                    case 33:
//                        currentMap = new forest_F7();
//                        break;
//                    case 34:
//                        currentMap = new forest_G3();
//                        break;
//                    case 35:
//                        currentMap = new forest_G4();
//                        break;
//                    case 36:
//                        currentMap = new forest_G5();
//                        break;
//                    case 37:
//                        currentMap = new forest_G6();
//                        break;
//                    case 38:
//                        currentMap = new forest_H4();
//                        break;
//                    case 39:
//                        currentMap = new forest_H5();
//                        break;
//
//                }
//
//            }
//        }
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

    boolean npcConvo;
    int currentNpcInteraction;

    public boolean isNpcConvo() {
        return npcConvo;
    }

    public void setNpcConvo(boolean npcConvo) {
        this.npcConvo = npcConvo;
    }

    public void initNPC(){
        npcConvo = false;
        currentNpcInteraction = -1;
    }

    public boolean npcCheck(Character player, NPC other){
        if(player.getMapPosX() >= other.getMapPosX() -20 && player.getMapPosX() <= other.getMapPosX() + 20){
            if(player.getMapPosY() >= other.getMapPosY() -20 && player.getMapPosY() <= other.getMapPosY() + 20){
                return true;
            }
        }
            return false;
    }

    public void checkRangeNPC(Character playerMan) {
        for(int i = 0; i < numOfNpc; i++) {
            if (npcCheck(playerMan, mapNpcs[i])) {
                currentNpcInteraction = i;
                npcConvo = true;
                return;
            }
        }
    }

    public void updateNPC(double dt,CharacterMovement movement,Collision collisionDetector){
        if(!movement.checkStationary()){
            currentNpcInteraction = -1;
            npcConvo = false;
        }
        for(int i = 0; i < numOfNpc;i++){
            mapNpcs[i].npcAction(dt, collisionDetector);
        }
    }

    public void drawNPCInteraction(Graphics2D g){
        if(npcConvo) {
            mapNpcs[currentNpcInteraction].drawConvo(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(!npcConvo) {
                checkRangeNPC(playerMan);
            }

        }
    }

}


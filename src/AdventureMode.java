

import java.awt.*;
import java.awt.event.*;



public class AdventureMode extends GameEngine {
    public static void main(String[] args) {
        createGame( new AdventureMode(),30);
    }






// Menu stuff



    private boolean pause = false;
    private int cursorPosistionY = 440;
    private boolean invMenu = false;
    private boolean equMenu = false;
    private boolean chaMenu = true;




    //////////////////////////////////
    ///
    /// Game
    ///
    /////////////////////////////////

    MapControl mapController;
    Character playerMan;
    CharacterMovement playerMovement;
    Collision collisionDetector;
    Combat combatMode;

    boolean[] createCombat;



    public void init(){
        setWindowSize(800,600);
        playerMan = new Character();
        collisionDetector = new Collision();
        playerMovement = new CharacterMovement(playerMan);
        mapController = new MapControl();

        createCombat = new boolean[1];
        createCombat[0] = false;

        playerMovement.initCharMovement();
        collisionDetector.initCollision();
        playerMan.setCurrentMapLocation(21); //< Change what map you start on
    }


    @Override
    public void update(double dt) {
        if(!pause) {
            if (playerMan.getCombatActive()) {
                if (createCombat[0]) {

                    combatMode = new Combat(playerMan);
                    createCombat[0] = false;
                }

                state = GameState.CombatMode;
            } else {
                state = GameState.TravelMode;
            }
            if (state == GameState.TravelMode) {
                mapController.updateMap(playerMan, collisionDetector);
                collisionDetector.updateCollision(playerMan, playerMovement);
                playerMovement.updateCharMovement(dt, collisionDetector, createCombat, playerMan);
            } else if (state == GameState.CombatMode) {
                combatMode.update(dt);

            }
        }
    }


    @Override
    public void paintComponent() {
        if (!pause) {
            clearBackground(800, 600);
            changeBackgroundColor(white);
            if (state == GameState.TravelMode) {
                mapController.drawMap(mGraphics); //< Draw the Map
                playerMovement.drawCharMovement(mGraphics);//<Draw Player
            } else if (state == GameState.CombatMode) {
                combatMode.paintComponent(mGraphics); //< Draw Combat
            }


            //Debug Lines Remove on your version
            changeColor(white);
            drawText(50, 70, Integer.toString((int) playerMan.getMapPosX() / 10), "Times New Roman", 20);
            drawText(50, 40, Integer.toString(collisionDetector.blocknum(playerMan)), "Times New Roman", 30);
            drawText(50, 90, Integer.toString((int) playerMan.getMapPosY() / 10), "Times New Roman", 20);
        }else{
            if(chaMenu) {
                clearBackground(800, 600);
                changeColor(black);
               // drawBoldText(100, 100, Integer.toString(cursorPosistionY));
                drawBoldText(650, 450, "RESUME", "New Roman Times", 20);
                drawBoldText(650, 480, "INVENTORY", "New Roman Times", 20);
                drawBoldText(650, 510, "EQUIPMENT", "New Roman Times", 20);
                drawBoldText(650, 540, "EXIT", "New Roman Times", 20);
                drawBoldText(3, 595, "Current Map Number: "+ playerMan.getCurrentMapLocation(), "New Roman Times", 15);
                drawBoldText(3, 30, playerMan.getName(), "Impact", 25);
                changeColor(red);
                drawBoldText(3, 50,"hp  "+ playerMan.getCurrentHP(), "New Roman Times", 15);
                changeColor(black);
                drawBoldText(3, 65, "xp "+ playerMan.getXPTotal(), "New Roman Times", 15);
                changeColor(blue);
                drawBoldText(3, 80, "lvl "+ playerMan.getCurrentLevel(), "New Roman Times", 15);

                changeColor(blue);
                drawBoldText(3, 575, "You need "+ playerMan.getXPToNextLevel()+" more xp to lvl up", "New Roman Times", 15);


                changeColor(red);
                drawSolidCircle(640, cursorPosistionY, 5);
            }else if(invMenu){
                clearBackground(800, 600);
                changeColor(black);
                drawBoldText(100, 100, "Add Inventory here");
                drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15);
            }else if(equMenu){
                clearBackground(800, 600);
                changeColor(black);
                drawBoldText(100, 100, "Add Equipment here");
                drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15);


            }


        }
    }

    ///////////////////////////////////////////
    ///
    ///   Keybinds
    ///
    ////////////////////////////////////////////

    enum GameState{TravelMode,CombatMode,MenuMode}
    GameState state = GameState.TravelMode;

    public void keyPressed (KeyEvent e) {
        if(state == GameState.TravelMode){
            playerMovement.keyPressed(e);
        }
        if(state == GameState.CombatMode){
            combatMode.keyPressed(e);
        }


    }


    @Override
    public void keyReleased(KeyEvent e) {
        if(state == GameState.TravelMode){
            playerMovement.keyReleased(e);
        }
        if(state == GameState.CombatMode){
            playerMovement.keyReleased(e);
            combatMode.keyReleased(e);

        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE&&chaMenu == true){
            pause = !pause;
            chaMenu = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE&&chaMenu == false){
            chaMenu = true;
        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_DOWN)&&cursorPosistionY<510){
            cursorPosistionY+=30;

        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_UP)&&cursorPosistionY>450){
            cursorPosistionY-=30;

        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==440){
            pause = !pause;

        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==530){
            System.exit(23);
        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==470){
            invMenu = true;
            equMenu = false;
            chaMenu = false;
        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==500){
            equMenu = true;
            invMenu = false;
            chaMenu = false;
        }


    }



}

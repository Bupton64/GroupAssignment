

import java.awt.*;
import java.awt.event.*;



public class AdventureMode extends GameEngine {
    public static void main(String[] args) {
        createGame(new AdventureMode(), 30);
    }







    //////////////////////////////////
    ///
    /// Game
    ///
    /////////////////////////////////
    Menu menuController;
    MapControl mapController;
    Character playerMan;
    CharacterMovement playerMovement;
    Collision collisionDetector;
    Combat combatMode;

    boolean[] createCombat;
    boolean menuCheck;


    public void init() {
        setWindowSize(800, 600);
        playerMan = new Character();
        playerMovement = new CharacterMovement(playerMan);

        collisionDetector = new Collision();
        mapController = new MapControl();


        menuController = new Menu();
        menuCheck = false;
        

        createCombat = new boolean[1];
        createCombat[0] = false;

        playerMovement.initCharMovement();
        collisionDetector.initCollision();
        playerMan.setCurrentMapLocation(21); //< Change what map you start on
    }


    @Override
    public void update(double dt) {
       if(menuCheck == false) {
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
               playerMovement.updateCharMovement(dt, createCombat, playerMan);
           } else if (state == GameState.CombatMode) {
               combatMode.update(dt);

           }
       }
    }


    @Override
    public void paintComponent() {
        clearBackground(800, 600);
        changeBackgroundColor(white);
        if (state == GameState.TravelMode) {
            mapController.drawMap(mGraphics); //< Draw the Map
            playerMovement.drawCharMovement(mGraphics);//<Draw Player
        } else if (state == GameState.CombatMode) {
            combatMode.paintComponent(mGraphics); //< Draw Combat
        } else if (state == GameState.OverworldMenu) {
            menuController.drawMenu(mGraphics);

        }


        //Debug Lines Remove on your version
        changeColor(white);
        drawText(50, 70, Integer.toString((int) playerMan.getMapPosX() / 10), "Times New Roman", 20);
        drawText(50, 40, Integer.toString(collisionDetector.blocknum(playerMan)), "Times New Roman", 30);
        drawText(50, 90, Integer.toString((int) playerMan.getMapPosY() / 10), "Times New Roman", 20);


    }

    ///////////////////////////////////////////
    ///
    ///   Keybinds
    ///
    ////////////////////////////////////////////

    enum GameState {TravelMode, CombatMode, OverworldMenu, MainMenu}

    GameState state = GameState.TravelMode;

    public void keyPressed(KeyEvent e) {
        if (state == GameState.TravelMode) {
            playerMovement.keyPressed(e);
        }
        if (state == GameState.CombatMode) {
            combatMode.keyPressed(e);
        }
        if(state == GameState.OverworldMenu){
            menuController.keyPressed(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if(menuController.chaMenu) {
                menuCheck = !menuCheck;
                menuController.initMenu();
                state = GameState.OverworldMenu;
            }else{
                menuController.chaMenu = true;
            }
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(state == GameState.OverworldMenu)&&menuController.cursorPositionY == 440 ){
            menuCheck = !menuCheck;
        }


    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (state == GameState.TravelMode) {
            playerMovement.keyReleased(e);
        }
        if (state == GameState.CombatMode) {
            playerMovement.keyReleased(e);
            combatMode.keyReleased(e);
        }
        if(state == GameState.OverworldMenu){
            playerMovement.keyReleased(e);
            
        }



    }
}

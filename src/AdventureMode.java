

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

    enum GameState {TravelMode, CombatMode, OverWorldMenu, MainMenu}
    GameState state = GameState.TravelMode;

    int stateChanger;

    Menu MenuController;
    StartScreen StartController;
    MapControl mapController;
    Character playerMan;
    CharacterMovement playerMovement;
    Collision collisionDetector;
    Combat combatMode;



    public void init() {

        setWindowSize(800, 600);
        playerMan = new Character();
        playerMovement = new CharacterMovement(playerMan);

        collisionDetector = new Collision();
        mapController = new MapControl(playerMan);

        MenuController = new Menu(playerMan);
        MenuController.initMenu();

        StartController = new StartScreen();

        playerMovement.initCharMovement();
        collisionDetector.initCollision();
        mapController.initNPC();

        playerMan.setCurrentMapLocation(21); //< Change what map you start on
        stateChanger = 0;
        state = GameState.MainMenu;
        StartController.initStart();

    }

   public void updateGameState(){
        if(stateChanger != 0) {

            if(stateChanger == 1){
                state = GameState.TravelMode;
            }else if(stateChanger == 2){
                combatMode = new Combat(playerMan);
                state = GameState.CombatMode;
            }else if(stateChanger == 3){
                state = GameState.OverWorldMenu;
            }else if(stateChanger == 4){
                state = GameState.MainMenu;
            }


            stateChanger = 0;
        }
   }

    @Override
    public void update(double dt) {

        updateGameState();




           if (state == GameState.TravelMode) {

              mapController.updateNPC(dt,playerMovement,collisionDetector);
             mapController.updateQuest(dt);


               mapController.updateMap(collisionDetector);
               collisionDetector.updateCollision(playerMan, playerMovement);
              stateChanger = playerMovement.updateCharMovement(dt, playerMan);
           } else if (state == GameState.CombatMode) {
              stateChanger =  combatMode.update(dt);
           }else if(state == GameState.OverWorldMenu) {
               //add Update later
           }
    }


    @Override
    public void paintComponent() {
        clearBackground(800, 600);
        changeBackgroundColor(white);
        if (state == GameState.TravelMode) {

            mapController.drawMap(mGraphics); //< Draw the Map

            playerMovement.drawCharMovement(mGraphics);//<Draw Player

            mapController.drawNPCInteraction(mGraphics);
            playerMan.getCurrentQuest().drawQuest(mGraphics);
           // questInProgress.drawQuest(mGraphics);


        } else if (state == GameState.CombatMode) {
            combatMode.paintComponent(mGraphics); //< Draw Combat
        } else if (state == GameState.OverWorldMenu) {
            changeBackgroundColor(blue);
            MenuController.drawChaMenu(mGraphics);
            MenuController.drawInvMenu(mGraphics);
            MenuController.drawEquMenu(mGraphics);


        }else if(state == GameState.MainMenu){
            StartController.changeBackgroundColor(black, mGraphics);
            StartController.drawStartScreen(mGraphics);
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



    public void keyPressed(KeyEvent e) {
        if (state == GameState.TravelMode) {
            playerMovement.keyPressed(e);
            mapController.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                stateChanger = 3;
            }
        }

        if (state == GameState.CombatMode) {
            combatMode.keyPressed(e);
        }



        if(state == GameState.OverWorldMenu){
            MenuController.keyPressed(e);
            if(e.getKeyCode() == KeyEvent.VK_SPACE && MenuController.getCursorPositionY() == 440 ){
                stateChanger = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE && MenuController.isChaMenu()) {
                stateChanger = 1;
            }

        }
        if (state == GameState.MainMenu){
            StartController.keyPressed(e);
            if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(StartController.cursorPositionY == 100)){
                stateChanger = 1;
            }


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
        if(state == GameState.OverWorldMenu){
            playerMovement.keyReleased(e);
            MenuController.keyReleased(e);
            
        }



    }
}

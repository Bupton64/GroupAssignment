

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

    enum GameState {TravelMode, CombatMode, OverWorldMenu, MainMenu, Shop1Mode, Shop2Mode, CutScene}
    GameState state = GameState.TravelMode;

    int stateChanger;

    Menu MenuController;
    StartScreen StartController;
    MapControl mapController;
    Character playerMan;
    CharacterMovement playerMovement;
    Collision collisionDetector;
    Combat combatMode;
    Shop1 Shop1Controller;
    cutScene cut_scene;



    public void init() {

        setWindowSize(800, 600);
        playerMan = new Character();
        playerMovement = new CharacterMovement(playerMan);

        collisionDetector = new Collision();
        mapController = new MapControl(playerMan);

        MenuController = new Menu(playerMan);
        MenuController.initMenu();

        Shop1Controller = new Shop1();
        Shop1Controller.shopInit();

        StartController = new StartScreen();

        playerMovement.initCharMovement();
        collisionDetector.initCollision();
        mapController.initNPC();

        playerMan.setCurrentMapLocation(21); //< Change what map you start on
        stateChanger = 0;
        state = GameState.MainMenu;
        StartController.initStart();

        cut_scene = new cutScene();
    }



   public void updateGameState(){
        if(stateChanger != 0) {

            if(stateChanger == 1){
                state = GameState.TravelMode;
            }else if(stateChanger == 2){
                combatMode = new Combat(playerMan,playerMan.getMonsterGen());
                state = GameState.CombatMode;
            }else if(stateChanger == 3){
                state = GameState.OverWorldMenu;
            }else if(stateChanger == 4){
                state = GameState.MainMenu;
            }else if(stateChanger == 5){
                state = GameState.Shop1Mode;
            }
            else if(stateChanger == 7){
                state = GameState.CutScene;
            }


            stateChanger = 0;
        }
   }

    @Override
    public void update(double dt) {

        updateGameState();




           if (state == GameState.TravelMode) {

              mapController.updateNPC(dt,playerMovement,collisionDetector);



               mapController.updateMap(collisionDetector);
               collisionDetector.updateCollision(playerMan, playerMovement);
              stateChanger = playerMovement.updateCharMovement(dt, playerMan);
              if(stateChanger != 2) {
                  stateChanger = mapController.updateQuest(dt);
              }
           } else if (state == GameState.CombatMode) {
              stateChanger =  combatMode.update(dt);
           }else if(state == GameState.OverWorldMenu) {
               //add Update later

           }else if(state == GameState.MainMenu){
               StartController.updateTimer(dt);
           } else if(state == GameState.CutScene){
               cut_scene.updateTimer(dt);
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

            changeColor(white);
            drawText(50, 70, Integer.toString((int) playerMan.getMapPosX() / 10), "Times New Roman", 20);
            drawText(50, 40, Integer.toString(collisionDetector.blocknum(playerMan)), "Times New Roman", 30);
            drawText(50, 90, Integer.toString((int) playerMan.getMapPosY() / 10), "Times New Roman", 20);


        } else if (state == GameState.CombatMode) {
            combatMode.paintComponent(mGraphics); //< Draw Combat
        } else if (state == GameState.OverWorldMenu) {
            changeBackgroundColor(black);
            MenuController.drawChaMenu(mGraphics);
            MenuController.drawInvMenu(mGraphics);
            MenuController.drawEquMenu(mGraphics);


        }else if(state == GameState.MainMenu){
            changeBackgroundColor(black);
            StartController.drawStartScreen(mGraphics);
        }else if(state == GameState.Shop1Mode){
            Shop1Controller.drawShop(mGraphics);

        }else if(state == GameState.CutScene) {
            changeBackgroundColor(black);
            cut_scene.drawCutScene(mGraphics);
        }


        //Debug Lines Remove on your version



    }

    ///////////////////////////////////////////
    ///
    ///   Keybinds
    ///
    ////////////////////////////////////////////



    public void keyPressed(KeyEvent e) {
        if (state == GameState.TravelMode) {
            if(!playerMan.isInConvo()) {
                playerMovement.keyPressed(e);
            }
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
            if(e.getKeyCode() == KeyEvent.VK_SPACE && MenuController.getCursorPositionY() == 440 ) {
                stateChanger = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE && MenuController.isChaMenu()) {
                stateChanger = 1;
            }

        }
        if (state == GameState.MainMenu){
            StartController.keyPressed(e);
            if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(StartController.cursorPositionY == 150)&& !StartController.startup){
                stateChanger = 7;
            }


        }
        if(e.getKeyCode() == KeyEvent.VK_T){
            stateChanger = 5;
        }
        if(state == GameState.Shop1Mode){
            Shop1Controller.keyPressed(e);
        }
        if(state == GameState.CutScene){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
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

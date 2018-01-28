

import java.awt.*;
import java.awt.event.*;



public class AdventureMode extends GameEngine {
    public static void main(String[] args) {
        createGame(new AdventureMode(), 30);
    }



    saveGame saveController;

    //////////////////////////////////
    ///
    /// Game
    ///
    /////////////////////////////////

    enum GameState {TravelMode, CombatMode, OverWorldMenu, MainMenu, CutScene, ShopMode, endCutScene}
    GameState state = GameState.TravelMode;

    private int stateChanger;

    private Menu menuController;
    private StartScreen startController;
    private MapControl mapController;
    private Character playerMan;
    private CharacterMovement playerMovement;
    private Collision collisionDetector;
    private Combat combatMode;
    private cutScene cutScene;
    private ShopControl shopController;
    private endCutScene endCutSceneController;



    AudioClip backgroundMusic;
    AudioClip cutSceneMusic;
    AudioClip villageMusic;
    AudioClip menuMusic;
    AudioClip clicks;
    private float volume;
    private boolean stopper;
    private boolean mute;


   public void stopMusic(){
        stopAudioLoop(villageMusic);
        stopAudioLoop(menuMusic);
        stopAudioLoop(cutSceneMusic);
        stopAudioLoop(backgroundMusic);
    }



    public void init() {
        cutSceneMusic = loadAudio("cutscene.wav");
        backgroundMusic = loadAudio("epic.wav");
        villageMusic = loadAudio("village.wav");
        menuMusic = loadAudio("menuMusic.wav");
        clicks = loadAudio("clicks.wav");
        mute = false;
        stopper = false;
        volume = 0;

        setWindowSize(800, 600);
        playerMan = new Character();



        shopController = new ShopControl(playerMan);

        saveController = new saveGame(playerMan);
        cutScene = new cutScene();
        endCutSceneController = new endCutScene();

        stateChanger = 0;
        state = GameState.MainMenu;

        menuController = new Menu(playerMan,saveController);
        startController = new StartScreen(playerMan,saveController);
        playerMovement = new CharacterMovement(playerMan);
        collisionDetector = new Collision();
        mapController = new MapControl(playerMan,collisionDetector);


        initFade();

    }


    private void updateGameState(){
        switch(stateChanger) {
            case 0:
                break;
            case 1:
                state = GameState.TravelMode;
                stopMusic();
                volume = -10;
                if(!stopper) {
                    startAudioLoop(villageMusic, volume);
                    stopper = true;
                }

                break;
            case 2:
                combatMode = new Combat(playerMan, playerMan.getMonsterGen());
                state = GameState.CombatMode;
               stopMusic();
               stopper = false;
                break;
            case 3:
                state = GameState.OverWorldMenu;
                stopMusic();
                stopper = false;
                break;
            case 4:
                state = GameState.MainMenu;
                break;
            case 5:
                state = GameState.endCutScene;
                break;
            case 6:
                state = GameState.ShopMode;
                stopMusic();

                stopper = false;
                volume = -13;
                startAudioLoop(menuMusic, volume);
                break;
            case 7:
                state = GameState.CutScene;
                stopMusic();
                volume = +6;
                startAudioLoop(cutSceneMusic, volume);
                break;

        }
       stateChanger = 0;

        if(mute){
            stopAudioLoop(villageMusic);
            stopAudioLoop(menuMusic);
            stopAudioLoop(cutSceneMusic);
        }
   }

    @Override
    public void update(double dt) {

        updateGameState();

        switch (state){
            case TravelMode:
                updateFade(dt);
                mapController.updateNPC(dt,collisionDetector);
                mapController.updateMap();
                collisionDetector.updateCollision(playerMan, playerMovement);
                stateChanger = playerMovement.updateCharMovement(dt, playerMan);
                if(stateChanger != 9 && stateChanger != 5) {
                    stateChanger = mapController.updateQuest(dt);
                }
                if(stateChanger == 9){
                    stateChanger = 0;
                    fadeState = true;
                    timer = 0;
                }
                if(fadeState){
                    if(timer >= 1){
                        stateChanger = 2;
                        if(timer > 1.5) {
                            fadeState = false;
                        }
                    }
                }
                break;
            case CombatMode:
                stateChanger =  combatMode.update(dt);
                break;
            case ShopMode:
                shopController.updateShopControl(playerMan.getCurrentShopActive());
                break;
            case MainMenu:
                startController.updateTimer(dt);
                break;
            case endCutScene:
                endCutSceneController.updateTimer(dt);
                break;
            case CutScene:
                cutScene.updateTimer(dt);
                break;
            case OverWorldMenu:
                break;

        }
    }


    @Override
    public void paintComponent() {
        clearBackground(800, 600);
        changeBackgroundColor(white);

        switch (state){
            case TravelMode:

                mapController.drawMap(mGraphics); //< Draw the Map
                playerMovement.drawCharMovement(mGraphics);//<Draw Player
                mapController.drawNPCInteraction(mGraphics);
             //   playerMan.getCurrentQuest().drawQuest(mGraphics);
                if(fadeState){
                    drawFade();

                }

                changeColor(white);
                drawText(50, 70, Integer.toString((int) playerMan.getMapPosX() / 10), "Times New Roman", 20);
                drawText(50, 40, Integer.toString(collisionDetector.blocknum(playerMan)), "Times New Roman", 30);
                drawText(50, 90, Integer.toString((int) playerMan.getMapPosY() / 10), "Times New Roman", 20);
                drawText(50, 110, Integer.toString(playerMan.getQuestStage()), "Times New Roman", 20);
                break;
            case CombatMode:
                combatMode.paintComponent(mGraphics); //< Draw Combat
                break;
            case OverWorldMenu:
                changeBackgroundColor(black);
                menuController.drawMenu(mGraphics);
                break;
            case ShopMode:
                changeBackgroundColor(black);
                shopController.drawShopControl(mGraphics);
                break;
            case MainMenu:
                changeBackgroundColor(black);
                startController.drawStartMenu(mGraphics);
                break;
            case CutScene:
                changeBackgroundColor(black);
                cutScene.drawCutScene(mGraphics);
                break;
            case endCutScene:
                endCutSceneController.drawCutScene(mGraphics);
                break;
        }

    }

    private double timer;
    private Image fade;
    private Image fadeArray[];
    private boolean fadeState;

    public void updateFade(double dt){
        timer+=dt;
    }

    public void initFade(){
        fadeState = false;
        timer = 0;
        fadeArray = new Image[10];
        fade = loadImage("fade.png");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                fadeArray[(i*5) + j] = subImage(fade, j*160, i*120, 140, 100);
            }
        }
    }
    
    public void drawFade(){
        if(timer > 0 && timer < 1){
            drawImage(fadeArray[0], 0,0,800,600);
        }
        if(timer > 0.1 && timer < 0.2){
            drawImage(fadeArray[1], 0,0,800,600);
        }
        if(timer > 0.2 && timer < 0.3){
            drawImage(fadeArray[2], 0,0,800,600);
        }
        if(timer > 0.3 && timer < 0.4){
            drawImage(fadeArray[3], 0,0,800,600);
        }
        if(timer > 0.4 && timer < 0.5){
            drawImage(fadeArray[4], 0,0,800,600);
        }
        if(timer > 0.5 && timer < 0.6){
            drawImage(fadeArray[5], 0,0,800,600);
        }
        if(timer > 0.6 && timer < 0.7){
            drawImage(fadeArray[6], 0,0,800,600);
        }
        if(timer > 0.7 && timer < 0.8){
            drawImage(fadeArray[7], 0,0,800,600);
        }
        if(timer > 0.8 && timer < 0.9){
            drawImage(fadeArray[8], 0,0,800,600);
        }
        if(timer > 0.9 && timer < 1.5){
            drawImage(fadeArray[9], 0,0,800,600);
        }
    }

    ///////////////////////////////////////////
    ///
    ///   Keybinds
    ///
    ////////////////////////////////////////////



    public void keyPressed(KeyEvent e) {
        switch (state){
            case TravelMode:
                if(!playerMan.isInConvo()) { playerMovement.keyPressed(e); }
                mapController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    playAudio(clicks);
                    stateChanger = 3;
                }

                if(e.getKeyCode() == KeyEvent.VK_V){
                    saveController.save("SaveOne.txt");
                }
                if(e.getKeyCode() == KeyEvent.VK_B){
                    saveController.loadGame(playerMan,"SaveOne.txt");
                    mapController.setReloadMap(true);
                }

                break;
            case CombatMode:
                combatMode.keyPressed(e);
                break;
            case OverWorldMenu:
                stateChanger = menuController.keyPressed(e);
                break;
            case MainMenu:
                stateChanger = startController.keyPressed(e);
                break;
            case CutScene:
                stateChanger = cutScene.keyPressed(e);
                break;
            case endCutScene:
                stateChanger = endCutSceneController.keyPressed(e);
                break;
            case ShopMode:
                stateChanger = shopController.keyPressed(e);
                break;
        }
        if(e.getKeyCode() == KeyEvent.VK_M){
            mute = !mute;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

        switch (state){
            case TravelMode:
                playerMovement.keyReleased(e);
                break;
            case CombatMode:
                combatMode.keyReleased(e);
                playerMovement.keyReleased(e);
                break;
            case OverWorldMenu:
                menuController.keyReleased(e);
                playerMovement.keyReleased(e);
                break;
        }
    }

}

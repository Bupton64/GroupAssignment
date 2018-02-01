/*
* 159.103 - Introduction to Games Programming - Assignment 2
*
* Bjarne's World - A classical JRPG
*
* Team 9 -
* Zane Lamb - 15160640
* Benjamin Upton - 16463710
* Jordan Drumm - 17044923
* James Waddell - 16379344
*
*/
import java.awt.*;
import java.awt.event.*;



public class AdventureMode extends GameEngine {
    public static void main(String[] args) {
        createGame(new AdventureMode(), 40);
    }


    /////////////////////////////////
    ///
    /// Fade
    ///
    /////////////////////////////////


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
        fade = loadImage("Image/fade.png");
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




    //////////////////////////////////
    ///
    /// Game
    ///
    /////////////////////////////////

    enum GameState {TravelMode, CombatMode, OverWorldMenu, MainMenu, CutScene, ShopMode, endCutScene, razuulCutscene, finalCutscene, razuulCutsceneAlternate}
    GameState state = GameState.TravelMode;

    private int stateChanger;
    private boolean generateCombat;
    private boolean generateRest;

    saveGame saveController;
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
    private RazuulCutscene razuulCutsceneController;
    private finalCutscene finalCutsceneController;



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
        cutSceneMusic = loadAudio("Audio/cutscene.wav");
        backgroundMusic = loadAudio("Audio/epic.wav");
        villageMusic = loadAudio("Audio/village.wav");
        menuMusic = loadAudio("Audio/menuMusic.wav");
        clicks = loadAudio("Audio/clicks.wav");
        mute = false;
        stopper = false;
        volume = 0;

        setWindowSize(800, 600);
        playerMan = new Character();

        finalCutsceneController = new finalCutscene();
        razuulCutsceneController = new RazuulCutscene();
        shopController = new ShopControl(playerMan);

        saveController = new saveGame(playerMan);
        cutScene = new cutScene();
        endCutSceneController = new endCutScene();

        generateCombat = false;
        generateRest = false;
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
                stopAudioLoop(menuMusic);
                stopAudioLoop(cutSceneMusic);
                stopAudioLoop(backgroundMusic);
                volume = -10;
                if(!stopper) {
                    startAudioLoop(villageMusic, volume);
                    stopper = true;
                }

                break;
            case 2:
               stopMusic();
               stopper = false;
               stopAudioLoop(cutSceneMusic);
                state = GameState.CombatMode;
                break;
            case 3:
                state = GameState.OverWorldMenu;
                break;
            case 4:
                state = GameState.MainMenu;
                break;
            case 5:
                stopMusic();
                startAudioLoop(cutSceneMusic, volume);
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
            case 8:
                stopMusic();
                playAudio(cutSceneMusic, volume);
                state = GameState.razuulCutscene;
                playerMan.setMapPosX(520);
                playerMan.setMapPosY(210);
                playerMan.setDirectionFacing(Character.Direction.left);
                break;
            case 13:
                stopMusic();
                startAudioLoop(cutSceneMusic, volume);
                state = GameState.finalCutscene;
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
        playerMan.setGameTimer(playerMan.getGameTimer() + dt);

        updateGameState();
        updateFade(dt);
        switch (state){
            case TravelMode:

                mapController.updateNPC(dt,collisionDetector);
                mapController.updateMap();
                collisionDetector.updateCollision(playerMan, playerMovement);
                stateChanger = playerMovement.updateCharMovement(dt, playerMan);

                if(stateChanger != 9 && stateChanger != 5 && stateChanger != 10) {
                    stateChanger = mapController.updateQuest(dt);
                }
                if((stateChanger == 9) || (stateChanger == 10)){
                    if(stateChanger == 9) {
                        generateCombat = true;
                    }
                    stateChanger = 0;
                    fadeState = true;
                    timer = 0;
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
                stateChanger = endCutSceneController.updateTimer(dt);
                if(stateChanger == 11){
                    playerMan.setMonsterGen(5);
                    stateChanger = 0;
                    generateCombat =true;
                    fadeState = true;
                    timer = 0;

                }
                break;
            case CutScene:
                cutScene.updateTimer(dt);
                break;
            case OverWorldMenu:
                menuController.updateMenu();
                break;
            case razuulCutscene:
                razuulCutsceneController.updateTimer(dt);
                break;
            case finalCutscene:
               stateChanger = finalCutsceneController.updateTimer(dt);
                break;
        }
        if(fadeState){

            playerMovement.stopMovement();
            if(timer >= 1){

                if(generateCombat){
                    stateChanger = 2;
                    playerMan.setCombatActive(true);
                    combatMode = new Combat(playerMan, playerMan.getMonsterGen());
                    generateCombat = false;
                }

                if(timer > 1.5) {
                    fadeState = false;
                    mapController.setReloadMap(true);
                }
            }
        }
    }


    @Override
    public void paintComponent() {
        clearBackground(800, 600);
        changeBackgroundColor(black);

        switch (state){
            case TravelMode:
                mapController.drawMap(mGraphics); //< Draw the Map
                playerMovement.drawCharMovement(mGraphics);//<Draw Player
                mapController.drawNPCInteraction(mGraphics);
                playerMan.getCurrentQuest().drawQuestReward(mGraphics);
                if(fadeState){
                    drawFade();

                }
                //debugging code
//                changeColor(white);
//                drawText(50, 70, Integer.toString((int) playerMan.getMapPosX() / 10), "Times New Roman", 20);
//                drawText(50, 40, Integer.toString(collisionDetector.blocknum(playerMan)), "Times New Roman", 30);
//                drawText(50, 90, Integer.toString((int) playerMan.getMapPosY() / 10), "Times New Roman", 20);
//                drawText(50, 110, Integer.toString(playerMan.getQuestStage()), "Times New Roman", 20);
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
                if(fadeState){
                    drawFade();

                }
                break;
            case razuulCutscene:
                if(playerMan.getNpcDeaths() == 0) {
                    razuulCutsceneController.drawRazuulCutscene(mGraphics);
                }else{
                    razuulCutsceneController.drawRazuulCutscene2(mGraphics);
                }
                break;
            case finalCutscene:
                finalCutsceneController.drawFinalCutsene(mGraphics, playerMan.getNpcDeaths());
                break;
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
                if(!playerMan.isInConvo() && !fadeState) { playerMovement.keyPressed(e); }
                mapController.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE && !fadeState && !playerMan.isInConvo()) {
                    playAudio(clicks);
                    stateChanger = 3;
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
            case razuulCutscene:
                stateChanger = razuulCutsceneController.keyPressed(e);
                break;
            case finalCutscene:
                finalCutsceneController.keyPressed(e);
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

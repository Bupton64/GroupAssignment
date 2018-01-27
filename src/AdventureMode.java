

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
    float volume = 0;
    boolean stopper = false;
    boolean mute = false;



    public void init() {



        cutSceneMusic = loadAudio("cutscene.wav");
        backgroundMusic = loadAudio("epic.wav");
        villageMusic = loadAudio("village.wav");
        menuMusic = loadAudio("menuMusic.wav");
        clicks = loadAudio("clicks.wav");

        setWindowSize(800, 600);
        playerMan = new Character();
        playerMovement = new CharacterMovement(playerMan);
        collisionDetector = new Collision();
        mapController = new MapControl(playerMan,collisionDetector);
        menuController = new Menu(playerMan,saveController);
        shopController = new ShopControl(playerMan);

        saveController = new saveGame(playerMan);
        cutScene = new cutScene();
        endCutSceneController = new endCutScene();

        stateChanger = 0;
        state = GameState.MainMenu;

        startController = new StartScreen(playerMan,saveController);



    }


    private void updateGameState(){
        switch(stateChanger) {
            case 0:
                break;
            case 1:
                state = GameState.TravelMode;
                stopAudioLoop(cutSceneMusic);
                stopAudioLoop(menuMusic);
                volume = -8;
                if(!stopper) {
                    startAudioLoop(villageMusic, volume);
                    stopper = true;
                }

                break;
            case 2:
                combatMode = new Combat(playerMan, playerMan.getMonsterGen());
                state = GameState.CombatMode;
                break;
            case 3:
                state = GameState.OverWorldMenu;
                break;
            case 4:
                state = GameState.MainMenu;
                break;
            case 5:
                state = GameState.endCutScene;
                break;
            case 6:
                state = GameState.ShopMode;
                stopAudioLoop(villageMusic);
                stopper = false;
                startAudioLoop(menuMusic);
                break;
            case 7:
                state = GameState.CutScene;
                startAudioLoop(cutSceneMusic);
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

                mapController.updateNPC(dt,collisionDetector);
                mapController.updateMap();
                collisionDetector.updateCollision(playerMan, playerMovement);
                stateChanger = playerMovement.updateCharMovement(dt, playerMan);
                if(stateChanger != 2 && stateChanger != 5) {
                    stateChanger = mapController.updateQuest(dt);
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
                playerMan.getCurrentQuest().drawQuest(mGraphics);

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

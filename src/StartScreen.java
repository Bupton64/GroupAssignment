import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.lang.String;






public class StartScreen extends extraFunctions {

    StartScreen(Character playerMan, saveGame Load){
        this.player = playerMan;
        this.loadController = Load;
        initStart();
    }

    MapControl reloader;

    enum startState {startScreen, loadScreen, credits}
    startState state = startState.startScreen;
    Image buttonSprite;
   Image buttonSpriteSheet = loadImage("buttons.png");
    Image paper = loadImage("paper.png");
    Image paper2 = loadImage("paper2.png");
    Image sword = loadImage("sword.png");
    Image sword2 = loadImage("sword2.png");
    Image Logo = loadImage("BjournesWorld.png");
    Image equipmentSprite = loadImage("equipmentSprite.png");
    Image background3;
    Image StartBackground;
    Image swordSprite;
    Image swordSprite2;
    //Image Logo;
    int cursorPositionY = 230;
    int num = 0;
    double timer =0;
    boolean startup = true;
    boolean intro = true;
    double index1 = 11.1;
    double index2 = 11.2;
    double index3 = 11.3;
    double index4 = 11.4;
    AudioClip credits;



    public void initStart(){
        clicks = loadAudio("Audio/clicks.wav");
        clicks2 = loadAudio("Audio/clicks2.wav");
        exitClick = loadAudio("Audio/exitClick.wav");
        introMusic = loadAudio("Audio/epic.wav");
        credits = loadAudio("Audio/credits.wav");
        p2 = loadAudio("Audio/page2.wav");
        startAudioLoop(introMusic, -3);
        StartBackground = subImage(paper, 0, 0, 768, 1028);
        StartBackground = subImage(paper2, 0, 0, 1028, 768);
        swordSprite = subImage(sword, 0, 0, 1793, 445);
        swordSprite2 = subImage(sword2, 0, 0, 1793, 445);
        background3 = subImage(equipmentSprite, 0, 0, 800, 600);
        //Logo = subImage(logo, 0, 0,518,91);
        buttonSprite = subImage(buttonSpriteSheet,30,70,180,80);
        CreditsEnd = new Credits();

        initLoad();

    }

    public void updateTimer(double dt){

        timer +=dt;
        if(state == startState.loadScreen){
            updateLoad();
        }
    }
    Credits CreditsEnd;

    public void drawStartMenu(Graphics2D g){
        changeBackgroundColor(black,g);
        if(state == startState.startScreen){
            drawStartScreen(g);
        }else if(state == startState.loadScreen){
            drawLoad(g);
        } else if(state == startState.credits){
            CreditsEnd.drawCredits(g);
        }
    }

    public void drawStartScreen(Graphics2D g){

        clearBackground(800, 600, g);
        //changeBackgroundColor(black,g);

        changeColor(white, g);

        if((timer >2)&&(timer<5)) {
            changeColor(grey1,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >2.1) &&(timer<5)){
            changeColor(grey2,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >2.2) &&(timer<5)){
            changeColor(grey3,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >2.3)&&(timer<5)) {
            changeColor(grey4,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >2.5)&&(timer<5)) {
            changeColor(grey5,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >2.6) &&(timer<5)){
            changeColor(grey6,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >2.7)&&(timer<5)) {
            changeColor(white,g);
            clearBackground(800, 600, g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4)&&(timer<5)) {
            changeColor(grey6,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4.1)&&(timer<5)) {
            changeColor(grey5,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4.2)&&(timer<5)) {
            changeColor(grey4,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4.3)&&(timer<5)) {
            changeColor(grey3,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4.4) &&(timer<5)){
            changeColor(grey2,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4.5)&&(timer<5)) {
            changeColor(grey1,g);
            drawBoldText(150, 300, "A 40/40 Studios Production", g);
        }
        if((timer >4.6)&&(timer<5)){
            clearBackground(800, 600, g);

        }

        if(timer>6){
            if(timer<10.9) {
                if(num<105) {
                    num += 1;
                }
            }
            //drawText(100, 100, Integer.toString(num), g);
            drawImage(Logo, 394-(num*3), 225,6*num,1*num,g );
        }
        if((num>104)&&(timer<100)) {
            changeColor(white, g);
            drawText(210, 500, "- Press <SPACE> to begin your adventure -",  "New Roman Times", 20, g);

        }
        if((timer > 100)&&intro){
            System.exit(23);
        }

        //drawBoldText(100, 100, Double.toString(timer), g);

        if(intro == false) {

            stopAudioLoop(credits);
            clearBackground(800 ,600, g);
            drawImage(background3, 0, 0, g);
            drawImage(Logo, 130, 80, g);
            drawImage(buttonSprite, 275, 197, 225, 60, g);
            drawImage(buttonSprite, 275, 197+80, 225, 60, g);
            drawImage(buttonSprite, 275, 197+160, 225, 60, g);
            drawImage(buttonSprite, 275, 197+230, 225, 60, g);

            drawImage(swordSprite, 520, cursorPositionY - 20, 1793 / 20, 445 / 20, g);
            drawImage(swordSprite2, 167, cursorPositionY - 20, 1793 / 20, 445 / 20, g);

            changeColor(black, g);

            changeColor(white, g);
            drawBoldText(328, 230, "New Game", "Felix Titling", 20, g);
            drawBoldText(322, 230 + 80, "Load game", "Felix Titling", 20, g);
            drawBoldText(340, 230 + 160, "Credits", "Felix Titling", 20, g);
            drawBoldText(365, 230 + 230, "Exit", "Felix Titling", 20, g);
            startup = false;
        }

    }


    ////////////////////////////////
    ///
    ///     Load
    ///
    ///////////////////////////////


    Character player;
    saveGame loadController;

    private String loadOneQuestName;
    private String loadOneLevel;
    private double loadOneTimer;
    private boolean loadOneDisplay;


    private String loadTwoQuestName;
    private String loadTwoLevel;
    private double loadTwoTimer;
    private boolean loadTwoDisplay;


    private String loadThreeQuestName;
    private String loadThreeLevel;
    private double loadThreeTimer;
    private boolean loadThreeDisplay;

    private boolean getLoadFiles;

    File SaveOne = new  File("SaveOne.txt");
    File SaveTwo = new File("SaveTwo.txt");
    File SaveThree = new File("SaveThree.txt");

    public void initLoad(){


        try{
            SaveOne.createNewFile();
            SaveTwo.createNewFile();
            SaveThree.createNewFile();
        }
        catch(IOException e){
       }


        getLoadFiles = false;

        loadOneQuestName = "";
        loadOneLevel = "";
        loadOneTimer = 0.0;
        loadOneDisplay = false;


        loadTwoQuestName = "";
        loadTwoLevel = "";
        loadTwoTimer = 0.0;
        loadTwoDisplay = false;

        loadThreeQuestName = "";
        loadThreeLevel = "";
        loadThreeTimer = 0.0;
        loadThreeDisplay = false;
    }

    public void getLoadFiles(){
        String temp;
        double timer;
        try (BufferedReader br = new BufferedReader(new FileReader("SaveOne.txt"))) {

            temp = br.readLine();
            if(temp == null){


            }else{
                timer = Double.parseDouble(br.readLine());
                loadOneQuestName = temp;
                loadOneTimer = timer;
                loadOneLevel = br.readLine();
                loadOneDisplay = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("SaveTwo.txt"))) {

            temp = br.readLine();
            if(temp == null){


            }else{
                timer = Double.parseDouble(br.readLine());
                loadTwoQuestName = temp;
                loadTwoTimer = timer;
                loadTwoLevel = br.readLine();
                loadTwoDisplay = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("SaveThree.txt"))) {

            temp = br.readLine();
            if(temp == null){


            }else{
                timer = Double.parseDouble(br.readLine());
                loadThreeQuestName = temp;
                loadThreeTimer = timer;
                loadThreeLevel = br.readLine();
                loadThreeDisplay = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void updateLoad(){
        if(!getLoadFiles){
            getLoadFiles();
            getLoadFiles = true;
        }

       // File file = new File("SaveOne.txt");

    }

    public void drawLoad(Graphics2D g){
        clearBackground(800, 600, g);
      changeBackgroundColor(black,g);
      drawImage(background3, 0, 0, g);
    //    drawImage(StartBackground, 210, 10, 350 * 1.2, 500 * 1.2, g);
        changeColor(purple, g);
        drawBoldText(280, 120, "Load Files", "Felix Titling", 35, g);
        changeColor(red, g);
        drawBoldText(200, 150 + 80, "Save 1", "Felix Titling", 20, g);
        if(loadOneDisplay) {
            changeColor(black, g);
            drawBoldText(390, 220, loadOneQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 240, "Level " +loadOneLevel, "Felix Titling", 15, g);
            drawBoldText(470, 240, "Time " + (int)loadOneTimer / 60 + ":" + (int)loadOneTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 230, "Empty", "Felix Titling", 15, g);
        }
        changeColor(red, g);
        drawBoldText(200, 150 + 160, "Save 2", "Felix Titling", 20, g);
        if(loadTwoDisplay) {
            changeColor(black, g);
            drawBoldText(390, 300, loadTwoQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 320, "Level " +loadTwoLevel, "Felix Titling", 15, g);
            drawBoldText(470, 320, "Time " + (int)loadTwoTimer / 60 + ":" + (int)loadTwoTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 310, "Empty", "Felix Titling", 15, g);
        }
        changeColor(red, g);
        drawBoldText(200, 150 + 240, "Save 3", "Felix Titling", 20, g);
        if(loadThreeDisplay) {
            changeColor(black, g);
            drawBoldText(390, 380, loadThreeQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 400, "Level " +loadThreeLevel, "Felix Titling", 15, g);
            drawBoldText(470, 400, "Time " + (int)loadThreeTimer / 60 + ":" + (int)loadThreeTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 390, "Empty", "Felix Titling", 15, g);
        }


        drawImage(swordSprite, 620, cursorPositionY - 20, 89, 22, g);
        drawImage(swordSprite2, 100, cursorPositionY - 20, 89, 22, g);


    }



    public int keyPressed(KeyEvent e){
        if(state == startState.startScreen){
            return startKeyPressed(e);
        }else if(state == startState.loadScreen){
            return loadKeyPressed(e);
        }else if(state == startState.credits){
            state = CreditsEnd.keyPressed(e);
        }

        return 0;
    }


    public int loadKeyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playAudio(p2);
            cursorPositionY = 310;
            state = startState.startScreen;
        }
        if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 390) {
            playAudio(clicks);
            cursorPositionY += 80;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 230) {
            cursorPositionY -= 80;
            playAudio(clicks);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            playAudio(exitClick);
            if(cursorPositionY == 230 && loadOneDisplay){
                loadController.loadGame(player,"SaveOne.txt");
                return 1;

            }else if(cursorPositionY == 310 && loadTwoDisplay){
                playAudio(exitClick);

                loadController.loadGame(player,"SaveTwo.txt");
                return 1;
            }else if(cursorPositionY == 390 && loadThreeDisplay){
                playAudio(exitClick);
                loadController.loadGame(player,"SaveThree.txt");
                return 1;
            }
        }

        return 0;
    }

    public int startKeyPressed(KeyEvent e) {
        if(startup&&(e.getKeyCode() == KeyEvent.VK_SPACE)&&intro) {
            stopAudioLoop(introMusic);
            intro = false;
        }
        if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 470) {
            playAudio(clicks);

            cursorPositionY += 80;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 230) {
            cursorPositionY -= 80;

            playAudio(clicks);

        }
        if (((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 470)) {
            System.exit(23);
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(cursorPositionY == 230)&& !startup){
            playAudio(exitClick);
            player = new Character();
            return 7;
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(cursorPositionY == 310)){
            playAudio(p2);
            cursorPositionY -= 80;
            state = startState.loadScreen;
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(cursorPositionY == 390)) {
           playAudio(exitClick);
            startAudioLoop(credits, +5);
           state = startState.credits;
           CreditsEnd.setWordsScrollingY(600);
        }
        return 0;
    }

}

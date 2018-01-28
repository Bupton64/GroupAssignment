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

    Image paper = loadImage("paper.png");
    Image sword = loadImage("sword.png");
    Image sword2 = loadImage("sword2.png");
    Image logo = loadImage("BjournesWorld.png");
    Image StartBackground;
    Image swordSprite;
    Image swordSprite2;
    Image Logo;
    int cursorPositionY = 150;
    int num = 0;
    double timer =0;
    boolean startup = true;
    boolean intro = true;
    double index1 = 11.1;
    double index2 = 11.2;
    double index3 = 11.3;
    double index4 = 11.4;

    Credits Credits;

    public void initStart(){
        clicks = loadAudio("clicks.wav");
        clicks2 = loadAudio("clicks2.wav");
        exitClick = loadAudio("exitClick.wav");
        introMusic = loadAudio("epic.wav");
        startAudioLoop(introMusic, -3);
        StartBackground = subImage(paper, 0, 0, 768, 1028);
        swordSprite = subImage(sword, 0, 0, 1793, 445);
        swordSprite2 = subImage(sword2, 0, 0, 1793, 445);
        Logo = subImage(logo, 0, 0,518,91);


        initLoad();

    }

    public void updateTimer(double dt){

        timer +=dt;
        if(state == startState.loadScreen){
            updateLoad();
        }
    }

    public void drawStartMenu(Graphics2D g){
        changeBackgroundColor(black,g);
        if(state == startState.startScreen){
            drawStartScreen(g);
        }else if(state == startState.loadScreen){
            drawLoad(g);
        } else if(state == startState.credits){
            Credits.drawCredits(g);
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
            drawText(100, 100, Integer.toString(num), g);
            drawImage(Logo, 85, 100,6*num,1*num,g );
        }
        if((num>104)&&(timer<100)) {
            changeColor(white, g);
            drawText(220, 500, "- Press <SPACE> to begin your adventure -",  "New Roman Times", 20, g);

        }
        if((timer > 100)&&intro){
            System.exit(23);
        }

        //drawBoldText(100, 100, Double.toString(timer), g);

        if(intro == false) {
            clearBackground(800 ,600, g);
            drawImage(StartBackground, 210, 10, 350 * 1.2, 500 * 1.2, g);
            drawImage(swordSprite, 500, cursorPositionY - 20, 1793 / 20, 445 / 20, g);
            drawImage(swordSprite2, 250, cursorPositionY - 20, 1793 / 20, 445 / 20, g);

            changeColor(black, g);

            changeColor(red, g);
            drawBoldText(358, 150, "New Game", "Felix Titling", 20, g);
            drawBoldText(352, 150 + 80, "Load game", "Felix Titling", 20, g);
            drawBoldText(370, 150 + 160, "Credits", "Felix Titling", 20, g);
            drawBoldText(395, 150 + 240, "Exit", "Felix Titling", 20, g);
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

    public void initLoad(){
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
      changeBackgroundColor(black,g);
    //    drawImage(StartBackground, 210, 10, 350 * 1.2, 500 * 1.2, g);
        changeColor(black, g);
        drawBoldText(330, 150, "Load Files", "Felix Titling", 30, g);
        changeColor(red, g);
        drawBoldText(280, 150 + 80, "Save_1", "Felix Titling", 20, g);
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
        drawBoldText(280, 150 + 160, "Save_2", "Felix Titling", 20, g);
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
        drawBoldText(280, 150 + 240, "Save_3", "Felix Titling", 20, g);
        if(loadThreeDisplay) {
            changeColor(black, g);
            drawBoldText(390, 380, loadThreeQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 400, "Level " +loadThreeLevel, "Felix Titling", 15, g);
            drawBoldText(470, 400, "Time " + (int)loadThreeTimer / 60 + ":" + (int)loadThreeTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 390, "Empty", "Felix Titling", 15, g);
        }


        drawImage(swordSprite, 600, cursorPositionY - 20, 89, 22, g);
        drawImage(swordSprite2, 150, cursorPositionY - 20, 89, 22, g);


    }



    public int keyPressed(KeyEvent e){
        if(state == startState.startScreen){
            return startKeyPressed(e);
        }else if(state == startState.loadScreen){
            return loadKeyPressed(e);
        }

        return 0;
    }


    public int loadKeyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
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
            if(cursorPositionY == 230 && loadOneDisplay){
                loadController.loadGame(player,"SaveOne.txt");
                return 1;

            }else if(cursorPositionY == 310 && loadTwoDisplay){
                loadController.loadGame(player,"SaveTwo.txt");
                return 1;
            }else if(cursorPositionY == 390 && loadThreeDisplay){
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
        if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 390) {
            playAudio(clicks);

            cursorPositionY += 80;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 150) {
            cursorPositionY -= 80;

            playAudio(clicks);

        }
        if (((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 390)) {
            System.exit(23);
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(cursorPositionY == 150)&& !startup){
            playAudio(exitClick);
            player = new Character();
            return 7;
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&(cursorPositionY == 230)){
            playAudio(exitClick);
            state = startState.loadScreen;
        }

        return 0;
    }

}

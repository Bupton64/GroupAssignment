import java.awt.*;
import java.awt.event.*;
import java.lang.String;






public class StartScreen extends extraFunctions {
    StartScreen(){
        initStart();
    }

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


    public void initStart(){
        clicks = loadAudio("clicks.wav");
        clicks2 = loadAudio("clicks2.wav");
        exitClick = loadAudio("exitClick.wav");
        introMusic = loadAudio("epic.wav");
        startAudioLoop(introMusic);
        StartBackground = subImage(paper, 0, 0, 768, 1028);
        swordSprite = subImage(sword, 0, 0, 1793, 445);
        swordSprite2 = subImage(sword2, 0, 0, 1793, 445);
        Logo = subImage(logo, 0, 0,518,91);


    }
    public void updateTimer(double dt){
        timer +=dt;
    }

    public void drawStartMenu(Graphics2D g){
        if(state == startState.startScreen){
            drawStartScreen(g);
        }
    }

    public void drawStartScreen(Graphics2D g){

        clearBackground(800, 600, g);
        changeBackgroundColor(black,g);
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
            changeColor(grey4, g);
            drawBoldText(352, 150 + 80, "Load game", "Felix Titling", 20, g);
            changeColor(red, g);
            drawBoldText(370, 150 + 160, "Credits", "Felix Titling", 20, g);
            drawBoldText(395, 150 + 240, "Exit", "Felix Titling", 20, g);
            startup = false;
        }

    }

    public void drawLoad(Graphics2D g){
        drawImage(StartBackground, 210, 10, 350 * 1.2, 500 * 1.2, g);


    }

    public void loadGame(saveGame loadController, Character playerMan){
        loadController.loadGame(playerMan);

    }

    public int keyPressed(KeyEvent e) {
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
           return 7;
        }
        return 0;
    }

}

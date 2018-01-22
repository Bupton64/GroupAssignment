import java.awt.*;

public class cutScene extends extraFunctions {
    //WON'T BE USED FOR A WHILE

    Image background;
    Image backgroundAlt;
    Image spriteSheet;
    Image spriteUp[];
    Image spriteDown[];
    Image spriteLeft[];
    Image spriteRight[];
    double timer;
    double timePast;
    boolean back;
    int posX;
    int posY;
    int flameChange;


    enum introState {text, animation}
    introState state;

    /*
     * Loads all required images
     */
    cutScene(){
        background = loadImage("intro_cutscene.png");
        backgroundAlt = loadImage("intro_cutscene2.png");
        timer = 0;
        timePast = 0;
        back = true;
        state = introState.text;
        spriteSheet = loadImage("chara1.png");
        spriteUp = new Image[3];
        spriteDown = new Image[3];
        spriteLeft = new Image[3];
        spriteRight = new Image[3];
        posX = 0;
        posY = 0;
        flameChange = 0;
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,312 + (52 * i), 288,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteUp[i] = subImage(spriteSheet,312 + (52 * i), 504,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteLeft[i] = subImage(spriteSheet,312 + (52 * i), 360,52,72);
        }
        for(int i =0; i < 3;i++){
            spriteRight[i] = subImage(spriteSheet,312 + (52 * i), 432,52,72);
        }
    }
    /*
     * Updates the timer
     */
    public void updateTimer(double dt){
        timer +=dt;
    }

    /*
     * Draws the whole cutscene
     */
    public void drawCutScene(Graphics2D g){
        System.out.println("Test1");
        if(state == introState.text) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            changeColor(white, g);

            if ((timer > 2) && (timer < 5)) {
                changeColor(grey1, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 2.1) && (timer < 5)) {
                changeColor(grey2, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 2.2) && (timer < 5)) {
                changeColor(grey3, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 2.3) && (timer < 5)) {
                changeColor(grey4, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 2.5) && (timer < 5)) {
                changeColor(grey5, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 2.6) && (timer < 5)) {
                changeColor(grey6, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 2.7) && (timer < 5)) {
                changeColor(white, g);
                clearBackground(800, 600, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4) && (timer < 5)) {
                changeColor(grey6, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4.1) && (timer < 5)) {
                changeColor(grey5, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4.2) && (timer < 5)) {
                changeColor(grey4, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4.3) && (timer < 5)) {
                changeColor(grey3, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4.4) && (timer < 5)) {
                changeColor(grey2, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4.5) && (timer < 5)) {
                changeColor(grey1, g);
                drawBoldText(150, 300, "In the distant future...", g);
            }
            if ((timer > 4.6) && (timer < 5)) {
                clearBackground(800, 600, g);
                state = introState.animation;
            }
        }
        if(state == introState.animation){
            flameChange++;
            if(flameChange % 3 == 0){
                back = !back;
            }
            if(back){
                drawImage(background, posX, posY, g);
            } else{
                drawImage(backgroundAlt, posX, posY, g);
            }
            posX--;
            posY--;
        }
    }
}

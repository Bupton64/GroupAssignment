import java.awt.*;

public class cutScene extends extraFunctions {
    //WON'T BE USED FOR A WHILE

    Image background;
    Image backgroundAlt;
    Image spriteSheet;
    Image spriteSheet2;
    Image spriteUp[];
    Image spriteDown[];
    Image spriteLeft[];
    Image spriteRight[];
    Image spriteDown2[];
    Image spriteLeft2[];
    Image spriteRight2[];
    double timer;
    double timePast;
    boolean back;
    int posX;
    int posY;
    int flameChange;
    int runSpeed;
    int runSpeedLeft;
    int height;


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
        spriteSheet = loadImage("scaredRunning.png");
        spriteSheet2 = loadImage("chara2.png");
//        spriteUp = new Image[3];
        spriteDown = new Image[3];
//        spriteLeft = new Image[3];
//        spriteRight = new Image[3];
        spriteDown2 = new Image[3];
//        spriteLeft2 = new Image[3];
//        spriteRight2 = new Image[3];
        posX = -800;
        posY = -600;
        runSpeed = 0;
        runSpeedLeft = 0;
        flameChange = 0;
        height = 0;
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,156 + (52 * i), 0,52,72);
            spriteDown2[i] = subImage(spriteSheet,312 + (52 * i), 0,52,72);
        }
//        for(int i =0; i < 3;i++){
//            spriteLeft[i] = subImage(spriteSheet,104 + (52 * i), 360,52,72);
//            spriteLeft2[i] = subImage(spriteSheet2,312 + (52 * i), 360,52,72);
//        }
//        for(int i =0; i < 3;i++) {
//            spriteRight[i] = subImage(spriteSheet, 104 + (52 * i), 432, 52, 72);
//            spriteRight2[i] = subImage(spriteSheet2, 312 + (52 * i), 432, 52, 72);
//        }
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
        if(state == introState.text) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            changeColor(white, g);

            if ((timer > 2) && (timer < 5)) {
                changeColor(grey1, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.1) && (timer < 5)) {
                changeColor(grey2, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.2) && (timer < 5)) {
                changeColor(grey3, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.3) && (timer < 5)) {
                changeColor(grey4, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.5) && (timer < 5)) {
                changeColor(grey5, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.6) && (timer < 5)) {
                changeColor(grey6, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.7) && (timer < 5)) {
                changeColor(white, g);
                clearBackground(800, 600, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4) && (timer < 5)) {
                changeColor(grey6, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4.1) && (timer < 5)) {
                changeColor(grey5, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4.2) && (timer < 5)) {
                changeColor(grey4, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4.3) && (timer < 5)) {
                changeColor(grey3, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4.4) && (timer < 5)) {
                changeColor(grey2, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4.5) && (timer < 5)) {
                changeColor(grey1, g);
                drawBoldText(300, 265, "In a far off land, the dark", g);
                drawBoldText(0, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(150, 335, "in a hunt for power and fortune.", g);
            }
            if ((timer > 4.6) && (timer < 5)) {
                clearBackground(800, 600, g);
                state = introState.animation;
            }
        }
        if(state == introState.animation){
            flameChange++;
            runSpeed+=2;
            if(flameChange % 3 == 0){
                back = !back;
            }
            if(back){
                drawImage(background, posX, posY, g);
            } else{
                drawImage(backgroundAlt, posX, posY, g);
            }
            if((posY + 200 + runSpeed) <280) {
                drawImage(spriteDown[flameChange % 3], posX + 857, posY + 1000 + runSpeed, g);
                drawImage(spriteDown2[flameChange % 3], posX + 1020, posY + 200 + runSpeed, g);
                height = runSpeed;
            } else if((posY + 200 + runSpeed) >=280) {
//                drawImage(spriteLeft2[flameChange % 3], posX + 1020 - runSpeedLeft, posY + 200 + height, g);
                if((posX +1020 - runSpeedLeft) > 560) {
                    drawImage(spriteDown2[flameChange % 3], posX + 1020 - runSpeedLeft, posY + 200 + runSpeed, g);
                }
                runSpeedLeft+=2;
            }
            if(posY < 0) {
                posX+=2;
                posY+=2;
            }
        }
    }
}


import java.awt.*;

public class cutScene extends extraFunctions {
    //WON'T BE USED FOR A WHILE

    Image background;
    Image backgroundAlt;
    Image spriteSheet;
    Image spriteSheet2;
    Image spriteSheet3;
    Image dialogueBack;
    Image dialogueBackSheet;
    Image spriteDown[];
    Image spriteDown2[];
    Image spriteDown3[];
    Image wizardDown[];
    Image wizardSpin[];
    double timer;
    double timePast;
    boolean back;
    boolean render;
    int posX;
    int posY;
    int flameChange;
    int runSpeed;
    int runSpeed2;
    int runSpeedLeft;
    int height;
    int wizardPosX;
    int wizardPosY;


    enum introState {text, animation}
    introState state;

    /*
     * Loads all required images
     */
    cutScene(){
        background = loadImage("intro_cutscene.png");
        backgroundAlt = loadImage("intro_cutscene2.png");
        timer = 0;
        timePast = 9999999;
        back = true;
        render = true;
        state = introState.text;
        spriteSheet = loadImage("scaredRunning.png");
        spriteSheet2 = loadImage("scaredRunning2.png");
        spriteSheet3 = loadImage("chara2.png");
        spriteDown = new Image[3];
        spriteDown2 = new Image[3];
        spriteDown3 = new Image[3];
        wizardDown = new Image[3];
        wizardSpin = new Image[4];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);
        posX = -800;
        posY = -600;
        runSpeed = 0;
        runSpeed2 = 0;
        runSpeedLeft = 0;
        flameChange = 0;
        height = 0;
        wizardPosX = 120;
        wizardPosY = -74;
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,156 + (52 * i), 0,52,72);
            spriteDown2[i] = subImage(spriteSheet,312 + (52 * i), 0,52,72);
            spriteDown3[i] = subImage(spriteSheet2,312 + (52 * i), 0,52,72);
            wizardDown[i] = subImage(spriteSheet3,468 + (52 * i), 288,52,72);
            wizardSpin[i] = subImage(spriteSheet3,530, 288 + (72*i),52,72);
        }
        wizardSpin[3] = subImage(spriteSheet3,530, 504,52,72);
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

            if(flameChange % 3 == 0){
                back = !back;
            }
            if(back){
                drawImage(background, posX, posY, g);
            } else{
                drawImage(backgroundAlt, posX, posY, g);
            }
            if((posY + 200 + runSpeed) <450) {
                runSpeed+=2;
                drawImage(spriteDown[flameChange % 3], posX + 857, posY + 1000 + runSpeed, g);
                drawImage(spriteDown2[flameChange % 3], posX + 1020, posY + 200 + runSpeed, g);
                height = runSpeed;
            }
            if(render) {
                runSpeed2 += 1;
                runSpeedLeft += 1;
                drawImage(spriteDown2[flameChange % 3], posX + 1020, posY + 200 + height, g);
                drawImage(spriteDown3[flameChange % 3], posX + 1200 + runSpeedLeft, posY + 180 + runSpeed, g);
                //Need if condition to break loop
                if((posY + 200 + height) > 800){
                    render = false;
                }
            }
            if(posY < 0) {
                posX+=2;
                posY+=2;
            }
            if((posY >= 0) && (wizardPosY < 50)){
                wizardPosY+=1;
                drawImage(wizardDown[flameChange % 3], wizardPosX, wizardPosY, g);
                timePast = timer + 5;
            }
            if((posY >= 0) && (wizardPosY >= 50)){
                if(timePast > timer) {
                    wizardPosY += 1;
                    changeColor(white, g);
                    drawImage(wizardDown[1], wizardPosX, 50, g);
                    drawImage(dialogueBack, 90, 400, 620, 165, g);
                    drawText(110, 450, "MWA HA HA HA! There's no stopping me now! Once I gain control", "Times New Roman", 20, g);
                    drawText(110, 475, "of the Seven Crystals of the South, my power will be un-matchable!", "Times New Roman", 20, g);
                }
            }
            if((timePast < timer) && (posY>=0)){
                drawImage(wizardSpin[flameChange % 4], wizardPosX, 50, g);
            }
        }
    }
}


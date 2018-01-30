import java.awt.*;
import java.awt.event.KeyEvent;

//condition == 1 is Julian dead
//condition == 2 is Sally dead
//condition == 3 is both dead

public class finalCutscene extends extraFunctions{

    double timer;
    int animationChange;
    int DjikstraPosY;
    Image backgroundFight;
    Image backgroundSevar;
    Image smokeSheet;
    Image smokeArray[];
    Image spritesheet;
    Image spritesheet2;
    Image spritesheet3;
    Image spritesheet4;
    Image spritesheet5;
    Image spritesheet6;
    Image BjarneSpin[];
    Image Therox;
    Image dialogueBackSheet;
    Image dialogueBack;
    Image bloodSheet;
    Image bloodArray[];
    Image fade;
    Image fadeArray[];
    Image temp;
    Image villagers[];
    Image Djikstra[];
    Image grave;
    boolean change;
    long currentTime;
    long initialTime;
    long elapsedTime;
    double interval;
    double dt;
    double extra;
    double fadeTemp;
    boolean hit;
    boolean hit2;

    finalCutscene(){
        hit = false;
        hit2 = false;
        timer = 0;
        animationChange = 0;
        change = false;
        DjikstraPosY = 500;
        backgroundFight = loadImage("bossFight.png");
        backgroundSevar = loadImage("plains_E5.png");       //PLACEHOLDER
        smokeSheet = loadImage("smoke.png");
        spritesheet = loadImage("chara1.png");
        spritesheet2 = loadImage("chara2.png");
        bloodSheet = loadImage("bloodSprite.png");
        Therox = subImage(spritesheet2, 520, 432, 52, 72);
        smokeArray = new Image[35];
        BjarneSpin = new Image[4];
        bloodArray = new Image[6];
        grave = loadImage("grave.png");
        fade = loadImage("fade.png");
        fadeArray = new Image[10];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);
        //NPCS
        villagers = new Image[12];
        spritesheet3 = loadImage("military2.png");
        villagers[0] = subImage(spritesheet3,52,144,56,72);      //D8
        spritesheet4 = loadImage("chara5.png");
        villagers[2] = subImage(spritesheet4,196,432,56,72);    //E8_byHouse
        villagers[3] = subImage(spritesheet2,208,360,56,72);    //E8_byLake
        villagers[10] = subImage(spritesheet4,364,144,56,72);     //E9_byBridgs
        spritesheet5 = loadImage("chara4.png");
        villagers[5] = subImage(spritesheet5,52,72,56,72);      //E9_byFence
        villagers[6] = subImage(spritesheet2, 52, 432, 56, 72); //E9_byField
        villagers[7] = subImage(spritesheet5,52,360,56,72);     //E11
        spritesheet6 = loadImage("chara3.png");
        villagers[11] = subImage(spritesheet2,364,360,56,72);    //F8_oldman
        villagers[4] = subImage(spritesheet2,196,144,56,72);    //F9_byBottomHouse
        villagers[1] = subImage(spritesheet4,52,360,56,72);    //F9_StoreBabbage
        villagers[8] = subImage(spritesheet6,520,144,56,72);    //F9_StoreLink
        villagers[9] = subImage(spritesheet6,52,360,56,72);    //H9

        Djikstra = new Image[3];
        for(int i = 0; i < 3; i++){
            Djikstra[i] = subImage(spritesheet2,468 + (52*i),216,52,72);
        }
        for(int i = 0; i < 6; i++){
            bloodArray[i] = subImage(bloodSheet, 512 * i, 0, 512, 512);
        }

        for(int i = 0; i < 4; i++) {
            BjarneSpin[i] = subImage(spritesheet,52, (72*i),52,72);
            for (int j = 0; j < 8; j++) {
                smokeArray[(i*8)+j] = subImage(smokeSheet, j * 128, i * 128, 128, 128);
            }
        }
        smokeArray[32] = subImage(smokeSheet, 0, 512, 128,128);
        smokeArray[33] = subImage(smokeSheet, 128, 512, 128,128);
        smokeArray[34] = subImage(smokeSheet, 256, 512, 128,128);

        temp = BjarneSpin[3];
        BjarneSpin[3]= BjarneSpin[2];
        BjarneSpin[2]= temp;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                fadeArray[(i*5) + j] = subImage(fade, j*160, i*120, 140, 100);
            }
        }
    }

    public void updateTimer(double dt){
        timer +=dt;
    }

    public void drawFinalCutsene(Graphics2D g, int condition){
        if(animationChange == 0){
            initialTime = getTime();
        }
        interval = 1000.0/40;
        dt = interval / 1000.0;
        currentTime = getTime();
        elapsedTime = currentTime - initialTime;
        if(interval > elapsedTime){
            extra = interval - elapsedTime;
            sleep(extra);
        } else if(elapsedTime > interval){
            dt = elapsedTime/1000;
        }
        animationChange++;
        if(!change){
            drawImage(backgroundFight, 0, 0, g);
        } else{
            drawImage(backgroundSevar, 0, 0, g);
        }

        if(dt <= 3){
            drawImage(Therox, 350, 300, g);
            drawImage(BjarneSpin[1], 400, 300, g);
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Therox:", "Times New Roman", 20, g);
            drawText(110, 450, "I-I... I can't believe it, you defeated me! Arghhhhhhhhhh", "Times New Roman", 20, g);
            drawText(110, 475, "", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt > 3 && dt <= 4){
            drawImage(BjarneSpin[1], 400, 300, g);
            drawImage(bloodArray[animationChange%6], 330, 300, 100, 100, g);
        }
        if(dt > 4 && dt <= 6){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawImage(BjarneSpin[1], 400, 300, g);
            drawText(110, 425, "Bjarne:", "Times New Roman", 20, g);
            drawText(110, 450, "It's... it's finally over...", "Times New Roman", 20, g);
            drawText(110, 475, "", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt > 6 && dt <= 10){
            drawImage(BjarneSpin[animationChange % 4], 400, 300, g);
            drawImage(smokeArray[animationChange % 35], 350, 250, g);
        }
        if(dt > 9 && dt <= 10){
            drawImage(villagers[0], 300, 250, g);
            drawImage(villagers[1], 500, 250, g);
            drawImage(villagers[2], 300, 300, g);
            drawImage(villagers[3], 500, 300, g);
            drawImage(villagers[4], 300, 350, g);
            drawImage(villagers[5], 500, 350, g);
            drawImage(villagers[6], 300, 400, g);
            drawImage(villagers[7], 500, 400, g);
            drawImage(villagers[8], 300, 450, g);
            drawImage(villagers[9], 500, 450, g);
            if(condition == 1){
                drawImage(villagers[10], 300, 500, g);
            } else if(condition == 2){
                drawImage(villagers[11], 500, 500, g);
            } else if(condition == 3){

            } else{
                drawImage(villagers[10], 300, 500, g);
                drawImage(villagers[11], 500, 500, g);
            }


            drawImage(Djikstra[1], 400, 500, g);
        }
        fadeTemp = dt;
        if(dt > 7 && dt < 11) {
            if(!hit){
                timer = 7;
                hit = !hit;
            }
            if (timer > 7 && timer < 42) {
                drawImage(fadeArray[0], 0, 0, 800, 600, g);
            }
            if (timer > 7.1 && timer < 7.2) {
                drawImage(fadeArray[1], 0, 0, 800, 600, g);
            }
            if (timer > 7.2 && timer < 7.3) {
                drawImage(fadeArray[2], 0, 0, 800, 600, g);
            }
            if (timer > 7.3 && timer < 7.4) {
                drawImage(fadeArray[3], 0, 0, 800, 600, g);

            }
            if (timer > 7.4 && timer < 7.5) {
                drawImage(fadeArray[4], 0, 0, 800, 600, g);
            }
            if (timer > 7.5 && timer < 7.6) {
                drawImage(fadeArray[5], 0, 0, 800, 600, g);
            }
            if (timer > 7.6 && timer< 7.7) {
                drawImage(fadeArray[6], 0, 0, 800, 600, g);
            }
            if (timer > 7.7 && timer < 7.8) {
                drawImage(fadeArray[7], 0, 0, 800, 600, g);
            }
            if (timer > 7.8 && timer < 7.9) {
                drawImage(fadeArray[8], 0, 0, 800, 600, g);
            }
            if (timer > 7.9 && timer < 8) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
            }
            if (timer > 8 && timer < 9) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
                change = true;
            }
            if (timer > 9 && timer < 9.1) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
            }
            if (timer > 9.1 && timer < 9.2) {
                drawImage(fadeArray[8], 0, 0, 800, 600, g);
            }
            if (timer > 9.2 && timer < 9.3) {
                drawImage(fadeArray[7], 0, 0, 800, 600, g);
            }
            if (timer > 9.3 && timer < 9.4) {
                drawImage(fadeArray[6], 0, 0, 800, 600, g);
            }
            if (timer > 9.4 && timer < 9.5) {
                drawImage(fadeArray[5], 0, 0, 800, 600, g);
            }
            if (timer > 9.5 && timer < 9.6) {
                drawImage(fadeArray[4], 0, 0, 800, 600, g);
            }
            if (timer > 9.6 && timer < 9.7) {
                drawImage(fadeArray[3], 0, 0, 800, 600, g);
            }
            if (timer > 9.7 && timer < 9.8) {
                drawImage(fadeArray[2], 0, 0, 800, 600, g);
            }
            if (timer > 9.8 && timer < 9.9) {
                drawImage(fadeArray[1], 0, 0, 800, 600, g);
            }
            if (timer > 9.9 && timer < 10) {
                drawImage(fadeArray[0], 0, 0, 800, 600, g);
            }
        }

        if(dt >= 11 && dt < 13){
            DjikstraPosY-=2;
            drawImage(villagers[0], 300, 250, g);
            drawImage(villagers[1], 500, 250, g);
            drawImage(villagers[2], 300, 300, g);
            drawImage(villagers[3], 500, 300, g);
            drawImage(villagers[4], 300, 350, g);
            drawImage(villagers[5], 500, 350, g);
            drawImage(villagers[6], 300, 400, g);
            drawImage(villagers[7], 500, 400, g);
            drawImage(villagers[8], 300, 450, g);
            drawImage(villagers[9], 500, 450, g);
            if(condition == 1){
                drawImage(villagers[10], 300, 500, g);
            } else if(condition == 2){
                drawImage(villagers[11], 500, 500, g);
            } else if(condition == 3){

            } else{
                drawImage(villagers[10], 300, 500, g);
                drawImage(villagers[11], 500, 500, g);
            }

            drawImage(BjarneSpin[0], 400, 300, g);
            drawImage(Djikstra[animationChange % 3], 400, DjikstraPosY, g);
        }
        if(dt >= 13 && dt < 26){
            drawImage(villagers[0], 300, 250, g);
            drawImage(villagers[1], 500, 250, g);
            drawImage(villagers[2], 300, 300, g);
            drawImage(villagers[3], 500, 300, g);
            drawImage(villagers[4], 300, 350, g);
            drawImage(villagers[5], 500, 350, g);
            drawImage(villagers[6], 300, 400, g);
            drawImage(villagers[7], 500, 400, g);
            drawImage(villagers[8], 300, 450, g);
            drawImage(villagers[9], 500, 450, g);
            if(condition == 1){
                drawImage(villagers[10], 300, 500, g);
            } else if(condition == 2){
                drawImage(villagers[11], 500, 500, g);
            } else if(condition == 3){

            } else{
                drawImage(villagers[10], 300, 500, g);
                drawImage(villagers[11], 500, 500, g);
            }

            drawImage(BjarneSpin[0], 400, 300, g);
            drawImage(Djikstra[1], 400, DjikstraPosY, g);
        }
        if(dt >= 13 && dt < 19){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Djikstra:", "Times New Roman", 20, g);
            drawText(110, 450, "Bjarne! You survived! That means he must be dead! HE DID IT!", "Times New Roman", 20, g);
            drawText(110, 475, "He freed our town from the wrath of Therox! Wait... where's Sevar?", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt >= 19 && dt < 25){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Bjarne:", "Times New Roman", 20, g);
            drawText(110, 450, "He didn't make it... he sacrificed himself casting the most powerful", "Times New Roman", 20, g);
            drawText(110, 475, "spell I've ever seen. It was an honorable death. A hero's death.", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt >= 26){
            drawImage(grave, 610, 145, g);
            drawImage(BjarneSpin[2], 610, 205, g);
        }
        if(dt >=25 && dt < 28) {
            if(!hit2){
                timer = 22;
                hit2 = !hit2;
            }
            if (timer > 22 && timer < 42) {
                drawImage(fadeArray[0], 0, 0, 800, 600, g);
            }
            if (timer > 22.1 && timer < 22.2) {
                drawImage(fadeArray[1], 0, 0, 800, 600, g);
            }
            if (timer > 22.2 && timer < 22.3) {
                drawImage(fadeArray[2], 0, 0, 800, 600, g);
            }
            if (timer > 22.3 && timer < 22.4) {
                drawImage(fadeArray[3], 0, 0, 800, 600, g);
            }
            if (timer > 22.4 && timer < 22.5) {
                drawImage(fadeArray[4], 0, 0, 800, 600, g);
            }
            if (timer > 22.5 && timer < 22.6) {
                drawImage(fadeArray[5], 0, 0, 800, 600, g);
            }
            if (timer > 22.6 && timer < 22.7) {
                drawImage(fadeArray[6], 0, 0, 800, 600, g);
            }
            if (timer > 22.7 && timer < 22.8) {
                drawImage(fadeArray[7], 0, 0, 800, 600, g);
            }
            if (timer > 22.8 && timer < 22.9) {
                drawImage(fadeArray[8], 0, 0, 800, 600, g);
            }
            if (timer > 22.9 && timer < 23) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
            }
            if (timer > 23 && timer < 24) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
                change = true;
            }
            if (timer > 24 && timer < 24.1) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
            }
            if (timer > 24.1 && timer < 24.2) {
                drawImage(fadeArray[8], 0, 0, 800, 600, g);
            }
            if (timer > 24.2 && timer < 24.3) {
                drawImage(fadeArray[7], 0, 0, 800, 600, g);
            }
            if (timer > 24.3 && timer < 24.4) {
                drawImage(fadeArray[6], 0, 0, 800, 600, g);
            }
            if (timer > 24.4 && timer < 24.5) {
                drawImage(fadeArray[5], 0, 0, 800, 600, g);
            }
            if (timer > 24.5 && timer < 24.6) {
                drawImage(fadeArray[4], 0, 0, 800, 600, g);
            }
            if (timer > 24.6 && timer < 24.7) {
                drawImage(fadeArray[3], 0, 0, 800, 600, g);
            }
            if (timer > 24.7 && timer < 24.8) {
                drawImage(fadeArray[2], 0, 0, 800, 600, g);
            }
            if (timer > 24.8 && timer < 24.9) {
                drawImage(fadeArray[1], 0, 0, 800, 600, g);
            }
            if (timer > 24.9 && timer < 25) {
                drawImage(fadeArray[0], 0, 0, 800, 600, g);
            }
        }
        if(dt >= 28 && dt < 38){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Bjarne:", "Times New Roman", 20, g);
            drawText(110, 450, "I miss you more and more everyday old friend. With Therox gone", "Times New Roman", 20, g);
            drawText(110, 475, "the town is safe with only a few straggling monsters left behind.", "Times New Roman", 20, g);
            drawText(110, 500, "I've been training to be a wizard too. Within that final battle ", "Times New Roman", 20, g);
            drawText(110, 525, "something entered my soul, whether it was your spirit or Therox's...", "Times New Roman", 20, g);
        }
        if(dt >= 37 && dt < 45){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Bjarne:", "Times New Roman", 20, g);
            drawText(110, 450, "I've only mastered a few basic spells for now but my thirst for ", "Times New Roman", 20, g);
            drawText(110, 475, "knowledge is strong. Who knows, maybe one day I will be as powerful", "Times New Roman", 20, g);
            drawText(110, 500, "you! Haha one day...", "Times New Roman", 20, g);
            drawText(110, 525, "", "Times New Roman", 20, g);
        }
        if(dt >= 45){
            changeColor(white, g);
            drawText(260, 450, "- Press <SPACE> to continue -",  "New Roman Times", 20, g);
        }
    }

    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            return 1;
        }
        return 0;
    }
}

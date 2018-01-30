import java.awt.*;
import java.awt.event.KeyEvent;

public class endCutScene extends extraFunctions{

    Image spriteSheet;
    Image spriteSheet2;
    Image spriteSheet3;
    Image spellSpriteSheet;
    Image bossBack;
    Image plainsBack;
    Image bolts[];
    Image lightening[];
    Image Bjarne[];
    Image BjarneSpin[];
    Image WizardSpin[];
    Image WizardGood[];
    Image WizardBad;
    Image fadeArray[];
    Image dialogueBackSheet;
    Image dialogueBack;
    Image smokeSheet;
    Image smokeArray[];
    Image fade;
    Image Dijkstra;
    Image Camrath;
    int animationChange;
    int runCount;
    boolean vanish;
    boolean change;
    double timer;
    private boolean startBattle;
    long currentTime;
    long initialTime;
    long elapsedTime;
    double interval;
    double dt;
    double extra;
    boolean hit;


    endCutScene(){
        hit = false;
        startBattle = false;
        timer = 0;
        fade = loadImage("fade.png");
        smokeSheet = loadImage("smoke.png");
        bossBack = loadImage("bossFight.png");
        plainsBack = loadImage("plains_E5.png");
        spriteSheet = loadImage("chara1.png");
        spriteSheet2 = loadImage("chara3.png");
        spriteSheet3 = loadImage("chara2.png");
        spellSpriteSheet = loadImage("spellBolt.png");

        Dijkstra = subImage(spriteSheet3, 520, 0,56,72);
        Camrath = subImage(spriteSheet2, 52, 288, 56, 72);

        vanish = false;
        change = false;
        runCount = 0;
        animationChange = 0;
        bolts = new Image[3];
        lightening = new Image[3];
        WizardSpin = new Image[4];
        BjarneSpin = new Image[4];
        Bjarne = new Image[3];
        WizardGood = new Image[3];
        fadeArray = new Image[10];
        smokeArray = new Image[35];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);

        for(int i =0; i < 3;i++){
            WizardSpin[i] = subImage(spriteSheet,52, 288 + (72*i),52,72);
            BjarneSpin[i] = subImage(spriteSheet,52, 72*i,52,72);
        }
        WizardSpin[3] = WizardSpin[2];
        WizardSpin[2] = subImage(spriteSheet,52, 504,52,72);
        BjarneSpin[3] = BjarneSpin[2];
        BjarneSpin[2] = subImage(spriteSheet,52, 216,52,72);
        WizardBad = subImage(spriteSheet3, 520, 288, 52, 72);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                smokeArray[(i*8)+j] = subImage(smokeSheet, j * 128, i * 128, 128, 128);
            }
        }
        smokeArray[32] = subImage(smokeSheet, 0, 512, 128,128);
        smokeArray[33] = subImage(smokeSheet, 128, 512, 128,128);
        smokeArray[34] = subImage(smokeSheet, 256, 512, 128,128);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                fadeArray[(i*5) + j] = subImage(fade, j*160, i*120, 140, 100);
            }
        }
        bolts[0] = subImage(spellSpriteSheet, 0, 0, 80, 112);
        bolts[1] = subImage(spellSpriteSheet, 100, 0, 80, 112);
        bolts[2] = subImage(spellSpriteSheet, 210, 0, 80, 112);
    }

    public int updateTimer(double dt){
        timer +=dt;
        if(startBattle){
            startBattle = false;
            return 11;
        }
        return 0;
    }


    public void drawCutScene(Graphics2D g) {
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
        if(!change) {
            drawImage(plainsBack, 0, 0, g);
            drawImage(Dijkstra, 400, 350, 50, 70, g);
            drawImage(Camrath, 500, 250, 50, 70, g);
        } else {
            drawImage(bossBack, 0, 0, g);
            drawImage(WizardBad, 400, 100, 50, 70, g);
        }

        if((dt >= 1) && dt < 2){
            drawImage(Dijkstra, 400, 350, 50, 70, g);
            drawImage(Camrath, 500, 250, 50, 70, g);

        }
        if(dt < 6) {
            drawImage(WizardSpin[getAnimationFrame(timer, 0.16, 4)], 300, 250, 50, 70, g);
            drawImage(BjarneSpin[getAnimationFrame(timer, 0.16, 4)], 400, 365, 50, 70, g);
            drawImage(smokeArray[getAnimationFrame(timer, 0.16, 34)], 260, 200, g);
            drawImage(smokeArray[getAnimationFrame(timer, 0.16, 34)], 360, 315, g);
        }
        if(dt >= 2 && dt < 5) {
            if (!hit) {
                timer = 2;
                hit = !hit;
            }
            if (timer > 2 && timer < 42) {
                drawImage(fadeArray[0], 0, 0, 800, 600, g);
            }
            if (timer > 2.1 && timer < 2.2) {
                drawImage(fadeArray[1], 0, 0, 800, 600, g);
            }
            if (timer > 2.2 && timer < 2.3) {
                drawImage(fadeArray[2], 0, 0, 800, 600, g);
            }
            if (timer > 2.3 && timer < 2.4) {
                drawImage(fadeArray[3], 0, 0, 800, 600, g);
            }
            if (timer > 2.4 && timer < 2.5) {
                drawImage(fadeArray[4], 0, 0, 800, 600, g);
            }
            if (timer > 2.5 && timer < 2.6) {
                drawImage(fadeArray[5], 0, 0, 800, 600, g);
            }
            if (timer > 2.6 && timer < 2.7) {
                drawImage(fadeArray[6], 0, 0, 800, 600, g);
            }
            if (timer > 2.7 && timer < 2.8) {
                drawImage(fadeArray[7], 0, 0, 800, 600, g);
            }
            if (timer > 2.8 && timer < 2.9) {
                drawImage(fadeArray[8], 0, 0, 800, 600, g);
            }
            if (timer > 2.9 && timer < 3) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
            }
            if (timer > 3 && timer < 4) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
                change = true;
            }
            if (timer > 4 && timer < 4.1) {
                drawImage(fadeArray[9], 0, 0, 800, 600, g);
            }
            if (timer > 4.1 && timer < 4.2) {
                drawImage(fadeArray[8], 0, 0, 800, 600, g);
            }
            if (timer > 4.2 && timer < 4.3) {
                drawImage(fadeArray[7], 0, 0, 800, 600, g);
            }
            if (timer > 4.3 && timer < 4.4) {
                drawImage(fadeArray[6], 0, 0, 800, 600, g);
            }
            if (timer > 4.4 && timer < 4.5) {
                drawImage(fadeArray[5], 0, 0, 800, 600, g);
            }
            if (timer > 4.5 && timer < 4.6) {
                drawImage(fadeArray[4], 0, 0, 800, 600, g);
            }
            if (timer > 4.6 && timer < 4.7) {
                drawImage(fadeArray[3], 0, 0, 800, 600, g);
            }
            if (timer > 4.7 && timer < 4.8) {
                drawImage(fadeArray[2], 0, 0, 800, 600, g);
            }
            if (timer > 4.8 && timer < 4.9) {
                drawImage(fadeArray[1], 0, 0, 800, 600, g);
            }
            if (timer > 4.9 && timer < 5) {
                drawImage(fadeArray[0], 0, 0, 800, 600, g);
            }
        }
        if(dt > 5 && dt < 19){
            //drawImage(WizardBad, 400, 100, 50, 70, g);
            drawImage(WizardSpin[2], 300, 250, 50, 70, g);
            drawImage(BjarneSpin[2], 400, 365, 50, 70, g);
        }
        if(dt >= 6 && dt < 11){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Therox: ", "Times New Roman", 20, g);
            drawText(110, 450, "WHAT!? How on earth- Nevermind that, you made a grave mistake ", "Times New Roman", 20, g);
            drawText(110, 475, "coming here!", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt >= 11 && dt < 17){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Sevar: ", "Times New Roman", 20, g);
            drawText(110, 450, "Therox! Your time is up! Bjarne, I've been saving up my energy for", "Times New Roman", 20, g);
            drawText(110, 475, "this one spell, I will finish Therox but likely won't make it through.", "Times New Roman", 20, g);
            drawText(110, 500, "Good luck friend.", "Times New Roman", 20, g);
        }
        if(dt >= 17 && dt < 19){
            //Insert fireball animation here
            drawImage(smokeArray[getAnimationFrame(timer, 0.16, 34)], 360, 50, g);
            drawImage(bolts[animationChange%3], 340,140, 70, 150,g);
        }
        if(dt >= 19){
            drawImage(WizardBad, 400, 100, 50, 70, g);
            drawImage(BjarneSpin[2], 400, 365, 50, 70, g);
        }
        if(dt >= 20 && dt < 25){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Bjarne: ", "Times New Roman", 20, g);
            drawText(110, 450, "SEVARRRRR NOOOOOO! What? Therox... you... you survived?", "Times New Roman", 20, g);
            drawText(110, 475, "", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt >= 25 && dt < 30){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Therox: ", "Times New Roman", 20, g);
            drawText(110, 450, "HA! Your little friend barely touched me, now prepare to meet your ", "Times New Roman", 20, g);
            drawText(110, 475, "end!", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt >= 30){
            changeColor(white, g);
            drawText(250, 450, "- Press <SPACE> to initiate battle -",  "New Roman Times", 20, g);
        }

    }

    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE ) {
            startBattle = true;
        }
        return 0;
    }
}

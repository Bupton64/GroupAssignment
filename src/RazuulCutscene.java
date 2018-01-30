import java.awt.*;
import java.awt.event.KeyEvent;

public class RazuulCutscene extends extraFunctions{

    double timer;
    int animationChange;
    int priestPosX;
    int priestPosY;
    Image background;
    Image backgroundAlternate;
    Image spritesheet;
    Image spritesheet2;
    Image dialogueBackSheet;
    Image dialogueBack;
    Image priest[];
    Image priestDown[];
    Image priestLeft[];
    Image priestAfter[];
    Image smokeSheet;
    Image smokeArray[];
    Image temp;
    Image spritesheet3;
    Image Bjarne;
    Image grave;
    long currentTime;
    long initialTime;
    long elapsedTime;
    double interval;
    double dt;
    double extra;


    RazuulCutscene(){
        priestPosX = 475;
        priestPosY = 200;
        timer = 0;
        animationChange = 0;
        grave = loadImage("grave.png");
        background = loadImage("priestFight.png");
        backgroundAlternate = loadImage("plains_F8.png");
        spritesheet = loadImage("chara2.png");
        spritesheet2 = loadImage("chara5.png");
        smokeSheet = loadImage("smoke.png");
        priest = new Image[4];
        priestAfter = new Image[4];
        priestDown = new Image[4];
        priestLeft = new Image[4];
        smokeArray = new Image[35];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);

        spritesheet3 = loadImage("chara1.png");
        Bjarne = subImage(spritesheet3, 52, 72, 56, 72);

        for(int i = 0; i < 3; i++){
            priestDown[i] = subImage(spritesheet2,312 + (i*52), 288,52,72);
            priestLeft[i] = subImage(spritesheet2,312 + (i*52), 360,52,72);
        }

        for(int i = 0; i < 4; i++) {
            priestAfter[i] = subImage(spritesheet2,364, 288 + (72*i),52,72);
            priest[i] = subImage(spritesheet,364, (72*i),52,72);
            for (int j = 0; j < 8; j++) {
                smokeArray[(i*8)+j] = subImage(smokeSheet, j * 128, i * 128, 128, 128);
            }
        }
        temp = priest[3];
        priest[3]= priest[2];
        priest[2]= temp;
        temp = priestAfter[3];
        priestAfter[3]= priestAfter[2];
        priestAfter[2]= temp;
        smokeArray[32] = subImage(smokeSheet, 0, 512, 128,128);
        smokeArray[33] = subImage(smokeSheet, 128, 512, 128,128);
        smokeArray[34] = subImage(smokeSheet, 256, 512, 128,128);

    }


    public void updateTimer(double dt){
        timer +=dt;
    }

    public void drawRazuulCutscene(Graphics2D g){
        if(animationChange == 0){
            initialTime = getTime();
        }
        interval = 1000.0/40;
        dt = interval / 1000.0;

        animationChange++;
        drawImage(background, 0, 0, g);
        currentTime = getTime();
        elapsedTime = currentTime - initialTime;
        if(interval > elapsedTime){
            extra = interval - elapsedTime;
            sleep(extra);
        } else if(elapsedTime > interval){
            dt = elapsedTime/1000;
        }
        if(dt <= 1){
            drawImage(priest[getAnimationFrame(timer, 0.04, 4)], 475, 200, g);
        } else if(dt > 1 && dt <= 2){
            drawImage(priestAfter[getAnimationFrame(timer, 0.16, 4)], 475, 200, g);
        }
        if(dt <= 2){
            drawImage(smokeArray[getAnimationFrame(timer, 0.16, 34)], 435, 150, g);
        }
        if(dt > 2 && dt <= 5){
            drawImage(priestAfter[0], 475, 200, g);
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Razuul:", "Times New Roman", 20, g);
            drawText(110, 450, "HAHAHA You thought you could defeat me!? Wrong you were little ", "Times New Roman", 20, g);
            drawText(110, 475, "man.", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt > 5 && priestPosY <305){
            priestPosY+=4;
            drawImage(priestDown[getAnimationFrame(timer, 0.16, 3)], priestPosX, priestPosY, g);
        }
        if(priestPosY >=305 && dt <= 11){
            priestPosX-=4;
            drawImage(priestLeft[getAnimationFrame(timer, 0.16, 3)], priestPosX, priestPosY, g);
        }
        if(dt > 11 && dt <= 17){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Julian:", "Times New Roman", 20, g);
            drawText(110, 450, "Bjarne you- you saved me! How can I ever repay you? But the", "Times New Roman", 20, g);
            drawText(110, 475, "priest... what was that thing!? He probably headed West to the", "Times New Roman", 20, g);
            drawText(110, 500, "church!", "Times New Roman", 20, g);
        }
        if(dt > 17){
            changeColor(white, g);
            drawText(260, 450, "- Press <SPACE> to continue -",  "New Roman Times", 20, g);
        }
    }
    public void drawRazuulCutscene2(Graphics2D g){
        if(animationChange == 0){
            initialTime = getTime();
        }
        interval = 1000.0/40;
        dt = interval / 1000.0;
        animationChange++;
        currentTime = getTime();
        elapsedTime = currentTime - initialTime;
        if(interval > elapsedTime){
            extra = interval - elapsedTime;
            sleep(extra);
        } else if(elapsedTime > interval){
            dt = elapsedTime/1000;
        }
        drawImage(backgroundAlternate, 0, 0, g);
        drawImage(Bjarne, 520, 210, g);
        drawImage(grave, 420, 200, g);
        if(dt <= 1){
            drawImage(priest[getAnimationFrame(timer, 0.16, 4)], 475, 200, g);
        } else if(dt > 1 && dt <= 2){
            drawImage(priestAfter[getAnimationFrame(timer, 0.16, 4)], 475, 200, g);
        }
        if(dt <= 2){
            drawImage(smokeArray[getAnimationFrame(timer, 0.16, 34)], 435, 150, g);
        }
        if(dt > 2 && dt <=5){
            drawImage(priestAfter[0], 475, 200, g);
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Razuul:", "Times New Roman", 20, g);
            drawText(110, 450, "HAHAHA You thought you could defeat me!? Wrong you were little ", "Times New Roman", 20, g);
            drawText(110, 475, "man.", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(dt > 5 && priestPosY <305){
            priestPosY+=5;
            drawImage(priestDown[getAnimationFrame(timer, 0.16, 3)], priestPosX, priestPosY, g);
        }
        if(priestPosY >=305 && dt <=11){
            priestPosX-=5;
            drawImage(priestLeft[getAnimationFrame(timer, 0.16, 3)], priestPosX, priestPosY, g);
        }
        if(dt > 11){
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

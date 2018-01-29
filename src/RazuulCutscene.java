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


    RazuulCutscene(){
        priestPosX = 475;
        priestPosY = 200;
        timer = 0;
        animationChange++;
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
        animationChange++;
        drawImage(background, 0, 0, g);

        if(timer > 0 && timer < 2){
            drawImage(priest[animationChange%4], 475, 200, g);
        } else if(timer > 2 && timer < 4){
            drawImage(priestAfter[animationChange%4], 475, 200, g);
        }
        if(timer > 0 && timer < 4){
            drawImage(smokeArray[animationChange%35], 425, 150, g);
        }
        if(timer > 4 && timer< 7){
            drawImage(priestAfter[0], 475, 200, g);
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Razuul:", "Times New Roman", 20, g);
            drawText(110, 450, "HAHAHA You thought you could defeat me!? Wrong you were little ", "Times New Roman", 20, g);
            drawText(110, 475, "man.", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(timer > 7 && priestPosY <305){
            priestPosY+=5;
            drawImage(priestDown[animationChange%3], priestPosX, priestPosY, g);
        }
        if(priestPosY >=305 && timer < 13){
            priestPosX-=5;
            drawImage(priestLeft[animationChange%3], priestPosX, priestPosY, g);
        }
        if(timer > 13 && timer < 19){
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Julian:", "Times New Roman", 20, g);
            drawText(110, 450, "Bjarne you- you saved me! How can I ever repay you? But the", "Times New Roman", 20, g);
            drawText(110, 475, "priest... what was that thing!? He probably headed West to the", "Times New Roman", 20, g);
            drawText(110, 500, "church!", "Times New Roman", 20, g);
        }
        if(timer > 19){
            changeColor(white, g);
            drawText(260, 450, "- Press <SPACE> to continue -",  "New Roman Times", 20, g);
        }
    }
    public void drawRazuulCutscene2(Graphics2D g){
        animationChange++;
        drawImage(backgroundAlternate, 0, 0, g);
        drawImage(Bjarne, 520, 210, g);
        if(timer > 0 && timer < 2){
            drawImage(priest[animationChange%4], 475, 200, g);
        } else if(timer > 2 && timer < 4){
            drawImage(priestAfter[animationChange%4], 475, 200, g);
        }
        if(timer > 0 && timer < 4){
            drawImage(smokeArray[animationChange%35], 425, 150, g);
        }
        if(timer > 4 && timer< 7){
            drawImage(priestAfter[0], 475, 200, g);
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Razuul:", "Times New Roman", 20, g);
            drawText(110, 450, "HAHAHA You thought you could defeat me!? Wrong you were little ", "Times New Roman", 20, g);
            drawText(110, 475, "man.", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
        if(timer > 7 && priestPosY <305){
            priestPosY+=5;
            drawImage(priestDown[animationChange%3], priestPosX, priestPosY, g);
        }
        if(priestPosY >=305 && timer < 13){
            priestPosX-=5;
            drawImage(priestLeft[animationChange%3], priestPosX, priestPosY, g);
        }
        if(timer > 13){
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

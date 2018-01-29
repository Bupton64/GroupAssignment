import java.awt.*;
import java.awt.event.KeyEvent;

public class RazuulCutscene extends extraFunctions{

    double timer;
    int animationChange;
    Image background;
    Image spritesheet;
    Image spritesheet2;
    Image dialogueBackSheet;
    Image dialogueBack;
    Image priest[];
    Image priestAfter[];
    Image smokeSheet;
    Image smokeArray[];
    Image temp;



    RazuulCutscene(){
        timer = 0;
        animationChange++;
        background = loadImage("priestFight.png");
        spritesheet = loadImage("chara2.png");
        spritesheet2 = loadImage("chara5.png");
        smokeSheet = loadImage("smoke.png");
        priest = new Image[4];
        priestAfter = new Image[4];
        smokeArray = new Image[35];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);



        for(int i = 0; i < 4; i++) {
            priestAfter[i] = subImage(spritesheet,364, 288 + (72*i),52,72);
            priest[i] = subImage(spritesheet2,364, (72*i),52,72);
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
        if(timer > 0 && timer < 4){
            drawImage(smokeArray[animationChange%35], 400, 250, g);
        }
        if(timer > 0 && timer < 2){
            drawImage(priest[animationChange%4], 450, 300, g);
        }
        if(timer > 2 && timer < 4){
            drawImage(priest[animationChange%4], 450, 300, g);
        }
    }

    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            return 1;
        }
        return 0;
    }
}

import java.awt.*;
import java.awt.event.KeyEvent;

public class endCutScene extends extraFunctions{

    Image spriteSheet;
    Image spriteSheet2;
    Image spriteSheet3;
    Image bossBack;
    Image plainsBack;
    Image Bjarne[];
    Image BjarneSpin[];
    Image WizardSpin[];
    Image WizardGood[];
    Image WizardBad[];
    Image fadeArray[];
    Image dialogueBackSheet;
    Image dialogueBack;
    Image smokeSheet;
    Image smokeArray[];
    Image fade;
    Image Dijkstra;
    Image Camrath;
    double timer;


    endCutScene(){
        timer = 0;
        fade = loadImage("fade.png");
        smokeSheet = loadImage("smoke.png");
        bossBack = loadImage("bossFight.png");
        plainsBack = loadImage("plains_E5.png");
        spriteSheet = loadImage("chara1.png");
        spriteSheet2 = loadImage("chara3.png");
        spriteSheet3 = loadImage("chara2.png");

        Dijkstra = subImage(spriteSheet3, 520, 0,56,72);
        Camrath = subImage(spriteSheet2, 52, 288, 56, 72);

        WizardSpin = new Image[4];
        BjarneSpin = new Image[4];
        Bjarne = new Image[3];
        WizardGood = new Image[3];
        WizardBad = new Image[3];
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
    }

    public void updateTimer(double dt){
        timer +=dt;
    }

    public void drawCutScene(Graphics2D g) {
        drawImage(plainsBack, 0, 0, g);
        drawImage(WizardSpin[0], 300, 250, 49, 72, g);
        drawImage(Dijkstra, 400, 300, 49, 72, g);
        drawImage(Camrath, 500, 250, 49, 72, g);
        drawImage(BjarneSpin[2], 400, 315, 49, 72,  g);
    }

    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            return 1;
        }
        return 0;
    }
}

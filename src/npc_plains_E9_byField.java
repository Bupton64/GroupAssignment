import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byField extends  NPC {

    npc_plains_E9_byField() {
        setName("Titus");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet, 52, 288, 56, 72);
        setMapPosX(100);
        setMapPosY(450);

        spriteDown = new Image[3];
        spriteUp = new Image[3];
        spriteRight = new Image[3];
        spriteLeft = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet, (52 * i), 288,52,72);
            spriteLeft[i] = subImage(spriteSheet,(52 * i), 360,52,72);
            spriteRight[i] = subImage(spriteSheet,(52 * i), 432,52,72);
            spriteUp[i] = subImage(spriteSheet,(52 * i), 504,52,72);
        }
    }

    @Override
    public void setUpCollision(Collision collisionDetector, Map map) {
        collisionDetector.addBoxCollision(((int) getMapPosX() / 10 - 2), ((int) getMapPosY() / 10 - 5), ((int) getWidth() / 10 - 2), ((int) getHeight() / 10 - 2), map.isFlicker());
    }

    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////

    @Override
    public void updateNpcMovement(double dt, Collision collisionDetector) {

    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null, false, true, "We've always had monsters nearby but it was never this bad... Sevar", "the Wizard protected us well, but now Therox has turned attention to ", "us... Well I just don't feel safe anymore.", "");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState currentState) {

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if (loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }








}

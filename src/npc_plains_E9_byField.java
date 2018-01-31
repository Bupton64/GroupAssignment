import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byField extends  NPC {

    npc_plains_E9_byField() {
        setName("Titus");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet, 52, 288, 56, 72);
        setMapPosX(100);
        setMapPosY(450);

        turnArray = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            turnArray[i] = subImage(spriteSheet, 52, 288 + (i*72), 56, 72);
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
        turn();
    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;
    Dialogue listTwo;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null, false, true, "We've always had monsters nearby but it was never this bad... Sevar", "the Wizard protected us well, but now Therox has turned his attention to ", "us... Well I just don't feel safe anymore.", "");
        listOne = d1;

        Dialogue d2 = new Dialogue(null, false, true, "Only the strong monsters remain but they're fading fast! Soon enough", "we'll be safer than ever!", "", "");
        listTwo = d2;
    }

    public void updateDialogue( int questStage) {
        if(questStage == 33){
            currentDialogue = listTwo;
        } else {
            currentDialogue = listOne;
        }
    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if (loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }








}

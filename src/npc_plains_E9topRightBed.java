import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9topRightBed extends  NPC {

    npc_plains_E9topRightBed(int posX, int posY) {
        setName("Bed");
        spriteSheet = loadImage("NPCwithoutSprite.png");
        sprite = subImage(spriteSheet, 0, 0, 1, 1);
        setMapPosX(posX);
        setMapPosY(posY);


        initDialogue();
        loadDialogue = true;
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
        Dialogue d1 = new Dialogue(null, true, true, "Would you like to sleep?", "", "", "");
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

    public int updateConvo(){
        switch (this.questStage){
            case 94:
                questStage = 0;
                return 94;
            default:
                return 0;
        }

    }

    public boolean keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    questStage = 94;
                }
            }
        }
        return super.keyPressed(e);


    }




}

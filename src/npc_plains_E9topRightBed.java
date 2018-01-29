import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9topRightBed extends  NPC {

    npc_plains_E9topRightBed() {
        setName("Bed");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet, 0, 0, 1, 1);
        setMapPosX(520);
        setMapPosY(175);


        initDialogue();
        loadDialogue = true;
    }


    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 1),((int)getMapPosY()/10 - 4),((int)getWidth()/10-4),((int)getHeight()/10 - 3),map.isFlicker());
    }

    @Override
    public void undoCollision(Collision collisionDetector){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 1),((int)getMapPosY()/10 - 4),((int)getWidth()/10-4),((int)getHeight()/10 - 3),false);
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

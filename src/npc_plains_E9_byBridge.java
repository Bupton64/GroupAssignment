import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byBridge extends  NPC {



    npc_plains_E9_byBridge(){
        setName("Sally");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,364,144,56,72);
        setMapPosX(475);
        setMapPosY(200);

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){

    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////


    Dialogue listOne;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,true,true,"You must be Bjarne right? I'm so sorry to hear what happened to your","town. Hopefully the Wizard in the North will be able to help you!","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }



    public int updateConvo(){
        if(summonMonster){
            return 99;

        }
        return 0;
    }

    //test code
    boolean summonMonster =false;


    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    summonMonster = true;
                }
            }
        }

        return super.keyPressed(e);


    }


}

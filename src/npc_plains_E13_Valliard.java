import java.awt.*;
import java.awt.event.*;

public class npc_plains_E13_Valliard extends NPC{


    npc_plains_E13_Valliard() {
        setName("Valliard");
        spriteSheet = loadImage("chara4.png");
        sprite = subImage(spriteSheet,520,504,56,72);
        setMapPosX(400);
        setMapPosY(250);

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void setUpCollision(Collision collisionDetector, Map map) {
        collisionDetector.addBoxCollision(((int) getMapPosX() / 10 - 2), ((int) getMapPosY() / 10 - 4), ((int) getWidth() / 10 - 2), ((int) getHeight() / 10 - 2), map.isFlicker());
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
        Dialogue d3 = new Dialogue(null, true, true, "We have seen your defiance, and it can continue no longer!", "Prepare yourself!", "", "" );
        Dialogue d2 = new Dialogue(d3, false, false, "I am Valliard! Lieutenant of the Flame Guard! My careful study of ", "war and magic will make you cower before me!", "", "" );
        Dialogue d1 = new Dialogue(d2, false, false, "Hah! You're too late! In five minutes all of Therox's armies will pour", "into your forest, the power of the books shall be ours! ", "", "");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState currentState) {

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState currentState, String questName, int questStage) {

        if (loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName, currentState, questName, questStage);
    }

    public int updateConvo() {
        if (summonMonster) {
            return 99;

        }
        return 0;
    }

    //test code
    boolean summonMonster = false;


    public boolean keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    summonMonster = true;
                }
            }
        }

        return super.keyPressed(e);


    }






}

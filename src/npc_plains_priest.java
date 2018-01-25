import java.awt.*;
import java.awt.event.*;


public class npc_plains_priest extends  NPC {



    npc_plains_priest(int posX, int posY){
        setName("Priest");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,0,56,72);
        setMapPosX(posX);
        setMapPosY(posY);

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

    Dialogue listTwo;

    Dialogue listThree;

    public void initDialogue() {

        Dialogue d1 = new Dialogue(null,false,true,"Hello, little man, you seem weak.... ","I would consider changing your Faith before the end comes","","");
        listOne = d1;

        Dialogue d4 = new Dialogue(null,true,true,"Or will you try to stop me? hahaha","","","");
        Dialogue d3 = new Dialogue(d4,false,false, "The dark lord is near, you have lost,","And now your friend Julien shall die.","","");
        Dialogue d2 = new Dialogue(d3,false,false, "Hello Again little man. ","I see you found my Book, well no problem the time has come for action","","");
        listTwo = d2;


        Dialogue d5 = new Dialogue(null,true,true,"round 2 habibs?","","","");
        listThree = d5;

    }

    public void updateDialogue(int questStage){
        if(questStage < 14) {
            currentDialogue = listOne;
        }
        if(questStage == 14){
            currentDialogue = listTwo;
        }
        if(questStage == 18){
            currentDialogue = listThree;
        }
    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }

        super.drawConvo(g, playerName,currentState, questName,questStage);
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

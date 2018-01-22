import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_StoreLink extends  NPC {

    npc_plains_F9_StoreLink(){
        setName("Link");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setMapPosX(400);
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

    Dialogue listTwo;


    public void initDialogue() {


        Dialogue d1 = new Dialogue(null,true,true,"Hey Thanks For Helping Camrath and I.","Here take this sword as a token of appreciation! And remember  ","you are always welcome to come browse my store.","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,true,true,"Hey Bjarne good to see you again! Care to browse my goods?","","","");
        listTwo = d2;
    }


    public void updateDialogue(int currentStage){
        if(currentStage == 4) {
            currentDialogue = listOne;
        }else{
            currentDialogue = listTwo;
        }

    }

    public int updateConvo(){
        switch (this.questStage){
            case 5:
                currentDialogue = listTwo;
                return 5;

            default:
                return 0;

        }

    }


    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }



    //////////////////////////////
    ///
    ///    KeyBinds
    ///
    //////////////////////////////



    public boolean keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 5:
                            questStage = 5;
                            break;

                    }
                }
            }
        }

        return super.keyReleased(e);


    }




}

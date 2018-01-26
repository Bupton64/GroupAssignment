import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byBridge extends  NPC {



    npc_plains_E9_byBridge(int posX, int posY){
        setName("Sally");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,364,144,56,72);
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
    Dialogue listFour;
    Dialogue listFive;

    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,true,true,"You must be Bjarne right? I'm so sorry to hear what happened to your","town. Hopefully the Wizard in the North will be able to help you!","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"Have you gone to see the wizard yet?","","","");
        listTwo = d2;

        Dialogue d3 = new Dialogue(null,true,true,"huh.. What happened? Why am I in the church?","weird... Race you back to Town Bjarnie? tehe.","","");
        listThree = d3;

        Dialogue d4 = new Dialogue(null,false,true,"Just give me a second to prepare. You can have a head start!","You'll need it loser ","","");
        listFour= d4;

        Dialogue d5 = new Dialogue(null, false, true,"Today seems like another great day!, apart from the whole","end of the world thing!","","");
        listFive = d5;
    }



    public int updateConvo(){
        switch (this.questStage){
            case 1:
                currentDialogue = listTwo;
                return 1;
            case 20:
                currentDialogue = listFour;
                return 20;
            default:
                return 0;

        }

    }


    public void updateDialogue(int currentStage,String questName){

        if(currentStage == 0) {
            currentDialogue = listOne;
        }else if(currentStage == 19){
            currentDialogue = listThree;
        }else if(currentStage == 20){
            currentDialogue = listFour;
        } else if (currentStage <19) {
            currentDialogue = listTwo;
        }else if(currentStage > 20){
            currentDialogue = listFive;
        }
    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(questStage, questName);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }






    public boolean keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 0:
                            questStage = 1;
                            break;
                        case 19:
                            questStage = 20;
                            break;

                    }
                }
            }
        }

        return super.keyPressed(e);


    }


}

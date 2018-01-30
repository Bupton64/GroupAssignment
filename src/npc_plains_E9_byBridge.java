import java.awt.*;
import java.awt.event.*;


public class npc_plains_E9_byBridge extends  NPC {



    npc_plains_E9_byBridge(int posX, int posY){
        setName("Sally");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,364,144,56,72);
        setMapPosX(posX);
        setMapPosY(posY);

        turnArray = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            turnArray[i] = subImage(spriteSheet,364, (i * 72),56,72);
        }
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
        if(this.questStage < 18 || this.questStage > 22){
            turn();
        }
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

        Dialogue d3 = new Dialogue(null,false,true,"Huh... What happened? Why am I in the church? Weird... Race ","you back to town Bjarnie? Tehe.","","");
        listThree = d3;

        Dialogue d4 = new Dialogue(null,false,true,"Just give me a second to prepare. You can have a head start!","You'll need it loser!","","");
        listFour= d4;

        Dialogue d5 = new Dialogue(null, false, true,"Well hello again Bjarne!Thanks again for the whole saving","my life thing hehe. Maybe after Therox is gone we could go for an ale?","","");
        listFive = d5;
    }



    public int updateConvo(){
        switch (this.questStage){
            case 1:
                currentDialogue = listTwo;
                return 1;
            case 22:
                currentDialogue = listFour;
                return 22;
            default:
                return 0;

        }

    }


    public void updateDialogue(int currentStage,String questName){

        if(currentStage == 0) {
            currentDialogue = listOne;
        }else if(currentStage == 21){
            currentDialogue = listThree;
        }else if(currentStage == 22){
            currentDialogue = listFour;
        } else if (currentStage < 21) {
            currentDialogue = listTwo;
        }else if(currentStage > 22){
            currentDialogue = listFive;
        }
    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage, questName);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }






    public boolean keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 0:
                            questStage = 1;
                            break;

                    }
                }
                if(questStage == 21){
                    questStage = 22;
                }
            }
        }

        return super.keyPressed(e);


    }


}

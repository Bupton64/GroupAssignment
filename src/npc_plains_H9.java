import java.awt.*;
import java.awt.event.*;

//BLACKSMITH
public class npc_plains_H9 extends  NPC {

    private int gold;

    npc_plains_H9(int gold){
        this.gold = gold;
        setName("Camrath");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(500);
        setMapPosY(250);

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

    Dialogue listSix;

    Dialogue listSeven;

    Dialogue listEight;

    Dialogue listNine;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Leave me be. I am busy....","","","");
        listOne = d1;


        Dialogue d2 = new Dialogue(null,true,true,"Bjarne! I've been expecting you ever since I heard you had arrived.","Let me guess, you're looking for a weapon? Unfortunately I'm lacking","materials. Could you give me 500GP so that I purchase the resources","needed?");
        listTwo = d2;

        Dialogue d3 = new Dialogue(null,false,true,"Thank you helping me out! Please go and find Link in the town.","I have sent her to the town Store to handle merchandise.","She will help you with getting a sword","");
        listThree = d3;

        Dialogue d4 = new Dialogue(null,false,true,"Hey Bjarne! Thanks again for helping me. I hope Link has been","able to help you with your quest.","","");
        listFour = d4;

        Dialogue d5 = new Dialogue(null,true,true,"Good to see you again Bjarne! Ohh whats this an envelope?","What! this is from my old friend the King, where did you get this?","Come inside my house , we cant talk about this out here!","");
        listFive = d5;

        Dialogue d6 = new Dialogue(null,false,true,"I'll Meet you inside","","","");
        listSix = d6;

        Dialogue d8 = new Dialogue(null,true,true,"Look... it doesn't matter. Go tell Sevar I will start preparations.","","","");
        Dialogue d7 = new Dialogue(d8,false,false,"Bjarne, Do you understand what you brought me?","This envelope has a message from the king telling me to gather the","materials for a location spell, You're not planning on going after Therox","are you? And where did you get this?");
        listSeven = d7;

        Dialogue d9 = new Dialogue(null,false,true,"Make haste Bjarne, Time is of the essence.","","","");
        listEight = d9;

    }

    public void updateDialogue(int questStage){

        if(questStage < 6){
            currentDialogue = listOne;
        }else if(questStage ==6){
            currentDialogue = listTwo;
        }else if(questStage == 7){
            currentDialogue = listThree;
        }else if(questStage < 23){
            currentDialogue = listFour;
        }else if (questStage == 23){
            currentDialogue = listFive;
        }else if(questStage == 24){
            currentDialogue = listSeven;
        }

    }

    public int updateConvo(){
        switch (this.questStage){
            case 6:
                currentDialogue = listThree;
                return 6;
            case 40:
                currentDialogue = listSix;
                return 24;
            case 25:
                currentDialogue = listEight;
                return 25;


            default:
                return 0;

        }

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName,int questStage){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
        if(questName == "The Road To Riches") {
            if(currentState == Quest.questState.inQuest){
                if(currentDialogue != listThree){
                    loadDialogue = true;
                }
            }
        }

    }



    //////////////////////////////
    ///
    ///    KeyBinds
    ///
    //////////////////////////////



    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375 ) {
                    switch (questStage) {
                        case 5:
                            if(gold >= 500) {
                                questStage = 6;
                            }
                            break;
                        case 23:
                            questStage = 40;
                            break;
                        case 24:
                            questStage = 25;
                            break;

                    }
                }
            }
        }

        return super.keyPressed(e);


    }








}

import java.awt.*;
import java.awt.event.*;

//BLACKSMITH
public class npc_plains_H9 extends  NPC {

    private int gold;

    npc_plains_H9(int gold,int posX, int posY){
        this.gold = gold;
        setName("Camrath");
        spriteSheet = loadImage("Image/chara3.png");
        sprite = subImage(spriteSheet,52,288,56,72);
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

    Dialogue listSix;

    Dialogue listSeven;

    Dialogue listEight;

    Dialogue listNine;

    Dialogue listTen;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Leave me be. I am busy.","","","");
        listOne = d1;

        Dialogue d3 = new Dialogue(null,false,true,"Thank you helping me out! Please go and find Link in the town.","I have sent her to the town Store to handle merchandise.","She will help you with getting a sword.","");
        listThree = d3;

        Dialogue d02 = new Dialogue(d3,true,false,"Could you spare 500GP so that I can purchase the resources needed?","","","");
        Dialogue d2 = new Dialogue(d02,false,false,"Hey there, I just finished clearing all the monsters out of this area.","I've been expecting you ever since I heard you had arrived. Let me" ,"guess, you're looking for a weapon? Unfortunately I'm lacking materials.","");
        listTwo = d2;



        Dialogue d4 = new Dialogue(null,false,true,"Hey Bjarne! Thanks again for helping me. I hope Link has been","able to help you with your quest.","","");
        listFour = d4;

        Dialogue d5 = new Dialogue(null,true,true,"Good to see you again Bjarne! Oh whats this? An envelope?","What! This is from my old friend the King, where did you get this?","Come inside my house , we can't talk about this out here!","");
        listFive = d5;

        Dialogue d6 = new Dialogue(null,false,true,"I'll meet you inside","","","");
        listSix = d6;

        Dialogue d8 = new Dialogue(null,true,true,"Look... it doesn't matter. Go tell Sevar I will start preparations.","","","");
        Dialogue d7 = new Dialogue(d8,false,false,"Bjarne, do you understand what you brought me?","This envelope has a message from the King telling me to gather the","materials for a location spell. You're not planning on going after Therox","are you? Where did you even get this!?");
        listSeven = d7;

        Dialogue d9 = new Dialogue(null,false,true,"Make haste Bjarne! Time is of the essence.","","","");
        listEight = d9;

        Dialogue d10 = new Dialogue(null,false,true,"Bjarne, good to see you old friend! The time has come to take the","fight to Therox! Talk to Dijkstra when you're ready!","","");
        listNine = d10;

        Dialogue d11 = new Dialogue(null,false,true,"Bjarne, welcome back to town! Thanks again for saving us!","","","");
        listTen = d11;

    }

    public void updateDialogue(int questStage){

        if(questStage < 5){
            currentDialogue = listOne;
        }else if(questStage == 5){
            currentDialogue = listTwo;
        }else if(questStage == 6){
            currentDialogue = listThree;
        }else if(questStage < 26){
            currentDialogue = listFour;
        }else if (questStage == 26){
            currentDialogue = listFive;
        }else if(questStage == 27){
            currentDialogue = listSeven;
        }else if(questStage == 30) {
            currentDialogue = listNine;
        } else if(questStage == 33){
            currentDialogue = listTen;
        }
    }

    public int updateConvo(){
        switch (this.questStage){
            case 6:
                currentDialogue = listThree;
                return 6;
            case 40:
                currentDialogue = listSix;
                return 27;
            case 28:
                currentDialogue = listEight;
                return 28;



            default:
                return 0;

        }

    }

    private boolean enoughGold = true;

    public void drawConvo(Graphics2D g,Quest.questState  currentState, String questName,int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
        if(questName == "The Road To Riches") {
            if(currentState == Quest.questState.inQuest){
                if(currentDialogue != listThree){
                    loadDialogue = true;
                }
            }
        }
        if(!enoughGold){
            changeColor(red,g);
            drawText(230,500,"Not enough gold","Felix Titling",20,g);
        }

    }



    //////////////////////////////
    ///
    ///    KeyBinds
    ///
    //////////////////////////////



    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.hasOptions && questStage == 5){
                if (currentDialogue.getOptionPosY() == 375 ) {
                    if (gold >= 500) {
                        questStage = 6;

                    } else {
                        enoughGold = false;
                        return true;
                    }
                }else{
                    return false;
                }
            }

            if(currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375 ) {
                    switch (questStage) {

                        case 26:
                            questStage = 40;
                            break;
                        case 27:
                            questStage = 28;
                            break;

                    }
                }else{
                    enoughGold =true;
                }
            }
        }

        return super.keyPressed(e);


    }








}

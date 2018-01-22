import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class npc_wizard extends  NPC {

    boolean questAccepted;

//    int questStage;


    npc_wizard(){
        setName("Sevar");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(400);
        setMapPosY(250);
        questAccepted = false;
        initDialogue();
        loadDialogue = true;


    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    //////////////////////////////
    ///
    ///    Movement
    ///
    /////////////////////////////////

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){
    }



    //////////////////////////////
    ///
    ///    Convo
    ///
    /////////////////////////////////
    Dialogue listZero;
    Dialogue listOne;
    Dialogue listTwo;
    Dialogue listThree;

    Dialogue listFour;
    Dialogue listFive;

    Dialogue listSix;



    public void initDialogue(){
        Dialogue d0 = new Dialogue(null,false,true,"Who are you? Come back later im busy","","","");
        listZero = d0;

        Dialogue d4 = new Dialogue(null,true,true,"Kill 5 Goblins in front of Sevars' estate.","","","");
        Dialogue d3 = new Dialogue(d4,false,false,"His minions have made their way right to my doorstep it seems, and I","can hardly work on devising a way to beat Therox with his lackeys nipping","at my heels, If you could take up guard duty here in front of my estate,","I could begin to get some work done.");
        Dialogue d2 = new Dialogue(d3,false,false,"Knowing Therox was coming for my collection of spellbooks, I cast a","spell to create this forest. It was an old spell, one I had never cast" ,"before... I   pushed too much power into it... and... well... it grew","too large. Now the town lies right between Therox and I.");
        Dialogue d1 = new Dialogue(d2,false,false,"Ahhhh, who are you? I don't recognise you but you don't seem the sort to","be working for Therox, that foul cretin! The town is in danger and it's","all my fault! ","");
        listOne = d1;



        Dialogue d5 = new Dialogue(null,false,true,"You still haven't cleared the area","","","");
        listTwo = d5;

        Dialogue d7 = new Dialogue(null,true,true," My friend Camrath should be able to help you with that."," Visit her in the East and buy yourself a new sword, and then return to me","","");
        Dialogue d6 = new Dialogue(d7,false,false,"Fantastic work! Looks like you've learnt a few new abilities as well! If","you hold any hope of one day defeating Therox, then you're going to need","to upgrade your equipment.","");
        listThree = d6;

        Dialogue d8 = new Dialogue(null,false,true,"Have you spoken to Camrath yet? you'll find him in the East","","","");
        listFour = d8;

        Dialogue d10 = new Dialogue(null,true,true,"Can you go retreive my 7 Orbs from the south?","","","");
        Dialogue d9 = new Dialogue(d10,false,false,"That's quite the sword! You must use it wisely and well. Train with it, ","get to know it and let it know you. There is something else you can do.","Therox's creatures have managed to steal 7 of my Magical orbs. I need you","to go and retreive the orbs, I saw them running to the south.");
        listFive = d9;

        Dialogue d11 = new Dialogue(null,false,true,"I saw the creatures run south of town, Best of luck Bjarne!","","","");
        listSix = d11;

    }

    public int updateConvo(){
        switch (this.questStage){
            case 2:
                currentDialogue = listTwo;
                return 2;
            case 3:
                currentDialogue = listFour;
                return 3;
            case 6:
                currentDialogue = listSix;
                return 6;
            default:
                return 0;

        }

    }

    public void updateDialogue(Quest.questState  currentState,String questName){
        if(questName == "empty"){
            currentDialogue = listZero;
        } else if(questName == "A Wizards Problem") {
            if (currentState == Quest.questState.preQuest) {
                currentDialogue = listOne;
            }
            if (currentState == Quest.questState.inQuest) {
                currentDialogue = listTwo;
            }
            if (currentState == Quest.questState.completedQuest) {
                currentDialogue = listThree;
            }
        }else if(questName == "The Road To Riches"){
            if (currentState == Quest.questState.preQuest) {
                currentDialogue = listThree;
            }
            if (currentState == Quest.questState.inQuest) {
                currentDialogue = listFour;
            }
            if (currentState == Quest.questState.completedQuest) {
                currentDialogue = listFive;
            }
        }
    }







    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){
//        this.questStage = questStage;

        if(loadDialogue) {
            updateDialogue(currentState,questName);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);


        if(questName == "A Wizards Problem") {

            if (currentState == Quest.questState.completedQuest) {
                this.questStage = 3;
                if(currentDialogue != listThree){
                    loadDialogue = true;
                }


            }
        } else if(questName == "The Road To Riches") {
            if (currentState == Quest.questState.completedQuest) {
                this.questStage = 6;
            }
        }

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
                        case 1:
                            questStage = 2;
                            break;
                        case 3:
                            questStage = 3;
                            break;
                    }
                }
            }
        }

        return super.keyReleased(e);


    }





}


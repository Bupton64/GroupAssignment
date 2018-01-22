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
    Dialogue listOne;
    Dialogue listTwo;
    Dialogue listThree;

    Dialogue listFour;
    Dialogue listFive;



    public void initDialogue(){
        Dialogue d4 = new Dialogue(null,true,true,"Kill 5 Goblins in front of Sevars' estate.","","","");
        Dialogue d3 = new Dialogue(d4,false,false,"His minions have made their way right to my doorstep it seems, and I","can hardly work on devising a way to beat Therox with his lackeys nipping","at my heels, If you could take up guard duty here in front of my estate,","I could begin to get some work done.");
        Dialogue d2 = new Dialogue(d3,false,false,"Knowing Therox was coming for my collection of spellbooks, I cast a","spell to create this forest. It was an old spell, one I had never cast" ,"before... I   pushed too much power into it... and... well... it grew","too large. Now the town lies right between Therox and I.");
        Dialogue d1 = new Dialogue(d2,false,false,"Ahhhh, who are you? I don't recognise you but you don't seem the sort to","be working for Therox, that foul cretin! The town is in danger and it's","all my fault! ","");
        listOne = d1;



        Dialogue d5 = new Dialogue(null,false,true,"You still haven't cleared the area","","","");
        listTwo = d5;

        Dialogue d6 = new Dialogue(null,true,true,"Fantastic work! Looks like you've learnt a few new abilities as well! If","you hold any hope of one day defeating Therox, then you're going to need","to upgrade your equipment. My friend Camrath will be able to help","you with that. Visit her in the East and buy yourself a new sword.");
        listThree = d6;

        Dialogue d7 = new Dialogue(null,false,true,"Have you spoken to Camrath yet? you'll find him in the East","","","");
        listFour = d7;

        Dialogue d8 = new Dialogue(null,true,false,"That's quite the sword! You must use it wisely and well. Train with it, ","get to know it and let it know you. There is something else you can do","however... COMPLETE STORY HERE","");
        listFive = d8;

    }

    public int updateConvo(){
        switch (this.questStage){
            case 1:
                currentDialogue = listTwo;
                return 1;
            case 3:
                currentDialogue = listFour;
                return 3;
            default:
                return 0;

        }

    }

    public void updateDialogue(Quest.questState  currentState,String questName){
        if(questName == "A Wizards Problem") {
            if (currentState == Quest.questState.preQuest) {
                currentDialogue = listOne;
            }
            if (currentState == Quest.questState.inQuest) {
                currentDialogue = listTwo;
            }
            if (currentState == Quest.questState.completedQuest) {
                currentDialogue = listThree;
            }
        }else{

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
            if (currentState == Quest.questState.preQuest) {
                this.questStage = 0;
            }
            if (currentState == Quest.questState.completedQuest) {
                this.questStage = 2;
                if(currentDialogue != listThree){
                    loadDialogue = true;
                }


            }
        } else if(questName == "The Road To Riches") {

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
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 0:
                            questStage = 1;
                            break;
                        case 2:
                            questStage = 3;
                            break;
                    }
                }
            }
        }

        return super.keyPressed(e);


    }



}


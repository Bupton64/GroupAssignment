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

    Dialogue listSeven;

    Dialogue listEight;



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

        Dialogue d8 = new Dialogue(null,false,true,"Have you spoken to Camrath yet? you'll find her in the East","","","");
        listFour = d8;

        Dialogue d10 = new Dialogue(null,true,true,"Can you go retreive my 7 Orbs from the south?","","","");
        Dialogue d9 = new Dialogue(d10,false,false,"That's quite the sword! You must use it wisely and well. Train with it, ","get to know it and let it know you. There is something else you can do.","Therox's creatures have managed to steal 7 of my Magical orbs. I need you","to go and retreive the orbs, I saw them running to the south.");
        listFive = d9;

        Dialogue d11 = new Dialogue(null,false,true,"I saw the creatures run south of town, Best of luck Bjarne!","","","");
        listSix = d11;

        Dialogue d14 = new Dialogue(null,true,true,"Can you go and look around town for some clues","Check the houses. I have a bad feeling about this!","","");
        Dialogue d13 = new Dialogue(d14,false,false,"Oh No....","I can sense dark energy in town, there must be something hiding.","","");
        Dialogue d12 = new Dialogue(d13,false,false,"Oh you have them! Hope that wasn't to much trouble.","Alright now lets see how they are getting inside.","","");
        listSeven = d12;

        Dialogue d15 = new Dialogue(null,false,true,"How goes your search? I think the houses in town","might have some clues.","","");
        listEight = d15;

    }

    public int updateConvo(){
        switch (this.questStage){
            case 2:
                currentDialogue = listTwo;
                return 2;
            case 3:
                return 3;
            case 4:
                currentDialogue = listFour;
                return 4;
            case 10:
                currentDialogue = listSix;
                return 10;
            case 12:
                return 12;
            default:
                return 0;

        }

    }

    public void updateDialogue(int currentStage,String questName){
        if(questStage == 0) {
            currentDialogue = listZero;
        }else if (questStage == 1) {
            currentDialogue = listOne;
        }else if (questStage == 2) {
            currentDialogue = listTwo;
        }else if (questStage == 3) {
            currentDialogue = listThree;
        }else if (questStage == 5) {
            currentDialogue = listFour;
        }else if (questStage == 9){
            currentDialogue = listFive;
        }else if (questStage == 10) {
            currentDialogue = listSix;
        }else if(questStage == 11){
            currentDialogue = listSeven;
        }else if(questStage == 12){
            currentDialogue = listEight;
        }
    }







    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){
        this.questStage = questStage;

        if(loadDialogue) {
            updateDialogue(questStage,questName);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);


        if(questName == "A Wizards Problem") {

            if (currentState == Quest.questState.completedQuest) {
                if(questStage == 2) {
                    this.questStage = 3;
                    currentDialogue = listThree;
                }


            }
        } else if(questName == "The Road To Riches") {
            if (currentState == Quest.questState.preQuest) {

            }
            if (currentState == Quest.questState.completedQuest) {

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
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 1:
                            questStage = 2;
                            break;
                        case 3:
                            questStage = 4;
                            break;
                        case 9:
                            questStage = 10;
                            break;
                        case 11:
                            questStage = 12;
                            break;
                    }
                }
            }


        }

        return super.keyPressed(e);


    }





}


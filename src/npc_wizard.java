import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class npc_wizard extends  NPC {

    boolean questAccepted;

//    int questStage;


    npc_wizard(int posX, int posY){
        setName("Sevar");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(posX);
        setMapPosY(posY);
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
    Dialogue listNine;
    Dialogue listTen;
    Dialogue listEleven;
    Dialogue listTwelve;
    Dialogue listThirteen;
    Dialogue listFourteen;


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

        Dialogue d17 = new Dialogue(null,true,true,"Can you go confront the priest in Town?","","","");
        Dialogue d16 = new Dialogue(d17,false,false,"Hmmmm............ It appears this book belongs to the priest.","I fear we have a spy in our clutches Young Bjarne. You need to go"," confront him. I saw him in town earlier, After you confront him,"," find me I'll be in town, This situation seems to be dire!");
        listNine = d16;


        Dialogue d20 = new Dialogue(null,true,true,"go find a symbol","","","");
        Dialogue d19 = new Dialogue(d20,false,false,"im a wizzy, kek","","","");
        Dialogue d18 = new Dialogue(d19,false,false,"hi","","","");
        listTen = d18;

        Dialogue d21 = new Dialogue(null,false,true,"I think I remember Seeing the Holy symbol east of my House.","","","");
        listEleven = d21;

        Dialogue d23 = new Dialogue(null,true,true,"Can you go west , And bring Sally back!","","","");
        Dialogue d22 = new Dialogue(d23,false,false,"Well Done getting the Holy Symbol.","I've Tracked the Demon down to his Church in the west.","Be weary he will not go down easy, Make sure you are Prepared.","");
        listTwelve = d22;

        Dialogue d24 = new Dialogue(null,false,true,"The church is in the west, Goodluck my friend.","","","");
        listThirteen = d24;
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
            case 14:
                return 14;
            case 16:
                currentDialogue = listEleven;
                return 16;
            case 18:
                currentDialogue = listThirteen;
                return 18;
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
        }else if(questStage == 13){
            currentDialogue = listNine;
        }else if (questStage == 15){
            currentDialogue = listTen;
        }else if(questStage == 16){
            currentDialogue = listEleven;
        }else if(questStage == 17){
            currentDialogue = listTwelve;
        }else if(questStage == 18){
            currentDialogue = listThirteen;
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
                        case 13:
                            questStage = 14;
                            break;
                        case 15:
                            questStage = 16;
                            break;
                        case 17:
                            questStage = 18;
                    }
                }
            }


        }

        return super.keyPressed(e);


    }





}


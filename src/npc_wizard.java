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
    Dialogue listNineHalf;
    Dialogue listTen;
    Dialogue listEleven;
    Dialogue listTwelve;
    Dialogue listThirteen;
    Dialogue listFourteen;
    Dialogue listFifteen;
    Dialogue listSixteen;
    Dialogue listSeventeen;
    Dialogue listEightteen;

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

        Dialogue d10 = new Dialogue(null,true,true,"Can you go retrieve my 7 Crystals from the south?","","","");
        Dialogue d9 = new Dialogue(d10,false,false,"That's quite the sword! You must use it wisely and well. Train with it, ","get to know it and let it know you. There is something else you can do.","Therox's creatures have managed to steal 7 of my Magical crystals. I need you","to go and retrieve the crystals, I saw them running to the south.");
        listFive = d9;

        Dialogue d11 = new Dialogue(null,false,true,"I saw the creatures run south of town, Best of luck Bjarne!","","","");
        listSix = d11;

        Dialogue d14 = new Dialogue(null,true,true,"Can you go and look around town for some clues","Check the houses. I have a bad feeling about this!","","");
        Dialogue d13 = new Dialogue(d14,false,false,"Oh No....","I can sense dark energy in town, there must be something hiding.","","");
        Dialogue d12 = new Dialogue(d13,false,false,"Oh you have them! Hope that wasn't too much trouble.","Alright now lets see how they are getting inside.","","");
        listSeven = d12;

        Dialogue d15 = new Dialogue(null,false,true,"How goes your search? I think the houses in town","might have some clues.","","");
        listEight = d15;

        Dialogue d17 = new Dialogue(null,true,true,"Can you go confront the priest in Town?","","","");
        Dialogue d16 = new Dialogue(d17,false,false,"Hmmmm... It appears this book belongs to the priest.","I fear we have a spy in our clutches Young Bjarne. You need to go"," confront him. I saw him in town earlier, After you confront him,"," find me I'll be in town, This situation seems to be dire!");
        listNine = d16;

        Dialogue d017 = new Dialogue(null,false,true,"Go confront the priest and get to the bottom of this","","","");
        listNineHalf = d017;


        Dialogue d20 = new Dialogue(null,true,true,"find the symbol, I think i remember leaving it somewhere northeast.","","","");
        Dialogue d19 = new Dialogue(d20,false,false,"To defeat him you will need alot more than strength.","You will need to go collect my Holy Symbol to stand a chance.","I think i left it somewhere north east of town.","");
        Dialogue d18 = new Dialogue(d19,false,false,"Bjarne , He came through here and took Sally.","He is one of Therox's Generals Razuul. ","A demon from the underworld.","");
        listTen = d18;

        Dialogue d21 = new Dialogue(null,false,true,"I think I remember Seeing the Holy symbol east of my House.","","","");
        listEleven = d21;

        Dialogue d23 = new Dialogue(null,true,true,"Can you go west , And bring Sally back!","","","");
        Dialogue d22 = new Dialogue(d23,false,false,"Well Done getting the Holy Symbol.","I've Tracked the Demon down to his Church in the west.","Be weary he will not go down easy, Make sure you are Prepared.","");
        listTwelve = d22;

        Dialogue d24 = new Dialogue(null,false,true,"The church is in the west, Goodluck my friend.","","","");
        listThirteen = d24;

        Dialogue d27 = new Dialogue(null,true,true,"Will you go find Dijkstra","","","");
        Dialogue d26 = new Dialogue(d27,false,false,"Our Only hope is a wanderer west of town, His name is Dijkstra,","He was a great warrior who fought with logic and vigor.","Please go find him, and ask for his help!","");
        Dialogue d25 = new Dialogue(d26,false,false,"You Did it good job! Good to see Sally back in town.","Although while you were gone...","Therox has found a way into Town. ","");
        listFourteen = d25;

        Dialogue d28 = new Dialogue(null,false,true,"I think Dijkstra was somewhere to the west.","","","");
        listFifteen = d28;

        Dialogue d30 = new Dialogue(null,true,true,"We need to make a stand soon, Take your time to get ready.","Therox will not fall easily, When you are ready meet me ","at my tower in the North.","");
        Dialogue d29 = new Dialogue(d30,false,false,"Hmmmm. I see Camrath is preparing that means we are almost ready.","There is one last thing you must know Bjarne. Dijkstra is not just a ","wanderer, He is also the King. The last living eir of Javaniah.","");
        listSixteen = d29;

        Dialogue d31 = new Dialogue(null,false,true,"I'll meet you at my house when you are ready.","","","");
        listSeventeen = d31;

        Dialogue d32 = new Dialogue(null,false,true,"Teleport to Therox","","","");
        listEightteen = d32;

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
                currentDialogue = listNineHalf;
                return 14;
            case 16:
                currentDialogue = listEleven;
                return 16;
            case 18:
                currentDialogue = listThirteen;
                return 18;
            case 21:
                return 21;
            case 26:
                currentDialogue = listSeventeen;
                return 26;
            default:
                return 0;

        }

    }

    public void updateDialogue(int currentStage,String questName){

        switch(questStage){
            case 0:
                currentDialogue = listZero;
                break;
            case 1:
                currentDialogue = listOne;
                break;
            case 2:
                currentDialogue = listTwo;
                break;
            case 3:
                currentDialogue = listThree;
                break;
            case 5:
                currentDialogue = listFour;
                break;
            case 9:
                currentDialogue = listFive;
                break;
            case 10:
                currentDialogue = listSix;
                break;
            case 11:
                currentDialogue = listSeven;
                break;
            case 12:
                currentDialogue = listEight;
                break;
            case 13:
                currentDialogue = listNine;
                break;
            case 15:
                currentDialogue = listTen;
                break;
            case 16:
                currentDialogue = listEleven;
                break;
            case 17:
                currentDialogue = listTwelve;
                break;
            case 18:
                currentDialogue = listThirteen;
                break;
            case 20:
                currentDialogue = listFourteen;
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                currentDialogue = listFifteen;
                break;
            case 25:
                currentDialogue = listSixteen;
                break;
            case 26:
                currentDialogue = listEightteen;
                break;

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
                            break;
                        case 20:
                            questStage = 21;
                            break;
                        case 25:
                            questStage = 26;
                            break;
                    }
                }
            }


        }

        return super.keyPressed(e);


    }





}


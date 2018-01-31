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
    Dialogue listFourteen2;
    Dialogue listFifteen;
    Dialogue listSixteen;
    Dialogue listSeventeen;
    Dialogue listEightteen;

    public void initDialogue(){
        Dialogue d0 = new Dialogue(null,false,true,"Who are you? Come back later, I'm busy.","","","");
        listZero = d0;

        Dialogue d4 = new Dialogue(null,true,true,"Kill 5 monsters in front of Sevars' estate.","","","");
        Dialogue d3 = new Dialogue(d4,false,false,"His minions have made their way right to my doorstep it seems, and I","can hardly work on devising a way to beat Therox with his lackeys ","nipping at my heels! If you could take up guard duty here in front of my ","estate, I could begin to get some work done.");
        Dialogue d2 = new Dialogue(d3,false,false,"Knowing Therox was coming for my collection of spellbooks, I cast a","spell to create this forest. It was an old spell, one I had never cast" ,"before... I pushed too much power into it... and... well... it grew","too large. Now the town lies right between Therox and I.");
        Dialogue d1 = new Dialogue(d2,false,false,"Ahhhh, who are you? I don't recognise you but you don't seem the sort to","be working for Therox, that foul cretin! The town is in danger and it's","all my fault! ","");
        listOne = d1;



        Dialogue d5 = new Dialogue(null,false,true,"You still haven't cleared the area","","","");
        listTwo = d5;

        Dialogue d7 = new Dialogue(null,true,true," My friend Camrath should be able to help you with that."," Visit her in the East, buy yourself a new sword, and then return to me.","","");
        Dialogue d6 = new Dialogue(d7,false,false,"Fantastic work! Looks like you've learnt a few new abilities as well! If","you hold any hope of one day defeating Therox, then you're going to need","to upgrade your equipment.","");
        listThree = d6;

        Dialogue d8 = new Dialogue(null,false,true,"Have you spoken to Camrath yet? You'll find her in the East","","","");
        listFour = d8;

        Dialogue d10 = new Dialogue(null,true,true,"Can you go retrieve my 7 Crystals from the South?","","","");
        Dialogue d9 = new Dialogue(d10,false,false,"That's quite the sword! You must use it wisely and well. Train with it, ","get to know it and let it know you. There is something else you can do.","Therox's creatures stole seven of my crystals while you were gone. I","saw them running off South, go retrieve them for me!");
        listFive = d9;

        Dialogue d11 = new Dialogue(null,false,true,"I saw the creatures run South of town. Best of luck Bjarne!","","","");
        listSix = d11;

        Dialogue d14 = new Dialogue(null,true,true,"Can you go and look around town for some clues?","Check the houses. I have a bad feeling about this...","","");
        Dialogue d13 = new Dialogue(d14,false,false,"Oh no...","I can sense dark energy in town, there must be something hiding!","","");
        Dialogue d12 = new Dialogue(d13,false,false,"Oh, you have them! I hope that wasn't too much trouble for you.","Alright, now lets see how they are getting inside.","","");
        listSeven = d12;

        Dialogue d15 = new Dialogue(null,false,true,"How goes your search? I think the houses in town might ","have some clues.","","");
        listEight = d15;

        Dialogue d17 = new Dialogue(null,true,true,"Can you go confront the priest in town?","","","");
        Dialogue d16 = new Dialogue(d17,false,false,"Hmmmm... It appears this book belongs to the priest.","I fear we have a spy in our clutches young Bjarne. You'll need to go","confront him! I recall seeing him in town earlier today. Find me in ","town once you've confronted him and hurry!");
        listNine = d16;

        Dialogue d017 = new Dialogue(null,false,true,"Go confront the priest and get to the bottom of this. There's","no time to waste!","","");
        listNineHalf = d017;


        Dialogue d20 = new Dialogue(null,true,true,"Find the symbol, I think I remember leaving it somewhere North-East.","","","");
        Dialogue d19 = new Dialogue(d20,false,false,"To defeat him you will need a lot more than just strength.","You will need to go collect my Holy Symbol to even stand a ","chance! It was stolen when my crystals were stolen but I think I can","sense it to the North-East of town.");
        Dialogue d18 = new Dialogue(d19,false,false,"Bjarne, he came through here and took Sally. He's one","of Therox's Generals, Razuul, a demon from the underworld! ","","");
        listTen = d18;

        Dialogue d21 = new Dialogue(null,false,true,"I think I remember seeing the Holy symbol East of my house.","","","");
        listEleven = d21;

        Dialogue d23 = new Dialogue(null,true,true,"Can you go West and bring Sally back!","","","");
        Dialogue d22 = new Dialogue(d23,false,false,"Well done getting the Holy Symbol. I've tracked the Demon down","to his church in the West. Be weary, he will not go down","easy! Make sure you are prepared.","");
        listTwelve = d22;

        Dialogue d24 = new Dialogue(null,false,true,"The church is in the West. Good luck my friend.","","","");
        listThirteen = d24;

        Dialogue d27 = new Dialogue(null,true,true,"Will you go find Dijkstra?","","","");
        Dialogue d26 = new Dialogue(d27,false,false,"Our only hope is a wanderer West of town, his name is Dijkstra.","He was a great warrior who fought with logic and vigor.","Please go find him and ask for his help!","");
        Dialogue d25 = new Dialogue(d26,false,false,"You did it! Good job! Good to see Sally back in town.","I can sense Therox getting closer and growing stronger. I'm afraid","if we don't do something soon, it may be too late...","");
        listFourteen = d25;

        Dialogue d025 = new Dialogue(d26,false,false,"I saw from the crystals what happened. ","Today is a day of mourning, do not blame yourself Bjarne.","Unfortunately every second we delay, they get stronger.","");
        listFourteen2 = d025;

        Dialogue d28 = new Dialogue(null,false,true,"I think Dijkstra was somewhere to the West.","","","");
        listFifteen = d28;

        Dialogue d30 = new Dialogue(null,true,true,"We need to make a stand soon, take your time to get ready.","Therox will not fall easily, When you are ready meet me ","at my tower in the North.","");
        Dialogue d29 = new Dialogue(d30,false,false,"Hmmmm I see Camrath is preparing, that means we are almost ready.","There is one last thing you must know Bjarne. Dijkstra is not just a ","wanderer, he is also the King. The last living heir of Javaniah.","");
        listSixteen = d29;

        Dialogue d31 = new Dialogue(null,false,true,"I'll meet you at my house when you are ready.","","","");
        listSeventeen = d31;

        Dialogue d32 = new Dialogue(null,false,true,"Bjarne, make sure you have stocked up on supplies before we go.","Once we're there, there will be no turning back! It will ","definately be worth visiting the town shop before we go!","");
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
                currentDialogue = listEight;
                return 12;
            case 15:
                currentDialogue = listNineHalf;
                return 15;
            case 17:
                currentDialogue = listEleven;
                return 17;
            case 20:
                currentDialogue = listThirteen;
                return 20;
            case 23:
                currentDialogue = listFifteen;
                return 23;
            case 29:
                currentDialogue = listSeventeen;
                return  29;
            default:
                return 0;

        }

    }

    public void updateDialogue(int npcDeaths){

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
            case 4:
                currentDialogue = listThree;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                currentDialogue = listFour;
                break;
            case 9:
                currentDialogue = listFive;
                break;
            case 10:
                currentDialogue = listSix;
                break;
            case 11:
            case 12:
                currentDialogue = listSeven;
                break;
            case 13:
                currentDialogue = listEight;
                break;
            case 14:
                currentDialogue = listNine;
                break;
            case 15:
            case 16:
                currentDialogue = listTen;
                break;
            case 17:
            case 18:
                currentDialogue = listEleven;
                break;
            case 19:
                currentDialogue = listTwelve;
                break;
            case 20:
            case 21:
                currentDialogue = listThirteen;
                break;

            case 22:
                if(npcDeaths == 0 || npcDeaths == 1){
                    currentDialogue = listFourteen;
                }else{
                    currentDialogue = listFourteen2;
                }

                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                currentDialogue = listFifteen;
                break;
            case 28:
            case 29:
                currentDialogue = listSixteen;
                break;
            case 30:
                currentDialogue = listEightteen;
                break;

        }

    }







    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){
        this.questStage = questStage;

        if(loadDialogue) {
            updateDialogue(npcDeaths);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);


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
                        case 14:
                            questStage = 15;
                            break;
                        case 16:
                            questStage = 17;
                            break;
                        case 19:
                            questStage = 20;
                            break;
                        case 22:
                            questStage = 23;
                            break;
                        case 28:
                            questStage = 29;
                            break;
                    }
                }
            }


        }

        return super.keyPressed(e);


    }





}


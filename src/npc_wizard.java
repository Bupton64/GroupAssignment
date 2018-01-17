import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class npc_wizard extends  NPC {

    boolean questAccepted;
    int questStage;


    npc_wizard(){
        setName("Sevar");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(400);
        setMapPosY(250);
        questAccepted = false;
        questStage = 0;
        initDialogue();
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

    Dialogue currentDialogue;


    public void initDialogue(){
        Dialogue d4 = new Dialogue(null,true,true,"Kill 5 Goblins in front of Sevars' estate.","","","");
        Dialogue d3 = new Dialogue(d4,false,false,"His minions have made their way right to my doorstep it seems, and I","can hardly work on devising a way to beat Therox with his lackeys nipping","at my heels, If you could take up guard duty here in front of my estate,","I could begin to get some work done.");
        Dialogue d2 = new Dialogue(d3,false,false,"Knowing Therox was coming for my collection of spellbooks, I cast a","spell to create this forest. It was an old spell, one I had never cast" ,"before... I   pushed too much power into it... and... well... it grew","too large. Now the town lies right between Therox and I.");
        Dialogue d1 = new Dialogue(d2,false,false,"Ahhhh, who are you? I don't recognise you but you don't seem the sort to","be working for Therox, that foul cretin! The town is in danger and it's","all my fault! ","");
        listOne = d1;



        Dialogue d5 = new Dialogue(null,false,true,"You still haven't cleared the area","","","");
        listTwo = d5;

        Dialogue d6 = new Dialogue(null,true,true,"Fantastic work! Looks like you've learnt a few new abilities as well! I'll","need you to venture out East, you can follow the path if you please, and  ","find Camrath. Camrath will be able to craft you a sword, the sword ","alone won't be enough but it's a start. Come and talk to me after you get it.");
        listThree = d6;

        currentDialogue = listOne;
    }

    public int updateConvo(){
        switch (questStage){
            case 1:
                return 1;
            case 3:
                return 2;
            default:
                return 0;

        }




    }


    public void updateDialogue(){
            if (currentDialogue.getOptionPosY() == 375) {

                currentDialogue.setOptionPosY(350);
            } else {
                currentDialogue.setOptionPosY(375);
            }

    }

    boolean changeDialogue;


    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        if(questName == "killingForWizard") {
            if (currentState == Quest.questState.preQuest) {
                questStage = 0;

                    //listOne.getFirst().display(g);
                currentDialogue.display(g);




            }
            if (currentState == Quest.questState.inQuest) {
                listTwo.display(g);

            }
            if (currentState == Quest.questState.completedQuest) {
                questStage = 2;

                listThree.display(g);
            }
        } else if(questName == "talkToBlacksmith") {
            if(currentState == Quest.questState.inQuest){
                drawText(110,450,"Have you spoken to Camrath yet? you'll find him in the East", "Times New Roman",20,g);
            }
            if(currentState == Quest.questState.completedQuest){
                changeColor(black, g);
                drawSolidRectangle(400,345,300,50,g);
                changeColor(Color.white,g);
                drawRectangle(400,345,300,50,10,g);
                drawText(425, 375, "Press 'Space' to accept quest", "Arial", 20, g);


                drawText(110,450,"That's quite the sword! You must use it wisely and well. Train with it, ", "Times New Roman",20,g);
                drawText(110,475,"get to know it and let it know you. There is something else you can do", "Times New Roman",20,g);
                drawText(110,500,"however... COMPLETE STORY HERE", "Times New Roman",20,g);
                //Implement when the push space to accept quest works
                //player.changeQuest(3);
            }
        }
//
    }



    //////////////////////////////
    ///
    ///    KeyBinds
    ///
    //////////////////////////////



    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next != null) {
                currentDialogue = currentDialogue.next;
                return true;
            }


            switch (questStage){
                case 0:
                    questStage = 1;
                    break;
                case 2:
                    questStage = 3;
                    break;
            }
            return false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(currentDialogue.isHasOptions()){
                updateDialogue();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(currentDialogue.isHasOptions()){
               updateDialogue();
            }
        }


        return false;
    }



}


import java.awt.*;
import java.awt.event.*;

//BLACKSMITH
public class npc_plains_H9 extends  NPC {



    npc_plains_H9(){
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


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,true,true,"I knew it was only a matter of time before you came looking for help.","Let me guess, you want a new sword? hmmmmm it'll cost you, I don't give","a damn if it's the 'end of the world' I need to put food on the table.","500GP and i'll make you one.");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,true,true,"This sword is made out of the purest crystal in the land, unbreakable,","unmatchable, unbeatable. If there's any weapon that stands a chance","of banishing Jacruler this is it. good luck Bjarne You'll","need it.");
        listTwo = d2;

    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName,int questStage){
        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
        if(questName == "talkToBlacksmith") {
            if (currentState == Quest.questState.inQuest) {

                drawText(425, 375, "Press 'Space' to buy sword", "Arial", 20, g);

            }
            if(currentState == Quest.questState.completedQuest){
                ;
            }
        } else{
            changeColor(black, g);
            drawSolidRectangle(400,345,300,50,g);
            changeColor(Color.white,g);
            drawRectangle(400,345,300,50,10,g);
            drawText(425, 375, "Press 'Space' to open menu", "Arial", 20, g);

            drawText(110, 450, "Would you like to browse my wares?", "Times New Roman", 20, g);
        }
    }








}

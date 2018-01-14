import java.awt.*;
import java.awt.event.*;


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
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
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



    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName){
        super.drawConvo(g, playerName,currentState, questName);
        if(questName == "killingForWizard") {
            if (currentState == Quest.questState.preQuest) {
                questStage = 0;
                changeColor(black, g);
                drawSolidRectangle(400,345,300,50,g);
                changeColor(Color.white,g);
                drawRectangle(400,345,300,50,10,g);
                drawText(425, 375, "Press 'Space' to accept quest", "Arial", 20, g);



                drawText(110, 450, "Ah, " + playerName+ " you made it! I'm surprised, but you've got a long way", "Times New Roman", 20, g);
                drawText(110, 475, "to go before you're ready to take on Jacruler... I need some help from you", "Times New Roman", 20, g);
                drawText(110, 500, "before we begin. There has been a lot of monsters around these parts of ", "Times New Roman", 20, g);
                drawText(110, 525, "late, would you please clear this area so we can get to work?", "Times New Roman", 20, g);


            }
            if (currentState == Quest.questState.inQuest) {
                drawText(110, 450, "You still haven't cleared the area", "Times New Roman", 20, g);
            }
            if (currentState == Quest.questState.completedQuest) {
                questStage = 2;
                changeColor(black, g);
                drawSolidRectangle(400,345,300,50,g);
                changeColor(Color.white,g);
                drawRectangle(400,345,300,50,10,g);
                drawText(425, 375, "Press 'Space' to accept quest", "Arial", 20, g);


                drawText(110, 450, "Fantastic work! Looks like you've learnt a few new abilities as well! I'll", "Times New Roman", 20, g);
                drawText(110, 475, "need you to venture out East, you can follow the path if you please, and  ", "Times New Roman", 20, g);
                drawText(110, 500, "find Camrath. Camrath will be able to craft you a sword, the sword ", "Times New Roman", 20, g);
                drawText(110, 525, "alone won't be enough but it's a start. Come and talk to me after you get it.", "Times New Roman", 20, g);
                //Implement when the push space to accept quest works
                //player.changeQuest(3);
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
            switch (questStage){
                case 0:
                    questStage = 1;
                    break;
                case 2:
                    questStage = 3;
                    break;
            }

        }
        return false;
    }



}


import java.awt.*;
import java.awt.event.*;


public class npc_wizard extends  NPC {

    boolean questAccept;

    npc_wizard(){
        setName("Tim the Great");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(17);
        setMapPos(400,250);
        setHostile(false);
        questAccept = false;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }


                      //<1 is pre-quest, 2 is before the quest has ended and 3 is end of first quest
                      //<First quest is to kill 5 monsters
                      //<4 is for after



    public void drawConvo(Graphics2D g, Character player){
        super.drawConvo(g, player);
        if(player.getCurrentQuest().getQuestName() == "killingForWizard") {
            if (player.getCurrentQuest().getState() == Quest.questState.preQuest) {
                changeColor(black, g);
                drawSolidRectangle(400,345,300,50,g);
                changeColor(Color.white,g);
                drawRectangle(400,345,300,50,10,g);
                drawText(425, 375, "Press 'Space' to accept quest", "Arial", 20, g);



                drawText(110, 450, "Ah, " + player.getName() + " you made it! I'm surprised, but you've got a long way", "Times New Roman", 20, g);
                drawText(110, 475, "to go before you're ready to take on Jacruler... I need some help from you", "Times New Roman", 20, g);
                drawText(110, 500, "before we begin. There has been a lot of monsters around these parts of ", "Times New Roman", 20, g);
                drawText(110, 525, "late, would you please clear this area so we can get to work?", "Times New Roman", 20, g);
                if(questAccept){
                    player.setTheState(Quest.questState.inQuest);
                }

            }
            if (player.getCurrentQuest().getState() == Quest.questState.inQuest) {
                drawText(110, 450, "You still haven't cleared the area", "Times New Roman", 20, g);
            }
            if (player.getCurrentQuest().getState() == Quest.questState.completedQuest) {
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
        } else if(player.getCurrentQuest().getQuestName() == "talkToBlacksmith") {
            if(player.getCurrentQuest().getState() == Quest.questState.inQuest){
                drawText(110,450,"Have you spoken to Camrath yet? you'll find him in the East", "Times New Roman",20,g);
            }
            if(player.getCurrentQuest().getState() == Quest.questState.completedQuest){
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
        } else{
            player.changeQuest(1);
        }
//
    }
//    public void updateConvo(Character playerMan){
//
//    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            questAccept = true;
        }
    }



}


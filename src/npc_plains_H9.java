import java.awt.*;
import java.awt.event.*;

//BLACKSMITH
public class npc_plains_H9 extends  NPC {

    Character player;

    npc_plains_H9(Character playerMan){
        setName("Camrath");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(39);
        setMapPos(500,250);
        setHostile(false);
        this.player = playerMan;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }

    int questNum = 1;   //<1 when he hasn't brought the sword, 2 after he brought it
                        //<3 is after the initial quest and players will be able to buy various weapons from him

    public void drawConvo(Graphics2D g){
        super.drawConvo(g);
        if(player.getCurrentQuest().getQuestName() == "talkToBlacksmith") {
            if (player.getCurrentQuest().getState() == Quest.questState.inQuest) {
                changeColor(black, g);
                drawSolidRectangle(400,345,300,50,g);
                changeColor(Color.white,g);
                drawRectangle(400,345,300,50,10,g);
                drawText(425, 375, "Press 'Space' to buy sword", "Arial", 20, g);

                drawText(110, 450, "I knew it was only a matter of time before you came looking for help.", "Times New Roman", 20, g);
                drawText(110, 475, "Let me guess, you want a new sword? hmmmmm it'll cost you, I don't give", "Times New Roman", 20, g);
                drawText(110, 500, "a damn if it's the 'end of the world' I need to put food on the table.", "Times New Roman", 20, g);
                drawText(110, 525, "500GP and i'll make you one.", "Times New Roman", 20, g);
            }
            if(player.getCurrentQuest().getState() == Quest.questState.completedQuest){
                drawText(110, 450, "This sword is made out of the purest crystal in the land, unbreakable,", "Times New Roman", 20, g);
                drawText(110, 475, "unmatchable, unbeatable. If there's any weapon that stands a chance", "Times New Roman", 20, g);
                drawText(110, 500, "of banishing Jacruler this is it. good luck " + player.getName() + " You'll", "Times New Roman", 20, g);
                drawText(110, 525, "need it.", "Times New Roman", 20, g);
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

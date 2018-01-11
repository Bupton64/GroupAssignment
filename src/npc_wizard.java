import java.awt.*;
import java.awt.event.*;


public class npc_wizard extends  NPC {

    npc_wizard( ){
        setName("THE GREAT WIZARD OF THE NORTH... TIM");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(17);
        setMapPos(400,250);
        setHostile(false);
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

    @Override
    public void npcAction(double dt, Collision collisionDetector){

    }


    int questNum = 1;



    public void drawConvo(Graphics2D g, String playerMan){
        super.drawConvo(g,playerMan);
        if(questNum == 1) {
            drawText(110, 450, "Start of quest", "Times New Roman", 20, g);
            questNum = 2;
        }
        if(questNum == 2){    
            drawText(110,450,"Next", "Times New Roman",20,g);
        }
    }







}


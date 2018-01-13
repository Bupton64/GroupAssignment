import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_oldman extends  NPC {

    npc_plains_f8_oldman(Character playerMan){
        setName("Julian");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(200,200);
        setHostile(false);

        setMoveTimer(0);
        setMoveDelay(10);
        location = new double[2];
        setLocation(0,300);
        setLocation(1,200);

        currentLocation =  1;
    }


    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
    }

    @Override
    public void setUpCollision(Collision collisionDetector,extraFunctions map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    public void npcAction(double dt,Collision collisionDetector){
            setMoveTimer(getMoveTimer() + dt);

            if(getMoveTimer() > getMoveDelay()){
                collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);
                if(currentLocation == 1) {
                    setMapPos(getMapPosX(), getMapPosY() + (20 * dt));
                    if (getMapPosY() > getLocation(0)) {
                        setMoveTimer(0);
                        currentLocation = 0;
                    }
                }else{
                    setMapPos(getMapPosX(), getMapPosY() - (20 * dt));
                    if (getMapPosY() < getLocation(1)) {
                        setMoveTimer(0);
                        currentLocation =1;
                    }
                }
                collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
            }

    }

    public void drawConvo(Graphics2D g){
        super.drawConvo(g);
        drawText(110,450,"I'm Julian, the oldest NPC... uh I mean villager in this Town.", "Times New Roman",20,g);
    }








}





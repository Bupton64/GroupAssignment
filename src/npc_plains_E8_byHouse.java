import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_byHouse extends  NPC {

    npc_plains_E8_byHouse(){
        setName("Tim Burr");
        spriteSheet = loadImage("chara1.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(20);
        setMapPos(80,180);
        setHostile(false);

        moveTimer = 0;
        moveDelay = 0.1;

        location = new double[2];
        setLocation(0,260);
        setLocation(1,80);
        currentLocation= 1;
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

    @Override
    public void npcAction(double dt,Collision collisionDetector){
        setMoveTimer(getMoveTimer() + dt);

        if(getMoveTimer() > getMoveDelay()){
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),false);
            if(currentLocation == 1) {
                setMapPos(getMapPosX() + (60 * dt), getMapPosY());
                if (getMapPosX() > getLocation(0)) {
                    setMoveTimer(0);
                    currentLocation= 0;
                }
            }else{
                setMapPos(getMapPosX() - (60 * dt), getMapPosY());
                if (getMapPosX() < getLocation(1)) {
                    setMoveTimer(0);
                    currentLocation = 1;
                }
            }
            collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),true);
        }

    }

    public void drawConvo(Graphics2D g, Character player){
        super.drawConvo(g, player);
        drawText(110,450,"MY NAME'S NOT THAT FUNNY OK!? ", "Times New Roman",20,g);
    }



}

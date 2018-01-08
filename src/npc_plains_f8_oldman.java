import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_oldman extends  NPC {

    npc_plains_f8_oldman( ){
        setName("Julian");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,364,288,56,72);
        setHeight(70);
        setWidth(50);
        setMapLocation(28);
        setMapPos(200,200);
        setHostile(false);
    }





}

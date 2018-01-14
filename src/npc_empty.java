import java.awt.event.KeyEvent;

public class npc_empty extends NPC {

    npc_empty(){

        setName("");
        setMapPosX(0);
        setMapPosY(0);
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,0,0,1,1);

    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){

    }


    public void npcAction(double dt, Character player){

    }

}
// Isaac Test Comment
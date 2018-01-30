import java.awt.*;
import java.awt.event.*;


public class npc_plains_SevarsWifeGrave extends  NPC {


    npc_plains_SevarsWifeGrave(){
        setName("Grave");
        spriteSheet = loadImage("NPCwithoutSprite.png");
        sprite = subImage(spriteSheet,0,0,1,1);
        setMapPosX(570);
        setMapPosY(220);

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        //collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
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




    public void initDialogue() {

        Dialogue d1 = new Dialogue(null,false,true,"Here rests Sevars' beloved wife.","","","");
        listOne = d1;
    }

    public void updateDialogue(int questStage){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }




}

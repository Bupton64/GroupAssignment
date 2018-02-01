import java.awt.*;
import java.awt.event.*;

//MOVED TO H9
public class npc_plains_F9_StoreBabbage extends  NPC {



    npc_plains_F9_StoreBabbage(){
        setName("Babbage");
        spriteSheet = loadImage("Image/chara5.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(300);
        setMapPosY(200);

        initDialogue(); //new
        loadDialogue = true; // new
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


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,true,true,"Would you like to browse my wares?","","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }


    public int updateConvo(){
        switch (this.questStage){
            case 96:
                this.questStage = 9;
                return 96;
            default:
                return 0;

        }

    }


    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }

    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    questStage = 96;
                }
            }
        }

        return super.keyPressed(e);


    }




}

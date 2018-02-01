import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_StoreLink extends  NPC {

    npc_plains_F9_StoreLink(){
        setName("Link");
        spriteSheet = loadImage("Image/chara3.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setMapPosX(450);
        setMapPosY(200);

        initDialogue();
        loadDialogue = true;
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

    Dialogue listTwo;


    public void initDialogue() {


        Dialogue d1 = new Dialogue(null,true,true,"Hey, thanks for helping Camrath and I.","Here, take this sword as a token of appreciation, and remember,  ","you are always welcome to come browse my store!","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,true,true,"Hey Bjarne, good to see you again! Care to browse my goods?","","","");
        listTwo = d2;
    }


    public void updateDialogue(int currentStage){
        if(currentStage == 7) {
            currentDialogue = listOne;
        }else{
            currentDialogue = listTwo;
        }

    }

    public int updateConvo(){
        switch (this.questStage){
            case 8:
                currentDialogue = listTwo;
                return 8;
            case 97:
                this.questStage = 9;
                return 97;
            default:
                return 0;

        }

    }


    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }

        super.drawConvo(g,currentState, questName,questStage,npcDeaths);

    }



    //////////////////////////////
    ///
    ///    KeyBinds
    ///
    //////////////////////////////



    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    if(questStage == 7){
                        questStage = 8;
                    }else{
                        questStage = 97;
                    }

                }
            }
        }

        return super.keyPressed(e);


    }




}

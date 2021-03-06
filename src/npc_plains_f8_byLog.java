import java.awt.*;
import java.awt.event.*;


public class npc_plains_f8_byLog extends  NPC {

    npc_plains_f8_byLog(){
        setName("Link");
        spriteSheet = loadImage("Image/chara3.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setMapPosX(650);
        setMapPosY(85);

        turnArray = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            turnArray[i] = subImage(spriteSheet,520,(i * 72),56,72);
        }
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
        if(this.questStage < 7){
            turn();
        }
    }




    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;




    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Can't you see I'm busy!? Camrath sent me to fetch wood!","","","");
        listOne = d1;


    }


        public void updateDialogue(int currentStage){
            if(questStage < 5){
                currentDialogue = listOne;
            }

        }


    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }




}

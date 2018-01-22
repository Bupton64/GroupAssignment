import java.awt.*;
import java.awt.event.*;

//BLACKSMITH
public class npc_plains_H9 extends  NPC {

    private int gold;

    npc_plains_H9(int gold){
        this.gold = gold;
        setName("Camrath");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(500);
        setMapPosY(250);

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

    Dialogue listThree;

    Dialogue listFour;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Leave me be. I am busy....","","","");
        listOne = d1;


        Dialogue d2 = new Dialogue(null,true,true,"Bjarne! I've been expecting you ever since I heard you had arrived.","Let me guess, you're looking for a weapon? Unfortunately I'm lacking","materials. Could you give me 500GP so that I purchase the resources","needed?");
        listTwo = d2;

        Dialogue d3 = new Dialogue(null,false,true,"Thank you helping me out! Please go and find Link in the town.","I have sent her to the town Store to handle merchandise.","She will help you with getting a sword","");
        listThree = d3;

        Dialogue d4 = new Dialogue(null,false,true,"Hey Bjarne! Thanks again for helping me. I hope Link has been","able to help you with your quest.","","");
        listFour = d4;
    }

    public void updateDialogue(Quest.questState  currentState,String questName){
        if(questName == "empty" || questName == "A Wizards Problem"){
            currentDialogue = listOne;
        }else if(questName == "The Road To Riches"){
            if (currentState == Quest.questState.preQuest) {
                currentDialogue = listTwo;
            }
            if (currentState == Quest.questState.inQuest) {
                currentDialogue = listThree;
            }
        }else{
            currentDialogue = listFour;
        }

    }

    public int updateConvo(){
        switch (this.questStage){
            case 6:
                currentDialogue = listThree;
                return 6;

            default:
                return 0;

        }

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName,int questStage){

        if(loadDialogue) {
            updateDialogue(currentState,questName);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
        if(questName == "The Road To Riches") {
            if (currentState == Quest.questState.preQuest) {

            }
            if(currentState == Quest.questState.inQuest){
                if(currentDialogue != listThree){
                    loadDialogue = true;
                }
            }
            if(currentState == Quest.questState.completedQuest){

            }







        }

    }



    //////////////////////////////
    ///
    ///    KeyBinds
    ///
    //////////////////////////////



    public boolean keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(currentDialogue.next == null && gold >= 500) {
                if (currentDialogue.getOptionPosY() == 375 ) {
                    switch (questStage) {
                        case 5:
                            questStage = 6;
                            break;

                    }
                }
            }
        }

        return super.keyPressed(e);


    }








}

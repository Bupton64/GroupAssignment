import java.awt.*;
import java.awt.event.*;

//MOVED TO H9
public class npc_plains_Dijkstra extends  NPC {



    npc_plains_Dijkstra(int posX, int posY){
        setName("Dijkstra");
        spriteSheet = loadImage("chara2.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setMapPosX(posX);
        setMapPosY(posY);

        spriteDown = new Image[3];
        spriteUp = new Image[3];
        spriteRight = new Image[3];
        spriteLeft = new Image[3];

        initDialogue(); //new
        loadDialogue = true; // new
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet, 468+(52 * i), 0,52,72);
            spriteLeft[i] = subImage(spriteSheet,468+(52 * i), 72,52,72);
            spriteRight[i] = subImage(spriteSheet,468+(52 * i), 144,52,72);
            spriteUp[i] = subImage(spriteSheet,468+(52 * i), 216,52,72);
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
        Dialogue d1 = new Dialogue(null,false,true,"If I'm honest, I'm a bit lost. There's so many monsters around here!","Thankfully I have these potions to save me!","","");
        listOne = d1;

        Dialogue d3 = new Dialogue(null,true,true,"Go Search the picture frame in the church and then visit Camrath","the blacksmith.","","");
        Dialogue d2 = new Dialogue(d3,false,false,"Hello Adventurer, I know why you are here... I can get you to Therox,","although it will not be easy... I hid something in the church many years","ago. Go to the church and search behind the picture frame.","");
        listTwo = d2;

        Dialogue d4 = new Dialogue(null,false,true,"The church is just west of here. Take what you find to Camrath.","","","");
        listThree = d4;

        Dialogue d6 = new Dialogue(null,true,true,"Are you ready for this final battle?","","","");
        Dialogue d5 = new Dialogue(d6,false,false,"Bjarne! Glad to see you made it in time. We have managed to create","a location spell that will send you, Sevar, and Therox to an isolated arena","away from his army. This will be your best chance to finish him.","");
        listFour = d5;
    }

    public void updateDialogue(int questStage){

        if(questStage < 24) {
            currentDialogue = listOne;
        }else {
            switch (questStage) {
                case 24:
                    currentDialogue = listTwo;
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                    currentDialogue = listThree;
                    break;
                case 29:
                    currentDialogue = listFour;
                    break;
            }

        }

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }


    public int updateConvo(){
        switch (this.questStage){
            case 25:
                currentDialogue = listThree;
                return 25;
            case 31:
                return 95;
            default:
                return 0;

        }

    }









    public boolean keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 24:
                            questStage = 25;
                            break;
                        case 30:
                            questStage = 31;
                            break;
                    }
                }
            }
        }

        return super.keyPressed(e);


    }






}

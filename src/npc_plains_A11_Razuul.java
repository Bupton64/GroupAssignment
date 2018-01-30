import java.awt.*;
import java.awt.event.*;

public class npc_plains_A11_Razuul extends NPC{


    npc_plains_A11_Razuul() {
        setName("Razuul");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,364,288,56,72);
        setMapPosX(320);
        setMapPosY(200);

        spriteLeft = new Image[3];
        spriteRight = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,312 + (52 * i), 288,52,72);
            spriteLeft[i] = subImage(spriteSheet,312 + (52 * i), 360,52,72);
        }
    }

    @Override
    public void setUpCollision(Collision collisionDetector, Map map) {
        collisionDetector.addBoxCollision(((int) getMapPosX() / 10 - 2), ((int) getMapPosY() / 10 - 4), ((int) getWidth() / 10 - 3), ((int) getHeight() / 10 - 3), map.isFlicker());
    }

    @Override
    public void undoCollision(Collision collisionDetector){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 4),((int)getWidth()/10-3),((int)getHeight()/10 - 3),false);
    }

    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////

    @Override
    public void updateNpcMovement(double dt, Collision collisionDetector) {

    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////
    int npcDeaths;
    Dialogue listOne;

    Dialogue listTwo;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null, true, true, "What a surprise it is to see you here little man! Wanted another", "crack at taking down the mighty Razuul did you? Well come", "and get it!", "");
        listOne = d1;

        Dialogue d3 = new Dialogue(null, true, true, "*You lose your shit and charge at Razuul*", "", "", "");
        Dialogue d2 = new Dialogue(d3, false, false, "Oooh she was delicious! Maybe after im finished with you, I'll go ", "pay that town another visit!", "", "");
        listTwo = d2;
    }

    public void updateDialogue(int npcDeaths) {
        if(npcDeaths == 0 || npcDeaths == 1) {
            currentDialogue = listOne;
        }else{
            currentDialogue = listTwo;
        }

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){
        this.npcDeaths = npcDeaths;
        if (loadDialogue) {
            updateDialogue(npcDeaths);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }

    public int updateConvo() {
        if (summonMonster) {
            return 99;

        } if(killnpc){
            return 93;
        }
        return 0;
    }

    //test code
    boolean summonMonster = false;
    boolean killnpc = false;


    public boolean keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    summonMonster = true;
                }else {
                    if (npcDeaths == 0 || npcDeaths == 1) {
                        killnpc = true;
                        currentDialogue = listTwo;
                    }
                }
            }
        }

        return super.keyPressed(e);


    }






}

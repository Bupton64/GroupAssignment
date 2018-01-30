import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8topRightBook extends  NPC {



    npc_plains_E8topRightBook(){
        setName("Book");
        sprite = loadImage("book.png");
        //sprite = subImage(spriteSheet,364,0,56,72);
        setMapPosX(450);
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


    public void initDialogue() {
        Dialogue d4 = new Dialogue(null, false, true, "Attacks come in two types, physical and magical.", "Physical attacks have a chance to miss your enemy, while magic attacks", "do not. However, only physical attacks can score a critical hit which", "doubles their damage!");
        Dialogue d3 = new Dialogue(d4, false, false, "Hints", "- You gain abilities and stats at level up", " - Enemies will sometimes drop items", " - Save often!");
        Dialogue d2 = new Dialogue(d3, false, false, "Town hints", "- You can sleep in the bed to regain health", "- Find the shop, there are valuable healing potions!", "- Talk to the townsfolk!");
        Dialogue d1 = new Dialogue(d2,false,false,"Welcome to Bjarne's World!","- Use the arrow keys to move","- [SPACE] to interact","- [ESC] to go back or access the menu");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }




}

import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8topRightBook extends  NPC {



    npc_plains_E8topRightBook(){
        setName("Book");
        sprite = loadImage("Image/book.png");
        //sprite = subImage(spriteSheet,364,0,56,72);
        setMapPosX(450);
        setMapPosY(250);
        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 1),((int)getMapPosY()/10 - 4),((int)getWidth()/10 - 3),((int)getHeight()/10 - 3),map.isFlicker());
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
        Dialogue d6 = new Dialogue(null, false, true, "STATS:", "Strength increases your damage.", "Luck increases your ciritcal chance.", "Good luck!");
        Dialogue d5 = new Dialogue(d6, false, false, "STATS:", "Attack increases your chance to hit and your damage.", "Defense increases your resistance to damage.", "Speed increases your chance to hit and turn order.");
        Dialogue d4 = new Dialogue(d5, false, false, "Attacks come in two types, physical and magical.", "Physical attacks have a chance to miss your enemy, while magic attacks", "do not. However, only physical attacks can score a critical hit which", "doubles their damage!");
        Dialogue d3 = new Dialogue(d4, false, false, "Hints", "- You gain abilities and stats at level up.", " - Abilities can only be used in combat", " - Save often!");
        Dialogue d2 = new Dialogue(d3, false, false, "Town hints", "- You can sleep in your bed to regain health.", "- Find the shop, there are valuable healing potions!", "- Talk to the townsfolk!");
        Dialogue d1 = new Dialogue(d2,false,false,"Welcome to Bjarne's World!","- Use the arrow keys to move.","- [SPACE] to interact.","- [ESC] to go back or access the menu.");
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

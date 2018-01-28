import java.awt.*;

public class quest_ASpyInTheClutches extends Quest {


    quest_ASpyInTheClutches(){


        collectableState = new boolean[1];
        for(int i = 0; i < 1;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 1;

        setQuestName("A Spy In The Clutches");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
            //500xp
            // mega pot
            return true;
        }
        displayTimer = 0;
        return false;
    }


    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 500);

        item_megaPotion mega = new item_megaPotion();
        playerMan.addItemToInventory(mega);
        playerMan.checkLevelUp();
    }

    public void drawQuestReward(Graphics2D g){
        if(displayReward){
            super.drawQuestReward(g);
            changeColor(white, g);
            drawBoldText(310, 40, "Quest Reward", "Felix Titling", 18, g);
            //  changeColor(purple, g);
            drawBoldText(330, 60, "+300 Gold", "Felix Titling", 16, g);
            drawBoldText(330, 80, "+500 EXP", "Felix Titling", 16, g);
        }
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(40, 400, "Search Town for Clues", "Arial", 20, g);

        }
        if(getState() == questState.inQuest){
            changeColor(white, g);
            drawText(40, 400, "Return to Sevar", "Arial", 20, g);
        }
        if(getState() == questState.completedQuest){
            changeColor(white, g);
            drawText(40, 400, "Confront the priest", "Arial", 20, g);
        }
        if(getState() == questState.extraQuest){
            changeColor(white, g);
            drawText(40, 400, "Find sevar in town", "Arial", 20, g);
        }

    }
}

import java.awt.*;

public class quest_TheMissingPieces extends Quest {




    quest_TheMissingPieces(){
        collectableState = new boolean[7];
        for(int i = 0; i < 7;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 7;
        setQuestName("The Missing Pieces");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
            // 300
            // 500exp
            return true;
        }
        displayTimer = 0;
        return false;
    }

    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 500);
        playerMan.setGpTotal(playerMan.getGpTotal() + 300);
        playerMan.checkLevelUp();
    }


    public void drawQuestReward(Graphics2D g){
        if(displayReward){
            super.drawQuestReward(g);
            changeColor(white, g);
            drawBoldText(310, 40, "Quest Reward", "Felix Titling", 18, g);
            //  changeColor(purple, g);
            drawBoldText(310, 70, "+ Bronze Sword", "Felix Titling", 16, g);
        }
    }





    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest){
            changeColor(white, g);
            drawText(40, 400,"Return to Sevar", "Arial", 20, g);
        }
        if(getState() == questState.inQuest) {
            changeColor(white, g);
            drawText(40, 400, numOfCollectables +"/7 Crystals Collected", "Arial", 20, g);

        }
        if(getState() == questState.completedQuest){
            changeColor(white, g);
            drawText(40, 400, "Return to Sevar", "Arial", 20, g);
        }

    }

}

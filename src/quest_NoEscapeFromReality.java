
import java.awt.*;

public class quest_NoEscapeFromReality extends Quest {
    boolean displayReward;

    quest_NoEscapeFromReality(){


        collectableState = new boolean[1];
        for(int i = 0; i < 1;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 1;

        setQuestName("No Escape From Reality");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
            //1000exp
            // 150gold
            return true;
        }
        displayTimer = 0;
        return false;
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(40, 400, "Go Find the Holy Symbol", "Arial", 20, g);

        }
        if(getState() == questState.inQuest){
            changeColor(white, g);
            drawText(40, 400, "Return to Sevar", "Arial", 20, g);
        }
        if(getState() == questState.completedQuest){
            changeColor(white, g);
            drawText(40, 400, "Head to the Church", "Arial", 20, g);
        }
        if(getState() == questState.extraQuest){
            changeColor(white, g);
            drawText(40, 400, "Head Back to town", "Arial", 20, g);
        }
    }
}


import java.awt.*;

public class quest_AWanderingSoul extends Quest {
    boolean displayReward;

    quest_AWanderingSoul(){


        collectableState = new boolean[1];
        for(int i = 0; i < 1;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 1;

        setQuestName("A Wandering Soul");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
            // 500exp
            // 1000gold
            return true;
        }
        displayTimer = 0;
        return false;
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(40, 400, "Find Dijkstra", "Arial", 20, g);

        }
        if(getState() == questState.inQuest){
            changeColor(white, g);
            drawText(40, 400, "Find the painting in the church", "Arial", 20, g);
        }
        if(getState() == questState.completedQuest){
            changeColor(white, g);
            drawText(40, 400, "Go to Camrath", "Arial", 20, g);
        }
        if(getState() == questState.extraQuest){
            changeColor(white, g);
            drawText(40, 400, "Return to Sevar", "Arial", 20, g);
        }
    }
}


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

        setQuestName("A Wondering Soul");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {

            return true;
        }
        displayTimer = 0;
        return false;
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(450, 30, "Find Dijkstra", "Arial", 30, g);

        }
        if(getState() == questState.inQuest){
            changeColor(white, g);
            drawText(450, 30, "Find the painting in the church", "Arial", 30, g);
        }
        if(getState() == questState.completedQuest){
            changeColor(white, g);
            drawText(450, 30, "Go to Camrath", "Arial", 30, g);
        }
        if(getState() == questState.extraQuest){
            changeColor(white, g);
            drawText(450, 30, "Return to Sevar", "Arial", 30, g);
        }
    }
}

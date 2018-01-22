import java.awt.*;

public class quest_TheMissingPeices extends Quest {

    boolean displayReward;

    int orbsCollected;

    quest_TheMissingPeices(){
        orbsCollected = 0;
        setQuestName("The Missing Peices");
        state = questState.inQuest;
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
        if(getState() == questState.inQuest) {
            changeColor(red, g);
            drawText(450, 30, orbsCollected +"/7 Orbs Collected", "Arial", 30, g);

        }

    }

}

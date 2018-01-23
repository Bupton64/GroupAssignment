import java.awt.*;

public class quest_ASpyInTheClutches extends Quest {
    boolean displayReward;

    quest_ASpyInTheClutches(){
        setQuestName("A Spy In The Clutches");
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
            drawText(450, 30, "Search Town for Clues", "Arial", 30, g);

        }

    }
}

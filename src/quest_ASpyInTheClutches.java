import java.awt.*;

public class quest_ASpyInTheClutches extends Quest {
    boolean displayReward;

    quest_ASpyInTheClutches(){
        setQuestName("The Road To Riches");
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
            drawText(450, 30, "Speak to the Blacksmith", "Arial", 30, g);
            if(displayReward){
                changeColor(white, g);
                drawBoldText(230, 300, "Quest Reward:", "Arial", 20, g);
                changeColor(purple, g);
                drawBoldText(360, 300, " +250 EXP", "Arial", 20, g);
            }
        }

    }
}

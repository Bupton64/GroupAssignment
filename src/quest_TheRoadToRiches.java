import java.awt.*;

public class quest_TheRoadToRiches extends Quest {



    boolean displayReward;

    quest_TheRoadToRiches(){
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
            drawText(450, 30, "Go talk to the blacksmith in the East", "Arial", 30, g);
            if(displayReward){
                changeColor(white, g);
                drawBoldText(230, 300, "Quest Reward:", "Arial", 20, g);
                changeColor(purple, g);
                drawBoldText(360, 300, " +250 EXP", "Arial", 20, g);
            }
        }

    }





}
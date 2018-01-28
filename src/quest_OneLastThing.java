
import java.awt.*;

public class quest_OneLastThing extends Quest {
    boolean displayReward;

    quest_OneLastThing(){



        setQuestName("One Last Thing");
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

    public void drawQuestReward(Graphics2D g){
        if(displayReward){
            super.drawQuestReward(g);
            changeColor(white, g);
            drawBoldText(310, 40, "Quest Reward", "Felix Titling", 18, g);
            //  changeColor(purple, g);
            drawBoldText(310, 60, "+1500 Gold", "Felix Titling", 16, g);
            drawBoldText(310, 80, "+1500 EXP", "Felix Titling", 16, g);
        }
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(40, 400, "Head to Sevars House", "Arial", 20, g);

        }
        if(getState() == questState.inQuest){
            changeColor(white, g);
            drawText(40, 400, "End Therox", "Arial", 20, g);
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


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

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(450, 30, "Head to Sevars House", "Arial", 30, g);

        }
        if(getState() == questState.inQuest){
            changeColor(white, g);
            drawText(450, 30, "End Therox", "Arial", 30, g);
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

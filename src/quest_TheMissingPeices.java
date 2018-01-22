import java.awt.*;

public class quest_TheMissingPeices extends Quest {

    boolean displayReward;









    quest_TheMissingPeices(){
        collectableState = new boolean[7];
        for(int i = 0; i < 7;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 7;
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
            changeColor(white, g);
            drawText(450, 30, numOfCollectables +"/7 Orbs Collected", "Arial", 30, g);

        }
        if(getState() == questState.completedQuest){
            changeColor(white, g);
            drawText(450, 30, "Complete", "Arial", 30, g);
        }

    }

}

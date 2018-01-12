import java.awt.*;

public class quest_killingForWizard extends Quest {



    private int killCount; //<Amount of monsters killed
    private int toBeKilled;

    quest_killingForWizard(){
        setQuestName("killingForWizard");
        killCount = 0;
        toBeKilled = 5;
        setReward(100);
        setStage(0);
        state = questState.preQuest;
    }



    public void drawQuest(Graphics2D g){
        if(getState() == questState.inQuest) {
            changeColor(blue, g);
            drawText(510, 30, "Monsters killed: " + killCount + "/5", "Arial", 30, g);
        }
    }

    public void updateQuest(Monster mon, double mapLocation){
        if(mapLocation == 17) {
            killCount++;
        }
        if(killCount == 5){
            setState(questState.completedQuest);
        }

    }




}

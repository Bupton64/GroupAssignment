import java.awt.*;

public class quest_killingForWizard extends Quest {

    enum questState{preQuest, inQuest, completedQuest}
    questState state = questState.preQuest;

    private int killCount; //<Amount of monsters killed
    private int toBeKilled;
    private boolean questActive;

    quest_killingForWizard(){
        killCount = 0;
        toBeKilled = 5;
        questActive = true;
        setReward(100);
        setStage(0);

    }

    public void drawQuest(Graphics2D g){
        changeColor(white, g);
        drawText(700, 50, "Monsters killed: " + killCount + "/5", g);
    }

    public void updateQuest(){
        killCount++;
        if(killCount == 5){
            setStage(1);
        }
        if()
    }


}

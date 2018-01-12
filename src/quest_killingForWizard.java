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
        changeColor(white, g);
        drawText(510, 30, "Monsters killed: " + killCount + "/5", "Arial", 30, g);
    }

    public void updateQuest(Monster mon, Character playerMan){
        if(playerMan.getCurrentMapLocation() == 17) {
            killCount++;
        }
        if(killCount == 5){
            setState(questState.completedQuest);
        }

    }




}

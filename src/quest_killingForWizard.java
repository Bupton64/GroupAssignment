import java.awt.*;

public class quest_killingForWizard extends Quest {



    private int killCount; //<Amount of monsters killed
    private int toBeKilled;
    boolean questFinished;

    quest_killingForWizard(){
        setQuestName("killingForWizard");
        killCount = 0;
        toBeKilled = 5;
        questFinished = false;
        state = questState.preQuest;
    }

    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 250);
        playerMan.checkLevelUp();
        questFinished = true;
    }



    public void drawQuest(Graphics2D g){
        if(getState() == questState.inQuest) {
            changeColor(red, g);
            drawText(510, 30, "Monsters killed: " + killCount + "/5", "Arial", 30, g);
        }
        if(getState() == questState.completedQuest && !questFinished) {
            changeColor(red, g);
            drawText(510, 30, "Complete", "Arial", 30, g);
        }

    }



    public void updateKillQuest(Monster mon, double mapLocation,Character player){
        if(state == questState.inQuest) {
            if (mapLocation == 17) {
                killCount++;
            }
            if (killCount == 5) {
                setState(questState.completedQuest);
                player.setQuestStage(2);
            }
        }

    }




}

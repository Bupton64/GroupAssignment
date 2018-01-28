import java.awt.*;

public class quest_AWizardsProblem extends Quest {




    private int toBeKilled;
    boolean questFinished;

    quest_AWizardsProblem(){
        setQuestName("A Wizards Problem");
        killCount = 4;
        toBeKilled = 5;
        questFinished = false;
        state = questState.preQuest;
    }

    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 250);
        playerMan.checkLevelUp();
        questFinished = true;
    }

    public void drawQuestReward(Graphics2D g){

    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest){
            changeColor(white, g);
            drawText(40, 400, "Find the Wizard", "Arial", 20, g);
        }
        if(getState() == questState.inQuest) {
            changeColor(white, g);
            drawText(40, 400, "Monsters killed: " + killCount + "/5", "Arial", 20, g);
        }
        if(getState() == questState.completedQuest && !questFinished) {
            changeColor(white, g);
            drawText(40, 400, "Return to wizard", "Arial", 20, g);
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

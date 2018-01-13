import java.awt.*;

public class quest_killingForWizard extends Quest {



    private int killCount; //<Amount of monsters killed
    private int toBeKilled;

    quest_killingForWizard(){
        setQuestName("killingForWizard");
        killCount = 0;
        toBeKilled = 5;
        state = questState.preQuest;
    }

    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 500);
        playerMan.checkLevelUp();
    }



    public void drawQuest(Graphics2D g){
        if(getState() == questState.inQuest) {
            changeColor(red, g);
            drawText(510, 30, "Monsters killed: " + killCount + "/5", "Arial", 30, g);
        }

    }

    public void updateTalkQuest(){
        if(state == questState.preQuest){
            state = questState.inQuest;
        }
    }

    public void updateKillQuest(Monster mon, double mapLocation){
        if(state == questState.inQuest) {
            if (mapLocation == 17) {
                killCount++;
            }
            if (killCount == 5) {
                setState(questState.completedQuest);
            }
        }

    }




}

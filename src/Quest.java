import java.awt.*;

public class Quest extends extraFunctions {
    //Members

    enum questState{preQuest, inQuest, completedQuest}
    questState state = questState.preQuest;

    private String questName; //<Name of the quest
    private int reward; //<How much is rewarded for completing each quest

    int displayTimer;
    int displayDuration;

    public String getQuestName() {
        return questName;
    }

    public int getReward() {
        return reward;
    }


    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }





    public questState getState() {
        return state;
    }

    public void setState(questState state) {
        this.state = state;
    }
    /*
     * Adds the reward to the players GP balance
     */
    public void giveReward(Character playerMan){

    }

    public void drawQuest(Graphics2D g){

    }



    public boolean updateRewardDisplay(double dt){
        displayTimer += dt;
        if(displayTimer > displayDuration){
            return false;
        }
        return true;

    }


    public void updateKillQuest(Monster mon, double mapLocation){


    }


}

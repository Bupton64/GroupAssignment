import java.awt.*;

public class Quest extends extraFunctions {
    //Members

    enum questState{preQuest, inQuest, completedQuest}
    questState state = questState.preQuest;

    private String questName; //<Name of the quest
    private int reward; //<How much is rewarded for completing each quest
    private int stage; //<What part of the quest the player is on

    public String getQuestName() {
        return questName;
    }

    public int getReward() {
        return reward;
    }

    public int getStage() {
        return stage;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setStage(int stage) {
        this.stage = stage;
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
        int temp = playerMan.getGpTotal() + reward;
        playerMan.setGpTotal(temp);
    }

    public void drawQuest(Graphics2D g){

    }

    public void updateQuest(Monster mon, double mapLocation){


    }
}

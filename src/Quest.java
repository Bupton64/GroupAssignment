import java.awt.*;

public class Quest extends extraFunctions {
    //Members

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
    /*
     * Adds the reward to the players GP balance
     */
    public void giveReward(Character playerMan){
        int temp = playerMan.getGpTotal() + reward;
        playerMan.setGpTotal(temp);
    }

    public void drawSuccess(Graphics2D g){
        drawBoldText(350, 300, "QUEST COMPLETE!", g);
    }
}

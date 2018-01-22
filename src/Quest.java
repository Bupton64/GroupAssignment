import java.awt.*;

public class Quest extends extraFunctions {
    //Members



    Quest(){
        displayTimer = 0;
        displayDuration = 5;


    }

    enum questState{preQuest, inQuest, completedQuest}
    questState state = questState.preQuest;

    private String questName; //<Name of the quest
    private int reward; //<How much is rewarded for completing each quest

    double displayTimer;
    double displayDuration;

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

    boolean[] collectableState;

    public boolean[] getCollectableState() {
        return collectableState;
    }

    public void setCollectableState(boolean collectableState, int index) {
        this.collectableState[index] = collectableState;
    }

    int numOfCollectables;

    int totalCollectables;

    public int getNumOfCollectables() {
        return numOfCollectables;
    }

    public void setNumOfCollectables(int numOfCollectables) {
        this.numOfCollectables = numOfCollectables;
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


        if(displayTimer < displayDuration){

            return true;
        }
        return false;

    }



    public void updateKillQuest(Monster mon, double mapLocation, Character player){


    }


}

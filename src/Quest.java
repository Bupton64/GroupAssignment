import java.awt.*;

public class Quest extends extraFunctions {
    //Members

    Image dialogueSpriteSheet;

    Image dialogueSimpleBox;

    Quest(){
        displayTimer = 0;
        displayDuration = 5;
        dialogueSpriteSheet = loadImage("dialogue_Boxes.png");
        dialogueSimpleBox = subImage(dialogueSpriteSheet,20,20,470,100);
        displayReward =false;
    }

    enum questState{preQuest, inQuest, completedQuest, extraQuest}
    questState state = questState.preQuest;

    private String questName; //<Name of the quest
    private int reward; //<How much is rewarded for completing each quest

    double displayTimer;
    double displayDuration;
    boolean displayReward;
    int numOfCollectables;
    int totalCollectables;

    int killCount; //<Amount of monsters killed

    boolean[] collectableState;

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



    public boolean[] getCollectableState() {
        return collectableState;
    }

    public void setCollectableState(boolean collectableState, int index) {
        this.collectableState[index] = collectableState;
    }

    public void setTotalCollectables(int totalCollectables) {
        this.totalCollectables = totalCollectables;
    }

    public int getTotalCollectables() {
        return totalCollectables;
    }

    public int getNumOfCollectables() {
        return numOfCollectables;
    }

    public void setNumOfCollectables(int numOfCollectables) {
        this.numOfCollectables = numOfCollectables;

    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
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

    public void drawQuestReward(Graphics2D g){
        if(displayReward) {
            drawImage(dialogueSimpleBox, 300, 1, 200, 100, g);
        }
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

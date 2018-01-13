import java.awt.*;

public class quest_talkToBlacksmith extends Quest {



    boolean displayReward;

    quest_talkToBlacksmith(){
        setQuestName("talkToBlacksmith");
        setReward(100);
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }

    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward) {
         displayReward = super.updateRewardDisplay(dt);
        }
        return true;
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.inQuest) {
            changeColor(blue, g);
            drawText(450, 30, "Go talk to the blacksmith in the East", "Arial", 30, g);
        }
        if(displayReward){
            changeColor(white, g);
            drawText(240, 330, "Quest Reward :", "Arial", 30, g);
            changeColor(purple, g);
            drawText(280, 330, " 500+ EXP", "Arial", 30, g);
        }
    }





}
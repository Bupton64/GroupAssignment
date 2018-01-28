
import java.awt.*;

public class quest_blankQuest extends Quest {



    private int killCount; //<Amount of monsters killed

    quest_blankQuest(){
        setState(questState.completedQuest);
        setQuestName("No Current Quest");

    }



    public void drawQuest(Graphics2D g){

    }
    public void drawQuestReward(Graphics2D g){
        if(displayReward) {

        }
    }

    public void updateQuest(){

    }


}


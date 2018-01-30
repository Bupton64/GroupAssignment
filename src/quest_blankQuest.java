
import java.awt.*;

public class quest_blankQuest extends Quest {



    private int killCount; //<Amount of monsters killed

    quest_blankQuest(){
        setState(questState.completedQuest);
        setQuestName("No Current Quest");

    }



    public void drawQuestReward(Graphics2D g){
        if(displayReward) {

        }
    }
    public void drawQuest(Graphics2D g){

        if(getState() == questState.completedQuest) {
            changeColor(black, g);
            drawText(40, 430, "Speak to some villagers", "Arial", 20, g);
        }



    }


    public void updateQuest(){

    }


}


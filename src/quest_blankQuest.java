
import java.awt.*;

public class quest_blankQuest extends Quest {



    private int killCount; //<Amount of monsters killed

    quest_blankQuest(){
        setState(questState.completedQuest);
        setQuestName("empty");

    }



    public void drawQuest(Graphics2D g){

    }

    public void updateQuest(){

    }


}


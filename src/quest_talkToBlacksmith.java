import java.awt.*;

public class quest_talkToBlacksmith extends Quest {





    quest_talkToBlacksmith(){
        setQuestName("talkToBlacksmith");
        setReward(100);
        setStage(0);
        state = questState.preQuest;
    }



    public void drawQuest(Graphics2D g){
        if(getState() == questState.inQuest) {
            changeColor(blue, g);
            drawText(450, 30, "Go talk to the blacksmith in the East", "Arial", 30, g);
        }
    }

    public void updateQuest(Monster mon, double mapLocation){

    }




}
import java.awt.*;

public class Dialogue extends extraFunctions{

    String dialogueOne;
    String dialogueTwo;
    String dialogueThree;
    String dialogueFour;

    boolean hasOptions;

    boolean lastNode;

    public Dialogue next;

    double optionPosX ;
    double optionPosY ;


    public Dialogue(Dialogue next,boolean hasOptions,boolean lastNode,String dialogueOne, String dialogueTwo, String dialogueThree, String dialogueFour){
        this.dialogueOne = dialogueOne;
        this.dialogueTwo = dialogueTwo;
        this.dialogueThree = dialogueThree;
        this.dialogueFour = dialogueFour;
        this.hasOptions = hasOptions;
        this.lastNode = lastNode;
        this.next = next;
        this.optionPosX = 415;
        this.optionPosY = 350;

    }

    public void changeOption(){
        if (optionPosY == 375) {

            optionPosY = 350;
        } else {
            optionPosY = 375;
        }

    }

    public double getOptionPosY() {
        return optionPosY;
    }

    public void setOptionPosY(double optionPosY) {
        this.optionPosY = optionPosY;
    }

    public boolean isHasOptions() {
        return hasOptions;
    }

    public void setHasOptions(boolean hasOptions) {
        this.hasOptions = hasOptions;
    }

    public void display(Graphics2D g){
        if(!lastNode){
            changeColor(black, g);
            drawSolidRectangle(400,345,300,50,g);
            changeColor(Color.white,g);
            drawRectangle(400,345,300,50,10,g);
            drawText(425, 375, "Press 'Space' to continue", "Arial", 20, g);
        }
        if(lastNode && !hasOptions){
            changeColor(black, g);
            drawSolidRectangle(400,345,300,50,g);
            changeColor(Color.white,g);
            drawRectangle(400,345,300,50,10,g);
            drawText(425, 375, "Press 'Space' to stop", "Arial", 20, g);
        }
        if(hasOptions){
            changeColor(black, g);
            drawSolidRectangle(400,325,300,70,g);
            changeColor(Color.white,g);
            drawRectangle(400,325,300,70,10,g);

            drawText(425, 380, "Accept", "Arial", 20, g);
            drawText(425, 355, "Decline", "Arial", 20, g);
            changeColor(green,g);
            drawSolidCircle(optionPosX,optionPosY,5,g);
        }
        drawText(110, 450, dialogueOne, "Times New Roman", 20, g);
        drawText(110, 475, dialogueTwo, "Times New Roman", 20, g);
        drawText(110, 500, dialogueThree, "Times New Roman", 20, g);
        drawText(110, 525, dialogueFour, "Times New Roman", 20, g);
    }





}




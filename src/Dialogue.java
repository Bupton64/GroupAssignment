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


    Image dialogueSpriteSheet;

    Image dialogueSimpleBox;
    Image dialogueContinueBox;

    public Dialogue(Dialogue next,boolean hasOptions,boolean lastNode,String dialogueOne, String dialogueTwo, String dialogueThree, String dialogueFour){
        dialogueSpriteSheet = loadImage("Image/dialogue_Boxes.png");
        dialogueSimpleBox = subImage(dialogueSpriteSheet,20,20,470,100);
        dialogueContinueBox = subImage(dialogueSpriteSheet,20,350,470,100);
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
        if(isHasOptions()) {
            if (optionPosY == 375) {

                optionPosY = 350;
            } else {
                optionPosY = 375;
            }
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
            drawImage(dialogueContinueBox,90,400,620,165,g);
            changeColor(Color.white,g);
            drawText(530, 540, "Press 'Space' to continue", "Arial", 10, g);

        }
        if(lastNode && !hasOptions){
            drawImage(dialogueSimpleBox,90,400,620,165,g);
            changeColor(white,g);



        }
        if(hasOptions){
            drawImage(dialogueSimpleBox,90,400,620,165,g);
            drawImage(dialogueSimpleBox,400,335,300,70,g);
            changeColor(white,g);
            drawText(425, 385, "Accept", "Arial", 20, g);
            drawText(425, 359, "Decline", "Arial", 20, g);
            changeColor(green,g);
            drawSolidCircle(optionPosX,optionPosY,5,g);
            changeColor(white,g);
        }
        drawText(110, 450, dialogueOne, "Times New Roman", 20, g);
        drawText(110, 475, dialogueTwo, "Times New Roman", 20, g);
        drawText(110, 500, dialogueThree, "Times New Roman", 20, g);
        drawText(110, 525, dialogueFour, "Times New Roman", 20, g);
    }





}




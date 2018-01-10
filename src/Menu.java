
import java.awt.*;
import java.awt.event.*;


public class Menu extends extraFunctions {

    Character playerMan= new Character();
    private boolean pause = false;
    public int cursorPositionY = 440;
    public boolean invMenu = false;
    public boolean equMenu = false;
    public boolean chaMenu = true;
    public void initMenu(){
        chaMenu = true;
        cursorPositionY = 440;
    }

    public void drawMenu(Graphics2D g) {
        if(chaMenu) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            changeColor(white,g);
            drawRectangle(0, 0, 400, 105, g);
            //drawBoldText(100, 100, Integer.toString(cursorPositionY));
            drawRectangle(620, 420, 179, 179, g);
            drawBoldText(650, 450, "RESUME", "New Roman Times", 20, g);
            drawBoldText(650, 480, "INVENTORY", "New Roman Times", 20, g);
            drawBoldText(650, 510, "EQUIPMENT", "New Roman Times", 20, g);
            drawBoldText(650, 540, "EXIT", "New Roman Times", 20,g );
            drawBoldText(3, 595, "MAP: "+playerMan.getCurrentMapLocation(), "New Roman Times", 15,g );
            drawBoldText(3, 35, playerMan.getName(), "Impact", 40,g );

            drawBoldText(3, 60,"HP   "+ Integer.toString((int)playerMan.getCurrentHP()), "New Roman Times", 20,g );

            drawBoldText(3, 80, "XP   "+ playerMan.getXPTotal(), "New Roman Times", 20,g);
            changeColor(green,g);
            drawBoldText(3, 100, "LVL "+ playerMan.getCurrentLevel(), "New Roman Times", 20,g);
            changeColor(white, g);
            drawRectangle(1, 458, 200, 62, g);
            drawBoldText(3, 450, "ATTACK "+ playerMan.getAttack(),"New Roman Times", 17,g );
            drawBoldText(3+150, 450, "DEFENCE "+ playerMan.getAttack(),"New Roman Times", 17,g );
            drawBoldText(3, 450+30, "STRENGTH "+ playerMan.getAttack(),"New Roman Times", 17,g );
            drawBoldText(3+150, 450+30, "SPEED "+ playerMan.getAttack(),"New Roman Times", 17,g );
            drawBoldText(3, 450+60, "LUCK "+ playerMan.getAttack(),"New Roman Times", 17,g );

            changeColor(green,g);
            drawBoldText(3, 575, "YOU NEED "+ playerMan.getXPToNextLevel()+" MORE XP TO LVL UP...", "New Roman Times", 15,g);


            changeColor(yellow,g);
            drawSolidCircle(640, cursorPositionY, 5,g);
        }else if(invMenu){
            clearBackground(800, 600,g);
            changeColor(white,g);
            drawBoldText(3, 40, "INVENTORY",g);
            drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15,g);
        }else if(equMenu){
            clearBackground(800, 600,g);
            changeColor(white, g);
            drawBoldText(3, 40, "EQUIPMENT",g);
            drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15,g);


        }


    }

    public void keyPressed(KeyEvent e) {

        if((e.getKeyCode() == KeyEvent.VK_DOWN)&&cursorPositionY<510){
            cursorPositionY+=30;

        }
        if((e.getKeyCode() == KeyEvent.VK_UP)&&cursorPositionY>450){
            cursorPositionY-=30;

        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&cursorPositionY==530){
            System.exit(23);
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&cursorPositionY==470){
            invMenu = true;
            equMenu = false;
            chaMenu = false;
        }
        if((e.getKeyCode() == KeyEvent.VK_SPACE)&&cursorPositionY==500){
            equMenu = true;
            invMenu = false;
            chaMenu = false;
        }


    }

}


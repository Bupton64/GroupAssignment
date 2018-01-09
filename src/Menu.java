
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
            clearBackground(800, 600,g);
            changeColor(black,g);
            //drawBoldText(100, 100, Integer.toString(cursorPositionY));
            drawBoldText(650, 450, "RESUME", "New Roman Times", 20, g);
            drawBoldText(650, 480, "INVENTORY", "New Roman Times", 20, g);
            drawBoldText(650, 510, "EQUIPMENT", "New Roman Times", 20, g);
            drawBoldText(650, 540, "EXIT", "New Roman Times", 20,g );
            drawBoldText(3, 595, "Current Map Number: "+playerMan.getCurrentMapLocation(), "New Roman Times", 15,g );
            drawBoldText(3, 30, playerMan.getName(), "Impact", 25,g );
            changeColor(red,g);
            drawBoldText(3, 50,"hp  "+ playerMan.getCurrentHP(), "New Roman Times", 15,g );
            changeColor(black,g);
            drawBoldText(3, 65, "xp "+ playerMan.getXPTotal(), "New Roman Times", 15,g);
            changeColor(blue,g);
            drawBoldText(3, 80, "lvl "+ playerMan.getCurrentLevel(), "New Roman Times", 15,g);

            changeColor(blue,g);
            drawBoldText(3, 575, "You need "+ playerMan.getXPToNextLevel()+" more xp to lvl up", "New Roman Times", 15,g);


            changeColor(red,g);
            drawSolidCircle(640, cursorPositionY, 5,g);
        }else if(invMenu){
            clearBackground(800, 600,g);
            changeColor(black,g);
            drawBoldText(100, 100, "Add Inventory here",g);
            drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15,g);
        }else if(equMenu){
            clearBackground(800, 600,g);
            changeColor(black, g);
            drawBoldText(100, 100, "Add Equipment here",g);
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


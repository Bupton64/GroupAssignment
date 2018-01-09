
import java.awt.*;
import java.awt.event.*;


public class Menu extends extraFunctions {
    public static void main(String[] args) {
        createGame( new Menu(),30);
    }
    Character playerMan;
    private boolean pause = false;
    private int cursorPosistionY = 440;
    private boolean invMenu = false;
    private boolean equMenu = false;
    private boolean chaMenu = true;
    public void init() {
        playerMan = new Character();
    }
    @Override
    public void update(double dt) {

    }
    @Override
    public void paintComponent() {
        if(AdventureMode.)
        if(chaMenu) {
            clearBackground(800, 600);
            changeColor(black);
            // drawBoldText(100, 100, Integer.toString(cursorPosistionY));
            drawBoldText(650, 450, "RESUME", "New Roman Times", 20);
            drawBoldText(650, 480, "INVENTORY", "New Roman Times", 20);
            drawBoldText(650, 510, "EQUIPMENT", "New Roman Times", 20);
            drawBoldText(650, 540, "EXIT", "New Roman Times", 20);
            drawBoldText(3, 595, "Current Map Number: "+playerMan.getCurrentMapLocation(), "New Roman Times", 15);
            drawBoldText(3, 30, playerMan.getName(), "Impact", 25);
            changeColor(red);
            drawBoldText(3, 50,"hp  "+ playerMan.getCurrentHP(), "New Roman Times", 15);
            changeColor(black);
            drawBoldText(3, 65, "xp "+ playerMan.getXPTotal(), "New Roman Times", 15);
            changeColor(blue);
            drawBoldText(3, 80, "lvl "+ playerMan.getCurrentLevel(), "New Roman Times", 15);

            changeColor(blue);
            drawBoldText(3, 575, "You need "+ playerMan.getXPToNextLevel()+" more xp to lvl up", "New Roman Times", 15);


            changeColor(red);
            drawSolidCircle(640, cursorPosistionY, 5);
        }else if(invMenu){
            clearBackground(800, 600);
            changeColor(black);
            drawBoldText(100, 100, "Add Inventory here");
            drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15);
        }else if(equMenu){
            clearBackground(800, 600);
            changeColor(black);
            drawBoldText(100, 100, "Add Equipment here");
            drawBoldText(3, 580, "BACK [ESC]", "New Roman Times", 15);


        }


    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(state == AdventureMode.GameState.TravelMode){
            playerMovement.keyReleased(e);
        }
        if(state == AdventureMode.GameState.CombatMode){
            playerMovement.keyReleased(e);
            combatMode.keyReleased(e);

        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE&&chaMenu == true){
            pause = !pause;
            chaMenu = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE&&chaMenu == false){
            chaMenu = true;
        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_DOWN)&&cursorPosistionY<510){
            cursorPosistionY+=30;

        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_UP)&&cursorPosistionY>450){
            cursorPosistionY-=30;

        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==440){
            pause = !pause;

        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==530){
            System.exit(23);
        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==470){
            invMenu = true;
            equMenu = false;
            chaMenu = false;
        }
        if(pause&&(e.getKeyCode() == KeyEvent.VK_ENTER)&&cursorPosistionY==500){
            equMenu = true;
            invMenu = false;
            chaMenu = false;
        }


    }

}


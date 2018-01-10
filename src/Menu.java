
import java.awt.*;
import java.awt.event.*;


public class Menu extends extraFunctions {

    Character playerMan= new Character();
    Image background;
    Image character;
    Image menuSprite = loadImage("menuSprite.png");
    Image characterSprite = loadImage("face.png");
    private boolean pause = false;
    public int cursorPositionY = 440;
    public boolean invMenu = false;
    public boolean equMenu = false;
    public boolean chaMenu = true;
    public void initMenu(){
        chaMenu = true;
        cursorPositionY = 440;
        background = subImage(menuSprite, 0, 0, 800, 600);
        character = subImage(characterSprite, 0, 0, 144, 144);

    }

    public void drawMenu(Graphics2D g) {
        if(chaMenu) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            drawImage(background , 0, 0, g);
            drawImage(character , 429, 97, 144, 144, g);
            changeColor(white,g);
            drawBoldText(650, 450, "RESUME", "Felix Titling", 20, g);
            drawBoldText(650, 480, "INVENTORY", "Felix Titling", 20, g);
            drawBoldText(650, 510, "EQUIPMENT", "Felix Titling", 20, g);
            drawBoldText(650, 540, "EXIT", "Felix Titling", 20,g );

            drawBoldText(3, 60, playerMan.getName(), "Felix Titling", 40,g );
            changeColor(red, g);
            drawBoldText(3, 85,"HP    "+ Integer.toString((int)playerMan.getCurrentHP()), "Felix Titling", 20,g );
            changeColor(green, g);
            drawBoldText(3, 105, "EXP   "+ playerMan.getXPTotal(), "Felix Titling", 20,g);
            changeColor(yellow,g);
            drawBoldText(3, 125, "LVL   "+ playerMan.getLevel(), "Felix Titling", 20,g);

            changeColor(white, g);
            drawBoldText(640, 50, "ATTACK :    "+ playerMan.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 80, "DEFENCE :   "+ playerMan.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 110, "STRENGTH : "+ playerMan.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 140, "SPEED :        "+ playerMan.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 170, "LUCK :        "+ playerMan.getAttack(),"Felix Titling", 17,g );

            changeColor(white,g);
            drawBoldText(3, 240, "TO NEXT LEVEL : ", "Felix Titling", 15,g);
            changeColor(green, g);
            drawBoldText(140, 240, playerMan.getXPToNextLevel()+" EXP", "Felix Titling", 15, g);


            changeColor(red,g);
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


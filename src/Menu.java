
import java.awt.*;
import java.awt.event.*;


public class Menu extends extraFunctions {
    Menu(Character playerMan){
        this.player1 = playerMan;
    }
    Character player1;
    Image background1;
    Image background2;
    Image background3;
    Image marker;
    Image character;
    Image menuSprite = loadImage("menuSprite.png");
    Image inventorySprite = loadImage("inventorySprite.png");
    Image equipmentSprite = loadImage("equipmentSprite.png");
    Image characterSprite = loadImage("face.png");
    Image arrow = loadImage("arrowhead.png");
    private boolean pause = false;
    public int cursorPositionY = 440;
    public boolean invMenu = false;
    public boolean equMenu = false;
    public boolean chaMenu = true;
    public void initMenu(){
        chaMenu = true;
        cursorPositionY = 440;
        background1 = subImage(menuSprite, 0, 0, 800, 600);
        background2 = subImage(inventorySprite, 0, 0, 800, 600);
        background3 = subImage(equipmentSprite, 0, 0, 800, 600);
        character = subImage(characterSprite, 0, 0, 144, 144);
        marker = subImage(arrow, 291, 100, 45, 40);

    }

    public void drawMenu(Graphics2D g) {
        if(chaMenu) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            drawImage(background1 , 0, 0, g);
            drawImage(character , 429, 97, 144, 144, g);
            changeColor(white,g);
            drawBoldText(650, 450, "RESUME", "Felix Titling", 20, g);
            drawBoldText(650, 480, "INVENTORY", "Felix Titling", 20, g);
            drawBoldText(650, 510, "EQUIPMENT", "Felix Titling", 20, g);
            drawBoldText(650, 540, "EXIT", "Felix Titling", 20,g );

            drawBoldText(3, 60, player1.getName(), "Felix Titling", 40,g );
            changeColor(red, g);
            drawBoldText(3, 85,"HP    "+ Integer.toString((int)player1.getCurrentHP()), "Felix Titling", 20,g );
            changeColor(green, g);
            drawBoldText(3, 105, "EXP   "+ player1.getXPTotal(), "Felix Titling", 20,g);
            changeColor(yellow,g);
            drawBoldText(3, 125, "LVL   "+ player1.getLevel(), "Felix Titling", 20,g);

            changeColor(white, g);
            drawBoldText(640, 50, "ATTACK :    "+ player1.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 80, "DEFENCE :   "+ player1.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 110, "STRENGTH : "+ player1.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 140, "SPEED :        "+ player1.getAttack(),"Felix Titling", 17,g );
            drawBoldText(640, 170, "LUCK :        "+ player1.getAttack(),"Felix Titling", 17,g );

            changeColor(white,g);
            drawBoldText(3, 240, "TO NEXT LEVEL : ", "Felix Titling", 15,g);
            changeColor(green, g);
            drawBoldText(140, 240, player1.getXPToNextLevel()+" EXP", "Felix Titling", 15, g);


            changeColor(red,g);
            drawImage(marker, 640-30, cursorPositionY-15, 32, 28,  g);

        }else if(invMenu){
            clearBackground(800, 600,g);
            drawImage(background2, 0, 0, g);
            changeColor(white,g);
            drawBoldText(3, 480, "Inventory : " + player1.getInventorySize() +"/"+ player1.getMaxInventorySize(), "Felix Titling", 15, g );
            for(int i = 0; i<player1.getInventorySize(); i++){
              //  drawBoldText(3, 100)
            }



            drawBoldText(500, 570, "INVENTORY","Felix Titling", 40, g);
            drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15,g);
        }else if(equMenu){
            clearBackground(800, 600,g);
            drawImage(background3, 0, 0, g);
            changeColor(white, g);
            drawBoldText(500, 40, "EQUIPMENT","Felix Titling", 40, g);
            drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15,g);


        }


    }

    public void keyPressed(KeyEvent e) {
      if(chaMenu) {
          if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 510) {
              cursorPositionY += 30;

          }
          if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 450) {
              cursorPositionY -= 30;

          }
          if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 530) {
              System.exit(23);
          }
          if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 470) {
              invMenu = true;
              equMenu = false;
              chaMenu = false;
          }
          if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 500) {
              equMenu = true;
              invMenu = false;
              chaMenu = false;
          }
      }else if(invMenu){

      }else{

      }


    }

}


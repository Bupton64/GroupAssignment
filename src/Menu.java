
import java.awt.*;
import java.awt.event.*;
import java.lang.String;


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
    private int cursorPositionY = 440;
    private boolean invMenu = false;
    private boolean equMenu = false;
    private boolean chaMenu = true;

    public boolean isChaMenu() {
        return chaMenu;
    }

    public int getCursorPositionY() {
        return cursorPositionY;
    }

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
            drawBoldText(640, 80, "DEFENCE :   "+ player1.getDefense(),"Felix Titling", 17,g );
            drawBoldText(640, 110, "STRENGTH : "+ player1.getStrength(),"Felix Titling", 17,g );
            drawBoldText(640, 140, "SPEED :        "+ player1.getSpeed(),"Felix Titling", 17,g );
            drawBoldText(640, 170, "LUCK :        "+ player1.getLuck(),"Felix Titling", 17,g );

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
               drawBoldText(3, 50, player1.getInventory()[i].getName(), "Felix Titling", 20, g  );
               drawBoldText(100, 50," X " +player1.getInventory()[i].getCounter(), "Felix Titling", 20, g );
            }




            drawBoldText(500, 570, "INVENTORY","Felix Titling", 40, g);
            drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15,g);
        }else if(equMenu){
            clearBackground(800, 600,g);
            drawImage(background3, 0, 0, g);
            changeColor(white, g);
            drawBoldText(500, 40, "EQUIPMENT","Felix Titling", 40, g);
            drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15,g);

            drawBoldText(3, 50, "HEAD :", "Felix Titling", 15,g);
            drawBoldText(3, 100, "WEAPON :", "Felix Titling", 15,g);
            drawBoldText(3, 150, "OFFHAND :", "Felix Titling", 15,g);
            drawBoldText(3, 200, "CHEST :", "Felix Titling", 15,g);
            drawBoldText(3, 300, "FEET :", "Felix Titling", 15,g);
            drawBoldText(3, 350, "ACCESSORY :", "Felix Titling", 15,g);
            drawBoldText(3, 400, "BAG :", "Felix Titling", 15,g);



            for(int i = 0; i< player1.getEquipmentSize(); i++){

                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.head) {
                    drawBoldText(100, 50, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }
                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.weapon) {
                    drawBoldText(100, 100, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }
                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.offhand) {
                    drawBoldText(100, 150, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }
                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.chest) {
                    drawBoldText(100, 200, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }
                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.feet) {
                    drawBoldText(100, 300, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }
                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.accessory) {
                    drawBoldText(100, 350, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }
                if(player1.getEquippedItems()[i].getSlot() == Item.Slot.bag) {
                    drawBoldText(100, 400, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                }

            }
            drawBoldText(3, 480, "Equipped : "+player1.getEquipmentSize()+ " / 6", "Felix Titling", 15, g );


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

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !chaMenu) {
            chaMenu = true;
        }
    }

}


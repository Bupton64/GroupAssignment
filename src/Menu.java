
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
    Image leftArrow;
    Image rightArrow;
    Image menuSprite = loadImage("menuSprite.png");
    Image inventorySprite = loadImage("inventorySprite.png");
    Image equipmentSprite = loadImage("equipmentSprite.png");
    Image characterSprite = loadImage("face.png");
    Image arrow1 = loadImage("arrowhead.png");
    Image arrow2 = loadImage("arrowhead.png");
    private boolean pause = false;
    private int cursorPositionY = 440;
    private boolean invMenu = false;
    private boolean equMenu = false;
    private boolean chaMenu = true;
    private boolean Using = true;
    private int index = 0;
    private boolean h = false;
    private boolean w = false;
    private boolean o = false;
    private boolean c = false;
    private boolean f = false;
    private boolean a = false;
    private int num =0 ;
    private boolean RA = false;
    private boolean LA = false;
    private int checkRightEquippable(){
        for(int i= 0; i<player1.getInventorySize(); i++){
            if(player1.getInventory()[i].isEquippable()){
                if(index !=i) {
                    if(index<i) {
                        index = i;
                        return i;

                    }
                }
            }
        }
        return index;
    }
    private int checkLeftEquippable() {
        for(int i = player1.getInventorySize(); i>-1; i--){
            if(player1.getInventory()[i].isEquippable()){
                if(index != i){
                    if(index>i){
                        index = i;
                        return i;
                    }
                }
            }
        }
        return index;
    }
    private int equippableSize(){
        int num = 0;
        for(int i=0; i<player1.getInventorySize(); i++){
            if(player1.getInventory()[i].isEquippable()){
                num++;
            }
        }
        return num;
    }
    private void arrowCheck(){
        //if()
    }

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
        marker = subImage(arrow1, 291, 100, 45, 40);
        rightArrow = subImage(arrow1, 291, 100, 45, 40);
        leftArrow = subImage(arrow2, 291, 55, 45, 40);

    }


    public void drawChaMenu(Graphics2D g){
        if (chaMenu == true) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            drawImage(background1, 0, 0, g);
            drawImage(character, 429, 97, 144, 144, g);
            changeColor(white, g);
            drawBoldText(650, 450, "RESUME", "Felix Titling", 20, g);
            drawBoldText(650, 480, "INVENTORY", "Felix Titling", 20, g);
            drawBoldText(650, 510, "EQUIPMENT", "Felix Titling", 20, g);
            drawBoldText(650, 540, "EXIT", "Felix Titling", 20, g);

            drawBoldText(3, 60, player1.getName(), "Felix Titling", 40, g);
            changeColor(red, g);
            drawBoldText(3, 85, "HP    " + Integer.toString((int) player1.getCurrentHP()), "Felix Titling", 20, g);

            drawSolidRectangle(110, 72, 100 / player1.getMaxHP() * player1.getCurrentHP(), 9, g);
            changeColor(white, g);
            drawRectangle(110, 72, 100, 9, 1, g);

            changeColor(green, g);
            drawBoldText(3, 105, "EXP   " + player1.getXPTotal(), "Felix Titling", 20, g);
            drawSolidRectangle(105 + ((player1.getXPToNextLevel() / 100)), 92, ((float) (player1.getXPTotal()) / (float) (player1.getXPToNextLevel())) * 100, 9, g);
            changeColor(white, g);
            drawRectangle(105 + ((player1.getXPToNextLevel() / 100)), 92, 100, 9, 1, g);
            changeColor(cyan, g);
            drawBoldText(3, 125, "LVL   " + player1.getLevel(), "Felix Titling", 20, g);
            changeColor(yellow, g);
            drawBoldText(3, 145, "GOLD  " + player1.getGpTotal(), "Felix Titling", 15, g);

            changeColor(white, g);
            drawBoldText(605, 50, "ATTACK : ", "Felix Titling", 17, g);
            drawBoldText(725, 50, Integer.toString(player1.getAttack() + player1.getEquipAttackBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 80, "DEFENCE : ", "Felix Titling", 17, g);
            drawBoldText(725, 80, Integer.toString(player1.getDefense() + player1.getEquipDefenseBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 110, "STRENGTH : ", "Felix Titling", 17, g);
            drawBoldText(725, 110, Integer.toString(player1.getStrength() + player1.getEquipStrengthBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 140, "SPEED : ", "Felix Titling", 17, g);
            drawBoldText(725, 140, Integer.toString(player1.getSpeed() + player1.getEquipSpeedBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 170, "LUCK : ", "Felix Titling", 17, g);
            drawBoldText(725, 170, Integer.toString(player1.getLuck() + player1.getEquipLuckBonus()), "Felix Titling", 17, g);
            changeColor(yellow, g);
            changeColor(white, g);
            drawBoldText(3, 240, "TO NEXT LEVEL : ", "Felix Titling", 15, g);
            changeColor(green, g);
            drawBoldText(140, 240, player1.getXPToNextLevel() + " EXP", "Felix Titling", 15, g);
            changeColor(red, g);
            drawImage(marker, 640 - 30, cursorPositionY - 15, 32, 28, g);
        }
    }

    public void drawInvMenu(Graphics2D g) {
        if (invMenu) {
            clearBackground(800, 600, g);
            drawImage(background2, 0, 0, g);
            changeColor(white, g);
            drawBoldText(3, 480, "Inventory : " + player1.getInventorySize() + "/" + player1.getMaxInventorySize(), "Felix Titling", 15, g);
            for (int i = 0; i < player1.getInventorySize(); i++) {
                drawBoldText(3, 50 + (i * 30), player1.getInventory()[i].getName(), "Felix Titling", 20, g);
                if (player1.getInventory()[i].getCounter() != 0) {
                    drawBoldText(730, 50 + (i * 30), " X " + Integer.toString(player1.getInventory()[i].getCounter()), "Felix Titling", 20, g);
                }
            }
            drawSolidRectangle(175, 530, 250, 45, g);
            if (index > 0) {
                drawImage(leftArrow, 125, 530, g);
            }
            if (index < player1.getInventorySize() - 1) {
                drawImage(rightArrow, 428, 530, g);
            }
            if (index >= player1.getInventorySize()) {
                index--;
            }
            changeColor(black, g);

            drawBoldText(180, 560, player1.getInventory()[index].getName(), "Felix Titling", 20, g);
            if (player1.getInventory()[index].getCounter() != 0) {
                drawBoldText(370, 560, " X " + Integer.toString(player1.getInventory()[index].getCounter()), "Felix Titling", 20, g);
            }
            changeColor(white, g);


            drawBoldText(500, 570, "INVENTORY", "Felix Titling", 40, g);
            drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15, g);
        }
    }









    public void drawEquMenu(Graphics2D g) {
        if (equMenu) {

                clearBackground(800, 600, g);
                drawImage(background3, 0, 0, g);
                changeColor(white, g);
                drawBoldText(500, 40, "EQUIPMENT", "Felix Titling", 40, g);
                drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15, g);
                changeColor(green, g);
                drawBoldText(3, 40, "EQUIPPED", "Felix Titling", 20, g);
                changeColor(white, g);
                drawBoldText(3, 100, "HEAD :", "Felix Titling", 15, g);
                drawBoldText(3, 125, "WEAPON :", "Felix Titling", 15, g);
                drawBoldText(3, 150, "OFFHAND :", "Felix Titling", 15, g);
                drawBoldText(3, 175, "CHEST :", "Felix Titling", 15, g);
                drawBoldText(3, 200, "FEET :", "Felix Titling", 15, g);
                drawBoldText(3, 225, "ACCESSORY :", "Felix Titling", 15, g);


                changeColor(cyan, g);

                for (int i = 0; i < player1.getEquipmentSize(); i++) {
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.head) {
                        h = true;
                        drawBoldText(150, 100, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.weapon) {
                        w = true;
                        drawBoldText(150, 125, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.offhand) {
                        o = true;
                        drawBoldText(150, 150, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.chest) {
                        c = true;
                        drawBoldText(150, 175, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.feet) {
                        f = true;
                        drawBoldText(150, 200, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.accessory) {
                        a = true;
                        drawBoldText(150, 225, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }

                }


                changeColor(red, g);
                if (h == false) {
                    drawBoldText(150, 100, "None", "Felix Titling", 15, g);
                }
                if (w == false) {
                    drawBoldText(150, 125, "None", "Felix Titling", 15, g);
                }
                if (o == false) {
                    drawBoldText(150, 150, "None", "Felix Titling", 15, g);
                }
                if (c == false) {
                    drawBoldText(150, 175, "None", "Felix Titling", 15, g);
                }
                if (f == false) {
                    drawBoldText(150, 200, "None", "Felix Titling", 15, g);
                }
                if (a == false) {
                    drawBoldText(150, 225, "None", "Felix Titling", 15, g);
                }


                changeColor(white, g);
                drawBoldText(295, 235, "EQUIPPED : " + player1.getEquipmentSize() + " / 6", "Felix Titling", 15, g);
                changeColor(green, g);
                drawBoldText(3, 285, "UNEQUIPPED:", "Felix Titling", 20, g);
                changeColor(white, g);
                int num =0;
                for (int i = 0; i < player1.getInventorySize(); i++) {

                    if ((player1.getInventory()[i].isEquippable())) {
                        drawBoldText(3, 310 + (35 * (i-num)), player1.getInventory()[i].getName(), "Felix Titling", 15, g);
                    }else{
                        num++;
                    }
                }

                changeColor(white, g);
                changeColor(white, g);
                drawSolidRectangle(515, 300, 220, 220, g);
                drawSolidRectangle(515, 60, 220, 210, g);


                if (player1.getInventory()[index].isEquippable()) {
                    changeColor(black, g);
                    drawBoldText(520, 80, "CHARACTER:", "Felix Titling", 20, g);

                    drawBoldText(520, 105, "ATK", "Felix Titling", 15, g);
                    drawBoldText(520, 105 + 30, "DEF", "Felix Titling", 15, g);
                    drawBoldText(520, 105 + 60, "STR", "Felix Titling", 15, g);
                    drawBoldText(520, 105 + 90, "SPD", "Felix Titling", 15, g);
                    drawBoldText(520, 105 + 120, "LUK", "Felix Titling", 15, g);

                    drawBoldText(680, 105, Integer.toString(player1.getAttack() + player1.getEquipAttackBonus()), "Felix Titling", 18, g);
                    drawBoldText(680, 105 + 30, Integer.toString(player1.getDefense() + player1.getEquipDefenseBonus()), "Felix Titling", 18, g);
                    drawBoldText(680, 105 + 60, Integer.toString(player1.getStrength() + player1.getEquipStrengthBonus()), "Felix Titling", 18, g);
                    drawBoldText(680, 105 + 90, Integer.toString(player1.getSpeed() + player1.getEquipSpeedBonus()), "Felix Titling", 18, g);
                    drawBoldText(680, 105 + 120, Integer.toString(player1.getLuck() + player1.getEquipLuckBonus()), "Felix Titling", 18, g);

                    for (int i = 0; i < player1.getEquipmentSize(); i++) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "weapon") {
                            if (player1.getInventory()[index].getSlot().name() == "weapon") {

                                if (player1.getEquippedItems()[i].getAttack() <= player1.getInventory()[index].getAttack()) {
                                    changeColor(green, g);
                                    drawBoldText(700, 105, "+" + (((player1.getInventory()[index].getAttack()) - player1.getEquippedItems()[i].getAttack())), "Felix Titling", 18, g);
                                } else {
                                    changeColor(red, g);
                                    drawBoldText(700, 105, "-" + (((player1.getInventory()[index].getAttack()) - player1.getEquippedItems()[i].getAttack())), "Felix Titling", 18, g);
                                }

                                if (player1.getEquippedItems()[i].getDefense() <= player1.getInventory()[index].getDefense()) {
                                    changeColor(green, g);
                                    drawBoldText(700, 105 + 30, "+" + (((player1.getInventory()[index].getDefense()) - player1.getEquippedItems()[i].getDefense())), "Felix Titling", 18, g);
                                } else {
                                    changeColor(red, g);
                                    drawBoldText(700, 105 + 30, "-" + (((player1.getInventory()[index].getDefense()) - player1.getEquippedItems()[i].getDefense())), "Felix Titling", 18, g);
                                }

                                if (player1.getEquippedItems()[i].getStrength() <= player1.getInventory()[index].getStrength()) {
                                    changeColor(green, g);
                                    drawBoldText(700, 105 + 60, "+" + (((player1.getInventory()[index].getStrength()) - player1.getEquippedItems()[i].getStrength())), "Felix Titling", 18, g);
                                } else {
                                    changeColor(red, g);
                                    drawBoldText(700, 105 + 60, "-" + (((player1.getInventory()[index].getStrength()) - player1.getEquippedItems()[i].getStrength())), "Felix Titling", 18, g);
                                }
                                if (player1.getEquippedItems()[i].getSpeed() <= player1.getInventory()[index].getSpeed()) {
                                    changeColor(green, g);
                                    drawBoldText(700, 105 + 90, "+" + (((player1.getInventory()[index].getSpeed()) - player1.getEquippedItems()[i].getSpeed())), "Felix Titling", 18, g);
                                } else {
                                    changeColor(red, g);
                                    drawBoldText(700, 105 + 90, "-" + (((player1.getInventory()[index].getSpeed()) - player1.getEquippedItems()[i].getSpeed())), "Felix Titling", 18, g);
                                }
                                if (player1.getEquippedItems()[i].getLuck() <= player1.getInventory()[index].getLuck()) {
                                    changeColor(green, g);
                                    drawBoldText(700, 105 + 120, "+" + (((player1.getInventory()[index].getLuck()) - player1.getEquippedItems()[i].getLuck())), "Felix Titling", 18, g);
                                } else {
                                    changeColor(red, g);
                                    drawBoldText(700, 105 + 120, "-" + (((player1.getInventory()[index].getLuck()) - player1.getEquippedItems()[i].getLuck())), "Felix Titling", 18, g);
                                }

                            }

                        } else if (i == player1.getEquipmentSize() - 1) {
                            changeColor(blue, g);
                            drawBoldText(700, 105, "+" + player1.getInventory()[index].getAttack(), "Felix Titling", 18, g);
                            drawBoldText(700, 105 + 30, "+" + player1.getInventory()[index].getDefense(), "Felix Titling", 18, g);
                            drawBoldText(700, 105 + 60, "+" + player1.getInventory()[index].getStrength(), "Felix Titling", 18, g);
                            drawBoldText(700, 105 + 90, "+" + player1.getInventory()[index].getSpeed(), "Felix Titling", 18, g);
                            drawBoldText(700, 105 + 120, "+" + player1.getInventory()[index].getLuck(), "Felix Titling", 18, g);
                        }
                    }
                }


                changeColor(yellow, g);
                drawBoldText(520, 290, player1.getInventory()[index].getName(), "Felix Titling", 15, g);
//                changeColor(purple, g);
//                drawBoldText(520, 175, "INFO:", "Felix Titling", 25, g  );
                changeColor(black, g);
                drawBoldText(520, 325, player1.getInventory()[index].getSlot().name() + " ITEM", "Felix Titling", 15, g);
                changeColor(cyan, g);
                drawBoldText(520, 350, player1.getInventory()[index].getTooltip() + " .", "Felix Titling", 12, g);
//                changeColor(black, g);
//                drawBoldText(520, 360, "STATS:", "Felix Titling", 25, g );
                changeColor(blue, g);
                drawBoldText(705, 375, Integer.toString(player1.getInventory()[index].getAttack()), "Felix Titling", 15, g);
                drawBoldText(705, 375 + 30, Integer.toString(player1.getInventory()[index].getDefense()), "Felix Titling", 15, g);
                drawBoldText(705, 375 + 60, Integer.toString(player1.getInventory()[index].getStrength()), "Felix Titling", 15, g);
                drawBoldText(705, 375 + 90, Integer.toString(player1.getInventory()[index].getSpeed()), "Felix Titling", 15, g);
                drawBoldText(705, 375 + 120, Integer.toString(player1.getInventory()[index].getLuck()), "Felix Titling", 15, g);
                changeColor(red, g);
                drawBoldText(520, 375, "ATK", "Felix Titling", 15, g);
                drawBoldText(520, 375 + 30, "DEF", "Felix Titling", 15, g);
                drawBoldText(520, 375 + 60, "STR", "Felix Titling", 15, g);
                drawBoldText(520, 375 + 90, "SPD", "Felix Titling", 15, g);
                drawBoldText(520, 375 + 120, "LUK", "Felix Titling", 15, g);


                changeColor(grey, g);
                drawBoldText(520, 515, "PRESS <SPACE> TO EQUIP ITEM.", "Felix Titling", 12, g);
                if (equippableSize()>1) {
                    drawImage(leftArrow, 460, 265, g);
                    drawImage(rightArrow, 460 + 290, 265, g);
                }
                if(index == player1.getInventorySize()){
                    index = 0;
                }
            }
           // changeColor(green, g);
            //drawBoldText(100, 100, Integer.toString(index), g);

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
          if((e.getKeyCode() == KeyEvent.VK_RIGHT)){
             if(index<player1.getInventorySize()-1){
                 index++;
             }
          }
          if((e.getKeyCode() == KeyEvent.VK_LEFT)){
              if(index>0){
                  index--;
              }
          }
          if(e.getKeyCode() == KeyEvent.VK_SPACE){
              if(player1.getInventory()[index].getName() == "Potion"){
                  player1.getInventory()[index].use(player1);
              }
              if((player1.getInventory()[index].getName() == "Rusty Sword")||(player1.getInventory()[index].getName() == "Iron Sword")){
                  equMenu = true;
                  invMenu = false;

              }
          }

      }else{
          if((e.getKeyCode() == KeyEvent.VK_RIGHT)){
              index = checkRightEquippable();
          }
          if((e.getKeyCode() == KeyEvent.VK_LEFT)){
              index = checkLeftEquippable();
          }

          if(e.getKeyCode() == KeyEvent.VK_SPACE){
              player1.equipItem(player1.getInventory()[index]);
              index = checkRightEquippable();
              index = checkLeftEquippable();
          }

      }


    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !chaMenu) {
            chaMenu = true;
            invMenu = false;
            equMenu = false;


        }
    }

}


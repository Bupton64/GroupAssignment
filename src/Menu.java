
import java.awt.*;
import java.awt.event.*;
import java.lang.String;


public class Menu extends extraFunctions {
    Menu(Character playerMan) {
        this.player1 = playerMan;
        initMenu();
    }

    Character player1;
    Image background1;
    Image background2;
    Image background3;
    Image statBackground;
    Image marker;
    Image character;
    Image leftArrow;
    Image rightArrow;
    Image scrollBackground;
    Image menuSprite = loadImage("menuSprite.png");
    Image inventorySprite = loadImage("inventorySprite.png");
    Image equipmentSprite = loadImage("equipmentSprite.png");
    Image characterSprite = loadImage("face.png");
    Image arrow1 = loadImage("arrowhead.png");
    Image arrow2 = loadImage("arrowhead.png");
    Image paper = loadImage("paper.png");
    Image paper2 = loadImage("paper2.png");
    Image book = loadImage("open.png");
    Image Book;
    private int cursorPositionY = 440;
    private boolean invMenu = false;
    private boolean equMenu = false;
    private boolean chaMenu = true;
    private int index = 0;
    private int index2 = 0;
    private boolean h = false;
    private boolean w = false;
    private boolean o = false;
    private boolean c = false;
    private boolean f = false;
    private boolean a = false;
    boolean isHead = false;
    boolean isWeapon = false;
    boolean isOffhand = false;
    boolean isChest = false;
    boolean isFeet = false;
    boolean isAccessory = false;
    boolean none = false;
    int scroller = 100;
    boolean nextPage = false;
    int bar = 0;
    int increaser = 0;
    int pos = 0;
    int pageNum = 1;
    int totalPages = 0;
    int scroller2 = 0;
    int scroller3 = 110;
    boolean slotSelect = true;
    boolean itemSelect = false;
    boolean stopper3 = false;

    int firstHead = 0;
    int firstWeapon = 0;
    int firstOffhand = 0;
    int firstChest = 0;
    int firstFeet = 0;
    int firstAccessory = 0;
    boolean firstTime = true;
    int limit = 375;
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int num5 = 0;
    int num6 = 0;
    boolean stopper = false;
    boolean stopper2 = false;
    boolean isEquiblableItems = false;

    public void drawMenu(Graphics2D g){
        drawChaMenu(g);
        drawEquMenu(g);
        drawInvMenu(g);
    }


    private int checkRightItemEquip(String name) {
        for (int i = 0; i < player1.getInventorySize(); i++) {
            if ((player1.getInventory()[i].getSlot().name() == name) && (player1.getInventory()[i].isEquippable())) {
                if (index != i) {
                    if (index < i) {
                        index = i;
                        return i;

                    }
                }
            }
        }
        return index;
    }

    private int checkLeftItemEquip(String temp) {
        for (int i = player1.getInventorySize() - 1; i > -1; i--) {
            if ((player1.getInventory()[i].getSlot().name() == temp)) {
                if (index != i) {
                    if (index > i) {
                        index = i;
                        return i;
                    }
                }
            }
        }
        return index;
    }


    private int checkRightEquippable() {
        for (int i = 0; i < player1.getInventorySize(); i++) {
            if (player1.getInventory()[i].isEquippable()) {
                if (index != i) {
                    if (index < i) {
                        index = i;
                        return i;

                    }
                }
            }
        }
        return index;
    }

    private int checkLeftEquippable() {
        for (int i = player1.getInventorySize(); i > -1; i--) {
            if (player1.getInventory()[i].isEquippable()) {
                if (index != i) {
                    if (index > i) {
                        index = i;
                        return i;
                    }
                }
            }
        }
        return index;
    }

    private int equippableSize() {
        int num = 0;
        for (int i = 0; i < player1.getInventorySize(); i++) {
            if (player1.getInventory()[i].isEquippable()) {
                num++;
            }
        }
        return num;
    }

    void stats(String name, Graphics2D g) {


        for (int i = 0; i < player1.getEquipmentSize(); i++) {
            if (player1.getEquippedItems()[i].getSlot().name() == name) {
                if (player1.getInventory()[index].getSlot().name() == name) {
                    if (player1.getEquippedItems()[i].getAttack() <= player1.getInventory()[index].getAttack()) {
                        changeColor(blue, g);
                        drawBoldText(220, 350, "+" + (((player1.getInventory()[index].getAttack()) - player1.getEquippedItems()[i].getAttack())), "Felix Titling", 18, g);
                    } else {
                        changeColor(red, g);
                        drawBoldText(220, 350, "-" + (((player1.getInventory()[index].getAttack()) - player1.getEquippedItems()[i].getAttack())), "Felix Titling", 18, g);
                    }

                    if (player1.getEquippedItems()[i].getDefense() <= player1.getInventory()[index].getDefense()) {
                        changeColor(blue, g);
                        drawBoldText(220, 350 + 30, "+" + (((player1.getInventory()[index].getDefense()) - player1.getEquippedItems()[i].getDefense())), "Felix Titling", 18, g);
                    } else {
                        changeColor(red, g);
                        drawBoldText(220, 350 + 30, "-" + (((player1.getInventory()[index].getDefense()) - player1.getEquippedItems()[i].getDefense())), "Felix Titling", 18, g);
                    }

                    if (player1.getEquippedItems()[i].getStrength() <= player1.getInventory()[index].getStrength()) {
                        changeColor(blue, g);
                        drawBoldText(220, 350 + 60, "+" + (((player1.getInventory()[index].getStrength()) - player1.getEquippedItems()[i].getStrength())), "Felix Titling", 18, g);
                    } else {
                        changeColor(red, g);
                        drawBoldText(220, 350 + 60, "-" + (((player1.getInventory()[index].getStrength()) - player1.getEquippedItems()[i].getStrength())), "Felix Titling", 18, g);
                    }
                    if (player1.getEquippedItems()[i].getSpeed() <= player1.getInventory()[index].getSpeed()) {
                        changeColor(blue, g);
                        drawBoldText(220, 350 + 90, "+" + (((player1.getInventory()[index].getSpeed()) - player1.getEquippedItems()[i].getSpeed())), "Felix Titling", 18, g);
                    } else {
                        changeColor(red, g);
                        drawBoldText(220, 350 + 90, "-" + (((player1.getInventory()[index].getSpeed()) - player1.getEquippedItems()[i].getSpeed())), "Felix Titling", 18, g);
                    }
                    if (player1.getEquippedItems()[i].getLuck() <= player1.getInventory()[index].getLuck()) {
                        changeColor(blue, g);
                        drawBoldText(220, 350 + 120, "+" + (((player1.getInventory()[index].getLuck()) - player1.getEquippedItems()[i].getLuck())), "Felix Titling", 18, g);
                    } else {
                        changeColor(red, g);
                        drawBoldText(220, 350 + 120, "-" + (((player1.getInventory()[index].getLuck()) - player1.getEquippedItems()[i].getLuck())), "Felix Titling", 18, g);
                    }

                }

            }


        }

    }

    void noneStats(String name, Graphics2D g) {
        if (player1.getInventory()[index].getSlot().name() == name) {
            changeColor(blue, g);
            drawBoldText(220, 350, "+" + player1.getInventory()[index].getAttack(), "Felix Titling", 18, g);
            drawBoldText(220, 350 + 30, "+" + player1.getInventory()[index].getDefense(), "Felix Titling", 18, g);
            drawBoldText(220, 350 + 60, "+" + player1.getInventory()[index].getStrength(), "Felix Titling", 18, g);
            drawBoldText(220, 350 + 90, "+" + player1.getInventory()[index].getSpeed(), "Felix Titling", 18, g);
            drawBoldText(220, 350 + 120, "+" + player1.getInventory()[index].getLuck(), "Felix Titling", 18, g);
        }
    }

    int firstItem(String name, int temp) {
        for (int i = 0; i < player1.getInventorySize(); i++) {
            if (player1.getInventory()[i].getSlot().name() == name) {
                temp = i;
                return temp;
            }
        }
        return temp;
    }

    public boolean isChaMenu() {
        return chaMenu;
    }

    public int getCursorPositionY() {
        return cursorPositionY;
    }

    public void initMenu() {
        clicks = loadAudio("clicks.wav");
        clicks2 = loadAudio("clicks2.wav");
        exitClick = loadAudio("exitClick.wav");
        chaMenu = true;
        cursorPositionY = 440;
        background1 = subImage(menuSprite, 0, 0, 800, 600);
        background2 = subImage(inventorySprite, 0, 0, 800, 600);
        background3 = subImage(equipmentSprite, 0, 0, 800, 600);
        statBackground = subImage(paper, 0, 0, 768, 1028);
        scrollBackground = subImage(paper2, 0, 0, 1028, 768);
        character = subImage(characterSprite, 0, 0, 144, 144);
        marker = subImage(arrow1, 291, 100, 45, 40);
        rightArrow = subImage(arrow1, 291, 100, 45, 40);
        leftArrow = subImage(arrow2, 291, 55, 45, 40);
        Book = subImage(book, 0, 0, 544, 416);

    }


    public void drawChaMenu(Graphics2D g) {
        if (chaMenu == true) {
            scroller2 = 0;
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
            if (player1.getInventorySize() > 0) {
                if ((scroller < 100) && (index == player1.getInventorySize() - 1)) {
                    if (pageNum == 1) {
                        pos++;
                        index = pos;
                    }
                    scroller = 380;
                    //totalPages--;
                } else if ((scroller < 100) && (index == player1.getInventorySize() - 2)) {
                    scroller = 100;
                    index++;

                } else if ((scroller < 100) && (index == 0)) {
                    index = 0;
                    pos = 0;
                } else if (scroller < 100) {
                    scroller = 100;
                    index++;
                }
                if (pos == player1.getInventorySize()) {
                    pos -= 5;
                    index = pos;
                }
                scroller2 = 0;
                clearBackground(800, 600, g);
                drawImage(Book, 0, 0, 800, 600, g);
                if (nextPage == true) {
                    scroller = 100;
                }
                //drawImage(leftArrow , 300,scroller, g );
                drawLine(70, scroller + 40, 250, scroller + 40, 2, g);
                changeColor(purple, g);
                drawBoldText(420, 550, "Inventory : " + player1.getInventorySize() + "/" + player1.getMaxInventorySize(), "Felix Titling", 18, g);
                changeColor(grey2, g);
                increaser = 0;
                if (player1.getInventorySize() % 5 != 0) {
                    totalPages = (player1.getInventorySize() / 5);
                } else {
                    totalPages = (player1.getInventorySize() / 5);
                }
                drawBoldText(640, 550, "Page: " + Integer.toString(pageNum) + "/" + Integer.toString(totalPages), "Felix Titling", 20, g);
                int dis = 5;
                if ((pos + 5) > player1.getInventorySize()) {
                    dis = player1.getInventorySize() - pos;
                }
                changeColor(red, g);
                //drawBoldText(200, 200, Integer.toString(pos), g);
                //drawBoldText(200, 250, Integer.toString(dis), g);
                changeColor(grey2, g);
                for (int i = pos; i < pos + dis; i++) {
                    drawBoldText(65, 130 + (increaser * 70), player1.getInventory()[i].getName(), "Felix Titling", 20, g);
                    if (player1.getInventory()[i].getCounter() != 0) {
                        drawBoldText(300, 130 + (increaser * 70), " X " + Integer.toString(player1.getInventory()[i].getCounter()), "Felix Titling", 20, g);
                    }
                    increaser++;
                }
                // drawSolidRectangle(175, 530, 250, 45, g);
                //drawImage(scrollBackground, 164, 525, 264, 60, g);


                changeColor(purple, g);
                if (player1.getInventory()[index].getName() != null) {
                    drawBoldText(420, 65, player1.getInventory()[index].getName(), "Felix Titling", 20, g);
                    drawLine(420, 70, 620, 70, 2, g);
                    changeColor(black, g);
                    if (player1.getInventory()[index].isEquippable()) {
                        drawBoldText(420, 100, "ATK", "Felix Titling", 15, g);
                        drawBoldText(420, 100 + 30, "DEF", "Felix Titling", 15, g);
                        drawBoldText(420, 100 + 60, "STR", "Felix Titling", 15, g);
                        drawBoldText(420, 100 + 90, "SPD", "Felix Titling", 15, g);
                        drawBoldText(420, 100 + 120, "LUK", "Felix Titling", 15, g);
                        drawBoldText(690, 100, Integer.toString(player1.getInventory()[index].getAttack()), "Felix Titling", 18, g);
                        drawBoldText(690, 100 + 30, Integer.toString(player1.getInventory()[index].getDefense()), "Felix Titling", 18, g);
                        drawBoldText(690, 100 + 60, Integer.toString(player1.getInventory()[index].getStrength()), "Felix Titling", 18, g);
                        drawBoldText(690, 100 + 90, Integer.toString(player1.getInventory()[index].getSpeed()), "Felix Titling", 18, g);
                        drawBoldText(690, 100 + 120, Integer.toString(player1.getInventory()[index].getLuck()), "Felix Titling", 18, g);


                        drawBoldText(420, 300, player1.getInventory()[index].getTooltip() + ".", "Felix Titling", 17, g);

                        changeColor(purple, g);
                        drawBoldText(420, 260, player1.getInventory()[index].getSlot().name() + " ITEM", "Felix Titling", 20, g);
                    } else {
                        drawBoldText(420, 150, player1.getInventory()[index].getTooltip() + ".", "Felix Titling", 17, g);

                        changeColor(purple, g);
                        drawBoldText(420, 100, player1.getInventory()[index].getSlot().name() + " ITEM", "Felix Titling", 20, g);

                    }

                    changeColor(purple, g);
                    drawBoldText(65, 70, "INVENTORY", "Felix Titling", 40, g);
                    drawBoldText(70, 545, "BACK [ESC]", "Felix Titling", 15, g);
                    // drawBoldText(400, 100, Integer.toString(scroller), g);
                    // drawBoldText(400, 200, Integer.toString(player1.getInventorySize()%5), g);
                }
                nextPage = false;
                if (pageNum > totalPages) {
                    pageNum = totalPages;
                }
            }else{
                clearBackground(800, 600, g);
                drawImage(Book, 0, 0, 800, 600, g);
                changeColor(purple, g);
                drawBoldText(65, 270, "YOUR INVENTORY IS EMPTY.", "Felix Titling", 20, g);
                changeColor(grey4, g);
                drawBoldText(65, 300, "FIND OR BUY ITEMS TO VIEW YOUR INVENTORY", "Felix Titling", 12, g);
                changeColor(red, g);
                drawLine(65, 305, 150, 305, 2, g);

            }
        }

    }

    public void drawEquMenu(Graphics2D g) {
        if (equMenu) {
            isEquiblableItems = false;
            for(int i =0; i<player1.getInventorySize(); i++){
                if(player1.getInventory()[i].getSlot().name() != "bag"){
                    isEquiblableItems = true;
                     break;
                }
            }
            if (isEquiblableItems||player1.getEquipmentSize()>0) {
                firstHead = firstItem("head", firstHead);
                firstWeapon = firstItem("weapon", firstWeapon);
                firstOffhand = firstItem("offhand", firstOffhand);
                firstChest = firstItem("chest", firstChest);
                firstFeet = firstItem("feet", firstFeet);
                firstAccessory = firstItem("accessory", firstAccessory);

                clearBackground(800, 600, g);
                drawImage(background3, 0, 0, g);
                changeColor(red, g);
                //drawBoldText(300, 400, Integer.toString(index), g);
                //drawBoldText(300, 200, Integer.toString(scroller3), g);

                if (slotSelect) {
                    changeColor(cyan, g);
                    drawSolidRectangle(60, scroller3, 492, 20, g);

                    System.out.println(Integer.toString(index));

                } else if (itemSelect) {
                    changeColor(red, g);
                    drawLine(575, 129 + scroller2, 675, 129 + scroller2, 2, g);
                }

                changeColor(white, g);
                drawBoldText(500, 580, "EQUIPMENT", "Felix Titling", 40, g);
                drawBoldText(3, 580, "BACK [ESC]", "Felix Titling", 15, g);
                changeColor(purple, g);
                drawBoldText(60, 90, "EQUIPPED", "Felix Titling", 20, g);
                drawLine(60, 96, 170, 96, 2, g);
                changeColor(grey4, g);
                drawBoldText(60, 125, "HEAD :", "Felix Titling", 15, g);
                drawBoldText(60, 150, "WEAPON :", "Felix Titling", 15, g);
                drawBoldText(60, 175, "OFFHAND :", "Felix Titling", 15, g);
                drawBoldText(60, 200, "CHEST :", "Felix Titling", 15, g);
                drawBoldText(60, 225, "FEET :", "Felix Titling", 15, g);
                drawBoldText(60, 250, "ACCESSORY :", "Felix Titling", 15, g);
                changeColor(black, g);
                for (int i = 0; i < 125; i += 25) {
                    drawLine(60, 131 + i, 550, 131 + i, 2, g);
                }


                changeColor(purple, g);

                for (int i = 0; i < player1.getEquipmentSize(); i++) {
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.head) {
                        h = true;
                        drawBoldText(370, 125, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.weapon) {
                        w = true;
                        drawBoldText(370, 150, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.offhand) {
                        o = true;
                        drawBoldText(370, 175, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.chest) {
                        c = true;
                        drawBoldText(370, 200, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.feet) {
                        f = true;
                        drawBoldText(370, 225, player1.getEquippedItems()[i].getName(), "Felix Titling", 15, g);
                    }
                    if (player1.getEquippedItems()[i].getSlot() == Item.Slot.accessory) {
                        a = true;
                        drawBoldText(370, 250, player1.getEquippedItems()[i].getName(), "Felix Titling", 12, g);
                    }

                }


                changeColor(red, g);
                if (h == false) {
                    drawBoldText(370, 125, "None", "Felix Titling", 15, g);

                }
                if (w == false) {
                    drawBoldText(370, 150, "None", "Felix Titling", 15, g);
                }
                if (o == false) {
                    drawBoldText(370, 175, "None", "Felix Titling", 15, g);
                }

                if (c == false) {
                    drawBoldText(370, 200, "None", "Felix Titling", 15, g);
                }
                if (f == false) {
                    drawBoldText(370, 225, "None", "Felix Titling", 15, g);
                }

                if (a == false) {
                    drawBoldText(370, 250, "None", "Felix Titling", 15, g);
                }


                changeColor(black, g);
                // drawBoldText(500, 250, player1.getEquipmentSize() + " / 6", "Felix Titling", 15, g);
                changeColor(purple, g);
                drawBoldText(570, 90, "UNEQUIPPED", "Felix Titling", 20, g);
                drawLine(570, 96, 680, 96, 2, g);
                changeColor(black, g);
                isHead = false;
                isWeapon = false;
                isOffhand = false;
                isChest = false;
                isFeet = false;
                isAccessory = false;

                if (scroller3 == 110) {
                    isHead = true;
                } else if (scroller3 == 135) {
                    isWeapon = true;
                } else if (scroller3 == 160) {
                    isOffhand = true;
                } else if (scroller3 == 185) {
                    isChest = true;
                } else if (scroller3 == 210) {
                    isFeet = true;

                } else if (scroller3 == 235) {
                    isAccessory = true;
                }
                none = false;
                for (int i = 0; i < player1.getEquipmentSize(); i++) {
                    if (isHead) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "head") {
                            index2 = i;
                            break;
                        }else if (i == player1.getEquipmentSize() - 1) {
                            none = true;
                        }
                    } else if (isWeapon) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "weapon") {
                            index2 = i;
                            break;
                        }else if (i == player1.getEquipmentSize() - 1) {

                            none = true;
                        }
                    } else if (isOffhand) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "offhand") {
                            index2 = i;
                            break;
                        }else if (i == player1.getEquipmentSize() - 1) {
                            none = true;
                        }
                    } else if (isChest) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "chest") {
                            index2 = i;
                            break;
                        }else if (i == player1.getEquipmentSize() - 1) {
                            none = true;
                        }
                    } else if (isFeet) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "feet") {
                            index2 = i;
                            break;
                        }else if (i == player1.getEquipmentSize() - 1) {
                            none = true;
                        }
                    } else if (isAccessory) {
                        if (player1.getEquippedItems()[i].getSlot().name() == "accessory") {
                            index2 = i;
                            break;
                        } else if (i == player1.getEquipmentSize() - 1) {
                            none = true;
                        }
                    }
                }


//            drawBoldText(200, 250, Boolean.toString(isHead), g);
//           drawBoldText(200, 300, Boolean.toString(isWeapon), g);
//            drawBoldText(200, 350, Boolean.toString(isOffhand), g);
//            drawBoldText(200, 400, Boolean.toString(isChest), g);
//            drawBoldText(200, 450, Boolean.toString(isFeet), g);
//            drawBoldText(200, 500, Boolean.toString(isAccessory), g);


                num1 = 0;
                num2 = 0;
                num3 = 0;
                num4 = 0;
                num5 = 0;
                num6 = 0;


                for (int i = 0; i < player1.getInventorySize(); i++) {

                    if ((player1.getInventory()[i].isEquippable())) {
                        if (isHead) {
                            if (player1.getInventory()[i].getSlot().name() == "head") {
                                if ((num1 == 0) && slotSelect) {
                                    index = i;
                                }

                                drawBoldText(575, 125 + (20 * (num1)), player1.getInventory()[i].getName(), "Felix Titling", 12, g);
                                num1++;
                            }


                        } else if (isWeapon) {
                            if (player1.getInventory()[i].getSlot().name() == "weapon") {
                                drawBoldText(575, 125 + (20 * (num2)), player1.getInventory()[i].getName(), "Felix Titling", 12, g);
                                if ((num2 == 0) && slotSelect) {
                                    index = i;
                                }
                                num2++;
                            }

                        } else if (isOffhand) {
                            if (player1.getInventory()[i].getSlot().name() == "offhand") {
                                if ((num3 == 0) && slotSelect) {
                                    index = i;
                                }
                                drawBoldText(575, 125 + (20 * (num3)), player1.getInventory()[i].getName(), "Felix Titling", 12, g);
                                num3++;
                            }
                        } else if (isChest) {
                            if (player1.getInventory()[i].getSlot().name() == "chest") {
                                if ((num4 == 0) && slotSelect) {
                                    index = i;
                                }

                                drawBoldText(575, 125 + (20 * (num4)), player1.getInventory()[i].getName(), "Felix Titling", 12, g);
                                num4++;
                            }
                        } else if (isFeet) {
                            if (player1.getInventory()[i].getSlot().name() == "feet") {
                                if ((num5 == 0) && slotSelect) {
                                    index = i;
                                }
                                drawBoldText(575, 125 + (20 * (num5)), player1.getInventory()[i].getName(), "Felix Titling", 12, g);

                                num5++;
                            }
                        } else if (isAccessory) {
                            if (player1.getInventory()[i].getSlot().name() == "accessory") {
                                if ((num6 == 0) && slotSelect) {
                                    index = i;
                                }

                                drawBoldText(575, 125 + (20 * (num6)), player1.getInventory()[i].getName(), "Felix Titling", 12, g);

                                num6++;
                            }
                        }
                    }
                }
                if (firstTime == true) {
                    index = firstHead;
                    firstTime = false;
                }


                changeColor(white, g);



                    changeColor(black, g);
                    drawLine(50, 265, 550, 265, 2, g);
                    drawLine(550, 100, 550, 480, 2, g);
                    drawBoldText(60, 300, "CHARACTER:", "Felix Titling", 20, g);
                    drawLine(60, 306, 170, 306, 2, g);
                    drawLine(270, 330, 270, 480, 2, g);
                    drawBoldText(60, 350, "ATK", "Felix Titling", 15, g);
                    drawBoldText(60, 350 + 30, "DEF", "Felix Titling", 15, g);
                    drawBoldText(60, 350 + 60, "STR", "Felix Titling", 15, g);
                    drawBoldText(60, 350 + 90, "SPD", "Felix Titling", 15, g);
                    drawBoldText(60, 350 + 120, "LUK", "Felix Titling", 15, g);
                    drawBoldText(200, 350, Integer.toString(player1.getAttack() + player1.getEquipAttackBonus()), "Felix Titling", 18, g);
                    drawBoldText(200, 350 + 30, Integer.toString(player1.getDefense() + player1.getEquipDefenseBonus()), "Felix Titling", 18, g);
                    drawBoldText(200, 350 + 60, Integer.toString(player1.getStrength() + player1.getEquipStrengthBonus()), "Felix Titling", 18, g);
                    drawBoldText(200, 350 + 90, Integer.toString(player1.getSpeed() + player1.getEquipSpeedBonus()), "Felix Titling", 18, g);
                    drawBoldText(200, 350 + 120, Integer.toString(player1.getLuck() + player1.getEquipLuckBonus()), "Felix Titling", 18, g);
                    //drawBoldText(300, 300, Boolean.toString(none), g);
                    if (itemSelect) {
                        if (none == false) {
                            stats("head", g);
                            stats("weapon", g);
                            stats("offhand", g);
                            stats("chest", g);
                            stats("feet", g);
                            stats("accessory", g);
                        }
                    }



                if (itemSelect) {
                    changeColor(purple, g);
                    drawBoldText(295, 300, player1.getInventory()[index].getName(), "Felix Titling", 20, g);
//                changeColor(purple, g);
//                drawBoldText(520, 175, "INFO:", "Felix Titling", 25, g  );
                    changeColor(blue, g);
                    drawBoldText(295, 315, player1.getInventory()[index].getSlot().name() + " ITEM", "Felix Titling", 12, g);
                    changeColor(black, g);
                    drawBoldText(295, 330, player1.getInventory()[index].getTooltip() + " .", "Felix Titling", 12, g);
//                changeColor(black, g);
//                drawBoldText(520, 360, "STATS:", "Felix Titling", 25, g );
                    changeColor(red, g);
                    drawBoldText(480, 350, Integer.toString(player1.getInventory()[index].getAttack()), "Felix Titling", 15, g);
                    drawBoldText(480, 350 + 30, Integer.toString(player1.getInventory()[index].getDefense()), "Felix Titling", 15, g);
                    drawBoldText(480, 350 + 60, Integer.toString(player1.getInventory()[index].getStrength()), "Felix Titling", 15, g);
                    drawBoldText(480, 350 + 90, Integer.toString(player1.getInventory()[index].getSpeed()), "Felix Titling", 15, g);
                    drawBoldText(480, 350 + 120, Integer.toString(player1.getInventory()[index].getLuck()), "Felix Titling", 15, g);
                    changeColor(red, g);
                    drawBoldText(295, 350, "ATK", "Felix Titling", 15, g);
                    drawBoldText(295, 350 + 30, "DEF", "Felix Titling", 15, g);
                    drawBoldText(295, 350 + 60, "STR", "Felix Titling", 15, g);
                    drawBoldText(295, 350 + 90, "SPD", "Felix Titling", 15, g);
                    drawBoldText(295, 350 + 120, "LUK", "Felix Titling", 15, g);
                    //drawText(300 ,300, Integer.toString(scroller2), g);

                    changeColor(grey4, g);
                    //drawBoldText(520, 535, "PRESS <SPACE> TO EQUIP ITEM.", "Felix Titling", 12, g);

                    if (index == player1.getInventorySize()) {
                        index = 0;
                    }
                    stopper = false;
                } else {
                    if (none == false) {
                        if (player1.getEquipmentSize() > 0) {
                            changeColor(purple, g);
                            drawBoldText(295, 300, player1.getEquippedItems()[index2].getName(), "Felix Titling", 20, g);
//                changeColor(purple, g);
//                drawBoldText(520, 175, "INFO:", "Felix Titling", 25, g  );
                            changeColor(blue, g);
                            drawBoldText(295, 315, player1.getEquippedItems()[index2].getSlot().name() + " ITEM", "Felix Titling", 12, g);
                            changeColor(black, g);
                            drawBoldText(295, 330, player1.getEquippedItems()[index2].getTooltip() + " .", "Felix Titling", 12, g);
//                changeColor(black, g);
//                drawBoldText(520, 360, "STATS:", "Felix Titling", 25, g );
                            changeColor(red, g);
                            drawBoldText(480, 350, Integer.toString(player1.getEquippedItems()[index2].getAttack()), "Felix Titling", 15, g);
                            drawBoldText(480, 350 + 30, Integer.toString(player1.getEquippedItems()[index2].getDefense()), "Felix Titling", 15, g);
                            drawBoldText(480, 350 + 60, Integer.toString(player1.getEquippedItems()[index2].getStrength()), "Felix Titling", 15, g);
                            drawBoldText(480, 350 + 90, Integer.toString(player1.getEquippedItems()[index2].getSpeed()), "Felix Titling", 15, g);
                            drawBoldText(480, 350 + 120, Integer.toString(player1.getEquippedItems()[index2].getLuck()), "Felix Titling", 15, g);
                            changeColor(red, g);
                            drawBoldText(295, 350, "ATK", "Felix Titling", 15, g);
                            drawBoldText(295, 350 + 30, "DEF", "Felix Titling", 15, g);
                            drawBoldText(295, 350 + 60, "STR", "Felix Titling", 15, g);
                            drawBoldText(295, 350 + 90, "SPD", "Felix Titling", 15, g);
                            drawBoldText(295, 350 + 120, "LUK", "Felix Titling", 15, g);
                            //drawText(300 ,300, Integer.toString(scroller2), g);

                            changeColor(grey4, g);
                            //drawBoldText(520, 535, "PRESS <SPACE> TO EQUIP ITEM.", "Felix Titling", 12, g);

                            if (index2 == player1.getEquipmentSize()) {
                                index2 = 0;
                            }

                        }
                        // changeColor(green, g);
                        //drawBoldText(100, 100, Integer.toString(index), g);
                    }
                    stopper = false;
                }
            }else{
                clearBackground(800, 600, g);
                drawImage(background3, 0, 0, g);
                changeColor(purple, g);
                drawBoldText(180, 240, "YOU HAVE NO ITEMS TO EQUIP, " , "Felix Titling", 25, g);
                drawBoldText(180, 270, "AND NOTHING EQUIPPED.", "Felix Titling", 25, g);
                changeColor(cyan, g);
                drawBoldText(180, 290, "FIND OR BUY ITEMS TO VIEW YOUR EQUIPMENT PAGE.", "Felix Titling", 15, g);
                changeColor(red, g);
                drawLine(180, 295, 283, 295, 2, g);



            }

            stopper2 = false;
        }
//        changeColor(red, g);
//        drawBoldText(500, 500, "IS =  " + Boolean.toString(itemSelect), g );
//        drawBoldText(500, 550, "SS =  " + Boolean.toString(slotSelect), g );
    }


    public int keyPressed(KeyEvent e) {


        if (chaMenu) {
            if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 510) {
                playAudio(clicks);
                cursorPositionY += 30;

            }
            if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 450) {
                playAudio(clicks);
                cursorPositionY -= 30;

            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 530) {
                System.exit(23);
            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 470) {
                //maybe temporary vvvvv
                index = 0;
                pos = 0;
                pageNum = 1;
                scroller = 100;
                //^^^^^^
                invMenu = true;
                equMenu = false;
                chaMenu = false;
            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 500) {
                equMenu = true;
                invMenu = false;
                chaMenu = false;
            }
        } else if (invMenu) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playAudio(clicks);
                if ((index < player1.getInventorySize() - 1) && scroller < 360) {
                    scroller += 70;
                    index++;
                }
            }
            if ((e.getKeyCode() == KeyEvent.VK_UP) && scroller > 100) {
                playAudio(clicks);
                if (index > 0) {
                    scroller -= 70;
                    index--;
                }
            }
            if ((e.getKeyCode() == KeyEvent.VK_TAB) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
                playAudio(clicks);
                nextPage = true;
                if (pageNum == totalPages) {
                    pageNum = 1;
                    pos = 0;
                    index = 0;
                } else {
                    pos += 5;
                    pageNum++;
                    index = pos;
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                playAudio(clicks2);
                if (player1.getInventory()[index].getSlot().name() == "bag") {
                    if (player1.getInventory()[index].getName() != null) {
                        if (player1.getInventory()[index].getCounter() == 1) {
                            player1.getInventory()[index].use(player1);
                            if(index != 0) {
                                index--;
                                scroller -= 70;
                            }else{
                                index = 0;
                            }
                        } else {
                            player1.getInventory()[index].use(player1);
                        }
                        stopper3 = true;
                    }

                }
                if ((player1.getInventory()[index].isEquippable() == true) && !stopper3) {
                    equMenu = true;
                    invMenu = false;

                }
                stopper3 = false;
            }
            //Bug vvvvv
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                playAudio(clicks);
                nextPage = true;
                if (pageNum == 1) {
                    pageNum = totalPages;
                    if (player1.getInventorySize() == 50) {
                        pos = (player1.getInventorySize() - player1.getInventorySize() % 5) - 5;
                    } else {
                        pos = (player1.getInventorySize() - player1.getInventorySize() % 5);
                    }
                    if (player1.getInventorySize() == 50) {
                        index = (player1.getInventorySize() - player1.getInventorySize() % 5) - 1;
                    } else {
                        index = player1.getInventorySize() - player1.getInventorySize() % 5;
                    }
                } else {
                    pos -= 5;
                    pageNum--;
                    index = pos;
                }

            }



        } else {

            if ((e.getKeyCode() == KeyEvent.VK_DOWN) && itemSelect) {
                playAudio(clicks);
                if (isHead) {
                    limit = num1;
                }
                if (isWeapon) {
                    limit = num2;
                }
                if (isOffhand) {
                    limit = num3;
                }
                if (isChest) {
                    limit = num4;
                }
                if (isFeet) {
                    limit = num5;
                }
                if (isAccessory) {
                    limit = num6;
                }

                if (scroller2 < ((limit * 20) - 20)) {
                    scroller2 += 20;
                }
                if (isHead) {
                    index = checkRightItemEquip("head");
                }
                if (isWeapon) {
                    index = checkRightItemEquip("weapon");
                }
                if (isOffhand) {
                    index = checkRightItemEquip("offhand");
                }
                if (isChest) {
                    index = checkRightItemEquip("chest");
                }
                if (isFeet) {
                    index = checkRightItemEquip("feet");
                }
                if (isAccessory) {
                    index = checkRightItemEquip("accessory");
                }


            }


            if ((e.getKeyCode() == KeyEvent.VK_DOWN) && slotSelect) {
                playAudio(clicks);
                if (scroller3 < 235) {
                    scroller3 += 25;
                }
                none = false;


            }
            if ((e.getKeyCode() == KeyEvent.VK_UP) && itemSelect) {
                playAudio(clicks);

                if (scroller2 > 0) {
                    scroller2 -= 20;
                }
                if (isHead) {
                    index = checkLeftItemEquip("head");
                }
                if (isWeapon) {
                    index = checkLeftItemEquip("weapon");
                }
                if (isOffhand) {
                    index = checkLeftItemEquip("offhand");
                }
                if (isChest) {
                    index = checkLeftItemEquip("chest");
                }
                if (isFeet) {
                    index = checkLeftItemEquip("feet");
                }
                if (isAccessory) {
                    index = checkLeftItemEquip("accessory");
                }


            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && slotSelect&&isEquiblableItems) {
                scroller2 = 0;
                none = false;
                itemSelect = true;
                slotSelect = false;
                stopper2 = true;
            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && itemSelect && !stopper2) {
                playAudio(clicks2);
                String temp = player1.getInventory()[index].getSlot().name();
                player1.equipItem(player1.getInventory()[index]);
                none = false;
                index = checkRightItemEquip(temp);
                index = checkLeftItemEquip(temp);
                itemSelect = false;
                slotSelect = true;
            }
            if ((e.getKeyCode() == KeyEvent.VK_UP) && slotSelect) {
                playAudio(clicks);
                if (scroller3 > 110) {
                    scroller3 -= 25;
                }
                none = false;

            }

            if ((e.getKeyCode() == KeyEvent.VK_X) && slotSelect) {
                player1.unequipItem(player1.getEquippedItems()[index2]);
            }


        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE && getCursorPositionY() == 440 ) {
            playAudio(exitClick);

            return 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && isChaMenu()) {
            playAudio(exitClick);

            return 1;
        }


        return 0;
    }

    public void keyReleased(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_ESCAPE) && itemSelect && equMenu) {
            playAudio(exitClick);

            slotSelect = true;
            itemSelect = false;
            stopper = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !chaMenu && !itemSelect && !stopper) {
            playAudio(exitClick);
            chaMenu = true;
            invMenu = false;
            equMenu = false;


        }

    }


}


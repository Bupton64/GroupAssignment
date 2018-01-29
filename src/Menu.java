
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;


public class Menu extends extraFunctions {
    Menu(Character playerMan, saveGame load) {
        this.player1 = playerMan;
        this.loadController = load;
        initMenu();
        initSaveGame();
        initInventoryMenu();
    }

    Character player1;
    Image buttonSpriteSheet;
    Image buttonSprite;
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
        buttonSpriteSheet = loadImage("buttons.png");
        buttonSprite = subImage(buttonSpriteSheet,30,70,180,80);
        clicks = loadAudio("clicks.wav");
        clicks2 = loadAudio("clicks2.wav");
        exitClick = loadAudio("exitClick.wav");
        select = loadAudio("select.wav");
        p1 = loadAudio("page1.wav");
        p2 = loadAudio("page2.wav");
        p3 = loadAudio("page3.wav");
        leave = loadAudio("leave.wav");
        chaMenu = true;
        cursorPositionY = 410;
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

    public void updateMenu(){
        if(invMenu){
            updateInventoryMenu();
        }


    }

    public void drawMenu(Graphics2D g){
        if(state == MenuState.CharacterMenu) {
            drawChaMenu(g);
            if(invMenu) {
                drawInventoryMenu(g);
            }
            drawEquMenu(g);
        }else if(state == MenuState.SaveMenu){
            drawSaveGame(g);
        }else if(state == MenuState.EquipmentMenu){
            drawEquMenu(g);
        }else if(state == MenuState.InventoryMenu){
           // drawInvMenu(g);
        }
    }

    public void drawChaMenu(Graphics2D g) {
        if (chaMenu == true) {

            scroller2 = 0;
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            drawImage(background1, 0, 0, g);
            drawImage(character, 429, 97, 144, 144, g);
            drawImage(paper, 10, 300, 514, 370, g);
            changeColor(black, g);
            drawBoldText(50,360,"Current Quest:","Felix Titling",18,g);
            drawImage(buttonSprite,235,340,250,53,g);
            changeColor(cyan, g);
            drawBoldText(265,367,player1.getCurrentQuest().getQuestName(),"Felix Titling",13,g);
            changeColor(black, g);
            player1.getCurrentQuest().drawQuest(g);




            drawBoldText(650, 420, "RESUME", "Felix Titling", 20, g);
            drawBoldText(650, 450, "Save", "Felix Titling", 20, g);
            drawBoldText(650, 480, "INVENTORY", "Felix Titling", 20, g);
            drawBoldText(650, 510, "EQUIPMENT", "Felix Titling", 20, g);
            drawBoldText(650, 540, "EXIT", "Felix Titling", 20, g);

            drawBoldText(3, 60, player1.getName(), "Felix Titling", 40, g);
            changeColor(red, g);
            drawBoldText(170, 45, "HP       " + Integer.toString((int) player1.getCurrentHP()), "Felix Titling", 20, g);

            drawSolidRectangle(465, 33, 100 / player1.getMaxHP() * player1.getCurrentHP(), 9, g);
            changeColor(white, g);
            drawRectangle(465, 33, 100, 9, 1, g);

            changeColor(green, g);
            drawBoldText(170, 70, "EXP     " + player1.getXPTotal(), "Felix Titling", 20, g);
            drawSolidRectangle(465 , 55, ((float) (player1.getXPTotal()) / (float) (player1.getXPToNextLevel())) * 100, 9, g);
            changeColor(white, g);
            drawRectangle(465 , 55, 100, 9, 1, g);
            changeColor(cyan, g);
            drawBoldText(173, 95, "LVL     " + player1.getLevel(), "Felix Titling", 20, g);
            changeColor(yellow, g);
            drawBoldText(170, 115, "GOLD  " + player1.getGpTotal(), "Felix Titling", 20, g);

            changeColor(white, g);
            drawBoldText(605, 50, "ATTACK : ", "Felix Titling", 17, g);
            drawBoldText(750, 50, Integer.toString(player1.getAttack() + player1.getEquipAttackBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 80, "DEFENCE : ", "Felix Titling", 17, g);
            drawBoldText(750, 80, Integer.toString(player1.getDefense() + player1.getEquipDefenseBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 110, "STRENGTH : ", "Felix Titling", 17, g);
            drawBoldText(750, 110, Integer.toString(player1.getStrength() + player1.getEquipStrengthBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 140, "SPEED : ", "Felix Titling", 17, g);
            drawBoldText(750, 140, Integer.toString(player1.getSpeed() + player1.getEquipSpeedBonus()), "Felix Titling", 17, g);
            drawBoldText(605, 170, "LUCK : ", "Felix Titling", 17, g);
            drawBoldText(750, 170, Integer.toString(player1.getLuck() + player1.getEquipLuckBonus()), "Felix Titling", 17, g);
            changeColor(yellow, g);
            changeColor(white, g);
            drawBoldText(3, 220, "TO NEXT LEVEL : ", "Felix Titling", 15, g);
            changeColor(green, g);
            drawBoldText(72, 240, player1.getXPToNextLevel() + " EXP", "Felix Titling", 15, g);
            changeColor(red, g);
            drawImage(marker, 640 - 30, cursorPositionY - 15, 32, 28, g);
        }
    }

    int numOfPages;
    int currentPage;
    int numOfItemsToDisplay;
    int inventoryMenuPointerPosY;
    int menuOption;

    public void initInventoryMenu(){

        numOfPages = 0;
        currentPage = 1;
        numOfItemsToDisplay = 0;
        menuOption = 0;
        inventoryMenuPointerPosY = 120;
    }


    public void updateInventoryMenu(){


        if(menuOption >= 0 && menuOption <= 9){

            inventoryMenuPointerPosY = 140 + (40 * (menuOption));
        }




        if (player1.getInventorySize() % 10 != 0) {
            numOfPages = (player1.getInventorySize() / 10)+1;
        } else {
            numOfPages = (player1.getInventorySize() / 10);
        }



        if(currentPage < numOfPages){
            numOfItemsToDisplay = 9 *currentPage;
        }else{
            numOfItemsToDisplay = player1.getMaxInventorySize()-1;

        }


    }

    public void drawInventoryMenu(Graphics2D g) {
        clearBackground(800,600,g);
        changeBackgroundColor(black,g);
        drawImage(Book, 0, 0, 800, 600, g);


        if (player1.getInventorySize() != 0) {


            drawLine(70, inventoryMenuPointerPosY, 250, inventoryMenuPointerPosY, 2, g);
            changeColor(purple, g);
            drawBoldText(420, 550, "Inventory : " + player1.getInventorySize() + "/" + player1.getMaxInventorySize(), "Felix Titling", 18, g);
            drawBoldText(640, 550, "Page: " + Integer.toString(currentPage) + "/" + Integer.toString(numOfPages), "Felix Titling", 20, g);
            changeColor(grey2, g);
            int j = 0;
            for (int i = ((currentPage - 1) * 10); i < (currentPage * 10); i++) {
                if (i < player1.getInventorySize()) {
                    drawBoldText(65, 130 + (j * 40), player1.getInventory()[i].getName(), "Felix Titling", 20, g);
                    if (player1.getInventory()[i].getCounter() != 0) {
                        drawBoldText(300, 130 + (j * 40), " X " + Integer.toString(player1.getInventory()[i].getCounter()), "Felix Titling", 20, g);
                    }
                    j++;
                }
            }

            if (player1.getInventorySize() > 0) {


                changeColor(black, g);
                if (player1.getInventory()[menuOption + (10 * (currentPage - 1))].getSlot() == Item.Slot.bag) {
                    drawBoldText(420, 65, player1.getInventory()[menuOption + (10 * (currentPage - 1))].getName(), "Felix Titling", 20, g);
                    drawLine(420, 70, 620, 70, 2, g);

                    changeColor(black, g);

                    changeColor(purple, g);
                    drawBoldText(420, 100, player1.getInventory()[menuOption + (10 * (currentPage - 1))].getSlot().name() + " ITEM", "Felix Titling", 20, g);
                    changeColor(black, g);
                    drawBoldText(420, 130, player1.getInventory()[menuOption + (10 * (currentPage - 1))].getTooltip() + ".", "Felix Titling", 17, g);
                } else {
                    drawBoldText(420, 65, player1.getInventory()[menuOption + (10 * (currentPage - 1))].getName(), "Felix Titling", 20, g);
                    drawLine(420, 70, 620, 70, 2, g);

                    changeColor(black, g);
                    drawBoldText(420, 100, "ATK", "Felix Titling", 15, g);
                    drawBoldText(420, 100 + 30, "DEF", "Felix Titling", 15, g);
                    drawBoldText(420, 100 + 60, "STR", "Felix Titling", 15, g);
                    drawBoldText(420, 100 + 90, "SPD", "Felix Titling", 15, g);
                    drawBoldText(420, 100 + 120, "LUK", "Felix Titling", 15, g);

                    drawBoldText(690, 100, Integer.toString(player1.getInventory()[menuOption + (10 * (currentPage - 1))].getAttack()), "Felix Titling", 18, g);
                    drawBoldText(690, 100 + 30, Integer.toString(player1.getInventory()[menuOption + (10 * (currentPage - 1))].getDefense()), "Felix Titling", 18, g);
                    drawBoldText(690, 100 + 60, Integer.toString(player1.getInventory()[menuOption + (10 * (currentPage - 1))].getStrength()), "Felix Titling", 18, g);
                    drawBoldText(690, 100 + 90, Integer.toString(player1.getInventory()[menuOption + (10 * (currentPage - 1))].getSpeed()), "Felix Titling", 18, g);
                    drawBoldText(690, 100 + 120, Integer.toString(player1.getInventory()[menuOption + (10 * (currentPage - 1))].getLuck()), "Felix Titling", 18, g);

                    changeColor(purple, g);
                    drawBoldText(420, 260, player1.getInventory()[menuOption + (10 * (currentPage - 1))].getSlot().name() + " ITEM", "Felix Titling", 20, g);
                    changeColor(black, g);
                    drawBoldText(420, 300, player1.getInventory()[menuOption + (10 * (currentPage - 1))].getTooltip() + ".", "Felix Titling", 17, g);
                }


                changeColor(purple, g);
                drawBoldText(65, 70, "INVENTORY", "Felix Titling", 40, g);
                drawBoldText(70, 545, "BACK [ESC]", "Felix Titling", 15, g);


            } else {
                changeColor(purple, g);
                drawBoldText(65, 270, "YOUR INVENTORY IS EMPTY.", "Felix Titling", 20, g);
                changeColor(grey4, g);
                drawBoldText(65, 300, "FIND OR BUY ITEMS TO VIEW YOUR INVENTORY", "Felix Titling", 12, g);
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



    ////////////////////////////////////
    ///
    ///     Save Game
    ///
    ////////////////////////////////////

    saveGame loadController;

    Image startBackground;
    Image swordSprite;
    Image swordSprite2;

    private String loadOneQuestName;
    private String loadOneLevel;
    private double loadOneTimer;
    private boolean loadOneDisplay;


    private String loadTwoQuestName;
    private String loadTwoLevel;
    private double loadTwoTimer;
    private boolean loadTwoDisplay;


    private String loadThreeQuestName;
    private String loadThreeLevel;
    private double loadThreeTimer;
    private boolean loadThreeDisplay;

    private boolean getSaveFiles;

  //  private int menuPointerPosX;
    private int menuPointerPosY;


    public void initSaveGame(){
        Image paper = loadImage("paper.png");
        Image sword = loadImage("sword.png");
        Image sword2 = loadImage("sword2.png");
        startBackground = subImage(paper, 0, 0, 768, 1028);
        swordSprite = subImage(sword, 0, 0, 1793, 445);
        swordSprite2 = subImage(sword2, 0, 0, 1793, 445);

        getSaveFiles = false;


        loadOneQuestName = "";
        loadOneTimer = 0.0;
        loadOneLevel = "";
        loadOneDisplay = false;

        loadTwoQuestName = "";
        loadTwoTimer = 0.0;
        loadTwoLevel = "";
        loadTwoDisplay = false;

        loadThreeQuestName = "";
        loadThreeTimer = 0.0;
        loadThreeLevel = "";
        loadThreeDisplay = false;

        menuPointerPosY = 230;
    }

    public void getSaveFiles(){
        String temp;
        double timer;
        try (BufferedReader br = new BufferedReader(new FileReader("SaveOne.txt"))) {
            temp = br.readLine();
            if(temp == null){
            }else{
                timer = Double.parseDouble(br.readLine());
                loadOneTimer = timer;
                loadOneQuestName = temp;
                loadOneLevel = br.readLine();
                loadOneDisplay = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("SaveTwo.txt"))) {
            temp = br.readLine();
            if(temp == null){
            }else{
                timer = Double.parseDouble(br.readLine());
                loadTwoTimer = timer;
                loadTwoQuestName = temp;
                loadTwoLevel = br.readLine();
                loadTwoDisplay = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("SaveThree.txt"))) {
            temp = br.readLine();
            if(temp == null){
            }else{
                timer = Double.parseDouble(br.readLine());
                loadThreeTimer = timer;
                loadThreeQuestName = temp;
                loadThreeLevel = br.readLine();
                loadThreeDisplay = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void updateSave(){
        if(!getSaveFiles){
            getSaveFiles();
            getSaveFiles = true;
        }

        // File file = new File("SaveOne.txt");

    }


    public void drawSaveGame(Graphics2D g){

        changeBackgroundColor(black,g);
        drawImage(background3, 0, 0, g);
        //drawImage(startBackground, 210, 10, 350 * 1.2, 500 * 1.2, g);
        changeColor(black, g);
        drawBoldText(330, 150, "Save Files", "Felix Titling", 30, g);
        changeColor(red, g);
        drawBoldText(280, 150 + 80, "Save_1", "Felix Titling", 20, g);
        if(loadOneDisplay) {
            changeColor(black, g);
            drawBoldText(390, 220, loadOneQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 240, "Level " +loadOneLevel, "Felix Titling", 15, g);
            drawBoldText(470, 240, "Time " + (int)loadOneTimer / 60 + ":" + (int)loadOneTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 230, "Empty", "Felix Titling", 15, g);
        }
        changeColor(red, g);
        drawBoldText(280, 150 + 160, "Save_2", "Felix Titling", 20, g);
        if(loadTwoDisplay) {
            changeColor(black, g);
            drawBoldText(390, 300, loadTwoQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 320, "Level " +loadTwoLevel, "Felix Titling", 15, g);
            drawBoldText(470, 320, "Time " + (int)loadTwoTimer / 60 + ":" + (int)loadTwoTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 310, "Empty", "Felix Titling", 15, g);
        }
        changeColor(red, g);
        drawBoldText(280, 150 + 240, "Save_3", "Felix Titling", 20, g);
        if(loadThreeDisplay) {
            changeColor(black, g);
            drawBoldText(390, 380, loadThreeQuestName, "Felix Titling", 15, g);
            drawBoldText(390, 400, "Level " +loadThreeLevel, "Felix Titling", 15, g);
            drawBoldText(470, 400, "Time " + (int)loadThreeTimer / 60 + ":" + (int)loadThreeTimer % 60, "Felix Titling", 15, g);
        }else{
            changeColor(red, g);
            drawBoldText(392, 390, "Empty", "Felix Titling", 15, g);
        }


        drawImage(swordSprite, 600, menuPointerPosY - 20, 89, 22, g);
        drawImage(swordSprite2, 150, menuPointerPosY - 20, 89, 22, g);
    }

    ////////////////////////////////////
    ///
    ///     Keybindos
    ///
    ////////////////////////////////////

    enum MenuState {CharacterMenu, SaveMenu, EquipmentMenu, InventoryMenu}
    MenuState state = MenuState.CharacterMenu;

    public int keyPressed(KeyEvent e){
        if(state == MenuState.CharacterMenu){
            return characterKeyPressed(e);
        }else if(state == MenuState.SaveMenu){
            return saveKeyPressed(e);
        }
        return 0;
    }

    public int saveKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            state = MenuState.CharacterMenu;
        }
        if ((e.getKeyCode() == KeyEvent.VK_DOWN) && menuPointerPosY < 390) {
            playAudio(clicks);
            menuPointerPosY += 80;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP) && menuPointerPosY > 230) {
            menuPointerPosY -= 80;
            playAudio(clicks);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(menuPointerPosY == 230 ){
               // loadController.loadGame(player,"SaveOne.txt");
                loadController.save("SaveOne.txt");
                getSaveFiles = false;
                updateSave();
                return 0;

            }else if(menuPointerPosY == 310 ){
              //  loadController.loadGame(player,"SaveTwo.txt");
                 loadController.save("SaveTwo.txt");
                getSaveFiles = false;
                updateSave();
                return 0;
            }else if(menuPointerPosY == 390 ){
            //    loadController.loadGame(player,"SaveThree.txt");
                loadController.save("SaveThree.txt");
                getSaveFiles = false;
                updateSave();
                return 0;
            }
        }


        return 0;
    }


    public int characterKeyPressed(KeyEvent e) {



        if (chaMenu) {
            if ((e.getKeyCode() == KeyEvent.VK_DOWN) && cursorPositionY < 510) {
                playAudio(clicks);
                cursorPositionY += 30;

            }
            if ((e.getKeyCode() == KeyEvent.VK_UP) && cursorPositionY > 420) {
                playAudio(clicks);
                cursorPositionY -= 30;

            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 530) {
                System.exit(23);
            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 440) {
                getSaveFiles = false;
                updateSave();
                state = MenuState.SaveMenu;
            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && cursorPositionY == 470) {
                playAudio(p2);
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
                playAudio(p3);
                equMenu = true;
                invMenu = false;
                chaMenu = false;
            }
        } else if (invMenu) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (menuOption + (10 * (currentPage - 1)) != player1.getInventorySize()-1) {
                    if (menuOption < numOfItemsToDisplay - ((currentPage - 1) * 10)) {
                        playAudio(clicks);
                        menuOption++;
                    } else {
                        menuOption = 0;
                    }
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_UP) {


                    if (menuOption > 0) {
                        playAudio(clicks);
                        menuOption--;
                    } else {
                        menuOption = numOfItemsToDisplay - ((currentPage - 1) * 10);
                    }


            }


            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(currentPage < numOfPages){
                    currentPage++;
                    menuOption = 0;
                }

            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(currentPage != 1){
                    currentPage--;
                    menuOption = 8;
                }

            }


            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                playAudio(exitClick);
                playAudio(p3);
                if (player1.getInventory()[menuOption + (10 * (currentPage - 1))].getName() != null) {
                    if (player1.getInventory()[menuOption + (10 * (currentPage - 1))].getSlot().name() == "bag") {

                        if (player1.getInventory()[menuOption + (10 * (currentPage - 1))].getCounter() == 1) {
                            player1.getInventory()[menuOption + (10 * (currentPage - 1))].use(player1);
                            if (menuOption != 0) {
                                menuOption--;
                            } else {
                                //  if(player1.getInventory()[menuOption + (10 * (currentPage-1)) ] == null){
                                if (currentPage > 1) {
                                    if(menuOption + (10 * (currentPage - 1)) == player1.getInventorySize() ){
                                        currentPage--;
                                    }


                                }

                                //  }

                                menuOption = 0;
                            }
                        } else {
                            player1.getInventory()[menuOption + (10 * (currentPage - 1))].use(player1);
                        }
                        stopper3 = true;


                    } else if ((player1.getInventory()[menuOption + (10 * (currentPage - 1))].isEquippable()) && !stopper3) {
                        equMenu = true;
                        invMenu = false;

                    }
                    stopper3 = false;
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                playAudio(exitClick);
                menuOption = 1;

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
                playAudio(select);
                scroller2 = 0;

                itemSelect = true;
                slotSelect = false;
                stopper2 = true;
            }
            if ((e.getKeyCode() == KeyEvent.VK_SPACE) && itemSelect && !stopper2) {
                playAudio(select);
                String temp = player1.getInventory()[index].getSlot().name();
                player1.equipItem(player1.getInventory()[index]);
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

            }

//            if ((e.getKeyCode() == KeyEvent.VK_X) && slotSelect) {
//                player1.unequipItem(player1.getEquippedItems()[index2]);
//            }


        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE && getCursorPositionY() == 410 ) {
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
            slotSelect = true;
            itemSelect = false;
            stopper = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !chaMenu && !itemSelect && !stopper) {
            playAudio(leave);
            chaMenu = true;
            invMenu = false;
            equMenu = false;


        }

    }


}


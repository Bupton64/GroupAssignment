import java.awt.*;
import java.awt.event.*;
import java.lang.String;


public class weaponShop extends shop {
    boolean stopper = false;
    weaponShop(Character playerMan){
        super(playerMan);
        setTotalPages(1);
        setMaxIndex(4);
    }
    Image equipmentSprite = loadImage("Image/equipmentSprite.png");

    @Override
    public void shopInit() {
        coin = loadAudio("Audio/coin.wav");
        p1 = loadAudio("Audio/page1.wav");
        p2 = loadAudio("Audio/page2.wav");
        p3 = loadAudio("Audio/page3.wav");
        exitClick = loadAudio("Audio/exitClick.wav");
        clicks = loadAudio("Audio/clicks.wav");

        Item[] inventory = new Item[50];
        for(int i = 0;  i < 50; i++){
            inventory[i] = new Item();
        }
        inventory[0] = new item_Equipment("Bronze Sword", 1, 0, 0, 1, 0, Item.Slot.weapon, "Durable and strong", 50, 300);
        inventory[1] = new item_Equipment("Stone Axe", 0, 0, 0, 0, 1, Item.Slot.weapon, "Rugged, yet effective", 300, 400);
        inventory[2] = new item_Equipment("Monks Staff", 1, 0, 0, 2, 0, Item.Slot.weapon, "A light wooden staff", 300, 1000);
        inventory[3] = new item_Equipment("Guardsmans Spear", 1, 0, 1, 0, 0, Item.Slot.weapon, "A military issue spear", 290, 1100);
        inventory[4] = new item_Equipment("Rough Axe", 0, 0, 0, 0, 2, Item.Slot.weapon, "A violent edge, little else", 300, 1200);

        inventory[5] =  new item_Equipment("Acolytes Staff", 2, 0, 0, 5, 0, Item.Slot.weapon, "Crafted from magic oak", 620, 2090);
        inventory[6] = new item_Equipment("Iron Sword", 4, 0, 0, 0, 2, Item.Slot.weapon, "A well forged sword", 600, 2300);

        inventory[7] = new item_Equipment("Steel Sword", 8, 0, 0, 0, 4, Item.Slot.weapon, "Grace and power combined", 1300, 4500);
        inventory[8] = new item_Equipment("Jesters Staff", 4, 0, 0, 10, 0, Item.Slot.weapon, "Lighter than air itself", 1250, 4800);
        inventory[9] = new item_Equipment("Emperors Word", 4, 0, 6, 0, 0, Item.Slot.weapon, "His voice pierces hearts", 1400, 4950);
        inventory[10] = new item_Equipment("Gladiators Axe", 8, 0, 0, 0, 8, Item.Slot.weapon, "Keen edged and lethal", 1450, 5200);

        setShopInventory(inventory);
    }

    public void updateShop(){
        if(getPlayer1().getQuestStage() > 11) { // Beat Valliard
            if (getMaxIndex() < 6) {
                setTotalPages(1);
                setMaxIndex(6);
            }
        }
        if(getPlayer1().getQuestStage() > 21) { // Beat Razuul
            if (getMaxIndex() < 10) {
                setTotalPages(2);
                setMaxIndex(10);
            }
        }
        if (getItemIndex() > getMaxIndex()) {
            setItemIndex(getMaxIndex());
        }
        setScroller((getItemIndex() % 10));
    }

    public void drawShop(Graphics2D g) {
        //< Set up background
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        drawImage(equipmentSprite,0,0,g);
        drawImage(this.getShopBackground(), 0, 0, 800, 600, g);
        changeColor(black, g);
        drawBoldText(80, 60, "LINK'S ARMORY", "Felix Titling", 30, g);

        //< Draw scroller
        drawLine(70,  (this.getScroller()*45) + 140, 250, (this.getScroller()*45) + 140, 2, g);

        //< Draw page number
        drawBoldText(80, 90, "Page: " + Integer.toString(this.getPageNum()) + " / " + Integer.toString(this.getTotalPages()), "Felix Titling", 17, g);

        // Draw Items on screen
        setIncreaser(0);
        for (int i = ((getPageNum()- 1) * 10); i < (getPageNum()*10); i++) {
            if(i <= getMaxIndex()) {
                //Draw left side (Item name)
                changeColor(purple, g);
                drawBoldText(70, 130 + (this.getIncreaser() * 45), this.getShopInventory()[i].getName(), "Felix Titling", 15, g);
                this.setIncreaser(this.getIncreaser() + 1);
            }
        }

        // Draw Cursored Item

        drawBoldText(420, 65, getShopInventory()[getItemIndex()].getName(), "Felix Titling", 20, g);
        drawLine(420, 70, 620, 70, 2, g);

        changeColor(black, g);
        drawBoldText(420, 100, "ATK", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 30, "DEF", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 60, "STR", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 90, "SPD", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 120, "LUK", "Felix Titling", 15, g);

        drawBoldText(690, 100, Integer.toString(getShopInventory()[getItemIndex()].getAttack()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 30, Integer.toString(getShopInventory()[getItemIndex()].getDefense()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 60, Integer.toString(getShopInventory()[getItemIndex()].getStrength()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 90, Integer.toString(getShopInventory()[getItemIndex()].getSpeed()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 120, Integer.toString(getShopInventory()[getItemIndex()].getLuck()), "Felix Titling", 18, g);

        // Display Item Difference
        for(int i=0; i < getPlayer1().getEquipmentSize(); i++){
           if(getShopInventory()[getItemIndex()].getSlot() == getPlayer1().getEquippedItems()[i].getSlot()){
               if(getShopInventory()[getItemIndex()].getAttack() > getPlayer1().getEquippedItems()[i].getAttack()){
                   changeColor(green2, g);
                   drawBoldText(700, 100, " +" + Integer.toString(getShopInventory()[getItemIndex()].getAttack() - getPlayer1().getEquippedItems()[i].getAttack()), "Felix Titling", 18, g);
               } else if (getShopInventory()[getItemIndex()].getAttack() < getPlayer1().getEquippedItems()[i].getAttack()){
                   changeColor(red, g);
                   drawBoldText(700, 100, " -" + Integer.toString(Math.abs(getShopInventory()[getItemIndex()].getAttack() - getPlayer1().getEquippedItems()[i].getAttack())), "Felix Titling", 18, g);
               }
               if(getShopInventory()[getItemIndex()].getDefense() > getPlayer1().getEquippedItems()[i].getDefense()){
                   changeColor(green2, g);
                   drawBoldText(700, 130, " +" + Integer.toString(getShopInventory()[getItemIndex()].getDefense() - getPlayer1().getEquippedItems()[i].getDefense()), "Felix Titling", 18, g);
               } else if (getShopInventory()[getItemIndex()].getDefense() < getPlayer1().getEquippedItems()[i].getDefense()){
                   changeColor(red, g);
                   drawBoldText(700, 130, " -" + Integer.toString(Math.abs(getShopInventory()[getItemIndex()].getDefense() - getPlayer1().getEquippedItems()[i].getDefense())), "Felix Titling", 18, g);
               }
               if(getShopInventory()[getItemIndex()].getStrength() > getPlayer1().getEquippedItems()[i].getStrength()){
                   changeColor(green2, g);
                   drawBoldText(700, 160, " +" + Integer.toString(getShopInventory()[getItemIndex()].getStrength() - getPlayer1().getEquippedItems()[i].getStrength()), "Felix Titling", 18, g);
               } else if (getShopInventory()[getItemIndex()].getStrength() < getPlayer1().getEquippedItems()[i].getStrength()){
                   changeColor(red, g);
                   drawBoldText(700, 160, " -" + Integer.toString(Math.abs(getShopInventory()[getItemIndex()].getStrength() - getPlayer1().getEquippedItems()[i].getStrength())), "Felix Titling", 18, g);
               }
               if(getShopInventory()[getItemIndex()].getSpeed() > getPlayer1().getEquippedItems()[i].getSpeed()){
                   changeColor(green2, g);
                   drawBoldText(700, 190, " +" + Integer.toString(getShopInventory()[getItemIndex()].getSpeed() - getPlayer1().getEquippedItems()[i].getSpeed()), "Felix Titling", 18, g);
               } else if (getShopInventory()[getItemIndex()].getSpeed() < getPlayer1().getEquippedItems()[i].getSpeed()){
                   changeColor(red, g);
                   drawBoldText(700, 190, " -" + Integer.toString(Math.abs(getShopInventory()[getItemIndex()].getSpeed() - getPlayer1().getEquippedItems()[i].getSpeed())), "Felix Titling", 18, g);
               }
               if(getShopInventory()[getItemIndex()].getLuck() > getPlayer1().getEquippedItems()[i].getLuck()){
                   changeColor(green2, g);
                   drawBoldText(700, 220, " +" + Integer.toString(getShopInventory()[getItemIndex()].getLuck() - getPlayer1().getEquippedItems()[i].getLuck()), "Felix Titling", 18, g);
               } else if (getShopInventory()[getItemIndex()].getLuck() < getPlayer1().getEquippedItems()[i].getLuck()){
                   changeColor(red, g);
                   drawBoldText(700, 220, " -" + Integer.toString(Math.abs(getShopInventory()[getItemIndex()].getLuck() - getPlayer1().getEquippedItems()[i].getLuck())), "Felix Titling", 18, g);
               }
           }
        }


        changeColor(purple, g);
        drawBoldText(420, 260, getShopInventory()[getItemIndex()].getSlot().name() + " ITEM", "Felix Titling", 20, g);
        changeColor(black, g);
        drawBoldText(420, 300, getShopInventory()[getItemIndex()].getTooltip() + ".", "Felix Titling", 17, g);
        changeColor(purple, g);
        drawBoldText(420, 500, "Bjarne's Gold:", "Felix Titling", 20, g );
        drawBoldText(420, 350, "PRICE:", "Felix Titling", 20, g );
        changeColor(black, g);
        drawBoldText(670, 500, Integer.toString(getPlayer1().getGpTotal()), "Felix Titling", 20, g);
        drawBoldText(670, 350, Integer.toString(getShopInventory()[getItemIndex()].getBuyPrice()), "Felix Titling", 20, g);

        // Draw extras
        drawBoldText(420, 530, "BUY ITEM [SPACE]", "Felix Titling", 15, g);
        drawBoldText(620, 530, "BACK [ESC]", "Felix Titling", 15, g);


        // Draw purchase results
        if(isPurchaseAttempt()){
            changeColor(black, g);
            drawImage(getDialougeBox(),100, 200, 600, 200, g);
            //drawSolidRectangle(100, 200, 600, 200, g);
            changeColor(white, g);
            if(isPurchaseSuccess()){
                if(!stopper) {
                    playAudio(coin);
                    stopper = true;
                }
                drawBoldText(225, 280, "You bought " + getShopInventory()[getItemIndex()].getName(), "Felix Titling", 20, g) ;
                drawBoldText( 300, 320,  "for " + Integer.toString(getShopInventory()[getItemIndex()].getBuyPrice()) + " gold","Felix Titling", 20, g);
            }else{
                if(getPlayer1().isInventoryFull()) {
                    drawBoldText(225, 280, "Cannot buy " + getShopInventory()[getItemIndex()].getName() + "!", "Felix Titling", 20, g) ;
                    drawBoldText( 275, 320,  "Inventory is full!","Felix Titling", 20, g);
                } else if(getPlayer1().getGpTotal() < getShopInventory()[getItemIndex()].getBuyPrice()){
                    drawBoldText(225, 280, "Cannot buy " + getShopInventory()[getItemIndex()].getName() + "!", "Felix Titling", 20, g) ;
                    drawBoldText( 275, 320,  "Not enough gold!","Felix Titling", 20, g);
                }
            }
            drawBoldText(300, 375, "PRESS [SPACE] TO CLOSE", "Felix Titling", 10, g);
        }

    }

    public int keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            playAudio(clicks);
            if(!isPurchaseAttempt()) {
                if ((getItemIndex()% 10) != 9) {
                    setItemIndex(getItemIndex() + 1);
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            playAudio(clicks);
            if(!isPurchaseAttempt()) {
                if ((getItemIndex()% 10) != 0){
                    setItemIndex(getItemIndex() - 1);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(!isPurchaseAttempt()) {
                if (getPageNum() < getTotalPages()) {
                    playAudio(p1);
                    setPageNum(getPageNum() + 1);
                    setItemIndex(((getPageNum() - 1) * 10));
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){

            if(!isPurchaseAttempt()) {
                if (getPageNum() != 1) {
                    playAudio(p3);
                    setPageNum(getPageNum() - 1);
                    setItemIndex(((getPageNum() - 1) * 10));
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!isPurchaseAttempt()) {
                this.buyItem(getItemIndex());
            } else {
                setPurchaseAttempt(false);
                setPurchaseSuccess(false);
            }
            stopper = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(!isPurchaseAttempt()){
                playAudio(p2);
                return 2;
            }
        }
        return 0;
    }
}





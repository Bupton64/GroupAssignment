import java.awt.*;
import java.awt.event.*;
import java.lang.String;


public class Shop1 extends extraFunctions {

    Shop1(Character playerMan){
        this.player1 = playerMan;
    }
    Character player1;

    public Item[] getShopInventory() {
        return shopInventory;
    }

    public void setShopInventory(Item[] inventory) {
        this.shopInventory = inventory;
    }
    private Item [] shopInventory;
    Image book = loadImage("open.png");
    Image shopBackground;
    int scroller = 100;
    boolean nextPage = false;
    int totalPages = 0;
    int pageNum = 0;
    int shopIndex = 0;
    int pos =0;
    int bar =0;
    int increaser = 0;
    private Item soldItem;
    int current = 0;


    void buyItem(int i){
       Item soldItem = shopInventory[i];
       player1.addItemToInventory(soldItem);
       player1.setGpTotal(player1.getGpTotal()-soldItem.getSellPrice());
    }

    void sellItem(int i){
        player1.getInventory()[i].getSellPrice();
    }

    void shopInit() {
        shopBackground = subImage(book, 0, 0, 544, 416);
        Item[] inventory = new Item[50];
        for(int i = 0;  i < 50; i++){
            inventory[i] = new Item();
        }
        inventory[0] = new item_Equipment("Rusty Sword", 1, 0, 0, 0, 0, Item.Slot.weapon, "An old warriors sword", 10, 0);
        inventory[1] = new item_Equipment("Bronze Sword", 1, 0, 0, 0, 1, Item.Slot.weapon, "Durable and strong", 50, 300);
        inventory[2] = new item_Equipment("Stone Axe", 0, 0, 0, 0, 1, Item.Slot.weapon, "Rugged, yet effective", 300, 400);
        inventory[3] = new item_Equipment("Monk's Staff", 1, 0, 0, 2, 0, Item.Slot.weapon, "A light wooden staff", 300, 1000);
        inventory[4] = new item_Equipment("Rough Axe", 0, 0, 0, 0, 2, Item.Slot.weapon, "A violent edge and little else", 3300, 1200);
        inventory[5]= new item_Equipment("Guardsman's Spear", 1, 0, 1, 0, 0, Item.Slot.weapon, "A military issue spear", 290, 1100);
        inventory[6] = new item_Equipment("Iron Sword", 4, 0, 0, 0, 2, Item.Slot.weapon, "A well forged sword", 600, 2300);
        inventory[7] = new item_Equipment("Iron Sword", 4, 0, 0, 0, 2, Item.Slot.weapon, "A well forged sword", 600, 2300);
        inventory[8] = new item_Equipment("Acolyte's Staff", 2, 0, 0, 5, 0, Item.Slot.weapon, "Crafted from enchanted willow", 620, 2090);
        inventory[9] = new item_Equipment("Steel Sword", 8, 0, 0, 0, 4, Item.Slot.weapon, "Grace and power combined", 1300, 4500);
        inventory[10] = new item_Equipment("Gladiator's Axe", 8, 0, 0, 0, 8, Item.Slot.weapon, "Keen edged and lethal", 1450, 5200);
        inventory[11] = new item_Equipment("Jester's Staff", 4, 0, 0, 10, 0, Item.Slot.weapon, "Lighter than air itself", 1250, 4800);
        inventory[12] = new item_Equipment("Emperor's Word", 4, 0, 6, 0, 0, Item.Slot.weapon, "His voice pierces hearts", 1400, 4950);
        inventory[13] = new item_Equipment("Valkyrie", 10, 10, 4, 0, 8, Item.Slot.weapon, "A legend made reality", 0, 0);
        inventory[14] = new item_Equipment("Ragged Cap", 0, 0, 0, 0, 0, Item.Slot.head, "Stitched leather", 10, 0);
        setShopInventory(inventory);
    }

    void drawShop(Graphics2D g) {
        player1.setGpTotal(10000);
        if(pos == 0) {
            current = scroller / 100;
        }
        clearBackground(800, 600, g);
        drawImage(shopBackground, 0, 0, 800, 600, g);
        changeColor(black, g);
        if (nextPage == true) {
            scroller = 100;
        }
        drawLine(70, scroller + 40, 250, scroller + 40, 2, g);
        drawBoldText(80, 50, "Weapons & Equipment", "Felix Titling", 20, g);
        drawBoldText(500, 500, Integer.toString(pageNum), g);
        int dis = 5;
        if((pos + 5) > 50){
            dis = 50-pos;
        }
        increaser = 0;
        for (int i = pos; i < pos+dis; i++) {
            changeColor(red, g);
            drawBoldText(100, 100+(i*40), Integer.toString(i), g);
            drawBoldText(65, 130 + (increaser * 100),shopInventory[i].getName(), "Felix Titling", 20, g);
            increaser++;
        }
        //drawBoldText(200, 200, shopInventory[0].getName(), g);
        nextPage = false;

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (scroller < 360) {
                scroller += 100;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if (scroller > 100) {
                scroller -= 100;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_TAB) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            pageNum++;
            pos +=5;
            nextPage = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (player1.getGpTotal() > shopInventory[current].getSellPrice()) {
                buyItem(current);
            } else {
                System.out.println("You don't have enough funds boi");
            }
        }
    }
}





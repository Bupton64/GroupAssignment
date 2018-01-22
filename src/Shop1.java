import java.awt.*;
import java.awt.event.*;
import java.lang.String;


public class Shop1 extends shop {

    Shop1(Character playerMan){
        super(playerMan);
    }

    @Override
    public void shopInit() {
        Item[] inventory = new Item[50];
        for(int i = 0;  i < 50; i++){
            inventory[i] = new Item();
        }
        inventory[0] = new item_Equipment("Bronze Sword", 1, 0, 0, 0, 1, Item.Slot.weapon, "Durable and strong", 50, 300);
        inventory[1] = new item_Equipment("Stone Axe", 0, 0, 0, 0, 1, Item.Slot.weapon, "Rugged, yet effective", 300, 400);
        inventory[2] = new item_Equipment("Monk's Staff", 1, 0, 0, 2, 0, Item.Slot.weapon, "A light wooden staff", 300, 1000);
        inventory[3] = new item_Equipment("Rough Axe", 0, 0, 0, 0, 2, Item.Slot.weapon, "A violent edge and little else", 3300, 1200);
        inventory[4] = new item_Equipment("Guardsman's Spear", 1, 0, 1, 0, 0, Item.Slot.weapon, "A military issue spear", 290, 1100);
        inventory[5] = new item_Equipment("Iron Sword", 4, 0, 0, 0, 2, Item.Slot.weapon, "A well forged sword", 600, 2300);
        inventory[6] = new item_Equipment("Acolyte's Staff", 2, 0, 0, 5, 0, Item.Slot.weapon, "Crafted from enchanted willow", 620, 2090);
        inventory[7] = new item_Equipment("Steel Sword", 8, 0, 0, 0, 4, Item.Slot.weapon, "Grace and power combined", 1300, 4500);
        inventory[8] = new item_Equipment("Gladiator's Axe", 8, 0, 0, 0, 8, Item.Slot.weapon, "Keen edged and lethal", 1450, 5200);
        inventory[9] = new item_Equipment("Jester's Staff", 4, 0, 0, 10, 0, Item.Slot.weapon, "Lighter than air itself", 1250, 4800);
        inventory[10] = new item_Equipment("Emperor's Word", 4, 0, 6, 0, 0, Item.Slot.weapon, "His voice pierces hearts", 1400, 4950);
        inventory[11] = new item_Equipment("Valkyrie", 10, 10, 4, 0, 8, Item.Slot.weapon, "A legend made reality", 0, 0);
        setShopInventory(inventory);
    }

    public void drawShop(Graphics2D g) {
        this.getPlayer1().setGpTotal(10000);
        if(this.getPos() == 0) {
            this.setCurrent(this.getScroller() / 100);
        }
        clearBackground(800, 600, g);
        drawImage(this.getShopBackground(), 0, 0, 800, 600, g);
        changeColor(black, g);
        if (this.isNextPage() == true) {
            this.setScroller(100);
        }
        drawLine(70,  this.getScroller() + 40, 250, this.getScroller() + 40, 2, g);
        drawBoldText(80, 50, "Weapons & Equipment", "Felix Titling", 20, g);
        drawBoldText(500, 500, Integer.toString(this.getPageNum()), g);
        int dis = 5;
        if((this.getPos() + 5) > 50){
            dis = 50-this.getPos();
        }
        setIncreaser(0);
        for (int i = this.getPos(); i < this.getPos()+dis; i++) {
            changeColor(red, g);
            drawBoldText(100, 100+(i*40), Integer.toString(i), g);
            drawBoldText(65, 130 + (this.getIncreaser() * 100), this.getShopInventory()[i].getName(), "Felix Titling", 20, g);
            this.setIncreaser(this.getIncreaser() + 1);
        }
        //drawBoldText(200, 200, shopInventory[0].getName(), g);
        setNextPage(false);

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.getScroller() < 360) {
                this.setScroller(this.getScroller() + 100);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.getScroller() > 100) {
                this.setScroller(this.getScroller() - 100);
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_TAB) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            this.setPageNum(this.getPageNum() + 1);
            this.setPos(this.getPos() + 5);
            this.setNextPage(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (this.getPlayer1().getGpTotal() > this.getShopInventory()[this.getCurrent()].getSellPrice()) {
                buyItem(this.getCurrent());
            } else {
                System.out.println("You don't have enough funds boi");
            }
        }
    }
}





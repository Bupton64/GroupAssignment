import java.awt.*;
import java.awt.event.KeyEvent;

public class itemShop extends shop {
    boolean stopper = false;
    itemShop(Character playerMan){
        super(playerMan);
        setTotalPages(1);
        setMaxIndex(4);
    }
    Image equipmentSprite = loadImage("equipmentSprite.png");
    @Override
    public void shopInit() {
        clicks = loadAudio("clicks.wav");
        p1 = loadAudio("page1.wav");
        p2 = loadAudio("page2.wav");
        p3 = loadAudio("page3.wav");
        leave = loadAudio("leave.wav");
        exitClick = loadAudio("exitClick.wav");
        coin = loadAudio("coin.wav");
        Item[] inventory = new Item[50];
        for(int i = 0;  i < 50; i++){
            inventory[i] = new Item();
        }
        inventory[0] = new item_Potion();
        inventory[1] = new item_Antidote();
        inventory[2] = new item_SpeedPotion();
        inventory[3] = new item_Eyedrops();
        inventory[4] = new item_wisdomStone();
        inventory[5] = new item_soulStone();
        inventory[6] = new item_HealingSalve();
        inventory[7] = new item_megaPotion();
        inventory[8] = new item_elixir();

        setShopInventory(inventory);
    }

    public void updateShop(){
        if(getPlayer1().getQuestStage() > 11) { // Beat Valliard
            if (getMaxIndex() < 6) {
                setMaxIndex(6);
            }
        }
        if(getPlayer1().getQuestStage() > 21) { // Beat Razuul
            if (getMaxIndex() < 8) {
                setMaxIndex(8);
            }
        }
        if(getItemIndex() > getMaxIndex()){
            setItemIndex(getMaxIndex());
        }
        setScroller((getItemIndex()%10));
    }

    public void drawShop(Graphics2D g) {
        //< Set up background
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        drawImage(equipmentSprite,0,0,g);
        drawImage(this.getShopBackground(), 0, 0, 800, 600, g);
        changeColor(black, g);
        drawBoldText(80, 60, "SALLY'S PHARMACY", "Felix Titling", 30, g);

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

        changeColor(purple, g);
        drawBoldText(420, 100, getShopInventory()[getItemIndex()].getSlot().name() + " ITEM", "Felix Titling", 20, g);
        changeColor(black, g);
        drawBoldText(420, 130, getShopInventory()[getItemIndex()].getTooltip() + ".", "Felix Titling", 17, g);
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

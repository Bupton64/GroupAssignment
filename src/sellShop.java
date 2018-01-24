import java.awt.*;
import java.awt.event.KeyEvent;

public class sellShop extends shop {

    sellShop(Character playerMan){
        super(playerMan);
        setMaxIndex(playerMan.getInventorySize()-1);
        switch(playerMan.getInventorySize()){
            case 10:
                setTotalPages(1);
                break;
            case 20:
                setTotalPages(2);
                break;
            case 30:
                setTotalPages(3);
                break;
            case 40:
                setTotalPages(4);
                break;
            case 50:
                setTotalPages(5);
                break;
            default:
                setTotalPages((playerMan.getInventorySize()/10)+1);
        }
    }

    @Override
    public void shopInit() {

    }

    public void updtaeShop(){
        switch(getPlayer1().getInventorySize()){
            case 10:
                setTotalPages(1);
                break;
            case 20:
                setTotalPages(2);
                break;
            case 30:
                setTotalPages(3);
                break;
            case 40:
                setTotalPages(4);
                break;
            case 50:
                setTotalPages(5);
                break;
            default:
                setTotalPages((getPlayer1().getInventorySize()/10)+1);
        }
        setMaxIndex(getPlayer1().getInventorySize()-1);
        if(getItemIndex() > getMaxIndex()){
            setItemIndex(getMaxIndex());
        }
        setScroller((getItemIndex()%10));
    }

    public void drawShop(Graphics2D g) {
        //< Set up background
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        drawImage(this.getShopBackground(), 0, 0, 800, 600, g);
        changeColor(black, g);
        drawBoldText(80, 60, "SELL TO VENDOR", "Felix Titling", 30, g);

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
                drawBoldText(70, 130 + (this.getIncreaser() * 45), getPlayer1().getInventory()[i].getName(), "Felix Titling", 15, g);
                this.setIncreaser(this.getIncreaser() + 1);
            }
        }

        // Draw Cursored Item
        if(getPlayer1().getInventory()[getItemIndex()].getSlot() == Item.Slot.bag){
            drawBoldText(420, 65, getPlayer1().getInventory()[getItemIndex()].getName(), "Felix Titling", 20, g);
            drawLine(420, 70, 620, 70, 2, g);

            changeColor(black, g);

            changeColor(purple, g);
            drawBoldText(420, 100, getPlayer1().getInventory()[getItemIndex()].getSlot().name() + " ITEM", "Felix Titling", 20, g);
            changeColor(black, g);
            drawBoldText(420, 130, getPlayer1().getInventory()[getItemIndex()].getTooltip() + ".", "Felix Titling", 17, g);
        } else {
            drawBoldText(420, 65, getPlayer1().getInventory()[getItemIndex()].getName(), "Felix Titling", 20, g);
            drawLine(420, 70, 620, 70, 2, g);

            changeColor(black, g);
            drawBoldText(420, 100, "ATK", "Felix Titling", 15, g);
            drawBoldText(420, 100 + 30, "DEF", "Felix Titling", 15, g);
            drawBoldText(420, 100 + 60, "STR", "Felix Titling", 15, g);
            drawBoldText(420, 100 + 90, "SPD", "Felix Titling", 15, g);
            drawBoldText(420, 100 + 120, "LUK", "Felix Titling", 15, g);

            drawBoldText(690, 100, Integer.toString(getPlayer1().getInventory()[getItemIndex()].getAttack()), "Felix Titling", 18, g);
            drawBoldText(690, 100 + 30, Integer.toString(getPlayer1().getInventory()[getItemIndex()].getDefense()), "Felix Titling", 18, g);
            drawBoldText(690, 100 + 60, Integer.toString(getPlayer1().getInventory()[getItemIndex()].getStrength()), "Felix Titling", 18, g);
            drawBoldText(690, 100 + 90, Integer.toString(getPlayer1().getInventory()[getItemIndex()].getSpeed()), "Felix Titling", 18, g);
            drawBoldText(690, 100 + 120, Integer.toString(getPlayer1().getInventory()[getItemIndex()].getLuck()), "Felix Titling", 18, g);

            changeColor(purple, g);
            drawBoldText(420, 260, getPlayer1().getInventory()[getItemIndex()].getSlot().name() + " ITEM", "Felix Titling", 20, g);
            changeColor(black, g);
            drawBoldText(420, 300, getPlayer1().getInventory()[getItemIndex()].getTooltip() + ".", "Felix Titling", 17, g);
        }
        changeColor(purple, g);
        drawBoldText(420, 450, "Bjarne's Gold:", "Felix Titling", 20, g);
        drawBoldText(420, 500, "SELL FOR:", "Felix Titling", 20, g);
        changeColor(black, g);
        drawBoldText(670, 450, Integer.toString(getPlayer1().getGpTotal()), "Felix Titling", 20, g);
        drawBoldText(670, 500, Integer.toString(getPlayer1().getInventory()[getItemIndex()].getSellPrice()), "Felix Titling", 20, g);

        // Draw extras
        drawBoldText(420, 530, "BUY ITEM [SPACE]", "Felix Titling", 15, g);
        drawBoldText(620, 530, "BACK [ESC]", "Felix Titling", 15, g);

        // If Sale
        if(isSaleMade()){
            changeColor(black, g);
            drawImage(getDialougeBox(),100, 200, 600, 200, g);
            changeColor(white, g);
            drawBoldText(225, 280, "You sold " + getLastSoldName(), "Felix Titling", 20, g) ;
            drawBoldText( 300, 320,  "for " + getLastSoldPrice() + " gold","Felix Titling", 20, g);
        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(!isPurchaseAttempt()) {
                if ((getItemIndex()% 10) != 9) {
                    setItemIndex(getItemIndex() + 1);
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(!isPurchaseAttempt()) {
                if ((getItemIndex()% 10) != 0){
                    setItemIndex(getItemIndex() - 1);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(!isPurchaseAttempt()) {
                if (getPageNum() < getTotalPages()) {
                    setPageNum(getPageNum() + 1);
                    setItemIndex(((getPageNum() - 1) * 10));
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if(!isPurchaseAttempt()) {
                if (getPageNum() != 1) {
                    setPageNum(getPageNum() - 1);
                    setItemIndex(((getPageNum() - 1) * 10));
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!isSaleMade()) {
                this.sellItem(getItemIndex());
                if(getPageNum() == getTotalPages()){
                    if(getMaxIndex()%10 == 0){
                        setPageNum(getPageNum()-1);
                        setItemIndex(((getPageNum() - 1) * 10));
                    }
                }
            } else {
                setSaleMade(false);
            }
        }
    }

}
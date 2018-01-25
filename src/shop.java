import java.awt.*;

abstract public class shop extends extraFunctions {

    private Character player1;
    private Item boughtItem;
    private Item soldItem;
    private int increaser;
    private int totalPages;
    private int pageNum;
    private int shopIndex;
    private int itemIndex;
    private int maxIndex;
    private Item [] shopInventory;
    private Image book;
    private Image shopBackground;
    private int scroller;
    private boolean purchaseSuccess;
    private boolean purchaseAttempt;
    private boolean saleMade;
    private Image dialougeBox;
    private String lastSoldName;
    private int lastSoldPrice;


    shop(Character playerMan){this.init(playerMan); }

    public void init(Character playerMan){
        this.dialougeBox = loadImage("dialogue_Boxes.png");
        this.dialougeBox = subImage(dialougeBox, 11, 11, 490, 100);
        this.player1 = playerMan;
        this.increaser = 0;
        this.totalPages = 0;
        this.pageNum = 1;
        this.shopIndex = 0;
        this.book = loadImage("open.png");
        this.shopBackground = subImage(book, 0, 0, 544, 416);
        this.scroller = 100;
        this.shopInit();
        this.purchaseAttempt = false;
        this.purchaseSuccess = false;
    }

    abstract public void shopInit();

    public void buyItem(int i){
        purchaseAttempt = true;
        if(player1.getGpTotal() >= shopInventory[i].getBuyPrice()) {
            if(!player1.isInventoryFull()) {
                Item soldItem = shopInventory[i];
                player1.addItemToInventory(soldItem);
                player1.setGpTotal(player1.getGpTotal() - soldItem.getBuyPrice());
                purchaseSuccess = true;
            } else{
                purchaseSuccess = false;
            }
        } else{
            purchaseSuccess = false;
        }
    }

    void sellItem(int i){
        saleMade=true;
        lastSoldName = player1.getInventory()[i].getName();
        lastSoldPrice = player1.getInventory()[i].getSellPrice();
        player1.setGpTotal(player1.getInventory()[i].getSellPrice() + player1.getGpTotal());
        if(player1.getInventory()[i].getCounter() > 1){
            player1.getInventory()[i].setCounter(player1.getInventory()[i].getCounter() - 1);
        } else {
            player1.removeFromInventory(player1.getInventory()[i]);
        }
    }

    //< Getters and Setters


    public String getLastSoldName() {
        return lastSoldName;
    }

    public void setLastSoldName(String lastSoldName) {
        this.lastSoldName = lastSoldName;
    }

    public int getLastSoldPrice() {
        return lastSoldPrice;
    }

    public void setLastSoldPrice(int lastSoldPrice) {
        this.lastSoldPrice = lastSoldPrice;
    }

    public boolean isSaleMade() {
        return saleMade;
    }

    public void setSaleMade(boolean saleMade) {
        this.saleMade = saleMade;
    }

    public Image getDialougeBox() {
        return dialougeBox;
    }

    public void setDialougeBox(Image dialougeBox) {
        this.dialougeBox = dialougeBox;
    }

    public boolean isPurchaseAttempt() {
        return purchaseAttempt;
    }

    public void setPurchaseAttempt(boolean purchaseAttempt) {
        this.purchaseAttempt = purchaseAttempt;
    }

    public boolean isPurchaseSuccess() {
        return purchaseSuccess;
    }

    public void setPurchaseSuccess(boolean purchaseSuccess) {
        this.purchaseSuccess = purchaseSuccess;
    }

    public Item getBoughtItem() {
        return boughtItem;
    }

    public void setBoughtItem(Item boughtItem) {
        this.boughtItem = boughtItem;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public Item[] getShopInventory() {
        return shopInventory;
    }

    public void setShopInventory(Item[] inventory) {
        this.shopInventory = inventory;
    }

    public Character getPlayer1() {
        return player1;
    }

    public void setPlayer1(Character player1) {
        this.player1 = player1;
    }

    public Item getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(Item soldItem) {
        this.soldItem = soldItem;
    }

    public int getIncreaser() {
        return increaser;
    }

    public void setIncreaser(int increaser) {
        this.increaser = increaser;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getShopIndex() {
        return shopIndex;
    }

    public void setShopIndex(int shopIndex) {
        this.shopIndex = shopIndex;
    }

    public Image getBook() {
        return book;
    }

    public void setBook(Image book) {
        this.book = book;
    }

    public Image getShopBackground() {
        return shopBackground;
    }

    public void setShopBackground(Image shopBackground) {
        this.shopBackground = shopBackground;
    }

    public int getScroller() {
        return scroller;
    }

    public void setScroller(int scroller) {
        this.scroller = scroller;
    }

}

import java.awt.*;

abstract public class shop extends extraFunctions {

    private Character player1;
    private int current;
    private Item soldItem;
    private int increaser;
    private int totalPages;
    private int pageNum;
    private int shopIndex;
    private int pos;
    private int bar;
    private Item [] shopInventory;
    private Image book;
    private Image shopBackground;
    private int scroller;
    private boolean nextPage;


    shop(Character playerMan){this.init(playerMan); }

    public void init(Character playerMan){
        this.player1 = playerMan;
        this.current = 0;
        this.increaser = 0;
        this.totalPages = 0;
        this.pageNum = 0;
        this.shopIndex = 0;
        this.pos = 0;
        this.bar = 0;
        this.book = loadImage("open.png");
        this.shopBackground = subImage(book, 0, 0, 544, 416);
        this.scroller = 100;
        this.nextPage = false;
        this.shopInit();
    }

    abstract public void shopInit();

    void buyItem(int i){
        if(player1.getGpTotal() >= shopInventory[i].getBuyPrice()) {
            if(!player1.isInventoryFull()) {
                Item soldItem = shopInventory[i];
                player1.addItemToInventory(soldItem);
                player1.setGpTotal(player1.getGpTotal() - soldItem.getBuyPrice());
            }
        } else{
            return;
        }
    }

    void sellItem(int i){
        player1.setGpTotal(player1.getInventory()[i].getSellPrice() + player1.getGpTotal());
        player1.removeFromInventory(player1.getInventory()[i]);
    }

    //< Getters and Setters
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

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
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

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
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

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

}

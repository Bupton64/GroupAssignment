import java.awt.*;
import java.awt.event.*;

public class ShopControl extends extraFunctions {



    ShopControl(Character player){
        this.playerMan = player;
        initShopControl();
    }

    /////////////////////////////////
    ///
    ///  start
    ///
    ////////////////////////////////



    private void updateStartShop(){

        if(menuOption == 0){
            menuPointerPosX = 150;
        }else if(menuOption == 1){
            menuPointerPosX = 500;
        }

    }

    private void drawStartShop(Graphics2D g){
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        drawImage(background, 0, 0, 800, 600, g);
        changeColor(white, g);
        drawImage(buttonSprite, 150, 250, g);
        drawImage(buttonSprite, 500, 250, g);
        drawImage(menuPointer, menuPointerPosX,menuPointerPosY,g);
        drawText(215,295,"Buy","Arial",30,g);
        drawText(565,295,"Sell","Arial",30,g);
    }



    /////////////////////////////////
    ///
    ///  Buy
    ///
    ////////////////////////////////

    private void updateBuyShop(){
        if(menuOption == 0){
            menuPointerPosX = 130;
        }else if(menuOption == 1){
            menuPointerPosX = 480;
        }
    }



    private void drawBuyShop(Graphics2D g){
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        drawImage(background, 0, 0, 800, 600, g);
        changeColor(white, g);
        drawImage(buttonSprite, 150, 250, g);
        drawImage(buttonSprite, 500, 250, g);
        drawImage(menuPointer, menuPointerPosX,menuPointerPosY,g);
        if(shopNum == 0){
            drawText(215,295,"Weapons","Arial",30,g);
            drawText(565,295,"Armor","Arial",30,g);
        }else{
            drawText(175,295,"Accessories","Arial",24,g);
            drawText(525,295,"Consumable","Arial",24,g);
        }

    }



    /////////////////////////////////
    ///
    ///  Game
    ///
    ////////////////////////////////

    private Image background;
    private Image buttonSprite;
    private Image menuPointer;

    private int menuOption;
    private double menuPointerPosX;
    private double menuPointerPosY;


    enum ShopState {Start, Sell, Buy, BuyWeapons, BuyArmor, BuyAccessories, BuyConsumables}
    ShopState state;

    private Character playerMan;
    private int shopStateChanger;
    private int shopNum;

    private sellShop sellController;
    private weaponShop weaponController;
    private armorShop armorController;
    private accessoriesShop accessoriesController;
    private itemShop consumablesController;



    private void initShopControl(){
        clicks = loadAudio("clicks.wav");
        p1 = loadAudio("page1.wav");
        p2 = loadAudio("page2.wav");
        p3 = loadAudio("page3.wav");
        leave = loadAudio("leave.wav");
        exitClick = loadAudio("exitClick.wav");
        shopNum = 0;
        state = ShopState.Start;
        shopStateChanger = 0;
        menuOption = 0;
        menuPointerPosX = 200;
        menuPointerPosY = 260;
        background = loadImage("open.png");
        background = subImage(background, 0, 0, 544, 416);
        buttonSprite =  loadImage("buttons.png");
        buttonSprite = subImage(buttonSprite,30,70,180,80);
        menuPointer = loadImage("arrowhead.png");
        menuPointer = subImage(menuPointer,0,96,48,48);

        sellController = new sellShop(playerMan);
        weaponController = new weaponShop(playerMan);
        armorController = new armorShop(playerMan);
        accessoriesController = new accessoriesShop(playerMan);
        consumablesController = new itemShop(playerMan);

    }



    private void updateShopState(){
        switch(shopStateChanger) {
            case 0:
                break;
            case 1:
                state = ShopState.Start;
                break;
            case 2:
                state = ShopState.Buy;
                break;
            case 3:
                state = ShopState.Sell;
                break;
            case 4:
                state = ShopState.BuyWeapons;
                break;
            case 5:
                state = ShopState.BuyArmor;
                break;
            case 6:
                state = ShopState.BuyAccessories;
                break;
            case 7:
                state = ShopState.BuyConsumables;
                break;
        }
        shopStateChanger = 0;
    }


    public void updateShopControl(int shopNum ){
        this.shopNum = shopNum;
        updateShopState();
        switch (state){
            case Start:
                updateStartShop();
                break;
            case Buy:
                updateBuyShop();
                break;
            case Sell:
                sellController.updateShop();
                break;
            case BuyWeapons:
                weaponController.updateShop();
                break;
            case BuyArmor:
                armorController.updateShop();
                break;
            case BuyAccessories:
                accessoriesController.updateShop();
                break;
            case BuyConsumables:
                consumablesController.updateShop();
                break;
        }
    }


    public void drawShopControl(Graphics2D g){
        changeColor(red, g);
        switch (state){
            case Start:
                drawStartShop(g);
                break;
            case Buy:
                drawBuyShop(g);
                break;
            case Sell:
                sellController.drawShop(g);
                break;
            case BuyWeapons:
                weaponController.drawShop(g);
                break;
            case BuyArmor:
                armorController.drawShop(g);
                break;
            case BuyAccessories:
                accessoriesController.drawShop(g);
                break;
            case BuyConsumables:
                consumablesController.drawShop(g);
                break;
        }
    }


    /////////////////////////////////
    ///
    ///   KeyBinds
    ///
    ////////////////////////////////

    public int keyPressed(KeyEvent e) {
        switch(state){
            case Start:
                return startKeyPressed(e);
            case Sell:
                shopStateChanger = sellController.keyPressed(e);
                break;
            case Buy:
                buyKeyPressed(e);
                break;
            case BuyWeapons:
                shopStateChanger = weaponController.keyPressed(e);
                break;
            case BuyArmor:
                shopStateChanger = armorController.keyPressed(e);
                break;
            case BuyAccessories:
                shopStateChanger = accessoriesController.keyPressed(e);
                break;
            case BuyConsumables:
                shopStateChanger = consumablesController.keyPressed(e);
                break;
        }
        return 0;
    }


    private int startKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playAudio(clicks);
            if(menuOption == 1){
                menuOption = 0;
            }else{
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playAudio(clicks);
            if(menuOption == 1){
                menuOption = 0;
            }else{
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            playAudio(clicks);
            if(menuOption == 0){
                shopStateChanger = 2;
            }else{
                shopStateChanger = 3;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playAudio(exitClick);


            return 1;
        }
        return 0;
    }

    private void buyKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playAudio(clicks);

            if(menuOption == 1){
                menuOption = 0;
            }else{
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            playAudio(clicks);

            if (menuOption == 1) {
                menuOption = 0;
            } else {
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            playAudio(clicks);

            if(menuOption == 0 && shopNum == 0){
                shopStateChanger = 4;
            }else if(menuOption == 1 && shopNum == 0){
                shopStateChanger = 5;
            }else if(menuOption == 0 && shopNum == 1){
                shopStateChanger = 6;
            }else if(menuOption == 1 && shopNum == 1){
                shopStateChanger = 7;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playAudio(leave);
            shopStateChanger = 1;
            menuOption = 0;
        }
    }
}

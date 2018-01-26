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
            menuPointerPosY = 200;
        }else if(menuOption == 1){
            menuPointerPosY = 250;
        }

    }

    private void drawStartShop(Graphics2D g){
            drawSolidCircle(menuPointerPosX,menuPointerPosY,5,g);
            drawText(200,200,"Buy","Arial",30,g);
            drawText(200,250,"Sell","Arial",30,g);
    }



    /////////////////////////////////
    ///
    ///  Buy
    ///
    ////////////////////////////////

    private void updateBuyShop(){
        if(menuOption == 0){
            menuPointerPosY = 200;
        }else if(menuOption == 1){
            menuPointerPosY = 300;
        }
    }



    private void drawBuyShop(Graphics2D g){
        drawSolidCircle(menuPointerPosX,menuPointerPosY,5,g);
        if(shopNum == 0){
            drawText(200,200,"Weapons","Arial",30,g);
            drawText(200,300,"Armor","Arial",30,g);
        }else{
            drawText(200,200,"Accessories","Arial",30,g);
            drawText(200,300,"Consumable","Arial",30,g);
        }

    }



    /////////////////////////////////
    ///
    ///  Game
    ///
    ////////////////////////////////


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
        menuPointerPosX = 180;
        menuPointerPosY = 200;

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
        if(e.getKeyCode() == KeyEvent.VK_UP){
            playAudio(clicks);
            if(menuOption == 1){
                menuOption = 0;
            }else{
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
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
        if(e.getKeyCode() == KeyEvent.VK_UP){
            playAudio(clicks);

            if(menuOption == 1){
                menuOption = 0;
            }else{
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
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

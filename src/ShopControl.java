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


    int menuOption;
    double menuPointerPosX;
    double menuPointerPosY;

    public void updateStartShop(double dt){

        if(menuOption == 0){
            menuPointerPosY = 200;
        }else if(menuOption == 1){
            menuPointerPosY = 250;
        }

    }

    public void drawStartShop(Graphics2D g){

            drawSolidCircle(menuPointerPosX,menuPointerPosY,5,g);

            drawText(200,200,"Buy","Arial",30,g);
            drawText(200,250,"Sell","Arial",30,g);
    }



    /////////////////////////////////
    ///
    ///  Buy
    ///
    ////////////////////////////////

    public void updateBuyShop(double dt){
        if(menuOption == 0){
            menuPointerPosY = 200;
        }else if(menuOption == 1){
            menuPointerPosY = 300;
        }

    }

    int shopNum = 0;

    public void drawBuyShop(Graphics2D g){

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




    enum ShopState {Start, Sell, Buy, BuyWeapons, BuyArmor, BuyAccessories, BuyConsumables}
    ShopState state;

    Character playerMan;
    int shopStateChanger;

    sellShop sellController;
    weaponShop weaponController;
    armorShop armorController;
    accessoriesShop accessoriesController;
    itemShop ConsumablesController;



    public void initShopControl(){
        state = ShopState.Start;
        shopStateChanger = 0;
        menuOption = 0;
        menuPointerPosX = 180;
        menuPointerPosY = 200;

        sellController = new sellShop(playerMan);
        weaponController = new weaponShop(playerMan);
        armorController = new armorShop(playerMan);
        accessoriesController = new accessoriesShop(playerMan);
        ConsumablesController = new itemShop(playerMan);

    }



    public void updateShopState(){
        if(shopStateChanger != 0){

            switch(shopStateChanger) {
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

    }


    public int updateShopControl(double dt,int shopNum ){
        this.shopNum = shopNum;
        updateShopState();

//        switch(state){
//            case Sell:
//
//        }

        if(state == ShopState.Start){
            updateStartShop(dt);
        }else if(state == ShopState.Sell){
            sellController.updateShop();
        }else if(state == ShopState.Buy){
            updateBuyShop(dt);
        }else if(state == ShopState.BuyWeapons){
            weaponController.updateShop();
        }else if(state == ShopState.BuyArmor){
            armorController.updateShop();
        }else if(state == ShopState.BuyAccessories){
            accessoriesController.updateShop();
        }else if(state == ShopState.BuyConsumables){
            ConsumablesController.updateShop();
        }

        return 0;


    }


    public void drawShopControl(Graphics2D g){

        changeColor(red, g);
        if(state == ShopState.Start){
            drawStartShop(g);
        }else if(state == ShopState.Sell){
            sellController.drawShop(g);
        }else if(state == ShopState.Buy){
            drawBuyShop(g);
        }else if(state == ShopState.BuyWeapons){
            weaponController.drawShop(g);
        }else if(state == ShopState.BuyArmor){
            armorController.drawShop(g);
        }else if(state == ShopState.BuyAccessories){
            accessoriesController.drawShop(g);
        }else if(state == ShopState.BuyConsumables){
            ConsumablesController.drawShop(g);
        }


    }


    /////////////////////////////////
    ///
    ///   KeyBinds
    ///
    ////////////////////////////////

    public int keyPressed(KeyEvent e) {
        if(state == ShopState.Start){
            return startKeyPressed(e);
        }else if(state == ShopState.Sell){
            shopStateChanger = sellController.keyPressed(e);
        }else if(state == ShopState.Buy){
            buyKeyPressed(e);
        }else if(state == ShopState.BuyWeapons){
            shopStateChanger = weaponController.keyPressed(e);
        }else if(state == ShopState.BuyArmor){
            shopStateChanger = armorController.keyPressed(e);
        }else if(state == ShopState.BuyAccessories){
            shopStateChanger = accessoriesController.keyPressed(e);
        }else if(state == ShopState.BuyConsumables){
            shopStateChanger = ConsumablesController.keyPressed(e);
        }

        return 0;



    }


    public int startKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(menuOption == 1){
                menuOption = 0;
               // menuPointerPosY = 250;
            }else{
              //  menuPointerPosY = 200;
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(menuOption == 1){
                menuOption = 0;
            }else{
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(menuOption == 0){
                shopStateChanger = 2;
            }else{
                shopStateChanger = 3;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            return 1;
        }
        return 0;
    }

    public void buyKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(menuOption == 1){
                menuOption = 0;
                // menuPointerPosY = 250;
            }else{
                //  menuPointerPosY = 200;
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (menuOption == 1) {
                menuOption = 0;
            } else {
                menuOption = 1;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){

            if(menuOption == 0 && shopNum == 0){
                shopStateChanger = 4;
            }
            if(menuOption == 1 && shopNum == 0){
                shopStateChanger = 5;
            }
            if(menuOption == 0 && shopNum == 1){
                shopStateChanger = 6;
            }
            if(menuOption == 1 && shopNum == 1){
                shopStateChanger = 7;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            shopStateChanger = 1;
            menuOption = 0;
        }
    }





}

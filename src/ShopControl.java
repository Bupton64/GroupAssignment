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

    }

    public void drawStartShop(Graphics2D g){

            drawText(200,200,"Buy","Arial",30,g);
            drawText(200,300,"Sell","Arial",30,g);
    }



    /////////////////////////////////
    ///
    ///  Buy
    ///
    ////////////////////////////////

    public void updateBuyShop(double dt){


    }


    public void drawBuyShop(Graphics2D g){
        drawText(200,200,"Weapons","Arial",30,g);
        drawText(200,250,"Armor","Arial",30,g);
        drawText(200,300,"Accessories","Arial",30,g);
        drawText(200,350,"Consumable","Arial",30,g);

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

    weaponShop weaponController;



    public void initShopControl(){
        state = ShopState.Start;
        menuOption = 0;
        menuPointerPosX = 180;
        menuPointerPosY = 150;

    }

    public void updateShopState(){

    }


    public int updateShopControl(double dt){

        if(state == ShopState.Start){
            updateStartShop(dt);
        }else if(state == ShopState.Sell){

        }else if(state == ShopState.Buy){
            updateBuyShop(dt);
        }else if(state == ShopState.BuyWeapons){

        }else if(state == ShopState.BuyArmor){

        }else if(state == ShopState.BuyAccessories){

        }else if(state == ShopState.BuyConsumables){

        }

        return 0;


    }


    public void drawShopControl(Graphics2D g){

        if(state == ShopState.Start){
            drawStartShop(g);
        }else if(state == ShopState.Sell){

        }else if(state == ShopState.Buy){
            drawBuyShop(g);
        }else if(state == ShopState.BuyWeapons){

        }else if(state == ShopState.BuyArmor){

        }else if(state == ShopState.BuyAccessories){

        }else if(state == ShopState.BuyConsumables){

        }


    }


    /////////////////////////////////
    ///
    ///   KeyBinds
    ///
    ////////////////////////////////

    public void keyPressed(KeyEvent e) {
        if(state == ShopState.Start){

        }else if(state == ShopState.Sell){

        }else if(state == ShopState.Buy){

        }else if(state == ShopState.BuyWeapons){

        }else if(state == ShopState.BuyArmor){

        }else if(state == ShopState.BuyAccessories){

        }else if(state == ShopState.BuyConsumables){

        }


    }





}

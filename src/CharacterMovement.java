

import java.awt.*;
import java.awt.event.*;




public class CharacterMovement extends extraFunctions implements KeyListener {


    ///////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////

    CharacterMovement(Character playerMan){
        this.playerMan = playerMan;
        initCharMovement();

    }

    double walkTimer;
    double walkDuration;
    double monsterDelay;

    boolean right;
    boolean left;
    boolean up;
    boolean down;

    boolean lockRight;
    boolean lockLeft;
    boolean lockUp;
    boolean lockDown;


    public void setLockRight(boolean lockRight) {
        this.lockRight = lockRight;
    }

    public void setLockLeft(boolean lockLeft) {
        this.lockLeft = lockLeft;
    }

    public void setLockUp(boolean lockUp) {
        this.lockUp = lockUp;
    }

    public void setLockDown(boolean lockDown) {
        this.lockDown = lockDown;
    }

    Image charSpriteSheet;
    Image[] playerMoveRight;
    Image[] playerMoveLeft;
    Image[] playerMoveUp;
    Image[] playerMoveDown;

    Character playerMan;

    double dx;
    double dy;


    public void initCharMovement(){

        lockRight = false;
        lockLeft = false;
        lockUp = false;
        lockDown = false;

        charSpriteSheet = loadImage("Image/charspritesheet.png");
        playerMan.setDirectionFacing(Character.Direction.down);

        playerMoveRight = new Image[3];
        playerMoveLeft = new Image[3];
        playerMoveDown = new Image[3];
        playerMoveUp = new Image[3];

        for(int i =0; i < 3;i++){
            playerMoveRight[i] = subImage(charSpriteSheet,0 + (52 * i), 144,52,72);
        }
        for(int i =0; i < 3;i++){
            playerMoveLeft[i] = subImage(charSpriteSheet,0 + (52 * i), 72,52,72);
        }
        for(int i =0; i < 3;i++){
            playerMoveUp[i] = subImage(charSpriteSheet,0 + (52 * i), 216,52,72);
        }
        for(int i =0; i < 3;i++){
            playerMoveDown[i] = subImage(charSpriteSheet,0 + (52 * i), 0,52,72);
        }
        walkTimer = 0;
        walkDuration = 0.16;
        monsterDelay = 0;

    }

    public int updateCharMovement(double dt, Character playerMan){
        dx = playerMan.getMapPosX();
        dy = playerMan.getMapPosY();


        if (down && !lockDown && !up) {
//            directionFacing = Direction.down;
            dy += 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosY(dy);
        }
        if (right && !lockRight && !left) {
        //    directionFacing = Direction.right;
            dx += 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosX(dx);
        }
        if (left && !lockLeft && !right) {
           // directionFacing = Direction.left;
            dx -= 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosX(dx);
        }
        if (up && !lockUp && !down) {
         //   directionFacing = Direction.up;
            dy -= 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosY(dy);
        }

        if(monsterDelay > 6){
            monsterDelay = 0;
           if(Math.random() * 20 > 17) { // was 17
             return  checkCombat(playerMan);
           }
        }
        return 0;
    }

    public void drawCharMovement(Graphics g) {
        if (right) {
            playerMan.setDirectionFacing(Character.Direction.right);
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveRight[j], dx, dy, 50, 70,g);
        } else if (left) {
            playerMan.setDirectionFacing(Character.Direction.left);
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveLeft[j], dx, dy, 50, 70,g);
        } else if (up) {
            playerMan.setDirectionFacing(Character.Direction.up);
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveUp[j], dx, dy, 50, 70,g);
        } else if (down) {
            playerMan.setDirectionFacing(Character.Direction.down);
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveDown[j], dx, dy, 50, 70,g);
        }
        if(checkStationary()) {
            if (playerMan.getDirection() == Character.Direction.right) {
                drawImage(playerMoveRight[1], dx, dy, 50, 70,g);

            } else if (playerMan.getDirection() == Character.Direction.left) {
                drawImage(playerMoveLeft[1], dx, dy, 50, 70,g);

            } else if (playerMan.getDirection() == Character.Direction.up) {
                drawImage(playerMoveUp[1], dx, dy, 50, 70,g);

            } else if (playerMan.getDirection() == Character.Direction.down) {
                drawImage(playerMoveDown[1], dx, dy, 50, 70,g);

            }

        }
    }

    ////////////////////////////////////////
    ///
    ///   Combat Integration
    ///
    ////////////////////////////////////////////

    public int checkCombat(Character playerMan){
        switch((int)playerMan.getCurrentMapLocation()){
            case 21:
            case 20:
            case 28:
            case 29:
            case 39:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                break;
            case 17:
                if(playerMan.getCurrentQuestName() != "A Wizards Problem"){
                    break;
                }
                playerMan.setCombatActive(true);
                playerMan.setMonsterGen(0);
                return 9;
            default :

                playerMan.setCombatActive(true);
                playerMan.setMonsterGen(0);
                return 9;
        }
        return 0;

    }

    public boolean checkStationary(){
        if(!right && !left && !up && !down){
            return true;
        }
        return false;
    }

    public void stopMovement(){

       lockDown = true;
       lockLeft= true;
       lockRight = true;
       lockUp = true;
        right = false;
        left = false;
        up = false;
        down = false;
    }










    ////////////////////////////////
    ///
    /// Key Binds
    ///
    /////////////////////////////


    public void keyPressed (KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
            right = true;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT ){
            left = true;
        }else if(e.getKeyCode() == KeyEvent.VK_UP ){
            up = true;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN ){
            down = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_ALT ){
            down = false;
            up = false;
            left = false;
            right = false;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

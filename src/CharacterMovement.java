

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

    enum Direction {up,down,left,right};
   Direction directionFacing;

   public Direction getDirection(){
       return directionFacing;
   }

    public void initCharMovement(){


        lockRight = false;
        lockLeft = false;
        lockUp = false;
        lockDown = false;

        charSpriteSheet = loadImage("charspritesheet.png");
        directionFacing = Direction.down;
        playerMan.setMapPosX(250);
        playerMan.setMapPosY(210);
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


        if (right && !lockRight ) {
            directionFacing = Direction.right;
            dx += 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosX(dx);
        }
        if (left && !lockLeft) {
            directionFacing = Direction.left;
            dx -= 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosX(dx);
        }
        if (up && !lockUp) {
            directionFacing = Direction.up;
            dy -= 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosY(dy);
        }
        if (down && !lockDown) {
            directionFacing = Direction.down;
            dy += 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosY(dy);
        }

        if(monsterDelay > 6){
            monsterDelay = 0;
           if(Math.random() * 20 > 17) {
             return  checkCombat(playerMan);
           }
        }
        return 0;
    }

    public void drawCharMovement(Graphics g) {
        if (right) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveRight[j], dx, dy, 50, 70,g);
        } else if (left) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveLeft[j], dx, dy, 50, 70,g);
        } else if (up) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveUp[j], dx, dy, 50, 70,g);
        } else if (down) {
            int j = getAnimationFrame(walkTimer, walkDuration, 3);
            drawImage(playerMoveDown[j], dx, dy, 50, 70,g);
        } else {
            if (directionFacing == Direction.right) {
                drawImage(playerMoveRight[0], dx, dy, 50, 70,g);

            } else if (directionFacing == Direction.left) {
                drawImage(playerMoveLeft[0], dx, dy, 50, 70,g);

            } else if (directionFacing == Direction.up) {
                drawImage(playerMoveUp[0], dx, dy, 50, 70,g);

            } else if (directionFacing == Direction.down) {
                drawImage(playerMoveDown[0], dx, dy, 50, 70,g);

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
                break;
            case 20:
                break;
            case 28:
                break;
            case 29:
                break;
            default :

                playerMan.setCombatActive(true);
                return 2;
        }
        return 0;

    }

    public boolean checkStationary(){
        if(!right && !left && !up && !down){
            return true;
        }
        return false;
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

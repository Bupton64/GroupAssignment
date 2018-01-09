

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
        charSpriteSheet = loadImage("charspritesheet.png");
        directionFacing = Direction.right;
        playerMan.setMapPosX(250);
        playerMan.setMapPosY(250);
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

    public void updateCharMovement(double dt, Collision collisionDetector ,boolean[] createCombat, Character playerMan){
        dx = playerMan.getMapPosX();
        dy = playerMan.getMapPosY();


        if (right && !collisionDetector.getLockRight()) {

            dx += 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosX(dx);
        }
        if (left && !collisionDetector.getLockLeft()) {

            dx -= 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosX(dx);
        }
        if (up && !collisionDetector.getLockUp()) {


                dy -= 5;


            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
            playerMan.setMapPosY(dy);
        }
        if (down && !collisionDetector.getLockDown()) {

                dy += 5;
            walkTimer += dt;
            if (walkTimer > walkDuration) {
                monsterDelay++;
                walkTimer -= walkDuration;
            }
        }
        playerMan.setMapPosY(dy);
        if(monsterDelay > 6){
           if(Math.random() * 20 > 18) {
               checkCombat(playerMan, createCombat);
           }
          monsterDelay = 0;
        }
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

    public void checkCombat(Character playerMan,boolean[] createCombat){
        switch((int)playerMan.getCurrentMapLocation()){
            case 21:
                break;
            case 20:
                break;
            case 28:
                break;
            case 29:
                break;
            default:
                createCombat[0] = true;
                playerMan.setCombatActive(true);
                break;
        }

    }










    ////////////////////////////////
    ///
    /// Key Binds
    ///
    /////////////////////////////


    public void keyPressed (KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
            directionFacing = Direction.right;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
            directionFacing = Direction.left;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            up = true;
            directionFacing = Direction.up;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down = true;
            directionFacing = Direction.down;
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

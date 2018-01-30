

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.management.PlatformLoggingMXBean;
import java.security.Key;


public class Combat extends extraFunctions{

    enum CombatState {playerTurn, playerAttack, enemyTurn, lootScreen, abilityMenu, itemMenu, run, playerDeath};
    CombatState state;

    int menuOption;
    boolean stopper2 = false;
    AudioClip gameover;


    String textFont = "arial";

    /////////////////////////////////////////
    ///
    ///  Sound
    ///
    /////////////////////////////////////////
    AudioClip attackMusic;
    AudioClip coin;
    AudioClip win;
    AudioClip miss;
    AudioClip hit1;
    AudioClip hit2;
    AudioClip hit3;
    AudioClip potion;
    private boolean stopper;
    private boolean s1;
    private boolean s2;
    private boolean s3;
    private boolean s4;
    private boolean s5;


    public void initSound(){
        stopper = false;
        s1 = false;
        s2 = false;
        s3 = false;
        s4 = false;
        s5 = false;
        gameover = loadAudio("gameover.wav");
        attackMusic = loadAudio("epic.wav");
        coin = loadAudio("coin.wav");
        clicks = loadAudio("clicks.wav");
        p1 = loadAudio("page1.wav");
        p2 = loadAudio("page2.wav");
        p3 = loadAudio("page3.wav");
        leave = loadAudio("leave.wav");
        exitClick = loadAudio("exitClick.wav");
        win = loadAudio("win.wav");
        miss = loadAudio("miss.wav");
        hit1 = loadAudio("hit_1.wav");
        hit2 = loadAudio("hit2.wav");
        hit3 = loadAudio("hit3.wav");
        potion = loadAudio("potion.wav");
        startAudioLoop(attackMusic, -11);

    }


    /////////////////////////////////////////
    ///
    ///  Portraits
    ///
    /////////////////////////////////////////

    Image heartImage;
    Image energyImage;
    Image energyspritesheet;
    Image energyFullImage;
    Image energyEmptyImage;


    Image LevelPortrait;


    Image statusSpriteSheet;
    Image statusPoison;
    Image statusBlind;


    public void initPortrait(){



        LevelPortrait = subImage(buttonSpriteSheet,450,155,120,120);

        statusSpriteSheet = loadImage("status_effects.png");
        statusPoison = subImage(statusSpriteSheet,189,0,16,16);
        statusBlind = subImage(statusSpriteSheet,336,0,16,16);

        heartImage = loadImage("heart.png");
        energyImage = loadImage("newbolt.png");
        energyspritesheet = loadImage("bolts.png");
        energyFullImage = subImage(energyspritesheet,0,0,320,480);
        energyEmptyImage = subImage(energyspritesheet,320,0,320,480);


    }

    public void updateNamePlates(double dt){

    }

    public void drawPlayerNamePlate(Graphics2D g) {

        //Status Display
        if(player.getLastStatusEffect() == Statblock.Status.Poison){
            drawImage(statusPoison,287,41,32,32,g);
        }else if( player.getLastStatusEffect() == Statblock.Status.Blind){
            drawImage(statusBlind,287,41,32,32,g);
        }


        //Level Display
        drawImage(LevelPortrait,80,0,30,30,g);
        changeColor(white,g);
        drawBoldText(91,19,Integer.toString(player.getLevel()), "felix titling",13,g);


        changeColor(Color.gray,g);

        //player Resource Bar
        drawSolidRectangle(80, 52, 203, 20,g);
        drawRectangle(80, 52, 203, 20, 2,g);
        drawRectangle(80, 30, 203, 20, 2,g);

        changeColor(red,g);
        drawSolidRectangle(82, 32, 200 / player.getMaxHP() * player.getCurrentHP(), 18,g);


        drawImage(energyEmptyImage, 110, 52, 22, 22,g);
        drawImage(energyEmptyImage, 140, 52, 22, 22,g);
        drawImage(energyEmptyImage, 170, 52, 22, 22,g);
        drawImage(energyEmptyImage, 200, 52, 22, 22,g);
        drawImage(energyEmptyImage, 230, 52, 22, 22,g);
        if(player.getEnergy() > 0){
            drawImage(energyFullImage, 110, 52, 22, 22,g);
        }
        if(player.getEnergy() > 1){
            drawImage(energyFullImage,140,52,22,22,g);
        }
        if(player.getEnergy() > 2){
            drawImage(energyFullImage,170,52,22,22,g);
        }
        if(player.getEnergy() > 3){
            drawImage(energyFullImage,200,52,22,22,g);
        }
        if(player.getEnergy() > 4){
            drawImage(energyFullImage,230,52,22,22,g);
        }





        drawImage(energyImage,62,50,30,30,g);
        drawImage(heartImage,60,20,40,40,g);


        //replace circle with portrait later
        changeColor(white,g);
        drawText(110,23,player.getName(),textFont,20,g);
        drawBoldText(150,47,Integer.toString((int)player.getCurrentHP()) + "/" + Integer.toString((int)player.getMaxHP()),textFont, 15,g);












        //EXP BAR
        changeColor(Color.gray,g);
        drawRectangle(105,80,102,15,3,g);

        changeColor(purple,g);

        drawSolidRectangle(107,82,((double)player.getXPTotal() / ((double)player.getXPToNextLevel() /100))  ,12,g);


        changeColor(white,g);
        drawBoldText(77,93,Integer.toString((int)((double)player.getXPTotal() / ((double)player.getXPToNextLevel() /100))) + "%",textFont, 13,g);




    }

    public void drawEnemyNamePlate(Graphics2D g){

        //Status Display
        if(enemy.getLastStatusEffect() == Statblock.Status.Poison){
            drawImage(statusPoison,482,41,32,32,g);
        }else if(enemy.getLastStatusEffect() == Statblock.Status.Blind){
            drawImage(statusBlind,482,41,32,32,g);
        }

        //Level Display
        drawImage(LevelPortrait,695 ,0,30,30,g);
        changeColor(white,g);
        drawBoldText(705  ,19,Integer.toString(enemy.getLevel()), "felix titling",13,g);

        changeColor(Color.gray,g);
        //player Resource Bar
        drawSolidRectangle(517, 52, 203, 20,g);
        drawRectangle(517, 52, 203, 20, 2,g);
        drawRectangle(517, 30, 203, 20, 2,g);

        changeColor(red,g);
        drawSolidRectangle(519, 32, 200 / enemy.getMaxHP() * enemy.getCurrentHP(), 18,g);


        drawImage(energyEmptyImage, 670, 52, 22, 22,g);
        drawImage(energyEmptyImage, 640, 52, 22, 22,g);
        drawImage(energyEmptyImage, 610, 52, 22, 22,g);
        drawImage(energyEmptyImage, 580, 52, 22, 22,g);
        drawImage(energyEmptyImage, 550, 52, 22, 22,g);
        if(enemy.getEnergy() > 0){
            drawImage(energyFullImage, 670, 52, 22, 22,g);
        }
        if(enemy.getEnergy() > 1){
            drawImage(energyFullImage,640,52,22,22,g);
        }
        if(enemy.getEnergy() > 2){
            drawImage(energyFullImage,610,52,22,22,g);
        }
        if(enemy.getEnergy() > 3){
            drawImage(energyFullImage,580,52,22,22,g);
        }
        if(enemy.getEnergy() > 4){
            drawImage(energyFullImage,550,52,22,22,g);
        }





        drawImage(energyImage,705,50,30,30,g);
        drawImage(heartImage,700,20,40,40,g);


        //replace circle with portrait later
        changeColor(white,g);
        drawText(600,23,enemy.getName(),textFont,20,g);
        drawBoldText(600,47,Integer.toString((int)enemy.getCurrentHP()) + "/" + Integer.toString((int)enemy.getMaxHP()),textFont, 15,g);








    }

    /////////////////////////////////////////
    ///
    ///  Combat Log
    ///
    /////////////////////////////////////////

    int numOfLogs;
    String[] logStrings;
    boolean[] logColours;
    boolean[] kill;
    Image logImage;
    Image menuBackGroundSprite;

    String statusLog;


    public void initLog(){
        statusLog = "";
        logImage = loadImage("paper2.png");
        menuBackGroundSprite = loadImage("CombatMenuImage.png");
        logStrings = new String[6];
        for(int i = 0;i < 6;i++){
            logStrings[i] = "";
        }
        logColours = new boolean[6];
        kill = new boolean[6];
        numOfLogs = 0;
    }

    public void pushString(String newLog, boolean playerLog,boolean kil){
        while(numOfLogs < 5){
            numOfLogs++;
        }
        for(int i = numOfLogs, j = numOfLogs-1;j >= 0;i--,j--){
            logStrings[i] = logStrings[j];
            logColours[i] = logColours[j];
         }


        kill[0] = kil;
        logStrings[0] = newLog;
        logColours[0] = playerLog;


    }

    public void updateLog(double dt){

    }

    public void drawLog(Graphics2D g){
        drawImage(menuBackGroundSprite,0,400,820,200,g);
        drawImage(logImage,465,415,315,175,g);
        for(int i = 0; i <= numOfLogs;i++){
            if(logColours[i]){
                changeColor(blue,g);
            }else {
                changeColor(red,g);
            }
            if(kill[i]){
                changeColor(black,g);
            }

            drawText(490,570 - (26 * i),logStrings[i],"Times New Roman",18,g);
        }




    }



    /////////////////////////////////////////
    ///
    ///  Player Turn Display
    ///
    /////////////////////////////////////////


    Image menuPointer;
    Image menuSpriteSheet;

    double menuPosX;
    double menuPosY;

    boolean checkCurse;

    Image buttonSpriteSheet;
    Image buttonSprite;

    public void initPlayerTurnDisplay(){
        buttonSpriteSheet = loadImage("buttons.png");
        buttonSprite = subImage(buttonSpriteSheet,30,70,180,80);
        checkCurse = false;
        menuOption = 0;

        menuSpriteSheet = loadImage("arrowhead.png");
        menuPointer = subImage(menuSpriteSheet,0,96,48,48);

    }

    public void checkPlayerCurse(){
        playerStatusString = "";

        if(player.getLastStatusEffect() != null) {
            if (player.getLastStatusDuration() > 1) {

                player.setLastStatusDuration(player.getLastStatusDuration() - 1);
                if (player.getLastStatusEffect() == Statblock.Status.Poison) {
                    playerStatusString = "You take " + (int)player.getLastStatusDamage() + "  poison damage";
                    statusLog = player.getName()  + " poisoned for " + (int)player.getLastStatusDamage();
                }

            } else {
                playerStatusString = player.getLastStatusEffect() + " fades from you";
                statusLog = player.getLastStatusEffect() + " fades from " + player.getName();
                player.setLastStatusEffect(null);

            }
        }
        checkCurse = false;
    }



    public void updatePlayerTurnDisplay(double dt){

        if(checkCurse){checkPlayerCurse();}

        if(menuOption == 0){
            menuPosX = 15;
            menuPosY = 427;
        }
        if(menuOption == 1){
            menuPosX = 235;
            menuPosY = 427;
        }
        if(menuOption == 2){
            menuPosX = 15;
            menuPosY = 520;
        }
        if(menuOption == 3){
            menuPosX = 235;
            menuPosY = 520;
        }

    }

    public void drawPlayerTurnDisplay(Graphics2D g){
        changeColor(white,g);


       // drawImage(menuPointer,menuPosX,menuPosY,g);


       // drawRectangle(20,415,200,80,2,g);
        drawImage(buttonSprite,30,420,g);
        drawText(90,460,"Attack",textFont,20,g);

        drawImage(buttonSprite,30,505,g);
      //  drawRectangle(20,505,200,80,2,g);
        drawText(90,545,"Items",textFont,20,g);

        drawImage(buttonSprite,240,420,g);
     //   drawRectangle(240,415,200,80,2,g);
        drawText(295,460,"Abilities",textFont,20,g);

        drawImage(buttonSprite,240,505,g);
      //  drawRectangle(240,505,200,80,2,g);
        drawText(310,545,"Run",textFont,20,g);

        drawImage(menuPointer,menuPosX,menuPosY,g);



    }

    /////////////////////////////////////////
    ///
    ///  Player Attack
    ///
    ////////////////////////////////////////

    Ability lastAbility;

    double playerAttackTimer;
    double playerAttackDuration;
    double playerAttackDelay;
    double playerAttackExtraDelay;
    boolean playerAttackActive;
    Ability[] playerAbilities;

    boolean castCurse;
    boolean castBuff;
    boolean castBasicAttack;
    boolean useItem;
    double playerDamage;

    boolean displayItem;
    boolean playerTurnSetUp;

    String playerTurnLog;

    boolean playerNewStatusDisplay;
    boolean playerOldStatusDisplay;

    String playerStatusString;



    public void initPlayerAttack(){
        playerStatusString = "";
        playerNewStatusDisplay = false;
        playerOldStatusDisplay = false;
        displayItem = false;
        playerDamage = 0;
        castBasicAttack = false;
        castCurse = false;
        castBuff = false;

        playerAbilities = player.getAbilities();

        playerAttackTimer = 0;
        playerAttackDelay = 2;
        playerAttackDuration = 4;
        playerAttackExtraDelay = 6;

    }


    public void startPlayerTurn() {
        s1 = false;
        s2 = false;
        s3 = false;
        s4 = false;
        s5 = false;

        if (!useItem){
            if (lastAbility.getType() == Ability.AbilityType.damage) {
                castBasicAttack = true;
            } else if (lastAbility.getType() == Ability.AbilityType.buff) {
                castBuff = true;
            } else if (lastAbility.getType() == Ability.AbilityType.curse) {
                castCurse = true;
            }
        }

        playerTurnSetUp = false;
    }


    public void castAttack(){
            lastAbility.use(player);
            playerDamage = lastAbility.getLastDamage();
            playerDamage = enemy.takeDamage((int)playerDamage);
            castBasicAttack = false;
            player.setEnergy(player.getEnergy()-lastAbility.getEnergyCost());

        if(lastAbility.getLastStatus() != null){
            enemy.setLastStatusDuration(lastAbility.getLastStatusDuration());
            enemy.setLastStatusEffect(lastAbility.getLastStatus());
            enemy.setLastStatusDamage(lastAbility.getDamageOverTime());
            statusLog = enemy.getName() + " was poisoned";

        }

    }

    public void castBuffSpell(){
        lastAbility.use(player);
        playerDamage = lastAbility.getLastDamage();
        castBuff = false;
        player.setEnergy(player.getEnergy()-lastAbility.getEnergyCost());
    }

    public void castCurseSpell(){
        lastAbility.use(player);
        enemy.setLastStatusDuration(lastAbility.getLastStatusDuration());
        enemy.setLastStatusEffect(lastAbility.getLastStatus());
        enemy.setLastStatusDamage(lastAbility.getDamageOverTime());
        castCurse = false;
    }


    public void useItemTurn() {
        if(!s5){
            playAudio(potion);
            s5 = false;
        }
        lastItemUsed.use(player);
        useItem= false;
        if(lastItemUsed.getName() == "Antidote" && player.getLastStatusEffect() == Statblock.Status.Poison){
            playerStatusString =  "Poison fades from you";
            statusLog = "Poison fades from " + player.getName();
        }

    }

    public void playerEndTurn(){
        displayItem =false;
        pushString(playerTurnLog,true,false);
        playerAttackActive = false;
        playerAttackTimer = 0;
        if(enemy.isAlive()){
            enemyTurnSetUp = true;
            state = CombatState.enemyTurn;
        }else{
            pushString(enemy.getName() + " has been killed",true,true);
            state = CombatState.lootScreen;
        }
    }




    public void updatePlayerAttack(double dt){
        if(state == CombatState.playerAttack) {
            if(playerTurnSetUp){startPlayerTurn();}
            playerAttackTimer += dt;

            if (playerAttackTimer > playerAttackDelay) {
                playerAttackActive = true;
                if(castBasicAttack) {
                    castAttack();
                }else if(castBuff){
                    castBuffSpell();
                }else if(castCurse){
                    castCurseSpell();
                }
                if(useItem){

                    useItemTurn();
                    lastAbility = playerAbilities[0];
                }

            }
            if (playerAttackTimer > playerAttackDuration) {
               if(lastAbility.getType() == Ability.AbilityType.damage && lastAbility.getLastStatus() != null){
                   playerNewStatusDisplay = true;
                   if(playerAttackTimer > playerAttackExtraDelay){


                       playerEndTurn();
                       pushString(statusLog,true,false);
                       playerNewStatusDisplay = false;
                   }
               }else if(playerStatusString != "") {
                   playerOldStatusDisplay = true;

                   if(playerAttackTimer > playerAttackExtraDelay){
                       if(enemy.isAlive()) {
                           player.takeDamage((int) player.getLastStatusDamage());
                           playerEndTurn();
                           pushString(statusLog,true,false);
                       }else{
                           player.setLastStatusEffect(null);
                           player.setLastStatusDuration(0);
                           player.setLastStatusDamage(0);
                           playerEndTurn();
                       }


                       playerOldStatusDisplay = false;
                   }
               }else{
                   playerEndTurn();
               }

            }


        }


    }

    public void drawPlayerAttack(Graphics2D g){

        changeColor(white,g);
        if(playerOldStatusDisplay && enemy.isAlive()){
            drawText(150, 500, playerStatusString, textFont, 20, g);
        }else {
            if (displayItem) {

                if (!playerAttackActive) {
                    drawText(150, 500, "Using " + lastItemUsed.getName() + "...", textFont, 20, g);
                } else {
                    playerTurnLog = player.getName() + " used " + lastItemUsed.getName();
                    drawText(120, 500, lastItemUsed.getDisplayString(), textFont, 20, g);
                }

            } else {

                if (!playerAttackActive) {
                    if (lastAbility.isMagic()) {
                        drawText(150, 500, "You cast " + lastAbility.getName()  , textFont, 20, g);
                    } else {
                        drawText(150, 500, "You used " + lastAbility.getName(), textFont, 20, g);
                    }
                } else if (playerAttackActive) {


                    if (lastAbility.getType() == Ability.AbilityType.damage) {
                        if (playerNewStatusDisplay) {
                            drawText(100, 500, enemy.getName() + " has been poisoned", textFont, 20, g);
                        } else {
                            if (lastAbility.isLastHit()) {
                                if(!s3) {
                                    playAudio(hit1);
                                    s3 = true;
                                }
                                playerTurnLog = player.getName() + " dealt " + (int) playerDamage + " with " + lastAbility.getName();
                                if (lastAbility.isLastCrit()) {
                                    playerTurnLog = player.getName() + " crit for " + (int) playerDamage + " with " + lastAbility.getName();
                                    drawBoldText(120, 500, "Your " + lastAbility.getName() + " CRITS " + enemy.getName(), textFont, 20, g);
                                    drawBoldText(140,525,  " for " + (int) playerDamage + " damage",textFont,20,g);
                                } else {
                                    if (lastAbility.isMagic()) {
                                        drawText(120, 500, lastAbility.getName() + " hits " + enemy.getName() , textFont, 20, g);
                                        drawBoldText(140,525,  " for " + (int) playerDamage + " damage",textFont,20,g);
                                    } else {
                                        drawText(120, 500, lastAbility.getName() + " hits " + enemy.getName() , textFont, 20, g);
                                        drawBoldText(140,525,  " for " + (int) playerDamage + " damage",textFont,20,g);
                                    }
                                }
                            } else {
                                if(!s4) {
                                    playAudio(miss);
                                    s4 = true;
                                }
                                playerTurnLog = player.getName() + " missed with " + lastAbility.getName();
                                drawText(70, 500, "Your " + lastAbility.getName() + " misses " + enemy.getName(), textFont, 20, g);
                            }
                        }
                    } else if (lastAbility.getType() == Ability.AbilityType.buff || lastAbility.getType() == Ability.AbilityType.curse) {
                        playerTurnLog = player.getName() + " cast " + lastAbility.getName();
                        drawText(150, 500, lastAbility.getDisplayString(), textFont, 20, g);
                    }
                }
            }
        }
    }


    /////////////////////////////////////////
    ///
    ///  Ability Menu
    ///
    ////////////////////////////////////////


    Image spellBook;
    Image spellBookPointer;

    double spellBookPointerX;
    double spellBookPointerY;

    int numOfPages;
    int currentPageNum;
    int numOfSpellsToDisplay;

    boolean nextPageExist;
    boolean prevPageExist;

    public void initAbilityMenu(){
        currentPageNum = 1;
        numOfPages = 1;
        spellBook = loadImage("open.png");
        spellBookPointer = subImage(menuSpriteSheet,288,96,48,48);
    }


    public void updateAbilityMenu(double dt){

        if(player.getNumOfAbilities() > 9){
            numOfPages = 1 + ((player.getNumOfAbilities()-1) / 8);
        }


        if(menuOption >= 1 && menuOption <= 10){
            spellBookPointerX = 70;
            spellBookPointerY = 120 + (40 * (menuOption-1));
        }

        if(menuOption == 20 ){
            spellBookPointerX = 430;
            spellBookPointerY = 450;
        }

        if(menuOption == 21 ){
            spellBookPointerX = 430;
            spellBookPointerY = 470;
        }

        if(nextPageExist){
            numOfSpellsToDisplay = 8;
        }else{
            numOfSpellsToDisplay = player.getNumOfAbilities()-1;

        }

    }


    public void drawAbilityMenu(Graphics2D g){

        changeColor(Color.gray,g);



        drawImage(spellBook,0,0,800,600,g);


        if(numOfPages > currentPageNum){
            drawText(480,480,"Next Page","Times New Roman",25,g);
            nextPageExist = true;
        }else{
            nextPageExist = false;
        }
        if(currentPageNum > 1){
            drawText(480,500,"Previous Page","Times New Roman",25,g);
            prevPageExist = true;
        }else{
            prevPageExist = false;
        }

        drawText(100,100,"Abilities", "Times new roman",30,g);
        drawText(530,100,"ToolTip", "Times new roman",30,g);



        int j = 1;
            for (int i = 1 + (8 * (currentPageNum-1)); i <= numOfSpellsToDisplay; i++) {
                while (!playerAbilities[i].isActive()) {
                    i++;

                }
                changeColor(Color.darkGray, g);
                drawSolidCircle(230, 145 + 40 * (j - 1), 13, g);
                changeColor(Color.gray, g);
                drawText(110, 150 + 40 * (j - 1), playerAbilities[i % (9 * currentPageNum + 1)].getName(), "Times new Roman", 20, g);
                drawCircle(230, 145 + 40 * (j - 1), 13, 2, g);
                drawImage(energyFullImage, 221, 135 + 40 * (j - 1), 20, 20, g);
                drawText(250, 150 + 40 * (j - 1), Integer.toString(playerAbilities[i % (9 * currentPageNum)].getEnergyCost()), "Times New Roman", 20, g);
                if (playerAbilities[i % (9 * currentPageNum)].isMagic()) {
                    drawText(310, 150 + 40 * (j - 1), "Magic", "Times new Roman", 20, g);
                } else {
                    drawText(310, 150 + 40 * (j - 1), "Physical", "Times new Roman", 20, g);
                }
                if (menuOption == j) {
                    drawText(460, 140, playerAbilities[i % (9 * currentPageNum)].getToolTip(), "Times New Roman", 20, g);
                }

                j++;

            }




        if(menuOption == 20){
            drawText(460,140,"Next Page","Times New Roman",20,g);
        }
        if(menuOption == 21){
            drawText(460,140,"Previous Page","Times New Roman",20,g);
        }




        drawImage(energyEmptyImage, 170, 42, 30, 30,g);
        drawImage(energyEmptyImage, 200, 42, 30, 30,g);
        drawImage(energyEmptyImage, 230, 42, 30, 30,g);
        drawImage(energyEmptyImage, 260, 42, 30, 30,g);
        drawImage(energyEmptyImage, 290, 42, 30, 30,g);
        if(player.getEnergy() > 0){
            drawImage(energyFullImage, 170, 42, 30, 30,g);
        }
        if(player.getEnergy() > 1){
            drawImage(energyFullImage,200,42,30,30,g);
        }
        if(player.getEnergy() > 2){
            drawImage(energyFullImage,230,42,30,30,g);
        }
        if(player.getEnergy() > 3){
            drawImage(energyFullImage,260,42,30,30,g);
        }
        if(player.getEnergy() > 4){
            drawImage(energyFullImage,290,42,30,30,g);
        }







        drawBoldText(110,535,"Back[ESC]","Felix titling",14,g);


        drawImage(spellBookPointer, spellBookPointerX,spellBookPointerY,40,40,g);


    }




    /////////////////////////////////////////
    ///
    ///  Item Menu
    ///
    ////////////////////////////////////////


    Item[] playerInventory;
    Item lastItemUsed;

    public void initItemMenu(){
        playerInventory = player.getInventory();
        spellBook = loadImage("open.png");
        spellBookPointer = subImage(menuSpriteSheet,288,96,48,48);

    }




    public void updateItemMenu(double dt){
//        if(menuOption == 0){
//            spellBookPointerX = 70;
//            spellBookPointerY = 485;
//        }
        if(menuOption >= 1 && menuOption <= 9){
            spellBookPointerX = 70;
            spellBookPointerY = 120 + (40 * (menuOption-1));
        }
    }




    public void drawItemMenu(Graphics2D g){
        changeColor(Color.gray,g);
        drawImage(spellBook,0,0,800,600,g);

        drawText(100,100,"ITEMS", "Times new roman",30,g);
        drawText(530,100,"ToolTip", "Times new roman",30,g);
        if(player.getBagSize() > 0) {
            int j = 1;
            for (int i = 0; i < player.getInventorySize(); i++) {
                while (playerInventory[i].getSlot() != Item.Slot.bag) {
                    i++;
                }
                changeColor(Color.darkGray, g);
                changeColor(Color.gray, g);
                drawText(110, 150 + 40 * (j - 1), playerInventory[i].getName(), "Times new Roman", 20, g);
                drawText(300, 150 + 40 * (j - 1), "x" + Integer.toString(playerInventory[i].getCounter()), "Times New Roman", 20, g);


                if (menuOption == j) {
                    drawText(430, 140, playerInventory[i].getTooltip(), "Times New Roman", 20, g);
                }

                if (j == player.getBagSize()) {
                    break;
                } else {
                    j++;
                }

            }
        }



          drawBoldText(110,535,"Back[ESC]","Felix titling",14,g);

        if(player.getBagSize() > 0) {
            drawImage(spellBookPointer, spellBookPointerX, spellBookPointerY, 40, 40, g);
        }

    }

    /////////////////////////////////////////
    ///
    ///  Run
    ///
    /////////////////////////////////////////

    double escapeTimer;
    double escapeDelay;
    double escapeDuration;

    boolean makeEscape;
    boolean escapeActive;

    boolean escapeChance;

    public void initRun(){
        escapeTimer = 0;
        escapeDelay = 3;
        escapeDuration = 5.5;
        makeEscape = false;


    }


    public void updateRun(double dt){
        if(state == CombatState.run){
            if(Math.random()* 10 > 2.5 && !escapeChance) {

                makeEscape = true;

                if(enemy.getName() == "Valliard" ||enemy.getName() == "Priest" || enemy.getName() == "Razuul" || enemy.getName() == "Therox"){
                    makeEscape = false;
                }
            }
            escapeChance = true;
            escapeTimer += dt;
            if(escapeTimer > escapeDelay){
                escapeActive = true;
            }
            if(escapeTimer > escapeDuration){
                escapeTimer = 0;
                escapeActive = false;

                if(makeEscape){
                    stopAudioLoop(attackMusic);
                    player.setCombatActive(false);
                }else {
                    enemyTurnSetUp = true;
                    state = CombatState.enemyTurn;
                    pushString(playerTurnLog,true,false);

                }
            }
        }else{
            escapeTimer = 0;
        }

    }

    public void drawRun(Graphics2D g){
        changeColor(white,g);
        if(!escapeActive) {
            drawText(100, 500, "You attempt to escape from " + enemy.getName() + "...", textFont, 20,g);
        }else if(escapeActive){
            if(makeEscape){
                drawText(100, 500, "You managed to get away!", textFont, 20, g);
            }else {
                drawText(100, 500, "You fail to escape from " + enemy.getName(), textFont, 20, g);
                playerTurnLog = player.getName() + " failed trying to run";
            }
        }
    }


    /////////////////////////////////////////
    ///
    ///  Enemy Turn
    ///
    ////////////////////////////////////////

    Ability enemyLastAbility;

    double enemyDamage;

    double enemyTurnTimer;
    double enemyTurnDelay;
    double enemyTurnDuration;
    double enemyTurnExtraDelay;

    boolean enemyAttackActive;
    boolean enemyMakeAttack;
    boolean enemyMakeBuff;
    boolean enemyMakeCurse;

    String enemyTurnLog;

    boolean enemyTurnSetUp;

    boolean displayEnemyOldStatus;
    boolean displayEnemyNewStatus;

    String enemyStatusString;

    public void startEnemyTurn() {
        enemyTurnSetUp = false;
        if(enemy.getEnergy()!= 5) {
            enemy.addEnergy(1);
        }
        enemyHasSpentEnergy = false;
        enemyLastAbility = enemy.moveChoice();
        if (enemyLastAbility.getType() == Ability.AbilityType.damage) {
            enemyMakeAttack = true;
        } else if (enemyLastAbility.getType() == Ability.AbilityType.buff) {
            enemyMakeBuff = true;
        } else if (enemyLastAbility.getType() == Ability.AbilityType.curse) {
            enemyMakeCurse = true;
        }
        enemyStatusString = "";
        if (enemy.getLastStatusEffect() != null)
            if (enemy.getLastStatusDuration() > 1) {
                enemy.setLastStatusDuration(enemy.getLastStatusDuration() - 1);
                if (enemy.getLastStatusEffect() == Statblock.Status.Poison) {
                    enemyStatusString = enemy.getName() + " takes " + (int)enemy.getLastStatusDamage() + "  poison damage";
                    statusLog = enemy.getName()  + " poisoned for " + (int)enemy.getLastStatusDamage();
                }

            } else {
                enemyStatusString = enemy.getLastStatusEffect() + " fades from " + enemy.getName();
                statusLog = enemy.getLastStatusEffect() + " fades from " + enemy.getName();
                enemy.setLastStatusEffect(null);
            }
    }






    public void initEnemyTurn(){
        enemyStatusString = "";
        displayEnemyNewStatus = false;
        displayEnemyOldStatus = false;
        enemyAttackActive = false;
        enemyTurnTimer = 0;
        enemyTurnDelay = 2;
        enemyTurnDuration = 4;
        enemyTurnExtraDelay = 6;
    }

    public void enemyAttack(){
        enemyLastAbility.use(enemy);
        enemyDamage = enemyLastAbility.getLastDamage();
      //  enemy.addEnergy(-enemyLastAbility.getEnergyCost());
        enemyDamage = player.takeDamage((int)enemyDamage);

        if(enemyLastAbility.getLastStatus() != null){
            player.setLastStatusDuration(enemyLastAbility.getLastStatusDuration());
            player.setLastStatusEffect(enemyLastAbility.getLastStatus());
            player.setLastStatusDamage(enemyLastAbility.getDamageOverTime());
            statusLog = player.getName() + " was poisoned";
        }
        enemyMakeAttack = false;

    }


    private boolean enemyHasSpentEnergy;
    public void enemySpendEnergy(){
        enemy.setEnergy(enemy.getEnergy()-enemyLastAbility.getEnergyCost());
        enemyHasSpentEnergy = true;
    }


    public void enemyBuff(){
        enemyLastAbility.use(enemy);
      //  enemy.addEnergy(-enemyLastAbility.getEnergyCost());
        enemyMakeBuff = false;

    }

    public void enemyCurse(){
      //  enemy.addEnergy(-enemyLastAbility.getEnergyCost());
        enemyLastAbility.use(enemy);
        player.setLastStatusDuration(enemyLastAbility.getLastStatusDuration());
        player.setLastStatusEffect(enemyLastAbility.getLastStatus());
        player.setLastStatusDamage(enemyLastAbility.getDamageOverTime());
        enemyMakeCurse = false;
    }

    public void enemyEndTurn(){
        pushString(enemyTurnLog,false,false);
        enemyAttackActive = false;
        enemyTurnTimer = 0;
        checkCurse = true;
        player.addEnergy(1);
        state = CombatState.playerTurn;
    }



    public void updateEnemyTurn(double dt){
        if(state == CombatState.enemyTurn){
            if(enemyTurnSetUp){startEnemyTurn();}
            enemyTurnTimer += dt;
            if(enemyTurnTimer > enemyTurnDelay){
                enemyAttackActive = true;
                if(!enemyHasSpentEnergy){
                    enemySpendEnergy();
                }
                if(enemyMakeAttack){
                    enemyAttack();
                }
                if(enemyMakeBuff){
                    enemyBuff();
                }
                if(enemyMakeCurse){
                    enemyCurse();
                }

            }
            if(enemyTurnTimer > enemyTurnDuration){

                if(enemyLastAbility.getType() == Ability.AbilityType.damage && enemyLastAbility.getLastStatus() != null){
                    displayEnemyNewStatus = true;
                    if(enemyTurnTimer > enemyTurnExtraDelay){
                        enemyEndTurn();
                        pushString(statusLog,false,false);
                        displayEnemyNewStatus = false;
                    }
                }else if(enemyStatusString != "" ) {
                    displayEnemyOldStatus = true;
                    if(enemyTurnTimer > enemyTurnExtraDelay){
                       // enemyEndTurn();
                        if(player.isAlive()) {
                            enemy.takeDamage((int) enemy.getLastStatusDamage());
                            pushString(statusLog,false,false);
                        }else{
                            fadeState = true;
                            timer = 0;
                            enemyEndTurn();
                            state = CombatState.playerDeath;
                            pushString(player.getName() + " has been killed",true,true);
                        }


                        displayEnemyOldStatus = false;
                    }
                }else {
                    if(!player.isAlive()){
                        fadeState = true;
                        timer = 0;
                        enemyEndTurn();
                        state = CombatState.playerDeath;
                        pushString(player.getName() + " has been killed",true,true);
                    }else{
                        enemyEndTurn();
                    }

                }

            }
        }
    }




    public void drawEnemyTurn(Graphics2D g){

        changeColor(black,g);
        drawLog(g);
        changeColor(white,g);
        if(displayEnemyOldStatus){
            drawText(70, 500, enemyStatusString, textFont, 20, g);
        }else {
            if (!enemyAttackActive) {
                if (enemyLastAbility.isMagic()){
                    if(!s2){
                        playAudio(exitClick);
                        s2 = true;
                    }
                    drawText(130, 500, enemy.getName() + " casts " + enemyLastAbility.getName() , textFont, 20, g);
                } else{
                    drawText(130, 500, enemy.getName() + " uses " + enemyLastAbility.getName(), textFont, 20, g);
                }
            } else if (enemyAttackActive) {
                if (enemyLastAbility.getType() == Ability.AbilityType.damage) {
                    if (displayEnemyNewStatus) {
                        drawText(100, 500, "You have been poisoned", textFont, 20, g);
                        //Might have to add somthing for log
                    } else {
                        if (enemyLastAbility.isLastHit()) {
                            if(!s1) {
                                playAudio(hit2);
                                s1 = true;
                            }
                            enemyTurnLog = enemy.getName() + " dealt " + (int) enemyDamage + " with " + enemyLastAbility.getName();
                            if (enemyLastAbility.isMagic()) {
                                drawText(120, 500, enemy.getName() + "'s " + enemyLastAbility.getName()  , textFont, 20, g);
                                drawBoldText(140,525,  " hits you for " + (int) enemyDamage ,textFont,20,g);

                            } else {
                                if (enemyLastAbility.isLastCrit()) {
                                    enemyTurnLog = enemy.getName() + " crit for " + (int) enemyDamage + " with " + enemyLastAbility.getName();
                                    drawBoldText(120, 500, enemy.getName() + "'s " + enemyLastAbility.getName(), textFont, 20, g);
                                    drawBoldText(140,525,  " Crits you for " + (int) enemyDamage ,textFont,20,g);
                                } else {
                                    drawText(120, 500, enemy.getName() + "'s " + enemyLastAbility.getName(), textFont, 20, g);
                                    drawBoldText(140,525,  " hits you for " + (int) enemyDamage ,textFont,20,g);
                                }

                            }

                        } else {
                            if(!s1) {
                                playAudio(miss);
                                s1 = true;
                            }
                            enemyTurnLog = enemy.getName() + " missed with " + enemyLastAbility.getName();
                            drawText(70, 500, enemy.getName() + "'s " + enemyLastAbility.getName() + " misses you", textFont, 20, g);
                        }
                    }
                } else if (enemyLastAbility.getType() == Ability.AbilityType.buff || enemyLastAbility.getType() == Ability.AbilityType.curse) {
                    enemyTurnLog = enemy.getName() + " cast " + enemyLastAbility.getName();
                    drawText(120, 500, enemyLastAbility.getDisplayString(), textFont, 20, g);
                }

            }
        }

    }





    /////////////////////////////////////////
    ///
    ///  Loot Screen
    ///
    ////////////////////////////////////////

    Image chestSpriteSheet;
    Image chestOne;
    Image chestTwo;

    Image lootScroll;



    Image coinImage;

    Item reward;
    boolean collectReward;

    boolean right;
    boolean chestOpen;

    double walkTimer;
    double walkDuration;

    int currentGold;

    boolean levelUp;

    public void initLootScreen(){

        lootScroll = loadImage("LootPicture.png");

        chestSpriteSheet = loadImage("chests.png");
        chestOne = subImage(chestSpriteSheet,0,310,80,50);
        chestTwo = subImage(chestSpriteSheet,0,526,80,50);



        levelUp = false;
        currentGold = player.getGpTotal();
        right = false;
        collectReward = false;

        coinImage = loadImage("coin.png");


        walkTimer = 0;
        walkDuration = 0.16;
    }



    public void updateLootScreen(double dt){
        if(right){

            double dx = player.getCombatPosX();
            if(dx <= 720){
                dx +=  300 * dt;
            }

            walkTimer += dt;
            player.setCombatPosX( dx);
            if(walkTimer > walkDuration){
               walkTimer -= walkDuration;
            }
        }

        if(collectReward){

            player.setLastStatusEffect(null);
            player.setLastStatusDuration(0);
            player.setLastStatusDamage(0);
            if(player.winBattle(enemy)){
                levelUp = true;
            }
            reward = new Item();
            reward = enemy.dropLoot();
            if(reward.getName()!=null){
                player.addItemToInventory(reward);
            }
            collectReward = false;
        }




    }

    public void drawLootScreen(Graphics2D g){
        stopAudioLoop(attackMusic);

        drawImage(coinImage,640,-10,70,70,g);
        changeColor(white,g);
        drawText(710,35,Integer.toString(player.getGpTotal()),"Times New Roman",30,g);

        if(!chestOpen){
            if(!stopper){
                playAudio(win);
                stopper = true;
            }
            drawText(80, 500, "Victory, Press 'Space' on Chest to collect Reward", "Times New Roman", 18, g);
            drawImage(chestOne,580,210,130,100,g);
        }else{
            drawImage(lootScroll,270,50,300,350,g);

            drawImage(chestTwo,580,210,130,100,g);
            drawText(80, 500, "Press 'Space' again to return to the overworld!", "Times New Roman", 18, g);
            if(reward.getName() == null){
                changeColor(red,g);
                drawText(400, 270, "Nothing", "Times New Roman", 18, g);
            }else{
                changeColor(blue,g);
                drawText(400, 270, reward.getName(), "Times New Roman", 18, g);
            }
            changeColor(black,g);
            drawBoldText(360,170,"Victory","felix Titling",22,g);
            drawBoldText(340,230,"Gold ","felix Titling",15,g);

            drawBoldText(340,250,"Exp","felix Titling",15,g);

            drawBoldText(340,270,"Item","felix Titling",15,g);

            changeColor(purple,g);
            drawBoldText(400,250,"+" + enemy.getXPGain() ,"Times New Roman", 20,g);
           // changeColor(yellow,g);
            changeColor(yellow,g);
            drawBoldText(400,230,"+" + (player.getGpTotal() - currentGold)  ,"Times New Roman",20,g);

        }
        if(right){
            int j= getAnimationFrame(walkTimer,walkDuration,3);
            drawImage(playerImage[j],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
        }else{

            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);

        }

        if(levelUp){
            changeColor(purple,g);
            drawBoldText(340,310,"Level Up!","Felix Titling",30,g);
        }

    }


    /////////////////////////////////
    ///
    /// Fade
    ///
    /////////////////////////////////


    private double timer;
    private Image fade;
    private Image fadeArray[];
    private boolean fadeState;

    public void updateDeath(double dt){

        timer+=dt;
    }

    public void initDeath(){

        fadeState = false;
        timer = 0;
        fadeArray = new Image[10];
        fade = loadImage("fade.png");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                fadeArray[(i*5) + j] = subImage(fade, j*160, i*120, 140, 100);
            }
        }
    }

    public void drawDeath(Graphics2D g){
        stopAudioLoop(attackMusic);
        if(timer > 1.1 && timer < 1.2){
            drawImage(fadeArray[1], 0,0,800,600,g);
        }
        if(timer > 1.2 && timer < 1.3){
            drawImage(fadeArray[2], 0,0,800,600,g);
        }
        if(timer > 1.3 && timer < 1.4){
            drawImage(fadeArray[3], 0,0,800,600,g);
        }
        if(timer > 1.4 && timer < 1.5){
            drawImage(fadeArray[4], 0,0,800,600,g);
        }
        if(timer > 1.5 && timer < 1.6){
            drawImage(fadeArray[5], 0,0,800,600,g);
        }
        if(timer > 1.6 && timer < 1.7){
            drawImage(fadeArray[6], 0,0,800,600,g);
        }
        if(timer > 1.7 && timer < 1.8){
            drawImage(fadeArray[7], 0,0,800,600,g);
        }
        if(timer > 1.8 && timer < 1.9){
            drawImage(fadeArray[8], 0,0,800,600,g);
        }
        if(timer > 1.9 && timer < 2.5){
            drawImage(fadeArray[9], 0,0,800,600,g);
        }
        if(timer > 2.4){
            if(!stopper2){
                playAudio(gameover);
                stopper2 = true;
            }
            drawImage(fadeArray[9], 0,0,800,600,g);
            changeColor(white,g);
            drawText(240,200,"GAME OVER!", "Felix Titling",60,g);
            drawText(240,300,"Level : " + player.getLevel(), "Felix Titling",30,g);
            drawText(240,360,"Score : " + (player.getLevel() * player.getQuestStage()) * 100, "Felix Titling",30,g);
            drawText(350, 450,"EXIT[ESC]","Felix Titling",15,g);
        }

    }





    /////////////////////////////////////////
    ///
    ///  Finding an Opponent
    ///
    ////////////////////////////////////////

    double roll;

    public void randomMonster(int monsterToFight){

        if(monsterToFight == 0) {
            roll = Math.random() * 10;

            switch (player.getLevel()) {
                case 1:
                    if (roll > 1) {
                        enemy = new monster_Goblin();
                    } else {
                        enemy = new monster_Wolf();
                    }
                    break;
                case 2:
                    if (roll > 5.5) {
                        enemy = new monster_Goblin();
                    } else if (roll > 0.5) {
                        enemy = new monster_Wolf();
                    } else {
                        enemy = new monster_Witch();
                    }
                    break;
                case 3:
                    if (roll > 8) {
                        enemy = new monster_Goblin();
                    } else if (roll > 3) {
                        enemy = new monster_Wolf();
                    } else {
                        enemy = new monster_Witch();
                    }
                    break;
                case 4:
                    if (roll > 7) {
                        enemy = new monster_brawler();
                    } else if (roll > 5) {
                        enemy = new monster_Wolf();
                    } else {
                        enemy = new monster_Witch();
                    }
                    break;
                case 5:
                    if(roll > 9) {
                        enemy = new monster_Witch();
                    } else if (roll > 6) {
                        enemy = new monster_brawler();
                    } else if(roll > 1) {
                        enemy = new monster_Vanguard();
                    }else{
                        enemy = new monster_Skeleton();
                    }
                    break;
                case 6:
                    if (roll > 7) {
                        enemy = new monster_Vanguard();
                    } else if (roll > 4) {
                        enemy = new monster_Skeleton();
                    }else if (roll > 1){
                        enemy = new monster_Wyvern();
                    }else{
                        enemy = new monster_brawler();
                    }
                    break;
                case 7:
                    if (roll > 6) {
                        enemy = new monster_Skeleton();
                    } else if (roll > 2) {
                        enemy = new monster_Wyvern();
                    }else if (roll > 1){
                        enemy = new monster_Vanguard();
                    }else{
                        enemy = new monster_giant();
                    }
                    break;
                case 8:
                    if (roll > 6.5) {
                        enemy = new monster_Skeleton();
                    } else if (roll > 3) {
                        enemy = new monster_Wyvern();
                    }else{
                        enemy = new monster_giant();
                    }
                    break;
                case 9:
                    if( roll > 7){
                        enemy = new monster_giant();
                    } else if ( roll > 2){
                        enemy = new monster_Elite();
                    } else if (roll > 1){
                        enemy = new monster_Wyvern();
                    } else {
                        enemy = new monster_vampire();
                    }
                    break;
                case 10:
                    if (roll > 9){
                        enemy = new monster_giant();
                    } else if ( roll > 6){
                        enemy = new monster_Elite();
                    } else if ( roll > 5){
                        enemy = new monster_troll();
                    } else {
                        enemy = new monster_vampire();
                    }
                    break;
                case 11:
                    if(roll > 8){
                        enemy = new monster_Elite();
                    } else if (roll > 6){
                        enemy = new monster_vampire();
                    } else if (roll > 2){
                        enemy = new monster_troll();
                    } else {
                        enemy = new monster_darkCultist();
                    }
                    break;
                case 12:
                    if(roll > 9){
                        enemy = new monster_Elite();
                    } else if ( roll > 7){
                        enemy = new monster_vampire();
                    } else if (roll > 4){
                        enemy = new monster_troll();
                    } else {
                        enemy = new monster_darkCultist();
                    }
                    break;
                case 13:
                    if(roll > 9){
                        enemy = new monster_vampire();
                    } else if (roll > 5){
                        enemy = new monster_troll();
                    } else {
                        enemy = new monster_darkCultist();
                    }
                    break;
                case 14:
                    if(roll > 6){
                        enemy = new monster_troll();
                    } else {
                        enemy = new monster_darkCultist();
                    }
                    break;
                case 15:
                    if(roll > 8){
                        enemy = new monster_troll();
                    } else {
                        enemy = new monster_darkCultist();
                    }
                    break;
                default:
                    enemy = new monster_darkCultist();

            }

        }else if(monsterToFight == 1){
            enemy = new monster_BOSS_Valliard();
        }else if(monsterToFight == 2){
            enemy = new monster_BOSS_priest();
        }else if(monsterToFight == 3){
            enemy = new monster_BOSS_razuulActual();
        }else if(monsterToFight == 4){
            enemy = new monster_BOSS_razuulEmpowered();
        }else if(monsterToFight == 5){
            enemy = new monster_BOSS_Therox();
        }


    }


    public void drawEnemy(Graphics2D g) {
        if (enemy.getName().equals("Wyvern") ) {
            drawImage(enemy.getSprite(), enemy.getCombatPosX()-100, enemy.getCombatPosY()-100, enemy.getSpriteWidth(), enemy.getSpriteHeight(), g);
        } else if(enemy.getName().equals("Priest") || enemy.getName().equals("Razuul")|| enemy.getName().equals("Valliard")) {
            drawImage(enemy.getSprite(), enemy.getCombatPosX()-50, enemy.getCombatPosY()-50, enemy.getSpriteWidth(), enemy.getSpriteHeight(), g);
        }else{
            drawImage(enemy.getSprite(), enemy.getCombatPosX(), enemy.getCombatPosY(), enemy.getSpriteWidth(), enemy.getSpriteHeight(), g);

        }
    }


    public int updateStageAfterBoss(){
        if(enemy.getName() == "Priest"){
            player.setQuestStage(16);
            return 8;
        }else if(enemy.getName() == "Therox"){
            player.setQuestStage(player.getQuestStage() + 1);
            return 13;
        }else if(enemy.getName() == "Razuul") {
            if(player.getQuestStage() == 20) {
                player.setQuestStage(21);
            }
            return 1;
        } else{
            return 1;
        }

    }


    /////////////////////////////////////////
    ///
    ///  Game
    ///
    ////////////////////////////////////////
    Image backGroundImage;
    Image charSpriteSheet;
    Image[] playerImage;


    Character player;
    Monster enemy;

    Combat(Character playertest, int monsterToFight){
        this.player = playertest;

        playerImage = new Image[3];
        player.setCombatPosX(150);
        player.setCombatPosY(200);
        randomMonster(monsterToFight);
        enemy.init();
        enemy.setCombatPosX(600);
        enemy.setCombatPosY(200);
        player.resetBonuses();
        initLog();
        initSound();
        initPlayerTurnDisplay();
        initPortrait();
        initPlayerAttack();
        initRun();
        initAbilityMenu();
        initEnemyTurn();
        initItemMenu();
        initLootScreen();
        initLog();
        initDeath();
        backGroundImage = loadImage("backgroundsprite.png");
        charSpriteSheet = loadImage("charspritesheet.png");
        for(int i =0; i < 3;i++){
            playerImage[i] = subImage(charSpriteSheet,0 + (52 * i), 144,52,72);
        }




        if(player.getSpeed() >= enemy.getSpeed()){
            state = CombatState.playerTurn;
            player.addEnergy(1);
        }else {
            state = CombatState.enemyTurn;
            enemyMakeAttack = true;
            enemy.addEnergy(1);
            enemyLastAbility = enemy.moveChoice();
        }

    }





    public int update(double dt) {


        updateNamePlates(dt);
        updatePlayerTurnDisplay(dt);
        updatePlayerAttack(dt);
        if(state == CombatState.run) {
            updateRun(dt);
        }
        updateEnemyTurn(dt);
        if(state == CombatState.abilityMenu) {
            updateAbilityMenu(dt);
        }
        if(state == CombatState.itemMenu) {
            updateItemMenu(dt);
        }
        if(state == CombatState.lootScreen) {
            updateLootScreen(dt);
        }
        updateLog(dt);
        if(!player.getCombatActive()){
           return updateStageAfterBoss();

        }

        if(state == CombatState.playerDeath){
            updateDeath(dt);

        }

        return 0;
    }


    public void paintComponent(Graphics2D g) {

        clearBackground(800, 600,g);
        drawImage(backGroundImage,0,0,800,400,g);




        if(state == CombatState.playerTurn){
            drawEnemy(g);
            DrawPlayerTurn(g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
        }else if(state == CombatState.playerAttack){
            drawEnemy(g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawLog(g);
            drawPlayerAttack(g);
        }else if(state == CombatState.enemyTurn){
            drawEnemy(g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
            drawLog(g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawEnemyTurn(g);

        }else if(state == CombatState.abilityMenu){
            drawLog(g);
            drawAbilityMenu(g);
        }else if(state == CombatState.itemMenu){
            drawLog(g);
            drawItemMenu(g);
        }else if(state == CombatState.run){
            drawEnemy(g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawLog(g);
            drawRun(g);
        }else if(state == CombatState.lootScreen){
            drawPlayerNamePlate(g);

            drawLog(g);
            drawLootScreen(g);
        }else if(state == CombatState.playerDeath){
            drawEnemy(g);

            drawLog(g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawDeath(g);
        }
    }


    public void DrawPlayerTurn(Graphics2D g){
        drawPlayerNamePlate(g);
        drawEnemyNamePlate(g);
        drawLog(g);
        drawPlayerTurnDisplay(g);
    }


    ///////////////////////////////
    ///
    ///  KeyBinds
    ///
    ///////////////////////////////

    public void keyPressed(KeyEvent e) {
        if( state == CombatState.playerTurn) {
            // Call keyPressed for Main Menu
            keyPressedPlayerTurn(e);
        } else if(state == CombatState.abilityMenu) {
            // Call keyPressed for Options Menu
            keyPressedAbilityMenu(e);
        } else if(state == CombatState.itemMenu) {
            // Call keyPressed for Game
            keyPressedItemMenu(e);
        } else if(state == CombatState.lootScreen) {
            keyPressedLootScreen(e);
        }else if(state == CombatState.playerDeath){
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                System.exit(1);
            }
        }
    }

    public void keyPressedPlayerTurn(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(menuOption == 0){
                playAudio(clicks);
                menuOption = 1;
            }
            if(menuOption == 2){
                playAudio(clicks);
                menuOption = 3;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(menuOption == 1){
                playAudio(clicks);
                menuOption = 0;
            }
            if(menuOption == 3){
                playAudio(clicks);
                menuOption = 2;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(menuOption == 2){
                playAudio(clicks);
                menuOption = 0;
            }
            if(menuOption == 3){
                playAudio(clicks);
                menuOption =1;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(menuOption == 0){
                playAudio(clicks);
                menuOption = 2;
            }
            if(menuOption == 1){
                playAudio(clicks);
                menuOption = 3;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            playAudio(exitClick);
            if(menuOption == 0){
                playAudio(clicks);
                //attackl

                lastAbility = playerAbilities[0];
               // castBasicAttack = true;
                playerTurnSetUp = true;
                state = CombatState.playerAttack;
            }
            if(menuOption == 1){
                playAudio(clicks);
                //abilitie
                state = CombatState.abilityMenu;
                menuOption = 1;

            }
            if(menuOption == 2){
                playAudio(clicks);
                //item
                state = CombatState.itemMenu;
                menuOption = 1;
            }
            if(menuOption == 3){
                playAudio(clicks);
                escapeChance = false;
                state = CombatState.run;
            }
        }

    }

    public void keyPressedAbilityMenu(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            playAudio(exitClick);
           if(menuOption == 20) {
                currentPageNum++;
                menuOption = 1;
            }else if(menuOption == 21){
                currentPageNum--;
                menuOption = 1;

            }else {
                if (player.getEnergy() >= playerAbilities[menuOption + (8 * (currentPageNum-1))].getEnergyCost()) {
                    lastAbility = playerAbilities[menuOption + (8 * (currentPageNum-1))];
                    playerTurnSetUp = true;

                    menuOption = 0;
                    state = CombatState.playerAttack;
                }
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playAudio(exitClick);
            state = CombatState.playerTurn;
            menuOption = 1;

        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){


                if(menuOption == 20){
                    playAudio(clicks);
                    if(prevPageExist) {
                        menuOption = 21;
                    }
                }else if(menuOption == 21){
                playAudio(clicks);
                if(nextPageExist) {
                    menuOption = 20;
                }
            }else if(menuOption < numOfSpellsToDisplay - ((currentPageNum-1) * 8)){
                playAudio(clicks);
                menuOption++;
            }else{
                menuOption = 1;
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_UP){

            if(menuOption == 20){
                playAudio(clicks);
                if(prevPageExist) {
                    menuOption = 21;
                }
            }else if(menuOption == 21){
                playAudio(clicks);
                if(nextPageExist) {
                    menuOption = 20;
                }
            }else if(menuOption > 1 ){
                playAudio(clicks);
                menuOption--;
            }else{
                menuOption = numOfSpellsToDisplay - ((currentPageNum-1) * 8) ;
            }

        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {

            if(menuOption != 20 && menuOption != 21) {
                playAudio(p2);
                lastMenuOption = menuOption;
                if (prevPageExist) {
                    menuOption = 21;
                }
                if (nextPageExist) {
                    menuOption = 20;
                }
            }
        }


        if(e.getKeyCode() == KeyEvent.VK_LEFT) {

            if(menuOption == 20 || menuOption == 21){
                playAudio(p1);
                menuOption = lastMenuOption;
            }
            lastMenuOption = 0;
        }

    }
    int lastMenuOption;
    public void keyPressedItemMenu(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(player.getBagSize() > 0) {
                playAudio(exitClick);
                {
                    lastItemUsed = playerInventory[player.SearchBag(menuOption)];
                    menuOption = 0;
                    playerTurnSetUp = true;
                    useItem = true;
                    displayItem = true;
                    state = CombatState.playerAttack;
                }
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playAudio(exitClick);
            state = CombatState.playerTurn;
            menuOption = 2;

        }


        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(menuOption < player.getBagSize()){
                playAudio(clicks);
                menuOption++;
            }else{
                menuOption = 1;
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if (menuOption > 1) {
                playAudio(clicks);
                menuOption--;
            } else {
                menuOption = player.getBagSize();
            }

        }
    }

    public void keyPressedLootScreen(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){

            if(chestOpen){
                player.setCombatActive(false);

            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
        }

//        if(e.getKeyCode() == KeyEvent.VK_R){
//            numOfLogs = 0;
//            chestOpen = false;
//            enemy.setCurrentHP(enemy.getMaxHP());
//            player.setCurrentHP(player.getMaxHP());
//            enemy.setEnergy(0);
//            player.setEnergy(0);
//            enemy.setAlive(true);
//            player.setCombatPosY(200);
//            player.setCombatPosX(150);
//            chestOpen = false;
//            kill[0] = false;
//            for(int i = 0;i < 6;i++){
//                logStrings[i] = "";
//            }
//
//            state = CombatState.playerTurn;
//        }

    }


    public void keyReleased(KeyEvent event) {
        if(state == CombatState.lootScreen){
            keyReleasedLootScreen(event);
        }

    }

    public void keyReleasedLootScreen(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(player.getCombatPosX() > 550 & !chestOpen){
                playAudio(p3);
                playAudio(coin);
                chestOpen = true;
                collectReward = true;
            }

        }

    }


    public void keyTyped(KeyEvent event) {

    }
}

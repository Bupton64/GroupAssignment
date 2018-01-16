

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

    String textFont = "arial";



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





    public void initPortrait(){



        heartImage = loadImage("heart.png");
        energyImage = loadImage("newbolt.png");
        energyspritesheet = loadImage("bolts.png");
        energyFullImage = subImage(energyspritesheet,0,0,320,480);
        energyEmptyImage = subImage(energyspritesheet,320,0,320,480);


    }

    public void updateNamePlates(double dt){

    }

    public void drawPlayerNamePlate(Graphics2D g) {

        //player portrait
        changeColor(black,g);
        drawSolidCircle(44, 50, 35,g);

        changeColor(Color.gray,g);
        drawCircle(44, 50, 35, 3,g);



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
        drawText(95,23,player.getName(),textFont,20,g);
        drawBoldText(150,47,Integer.toString((int)player.getCurrentHP()) + "/" + Integer.toString((int)player.getMaxHP()),textFont, 15,g);
        changeColor(blue,g);
        drawSolidCircle(40,45,13,g);


        //Level Display
        changeColor(black,g);
        drawSolidCircle(15,80,10,g);
        changeColor(Color.gray,g);
        drawCircle(15,80,10,2,g);
        changeColor(white,g);
        drawText(12,85,Integer.toString(player.getLevel()), textFont,13,g);








        //EXP BAR
        changeColor(Color.gray,g);
        drawRectangle(105,80,102,15,3,g);

        changeColor(purple,g);

        drawSolidRectangle(107,82,(player.getXPTotal() / (player.getXPToNextLevel() /100))  ,12,g);


        changeColor(white,g);
        drawBoldText(77,93,Integer.toString((player.getXPTotal() / (player.getXPToNextLevel() /100))) + "%",textFont, 13,g);




    }

    public void drawEnemyNamePlate(Graphics2D g){
        //player portrait
        changeColor(black,g);
        drawSolidCircle(756, 50, 35,g);
        changeColor(Color.gray,g);
        drawCircle(756, 50, 35, 3,g);

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
        drawText(630,23,enemy.getName(),textFont,20,g);
        drawBoldText(600,47,Integer.toString((int)enemy.getCurrentHP()) + "/" + Integer.toString((int)enemy.getMaxHP()),textFont, 15,g);
        changeColor(red,g);
        drawSolidCircle(760,45,13,g);


        //Level Display
        changeColor(black,g);
        drawSolidCircle(785,80,10,g);
        changeColor(Color.gray,g);
        drawCircle(785,80,10,2,g);
        changeColor(white,g);
        drawText(782,85,Integer.toString(enemy.getLevel()), textFont,13,g);


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


    public void initLog(){
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

        for(int i = 0; i <= numOfLogs;i++){
            if(logColours[i]){
                changeColor(blue,g);
            }else {
                changeColor(red,g);
            }
            if(kill[i]){
                changeColor(black,g);
            }

            drawText(480,570 - (26 * i),logStrings[i],"Times New Roman",18,g);
        }


        changeColor(Color.gray,g);
        drawRectangle(1,401,797,197,4,g);
        //log
        drawRectangle(475,415, 300,165,3,g);
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

    public void initPlayerTurnDisplay(){
        menuOption = 0;
        menuSpriteSheet = loadImage("arrowhead.png");
        menuPointer = subImage(menuSpriteSheet,0,96,48,48);

    }

    public void updatePlayerTurnDisplay(double dt){
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
        changeColor(Color.gray,g);


        drawImage(menuPointer,menuPosX,menuPosY,g);


        drawRectangle(20,415,200,80,2,g);
        drawText(90,460,"Attack",textFont,20,g);

        drawRectangle(20,505,200,80,2,g);
        drawText(90,550,"Items",textFont,20,g);

        drawRectangle(240,415,200,80,2,g);
        drawText(300,460,"Abilities",textFont,20,g);

        drawRectangle(240,505,200,80,2,g);
        drawText(320,550,"Run",textFont,20,g);





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
    boolean playerAttackActive;
    Ability[] playerAbilities;

    boolean castBuff;
    boolean castBasicAttack;
    boolean useItem;
    double playerDamage;

    boolean displayItem;


    String playerTurnLog;






    public void initPlayerAttack(){


        displayItem = false;




        playerDamage = 0;
        castBasicAttack = false;

        playerAbilities = player.getAbilities();

        playerAttackTimer = 0;
        playerAttackDelay = 2;
        playerAttackDuration = 4;
    }

    public void castAttack(){
            lastAbility.use(player);
            playerDamage = lastAbility.getLastDamage();
            playerDamage = enemy.takeDamage((int)playerDamage);
            castBasicAttack = false;
            player.setEnergy(player.getEnergy()-lastAbility.getEnergyCost());

    }

    public void castBuffSpell(){
        lastAbility.use(player);
        playerDamage = lastAbility.getLastDamage();
        castBuff = false;
        player.setEnergy(player.getEnergy()-lastAbility.getEnergyCost());
    }

    public void useItemTurn() {

        lastItemUsed.use(player);
        useItem= false;

    }


    public void updatePlayerAttack(double dt){
        if(state == CombatState.playerAttack) {
            playerAttackTimer += dt;

            if (playerAttackTimer > playerAttackDelay) {
                playerAttackActive = true;
                if(castBasicAttack) {
                    castAttack();
                }else if(castBuff){
                    castBuffSpell();
                }
                if(useItem){
                    useItemTurn();
                }

            }
            if (playerAttackTimer > playerAttackDuration) {
                displayItem =false;
                pushString(playerTurnLog,true,false);
                playerAttackActive = false;
                playerAttackTimer = 0;
                if(enemy.isAlive()){
                    enemy.addEnergy(1);
                    enemyMakeAttack = true;
                    enemyLastAbility = enemy.moveChoice();
                    state = CombatState.enemyTurn;
                }else{
                    pushString(enemy.getName() + " has been killed",true,true);
                    state = CombatState.lootScreen;
                }

            }


        }


    }

    public void drawPlayerAttack(Graphics2D g){




        if(displayItem){

            if(!playerAttackActive){
                drawText(150, 500, "Using " + lastItemUsed.getName() + "...", textFont, 20,g);
            }else{
                playerTurnLog = player.getName() + " used " + lastItemUsed.getName();
                drawText(120, 500, lastItemUsed.getDisplayString(), textFont, 20,g);
            }

        }else{

            if (!playerAttackActive) {
                if (lastAbility.getType() == Ability.AbilityType.damage) {
                    drawText(100, 500, "Using " + lastAbility.getName() + " on " + enemy.getName() + "...", textFont, 20,g);
                } else if (lastAbility.getType() == Ability.AbilityType.buff) {
                    drawText(150, 500, "Casting " + lastAbility.getName() + "...", textFont, 20,g);
                }
            } else if (playerAttackActive) {
                if (lastAbility.getType() == Ability.AbilityType.damage) {
                    if (lastAbility.isLastHit()) {
                        playerTurnLog = player.getName() + " dealt " + (int) playerDamage + " with " + lastAbility.getName();
                        if (lastAbility.isLastCrit()) {
                            playerTurnLog = player.getName() + " crit for " + (int) playerDamage + " with " + lastAbility.getName();
                            drawBoldText(70, 500, "Your " + lastAbility.getName() + " CRITS " + enemy.getName() + " for " + (int) playerDamage + " damage", textFont, 20,g);
                        } else {
                            if (lastAbility.isMagic()) {
                                drawText(70, 500, "Your " + lastAbility.getName() + " hits " + enemy.getName() + " for " + (int) playerDamage + " damage", textFont, 20,g);
                            } else {
                                drawText(70, 500, "Your " + lastAbility.getName() + " hits " + enemy.getName() + " for " + (int) playerDamage + " damage", textFont, 20,g);
                            }
                        }
                    } else {
                        playerTurnLog = player.getName() + " missed with " + lastAbility.getName();
                        drawText(70, 500, "Your " + lastAbility.getName() + " misses " + enemy.getName(), textFont, 20,g);
                    }
                } else if (lastAbility.getType() == Ability.AbilityType.buff) {
                    playerTurnLog = player.getName() + " cast " + lastAbility.getName();
                    drawText(150, 500, lastAbility.getDisplayString(), textFont, 20,g);
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

        if(player.getNumOfAbilities() > 8){
            numOfPages = 1 + ((player.getNumOfAbilities()-1) / 8);
        }

        if(menuOption == 0){
            spellBookPointerX = 70;
            spellBookPointerY = 485;
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



        drawRectangle(1,401,797,197,4,g);
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


        if(menuOption == 0){
            drawText(460,140,"Return","Times New Roman",20,g);
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






        changeColor(red,g);
        drawCircle(145,505,30,4,g);
        drawLine(125,485,165,525,3,g);
        drawLine(165,485,125,525,3,g);



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
        if(menuOption == 0){
            spellBookPointerX = 70;
            spellBookPointerY = 485;
        }
        if(menuOption >= 1 && menuOption <= 9){
            spellBookPointerX = 70;
            spellBookPointerY = 120 + (40 * (menuOption-1));
        }
    }




    public void drawItemMenu(Graphics2D g){
        changeColor(Color.gray,g);
        drawRectangle(1,401,797,197,4,g);
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
                drawText(250, 150 + 40 * (j - 1), "x" + Integer.toString(playerInventory[i].getCounter()), "Times New Roman", 20, g);


                if (menuOption == j) {
                    drawText(430, 140, playerInventory[i % (8 * currentPageNum)].getTooltip(), "Times New Roman", 20, g);
                }

                if (j == player.getBagSize()) {
                    break;
                } else {
                    j++;
                }

            }
        }


        changeColor(red,g);
        drawCircle(145,505,30,4,g);
        drawLine(125,485,165,525,3,g);
        drawLine(165,485,125,525,3,g);

        drawImage(spellBookPointer, spellBookPointerX,spellBookPointerY,40,40,g);


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

    public void initRun(){
        escapeTimer = 0;
        escapeDelay = 3;
        escapeDuration = 6;
        makeEscape = false;

    }

    public void updateRun(double dt){
        if(state == CombatState.run){
            escapeTimer += dt;
            if(escapeTimer > escapeDelay){
                escapeActive = true;
                if(Math.random()* 10 > 5) {
                    makeEscape = true;
                }
            }
            if(escapeTimer > escapeDuration){
                escapeTimer = 0;
                escapeActive = false;
                enemy.addEnergy(1);
                enemyMakeAttack = true;
                enemyLastAbility = enemy.moveChoice();
                if(makeEscape){
                    player.setCombatActive(false);
                }else {
                    state = CombatState.enemyTurn;
                }
            }
        }else{
            escapeTimer = 0;
        }

    }

    public void drawRun(Graphics2D g){
        changeColor(black,g);
        if(!escapeActive) {
            drawText(100, 500, "You attempt to escape from " + enemy.getName() + "...", textFont, 20,g);
        }else if(escapeActive){
            if(makeEscape){
                drawText(100, 500, "You managed to get away!", textFont, 20, g);
            }else {
                drawText(50, 500, "You escape, But " + enemy.getName() + " uses i++ to catch you", textFont, 20, g);
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

    boolean enemyAttackActive;
    boolean enemyMakeAttack;

    String enemyTurnLog;


    public void initEnemyTurn(){
        enemyAttackActive = false;
        enemyTurnTimer = 0;
        enemyTurnDelay = 2;
        enemyTurnDuration = 4;
    }

    public void enemyAttack(){

        enemyDamage = enemyLastAbility.getLastDamage();
        enemy.addEnergy(-enemyLastAbility.getEnergyCost());
        enemyDamage = player.takeDamage((int)enemyDamage);
        enemyMakeAttack = false;

    }

    public void updateEnemyTurn(double dt){
        if(state == CombatState.enemyTurn){
            enemyTurnTimer += dt;
            if(enemyTurnTimer > enemyTurnDelay){
                enemyAttackActive = true;
                if(enemyMakeAttack){
                    enemyAttack();
                }

            }
            if(enemyTurnTimer > enemyTurnDuration){
                pushString(enemyTurnLog,false,false);
                enemyAttackActive = false;
                enemyTurnTimer = 0;
                player.addEnergy(1);
                state = CombatState.playerTurn;
            }
        }
    }

    public void drawEnemyTurn(Graphics2D g){
        changeColor(black,g);
        drawLog(g);

        if(!enemyAttackActive) {
            drawText(100, 500, enemy.getName() + " attempts to " + enemyLastAbility.getName() + "...", textFont, 20,g);
        }else if(enemyAttackActive){

            if(enemyLastAbility.isLastHit()){
                enemyTurnLog = enemy.getName() + " dealt " + (int)enemyDamage + " with "+ enemyLastAbility.getName();
                if(enemyLastAbility.isMagic()) {

                    drawText(70, 500, enemy.getName() + "'s " + enemyLastAbility.getName() + " hits you for " + (int)enemyDamage + " magic damage", textFont, 20,g);

                }else{
                    if(enemyLastAbility.isLastCrit()){
                        enemyTurnLog = enemy.getName() + " crit for " + (int)enemyDamage + " with "+ enemyLastAbility.getName();
                        drawBoldText(25, 500, enemy.getName() + "'s " + enemyLastAbility.getName() + " CRITS you for " + (int)enemyDamage + " phys damage", textFont, 20,g);
                    }else{

                        drawText(70, 500, enemy.getName() + "'s " + enemyLastAbility.getName() + " hits you for " + (int)enemyDamage + " phys damage", textFont, 20,g);
                    }

                }
            }else{
                enemyTurnLog = enemy.getName() + " missed with "+ enemyLastAbility.getName();
                drawText(70, 500, enemy.getName() + "'s " + enemyLastAbility.getName() + " misses you", textFont, 20,g);
            }

        }

    }


    /////////////////////////////////////////
    ///
    ///  Loot Screen
    ///
    ////////////////////////////////////////

    Image coinImage;
    Image chestClosedImage;
    Image chestOpenImage;

    Item reward;
    boolean collectReward;

    boolean right;
    boolean chestOpen;

    double walkTimer;
    double walkDuration;

    int currentGold;

    boolean levelUp;

    public void initLootScreen(){
        levelUp = false;
        currentGold = player.getGpTotal();
        right = false;
        collectReward = false;

        coinImage = loadImage("coin.png");
        chestClosedImage = loadImage("chest1.png");
        chestOpenImage = loadImage("chest2.png");

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
        changeColor(black,g);
        if(!chestOpen) {
            drawText(80, 500, "Victory, Press 'Space' on Chest to collect Reward", "Times New Roman", 18, g);
        }else{
            if(reward.getName() == null){
                drawText(80, 470, "Nothing dropped from " + enemy.getName(), "Times New Roman", 18, g);
            }else{
                drawText(80, 470, reward.getName() + " dropped from " + enemy.getName(), "Times New Roman", 18, g);
            }
            drawText(80, 500, "Press 'Space' again to return to the overworld!", "Times New Roman", 18, g);
        }
        drawImage(coinImage,640,-10,70,70,g);
        changeColor(white,g);
        drawText(710,35,Integer.toString(player.getGpTotal()),"Times New Roman",30,g);

        if(!chestOpen){
            drawImage(chestClosedImage,630,220,130,130,g);
        }else{
            drawImage(chestOpenImage,630,220,130,130,g);
            changeColor(purple,g);
            drawBoldText(570,210,"+" + enemy.getXPGain() + " EXP","Times New Roman", 20,g);
            changeColor(yellow,g);
            drawBoldText(570,190,"+" + (player.getGpTotal() - currentGold) + " GOLD","Times New Roman",20,g);

        }
        if(right){
            int j= getAnimationFrame(walkTimer,walkDuration,3);
            drawImage(playerImage[j],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
        }else{

            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);

        }

        if(levelUp){
            changeColor(purple,g);
            drawBoldText(260,170,"Level Up","Felix Titling",70,g);
        }

    }

    /////////////////////////////////////////
    ///
    ///  Finding an Opponent
    ///
    ////////////////////////////////////////

    double roll;

    public void randomMonster(){

        roll = Math.random() * 10;

        switch(player.getLevel()){
            case 1:
                if(roll > 1) {
                    enemy = new monster_Goblin();
                }else{
                    enemy = new monster_Wolf();
                }
                break;
            case 2:
                if(roll > 7){
                    enemy = new monster_Goblin();
                }else if(roll > 1){
                    enemy = new monster_Wolf();
                }else{
                    enemy = new monster_Witch();
                }
                break;
            case 3:
                if(roll > 9){
                    enemy = new monster_Goblin();
                }else if(roll > 3){
                    enemy = new monster_Wolf();
                }else{
                    enemy = new monster_Witch();
                }
                break;
            case 4:
                if(roll > 9){
                    enemy = new monster_Goblin();
                }else if(roll > 5){
                    enemy = new monster_Wolf();
                }else{
                    enemy = new monster_Witch();
                }
                break;
            case 5:
                if(roll > 8){
                    enemy = new monster_Wolf();
                }else{
                    enemy = new monster_Witch();
                }
                break;
            default :
                enemy = new monster_Witch();
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

    Combat(Character playertest){
        this.player = playertest;

        playerImage = new Image[3];
        player.setCombatPosX(150);
        player.setCombatPosY(200);
        randomMonster();
        enemy.init();
        enemy.setCombatPosX(600);
        enemy.setCombatPosY(200);
        player.resetBonuses();
        initPortrait();
        initPlayerTurnDisplay();
        initPlayerAttack();
        initRun();
        initAbilityMenu();
        initEnemyTurn();
        initItemMenu();
        initLootScreen();
        initLog();
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
        if(!player.isAlive()){
            state = CombatState.playerDeath;
        }

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
            return 1;
        }
        return 0;
    }


    public void paintComponent(Graphics2D g) {

        clearBackground(800, 600,g);
        drawImage(backGroundImage,0,0,800,400,g);




        if(state == CombatState.playerTurn){
            drawImage(enemy.getSprite(),enemy.getCombatPosX(),enemy.getCombatPosY(),enemy.getSpriteWidth(),enemy.getSpriteHeight(),g);
            DrawPlayerTurn(g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
        }else if(state == CombatState.playerAttack){
            drawImage(enemy.getSprite(),enemy.getCombatPosX(),enemy.getCombatPosY(),enemy.getSpriteWidth(),enemy.getSpriteHeight(),g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawLog(g);
            drawPlayerAttack(g);
        }else if(state == CombatState.enemyTurn){
            drawImage(enemy.getSprite(),enemy.getCombatPosX(),enemy.getCombatPosY(),enemy.getSpriteWidth(),enemy.getSpriteHeight(),g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawEnemyTurn(g);
            drawLog(g);
        }else if(state == CombatState.abilityMenu){
            drawAbilityMenu(g);
        }else if(state == CombatState.itemMenu){
            drawItemMenu(g);
        }else if(state == CombatState.run){
            drawImage(enemy.getSprite(),enemy.getCombatPosX(),enemy.getCombatPosY(),enemy.getSpriteWidth(),enemy.getSpriteHeight(),g);
            drawImage(playerImage[0],player.getCombatPosX(),player.getCombatPosY(),112,144,g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
            drawLog(g);
            drawRun(g);
        }else if(state == CombatState.lootScreen){
            drawPlayerNamePlate(g);
            drawLootScreen(g);
            drawLog(g);
        }else if(state == CombatState.playerDeath){
            drawImage(enemy.getSprite(),enemy.getCombatPosX(),enemy.getCombatPosY(),enemy.getSpriteWidth(),enemy.getSpriteHeight(),g);
            changeColor(white,g);
            drawText(240,200,"GAME OVER!", "Times New Roman",60,g);
            drawLog(g);
            drawPlayerNamePlate(g);
            drawEnemyNamePlate(g);
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
        }
    }

    public void keyPressedPlayerTurn(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(menuOption == 0){
                menuOption = 1;
            }
            if(menuOption == 2){
                menuOption = 3;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(menuOption == 1){
                menuOption = 0;
            }
            if(menuOption == 3){
                menuOption = 2;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(menuOption == 2){
                menuOption = 0;
            }
            if(menuOption == 3){
                menuOption =1;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(menuOption == 0){
                menuOption = 2;
            }
            if(menuOption == 1){
                menuOption = 3;
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(menuOption == 0){
                //attackl

                lastAbility = playerAbilities[0];
                if(lastAbility.getType() == Ability.AbilityType.damage){
                    castBasicAttack = true;
                }else if(lastAbility.getType() == Ability.AbilityType.buff){
                    castBuff = true;
                }
                state = CombatState.playerAttack;
            }
            if(menuOption == 1){
                //abilitie
                state = CombatState.abilityMenu;
                menuOption = 0;

            }
            if(menuOption == 2){
                //item
                state = CombatState.itemMenu;
                menuOption = 0;
            }
            if(menuOption == 3){
                state = CombatState.run;
            }
        }

    }

    public void keyPressedAbilityMenu(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(menuOption == 0){
                state = CombatState.playerTurn;
                menuOption = 1;
            }else if(menuOption == 20) {
                currentPageNum++;
                menuOption = 1;
            }else if(menuOption == 21){
                currentPageNum--;
                menuOption = 1;

            }else {
                if (player.getEnergy() >= playerAbilities[menuOption + (8 * (currentPageNum-1))].getEnergyCost()) {
                    lastAbility = playerAbilities[menuOption + (8 * (currentPageNum-1))];
                    if(lastAbility.getType() == Ability.AbilityType.damage){
                        castBasicAttack = true;
                    }else if( lastAbility.getType() == Ability.AbilityType.buff){
                        castBuff = true;
                    }

                    menuOption = 0;
                    state = CombatState.playerAttack;
                }
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){


            if(menuOption == 20){
                if(prevPageExist) {
                    menuOption = 21;
                }
            }else if(menuOption == 21){
                if(nextPageExist) {
                    menuOption = 20;
                }
            }else if(menuOption < numOfSpellsToDisplay - ((currentPageNum-1) * 8)){
                menuOption++;
            }else{
                menuOption = 0;
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_UP){

            if(menuOption == 20){
                if(prevPageExist) {
                    menuOption = 21;
                }
            }else if(menuOption == 21){
                if(nextPageExist) {
                    menuOption = 20;
                }
            }else if(menuOption > 0 ){
                menuOption--;
            }else{
                menuOption = numOfSpellsToDisplay - ((currentPageNum-1) * 8) ;
            }

        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(menuOption != 20 && menuOption != 21) {
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
                menuOption = lastMenuOption;
            }
            lastMenuOption = 0;
        }

    }
    int lastMenuOption;
    public void keyPressedItemMenu(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(menuOption == 0){
                state = CombatState.playerTurn;
                menuOption = 2;
            }else {

                    lastItemUsed = playerInventory[player.SearchBag(menuOption)];
                    menuOption = 0;
                    useItem = true;
                    displayItem = true;
                    state = CombatState.playerAttack;
                }
            }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(menuOption < player.getBagSize()){
                menuOption++;
            }else{
                menuOption = 0;
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if (menuOption > 0) {
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

        if(e.getKeyCode() == KeyEvent.VK_R){
            numOfLogs = 0;
            chestOpen = false;
            enemy.setCurrentHP(enemy.getMaxHP());
            player.setCurrentHP(player.getMaxHP());
            enemy.setEnergy(0);
            player.setEnergy(0);
            enemy.setAlive(true);
            player.setCombatPosY(200);
            player.setCombatPosX(150);
            chestOpen = false;
            kill[0] = false;
            for(int i = 0;i < 6;i++){
                logStrings[i] = "";
            }

            state = CombatState.playerTurn;
        }

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
                chestOpen = true;
                collectReward = true;
            }

        }

    }


    public void keyTyped(KeyEvent event) {

    }
}

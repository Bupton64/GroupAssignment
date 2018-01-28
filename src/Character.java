import java.awt.*;

public class Character extends Statblock {

    private int XPTotal; //< Contains the characters current XP total
    private int XPToNextLevel; //< Contains the characters required XPTotal for next level
    private int gpTotal; //< The characters gold total
    private double mapPosX; //< Characters map position X
    private double mapPosY; //< Characters map position Y
    private Item [] inventory; //< The characters inventory.
    private Item [] equippedItems; //< The characters currently equipped items.
    private int maxInventorySize; //< Maximum size of the players inventory.
    private double currentMapLocation; //< Determines what map number the player is currently on
    private boolean combatActive; //< Determines whether the character is in combat.
    private double GameTimer;

    public double getGameTimer() {
        return GameTimer;
    }

    public void setGameTimer(double gameTimer) {
        GameTimer = gameTimer;
    }

    public int getInventorySize(){
        int count=0;
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getSlot()!=null){
                count++;
            }
        }
        return count;
    }

    public int getBagSize(){
        int count=0;
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getSlot() == Item.Slot.bag){
                count++;
            }
        }
        return count;
    }

    public int SearchBag(int index){
        int i;
        for(i=0; i<maxInventorySize; i++){
            if(inventory[i].getSlot() == Item.Slot.bag){
                index--;
                if(index == 0){
                    break;
                }
            }
        }
        return i;
    }

    public int getEquipmentSize(){
        int count = 0;
        for(int i = 0; i<6; i++){
            if( equippedItems[i].getSlot() != null){
                count++;
            }
        }
        return  count;
    }

    public void setCombatActive(boolean active){
        this.combatActive = active;
    }

    public boolean getCombatActive(){
        return combatActive;
    }

    public Item[] getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(Item[] equippedItems) {
        this.equippedItems = equippedItems;
    }

    public int getMaxInventorySize() {
        return maxInventorySize;
    }

    public void setMaxInventorySize(int maxInventorySize) {
        this.maxInventorySize = maxInventorySize;
    }

    public double getCurrentMapLocation() {
        return currentMapLocation;
    }

    public void setCurrentMapLocation(double currentMapPos) {
        this.currentMapLocation = currentMapPos;
    }

    public void sortInventory(){
        Item swapper;
        for(int i=0; i < maxInventorySize; i++){
            for(int j = 1; j < maxInventorySize-i; j++){
                if((inventory[j-1].getSlot()==null) && inventory[j].getSlot() != null){
                    swapper = inventory[j-1];
                    inventory[j-1] = inventory[j];
                    inventory[j]=swapper;
                }
            }
        }
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public double getMapPosX() {
        return mapPosX;
    }

    public void setMapPosX(double mapPosX) {
        this.mapPosX = mapPosX;
    }

    public double getMapPosY() {
        return mapPosY;
    }

    public void setMapPosY(double mapPosY) {
        this.mapPosY = mapPosY;
    }

    public int getXPTotal() {
        return XPTotal;
    }

    public void setXPTotal(int XPTotal) {
        this.XPTotal = XPTotal;
    }

    public int getXPToNextLevel() {
        return XPToNextLevel;
    }

    public void setXPToNextLevel(int XPToNextLevel) {
        this.XPToNextLevel = XPToNextLevel;
    }

    public int getGpTotal() {
        return gpTotal;
    }

    public void setGpTotal(int gpTotal) {
        this.gpTotal = gpTotal;
    }

    public Character() {
        this.init();
    }

    public int findItemIndex(Item newItem){
        assert(alreadyHoldsItem(newItem));
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getName()==newItem.getName()){
                return i;
            }
        }
        return -1;
    }

    public boolean alreadyHoldsItem(Item newItem){
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getName()==newItem.getName()){
                return true;
            }
        }
        return false;
    }

    public void addItemToInventory(Item newItem){
        if(isInventoryFull()){ return;}
        if(newItem.getSlot() == Item.Slot.bag) {
            if (alreadyHoldsItem(newItem)) {
                int index = findItemIndex(newItem);
                inventory[index].setCounter(inventory[index].getCounter() + 1);
                sortInventory();
                return;
            }
        }
        for(int i=0; i<maxInventorySize; i++) {
            if (inventory[i].getSlot() == null) {
                inventory[i] = newItem;
                sortInventory();
                return;
            }
        }
        sortInventory();
    }

    public void equipItem(Item newItem) {
        if (!newItem.isEquippable()){return;}
        if (newItem.getSlot() == Item.Slot.bag || newItem.getSlot() == null){return;}
        if(!alreadyHoldsItem(newItem)){return;}
        newItem.setEquipped(true);
        int index=-1;
        for (int i=0; i<6; i++){ //< Find which slot is to be replaced
            if(equippedItems[i].getSlot()==newItem.getSlot()){
                index=i;
            }
        }
        if(index > -1) {
            Item temp = equippedItems[index]; //< Store old item in case of full inventory
            equippedItems[index] = newItem; //< Equip the new item in the right slot
            removeFromInventory(newItem);
            for (int i = 0; i < maxInventorySize; i++) { //< Put old item in inventory now that space is definitely there
                if (inventory[i].getSlot() == null) {
                    inventory[i] = temp;
                    inventory[i].setEquipped(false);
                    break;
                }
            }

        } else {
            for (int i = 0; i < 6; i++) { //< Find the next available slot in equipment
                if (equippedItems[i].getSlot() == null) {
                    equippedItems[i] = newItem;
                    removeFromInventory(newItem);
                    break;
                }
            }
        }
        checkGear();
        setGearStats();
        sortInventory();
    }

    public void unequipItem(Item item){
        if(isInventoryFull()){return;}
        if(!item.isEquipped()){return;}
        for(int i = 0; i < 6; i++){
            if(equippedItems[i] == item){ //< Find the item in equipment
                equippedItems[i].setEquipped(false);
                for(int j = 0; j < maxInventorySize ; j++){ //< Find the open spot in inventory
                    if(inventory[j].getSlot() == null){
                        inventory[j] = item; //< Place item in inventory
                        equippedItems[i] = new Item(); //< Remove old item
                        break;
                    }
                }
                break;
            }
        }
        checkGear();
        setGearStats();
        sortInventory();
    }

    public boolean isInventoryFull(){
        for(int i =0; i < maxInventorySize; i++){
            if(inventory[i].getSlot() == null){
                return false;
            }
        }
        return true;
    }

    public void removeFromInventory(Item item){
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i] == item){
                inventory[i] = new Item();
                break;
            }
        }
        sortInventory();
    }

    public void checkGear(){
        int head=0;
        int feet=0;
        int chest=0;
        int weapon=0;
        int offhand=0;
        int accessory=0;

        for(int i=0; i<6; i++){
            if(equippedItems[i].getSlot()==Item.Slot.head){
                head++;
            }
            if(equippedItems[i].getSlot()==Item.Slot.feet){
                feet++;
            }
            if(equippedItems[i].getSlot()==Item.Slot.chest){
                chest++;
            }
            if(equippedItems[i].getSlot()==Item.Slot.weapon){
                weapon++;
            }
            if(equippedItems[i].getSlot()==Item.Slot.offhand){
                offhand++;
            }
            if(equippedItems[i].getSlot()==Item.Slot.accessory){
                accessory++;
            }

        }

        if(head > 1 || feet > 1 || chest > 1 || weapon > 1 || offhand > 1 || accessory > 1 ){

            System.exit(27);
        }

    }

    public void setGearStats(){
        int speedBonus=0;
        int attackBonus=0;
        int luckBonus=0;
        int defenseBonus=0;
        int strengthBonus=0;

        for(int i=0; i<6; i++){
            speedBonus+=equippedItems[i].getSpeed();
            attackBonus+=equippedItems[i].getAttack();
            luckBonus+=equippedItems[i].getLuck();
            defenseBonus+=equippedItems[i].getDefense();
            strengthBonus+=equippedItems[i].getStrength();
        }

        setEquipAttackBonus(attackBonus);
        setEquipSpeedBonus(speedBonus);
        setEquipLuckBonus(luckBonus);
        setEquipDefenseBonus(defenseBonus);
        setEquipStrengthBonus(strengthBonus);
    }

    public void init(){
        //Quest Init - Zane
        GameTimer = 0.0;
        setMapPosX(250);
        setMapPosY(240);
        setCurrentMapLocation(21);
        questStage = 0;
        currentQuest = new quest_blankQuest();

        // Memory initialisation

        inventory = new Item [50];
        for(int i=0; i<50; i++){
            inventory[i] = new Item();
        }
        equippedItems = new Item [6];
        for(int i=0; i<6; i++){
            equippedItems[i] = new Item();
        }

        //< Set up starting Inventory
        setMaxInventorySize(50);
        initInventory();

        //< Check inventory
        /*
        for(int i=0; i<maxInventorySize; i++){
            System.out.println(inventory[i].getName());
        }
        int index=0;
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getName()=="Rusty Sword"){
                index=i;
                break;
            }
        }
        equipItem(inventory[index]);
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getName()=="Iron Sword"){
                index=i;
                break;
            }
        }
        equipItem(inventory[index]);
        System.out.println();
        for(int i=0; i<maxInventorySize; i++){
            System.out.println(inventory[i].getName());
        }

        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i].getName()=="Rusty Sword") {
                index = i;
                break;
            }
        }
        equipItem(inventory[index]);
        System.out.println();
        for(int i=0; i<maxInventorySize; i++){
            System.out.println(inventory[i].getName());
        }
        */

        //< Set up initial Stats
        initStats();

        //< Set up the ability list (Needs all abilities, check unlockAbility to make sure character gains access)
        initAbilities();

        //< Load the characters combat sprite
        initImage();

        // Test Functions
        setGpTotal(100);
//        setQuestStage(23);
//        currentQuest = new quest_AWanderingSoul();
//        currentQuest.setDisplayReward(false);
//        currentQuest.setState(Quest.questState.preQuest);
        setXPTotal(0); //< TESTERS
        checkLevelUp(); //< Tester
    }

    public void initInventory(){

        // Equipment

        // Weapons

        item_Equipment rusty = new item_Equipment("Rusty Sword", 1, 0, 0, 0, 0, Item.Slot.weapon, "An old warriors sword", 10, 0);
        addItemToInventory(rusty); // T0 Sword
        equipItem(rusty);

<<<<<<< HEAD
        item_Potion pot = new item_Potion();
        pot.setCounter(2);
        addItemToInventory(pot);
        /*
=======
>>>>>>> 414417e317701fa2970c1ead96f8b5481872c345

        item_Equipment bronzeSword = new item_Equipment("Bronze Sword", 1, 0, 0, 0, 1, Item.Slot.weapon, "Durable and strong", 50, 300);
        addItemToInventory(bronzeSword); //T1 Sword

        item_Equipment stone = new item_Equipment("Stone Axe", 0, 0, 0, 0, 1, Item.Slot.weapon, "Rugged, yet effective", 300, 400);
        addItemToInventory(stone); //T1 Axe

        item_Equipment monksStaff = new item_Equipment("Monk's Staff", 1, 0, 0, 2, 0, Item.Slot.weapon, "A light wooden staff", 300, 1000);
        addItemToInventory(monksStaff); //T2 Staff

        item_Equipment rough = new item_Equipment("Rough Axe", 0, 0, 0, 0, 2, Item.Slot.weapon, "A violent edge and little else", 3300, 1200);
        addItemToInventory(rough); //T2 Axe

        item_Equipment spear = new item_Equipment("Guardsman's Spear", 1, 0, 1, 0, 0, Item.Slot.weapon, "A military issue spear", 290, 1100);
        addItemToInventory(spear); //T2 Spear

        item_Equipment ironSword = new item_Equipment("Iron Sword", 4, 0, 0, 0, 2, Item.Slot.weapon, "A well forged sword", 600, 2300);
        addItemToInventory(ironSword); //T3 Sword

        item_Equipment trickspear = new item_Equipment("Trickster's Spear", 2, 0, 3, 0, 0, Item.Slot.weapon, "Expertly balanced spear", 590, 2250);
        addItemToInventory(trickspear); //T3 Spear

        item_Equipment acolyte = new item_Equipment("Acolyte's Staff", 2, 0, 0, 5, 0, Item.Slot.weapon, "Crafted from enchanted willow", 620, 2090);
        addItemToInventory(acolyte); //T3 Staff

        item_Equipment steelSword = new item_Equipment("Steel Sword", 8, 0, 0, 0, 4, Item.Slot.weapon, "Grace and power combined", 1300, 4500);
        addItemToInventory(steelSword); //T4 Sword

        item_Equipment gladiator = new item_Equipment("Gladiator's Axe", 8, 0, 0, 0, 8, Item.Slot.weapon, "Keen edged and lethal", 1450, 5200);
        addItemToInventory(gladiator); //T4 Axe

        item_Equipment jester = new item_Equipment("Jester's Staff", 4, 0, 0, 10, 0, Item.Slot.weapon, "Lighter than air itself", 1250, 4800);
        addItemToInventory(jester); //T4 Staff

        item_Equipment emperor = new item_Equipment("Emperor's Word", 4, 0, 6, 0, 0, Item.Slot.weapon, "His voice pierces hearts", 1400, 4950);
        addItemToInventory(emperor); //T4 Spear

        item_Equipment valkyrie = new item_Equipment("Valkyrie", 10, 10, 4, 0, 8, Item.Slot.weapon, "A legend made reality", 0, 0);
        addItemToInventory(valkyrie); //Endgame Sword


        // Head

        item_Equipment ragged = new item_Equipment("Ragged Cap", 0, 0, 0, 0, 0, Item.Slot.head, "Stitched leather", 10, 0);
        addItemToInventory(ragged);
        equipItem(ragged);

        item_Equipment skull = new item_Equipment("Skull Cap", 0, 1, 0, 0, 0, Item.Slot.head, "Can deflect blows", 40, 290);
        addItemToInventory(skull); //< T1 Helm

        item_Equipment visor = new item_Equipment("Steel Visor", 0, 2, 0, 0, 0, Item.Slot.head, "Safety is key", 240, 780);
        addItemToInventory(visor); //< T2 Helm

        item_Equipment conical = new item_Equipment("Conical Helm", 0, 3, 0, 0, 0, Item.Slot.head, "Excellent skull protection", 340, 1980);
        addItemToInventory(conical); //< T3 Helm

        item_Equipment great = new item_Equipment("Great Helm", 0, 4, 0, 0, 0, Item.Slot.head, "Forged to withstand giants", 765, 3200);
        addItemToInventory(great); //< T4 Helm

        // Offhand

        item_Equipment buckler = new item_Equipment("Worn Buckler", 0, 1, 0, 0, 0, Item.Slot.offhand, "A small buckler", 20, 200);
        addItemToInventory(buckler);
        equipItem(buckler); // T1 Shield

        item_Equipment shiv = new item_Equipment("Shiv", 1, 0, 0, 1, 0, Item.Slot.offhand, "A twisted edge", 40, 290);
        addItemToInventory(shiv);
        equipItem(buckler); // T1 Dagger

        item_Equipment shield = new item_Equipment("Wooden Shield", 0, 2, 0, 0, 0, Item.Slot.offhand, "A lightweight shield", 120, 600);
        addItemToInventory(shield);
        equipItem(buckler); // T2 Shield

        item_Equipment assassin = new item_Equipment("Assassin's Dagger", 3, 0, 0, 1, 0, Item.Slot.offhand, "Keen and silent", 40, 2050);
        addItemToInventory(assassin);
        equipItem(buckler); // T3 Dagger

        item_Equipment steelShield = new item_Equipment("Steel Shield", 0, 4, 1, 0, 0, Item.Slot.offhand, "An elite's shield", 1200, 2800);
        addItemToInventory(steelShield);
        equipItem(buckler); // T4 Shield

        // Feet

        item_Equipment clothShoes = new item_Equipment("Cloth Shoes", 0, 0, 0, 0, 0, Item.Slot.feet, "A comfy pair of wraps", 10, 0);
        addItemToInventory(clothShoes);
        equipItem(clothShoes); // T0 Boots

        item_Equipment boots = new item_Equipment("Leather Boots", 0, 1, 0, 2, 0, Item.Slot.feet, "Sturdy walking boots", 10, 210);
        addItemToInventory(boots); // T1 Boots

        item_Equipment chain = new item_Equipment("Chain Boots", 0, 2, 0, 2, 0, Item.Slot.feet, "Light and durable", 230, 550);
        addItemToInventory(chain); // T2 Boots

        item_Equipment half = new item_Equipment("Half Plate Boots", 0, 3, 0, 1, 0, Item.Slot.feet, "A guardman's pair", 415, 1890);
        addItemToInventory(half); // T3 Boots

        item_Equipment full = new item_Equipment("Full Plate Boots", 0, 4, 0, 0, 0, Item.Slot.feet, "Made for knights", 1090, 3040);
        addItemToInventory(full); // T4 Boots

        // Chests

        item_Equipment robe = new item_Equipment("Traveller's Robe", 0, 0, 0, 0, 0, Item.Slot.chest, "For long journeys", 10, 0);
        addItemToInventory(robe);
        equipItem(robe); // T0 Chest

        item_Equipment leatherJack = new item_Equipment("Leather Jack", 0, 1, 0, 1, 0, Item.Slot.chest, "Provides basic protection", 50, 300);
        addItemToInventory(leatherJack); // T1 Chest

        item_Equipment scale = new item_Equipment("Scale Mail", 0, 2, 0, 2, 0, Item.Slot.chest, "A sturdy chestpiece", 390, 1040);
        addItemToInventory(scale); // T2 Chest

        item_Equipment breast = new item_Equipment("Breastplate", 0, 4, 0, 2, 0, Item.Slot.chest, "Solid and sure", 1080, 2700);
        addItemToInventory(breast); // T3 Chest

        item_Equipment plate = new item_Equipment("Full Platemail", 0, 8, 0, 0, 0, Item.Slot.chest, "The pinnacle of armour", 2340, 4900);
        addItemToInventory(plate); // T4 Chest

        // Accessories - All first unlock unless specified

        item_Equipment silver = new item_Equipment("Silver Amulet", 0, 0, 2, 0, 0, Item.Slot.accessory, "A lucky charm", 400, 2000);
        addItemToInventory(silver);

        item_Equipment gold = new item_Equipment("Gold Amulet", 0, 0, 0, 3, 0, Item.Slot.accessory, "An inspiring memento", 400, 2000);
        addItemToInventory(gold);

        item_Equipment chainGaunt = new item_Equipment("Chain Gauntlets", 0, 0, 0, 0, 2, Item.Slot.accessory, "Fitted knuckles", 400, 2000);
        addItemToInventory(chainGaunt);

        item_Equipment leatherBrace = new item_Equipment("Leather Bracers", 0, 1, 0, 1, 0, Item.Slot.accessory, "Extra protection", 450, 4000);
        addItemToInventory(leatherBrace);

        item_Equipment steelGaunt = new item_Equipment("Steel Gauntlets", 0, 0, 2, 0, 0, Item.Slot.accessory, "Strong, edged plating", 1700, 4500);
        addItemToInventory(steelGaunt); // After 2nd unlock

        item_Equipment hide = new item_Equipment("Hide Bracers", 0, 2, 0, 0, 0, Item.Slot.accessory, "Forearm guard", 1900, 3800);
        addItemToInventory(hide); // After 2nd unlock

        // Items

        item_SpeedPotion speed = new item_SpeedPotion();
        addItemToInventory(speed);

        item_soulStone soul = new item_soulStone();
        addItemToInventory(soul);

        item_Eyedrops eye = new item_Eyedrops();
        addItemToInventory(eye);

        item_Antidote anti = new item_Antidote();
        anti.setCounter(99);
        addItemToInventory(anti);

        item_HealingSalve salve = new item_HealingSalve();
        addItemToInventory(salve);

        item_megaPotion mega = new item_megaPotion();
        addItemToInventory(mega);

        item_elixir elixir = new item_elixir();
        addItemToInventory(elixir);

        item_Potion pot = new item_Potion();
        pot.setCounter(99);
        addItemToInventory(pot);

        item_scrollOfKnowledge scroll = new item_scrollOfKnowledge();
        addItemToInventory(scroll);
        */
    }

    public void initStats(){
        combatActive = false;
        setAttack(5);
        setDefense(3);
        setLuck(3);
        setSpeed(3);
        setStrength(3);
        setXPTotal(0);
        setXPToNextLevel(500);
        setGpTotal(50);
        setCurrentHP(150);
        setMaxHP(150);
        setLevel(1);
        setAlive(true);
        setName("Bjarne");
        setEnergy(0);
    }

    public void initAbilities(){
        Ability [] temp = new Ability[20];
        for(int i=0; i<20; i++){
            temp[i] = new Ability();
            temp[i].setActive(false);
        }
        setMaxNumAbilities(20);
        temp[0] = new ability_BasicAttack();
        temp[1] = new ability_Slash();
        temp[2] = new ability_Spark();
        temp[3] = new ability_DualStrike();
        temp[4] = new ability_BladeDance();
        temp[5] = new ability_Armageddon();
        temp[6] = new ability_Smash();
        temp[7] = new ability_Heal();
        temp[8] = new ability_IronSkin();
        temp[9] = new ability_Berserk();
        temp[10] = new ability_Devastate();
        temp[11] =  new ability_regenerate();
        temp[12] = new ability_psiblast();
        temp[13] = new ability_heroism();
        temp[14] = new ability_ironFist();
        this.setAbilities(temp);
        setNumOfAbilities();
        sortAbilities();
    }

    public void initImage(){
        Image sprite = loadImage("combatCharacter.png");
        setSprite(sprite);
        setSpriteWidth(150);
        setSpriteHeight(150);
    }

    public void unlockAbility(){
        Ability [] temp = new Ability[20];
        for(int i=0; i<20; i++){
            temp[i]=new Ability();
        }
        temp=getAbilities();
        int level = getLevel();
        switch(level){

            case 2:
            for(int i=0; i<getMaxNumAbilities(); i++) {
                if (temp[i].getName() == "Slash") {
                    temp[i].setActive(true);
                }
                if(temp[i].getName()=="Heal"){
                    temp[i].setActive(true);
                }
            }
            break;

            case 3:
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Smash"){
                    temp[i].setActive(true);
                }
                if(temp[i].getName()=="Blade Dance"){
                    temp[i].setActive(true);
                }
            }
            break;

            case 4:
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Devastate"){
                    temp[i].setActive(true);
                }
                if(temp[i].getName()=="Toxicity"){
                    temp[i].setActive(true);
                }
            }
            break;

            case 5:
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Berserk"){
                    temp[i].setActive(true);
                }
            }
            break;

            case 6:
                for(int i=0; i<getMaxNumAbilities(); i++){
                    if(temp[i].getName()=="Psi Blast"){
                        temp[i].setActive(true);
                    }
                }
                break;

            case 7:
                for(int i=0; i<getMaxNumAbilities(); i++){
                    if(temp[i].getName()=="Regenerate"){
                        temp[i].setActive(true);
                    }
                    if(temp[i].getName()=="Dual Strike"){
                        temp[i].setActive(true);
                    }
                }
                break;

            case 8:
                for(int i=0; i<getMaxNumAbilities(); i++){
                    if(temp[i].getName()=="Iron Fist"){
                        temp[i].setActive(true);
                    }
                }
                break;

            case 9:
                for(int i=0; i<getMaxNumAbilities(); i++){
                    if(temp[i].getName()=="Heroism"){
                        temp[i].setActive(true);
                    }
                }
                break;

            case 10:
                for(int i=0; i<getMaxNumAbilities(); i++){
                    if(temp[i].getName()=="Armageddon"){
                        temp[i].setActive(true);
                    }
                }
                break;

        }
        setNumOfAbilities();
        setAbilities(temp);
        sortAbilities();
    }

    public void levelUp(){
        setLevel(getLevel() + 1);
        setAttack(getAttack() + (int)(Math.random()*3));
        setStrength(getStrength() + (int)(Math.random()*2));
        setSpeed(getSpeed() + (int)(Math.random()*3));
        setLuck(getLuck() +  (int)(Math.random()*2));
        setMaxHP((getMaxHP() + (int)(Math.random()*11))+35);
        unlockAbility();
        setCurrentHP(this.getMaxHP());
    }

    public boolean checkLevelUp(){
        if(XPToNextLevel<=XPTotal){
            levelUp();
            // Comment to make a dud commit, making sure I didn't break everything
            XPTotal-=XPToNextLevel;
            XPToNextLevel=getLevel()*getLevel()*150;
            checkLevelUp();
            return true;
        } else {
            return false;
        }
    }

    public void resetBonuses(){
        setEnergy(0);
        setAttackBonus(0);
        setStrengthBonus(0);
        setSpeedBonus(0);
        setLuckBonus(0);
        setDefenseBonus(0);

    }

    public boolean winBattle(Monster enemy){
        XPTotal+=enemy.getXPGain();
        gpTotal+=enemy.randomGold();
        currentQuest.updateKillQuest(enemy,currentMapLocation,this);
        resetBonuses();
        if(checkLevelUp()){
            return true;
        } else {
            return false;
        }

    }

    /////////////////////////////////
    ///
    ///  Quest Tool Bar
    ///
    ////////////////////////////////

    private Quest currentQuest;
    private boolean inConvo;
    private int questStage;


    public boolean getCollectableState(int index) { return currentQuest.getCollectableState()[index];}

    public void setCollectableState(int index,boolean change){currentQuest.setCollectableState(change,index);}

    public int getCollectableNum(){return currentQuest.getNumOfCollectables();}

    public void setCollectableNum(int num) {
        currentQuest.setNumOfCollectables(num);
        if (currentQuest.getNumOfCollectables() == currentQuest.getTotalCollectables()) {
            if(questStage == 10) {
                currentQuest.setState(Quest.questState.completedQuest);
            }else if(questStage == 13){
                currentQuest.setState(Quest.questState.inQuest);
            }else if(questStage == 17){
                currentQuest.setState(Quest.questState.inQuest);
            }else if(questStage == 23){
                currentQuest.setState(Quest.questState.completedQuest);
            }
            setQuestStage(getQuestStage() + 1);
        }
    }


    public int getQuestStage() {
        return questStage;
    }

    public void setQuestStage(int questStage) {
        this.questStage = questStage;
    }

    public boolean isInConvo() {
        return inConvo;
    }

    public void setInConvo(boolean inConvo) {
        this.inConvo = inConvo;
    }

    public void changeQuest(){
        switch(questStage){
            case 1:
                currentQuest = new quest_AWizardsProblem();
                currentQuest.setState(Quest.questState.preQuest);
                break;
            case 2:
                currentQuest.setState(Quest.questState.inQuest);
                break;
            case 3:
                questStage = 3;
                break;
            case 4:
                currentQuest.giveReward(this);
                currentQuest = new quest_TheRoadToRiches();
                questStage = 5;
                break;
            case 6:
                setGpTotal(getGpTotal() - 500);
                currentQuest.setState(Quest.questState.inQuest);
                questStage = 7;
                break;
            case 8:


                currentQuest.giveReward(this);
                currentQuest = new quest_TheMissingPeices();
                questStage = 9;
                break;
            case 9:

                break;
            case 10:
                currentQuest.setState(Quest.questState.inQuest);
                break;
            case 12:
                currentQuest.giveReward(this);
                currentQuest = new quest_ASpyInTheClutches();
                questStage = 13;
                break;
            case 15:
                currentQuest.setState(Quest.questState.completedQuest);
                break;
            case 16:
                currentQuest.setState(Quest.questState.extraQuest);
                break;
            case 17:
                currentQuest.giveReward(this);
                currentQuest = new quest_NoEscapeFromReality();
                questStage = 18;
                break;
            case 20:
                currentQuest.setState(Quest.questState.completedQuest);
                break;
            case 22:
                currentQuest.setState(Quest.questState.extraQuest);
                break;
            case 23:
                currentQuest.giveReward(this);
                currentQuest = new quest_AWanderingSoul();
                questStage = 24;
                break;
            case 25:
                currentQuest.setState(Quest.questState.inQuest);
                break;
            case 28:
                currentQuest.setState(Quest.questState.extraQuest);
                break;
            case 29:
                currentQuest.giveReward(this);
                currentQuest = new quest_OneLastThing();
                questStage = 30;
                break;
            case 31:
                break;
            case 32:
                break;



        }


    }

    public boolean updateQuestReward(double dt){
        return currentQuest.updateRewardDisplay(dt);
    }



    public Quest getCurrentQuest(){
        return currentQuest;
    }

    public void setCurrentQuest(Quest currentQuest) {
        this.currentQuest = currentQuest;
    }

    public Quest.questState getCurrentQuestState(){
        return currentQuest.getState();
    }

    public String getCurrentQuestName(){
        return currentQuest.getQuestName();
    }


    public void setQuestState(Quest.questState newstate){
        currentQuest.setState(newstate);
    }







    //////////////////////////////
    ///
    ///  Boss Kill And Monsters
    ///
    //////////////////////////////

    private int monsterGen;

    private boolean ValliardAlive = true;

    public boolean isValliardAlive() {
        return ValliardAlive;
    }

    public void setValliardAlive(boolean valliardAlive) {
        ValliardAlive = valliardAlive;
    }


    public int getMonsterGen() {
        return monsterGen;
    }

    public void setMonsterGen(int monsterGen) {
        this.monsterGen = monsterGen;
    }


    //////////////////////////////
    ///
    ///  Shop
    ///
    //////////////////////////////

    int currentShopActive = 0;

    public int getCurrentShopActive() {
        return currentShopActive;
    }

    public void setCurrentShopActive(int currentShopActive) {
        this.currentShopActive = currentShopActive;
    }
}

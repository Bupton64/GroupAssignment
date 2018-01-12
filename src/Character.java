import java.awt.*;

public class Character extends Statblock {

    public int questNum = 1;    //<Keeps track of what section of the quest the player is currently on.

    public int getQuestNum() {
        return questNum;
    }



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
            if(inventory[i]==newItem){
                return i;
            }
        }
        return -1;
    }

    public boolean alreadyHoldsItem(Item newItem){
        for(int i=0; i<maxInventorySize; i++){
            if(inventory[i]==newItem){
                return true;
            }
        }
        return false;
    }

    public void addItemToInventory(Item newItem){
        if(alreadyHoldsItem(newItem)){
            int index=findItemIndex(newItem);
            inventory[index].setCounter(inventory[index].getCounter()+1);
            return;
        }
        for(int i=0; i<maxInventorySize; i++) {
            if (inventory[i].getSlot() == null) {
                inventory[i] = newItem;
                return;
            }
        }
        sortInventory();
    }

    public void equipItem(Item newItem){
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
        currentQuest = new quest_blankQuest();

        // Memory initialisation

        Ability [] temp = new Ability[20];
        for(int i=0; i<20; i++){
            temp[i] = new Ability();
            temp[i].setActive(false);
        }
        inventory = new Item [100];
        for(int i=0; i<100; i++){
            inventory[i] = new Item();
        }
        equippedItems = new Item [6];
        for(int i=0; i<6; i++){
            equippedItems[i] = new Item();
        }

        setMaxInventorySize(50);

        //< Set up starting Inventory

        item_Equipment rusty = new item_Equipment("Rusty Sword", 1, 0, 0, 0, 0, Item.Slot.weapon, "An old warriors sword");
        addItemToInventory(rusty);
        equipItem(rusty);

        item_Equipment ragged = new item_Equipment("Ragged Cap", 0, 0, 0, 0, 0, Item.Slot.head, "Stitched leather");
        addItemToInventory(ragged);
        equipItem(ragged);

        item_Equipment buckler = new item_Equipment("Worn Buckler", 0, 1, 0, 0, 0, Item.Slot.offhand, "A small buckler that straps to the arm");
        addItemToInventory(buckler);
        equipItem(buckler);

        item_Equipment clothShoes = new item_Equipment("Cloth Shoes", 0, 0, 0, 0, 0, Item.Slot.feet, "A comfy pair of wraps");
        addItemToInventory(clothShoes);
        equipItem(clothShoes);

        item_Equipment leatherJack = new item_Equipment("Leather Jack", 0, 1, 0, 0, 0, Item.Slot.chest, "A sturdy chest piece");
        addItemToInventory(leatherJack);
        equipItem(leatherJack);

        item_Equipment ironSword = new item_Equipment("Iron Sword", 2, 0, 0, 0, 0, Item.Slot.weapon, "A well forged sword");
        addItemToInventory(ironSword);

        item_SpeedPotion speed = new item_SpeedPotion();
        addItemToInventory(speed);

        item_Potion pot = new item_Potion();
        addItemToInventory(pot);
        addItemToInventory(pot);
        addItemToInventory(pot);

        //< Check inventory
        /*
        for(int i=0; i<maxInventorySize; i++){
            System.out.println(inventory[i].getName());
        }
        */
        //< Set up initial Stats

        combatActive = false;
        setAttack(5);
        setDefense(3);
        setLuck(3);
        setSpeed(3);
        setStrength(3);
        setXPTotal(0);
        setXPToNextLevel(500);
        setGpTotal(50);
        setCurrentHP(40);
        setMaxHP(40);
        setLevel(1);
        setAlive(true);
        setName("Zarxas");
        setEnergy(0);

        //< Set up the ability list (Needs all abilities, check unlockAbility to make sure character gains access)

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
        this.setAbilities(temp);
        setNumOfAbilities();
        sortAbilities();

        //< Load the characters combat sprite

        Image sprite = loadImage("combatCharacter.png");
        setSprite(sprite);
        setSpriteWidth(150);
        setSpriteHeight(150);

        // Test Functions
        //setXPTotal(500); //< TESTERS
        //checkLevelUp(); //< Tester
    }

    public void unlockAbility(){
        Ability [] temp = new Ability[20];
        for(int i=0; i<20; i++){
            temp[i]=new Ability();
        }
        temp=getAbilities();
        if(getLevel()==2){
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Spark"){
                    temp[i].setActive(true);
                }
            }
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Heal"){
                    temp[i].setActive(true);
                }
            }
        }
        if(getLevel()==3){
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Blade Dance"){
                    temp[i].setActive(true);
                }
            }
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Berserk"){
                    temp[i].setActive(true);
                }
            }
        }
        if(getLevel()==4){
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Dual Strike"){
                    temp[i].setActive(true);
                }
            }
        }
        if(getLevel()==5){
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Armageddon"){
                    temp[i].setActive(true);
                }
            }
        }
        if(getLevel()==6){
            for(int i=0; i<getMaxNumAbilities(); i++){
                if(temp[i].getName()=="Smash"){
                    temp[i].setActive(true);
                }
            }
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
        setMaxHP(getMaxHP() + (int)(Math.random()*11));
        unlockAbility();
        setCurrentHP(this.getMaxHP());
    }

    public boolean checkLevelUp(){
        if(XPToNextLevel<=XPTotal){
            levelUp();
            XPTotal-=XPToNextLevel;
            XPToNextLevel=getLevel()*getLevel()*150;
            checkLevelUp();
            return true;
        } else {
            return false;
        }
    }

    public boolean winBattle(Monster enemy){
        XPTotal+=enemy.getXPGain();
        gpTotal+=enemy.randomGold();
        currentQuest.updateQuest(enemy,currentMapLocation);
        resetBonuses();
        if(checkLevelUp()){
            return true;
        } else {
            return false;
        }

    }

    private Quest currentQuest;

    enum QuestState {QuestZero,QuestOne,QuestTwo}
    QuestState questState = QuestState.QuestZero;

    public QuestState getQuestState() {
        return questState;
    }

    public void setQuestState(QuestState questState) {
        this.questState = questState;
    }

    public void changeQuest(int swapTo){
        switch(swapTo){
            case 1:
                questState = QuestState.QuestOne;
                currentQuest = new quest_killingForWizard();
                break;
            case 2:
                questState = QuestState.QuestTwo;
                break;
        }


    }


    public Quest getCurrentQuest(){
        return currentQuest;
    }

}

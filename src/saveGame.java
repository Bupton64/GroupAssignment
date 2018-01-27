
import java.io.*;


public class saveGame {

    Character playerMan;

    saveGame(Character player){
        this.playerMan = player;
    }

    public void save() {
        PrintWriter pw = null;
        try {

            File file = new File("fubars.txt");
            file.delete();
            FileWriter fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);



            //StatBlock Save
            pw.println("#######################");
            pw.println("###");
            pw.println("###  StatBlock");
            pw.println("###");
            pw.println("#######################");
            pw.println(playerMan.getAttack());
            pw.println(playerMan.getDefense());
            pw.println(playerMan.getStrength());
            pw.println(playerMan.getLuck());
            pw.println(playerMan.getSpeed());
            pw.println(playerMan.getMaxHP());
            pw.println(playerMan.getCurrentHP());
            pw.println(playerMan.getLevel());



            //Character Save
            pw.println("#######################");
            pw.println("###");
            pw.println("###  Character");
            pw.println("###");
            pw.println("#######################");
            pw.println(playerMan.getXPTotal());
            pw.println(playerMan.getXPToNextLevel());
            pw.println(playerMan.getGpTotal());
            pw.println(playerMan.getMapPosX());
            pw.println(playerMan.getMapPosY());
            pw.println(playerMan.getCurrentMapLocation());
            pw.println(playerMan.getMaxInventorySize());


            //Quest Save
            pw.println("#######################");
            pw.println("###");
            pw.println("###  Quests");
            pw.println("###");
            pw.println("#######################");
            pw.println(playerMan.getQuestStage());
            pw.println(playerMan.getCurrentQuest().getQuestName());
            pw.println(playerMan.getCurrentQuest().getKillCount());
            pw.println(playerMan.getCurrentQuest().getTotalCollectables());
            pw.println(playerMan.getCurrentQuest().getNumOfCollectables());
            for(int i = 0; i < playerMan.getCurrentQuest().getTotalCollectables(); i++ ){
                pw.println(playerMan.getCurrentQuest().getCollectableState()[i]);
            }
            //Bosses
            pw.println(playerMan.isValliardAlive());


            //Items
            pw.println("#######################");
            pw.println("###");
            pw.println("###  Items");
            pw.println("###");
            pw.println("#######################");
            pw.println(playerMan.getInventorySize());
            for(int i = 0; i < playerMan.getInventorySize();i++){
                pw.println(playerMan.getInventory()[i].getName());
                pw.println(playerMan.getInventory()[i].getCounter());
            }
            pw.println("#######################");
            pw.println("###");
            pw.println("###  Equipped Items");
            pw.println("###");
            pw.println("#######################");
            for(int i = 0; i < playerMan.getEquipmentSize();i++){
                pw.println(playerMan.getEquippedItems()[i].getName());
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }



    public Character loadGame() {
        Character temp = new Character();
        try (BufferedReader br = new BufferedReader(new FileReader("fubars.txt"))) {
            String line = br.readLine();

            line = br.readLine();
            while (line.charAt(0) == '#') {
                line = br.readLine();
            }
            //StatBlock
//            pw.println(playerMan.getAttack());
//            pw.println(playerMan.getDefense());
//            pw.println(playerMan.getStrength());
//            pw.println(playerMan.getLuck());
//            pw.println(playerMan.getSpeed());
//            pw.println(playerMan.getMaxHP());
//            pw.println(playerMan.getCurrentHP());
//            pw.println(playerMan.getLevel());
            temp.setAttack(Integer.parseInt(line));
            line = br.readLine();
            temp.setDefense(Integer.parseInt(line));
            line = br.readLine();
            temp.setStrength(Integer.parseInt(line));
            line = br.readLine();
            temp.setLuck(Integer.parseInt(line));
            line = br.readLine();
            temp.setSpeed(Integer.parseInt(line));
            line = br.readLine();
            temp.setMaxHP(Integer.parseInt(line));
            line = br.readLine();
            temp.setCurrentHP(Integer.parseInt(line));
            line = br.readLine();
            temp.setLevel(Integer.parseInt(line));
            line = br.readLine();
            while (line.charAt(0) == '#') {
                line = br.readLine();
            }
            //Character
//            pw.println(playerMan.getXPTotal());
////            pw.println(playerMan.getXPToNextLevel());
////            pw.println(playerMan.getGpTotal());
////            pw.println(playerMan.getMapPosX());
////            pw.println(playerMan.getMapPosY());
////            pw.println(playerMan.getCurrentMapLocation());
////            pw.println(playerMan.getMaxInventorySize());
            temp.setXPTotal(Integer.parseInt(line));
            line = br.readLine();
            temp.setXPToNextLevel(Integer.parseInt(line));
            line = br.readLine();
            temp.setGpTotal(Integer.parseInt(line));
            line = br.readLine();
            temp.setMapPosX(Integer.parseInt(line));
            line = br.readLine();
            temp.setMapPosY(Integer.parseInt(line));
            line = br.readLine();
            temp.setCurrentMapLocation(Integer.parseInt(line));
            line = br.readLine();
            temp.setMaxInventorySize(Integer.parseInt(line));
            line = br.readLine();
            while (line.charAt(0) == '#') {
                line = br.readLine();
            }
            //Quests

//            pw.println(playerMan.getQuestStage());
//            pw.println(playerMan.getCurrentQuest().getQuestName());
//            pw.println(playerMan.getCurrentQuest().getKillCount());
//            pw.println(playerMan.getCurrentQuest().getTotalCollectables());
//            pw.println(playerMan.getCurrentQuest().getNumOfCollectables());
//            for(int i = 0; i < playerMan.getCurrentQuest().getTotalCollectables(); i++ ){
//                pw.println(playerMan.getCurrentQuest().getCollectableState()[i]);
//            }
//          Bosses
//            pw.println(playerMan.isValliardAlive());
            temp.setQuestStage(Integer.parseInt(line));
            line = br.readLine();
            if (line == "empty") {
                temp.setCurrentQuest(new quest_blankQuest());
            } else if (line == "A Wizards Problem") {
                temp.setCurrentQuest(new quest_AWizardsProblem());
            } else if (line == "The Road To Riches") {
                temp.setCurrentQuest(new quest_TheRoadToRiches());
            } else if (line == "The Missing Peices") {
                temp.setCurrentQuest(new quest_TheMissingPeices());
            } else if (line == "A Spy In The Clutches") {
                temp.setCurrentQuest(new quest_ASpyInTheClutches());
            } else if (line == "No Escape From Reality") {
                temp.setCurrentQuest(new quest_NoEscapeFromReality());
            } else if (line == "A Wandering Soul") {
                temp.setCurrentQuest(new quest_AWanderingSoul());
            } else if (line == "One Last Thing") {
                temp.setCurrentQuest(new quest_OneLastThing());
            }
            temp.getCurrentQuest().setKillCount(Integer.parseInt(line));
            line = br.readLine();
            temp.getCurrentQuest().setTotalCollectables(Integer.parseInt(line));
            line = br.readLine();
            temp.getCurrentQuest().setNumOfCollectables(Integer.parseInt(line));
            for (int i = 0; i < temp.getCurrentQuest().getTotalCollectables(); i++) {
                line = br.readLine();
                temp.getCurrentQuest().setCollectableState(Boolean.parseBoolean(line), i);
            }
            line = br.readLine();
            temp.setValliardAlive(Boolean.parseBoolean(line));


            line = br.readLine();
            while (line.charAt(0) == '#') {
                line = br.readLine();
            }
            //Items
//            pw.println(playerMan.getInventorySize());
//            for(int i = 0; i < playerMan.getInventorySize();i++){
//                pw.println(playerMan.getInventory()[i].getName());
//                pw.println(playerMan.getInventory()[i].getCounter());
//            }

            int inventorySize = Integer.parseInt(line);

            for(int j = 0; j < inventorySize;j++){
                line = br.readLine();
                loadItem(line,temp);

            }


            temp.setMapPosY(Integer.parseInt(line));




        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }


    public void loadItem(String name,Character temp){
        if(name == "Rusty Sword"){
            item_Equipment rusty = new item_Equipment("Rusty Sword", 1, 0, 0, 0, 0, Item.Slot.weapon, "An old warriors sword", 10, 0);
            temp.addItemToInventory(rusty); // T0 Sword
        }else if(name == "Bronze Sword"){
            item_Equipment bronzeSword = new item_Equipment("Bronze Sword", 1, 0, 0, 0, 1, Item.Slot.weapon, "Durable and strong", 50, 300);
            temp.addItemToInventory(bronzeSword); //T1 Sword
        }else if(name == "Stone Axe"){
            item_Equipment stone = new item_Equipment("Stone Axe", 0, 0, 0, 0, 1, Item.Slot.weapon, "Rugged, yet effective", 300, 400);
            temp.addItemToInventory(stone); //T1 Axe
        }else if(name == "Monk's Staff"){
            item_Equipment monksStaff = new item_Equipment("Monk's Staff", 1, 0, 0, 2, 0, Item.Slot.weapon, "A light wooden staff", 300, 1000);
            temp.addItemToInventory(monksStaff); //T2 Staff
        }else if(name == "Rough Axe"){
            item_Equipment rough = new item_Equipment("Rough Axe", 0, 0, 0, 0, 2, Item.Slot.weapon, "A violent edge and little else", 3300, 1200);
            temp.addItemToInventory(rough); //T2 Axe
        }else if(name == "Guardsman's Spear"){
            item_Equipment spear = new item_Equipment("Guardsman's Spear", 1, 0, 1, 0, 0, Item.Slot.weapon, "A military issue spear", 290, 1100);
            temp.addItemToInventory(spear); //T2 Spear
        }else if(name == "Iron Sword"){
            item_Equipment ironSword = new item_Equipment("Iron Sword", 4, 0, 0, 0, 2, Item.Slot.weapon, "A well forged sword", 600, 2300);
            temp.addItemToInventory(ironSword); //T3 Sword
        }else if(name == "Trickster's Spear"){
            item_Equipment trickspear = new item_Equipment("Trickster's Spear", 2, 0, 3, 0, 0, Item.Slot.weapon, "Expertly balanced spear", 590, 2250);
            temp.addItemToInventory(trickspear); //T3 Spear
        }else if(name == "Acolyte's Staff"){
            item_Equipment acolyte = new item_Equipment("Acolyte's Staff", 2, 0, 0, 5, 0, Item.Slot.weapon, "Crafted from enchanted willow", 620, 2090);
            temp.addItemToInventory(acolyte); //T3 Staff
        }else if(name == "Steel Sword"){
            item_Equipment steelSword = new item_Equipment("Steel Sword", 8, 0, 0, 0, 4, Item.Slot.weapon, "Grace and power combined", 1300, 4500);
            temp.addItemToInventory(steelSword); //T4 Sword
        }else if(name == "Gladiator's Axe"){
            item_Equipment gladiator = new item_Equipment("Gladiator's Axe", 8, 0, 0, 0, 8, Item.Slot.weapon, "Keen edged and lethal", 1450, 5200);
            temp.addItemToInventory(gladiator); //T4 Axe
        }else if(name == "Jester's Staff"){
            item_Equipment jester = new item_Equipment("Jester's Staff", 4, 0, 0, 10, 0, Item.Slot.weapon, "Lighter than air itself", 1250, 4800);
            temp.addItemToInventory(jester); //T4 Staff
        }else if(name == "Emperor's Word"){
            item_Equipment emperor = new item_Equipment("Emperor's Word", 4, 0, 6, 0, 0, Item.Slot.weapon, "His voice pierces hearts", 1400, 4950);
            temp.addItemToInventory(emperor); //T4 Spear
        }else if(name == "Valkyrie"){
            item_Equipment valkyrie = new item_Equipment("Valkyrie", 10, 10, 4, 0, 8, Item.Slot.weapon, "A legend made reality", 0, 0);
            temp.addItemToInventory(valkyrie); //Endgame Sword
        }

    }



    equipItem(rusty);



    














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


}

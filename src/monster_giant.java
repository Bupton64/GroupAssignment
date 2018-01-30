import java.awt.*;

public class monster_giant extends Monster {

    public monster_giant() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[2];
        for (int i = 0; i < 2; i++) {
            temp[i] = new Ability();
        }
        setAttack(20);
        setDefense(6);
        setLuck(0);
        setSpeed(10);
        setStrength(20);
        setXPGain(1560);
        setGoldMin(480);
        setGoldMax(700);
        setCurrentHP(400);
        setMaxHP(400);
        setLevel(8);
        setAlive(true);
        setName("Giant");
        setEnergy(0);
        temp[0] = new ability_monster_chargeUp();
        setUpAbilityNumberI(temp, 1, "Hammer Down!", 0, 0, 0, 0, 0, false, 5, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);

        Image sprite = loadImage("monster_giant.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >97){
            newItem = new item_Equipment("Acolyte's Staff", 2, 0, 0, 5, 0, Item.Slot.weapon, "Crafted from enchanted willow", 620, 2090);
        } else if (num >94) {
            newItem = new item_Equipment("Guardsman's Spear", 1, 0, 1, 0, 0, Item.Slot.weapon, "A military issue spear", 290, 1100);
        } else if (num >90){
            newItem = new item_Equipment("Monk's Staff", 1, 0, 0, 2, 0, Item.Slot.weapon, "A light wooden staff", 300, 1000);
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getEnergy() == 5){
            return abilities[1]; //< Use Hammer Down
        } else{
            return abilities[0]; //< Use Charge Up
        }
    }

}

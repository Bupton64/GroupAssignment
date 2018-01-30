import java.awt.*;

public class monster_vampire extends Monster {

    public monster_vampire() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = new Ability();
        }
        setAttack(23);
        setDefense(6);
        setLuck(2);
        setSpeed(35);
        setStrength(5);
        setXPGain(1970);
        setGoldMin(800);
        setGoldMax(1020);
        setCurrentHP(600);
        setMaxHP(600);
        setLevel(10);
        setAlive(true);
        setName("Vampire");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Fang", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Swooping Strike", 0, 10, 0, 0, 0, false, 2, "", true, Ability.AbilityType.damage, "");
        temp[2] = new ability_monster_lifeCoil();
        temp[2].setName("Vampiric Bite");
        this.setAbilities(temp);

        Image sprite = loadImage("monster_vampire.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_Equipment("Breastplate", 0, 4, 0, 2, 0, Item.Slot.chest, "Solid and sure", 1080, 2700);
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();

        if(this.getCurrentHP() > this.getMaxHP()*0.8){
            if(this.getEnergy() > 1){
                if(num > 30){
                    return abilities[1]; //< Swooping Strike
                } else {
                    return abilities[0]; //< Fang
                }
            } else{
                return abilities[0]; //< Fang
            }
        } else if(this.getCurrentHP() > this.getMaxHP() * 0.3){
            if(num > 70){
                return abilities[1]; //< Swooping Strike
            } else {
                return abilities[0]; //< Fang
            }
        } else{
            if(this.getEnergy() > 3){
                return abilities[2]; //< Vampiric Bite
            } else{
                return abilities[0]; //< Fang
            }
        }
    }

}

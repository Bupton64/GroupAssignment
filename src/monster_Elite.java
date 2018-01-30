import java.awt.*;

public class monster_Elite extends Monster {

    public monster_Elite() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = new Ability();
        }
        setAttack(15);
        setDefense(0);
        setLuck(10);
        setSpeed(20);
        setStrength(8);
        setXPGain(1720);
        setGoldMin(640);
        setGoldMax(980);
        setCurrentHP(500);
        setMaxHP(500);
        setLevel(9);
        setAlive(true);
        setName("Elite");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Slice", 2, 0, 0, 0, 1, false, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Faint Strike", 0, 2, 2, 2, 2, false, 2, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Flurry", 0, 4, 0, 5, 4, false, 5, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);

        Image sprite = loadImage("monster_elite.png");
        setSprite(sprite);
        setSpriteWidth(150);
        setSpriteHeight(150);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >50){
            newItem = new item_megaPotion();
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getCurrentHP() > this.getMaxHP()*0.6){
            if(this.getEnergy() > 1){
                if(num > 70){
                    return abilities[1]; //< Faint Strike
                } else {
                    return abilities[0]; //< Slice
                }
            } else {
                return abilities[0]; //< Slice
            }
        } else{
            if(this.getEnergy() > 4){
                if(num > 40){
                    return abilities[2]; //< Flurry
                } else {
                    return abilities[1]; //< Faint Strike
                }
            } else if (this.getEnergy() > 1) {
                if(num > 40) {
                    return abilities[1]; //< Faint Strike
                } else{
                    return abilities[0]; //< Slice
                }
            } else {
                return abilities[0]; //< Slice
            }
        }
    }

}

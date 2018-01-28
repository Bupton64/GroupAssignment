import java.awt.*;

public class monster_brawler extends Monster{

    public void init() {
        Ability[] temp;
        temp = new Ability[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = new Ability();
        }
        setAttack(3);
        setDefense(0);
        setLuck(2);
        setSpeed(10);
        setStrength(4);
        setXPGain(450);
        setGoldMin(220);
        setGoldMax(260);
        setCurrentHP(220);
        setMaxHP(220);
        setLevel(4);
        setAlive(true);
        setName("Brawler");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Punch", 2, -2, 0, 0, -1, false, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Grapple", 0, 2, 2, 2, 2, false, 2, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Haymaker", 0, 4, 0, 5, 4, false, 5, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);

        //Image sprite = loadImage("monster_theroxVanguard.png");
        Image sprite = loadImage("monster_brawler.png");
        setSprite(sprite);
        setSpriteWidth(150);
        setSpriteHeight(150);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_Equipment("Scale Mail", 0, 2, 0, 2, 0, Item.Slot.chest, "A sturdy chestpiece", 390, 1040);

        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getCurrentHP() > this.getMaxHP()*0.4){
            if(this.getEnergy() > 1){
                if(num > 60){
                    return abilities[1].use(this); //< Grapple
                } else {
                    return abilities[0].use(this); //< Two Handed Smash
                }
            } else {
                return abilities[0].use(this); //< Two Handed Smash
            }
        } else{
            if(this.getEnergy() > 4){
                if(num > 70){
                    return abilities[2].use(this); //< Whirling Axes
                } else {
                    return abilities[1].use(this); //< Cleave
                }
            } else if (this.getEnergy() > 1) {
                if(num > 50) {
                    return abilities[1].use(this); //< Cleave
                } else{
                    return abilities[0].use(this); //< Two Handed Smash
                }
            } else {
                return abilities[0].use(this); //< Two Handed Smash
            }
        }
    }

}

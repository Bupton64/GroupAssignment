import java.awt.*;

public class monster_Vanguard extends Monster{

    public monster_Vanguard() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = new Ability();
        }
        setAttack(6);
        setDefense(0);
        setLuck(4);
        setSpeed(16);
        setStrength(4);
        setXPGain(900);
        setGoldMin(190);
        setGoldMax(230);
        setCurrentHP(250);
        setMaxHP(250);
        setLevel(5);
        setAlive(true);
        setName("Vanguard");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Smash", 2, 0, 0, 0, 1, false, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Cleave", 0, 2, 2, 2, 2, false, 2, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Whirling Axes", 0, 4, 0, 5, 4, false, 5, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);

        Image sprite = loadImage("monster_theroxVanguard.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_soulStone();
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getCurrentHP() > this.getMaxHP()*0.6){
            if(this.getEnergy() > 1){
                if(num > 70){
                    return abilities[1].use(this); //< Cleave
                } else {
                    return abilities[0].use(this); //< Two Handed Smash
                }
            } else {
                return abilities[0].use(this); //< Two Handed Smash
            }
        } else{
            if(this.getEnergy() > 4){
                if(num > 40){
                    return abilities[2].use(this); //< Whirling Axes
                } else {
                    return abilities[1].use(this); //< Cleave
                }
            } else if (this.getEnergy() > 1) {
                if(num > 40) {
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

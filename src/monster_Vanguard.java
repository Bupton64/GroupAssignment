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
        setAttack(13);
        setDefense(6);
        setLuck(4);
        setSpeed(14);
        setStrength(4);
        setXPGain(900);
        setGoldMin(190);
        setGoldMax(230);
        setCurrentHP(250);
        setMaxHP(250);
        setLevel(5);
        setAlive(true);
        setName("Therox's Vanguard");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Two Handed Smash", 2, 0, 0, 0, 1, false, -1, "", true, Ability.AbilityType.damage, "");
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
        return abilities[1].use(this);
        /*if(getCurrentHP()>getMaxHP()*0.5){
            if(getEnergy()>1){
                if(num>70){
                    return abilities[1].use(this); //< Use Snowblast
                } else if(num>50){
                    return abilities[3].use(this); //< Use Blinding Light
                } else {
                    return abilities[0].use(this); //< Use Freezing Ray
                }
            }  else{
                return abilities[0].use(this); //< Use Freezing Ray
            }
        } else{
            if(getEnergy()>4){
                if(num>30) {
                    return abilities[2].use(this); //< Use Ice Storm
                } else {
                    return abilities[3].use(this); //< Use Blinding Light
                }
            } else if(getEnergy()>1){
                if(num>50){
                    return abilities[1].use(this); //< Use Snowblast
                } else{
                    return abilities[0].use(this); //< Use Freezing Ray
                }
            } else{
                return abilities[0].use(this); //< Use Freezing Ray
            }
        }*/
    }

}

import java.awt.*;

public class monster_Witch extends Monster {

    public monster_Witch() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[4];
        for (int i = 0; i < 4; i++) {
            temp[i] = new Ability();
        }
        setAttack(6);
        setDefense(4);
        setLuck(0);
        setSpeed(0);
        setStrength(2);
        setXPGain(450);
        setGoldMin(160);
        setGoldMax(190);
        setCurrentHP(150);
        setMaxHP(150);
        setLevel(3);
        setAlive(true);
        setName("Witch");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Freezing Ray", 5, 1, 1, 1, 1, true, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Snowblast", 0, 2, 2, 0, 2, true, 2, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Ice Storm", 0, 4, 0, 0, 4, true, 5, "", true, Ability.AbilityType.damage, "");
        temp[3] = new ability_monster_blindingLight();
        this.setAbilities(temp);

        Image sprite = loadImage("Image/monster_Witch.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_wisdomStone();
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(getCurrentHP()>getMaxHP()*0.5){
            if(getEnergy()>1){
                if(num>70){
                    return abilities[1]; //< Use Snowblast
                } else if(num>50){
                    return abilities[3]; //< Use Blinding Light
                } else {
                    return abilities[0]; //< Use Freezing Ray
                }
            }  else{
                return abilities[0]; //< Use Freezing Ray
            }
        } else{
            if(getEnergy()>4){
                if(num>30) {
                    return abilities[2]; //< Use Ice Storm
                } else if ( num > 10) {
                    return abilities[3]; //< Use Blinding Light
                } else {
                    return abilities[0]; //< Use Freezing Ray
                }
            } else if(getEnergy()>1){
                if(num>50){
                    return abilities[1]; //< Use Snowblast
                } else{
                    return abilities[0]; //< Use Freezing Ray
                }
            } else{
                return abilities[0]; //< Use Freezing Ray
            }
        }
    }
}
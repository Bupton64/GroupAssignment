import java.awt.*;

public class monster_BOSS_Valliard extends Monster {
    public monster_BOSS_Valliard(){this.init();}

    public void init(){
        Ability [] temp;
        temp= new Ability[5];
        for(int i=0; i<5; i++){
            temp[i]=new Ability();
        }
        setAttack(6);
        setDefense(5);
        setLuck(0);
        setSpeed(7);
        setStrength(2);
        setXPGain(900);
        setGoldMin(400);
        setGoldMax(550);
        setCurrentHP(500);
        setMaxHP(500);
        setLevel(5);
        setAlive(true);
        setName("Valliard");
        setEnergy(0);

        Image sprite = loadImage("monster_BOSS_valliard.png"); //NEEDS IMAGE
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);

        // NEEDS ABILITIES
        setUpAbilityNumberI(temp, 0, "Judgment", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        temp[1] =  new ability_monster_lifeCoil();
        temp[2] = new ability_monster_rabidFang();
        temp[3] = new ability_Berserk();
        temp[3].setDisplayString("Valliard's rage overflows!");
        temp[4] = new ability_BladeDance();

        this.setAbilities(temp);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        return newItem;
    }

    @Override
    public Ability moveChoice() {
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getCurrentHP() > this.getMaxHP()*0.7){
            if(this.getEnergy() > 2){
                if(num > 60){
                    return abilities[3].use(this);
                } else if (num >20){
                    return abilities[4].use(this);
                } else if (num > 5){
                    return abilities[2].use(this);
                } else {
                    return abilities[0].use(this);
                }
            } else if (this.getEnergy() > 1){
                if (num > 20){
                    return abilities[2].use(this);
                } else {
                    return abilities[0].use(this);
                }
            } else {
                return abilities[0].use(this);
            }
        } else if (this.getCurrentHP() > this.getMaxHP()*0.4){
            if(this.getEnergy() > 3){
                if(num > 30){
                    return abilities[1].use(this);
                } else if (num >20){
                    return abilities[4].use(this);
                } else if (num > 10){
                    return abilities[2].use(this);
                } else {
                    return abilities[0].use(this);
                }
            } else if(this.getEnergy() > 2){
                if (num > 60){
                    return abilities[4].use(this);
                } else if (num > 30){
                    return abilities[2].use(this);
                } else {
                    return abilities[0].use(this);
                }
            } else if (this.getEnergy() > 1){
                if (num > 30){
                    return abilities[2].use(this);
                } else {
                    return abilities[0].use(this);
                }
            } else {
                return abilities[0].use(this);
            }
        } else{
            if(this.getEnergy() > 3){
                return abilities[1].use(this);
            } else if(this.getEnergy() > 2){
                return abilities[4].use(this);
            } else if (this.getEnergy() > 1){
                return abilities[2].use(this);
            } else {
                return abilities[0].use(this);
            }
        }

    }
}

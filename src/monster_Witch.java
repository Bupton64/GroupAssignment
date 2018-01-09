public class monster_Witch extends Monster {

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
        setXPGain(250);
        setGoldMin(130);
        setGoldMax(160);
        setCurrentHP(20);
        setMaxHP(20);
        setLevel(3);
        setAlive(true);
        setName("Witch");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Freezing Ray", 5, 1, 1, 1, 1, true, -1, "", true, Ability.AbilityType.damage);
        setUpAbilityNumberI(temp, 1, "Snowblast", 0, 2, 2, 0, 2, true, 2, "", true, Ability.AbilityType.damage);
        setUpAbilityNumberI(temp, 2, "Ice Storm", 0, 4, 0, 0, 4, true, 5, "", true, Ability.AbilityType.damage);
    }

    public Ability moveChoice(){
        int num=(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(getCurrentHP()>getMaxHP()*0.5){
            if(getEnergy()>1){
                if(num>70){
                    return abilities[1].use(this);
                } else {
                    return abilities[0].use(this);
                }
            }  else{
                return abilities[0].use(this);
            }
        } else{
            if(getEnergy()>4){
                return abilities[2].use(this);
            } else if(getEnergy()>1){
                if(num>50){
                    return abilities[1].use(this);
                } else{
                    return abilities[0].use(this);
                }
            } else{
                return abilities[0].use(this);
            }
        }
    }
}
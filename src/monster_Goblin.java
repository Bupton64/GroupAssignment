import java.awt.*;

public class monster_Goblin extends Monster {

    public monster_Goblin() {
        this.init();
    }

    public void init(){
        Ability [] temp;
        temp= new Ability[3];
        for(int i=0; i<3; i++){
            temp[i]=new Ability();
        }
        setAttack(3);
        setDefense(3);
        setLuck(3);
        setSpeed(3);
        setStrength(3);
        setXPGain(100);
        setGoldMin(40);
        setGoldMax(70);
        setCurrentHP(45);
        setMaxHP(45);
        setLevel(1);
        setAlive(true);
        setName("Goblin");
        setEnergy(0);

        Image sprite = loadImage("chara5.png");
        sprite = subImage(sprite, 520, 360, 56, 72);
        setSprite(sprite);
        setSpriteWidth(120);
        setSpriteHeight(142);

        setUpAbilityNumberI(temp, 0, "Bite", 0, 0, 0, 0, 0, false, -1,"", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Slash", 1, 1, -1, 0, 0, false, 1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Firestrike", 1, 1, 0, 0, 4, true, 3, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);
    }

    public Ability moveChoice(){
        int num=(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(getCurrentHP()>getMaxHP()*0.4){
            if(getEnergy()>2){
                if(num>70){
                    return abilities[2].use(this);
                } else if (num>35){
                    return abilities[1].use(this);
                } else {
                    return abilities[0].use(this);
                }
            } else if(getEnergy()>0){
                if(num>60){
                    return abilities[1].use(this);
                } else{
                    return abilities[0].use(this);
                }
            } else{
                return abilities[0].use(this);
            }
        } else{
            if(getEnergy()>2){
                if(num>40){
                    return abilities[2].use(this);
                } else {
                    return abilities[1].use(this);
                }
            } else if(getEnergy()>0){
                if(num>20){
                    return abilities[1].use(this);
                } else{
                    return abilities[0].use(this);
                }
            } else{
                return abilities[0].use(this);
            }
        }
    }

    @Override
    public Item dropLoot(){
        Item reward;
        int random = (int)(Math.random()*100);
        if(random>90){
            reward = new item_Potion();
        } else{
            reward = new Item();
        }
        return reward;
    }
}

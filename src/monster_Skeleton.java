import java.awt.*;

public class monster_Skeleton extends Monster {

    public monster_Skeleton() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = new Ability();
        }
        setAttack(15);
        setDefense(6);
        setLuck(4);
        setSpeed(14);
        setStrength(4);
        setXPGain(1210);
        setGoldMin(280);
        setGoldMax(320);
        setCurrentHP(250);
        setMaxHP(250);
        setLevel(6);
        setAlive(true);
        setName("Skeleton");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Skeletal Fist", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        temp[1] =  new ability_monster_witheringTouch();
        temp[2] = new ability_monster_sacrament();
        this.setAbilities(temp);

        Image sprite = loadImage("monster_skeleton.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_Antidote();
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

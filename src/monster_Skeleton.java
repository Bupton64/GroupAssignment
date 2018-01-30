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
        setGoldMin(310);
        setGoldMax(350);
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
        setSpriteWidth(150);
        setSpriteHeight(150);
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

        if(this.getCurrentHP() > this.getMaxHP() *0.6){
            if (this.getEnergy() > 1){
                if(num > 80){
                    return abilities[1]; //< Withering Touch
                } else {
                    return abilities[0]; //< Skeletal Fist
                }
            } else{
                return abilities[0]; //< Skeletal Fist
            }
        } else{
            if(this.getEnergy() > 4){
                if(num > 40) {
                    return abilities[2]; //< Sacrament
                } else {
                    return abilities[0]; //< Skeletal Fist
                }
            } else if (this.getEnergy() > 1){
                if(num > 70){
                    return abilities[1]; //< Withering Touch
                } else {
                    return abilities[0]; //< Skeletal Fist
                }
            } else {
                return abilities[0]; //< Skeletal Fist
            }
        }



    }

}

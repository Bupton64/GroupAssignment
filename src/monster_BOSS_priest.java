import java.awt.*;

public class monster_BOSS_priest extends Monster {
    public monster_BOSS_priest(){this.init();}

    public void init(){
        Ability [] temp;
        temp= new Ability[2];
        for(int i=0; i<2; i++){
            temp[i]=new Ability();
        }
        setAttack(1);
        setDefense(0);
        setLuck(0);
        setSpeed(0);
        setStrength(0);
        setXPGain(1);
        setGoldMin(1);
        setGoldMax(1);
        setCurrentHP(300);
        setMaxHP(300);
        setLevel(8);
        setAlive(true);
        setName("Priest");
        setEnergy(0);

        Image spriteSheet = loadImage("monster_priest.png");
        Image sprite = subImage(spriteSheet,364,72,56,72);
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);

        // NEEDS ABILITIES
        setUpAbilityNumberI(temp, 0, "Holy Glare", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        temp[1] =  new ability_monster_lifeCoil();


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
        if(this.getEnergy() > 2){
            return abilities[1];
        } else{
            return abilities[0];
        }
    }

}

import java.awt.*;

public class monster_BOSS_Valliard extends Monster {
    public monster_BOSS_Valliard(){this.init();}

    public void init(){
        Ability [] temp;
        temp= new Ability[3];
        for(int i=0; i<3; i++){
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
        setSpriteWidth(120);
        setSpriteHeight(120);

        // NEEDS ABILITIES
        setUpAbilityNumberI(temp, 0, "Hand of Judgment", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        temp[1] =  new ability_monster_lifeCoil();
        setUpAbilityNumberI(temp, 2, "Flame Thrust", 4, 2, 2, 2, 4, true, 2, "", true, Ability.AbilityType.damage, "");
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
        return null;
    }
}

import java.awt.*;

public class monster_BOSS_Therox extends Monster {

    public monster_BOSS_Therox(){this.init();}

    public void init(){
        Ability [] temp;
        temp= new Ability[10];
        for(int i=0; i<10; i++){
            temp[i]=new Ability();
        }
        setAttack(25);
        setDefense(10);
        setLuck(3);
        setSpeed(23);
        setStrength(10);
        setXPGain(10000);
        setGoldMin(0);
        setGoldMax(0);
        setCurrentHP(2000);
        setMaxHP(10000);
        setLevel(15);
        setAlive(true);
        setName("Therox");
        setEnergy(0);

        Image sprite = loadImage("monster_BOSS_therox.png");
        sprite = subImage(sprite, 0, 150, 100, 150);
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);

        // NEEDS ABILITIES
        setUpAbilityNumberI(temp, 0, "Hatred", 0, 0, 0, 0, 0, true, -1, "", true, Ability.AbilityType.damage, "");


        this.setAbilities(temp);
    }

}

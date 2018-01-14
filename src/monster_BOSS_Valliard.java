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

        Image sprite = loadImage("monster_Wolf.png"); //NEEDS IMAGE
        setSprite(sprite);
        setSpriteWidth(120);
        setSpriteHeight(120);

        // NEEDS ABILITIES

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

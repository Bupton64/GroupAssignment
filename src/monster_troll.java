import java.awt.*;

public class monster_troll extends Monster {

    public monster_troll() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[2];
        for (int i = 0; i < 2; i++) {
            temp[i] = new Ability();
        }
        setAttack(30);
        setDefense(6);
        setLuck(0);
        setSpeed(10);
        setStrength(30);
        setXPGain(2580);
        setGoldMin(790);
        setGoldMax(1030);
        setCurrentHP(600);
        setMaxHP(600);
        setLevel(11);
        setAlive(true);
        setName("Troll");
        setEnergy(0);
        temp[0] = new ability_monster_chargeUp();
        temp[0].setName("Enrage");
        setUpAbilityNumberI(temp, 1, "Axe Smash!", 0, 0, 0, 0, 0, false, 5, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);

        Image sprite = loadImage("monster_troll.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >95){
            newItem = new item_Equipment("Gladiators Axe", 8, 0, 0, 0, 8, Item.Slot.weapon, "Keen edged and lethal", 1450, 5200);
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getEnergy() == 5){
            return abilities[1].use(this); //< Use Axe Smash
        } else{
            return abilities[0].use(this); //< Use Enrage
        }
    }

}

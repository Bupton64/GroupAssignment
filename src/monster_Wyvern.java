import java.awt.*;

public class monster_Wyvern extends Monster {

    public monster_Wyvern() {
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
        setLuck(0);
        setSpeed(30);
        setStrength(2);
        setXPGain(1280);
        setGoldMin(370);
        setGoldMax(460);
        setCurrentHP(300);
        setMaxHP(300);
        setLevel(7);
        setAlive(true);
        setName("Wyvern");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Swooping Claw", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Razor Bite", 0, 10, 0, 0, 0, false, 2, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Body Slam", 0, 10, 0, 0, 4, false, 4, "", true, Ability.AbilityType.damage, "");
        this.setAbilities(temp);

        Image sprite = loadImage("monster_wyvern.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_Equipment("Scale Mail", 0, 2, 0, 2, 0, Item.Slot.chest, "A sturdy chestpiece", 390, 1040);

        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();

        if(this.getCurrentHP() > this.getMaxHP()*0.8){
            if(this.getEnergy() > 1){
                if(num > 30){
                    return abilities[1].use(this); //< Razor Bite
                } else {
                    return abilities[0].use(this); //< Swooping Claw
                }
            } else{
                return abilities[0].use(this); //< Swooping Claw
            }
        } else if(this.getCurrentHP() > this.getMaxHP() * 0.3){
            if(num > 70){
                return abilities[1].use(this); //< Razor Bite
            } else {
                return abilities[0].use(this); //< Swooping Claw
            }
        } else{
            if(this.getEnergy() > 3){
                return abilities[2].use(this); //< Body Slam
            } else{
                return abilities[0].use(this); //< Swooping Claw
            }
        }
    }

}

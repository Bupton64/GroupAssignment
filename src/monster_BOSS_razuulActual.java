import java.awt.*;

public class monster_BOSS_razuulActual extends Monster {

    public monster_BOSS_razuulActual(){this.init();}

    public void init(){
        Ability [] temp;
        temp= new Ability[5];
        for(int i=0; i<5; i++){
            temp[i]=new Ability();
        }
        setAttack(20);
        setDefense(10);
        setLuck(3);
        setSpeed(14);
        setStrength(10);
        setXPGain(3000);
        setGoldMin(3500);
        setGoldMax(4000);
        setCurrentHP(800);
        setMaxHP(800);
        setLevel(10);
        setAlive(true);
        setName("Razuul");
        setEnergy(0);

        Image sprite = loadImage("Image/monster_lich2.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);

        // NEEDS ABILITIES
        setUpAbilityNumberI(temp, 0, "Lich's Touch", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        temp[1] =  new ability_monster_lifeCoil();
        temp[1].setName("Lich's Life");
        temp[2] = new ability_monster_rabidFang();
        temp[2].setName("Lich's Breath");
        temp[3] = new ability_heroism();
        temp[3].setName("Lich's Power");
        temp[4] = new ability_Armageddon();
        temp[4].setName("Undeath");


        this.setAbilities(temp);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new item_Equipment("Jesters Staff", 4, 0, 0, 10, 0, Item.Slot.weapon, "Lighter than air itself", 1250, 4800);
        return newItem;
    }

    @Override
    public Ability moveChoice() {
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        // return abilities[0].use(this); //< Use Lich's Touch (Cost -1)
        // return abilities[1].use(this); //< Use Lich's Life (Cost 3)
        // return abilities[2].use(this); //< Use Lich's Breath (Cost 2)
        // return abilities[3].use(this); //< Use Lich's Power (Cost 4)
        // return abilities[4].use(this); //< Use Undeath (Cost 5)
        if(this. getCurrentHP() > this.getMaxHP() *0.8){
            if(this.getEnergy() > 3){
                if(num > 90){
                    return abilities[3]; //< Use Lich's Power (Cost 4)
                } else if (num > 55){
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                } else if (num > 35){
                    return abilities[1]; //< Use Lich's Life (Cost 3)
                } else {
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                }
            } else if (this.getEnergy() > 2){
                if(num > 60){
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                } else if (num > 40){
                    return abilities[1]; //< Use Lich's Life (Cost 3)
                } else {
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                }
            } else if (this.getEnergy() > 1){
                if(num > 50){
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                } else {
                    return abilities[0];//< Use Lich's Touch (Cost -1)
                }
            } else {
                return abilities[0].use(this); //< Use Lich's Touch (Cost -1)
            }
        } else if (this.getCurrentHP() > this.getMaxHP() * 0.4){ //Between 40-80% Uses best available ability or builds energy
            if (this.getEnergy() > 3){
                if(num >40) {
                    return abilities[3];//< Use Lich's Power (Cost 4)
                } else {
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                }
            } else if (this.getEnergy() > 2){
                if(num > 70) {
                    return abilities[1]; //< Use Lich's Life (Cost 3)
                } else {
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                }
            } else if (this.getEnergy() > 1){
                if(num > 21){
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                } else {
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                }
            } else {
                return abilities[0]; //< Use Lich's Touch (Cost -1)
            }
        } else {
            if(this.getEnergy() > 4){
                return abilities[4]; //< Use Undeath (Cost 5)
            } else if (this.getEnergy() > 3){
                if (num > 30){
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                } else if (num > 20){
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                } else {
                    return abilities[1]; //< Use Lich's Life (Cost 3)
                }
            } else if (this.getEnergy() > 2){
                if (num > 29){
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                } else if (num > 20){
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                } else {
                    return abilities[1]; //< Use Lich's Life (Cost 3)
                }
            } else if (this.getEnergy() > 1){
                if (num > 20){
                    return abilities[0]; //< Use Lich's Touch (Cost -1)
                } else{
                    return abilities[2]; //< Use Lich's Breath (Cost 2)
                }
            } else {
                return abilities[0]; //< Use Lich's Touch (Cost -1)
            }
        }

    }

}

import java.awt.*;

public class monster_BOSS_Therox extends Monster {

    public monster_BOSS_Therox(){this.init();}

    public void init(){
        Ability [] temp;
        temp= new Ability[8];
        for(int i=0; i<8; i++){
            temp[i]=new Ability();
        }
        setAttack(35);
        setDefense(10);
        setLuck(3);
        setSpeed(23);
        setStrength(25);
        setXPGain(10000);
        setGoldMin(0);
        setGoldMax(0);
        setCurrentHP(25);
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
        setUpAbilityNumberI(temp, 0, "Hatred", 0, 0, 0, 0, 0, false, -1, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 1, "Pain", 2, 4, 2, 2, 4, false, 3, "", true, Ability.AbilityType.damage, "");
        setUpAbilityNumberI(temp, 2, "Destruction", 4, 10, 4, 4, 10, false, 5, "", true, Ability.AbilityType.damage, "" );
        temp[3] = new ability_monster_ferocity();
        temp[4] = new ability_monster_guard();
        temp[5] = new ability_monster_rage();
        temp[6] = new ability_monster_grace();
        temp[7] = new ability_monster_fortune();
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
        // return abilities[0].use(this); //< Use Hatred (Cost -1)
        // return abilities[1].use(this); //< Use Pain (Cost 3)
        // return abilities[2].use(this); //< Use Destruction (Cost 5)
        // return abilities[3].use(this); //< Use Ferocity (Cost 1)
        // return abilities[4].use(this); //< Use Guard (Cost 1)
        // return abilities[5].use(this); //< Use Rage (Cost 1)
        // return abilities[6].use(this); //< Use Grace (Cost 1)
        // return abilities[7].use(this); //< Use Fortune (Cost 1)
        if(this.getCurrentHP() > 1800){
            if(this.getEnergy() > 4){
                if(num > 20){
                    return abilities[2]; //< Use Destruction (Cost 5)
                } else if( num > 17){
                    return abilities[3]; //< Use Ferocity (Cost 1)
                } else if( num > 14){
                    return abilities[4]; //< Use Guard (Cost 1)
                } else if( num > 11){
                    return abilities[5]; //< Use Rage (Cost 1)
                } else if( num > 8){
                    return abilities[6]; //< Use Grace (Cost 1)
                } else if( num > 5){
                    return abilities[7]; //< Use Fortune (Cost 1)
                } else {
                    return abilities[0]; //< Use Hatred (Cost -1)
                }
            } else if (this.getEnergy() > 2){
                if(num > 40){
                    return abilities[1]; //< Use Pain (Cost 3)
                } else if( num > 34){
                    return abilities[3]; //< Use Ferocity (Cost 1)
                } else if( num > 28){
                    return abilities[4]; //< Use Guard (Cost 1)
                } else if( num > 22){
                    return abilities[5]; //< Use Rage (Cost 1)
                } else if( num > 16){
                    return abilities[6]; //< Use Grace (Cost 1)
                } else if( num > 12){
                    return abilities[7]; //< Use Fortune (Cost 1)
                } else {
                    return abilities[0]; //< Use Hatred (Cost -1)
                }
            }  else if (this.getEnergy() > 0) {
                if(num > 30){
                    return abilities[0]; //< Use Hatred (Cost -1)
                } else if( num > 24){
                    return abilities[3]; //< Use Ferocity (Cost 1)
                } else if( num > 18){
                    return abilities[4]; //< Use Guard (Cost 1)
                } else if( num > 12){
                    return abilities[5];//< Use Rage (Cost 1)
                } else if( num > 6){
                    return abilities[6]; //< Use Grace (Cost 1)
                } else {
                    return abilities[7]; //< Use Fortune (Cost 1)
                }
            } else {
                return abilities[0]; //< Use Hatred (Cost -1)
            }
        } else if(this.getCurrentHP() > 1200){
            if(this.getEnergy() > 4){
                if(num > 80){
                    return abilities[2]; //< Use Destruction (Cost 5)
                } else if( num > 65){
                    return abilities[3]; //< Use Ferocity (Cost 1)
                } else if( num > 50){
                    return abilities[4]; //< Use Guard (Cost 1)
                } else if( num > 35){
                    return abilities[5]; //< Use Rage (Cost 1)
                } else if( num > 20){
                    return abilities[6]; //< Use Grace (Cost 1)
                } else if( num > 10){
                    return abilities[7]; //< Use Fortune (Cost 1)
                } else {
                    return abilities[0]; //< Use Hatred (Cost -1)
                }
            } else if (this.getEnergy() > 2){
                if(num > 80){
                    return abilities[1]; //< Use Pain (Cost 3)
                } else if( num > 65){
                    return abilities[3]; //< Use Ferocity (Cost 1)
                } else if( num > 50){
                    return abilities[4]; //< Use Guard (Cost 1)
                } else if( num > 35){
                    return abilities[5]; //< Use Rage (Cost 1)
                } else if( num > 20){
                    return abilities[6]; //< Use Grace (Cost 1)
                } else if( num > 10){
                    return abilities[7]; //< Use Fortune (Cost 1)
                } else {
                    return abilities[0]; //< Use Hatred (Cost -1)
                }
            } else if (this.getEnergy() > 0) {
                if(num > 70){
                    return abilities[0]; //< Use Hatred (Cost -1)
                } else if( num > 55){
                    return abilities[3]; //< Use Ferocity (Cost 1)
                } else if( num > 40){
                    return abilities[4]; //< Use Guard (Cost 1)
                } else if( num > 25){
                    return abilities[5]; //< Use Rage (Cost 1)
                } else if( num > 10){
                    return abilities[6]; //< Use Grace (Cost 1)
                } else {
                    return abilities[7]; //< Use Fortune (Cost 1)
                }
            } else {
                return abilities[0]; //< Use Hatred (Cost -1)
            }
        } else{
            if(this.getEnergy() > 4){
                return abilities[2]; //< Use Destruction (Cost 5)
            } else if(this.getEnergy() > 2){
                if(num > 60){
                    return abilities[1]; //< Use Pain (Cost 3)
                } else{
                    return abilities[0]; //< Use Hatred (Cost -1)
                }
            } else{
                return abilities[0]; //< Use Hatred (Cost -1)
            }
        }
    }

}

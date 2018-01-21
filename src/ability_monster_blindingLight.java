public class ability_monster_blindingLight extends Ability {

    public ability_monster_blindingLight() {
        this.setName("Blinding Light");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(2);
        this.setActive(true);
        this.setType(AbilityType.curse);
    }

    @Override
    public Ability use(Statblock user){
        setLastStatus(null);
        setLastStatusDuration(0);
        int num =(int)(Math.random()*100);
        if (num>20) {
            setLastStatus(Statblock.Status.Blind);
            int length = (int) (Math.random() * 4);
            length++;
            setLastStatusDuration(length);
            setDisplayString(user.getName() + " blinded their foe!");
            return this;
        } else{
            setDisplayString("Nothing happened!");
            return this;
        }
    }

}

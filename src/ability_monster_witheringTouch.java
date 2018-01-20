public class ability_monster_witheringTouch extends Ability {

    public ability_monster_witheringTouch() {
        this.setName("Withering Touch");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(false);
        this.setEnergyCost(2);
        this.setActive(true);
        this.setType(AbilityType.curse);
        this.setDisplayString("The Skeleton's touch is poisonous!");
    }

    @Override
    public Ability use(Statblock user){
        setLastStatus(Statblock.Status.Poison);
        setLastStatusDuration(3);
        int rand = (int)(Math.random()*8);
        setDamageOverTime(rand + user.getLevel()*5);
        return this;
    }

}

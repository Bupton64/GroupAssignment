public class ability_Berserk extends Ability {
    public ability_Berserk() {
        this.setName("Berserk");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(3);
        this.setToolTip("Harm yourself to gain strength");
        this.setActive(false);
        this.setType(AbilityType.buff);
        this.setDisplayString("Your power grows with your recklessness!");
    }

    public Ability use(Statblock user){
        int amountToGain= 5;
        user.setStrengthBonus(user.getStrengthBonus()+amountToGain);
        int damage = (3 * user.getLevel())*(int)Math.random();
        user.takeDamage(damage);
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(amountToGain);
        return this;
    }

}

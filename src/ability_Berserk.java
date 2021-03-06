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
        this.setDisplayString("Your recklessness empowers you!");
    }

    public Ability use(Statblock user){
        int amountToGain= 3;
        user.setStrengthBonus(user.getStrengthBonus()+amountToGain);
        int damage = (6 * user.getLevel())*(int)Math.random();
        user.setCurrentHP(user.getCurrentHP()-damage);
        user.takeDamage(damage);
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(damage);
        return this;
    }

}

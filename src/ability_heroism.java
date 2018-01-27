public class ability_heroism extends Ability {

    public ability_heroism(){
        this.setName("Heroism");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(4);
        this.setToolTip("Gain divine strength");
        this.setActive(true);
        this.setType(AbilityType.buff);

    }

    @Override
    public Ability use(Statblock user){
        this.setDisplayString(user.getName() + "'s destiny nears!");
        int amountToIncrease = 1 + (int)(Math.random()*4);
        user.setDefenseBonus(user.getDefenseBonus()+amountToIncrease);
        user.setStrengthBonus(user.getStrengthBonus()+amountToIncrease);
        user.setSpeedBonus(user.getSpeedBonus()+amountToIncrease);
        user.setAttackBonus(user.getAttackBonus()+amountToIncrease);
        user.setLuckBonus(user.getLuckBonus()+amountToIncrease);
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(amountToIncrease);
        return this;
    }

}

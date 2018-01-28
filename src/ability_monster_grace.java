public class ability_monster_grace extends Ability {

    public ability_monster_grace(){
        this.setName("Grace");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(1);
        this.setToolTip("");
        this.setActive(true);
        this.setType(AbilityType.buff);
        this.setDisplayString("Therox's speed increases!");
    }

    @Override
    public Ability use(Statblock user){
        int amountToIncrease = 1 + (int)(Math.random()*7);
        user.setSpeedBonus(user.getSpeedBonus()+amountToIncrease);
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(amountToIncrease);
        return this;

    }

}

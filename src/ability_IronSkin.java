public class ability_IronSkin extends Ability {
    public ability_IronSkin(){
        this.setName("Iron Skin");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(1);
        this.setToolTip("Harden your skin to resist blows");
        this.setActive(true);
        this.setType(AbilityType.buff);
        this.setDisplayString("Your skin grows tougher!");
    }

    @Override
    public Ability use(Statblock user){
        int amountToIncrease = 1 + (int)(Math.random()*7);
        user.setDefenseBonus(user.getDefenseBonus()+amountToIncrease);
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(amountToIncrease);
        return this;

    }
}
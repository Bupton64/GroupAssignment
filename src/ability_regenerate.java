public class ability_regenerate extends Ability {

    public ability_regenerate() {
        this.setName("Regenerate");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(4);
        this.setToolTip("Powerful healing");
        this.setActive(false);
        this.setType(AbilityType.buff);
    }

    @Override
    public Ability use(Statblock user){
        int amountToHeal= user.getLevel()*(int)(Math.random()*20);
        amountToHeal+=(20*user.getLevel());
        amountToHeal+=40;
        user.setCurrentHP(user.getCurrentHP()+ amountToHeal);
        if(user.getCurrentHP()>user.getMaxHP()){
            user.setCurrentHP(user.getMaxHP());
        }
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(amountToHeal);
        setDisplayString("You heal for " + amountToHeal + " health!");
        return this;
    }

}

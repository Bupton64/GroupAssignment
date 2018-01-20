public class ability_monster_sacrament extends Ability {

    public ability_monster_sacrament() {
        this.setName("Sacrament");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(4);
        this.setToolTip("");
        this.setActive(true);
        this.setType(AbilityType.buff);
    }

    @Override
    public Ability use(Statblock user){
        int amountToHeal= user.getLevel()*(int)(Math.random()*15);
        user.setCurrentHP(user.getCurrentHP() + amountToHeal);
        if(user.getCurrentHP()>user.getMaxHP()){
            user.setCurrentHP(user.getMaxHP());
        }
        setLastHit(true);
        setLastCrit(false);
        setLastStatus(null);
        setLastStatusDuration(0);
        setLastDamage(amountToHeal);
        setDisplayString( user.getName() + " healed for " + amountToHeal + " health!");
        return this;
    }

}

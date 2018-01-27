public class ability_monster_plague extends Ability {

    public ability_monster_plague() {
        this.setName("Plague");
        this.setSpeed(0);
        this.setAttack(2);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(false);
        this.setEnergyCost(2);
        this.setActive(true);
        this.setType(AbilityType.damage);
        this.setDisplayString("");
    }

    @Override
    public Ability use(Statblock user){
        Ability plague = super.use(user);
        int poisonChance = (int)(Math.random()*100);
        plague.setLastStatus(null);
        plague.setLastStatusDuration(0);
        if(plague.getLastDamage() > 0) {
            if (poisonChance > 30) {
                plague.setLastStatus(Statblock.Status.Poison);
                plague.setLastStatusDuration(4);
                int rand = (int) (Math.random() * 8);
                plague.setDamageOverTime(rand + user.getLevel() * 3);
            }
        }
        return plague;
    }

}

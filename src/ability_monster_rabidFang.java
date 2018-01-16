public class ability_monster_rabidFang extends Ability {
    public ability_monster_rabidFang() {
        this.setName("Rabid Fang");
        this.setSpeed(0);
        this.setAttack(2);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(2);
        this.setActive(false);
        this.setType(AbilityType.buff);
        this.setDisplayString("");
    }

    @Override
    public Ability use(Statblock user){
        Ability rabid = super.use(user);
        int poisonChance = (int)(Math.random()*100);
        if(poisonChance > 70){
            setLastStatus(Statblock.Status.poison);
            setLastStatusDuration(4);
            int rand = (int)(Math.random()*8);
            setDamageOverTime(rand + user.getLevel()*7);
        }
        return rabid;
    }

}

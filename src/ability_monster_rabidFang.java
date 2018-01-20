public class ability_monster_rabidFang extends Ability {
    public ability_monster_rabidFang() {
        this.setName("Rabid Fang");
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
        Ability rabid = super.use(user);
        int poisonChance = (int)(Math.random()*100);
        System.out.println(poisonChance);
        rabid.setLastStatus(null);
        rabid.setLastStatusDuration(0);
        if(rabid.getLastDamage() > 0) {
            if (poisonChance > 70) {
                rabid.setLastStatus(Statblock.Status.poison);
                rabid.setLastStatusDuration(4);
                int rand = (int) (Math.random() * 8);
                rabid.setDamageOverTime(rand + user.getLevel() * 3);
            }
        }
        return rabid;
    }

}

public class ability_Devastate extends Ability {

    public ability_Devastate() {
        this.setName("Devastate");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(5);
        this.setToolTip("A wild blow, tough to land");
        this.setActive(false);
        this.setType(AbilityType.damage);

    }

    public Ability use(Statblock user){
        int num = (int)(Math.random()*100);
        if(num > 80){
            setLastDamage(user.getLevel()*75);
            setLastAttack(this.getName());
            setLastHit(true);
            setDisplayString(user.getName() + " dealt " + this.getLastDamage());
            return this;
        } else{
            setLastDamage(0);
            setLastAttack(this.getName());
            setLastHit(false);
            setDisplayString(user.getName() + " was unable to hit!");
            return this;
        }
    }

}

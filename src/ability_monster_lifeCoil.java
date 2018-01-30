public class ability_monster_lifeCoil extends Ability{
    public ability_monster_lifeCoil() {
        this.setName("Life Coil");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(3);
        this.setToolTip("");
        this.setActive(true);
        this.setType(AbilityType.damage);
    }

    public Ability use(Statblock user){
        Ability useThis = super.use(user);

        user.setCurrentHP(useThis.getLastDamage()+user.getCurrentHP());
        if(user.getCurrentHP() > user.getMaxHP()){
            user.setCurrentHP(user.getMaxHP());
        }
        setDisplayString( user.getName() + " drained you for " + useThis.getLastDamage() + " health!");
        return useThis;
    }
}

/*


 */
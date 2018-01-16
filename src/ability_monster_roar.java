public class ability_monster_roar extends Ability {
    public ability_monster_roar() {
        this.setName("Roar");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(2);
        this.setActive(false);
        this.setType(AbilityType.buff);
        this.setDisplayString("The wolf is emboldened by its courage!");
    }

    @Override
    public Ability use(Statblock user){
        user.setStrength(user.getStrength()+2);
        return this;
    }
}

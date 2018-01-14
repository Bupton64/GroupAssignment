public class ability_Armageddon extends Ability{
    public ability_Armageddon(){
        this.setName("Armageddon");
        this.setSpeed(1);
        this.setAttack(20);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(20);
        this.setMagic(true);
        this.setEnergyCost(5);
        this.setToolTip("The end of all things");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}
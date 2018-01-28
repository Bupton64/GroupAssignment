public class ability_Spark extends Ability{
    public ability_Spark(){
        this.setName("Spark");
        this.setSpeed(1);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(1);
        this.setToolTip("A small burst of magical energy");
        this.setActive(true);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}
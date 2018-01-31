public class ability_DualStrike extends Ability{
    public ability_DualStrike(){
        this.setName("Dual Strike");
        this.setSpeed(-10);
        this.setAttack(6);
        this.setDefense(-2);
        this.setLuck(-5);
        this.setStrength(17);
        this.setMagic(false);
        this.setEnergyCost(4);
        this.setToolTip("A devastating combination move");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}
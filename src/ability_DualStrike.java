public class ability_DualStrike extends Ability{
    public ability_DualStrike(){
        this.setName("Dual Strike");
        this.setSpeed(-3);
        this.setAttack(3);
        this.setDefense(-2);
        this.setLuck(-1);
        this.setStrength(3);
        this.setMagic(false);
        this.setEnergyCost(4);
        this.setToolTip("A devastating combination move");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}
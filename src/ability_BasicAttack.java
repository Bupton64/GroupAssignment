public class ability_BasicAttack extends Ability{
    public ability_BasicAttack(){
        this.setName("Attack");
        this.setSpeed(0);
        this.setAttack(-2);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(-1);
        this.setMagic(false);
        this.setEnergyCost(-1);
        this.setToolTip("Attack");
        this.setActive(true);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}

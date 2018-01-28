public class ability_Slash extends Ability{
    public ability_Slash(){
        this.setName("Slash");
        this.setSpeed(1);
        this.setAttack(1);
        this.setDefense(-1);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(false);
        this.setEnergyCost(1);
        this.setToolTip("A fierce strike");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}

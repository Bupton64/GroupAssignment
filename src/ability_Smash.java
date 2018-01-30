public class ability_Smash extends Ability{
    public ability_Smash(){
        this.setName("Smash");
        this.setSpeed(0);
        this.setAttack(2);
        this.setDefense(2);
        this.setLuck(4);
        this.setStrength(0);
        this.setMagic(false);
        this.setEnergyCost(2);
        this.setToolTip("A powerful shockwave");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}
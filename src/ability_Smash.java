public class ability_Smash extends Ability{
    public ability_Smash(){
        this.setName("Smash");
        this.setSpeed(0);
        this.setAttack(2);
        this.setDefense(2);
        this.setLuck(2);
        this.setStrength(0);
        this.setMagic(false);
        this.setEnergyCost(2);
        this.setToolTip("A powerful shockwave gives you the edge over your opponent");
        this.setActive(false);
        this.setType(AbilityType.damage);
    }
}
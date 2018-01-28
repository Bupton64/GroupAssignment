public class ability_BladeDance extends Ability{
    public ability_BladeDance(){
        this.setName("Blade Dance");
        this.setSpeed(10);
        this.setAttack(1);
        this.setDefense(1);
        this.setLuck(1);
        this.setStrength(8);
        this.setMagic(false);
        this.setEnergyCost(3);
        this.setToolTip("A song of speed, rhythm and grace");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }
}
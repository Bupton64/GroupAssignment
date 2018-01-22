public class ability_ironFist extends Ability {

    public ability_ironFist(){
        this.setName("Iron Fist");
        this.setSpeed(1);
        this.setAttack(10);
        this.setDefense(1);
        this.setLuck(1);
        this.setStrength(12);
        this.setMagic(false);
        this.setEnergyCost(4);
        this.setToolTip("A steely blow");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }

}

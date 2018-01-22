public class ability_psiblast extends Ability {

    public ability_psiblast(){
        this.setName("Psi Blast");
        this.setSpeed(4);
        this.setAttack(6);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(6);
        this.setMagic(true);
        this.setEnergyCost(2);
        this.setToolTip("A powerful magical attack");
        this.setActive(false);
        this.setType(AbilityType.damage);
        this.setDisplayString(null);
    }

}

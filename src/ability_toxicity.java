public class ability_toxicity extends Ability {

    public ability_toxicity() {
        this.setName("Toxicity");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(3);
        this.setActive(false);
        this.setType(AbilityType.curse);
        this.setToolTip("Boil the blood of your foe");
    }

    @Override
    public Ability use(Statblock user){
        //Ability toxic = new ability_toxicity();
        int poisonChance = (int)(Math.random()*100);
        setLastStatus(null);
        setLastStatusDuration(0);
        if (poisonChance > 30) {
            setLastStatus(Statblock.Status.Poison);
            setLastStatusDuration(4);
            int rand = (int) (Math.random() * 8);
            setDamageOverTime(rand + user.getLevel() * 3);
            this.setDisplayString("Your foe's blood boils!");
        } else{
            this.setDisplayString("Nothing happened!");
        }
        return this;
    }

}

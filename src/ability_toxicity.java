public class ability_toxicity extends Ability {

    public ability_toxicity() {
        this.setName("Toxicity");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(false);
        this.setEnergyCost(3);
        this.setActive(false);
        this.setType(AbilityType.curse);
        this.setDisplayString("");
    }

    @Override
    public Ability use(Statblock user){
        Ability toxic = new ability_toxicity();
        int poisonChance = (int)(Math.random()*100);
        toxic.setLastStatus(null);
        toxic.setLastStatusDuration(0);
        if (poisonChance > 30) {
            toxic.setLastStatus(Statblock.Status.Poison);
            toxic.setLastStatusDuration(4);
            int rand = (int) (Math.random() * 8);
            toxic.setDamageOverTime(rand + user.getLevel() * 3);
        }
        return toxic;
    }

}

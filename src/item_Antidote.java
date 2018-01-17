public class item_Antidote extends Item {

    public item_Antidote() {
        this.setNumericValue(0);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Antidote");
        this.setTooltip("Cures poison");
        this.setUseableOustideCombat(false);
        this.setSellPrice(50);
        this.setBuyPrice(200);
    }

    @Override
    public void use(Character user){
        if(user.getLastStatusDuration()>0 && user.getLastStatusEffect() == Statblock.Status.poison){
            user.setLastStatusDuration(0);
            user.setLastStatusEffect(null);
            this.setDisplayString(user.getName() + "blood was cleansed!");
        } else {
            this.setDisplayString("Nothing happened!");
        }
        super.use(user);
    }
}

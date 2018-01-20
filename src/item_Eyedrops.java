public class item_Eyedrops extends Item {

    public item_Eyedrops() {
        this.setNumericValue(0);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Eyedrops");
        this.setTooltip("Cures blindness");
        this.setUseableOustideCombat(false);
        this.setSellPrice(50);
        this.setBuyPrice(250);
    }

    @Override
    public void use(Character user){
        if((user.getLastStatusDuration()>0) && (user.getLastStatusEffect() == Statblock.Status.blind)){
            user.setLastStatusDuration(0);
            user.setLastStatusEffect(null);
            this.setDisplayString(user.getName() + "'s eyes were cleared!");
        } else{
            this.setDisplayString("Nothing happened!");
        }
        super.use(user);
    }

}

public class item_soulStone extends Item {

    public item_soulStone() {
        this.setNumericValue(3);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Soul Stone");
        this.setTooltip("A gemstone containing divine energy");
        this.setUseableOustideCombat(false);
    }

    @Override
    public void use(Character user){
        user.setEnergy(user.getEnergy()+3);
        if(user.getEnergy()>5){
            user.setEnergy(5);
        }
        this.setDisplayString(user.getName() + " gained " + this.getNumericValue() + " energy!");
        super.use(user);
    }
}
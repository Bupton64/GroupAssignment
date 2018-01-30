public class item_wisdomStone extends Item {

    public item_wisdomStone() {
        this.setNumericValue(100);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Wisdom Stone");
        this.setTooltip("Gives 100 EXP");
        this.setUseableOustideCombat(true);
        this.setSellPrice(50);
        this.setBuyPrice(200);
    }

    @Override
    public void use(Character user){
        user.setXPTotal(user.getXPTotal()+this.getNumericValue());
        user.checkLevelUp();
        this.setDisplayString(user.getName() + " gained " + this.getNumericValue() + " experience!");
        super.use(user);
    }

}

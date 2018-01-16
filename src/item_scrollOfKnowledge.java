public class item_scrollOfKnowledge extends Item {

    public item_scrollOfKnowledge() {
        this.setNumericValue(100);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Scroll of Knowledge");
        this.setTooltip("Wisdom from the prophets of Artreza");
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

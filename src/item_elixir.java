public class item_elixir extends Item {

    public item_elixir(){
        this.setNumericValue(0);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Elixir");
        this.setTooltip("Fully rejuvenates a user");
        this.setUseableOustideCombat(true);
        this.setSellPrice(90);
        this.setBuyPrice(1040);
    }

    @Override
    public void use(Character user){
        user.setCurrentHP(user.getMaxHP());
        this.setDisplayString(user.getName() + " was fully healed!");
        super.use(user);
    }

}

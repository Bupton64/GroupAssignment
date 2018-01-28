public class item_Potion extends Item {

    public item_Potion(){
        this.setNumericValue(50);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Potion");
        this.setTooltip("Restores 50 HP");
        this.setUseableOustideCombat(true);
        this.setSellPrice(10);
        this.setBuyPrice(100);
    }

    @Override
    public void use(Character user){
        user.setCurrentHP(user.getCurrentHP()+this.getNumericValue());
        if(user.getCurrentHP()>user.getMaxHP()){
            user.setCurrentHP(user.getMaxHP());
        }
        this.setDisplayString(user.getName() + " healed for " + this.getNumericValue() + " health!");
        super.use(user);
    }

}

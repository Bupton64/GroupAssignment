public class item_HealingSalve extends Item {

    public item_HealingSalve(){
        this.setNumericValue(200);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Healing Salve");
        this.setTooltip("Restores 200 HP");
        this.setUseableOustideCombat(true);
        this.setSellPrice(90);
        this.setBuyPrice(300);
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

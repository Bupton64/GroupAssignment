public class item_HealingSalve extends Item {

    public item_HealingSalve(){
        this.setNumericValue(100);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Healing Salve");
        this.setTooltip("A magical paste for healing the body.");
        this.setUseableOustideCombat(true);
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
public class item_megaPotion extends Item {

    public item_megaPotion(){
        this.setNumericValue(250);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Mega Potion");
        this.setTooltip("Restores 250 HP");
        this.setUseableOustideCombat(true);
        this.setSellPrice(80);
        this.setBuyPrice(500);
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

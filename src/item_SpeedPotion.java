public class item_SpeedPotion extends Item {

    public item_SpeedPotion(){
        this.setNumericValue(3);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Speed Potion");
        this.setTooltip("Increases speed");
        this.setSellPrice(50);
        this.setBuyPrice(250);
        this.setUseableOustideCombat(false);
    }

    @Override
    public void use(Character user){
        user.setSpeedBonus(user.getSpeedBonus() + getNumericValue());
        this.setDisplayString(user.getName() + "'s speed increases!");
        super.use(user);
    }
}
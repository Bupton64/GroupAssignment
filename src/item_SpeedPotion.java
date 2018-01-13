public class item_SpeedPotion extends Item {

    public item_SpeedPotion(){
        this.setNumericValue(3);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Speed Potion");
        this.setTooltip("A concoction for agility");
    }

    @Override
    public void use(Character user){
        user.setSpeedBonus(user.getSpeedBonus() + getNumericValue());
        super.use(user);
    }
}
public class item_Potion extends Item {

    public item_Potion(){
        this.setNumericValue(15);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Potion");
        this.setTooltip("A small brew of magical healing herbs");
    }

    @Override
    public void use(Character user){
        user.setCurrentHP(user.getCurrentHP()+this.getNumericValue());
        if(user.getCurrentHP()>user.getMaxHP()){
            user.setCurrentHP(user.getMaxHP());
        }
        super.use(user);
    }
}

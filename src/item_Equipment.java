public class item_Equipment extends Item {
    public item_Equipment(String name, int attack, int defense, int luck, int speed, int strength, Slot slot){
        this.setName(name);
        this.setAttack(attack);
        this.setDefense(defense);
        this.setLuck(luck);
        this.setSpeed(speed);
        this.setStrength(strength);
        this.setSlot(slot);
        setEquippable(true);
        setEquipped(false);
    }
}

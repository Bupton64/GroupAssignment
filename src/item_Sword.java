public class item_Sword extends Item {

    public item_Sword(String name, int attack, int defense, int luck, int speed, int strength){
        this.setName(name);
        this.setAttack(attack);
        this.setDefense(defense);
        this.setLuck(luck);
        this.setSpeed(speed);
        this.setStrength(strength);
        this.setSlot(Slot.weapon);
        setEquippable(true);
        setEquipped(false);
    }

}

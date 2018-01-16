public class item_Equipment extends Item {
    public item_Equipment(String name, int attack, int defense, int luck, int speed, int strength, Slot slot, String tooltip, int sell, int buy){
        this.setName(name);
        this.setAttack(attack);
        this.setDefense(defense);
        this.setLuck(luck);
        this.setSpeed(speed);
        this.setStrength(strength);
        this.setSlot(slot);
        this.setTooltip(tooltip);
        this.setEquippable(true);
        this.setEquipped(false);
        this.setUseableOustideCombat(false);
        this.setSellPrice(sell);
        this.setBuyPrice(buy);
    }
}

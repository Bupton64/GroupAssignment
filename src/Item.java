public class Item {

    enum Slot{head,weapon,offhand,chest,feet, accessory,bag}

    private String name;
    private int attack;
    private int defense;
    private int luck;
    private int speed;
    private int strength;
    private int numericValue;
    private int counter;
    private String tooltip;
    private Slot slot;
    private boolean isEquippable;
    private boolean isEquipped;
    private boolean isUseableOustideCombat;

    public boolean isUseableOustideCombat() {
        return isUseableOustideCombat;
    }

    public void setUseableOustideCombat(boolean useableOustideCombat) {
        isUseableOustideCombat = useableOustideCombat;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(int numericValue) {
        this.numericValue = numericValue;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public boolean isEquippable() {
        return isEquippable;
    }

    public void setEquippable(boolean equippable) {
        isEquippable = equippable;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

    public Item(){
        this.setSlot(null);
        this.setEquippable(false);
        this.setEquipped(false);
    }

    public void use(Character user){
        if(this.counter>1){
            counter--;
        } else{
            user.removeFromInventory(this);
        }
    }
}

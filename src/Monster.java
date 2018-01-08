abstract public class Monster extends Statblock {

    private int XPGain; //< Amount of XP to be gained upon defeating a monster
    private int goldMin; //< Lowest amount of gold to be rewarded upon defeating a monster
    private int goldMax; //< Highest amount of gold to be rewarded upon defeating a monster


    public int getXPGain() {
        return XPGain;
    }

    public void setXPGain(int XPGain) {
        this.XPGain = XPGain;
    }

    public int getGoldMin() {
        return goldMin;
    }

    public void setGoldMin(int goldMin) {
        this.goldMin = goldMin;
    }

    public int getGoldMax() {
        return goldMax;
    }

    public void setGoldMax(int goldMax) {
        this.goldMax = goldMax;
    }

    public Monster() {
    }

    abstract public Ability moveChoice();

    // Methods
    public int randomGold(){
        int gold= (int)Math.random()*(goldMax-goldMin);
        gold+=goldMin;
        return gold;
    }



}

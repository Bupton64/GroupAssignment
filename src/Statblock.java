import java.awt.*;
import java.math.*;
import java.util.Arrays;
/* Parent class for all character objects */
public class Statblock extends extraFunctions{
    // Members

    private String name; //< Name of the object
    private Image sprite; //< The associated sprite
    private int spriteHeight; //< The height for the sprite png
    private int spriteWidth; //< The width for the sprite png
    private int attack; //< Influences hit chance and damage
    private int defense; //< Influences damage resistance
    private int strength; //< Influences damage (more so than attack)
    private int luck; //< Used to determine critical hits
    private double currentHP; //< The characters dynamic hit point total, should always be casted to int on display
    private int speed; //< Influences characters hit chance
    private boolean isAlive; //< Tracks whether this character has been killed or not
    private double maxHP; //< The characters total hit point total, should be casted to int on display
    private int level; //< Records the characters level, higher the level the higher some success requirements are
    private int attackBonus; //< Records the current attack bonus
    private int defenseBonus; //< Records the current defense bonus
    private int strengthBonus; //< Records the current strength bonus
    private int luckBonus; //< Records the current luck bonus
    private int speedBonus; //< Records the current speed bonus
    private String lastAttack; //< Records the last attack made.
    private int energy; //< Records the characters current energy pool.
    private Ability [] abilities; //< Array of abilities
    private double combatPosX; //< Character position on combat screen
    private double combatPosY; //< Character position on combat screen
    private int numOfAbilities; //< Number of abilities currently available to the player.
    private int maxNumAbilities; //< Maximum number of abilities available to player.
    private int equipAttackBonus; //< Characters bonus to attack from equipped items.
    private int equipDefenseBonus; //< Characters bonus to defense from equipped items.
    private int equipSpeedBonus; //< Characters bonus to speed from equipped items.
    private int equipLuckBonus; //< Characters bonus to luck from equipped items.
    private int equipStrengthBonus; //< Characters bonus to strength from equipped items.

    // Getters and Setters


    public int getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public void setNumOfAbilities(int numOfAbilities) {
        this.numOfAbilities = numOfAbilities;
    }

    public int getEquipAttackBonus() {
        return equipAttackBonus;
    }

    public void setEquipAttackBonus(int equipAttackBonus) {
        this.equipAttackBonus = equipAttackBonus;
    }

    public int getEquipDefenseBonus() {
        return equipDefenseBonus;
    }

    public void setEquipDefenseBonus(int equipDefenseBonus) {
        this.equipDefenseBonus = equipDefenseBonus;
    }

    public int getEquipSpeedBonus() {
        return equipSpeedBonus;
    }

    public void setEquipSpeedBonus(int equipSpeedBonus) {
        this.equipSpeedBonus = equipSpeedBonus;
    }

    public int getEquipLuckBonus() {
        return equipLuckBonus;
    }

    public void setEquipLuckBonus(int equipLuckBonus) {
        this.equipLuckBonus = equipLuckBonus;
    }

    public int getEquipStrengthBonus() {
        return equipStrengthBonus;
    }

    public void setEquipStrengthBonus(int equipStrengthBonus) {
        this.equipStrengthBonus = equipStrengthBonus;
    }

    public int getMaxNumAbilities() {
        return maxNumAbilities;
    }

    public void setMaxNumAbilities(int maxNumAbilities) {
        this.maxNumAbilities = maxNumAbilities;
    }

    public int getNumOfAbilities() {
        setNumOfAbilities();
        return numOfAbilities;
    }

    public void setNumOfAbilities() {
        Ability [] temp = new Ability[maxNumAbilities];
        for(int i=0; i<maxNumAbilities; i++){
            temp[i]= new Ability();
        }
        temp=getAbilities();
        int count=0;
        for(int i=0; i<maxNumAbilities; i++){
            if(temp[i].isActive()){
                count++;
            }
        }
        this.numOfAbilities = count;
    }

    public double getCombatPosX() {
        return combatPosX;
    }

    public void setCombatPosX(double combatPosX) {
        this.combatPosX = combatPosX;
    }

    public double getCombatPosY() {
        return combatPosY;
    }

    public void setCombatPosY(double combatPosY) {
        this.combatPosY = combatPosY;
    }

    public Ability[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Ability[] abilities) {
        this.abilities = abilities;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public double getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getLuckBonus() {
        return luckBonus;
    }

    public void setLuckBonus(int luckBonus) {
        this.luckBonus = luckBonus;
    }

    public int getSpeedBonus() {
        return speedBonus;
    }

    public void setSpeedBonus(int speedBonus) {
        this.speedBonus = speedBonus;
    }

    public String getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(String lastAttack) {
        this.lastAttack = lastAttack;
    }


    // Methods

    public void setUpAbilityNumberI(Ability [] abilities, int i, String name, int speed, int attack, int defense, int luck, int strength, boolean isMagic, int energy, String tooltip, boolean active, Ability.AbilityType type){
        abilities[i].setName(name);
        abilities[i].setSpeed(speed);
        abilities[i].setAttack(attack);
        abilities[i].setDefense(defense);
        abilities[i].setLuck(luck);
        abilities[i].setStrength(strength);
        abilities[i].setMagic(isMagic);
        abilities[i].setEnergyCost(energy);
        abilities[i].setToolTip(tooltip);
        abilities[i].setActive(active);
        abilities[i].setType(type);
    }

    public void sortAbilities(){
        sortByActive();
        Ability [] temp = new Ability[maxNumAbilities];
        for(int i=0; i <maxNumAbilities; i++){
            temp[i]=new Ability();
        }
        temp=getAbilities();
        Ability swap;
        for(int i=0; i<numOfAbilities; i++){
            for(int j=1; j<numOfAbilities-i; j++){
                if(temp[j-1].getEnergyCost() > temp[j].getEnergyCost()){
                    swap = temp[j-1];
                    temp[j-1] = temp[j];
                    temp[j] = swap;
                }
            }
        }
        setAbilities(temp);
    }

    public void sortByActive(){
        Ability [] temp = new Ability[maxNumAbilities];
        for(int i=0; i <maxNumAbilities; i++){
            temp[i]=new Ability();
        }
        temp=getAbilities();
        Ability swap;
        for(int i=0; i<maxNumAbilities; i++){
            for(int j=1; j<maxNumAbilities-i; j++){
                if(!temp[j-1].isActive() && temp[j].isActive()){
                    swap = temp[j-1];
                    temp[j-1] = temp[j];
                    temp[j] = swap;
                }
            }
        }
        setAbilities(temp);
    }

    public void resetBonuses(){
        energy = 0;
        attackBonus=0;
        strengthBonus=0;
        speedBonus=0;
        luckBonus=0;
        defenseBonus=0;
    }


    public int takeDamage(int damage){
        double reduced = (defense+defenseBonus+equipDefenseBonus)/2.0;
        double percentageReduction = reduced/100;
        if(percentageReduction>0.50){
            percentageReduction=0.50;
        }
        reduced=percentageReduction*damage;
        damage-=reduced;
        this.currentHP -= damage; //< Remove damage from health
        if(this.currentHP<=0){
            this.isAlive=false;
        }
        return damage;
    }

    public void addEnergy(int energy){
       setEnergy(getEnergy()+energy);
    }

    public Statblock() {
    }


}

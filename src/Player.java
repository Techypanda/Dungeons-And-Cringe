import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class Player extends Character {
    private ArrayList<Item> inventory;
    private Weapon weapon;
    private Armour armour;
    public Player(String inName, int inHP, int inGold) {
        super(inName, inHP, inGold);
        inventory = new ArrayList<>();
    }
    public void equip(Weapon weapon) {
        this.weapon = weapon;
    }
    public void equip(Armour armour) {
        this.armour = armour;
    }
    @Override
    public void dealDamage(Character target) {
        Random rand = new Random();
        int dmgVal = rand.nextInt((weapon.getMax() - weapon.getMin()) + 1) + weapon.getMin(); // MODIFIER NEEDS TO BE ADDED
        target.takeDamage(dmgVal);
    }
    @Override
    public void takeDamage(int inDmg) {
        Random rand = new Random();
        int defenceVal = rand.nextInt((armour.getMax() - armour.getMin()) + 1) + armour.getMin();
        currHP = currHP - Math.max(0, inDmg - defenceVal);
    }
    @Override
    public String toString() {
        return String.format("%s, HP: %d, gold: %d", name, currHP, gold);
    }
}

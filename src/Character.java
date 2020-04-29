public abstract class Character {
    protected String name;
    protected int maxHP;
    protected int gold;
    protected int currHP;
    public Character(String inName, int inHP, int inGold) {
        name = inName;
        maxHP = inHP;
        gold = inGold;
        currHP = maxHP;
    }
    public abstract void dealDamage(Character target);
    public abstract void takeDamage(int inDmg);
    public abstract String toString();
}

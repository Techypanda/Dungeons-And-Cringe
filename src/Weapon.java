public class Weapon extends Item {
    private String type;
    public Weapon(String inName, int inCost, int inMinEffect, int inMaxEffect, String inType) {
        super(inName, inCost, inMinEffect, inMaxEffect);
        type = inType;
    }
    @Override
    public String toString() {
        return String.format("%s, Damage Type: %s, Cost: %d, Damage: %d - %d", name, type, cost,
        minimumEffect, maxEffect);
    }
}

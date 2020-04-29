public class CharacterTestHarness {
    public static void main(String[] args) {
        Player player = new Player("A Cool Name", 100, 5);
        Character slime = new Slime();
        Character goblin = new Goblin();
        Character ogre = new Ogre();
        Character dragon = new Dragon();
        player.equip(new Weapon("Cutlass", 75, 4, 8, "Sharp"));
        player.equip(new Armour("Chainmail", 50, 2, 4, "Chains"));
        System.out.printf("Before Battle: \n%s\n%s\n", player.toString(), dragon.toString());
        dragon.dealDamage(player);
        System.out.printf("After Battle: \n%s\n%s\n", player.toString(), dragon.toString());
    }
}

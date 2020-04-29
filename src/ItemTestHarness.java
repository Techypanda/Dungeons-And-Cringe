import java.util.*;

public class ItemTestHarness {
    public static void main(String[] args) {
        List<Item> TestInventory = new ArrayList<>();
        TestInventory.add(new Armour("Chainmail", 50, 2, 4, "Chains"));
        TestInventory.add(new Weapon("Cutlass", 75, 4, 8, "Sharp"));
        TestInventory.add(new Healing("Koolaid", 20, 1, 3));
        TestInventory.add(new Harming("Poison", 34, 6, 9));
        for (Item currItem: TestInventory) {
            System.out.println(currItem.toString());
        }
    }
}

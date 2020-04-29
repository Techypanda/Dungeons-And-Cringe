import java.util.Random;
public class Ogre extends Enemy {
    public Ogre() {
        super("Ogre", 40, 40, 5, 10, 6, 12);
    }
    @Override
    public void dealDamage(Character target) {
        Random rand = new Random();
        int roll = rand.nextInt((100 - 1) + 1) + 1;
        if (roll > 20) {
              int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
              target.takeDamage(dmgVal);
        } else {
            int dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal); // Attack Once
            dmgVal = rand.nextInt((damage[1] - damage[0]) + 1) + damage[0];
            target.takeDamage(dmgVal); // Attack Twice
        }
     }
}

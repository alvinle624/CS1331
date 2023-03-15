/**
 * class Turtle.
 * @author Alvin Le
 * @version 1.0
 */
public class Turtle extends Pet {
    private boolean melonArmor;
    /**
     * @param health int
     * @param attack int
     * @param melonArmor boolean
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }
    /**
     * no-args constructor.
     */
    public Turtle() {
        this(4, 2, true);
    }
    /**
     * @param damage int
     * receives damage.
     */
    public void getAttacked(int damage) {
        if (melonArmor == true) {
            int newDamage = damage - 20;
            if (newDamage < 0) {
                newDamage = 0;
            }
            setHealth(getHealth() - newDamage);
            setMelonArmor(false);
        } else {
            setHealth(getHealth() - damage);
        }
    }
    /**
     * @return String
     */
    public String toString() {
        return "Turtle:" + super.toString() + "/" + this.melonArmor;
    }
    /**
     * @param melonArmor boolean
     */
    public void setMelonArmor(boolean melonArmor) {
        this.melonArmor = melonArmor;
    }
    /**
     * @return boolean
     */
    public boolean getMelonArmor() {
        return this.melonArmor;
    }
}

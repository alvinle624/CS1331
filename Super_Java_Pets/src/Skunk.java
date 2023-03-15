/**
 * class Skunk.
 * @author Alvin Le
 * @version 1.0
 */
public class Skunk extends Pet {
    private int numSpray;
    /**
     * @param health int
     * @param attack int
     * @param numSpray int
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        if (numSpray < 0) {
            this.numSpray = 0;
        } else {
            this.numSpray = numSpray;
        }
    }
    /**
     * no-args constructor.
     */
    public Skunk() {
        this(5, 3, 1);
    }
    /**
     * @param target Pet object
     * debuffs other pet.
     */
    public void sprayPet(Pet target) {
        int healthDebuff = target.getHealth() / 3;
        int attackDebuff = target.getAttack() / 3;

        target.setHealth(target.getHealth() - healthDebuff);
        target.setAttack(target.getAttack() - attackDebuff);

        setNumSpray(this.numSpray - 1);
    }
    /**
     * @param target Pet object
     * attacks pet.
     */
    public void attackPet(Pet target) {
        if (numSpray > 0) {
            sprayPet(target);
        }
        target.getAttacked(getAttack());
    }
    /**
     * @return String
     */
    public String toString() {
        return "Skunk:" + super.toString() + "/" + this.numSpray;
    }
    /**
     * @param numSpray int
     */
    public void setNumSpray(int numSpray) {
        if (numSpray < 0) {
            this.numSpray = 0;
        } else {
            this.numSpray = numSpray;
        }
    }
    /**
     * @return int
     */
    public int getNumSpray() {
        return this.numSpray;
    }
}

/**
 * class Hippo.
 * @author Alvin Le
 * @version 1.0
 */
public class Hippo extends Pet {
    private int buff;
    /**
     * @param health int
     * @param attack int
     * @param buff int
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);

        if (buff < 0) {
            this.buff = 0;
        } else {
            this.buff = buff;
        }
    }
    /**
     * no-args constructor.
     */
    public Hippo() {
        this(7, 4, 2);
    }
    /**
     * increases health and attack.
     */
    public void getBuffed() {
        setHealth(getHealth() + this.buff);
        setAttack(getAttack() + this.buff);
    }
    /**
     * @param target Pet object
     * attacks other pet.
     */
    public void attackPet(Pet target) {
        target.getAttacked(getAttack());
        if (target.hasFainted() == true) {
            getBuffed();
        }
    }
    /**
     * @return String
     */
    public String toString() {
        return "Hippo:" + super.toString() + "/" + this.buff;
    }
    /**
     * @param buff int
     */
    public void setBuff(int buff) {
        if (buff < 0) {
            this.buff = 0;
        } else {
            this.buff = buff;
        }
    }
    /**
     * @return int
     */
    public int getBuff() {
        return this.buff;
    }

}

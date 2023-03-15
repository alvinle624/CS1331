/**
 * class Pet.
 * @author Alvin Le
 * @version 1.0
 */
public abstract class Pet implements Comparable<Pet> {
    private int health;
    private int attack;
    /**
     * @param health int
     * @param attack int
     */
    public Pet(int health, int attack) {
        if (health <= 0) {
            this.health = 1;
        } else {
            this.health = health;
        }

        if (attack < 0) {
            this.attack = 0;
        } else {
            this.attack = attack;
        }
    }
    /**
     * @return boolean
     * determines if pet has fainted.
     */
    public boolean hasFainted() {
        boolean a = (getHealth() <= 0) ? true : false;
        return a;
    }
    /**
     * @param damage int
     * receives damage.
     */
    public void getAttacked(int damage) {
        setHealth(getHealth() - damage);
    }
    /**
     * @param target Pet object
     * attacks other pet.
     */
    public void attackPet(Pet target) {
        target.getAttacked(getAttack());
    }
    /**
     * @return String
     */
    public String toString() {
        return (this.attack + "/" + this.health);
    }
    /**
     * @param otherPet Pet object
     * @return int
     * compares pets.
     */
    public int compareTo(Pet otherPet) {
        if (otherPet == null) {
            return 1;
        } else {
            int petSum = this.health + this.attack;
            int otherPetSum = otherPet.getHealth() + otherPet.getAttack();
            if (petSum > otherPetSum) {
                return 1;
            } else if (petSum == otherPetSum) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    /**
     * @param health int
     */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
     * @param attack int
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
    /**
     * @return int
     */
    public int getHealth() {
        return this.health;
    }
    /**
     * @return int
     */
    public int getAttack() {
        return this.attack;
    }
}

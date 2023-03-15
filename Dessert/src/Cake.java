/**
 * class Cake.
 * @author Alvin Le
 * @version 1.0
 */
public class Cake extends Dessert {
    private String frosting;
    /**
     * @param flavor String
     * @param sweetness int
     * @param frosting String
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }
    /**
     * @param flavor String
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }
    /**
     * @return String
     * returns the type of cake.
     */
    @Override
    public String toString() {
        return "This is a " + super.getFlavor() + " cake with a " + getFrosting()
                + " frosting and has a sweetness of " + super.getSweetness() + ".";
    }
    /**
     * @param obj Object
     * @return boolean
     * checks if two cakes are equal.
     */
    @Override
    public boolean equals(Object obj) {
        Cake otherCake = (Cake) obj;

        return (getFlavor() == otherCake.getFlavor() && getSweetness() == otherCake.getSweetness()
                && getFrosting() == otherCake.getFrosting());
    }
    /**
     * @param frosting String
     * sets frosting.
     */
    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }
    /**
     * @return String
     * gets frosting.
     */
    public String getFrosting() {
        return this.frosting;
    }
}

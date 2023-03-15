/**
 * class IceCream.
 * @author Alvin Le
 * @version 1.0
 */
public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;
    /**
     * @param flavor String
     * @param sweetness double
     * @param scoops int
     * @param cone boolean
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }
    /**
     * @param scoops int
     * @param cone boolean
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }
    /**
     * no args constructor.
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }
    /**
     * @return String
     * returns the type of ice cream.
     */
    @Override
    public String toString() {
        String ifCone = (getCone()) ? "has" : "does not have";

        return "This is a " + getFlavor() + " ice cream with " + getScoops() + " scoops and " + ifCone + "a cone";
    }
    /**
     * @param obj Object
     * @return boolean
     * checkes if two IceCreams are equal.
     */
    @Override
    public boolean equals(Object obj) {
        IceCream otherIceCream = (IceCream) obj;

        return (getFlavor() == otherIceCream.getFlavor() && getSweetness() == otherIceCream.getSweetness()
                && getScoops() == otherIceCream.getScoops() && getCone() == otherIceCream.getCone());
    }
    /**
     * @param scoops int
     * sets scoops.
     */
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
    /**
     * @param cone boolean
     * sets cone.
     */
    public void setCone(boolean cone) {
        this.cone = cone;
    }
    /**
     * @return int
     * returns scoops.
     */
    public int getScoops() {
        return this.scoops;
    }
    /**
     * @return boolean
     * returns cone.
     */
    public boolean getCone() {
        return this.cone;
    }
}

/**
 * class Dessert.
 * @author Alvin Le
 * @version 1.0
 */
public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;
    /**
     * @param flavor String
     * @param sweetness double
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }
    /**
     * no args constructor.
     */
    public Dessert() {
        this("vanilla", 25.0);
    }
    /**
     * @return String
     * returns the type and values of the dessert.
     */
    @Override
    public String toString() {
        double sweet = ((Math.round(getSweetness() * 100.0)) / 100.0);
        return "This is a " + this.flavor + " dessert with a sweetness of "
                + sweet + ".";
    }
    /**
     * @param obj Object
     * @return boolean
     * checks if two desserts are equal.
     */
    @Override
    public boolean equals(Object obj) {
        Dessert otherDessert = (Dessert) obj;

        return (getFlavor() == otherDessert.getFlavor() && getSweetness() == otherDessert.getSweetness());
    }
    /**
     * @param otherDessert Dessert object
     * @return int
     * shows which dessert is greater in value.
     */
    @Override
    public int compareTo(Dessert otherDessert) {
        String originalFlavor = getFlavor();
        int strLength = Math.min(originalFlavor.length(), otherDessert.getFlavor().length());
        int lexiValue = 0;

        if (getSweetness() == otherDessert.getSweetness()) {
            int i = 0;
            while (i < strLength && lexiValue == 0) {
                lexiValue = (((int) originalFlavor.charAt(i)) - ((int) otherDessert.getFlavor().charAt(i)));
                i = i + 1;
            }
            if (lexiValue == 0) {
                if (originalFlavor.length() == otherDessert.getFlavor().length()) {
                    return 0;
                } else if (originalFlavor.length() > otherDessert.getFlavor().length()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (lexiValue < 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (getSweetness() > otherDessert.getSweetness()) {
            return 1;
        } else {
            return -1;
        }
    }
    /**
     * @param flavor String
     * sets flavor.
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    /**
     * @param sweetness int
     * sets sweetness.
     */
    public void setSweetness(int sweetness) {
        this.sweetness = sweetness;
    }
    /**
     * @return String
     * gets flavor.
     */
    public String getFlavor() {
        return this.flavor;
    }
    /**
     * @return double
     * returns sweetness.
     */
    public double getSweetness() {
        return this.sweetness;
    }
}

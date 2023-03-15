import java.util.ArrayList;
/**
 * class Store.
 * @author Alvin Le
 * @version 1.0
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;
    /**
     * @param name String
     */
    public Store(String name) {
        ArrayList<Dessert> newDesserts = new ArrayList<>();
        this.desserts = newDesserts;
        this.name = name;
    }
    /**
     * @param newDessert Dessert object
     * adds a Dessert object to ArrayList desserts of type Dessert.
     */
    public void addDessert(Dessert newDessert) {
        this.desserts.add(newDessert);
    }
    /**
     * @param dessert Dessert object
     * @return Dessert object
     * removes a Dessert object from ArrayList desserts of type Dessert.
     */
    public Dessert removeDessert(Dessert dessert) {
        Dessert removedDessert = null;
        int i = 0;

        while (i < this.desserts.size() && this.desserts.get(i) != dessert) {
            if (this.desserts.get(i).equals(dessert)) {
                removedDessert = this.desserts.get(i);
                this.desserts.remove(this.desserts.get(i));
            }
            i = i + 1;
        }
        return removedDessert;
    }
    /**
     * @param dessert Dessert object
     * @return Dessert object
     * finds a certain Dessert object in the ArrayList desserts of type Dessert.
     */
    public Dessert findDessert(Dessert dessert) {
        Dessert dessertFound = null;
        int low = 0;
        int high = this.desserts.size() - 1;
        int mid = high / 2;
        int lexiValue = 0;

        while (low <= high) {
            mid = ((high - low) / 2) + low;
            if (dessert.getSweetness() == this.desserts.get(mid).getSweetness()) {
                String originalFlavor = this.desserts.get(mid).getFlavor();
                lexiValue = ((int) originalFlavor.charAt(0) - ((int) dessert.getFlavor().charAt(0)));
                if (dessert.getFlavor() == this.desserts.get(mid).getFlavor()) {
                    dessertFound = this.desserts.get(mid);
                    low = high + 1;
                } else if (lexiValue < 0) {
                    low = mid + 1;
                } else if (lexiValue > 0) {
                    high = mid - 1;
                }
            } else if (dessert.getSweetness() < this.desserts.get(mid).getSweetness()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return dessertFound;
    }
    /**
     * sorts the desserts ArrayList of type Dessert.
     */
    public void sortStore() {
        boolean unsorted = true;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < this.desserts.size() - 1; i = i + 1) {
                if (this.desserts.get(i).compareTo(this.desserts.get(i + 1)) == 1) {
                    unsorted = true;
                    Dessert holder = this.desserts.get(i);
                    this.desserts.set(i, this.desserts.get(i + 1));
                    this.desserts.set(i + 1, holder);
                }
            }
        }
    }
    /**
     * @param dessert Dessert object
     * @return int
     * checks the Store object for Desserts objects greater then or equal to the given dessert object.
     */
    public int checkStore(Dessert dessert) {
        int numDesserts = 0;
        for (int i = 0; i < this.desserts.size(); i = i + 1) {
            if (this.desserts.get(i).compareTo(dessert) >= 0) {
                numDesserts = numDesserts + 1;
            }
        }
        return numDesserts;
    }
    /**
     * @param name String
     * sets name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param desserts ArrayList of type Desserts
     * sets desserts ArrayList of type Desserts.
     */
    public void setDesserts(ArrayList<Dessert> desserts) {
        this.desserts = desserts;
    }
    /**
     * @return String
     * gets name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return ArrayList of type Dessert
     * gets desserts ArrayList of type Desserts.
     */
    public ArrayList<Dessert> getDesserts() {
        return this.desserts;
    }
}

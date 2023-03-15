/**
 * class Bob.
 * @author Alvin Le
 * @version 1.0
 */
public class Bob {
    /**
     * @param args String array
     * main.
     */
    public static void main(String[] args) {

    }
    /**
     * @param store1 Store object
     * @param store2 Store object
     * @return boolean
     * checks if all the desserts in store1 is found in store2.
     */
    public static boolean compareStores(Store store1, Store store2) {
        boolean allFound = true;
        int i = 0;
        while (allFound && i < store1.getDesserts().size()) {
            allFound = store2.findDessert(store1.getDesserts().get(i)) != null;
            i = i + 1;
        }
        return allFound;
    }
    /**
     * @param store1 Store object
     * @param dessert Dessert object
     * @return boolean
     * checks if store1 has a certain dessert.
     */
    public static boolean shop(Store store1, Dessert dessert) {
        store1.sortStore();
        boolean dessertFound = (store1.findDessert(dessert) != null);
        return dessertFound;
    }
}

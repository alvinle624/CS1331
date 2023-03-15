/**
 * class Recursion.
 * @author Alvin Le
 * @version 1.0
 */
public class Recursion {
    /**
     * @param args String array
     * main.
     */
    public static void main(String[] args) {
        String[] array = {"Brian", "Alex", "Charlie", "David", "Aaron"};
        String[][] arr2 = {{"Alex", "Brian"}, {"Aaron", "David"}, {"Charlie"}};
        String[] arr1 = {"a", "a", "a", "b", "b", "c", "d", "d", "d"};
        String str1 = "hannah";
        String str2 = "Hannah";
        String str3 = "car";
        String str4 = null;
        String str5 = "";

//        Point[] points1 = {new Point(1, 1), new Point(0, 0), new Point(3, 4), new Point(5, 5)};
//        Point[] points2 = {new Point(1, 1), new Point(0, 0), new Point(3, 3), new Point(5, 5)};
//        Point[] points3 = {new Point(5, 5), new Point(4, 4), new Point(3, 3), new Point(1, 4)};
//
//        System.out.println(numInteriorPoints(points1, 5));
//        System.out.println(numInteriorPoints(points2, 5));
//        System.out.println(numInteriorPoints(points3, 5));

        String[] mergeAllArr3 = mergeAll(arr2);
        for (int i = 0; i < mergeAllArr3.length; i = i + 1) {
            System.out.println(mergeAllArr3[i]);
        }

//        System.out.println();
//        for (int i = 0; i < array.length; i = i + 1) {
//            System.out.println(mergeSort(array)[i]);
//        }
//
//        System.out.println();
//        System.out.println(countDuplicates(arr1));
//
//        System.out.println();
//        System.out.println(verifyPalindrome(str1));
//        System.out.println(verifyPalindrome(str2));
//        System.out.println(verifyPalindrome(str3));
//        System.out.println(verifyPalindrome(str4));
//        System.out.println(verifyPalindrome(str5));
//        System.out.println();
    }
    /**
     * @param arrayStr String array
     * @return String array.
     * merge sorts arrayStr.
     */
    public static String[] mergeSort(String[] arrayStr) {
        RecursionUtils utils = new RecursionUtils();

        if (arrayStr.length < 2) {
            return arrayStr;
        }

        int mid = arrayStr.length / 2;
        String[] left = new String[mid];
        String[] right = new String[arrayStr.length - mid];

        for (int i = 0; i < mid; i = i + 1) {
            left[i] = arrayStr[i];
        }

        for (int i = mid; i < arrayStr.length; i = i + 1) {
            right[i - mid] = arrayStr[i];
        }

        return utils.merge(mergeSort(left), mergeSort(right));
    }
    /**
     * @param arrayStr 2D String array
     * @return String array.
     * merge sorts 2D String  array arrayStr.
     */
    public static String[] mergeAll(String[][] arrayStr) {
        int size = 0;

        for (int i = 0; i < arrayStr.length; i = i + 1) {
            for (int j = 0; j < arrayStr[i].length; j = j + 1) {
                size = size + 1;
            }
        }

        String[] finalArr = new String[size];
        for (int i = 0; i < arrayStr.length; i = i + 1) {
            int nullCounter = 0;

            while (finalArr[nullCounter] != null) {
                nullCounter = nullCounter + 1;
            }

            for (int j = 0; j < arrayStr[i].length; j = j + 1) {
                finalArr[j + nullCounter] = arrayStr[i][j];
            }
        }
        return mergeSort(finalArr);
    }
    /**
     * @param strArray String array
     * @return int
     * counts the duplicates.
     */
    public static int countDuplicates(String[] strArray) {
        RecursionUtils utils = new RecursionUtils();
        int count = 0;
        int start = 0;
        int end = strArray.length;

        for (int i = start; i < end - 1; i = i + 1) {
            if (strArray[start].equals(strArray[i + 1])) {
                count = count + 1;
            } else {
                start = i + 1;
                count = count + countDuplicates(utils.copyOfRange(strArray, start, end));
                return count;
            }
        }
        return count;
    }
    /**
     * @param string String
     * @return boolean
     * checks if palindrome.
     */
    public static boolean verifyPalindrome(String string) {
        RecursionUtils utils = new RecursionUtils();
        boolean pali = false;
        if (string == null) {
            return pali;
        }

        if (string.length() == 0 || string.length() == 1) {
            pali = true;
        } else {
            if (string.substring(0, 1).equalsIgnoreCase(string.substring(string.length() - 1))) {
                verifyPalindrome(string.substring(1, string.length() - 1));
                pali = true;
            } else {
                pali = false;
            }
        }
        return pali;
    }
    /**
     * @param p array of Point objects.
     * @param radius int
     * @return int
     * counts all the points inside a circle.
     */
    public static int numInteriorPoints(Point[] p, int radius) {
        int start = 0;
        int end = p.length;
        int count = 0;

        if (p.length <= 0) {
            return count;
        }
        for (int i = start; i < end; i = i + 1) {
            if ((p[i].getX() * p[i].getX()) + (p[i].getY() * p[i].getY()) < (radius * radius)) {
                start = i + 1;
                count = 1 + numInteriorPoints(copyOfRange(p, start, end), 5);
                i = end;
            }
        }
        return count;
    }
    /**
     * @param original array of Point objects.
     * @param start int
     * @param end int
     * @return array of Point objects.
     * makes an altered copy of orginal point array.
     */
    public static Point[] copyOfRange(Point[] original, int start, int end) throws ArrayIndexOutOfBoundsException,
            IllegalArgumentException,
            NullPointerException {
        if (original == null) {
            throw new NullPointerException("array reference \"original\" is null");
        } else if (start > end) {
            throw new IllegalArgumentException(
                    String.format("start index %d is greater than end index %d", start, end));
        } else if (start < 0 || start > original.length) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("start index %d is out of bounds for array of length %d", start, original.length));
        } else if (end > original.length) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("end index %d is out of bounds for array of length %d", end, original.length));
        }

        Point[] copy = new Point[end - start];
        for (int i = start; i < end; i += 1) {
            copy[i - start] = original[i];
        }
        return copy;
    }
}

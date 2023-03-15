import java.util.ArrayList;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
       String[] arr = {"Tom", "Eric", "Eric", "John", "Cindy", "Cindy", "Cindy"};
       LinkedList<String> aList = new LinkedList<String>(arr);


       System.out.println(Arrays.toString(aList.toArray()));

       aList.set(2, "alvin");

        System.out.println(Arrays.toString(aList.toArray()));



    }


}

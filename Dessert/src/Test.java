import java.util.ArrayList;
public class Test {
    public static int count = 0;
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Object 1");
        strList.add("Object 2");
        strList.add("Object 3");
        System.out.println(strList.get(1));

        strList.remove(1);
        System.out.println(strList.get(1));

        Test a = new Test();
        System.out.println(a.recursion(5));
        System.out.println(a.exam(6, 6));
        System.out.println(1%2);
        System.out.println(2%2);
        System.out.println(3%2);
        System.out.println(0%2);

    }
    public String returnTest(String a) {
        return a;
    }
    public int recursion(int n) {
        this.count = this.count + 1;
        int factorial;
        if (n == 0) {
            factorial = 1;
            return  factorial;
        } else {
            factorial = n * recursion(n - 1);
        }
        return factorial;
    }

    public static int exam(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        } else {
            return b + exam(a*2, b/2);
        }
    }
}

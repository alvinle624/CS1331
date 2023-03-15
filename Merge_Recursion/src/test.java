public class test {
    public static void main(String[] args) {
        String str1 = "hannah";
        String str2 = "Hannah";
        String str3 = "car";
        String str4 = null;
        String str5 = "";
        String str6 = str1.substring(0, 1);
        String str7 = str1.substring(str1.length() - 1);

        String[] arr = new String[str1.length()];
        String a = str1.substring(1, str1.length() - 1);

        System.out.println(str1.substring(1, str1.length() - 1));
        System.out.println(str6);
        System.out.println(str7);


        System.out.println(str6.equalsIgnoreCase(str7));

    }
}

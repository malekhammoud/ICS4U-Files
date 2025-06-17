package recursion;


public class backward_string {
    public static void main(String[] args) {
        String str = "Hello World!!";
        String reversed = reverseString(str);
        System.out.println(reversed);
    }

    private static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}

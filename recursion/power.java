package recursion;

public class power {
    public static int power(int base, int exponent){
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);

    }
    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        int result = power(base, exponent);
        System.out.println("Result: " + result);

    }
}

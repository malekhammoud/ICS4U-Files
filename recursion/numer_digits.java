package recursion;

public class numer_digits {
    public static int numDigits(int n) {
        // Base case: if n is 0, return 1 (to count the digit '0')
        if (n == 0) {
            return 0;
        }
        // Recursive case: divide n by 10 and add 1 to the count
        return 1 + numDigits(n / 10);
    }

    public static void main(String[] args) {
        int number = 123456435;
        int result = numDigits(number);
        System.out.println("Number of digits in " + number + " is: " + result);
    }
}

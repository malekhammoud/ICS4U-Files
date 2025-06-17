package recursion;

public class Towers_Hanoi {
    public static void moveDisks(int n, char source, char destination, char auxiliary) {
        if(n ==0){
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        } else {
            moveDisks(n-1, source, destination, auxiliary);
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            moveDisks(n-1, source, auxiliary, destination);
        }
    }
    public static void main(String[] args) {
        int n = 25;
        char source = 'A';
        char destination = 'C';
        char auxiliary = 'B';
        System.out.println("The sequence of moves involved in the Tower of Hanoi are:");
        moveDisks(n, source, destination, auxiliary);
    }
}

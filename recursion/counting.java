package recursion;

public class counting {
    public static int counting(int n, int i){
        if (i >= n) {
            return n;
        }
        System.out.print(i + " ");
        return counting(n, i+1);
    }
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(counting(n, 1));
    }
}

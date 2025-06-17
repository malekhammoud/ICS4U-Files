package searching;

/**
 *Consider the array nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9}.
 * Modify the binary search algorithm to report how many times the value 5 occurs in nums.
 * (HINT: If you find the position of the first occurrence and the position of the last occurrence,
 * then the number of occurrences is last - first + 1)
 */

/**
 * , 2, 5, 5, 5, 6, 6, 8, 9, 9, 9
 */
public class binarycount {
    static int binary_bottom(int[] items, int goal, int start, int end) {
        if (start > end) return -1;
        else {
            int middle = (start + end) / 2;
            if (items[middle] ==  goal) {
                if (middle-1 <= start) return start;
                if (items[middle-1] != goal) return middle;
                return binary_bottom(items, goal, start, middle-1);
            } else if (goal < items[middle]) {
                return binary_bottom(items, goal, start, middle-1);
            } else {
                return binary_bottom(items, goal, middle+1, end);
            }
        }
    }
    static int binary_top(int[] items, int goal, int start, int end) {
        if (start > end) return -1;
        else {
            int middle = (start + end) / 2;
            if (items[middle] ==  goal) {
                if (middle+1 >= end) return end;
                if (items[middle+1] != goal) return middle;
                return binary_top(items, goal, middle+1, end);
                //return middle;
            } else if (goal < items[middle]) {
                return binary_top(items, goal, start, middle-1);
            } else {
                return binary_top(items, goal, middle+1, end);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 2, 5, 5, 5, 5, 5, 6, 6, 8, 8, 8, 8,8, 8, 8, 8,8, 8, 8, 8,8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9};
        int x = 5;
        int bottom = binary_bottom(arr, x, 0, arr.length - 1);
        int top = binary_top(arr, x, 0, arr.length - 1);
        System.out.println(top-bottom+1);
    }
}

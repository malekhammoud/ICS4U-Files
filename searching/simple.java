package searching;

public class simple {
    static int binarySearch(int arr[], int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) return mid;

            if (arr[mid] > x) {
                return binarySearch(arr, left, mid - 1, x);
            }
            else{
                return binarySearch(arr, mid + 1, right, x);
            }
        }
        return -1;
    }

    static int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 26, 40};
        int n = arr.length;
        int x = 26;
        int result = binarySearch(arr, 0, n - 1, x);
        result = linearSearch(arr, x);
        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element found at index " + result);
    }
}

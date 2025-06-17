package sorting;

public class quicksort {
    int partition(int[] items, int low, int high){
        int pivot = items[high];	// choose the rightmost element as the pivot
        int index = low - 1;	// index of smaller element
        int temp;	// for storing data while we swap elements
        for (int j = low; j < high; j++) {
            if (items[j] <= pivot) {
                index++;	// increment smaller element index by 1
                // swap elements index and j
                temp = items[index];
                items[index] = items[j];
                items[j] = temp;
            }
        }
        // put pivot in its sorted place
        temp = items[index+1];
        items[index+1] = items[high];
        items[high] = temp;
        return (index + 1);	// return index of partition
    }
    void quickSort(int[] items, int low, int high){
        // find the pivot element such that values to the left are smaller and to the right are larger
        if (low < high) {
            int pIndex = partition(items, low, high);
            // quick sort the left partition
            quickSort(items, low, pIndex - 1);
            // quick sort the right partition
            quickSort(items, pIndex + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] items = {10, 7, 8, 9, 1, 5};
        int n = items.length;
        quicksort q = new quicksort();
        q.quickSort(items, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int i : items) {
            System.out.print(i + " ");
        }
    }

}

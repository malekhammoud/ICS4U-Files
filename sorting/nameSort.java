package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class nameSort {
    /**
     * Sorts the data in items in ascending order.
     * @param items the data structure to be sorted.
     */
    static void selectionSort(String[] items) {
        for (int index = 0; index < items.length; index++) {
            for (int subIndex = index; subIndex < items.length; subIndex++){
                if (items[subIndex].compareTo(items[index]) < 0) {
                    String temp= items[index];
                    items[index] = items[subIndex];
                    items[subIndex] = temp;
                }
            }
        }
    }
    public static ArrayList<String> insertionSort(ArrayList<String> items) {
        int previousIndex;
        String temp;
        for (int index = 1; index < items.size(); index++) {
            temp = items.get(index);
            previousIndex = index - 1;
            while ((items.get(previousIndex).compareTo(temp) > 0) && (previousIndex > 0)) {
                items.set(previousIndex + 1, items.get(previousIndex));
                previousIndex -= 1;
            }
            if(items.get(previousIndex).compareTo(temp) > 0) {
                items.set(previousIndex + 1, items.get(previousIndex));
                items.set(previousIndex, temp);
            } else {
                items.set(previousIndex + 1, temp);
            }
        }
        return items;
    }

    public static String[] insertionSort(String[] items) {
        int previousIndex;
        String temp;
        for (int index = 1; index < items.length; index++) {
            temp = items[index];
            previousIndex = index - 1;
            while ((items[previousIndex].compareTo(temp) > 0) && (previousIndex > 0)) {
                items[previousIndex + 1] = items[previousIndex];
                previousIndex -= 1;
            }
            if(items[previousIndex].compareTo(temp) > 0) {
                items[previousIndex + 1] = items[previousIndex];
                items[previousIndex] = temp;
            } else {
                items[previousIndex + 1] = temp;
            }
        }
        return items;
    }
    public static int partition(ArrayList<String> items, int low, int high){
        String pivot = items.get(high);	// choose the rightmost element as the pivot
        int index = low - 1;	// index of smaller element
        String temp;	// for storing data while we swap elements
        for (int j = low; j < high; j++) {
            if (items.get(j).compareTo(pivot) <= 0) {
                index++;	// increment smaller element index by 1
                // swap elements index and j
                temp = items.get(index);
                items.set(index, items.get(j));
                items.set(j, temp);
            }
        }
        // put pivot in its sorted place
        temp = items.get(index+1);
        items.set(index+1, items.get(high));
        items.set(high, temp);
        return (index + 1);	// return index of partition
    }
    public static ArrayList<String> quickSort(ArrayList<String> items, int low, int high){
        // find the pivot element such that values to the left are smaller and to the right are larger
        if (low < high) {
            int pIndex = partition(items, low, high);
            // quick sort the left partition
            quickSort(items, low, pIndex - 1);
            // quick sort the right partition
            quickSort(items, pIndex + 1, high);
        }
        return items;
    }



    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        while (true) {
            String in = input.nextLine();
            if (in.charAt(0) == 'q') {
                break;
            }
            items.add(in);
        }
        quickSort(items, 0, items.size() - 1);

        System.out.println("Sorted names: ");
        for (String name : items) {
            System.out.println(name);
        }
    }
}

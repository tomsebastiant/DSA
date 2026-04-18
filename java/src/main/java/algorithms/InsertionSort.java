package algorithms;

public class InsertionSort {

    /*
     * We start with second element of the array as first element in the array is assumed to be sorted.
     * Compare second element with the first element and check if the second element is smaller then swap them.
     * Move to the third element and compare it with the first two elements and put at its correct position
     * Repeat until the entire array is sorted
     *
     * Time Complexity: Best O(n), Average O(n^2), Worst O(n^2)
     * Space Complexity: O(1)
     */

    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }
}

package algorithms;

public class QuickSelectSort {

    /*
     * Understanding the Pivot Concept
     * Think of the pivot as a number in the array that you're going to use to split the array into two parts:
     *
     * Left side: All numbers smaller than or equal to the pivot.
     * Right side: All numbers greater than the pivot.
     * The key idea is that once you place the pivot in its correct position (as if the array were fully sorted), 
     * you know exactly how many numbers are smaller than it.
     *
     * Example partition:
     * Array: [4, 2, 7, 1, 3], pivot = 3
     * Start: i = -1, j scans from left to right until the element before pivot.
     * j = 0: 4 is greater than 3, so do nothing.
     * j = 1: 2 is smaller than 3, move i to 0 and swap 4 with 2 -> [2, 4, 7, 1, 3]
     * j = 2: 7 is greater than 3, so do nothing.
     * j = 3: 1 is smaller than 3, move i to 1 and swap 4 with 1 -> [2, 1, 7, 4, 3]
     * Finally, swap pivot 3 with the element at i + 1 -> [2, 1, 3, 4, 7]
     * Here, 3 is in its sorted position, smaller values are on the left, and greater values are on the right.
     *
     * Quick Sort Time Complexity: Best O(n log n), Average O(n log n), Worst O(n^2)
     * Quick Sort Space Complexity: Best O(log n), Average O(log n), Worst O(n)
     * Quick Select Time Complexity: Best O(n), Average O(n), Worst O(n^2)
     * Quick Select Space Complexity: Best O(log n), Average O(log n), Worst O(n)
     */

    public static int kthSmallest(int[] arr, int k) {
        return quickselect(arr,0,arr.length-1,k);
    }

    public static int[] sort(int[] arr) {
        return quicksort(arr,0,arr.length-1);
    }

    public static int[] quicksort(int arr[],int l, int r){
            if(l<=r){
                // Partition places the pivot at its correct sorted position.
                int pi = partition(arr,l,r);

                // Recursively sort elements smaller than the pivot.
                quicksort(arr,l,pi-1);

                // Recursively sort elements greater than the pivot.
                quicksort(arr,pi+1,r);
            }
        return arr;
    }

    private static int quickselect(int arr[],int l, int r, int k){
        if(l<=r){
            int pi = partition(arr,l,r);
            if(pi>(k-1)){
                return quickselect(arr,l,pi-1,k);
            } else if (pi<k-1){
                return quickselect(arr,pi+1,r,k);
            } else {
                return arr[pi];
            }
        }
        return -1;
    }

    private static int partition(int arr[],int l, int r){
        // Use the last element as the pivot.
        int pivot = r;
        int i =l-1;

        // Move all elements smaller than the pivot before it.
        for(int j=l;j<r;j++){
            if(arr[j]<arr[pivot]){
                i++;
                swap(arr,i,j);
            }
        }

        // Place the pivot between the smaller and greater elements.
        swap(arr,i+1,pivot);
        return i+1;
    }



    private static void swap(int arr[],int i, int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

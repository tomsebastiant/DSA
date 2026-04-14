package algorithms;

public class QuickSelectSort {

//Understanding the Pivot Concept
//    Think of the pivot as a number in the array that you're going to use to split the array into two parts:
//
//    Left side: All numbers smaller than or equal to the pivot.
//    Right side: All numbers greater than the pivot.
//    The key idea is that once you place the pivot in its correct position (as if the array were fully sorted), you know exactly how many numbers are smaller than it.

    public static int kthSmallest(int[] arr, int k) {
        return quickselect(arr,0,arr.length-1,k);
    }

    public static int[] sort(int[] arr) {
        return quicksort(arr,0,arr.length-1);
    }

    public static int[] quicksort(int arr[],int l, int r){
            if(l<=r){
                int pi = partition(arr,l,r);
                quicksort(arr,l,pi-1);
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
        int pivot = r;
        int i =l-1;
        for(int j=l;j<=r;j++){
            if(arr[j]<arr[pivot]){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,pivot);
        return i+1;
    }



    private static void swap(int arr[],int i, int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

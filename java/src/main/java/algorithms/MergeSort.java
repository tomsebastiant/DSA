package algorithms;

public class MergeSort {


//    Merge sort is a popular sorting algorithm known for its efficiency and stability. It follows the divide-and-conquer approach
//    to sort a given array of elements.
//
//    Divide: Divide the list or array recursively into two halves until it can no more be divided.
//    Conquer: Each subarray is sorted individually using the merge sort algorithm.
//    Merge: The sorted subarrays are merged back together in sorted order. The process continues until all elements from
//    both subarrays have been merged.
//
//    Divide:
//
//
//            [38, 27, 43, 10]  is divided into  [38, 27  ] and  [43, 10]  .
//            [38, 27]  is divided into  [38]  and  [27]  .
//            [43, 10]  is divided into  [43]  and  [10]  .
//    Conquer:
//
//
//          [38]  is already sorted.
//          [27]  is already sorted.
//          [43]  is already sorted.
//          [10]  is already sorted.
//            Merge:
//
//
//    Merge  [38]  and  [27]  to get  [27, 38] .
//    Merge  [43]  and  [10]  to get  [10,43] .
//    Merge  [27, 38]  and  [10,43]  to get the final sorted list  [10, 27, 38, 43]
//    Therefore, the sorted list is  [10, 27, 38, 43] .
//
//    Given an integer array arr[] of size n, find the inversion count in the array. Two array elements arr[i]
//    and arr[j] form an inversion if arr[i] > arr[j] and i < j.
//
//    While merging the two halves back together, we also count how many elements from the left half array are greater than elements
//    from the right half array, as these represent cross inversions (i.e., element from the left half of the array is greater than
//    an element from the right half during the merging process in the merge sort algorithm). Finally, we sum the inversions
//    from the left half, right half, and the cross inversions to get the total number of inversions in the array. This approach
//    efficiently counts inversions while sorting the array.

    static int inversionCount(int arr[]) {
        int temp[]=new int[arr.length];
        return mergeSort(arr,temp,0,arr.length-1);
    }

    public static int [] sort(int arr[]) {
        int temp[]=new int[arr.length];
        mergeSort(arr,temp,0,arr.length-1);
        return arr;
    }

    public static int mergeSort(int arr[],int temp[],int l, int r){
        if(l>=r){
            return 0;
        }
        int mid = (l+r)/2;
        int invCount = mergeSort(arr,temp,l,mid);
        invCount += mergeSort(arr,temp,mid+1,r);
        invCount += merge(arr,temp,l,mid,r);
        return invCount;
    }

    public static int merge(int arr[],int temp[],int l,int mid, int r){
        int count = 0;
        int i=l;
        int j=mid+1;
        int k=l;
        while(i<=mid && j<= r){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid-i+1;
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<= r){
            temp[k++] = arr[j++];
        }

        for(int idx = l; idx<=r; idx++){
            arr[idx] = temp[idx];
        }
        return count;
    }
}

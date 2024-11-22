public class QuickSelectSort {
    public static int kthSmallest(int[] arr, int k) {


        return quickselect(arr,0,arr.length-1,k);
    }

    public static int partition(int arr[],int l, int r){
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

    public static int quickselect(int arr[],int l, int r, int k){
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

    public static void swap(int arr[],int i, int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

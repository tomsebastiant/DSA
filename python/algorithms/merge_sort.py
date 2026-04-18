class MergeSort:
    """
    Merge sort divides the array into two halves, sorts each half recursively,
    and then merges the sorted halves back together.

    This implementation also counts inversions:
    total number of pairs (i, j) where i < j and arr[i] > arr[j].

    Time Complexity: O(n log n)
    Space Complexity: O(n)
    """

    @staticmethod
    def inversion_count(arr):
        # Initialize temp once here instead of inside merge to avoid repeated initializations.
        temp = [0] * len(arr)
        return MergeSort.merge_sort(arr, temp, 0, len(arr) - 1)

    @staticmethod
    def sort(arr):
        # Initialize temp once here instead of inside merge to avoid repeated initializations.
        temp = [0] * len(arr)
        MergeSort.merge_sort(arr, temp, 0, len(arr) - 1)
        return arr

    @staticmethod
    def merge_sort(arr, temp, left, right):
        if left >= right:
            return 0

        mid = (left + right) // 2
        inv_count = MergeSort.merge_sort(arr, temp, left, mid)
        inv_count += MergeSort.merge_sort(arr, temp, mid + 1, right)
        inv_count += MergeSort.merge(arr, temp, left, mid, right)
        return inv_count

    @staticmethod
    def merge(arr, temp, left, mid, right):
        count = 0
        i = left
        j = mid + 1
        k = left

        while i <= mid and j <= right:
            if arr[i] <= arr[j]:
                temp[k] = arr[i]
                i += 1
            else:
                temp[k] = arr[j]
                j += 1
                # Since arr[i] is already greater than arr[j], and the left half
                # is sorted, all remaining elements from arr[i] to arr[mid] are
                # also greater than arr[j]. Count them all at once.
                count += mid - i + 1
            k += 1

        while i <= mid:
            temp[k] = arr[i]
            i += 1
            k += 1

        while j <= right:
            temp[k] = arr[j]
            j += 1
            k += 1

        for idx in range(left, right + 1):
            arr[idx] = temp[idx]

        return count

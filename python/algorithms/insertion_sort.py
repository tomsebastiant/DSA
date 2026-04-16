class InsertionSort:
    # We start with second element of the array as first element in the array is assumed to be sorted.
    # Compare second element with the first element and check if the second element is smaller then swap them.
    # Move to the third element and compare it with the first two elements and put at its correct position.
    # Repeat until the entire array is sorted.

    def sort(self, arr):
        n = len(arr)
        for i in range(1, n):
            key = arr[i]
            j = i - 1

            while j >= 0 and arr[j] > key:
                arr[j + 1] = arr[j]
                j -= 1

            arr[j + 1] = key

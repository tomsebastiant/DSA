class QuickSelectSort:
    """
    Understanding the Pivot Concept
    Think of the pivot as a number in the array that you're going to use to split the array into two parts:

    Left side: All numbers smaller than or equal to the pivot.
    Right side: All numbers greater than the pivot.
    The key idea is that once you place the pivot in its correct position (as if the array were fully sorted),
    you know exactly how many numbers are smaller than it.

    Example partition:
    Array: [4, 2, 7, 1, 3], pivot = 3
    Start: i = -1, j scans from left to right until the element before pivot.
    j = 0: 4 is greater than 3, so do nothing.
    j = 1: 2 is smaller than 3, move i to 0 and swap 4 with 2 -> [2, 4, 7, 1, 3]
    j = 2: 7 is greater than 3, so do nothing.
    j = 3: 1 is smaller than 3, move i to 1 and swap 4 with 1 -> [2, 1, 7, 4, 3]
    Finally, swap pivot 3 with the element at i + 1 -> [2, 1, 3, 4, 7]
    Here, 3 is in its sorted position, smaller values are on the left, and greater values are on the right.

    Quick Sort Time Complexity: Best O(n log n), Average O(n log n), Worst O(n^2)
    Quick Sort Space Complexity: Best O(log n), Average O(log n), Worst O(n)
    Quick Select Time Complexity: Best O(n), Average O(n), Worst O(n^2)
    Quick Select Space Complexity: Best O(log n), Average O(log n), Worst O(n)
    """

    @staticmethod
    def kth_smallest(arr, k):
        return QuickSelectSort.quickselect(arr, 0, len(arr) - 1, k)

    @staticmethod
    def sort(arr):
        return QuickSelectSort.quicksort(arr, 0, len(arr) - 1)

    @staticmethod
    def quicksort(arr, left, right):
        if left <= right:
            # Partition places the pivot at its correct sorted position.
            pivot_index = QuickSelectSort.partition(arr, left, right)

            # Recursively sort elements smaller than the pivot.
            QuickSelectSort.quicksort(arr, left, pivot_index - 1)

            # Recursively sort elements greater than the pivot.
            QuickSelectSort.quicksort(arr, pivot_index + 1, right)

        return arr

    @staticmethod
    def quickselect(arr, left, right, k):
        if left <= right:
            pivot_index = QuickSelectSort.partition(arr, left, right)

            if pivot_index > k - 1:
                return QuickSelectSort.quickselect(arr, left, pivot_index - 1, k)
            if pivot_index < k - 1:
                return QuickSelectSort.quickselect(arr, pivot_index + 1, right, k)
            return arr[pivot_index]

        return -1

    @staticmethod
    def partition(arr, left, right):
        # Use the last element as the pivot.
        pivot = right
        i = left - 1

        # Move all elements smaller than the pivot before it.
        for j in range(left, right):
            if arr[j] < arr[pivot]:
                i += 1
                QuickSelectSort.swap(arr, i, j)

        # Place the pivot between the smaller and greater elements.
        QuickSelectSort.swap(arr, i + 1, pivot)
        return i + 1

    @staticmethod
    def swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]

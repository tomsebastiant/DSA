class SelectionSort:
    """
    It sorts an array by repeatedly selecting the smallest (or largest) element from the
    unsorted portion and swapping it with the first unsorted element.
    This process continues until the entire array is sorted.

    Time Complexity: Best O(n^2), Average O(n^2), Worst O(n^2)
    Space Complexity: O(1)
    """

    @staticmethod
    def selection_sort(arr):
        n = len(arr)
        for i in range(n - 1):
            # Assume the current position holds
            # the minimum element
            min_idx = i

            # Iterate through the unsorted portion
            # to find the actual minimum
            for j in range(i + 1, n):
                if arr[j] < arr[min_idx]:
                    # Update min_idx if a smaller element
                    # is found
                    min_idx = j

            # Move minimum element to its
            # correct position
            arr[i], arr[min_idx] = arr[min_idx], arr[i]

class E_ContainsDuplicate:
    """
    LC: 217
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.

    Approach: Use a set to keep track of unique elements.

    Tags: Array
    """

    def contains_duplicate(self, nums):
        unique = set()
        for num in nums:
            if num in unique:
                return True
            unique.add(num)
        return False


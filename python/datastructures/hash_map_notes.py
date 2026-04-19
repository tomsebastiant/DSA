class HashMapNotes:
    def frequency_count(self, nums):
        freq = {}
        for n in nums:
            freq[n] = freq.get(n, 0) + 1
        return freq

    def two_sum(self, nums, target):
        seen = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in seen:
                return [seen[complement], i]
            seen[num] = i
        return []

    def subarray_sum(self, nums, target):
        prefix_count = {0: 1}
        prefix_sum = 0
        count = 0

        for num in nums:
            prefix_sum += num
            count += prefix_count.get(prefix_sum - target, 0)
            prefix_count[prefix_sum] = prefix_count.get(prefix_sum, 0) + 1

        return count


class M_NonOverlappingIntervals:
    """
    LC: 435
    Tags: Greedy
    https://leetcode.com/problems/non-overlapping-intervals
    Given an array of intervals where intervals[i] = [starti, endi],
    return the minimum number of intervals you need to remove to make the rest
    of the intervals non-overlapping.

    Approach: Sort by end time and keep the interval that finishes earliest.
    """

    def erase_overlap_intervals(self, intervals):
        intervals.sort(key=lambda x: x[1])
        count = 0
        end = intervals[0][1]

        for start, finish in intervals[1:]:
            if start < end:
                count += 1
            else:
                end = finish
        return count


class M_QueueBuildWithHeight:
    """
    LC: 406
    Tags: Greedy
    https://leetcode.com/problems/queue-reconstruction-by-height
    Each person[i] = [hi, ki] represents height hi with exactly ki people in front
    who have height greater than or equal to hi.

    Approach: Sort by height descending and k ascending, then insert each person at index k.
    """

    def reconstruct_queue(self, people):
        people.sort(key=lambda p: (-p[0], p[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
        return result


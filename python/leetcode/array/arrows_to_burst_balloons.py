class M_ArrowsToBurstBalloons:
    """
    LC: 452
    Tags: Greedy
    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
    There are some spherical balloons taped onto a flat wall that represents the XY-plane.
    The balloons are represented as a 2D integer array points where points[i] = [xstart, xend].

    Arrows can be shot vertically from different points along the x-axis.
    A balloon is burst by an arrow shot at x if xstart <= x <= xend.

    Approach: Sort by end time. If the next balloon starts after the current arrow's reach,
    use a new arrow and update the active end.
    """

    def find_min_arrow_shots(self, points):
        if not points:
            return 0

        points.sort(key=lambda p: p[1])
        arrows = 1
        end = points[0][1]

        for start, finish in points[1:]:
            if start > end:
                arrows += 1
                end = finish
        return arrows


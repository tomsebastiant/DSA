class M_HandOfStraights:
    """
    LC: 846
    Tags: Greedy
    Tags: Array
    https://leetcode.com/problems/hand-of-straights
    Alice has some number of cards and she wants to rearrange the cards into groups so that each
    group is of size groupSize, and consists of groupSize consecutive cards.

    Approach: Count card frequencies, repeatedly start from the smallest available card,
    and consume consecutive runs of length groupSize.
    """

    def is_n_straight_hand(self, hand, group_size):
        if len(hand) % group_size != 0:
            return False

        counts = {}
        for card in hand:
            counts[card] = counts.get(card, 0) + 1

        while counts:
            first = min(counts)
            for card in range(first, first + group_size):
                if card not in counts:
                    return False
                if counts[card] == 1:
                    del counts[card]
                else:
                    counts[card] -= 1
        return True


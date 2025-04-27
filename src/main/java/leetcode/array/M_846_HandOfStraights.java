package leetcode.array;

import java.util.TreeMap;

/**
 Tags: #Greedy
 https://leetcode.com/problems/hand-of-straights
 Alice has some number of cards and she wants to rearrange the cards into groups so that each
 group is of size groupSize, and consists of groupSize consecutive cards.

 Given an integer array hand where hand[i] is the value written on the ith card and an integer
 groupSize, return true if she can rearrange the cards, or false otherwise.

 Approach: The hand size is not divisible by groupsize we exit
 We're using a TreeMap to have a sorted map containing the counts of each card.
 We iterate from the first key and group the cards and remove them from the TreeMap
 If at some point we dont have the required cards, we return false.

 */
public class M_846_HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        //TreeMap ensure that the keys are sorted. Also gives the method firstKey
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first; i < first + groupSize; i++) {
                if (!map.containsKey(i)) return false;
                int count = map.get(i);
                if (count == 1) {
                    map.remove(i);
                } else {
                    map.put(i, count - 1);
                }
            }
        }
        return true;
    }
}

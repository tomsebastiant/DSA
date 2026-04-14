package leetcode.bfsdfs;

import java.util.List;
import java.util.Stack;

/**
 https://leetcode.com/problems/keys-and-rooms
 There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

 When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

 Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 return true if you can visit all the rooms, or false otherwise..

 Approach 1:  Use stack to effectively do a BFS and keep marking the visited rooms as we get the keys
 Approach 2: You can use recursion to do DFS and keep track of the visited rooms
 */
public class M_841_KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0]=true;
        Stack<Integer> keys = new Stack<>();
        keys.add(0);
        while(!keys.isEmpty()){
            int key=keys.pop();
            for(int new_key:rooms.get(key)){
                if(!visited[new_key]){
                    visited[new_key] = true;
                    keys.add(new_key);
                }

            }
        }

        for(boolean visit:visited){
            if(!visit) return false;
        }
        return true;
    }
}

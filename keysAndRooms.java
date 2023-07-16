//Leetcode: 841. Keys and Rooms
import java.util.*;
class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if(rooms == null)
            return false;

        //having a boolean list
        boolean list[] = new boolean[rooms.size()];
        //marking first one as visited since
        list[0] = true;

        //DFS approach
        //we need a stack to store the keys that we have
        Stack<Integer> keys = new Stack();

        //insert the first room's key
        keys.add(0);

        while(!keys.isEmpty()){
            //go into the room with the key at the top of the stack
            int key = keys.pop();

            //get the keys in the room
            for(int k : rooms.get(key)){
                //visit if not visited
                if(!list[k]){
                    //mark as visited
                    list[k] = true;
                    //add to our keys this rooms key
                    //so that we can get that room's keys
                    keys.add(k);
                }
                //if already visited, we dont have to add its keys again
            }
        }

        //verify rooms visited
        for(boolean r : list){
            //found a room not visited
            if(!r){
                return false;
            }
        }

        return true;
    }

}
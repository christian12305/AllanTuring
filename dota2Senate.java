import java.util.*;
// Leetcode: 649. Dota2 Senate

class Solution {
    public String predictPartyVictory(String senate) {


        //Radiant -> R
        //Dire -> D
        //return Radiant or Dire

        // ROUND BASED PROCEDURE
        //  THATS WHY QUEUE IS USED
        //
        //having 2 queues, store the index of each CHARACTER in its pertaining queue
        //  this is because they vote in a ROUND BASED type of order

        //while both queues have at least 1 item
            //get the first element in the queue from both and compare
            //the one with the lower value will get to the back of the queue
            //the other one is not added, eliminating it
        //return the name of one that is not empty

        Queue<Integer> Rqueue = new LinkedList<>();
        Queue<Integer> Dqueue = new LinkedList<>();

        //Storing e/o of the indexes of the senators
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'D'){
                Dqueue.add(i);
            }else{
                Rqueue.add(i);
            }
        }

        //Decide who leaves with the one before it eliminating the one after
        //meaning lower index wins
        while(!Rqueue.isEmpty() && !Dqueue.isEmpty()){
            int r = Rqueue.remove();
            int d = Dqueue.remove();

            //D is eliminateed
            //R goes to the tail of the queue
            //  the tail of the queue is starts at next round
            //  next round will start after the last senator speaks
            //  therefore, after the last index of senate
            //  In turn, this updates the position of senator
            if(r < d){
                Rqueue.add(r + senate.length());
            //R is eliminated
            //D goes to the tail of the queue
            }else if(d < r){
                Dqueue.add(d + senate.length());
            }


        }

        //Whichever is not empty is returneed
        if(Rqueue.isEmpty()){
            return "Dire";
        }else
            return "Radiant";

    }
}
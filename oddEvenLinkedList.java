/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// LeetCode: 328. Odd Even Linked List
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // #ITERATE NODES
        // #   IF i % 2 == 0
        // #       ADD TO EVEN LIST
        // #   ELSE
        // #       ADD TO ODD LIST
        // #LINK THE LAST ELEMENT OF THE ODD LIST TO THE HEAD OF THE EVEN LIST

        ListNode evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;

        ListNode temp = head;

        int count = 1;

        //if we havent reached the end
        while(temp != null){
            if(count++ % 2 == 0){
                //first even
                if(evenStart == null){
                    evenStart = evenEnd = temp;
                //rest of even
                }else{
                    evenEnd.next = temp;
                    evenEnd = evenEnd.next;
                }
                
            }else{
                //first odd
                if(oddStart == null){
                    oddStart = oddEnd = temp;
                //rest of odd
                }else{
                    oddEnd.next = temp;
                    oddEnd = oddEnd.next;
                }
            }
            //move to next node
            temp = temp.next;
        }//while

        //Means we couldnt divide into odd or even
        if(oddStart == null || evenStart == null){
            return head;
        }

        //Unify both lissts
        oddEnd.next = evenStart;
        evenEnd.next = null;

        //Attach to our original head
        head = oddStart;

        return head;
    }

    //Auxiliary class
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


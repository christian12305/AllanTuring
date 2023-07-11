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

 // Leetcode: 206. Reverse Linked List
class Solution {
    public ListNode reverseList(ListNode head) {

        //[1,2,3,4,5]
        //
        //curr = 3, next = 4
        //curr.next = newList = [2,1]
        //newList = curr = [3,2,1]
        //curr = next

        //iterating the list
            //having an auxiliary new list pointer
            //store the next of the current element
            //add the new list pointer to the current's next
            //update the new list
            //update the current element to the next

        ListNode curr = head;
        
        //newList starts at null to reverse it
        ListNode newList = null;

        while(curr != null){
            //store the rest of the old list
            ListNode next = curr.next;

            //attaches the list the the next of the head
            curr.next = newList;

            //updates the head of the newList
            newList = curr;

            //Moves iteration
            curr = next;

        }

        return newList;

    }

      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
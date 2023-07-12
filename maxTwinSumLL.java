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
// Leetcode: 2130. Maximum Twin Sum of a Linked List
import java.lang.Math;
class Solution {
    public int pairSum(ListNode head) {
        //length is even
        // i and (n-i)- 1 nodes are twins
        //  get the max sum of the twins
        //  having a list from 0th to the middle-1
        //  and a REVERSED second list from middle to length -1
        //      pair the heads of the lists, sum them and store max

        ListNode list1 = head;
        
        //to find middle, using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list2 = slow;

        //Reverse list2
        ListNode newList = null;
        while(list2 != null){
            ListNode next = list2.next;

            list2.next = newList;

            newList = list2;

            list2 = next;

        }

        list2 = newList;

        //sum heads
        //storing max
        int max = Integer.MIN_VALUE;
        while(list1 != null && list2 != null){
            int sum = list1.val + list2.val;

            max = Math.max(max, sum);

            list1 = list1.next;
            list2 = list2.next;
        }

        

        return max;
        
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
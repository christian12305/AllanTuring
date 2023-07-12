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
import java.lang.Math;
class Solution {
    public void reorderList(ListNode head) {
        //reorder list as such:
        // 0 , n, 1, n-1, 2, n-2
        //
        //divide list in 2
        //  (mid point is ceiling of length/2)
        //
        //construct resulting list with list1, list2, list1, list2...
        //


        //midpoint will be found using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is the middle node


        
        //first list
        ListNode list1 = head;
        ListNode list1T = slow;

        //second list
        //head of second list
        ListNode list2 = slow.next;

        //cut first list
        slow.next = null;


        //to reverse the second list
        ListNode newList = null;

        while(list2 != null){
            //point to new list
            ListNode next = list2.next;
            list2.next = newList;
            //make it the head of the new list
            newList = list2;
            //update remaining list
            list2 = next;
        }

        //update our list2 with our new list
        list2 = newList;

        //construct resulting list (0,n,1,n-1,2,n-2...)
        ListNode resultList = list1;

        while(list2 != null){

            //list1
            //[1,5,2,3]

            //list 2
            //[4]


            //-> 2,3]
            //[1,5,2,3]

            //one element from list one, second from list2
            //store the rest of list1
            ListNode next = list1.next;
            //put the node from list2 next to it
            list1.next = list2;

            //move head2 forward on second list
            list2 = list2.next;
            //new head for list1
            list1 = list1.next;
            
            //attach node to the rest of the resultlist
            list1.next = next;
            //new head for list 1(again)
            list1 = list1.next;
        }

        head = resultList;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
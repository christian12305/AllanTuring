#Leetcode: 2095. Delete the Middle Node of a Linked List
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteMiddle(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """

        #GET THE LENGTH N OF LIST
        #
        #HAVING A COUNTER AT 0
        #ITERATE THE LIST
        #INCREMENT COUNTER PER NODE VISITED
        #IF COUNTER IS (// ES MATH.FLOOR) N//2
        #   REMOVE NODE BY CONNECTING
        #   NODE[i-1] and NODE[i+1]
        #RETURN THE NODE HEAD

        #base case
        if head.next == None:
            return None

        temp = head
        length = 0


        while temp:
            length += 1
            temp = temp.next

        middle = (length // 2) -1

        counter = 0

        temp = head

        while temp:
            counter+=1
            if counter == middle:
                #connect temp a temp.next.next
                #temp.next would then be the middle
                temp.next = temp.next.next
        
        return head
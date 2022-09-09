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


// reference : https://www.youtube.com/watch?v=BE0hruM5O5U

class Solution {
    public ListNode reverseBetween(ListNode head, int start, int end) {
        if(head == null || start == end)
            return head;
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode nodeBeforeSublist = fakeHead;
        
        int position = 1;
        while(position < start){
            nodeBeforeSublist = nodeBeforeSublist.next;
            position++;
        }
        
        ListNode workingPtr = nodeBeforeSublist.next;
        
        while(start < end){
            ListNode nodeToBeExtracted = workingPtr.next;
            workingPtr.next = nodeToBeExtracted.next;
            nodeToBeExtracted.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = nodeToBeExtracted;
            
            start++;
        }
        
        return fakeHead.next;
    }
}
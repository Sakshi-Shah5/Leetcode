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


/* 
approach : 
we can reverse the 2nd half of the LL eg 1 2 2 1 will become 1 2 1 2 and then we can check 1st half of the LL with 2nd half comparing each node individually.

via slow and fast pointer approach, we can find the mid of the LL cuz that mid could act as the starting of the 2nd half of the LL

*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;
        
        
        //define slow and fast 
        ListNode slow = head;
        ListNode fast = head;
        
        
        //move slow and fast in the right position
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the 2nd half of the Linked List
        ListNode left = head;
        ListNode right = reverse(slow);
        
        //check if it is a palindrome
        while(right != null){
            if(left.val == right.val){
                left = left.next;
                right = right.next;
            }
            else{
                return false;
            }
        }
        return true;
        
        
    }
    
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        //reverse 2nd half 
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
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
class Solution {
    public void reorderList(ListNode head) {
        ListNode firstHalf=head;
        // ListNode secondHalf=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode secondHalf=slow.next;
        slow.next=null;
        // Now we have to reverse the second half
        ListNode prev=null;
        ListNode curr=secondHalf;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        while(firstHalf!=null && prev!=null){
            ListNode nextTemp1=firstHalf.next;
            ListNode nextTemp2=prev.next;
            firstHalf.next=prev;
            prev.next=nextTemp1;
            firstHalf=nextTemp1;
            prev=nextTemp2;
        }
        // return 
    }
}
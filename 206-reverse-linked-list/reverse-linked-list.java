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
    public ListNode reverseList(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode currentNode=temp;
            ListNode nextNode=temp.next;
            currentNode.next=prev;
            prev=currentNode;
            temp=nextNode;
        }
        return prev;
        
    }
}
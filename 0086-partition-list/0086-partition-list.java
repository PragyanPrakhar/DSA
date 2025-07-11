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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode one=new ListNode(-1);
        ListNode temp=head;
        ListNode ans=one;
        while(temp!=null){
            if(temp.val<x){
                one.next=new ListNode(temp.val);
                one=one.next;
                temp.val=-101;
            }
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.val!=-101){
                one.next=new ListNode(temp.val);
                one=one.next;
            }
            temp=temp.next;
        }
        return ans.next;

    }
}
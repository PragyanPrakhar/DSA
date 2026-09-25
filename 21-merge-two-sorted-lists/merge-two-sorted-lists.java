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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode();
        ListNode r=res;
        rec(r,list1,list2);
        return res.next;
    }
    private void rec(ListNode res , ListNode list1 , ListNode list2){
        if(list1==null || list2==null){
            if(list1==null){
                while(list2 != null){
                    res.next=list2;
                    list2=list2.next;
                    res=res.next;
                }
            }
            if(list2 == null){
                while(list1 != null){
                    res.next=list1;
                    list1=list1.next;
                    res=res.next;
                }
            }
            return;
        }
        if(list1.val >= list2.val){
            res.next=list2;
            rec(res.next,list1,list2.next);
        }
        if(list1.val < list2.val){
            res.next=list1;
            rec(res.next,list1.next,list2);
        }
    }
}
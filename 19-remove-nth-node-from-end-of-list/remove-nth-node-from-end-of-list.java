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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNumberOfNodes = 0;
        ListNode temp = head;

        // Count total nodes
        while (temp != null) {
            totalNumberOfNodes++;
            temp = temp.next;
        }

        // If head is to be removed
        if (n == totalNumberOfNodes) {
            return head.next;
        }

        // Reset temp to head
        temp = head;
        int nodeToBeRemoved = totalNumberOfNodes - n;
        int curr = 0;

        while (curr < nodeToBeRemoved - 1) {
            curr++;
            temp = temp.next;
        }

        // Skip the node
        temp.next = temp.next.next;
        return head;
    }
}

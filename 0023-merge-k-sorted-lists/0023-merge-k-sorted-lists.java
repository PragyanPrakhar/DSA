class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode ls : lists) {
            while (ls != null) {
                pq.add(ls.val);
                ls = ls.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            current.next = new ListNode(pq.poll());
            current = current.next;
        }

        return dummy.next;
    }
}

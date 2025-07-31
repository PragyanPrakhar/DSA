class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeRange(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = start + (end - start) / 2;
        ListNode left = mergeRange(lists, start, mid);
        ListNode right = mergeRange(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // One list is exhausted, attach the remaining
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}

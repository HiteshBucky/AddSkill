class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //Break the temp so that we have (head temp) for left list and (slow fast) for right
        temp.next = null;

        ListNode left_list = sortList(head);
        ListNode right_list = sortList(slow);

        return merge(left_list, right_list);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode sorted_list = new ListNode(0);
        ListNode curr_node = sorted_list;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr_node.next = left;
                left = left.next;
            } else {
                curr_node.next = right;
                right = right.next;
            }
            curr_node = curr_node.next;
        }
        if (left != null) {
            curr_node.next = left;
            left = left.next;
        }
        if (right != null) {
            curr_node.next = right;
            right = right.next;
        }
        return sorted_list.next;
    }
}
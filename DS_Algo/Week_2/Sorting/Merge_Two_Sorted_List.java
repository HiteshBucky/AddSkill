class Solution {
    public ListNode mergeTwoLists(ListNode left, ListNode right) {
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head , fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null && fast.next == null) { slow = slow.next; }
        ListNode cur = slow , prev = null , next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        slow = prev;
        while (slow != null) {
            if (slow.val != head.val) { return false; }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
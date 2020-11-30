class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      
     PriorityQueue<Integer> q = new PriorityQueue<>(); 
      
     for(ListNode list : lists) {
         while(list != null) {
             q.add(list.val);
             list = list.next;
         }
     }
      
     ListNode head = new ListNode(-1);
     ListNode curr = head;   
     while(!q.isEmpty()) {
         curr.next = new ListNode(q.poll());
         curr = curr.next;
     }
      
     return head.next;
  }
}
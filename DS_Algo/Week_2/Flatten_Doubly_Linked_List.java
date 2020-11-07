class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node prev = null;
        
        while(!stack.empty()){
            Node node = stack.pop();
            if(node.next != null) stack.push(node.next);
            
            if(node.child != null){
                stack.push(node.child);
                node.child = null;
            }
            node.next = stack.empty() ? null : stack.peek();
            node.prev = prev;
            prev = node;
        }
        
        return head;        
    }
}

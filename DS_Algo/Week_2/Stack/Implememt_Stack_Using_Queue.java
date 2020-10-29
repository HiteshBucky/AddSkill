class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
        size = 0;
    }

    public void push(int x) {
        size++;
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }
        //Swap names
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop() {
        if (q1.isEmpty()) return -1;
        size--;
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    public boolean empty() {
        return size == 0;
    }
}
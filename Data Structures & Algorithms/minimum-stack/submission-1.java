class MinStack {
    private ArrayList<Integer> stack;
    private PriorityQueue<Integer> q;

    public MinStack() {
        stack = new ArrayList<>();
        q = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.add(val);
        q.offer(val);
    }

    public void pop() {
        int val = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        if (val == q.peek()) {
            System.out.println(q.peek());
            q.poll();
            System.out.println(q.peek());
            return;
        }
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        while (!q.isEmpty() && val != q.peek()) {
            q1.offer(q.poll());
        }
        if (!q.isEmpty())
            q.poll();
        while (!q1.isEmpty()) {
            q.offer(q1.poll());
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return q.peek();
    }
}
// 0-2   -2 0
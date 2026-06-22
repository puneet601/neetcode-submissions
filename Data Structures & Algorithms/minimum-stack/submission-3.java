class Pair{
    int val;
    int min;

    Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    private Stack<Pair> st;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        st.push(new Pair(val,this.min));
        if (this.min > val) {
            this.min = val;
        }
    }

    public void pop() {
        Pair pop = st.pop();
        
        if (pop.val == this.min) {
            this.min = pop.min;
        }
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return this.min;
    }
}

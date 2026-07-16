class Solution {
    class Pair{
        int val;
        int freq;
        Pair(int val, int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int start = -1, end = -1;
        int max = 0;int curr;
        Stack<Pair> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek().val] > heights[i]) {
                Pair top = st.pop();
                
                count+=top.freq;
                if (end < top.val) {
                    end = top.val;
                }
                start = top.val;
                curr = (top.freq + end - start) * heights[top.val];
                
                max = max > curr ? max : curr;
            }
            
            st.push(new Pair(i,count+1));
            count=0;
        }
        end = -1;start=-1;
        while (!st.isEmpty()) {
            Pair top = st.pop();
            if (end == -1) {
                end = top.val;
            }
            start = top.val;
            curr = (top.freq+ end - start) * heights[top.val];
            max = max > curr ? max : curr;
        }
        return max;
    }
}
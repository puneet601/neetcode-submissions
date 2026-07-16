class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = -1;
        right[n - 1] = n;
        int max = 0;
        int curr;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            left[i]=-1;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                left[i]=st.peek();
            }
            st.push(i);
        }
            st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            right[i]=n;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                right[i]=st.peek();
            }
            st.push(i);
        }
            
         max = 0;
         curr = 0;
        for (int i = 0; i < n; i++) {
            curr = heights[i] * (right[i] - left[i] - 1);
            max = max > curr ? max : curr;
        }
        return max;
    }
}
/*

*/
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n=temp.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(i);
            }else{
                int top = st.peek();
                while(temp[top]<temp[i]){
                    res[top] = i-st.pop();
                    if(st.isEmpty())
                    break;
                    top=st.peek();
                }
                st.push(i);
            }
        }
        return res;
    }
}

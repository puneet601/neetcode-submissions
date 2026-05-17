class Solution {
    public int maxProfit(int[] prices) {
        int low = 0;
        int max = 0;
        

        for(int i=1;i<prices.length;i++){

            if(prices[low]>prices[i]){
                low = i;
            }
            else if(prices[i]-prices[low]>max){
                max = prices[i]-prices[low];
            }
        }

        return max;
    }
}

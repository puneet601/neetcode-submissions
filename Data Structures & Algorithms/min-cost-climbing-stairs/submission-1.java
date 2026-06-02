class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int zero = minCostClimbingStairs(cost,0,new int[cost.length]);

        int one = minCostClimbingStairs(cost,1,new int[cost.length]);

        return Math.min(zero,one);
    }

    int minCostClimbingStairs(int[] cost, int i, int[] minCost) {
        if(i>=cost.length)
        return 0;
        if(minCost[i]!=0)
        return minCost[i];
        int one = minCostClimbingStairs(cost,i+1,minCost);
        int two = minCostClimbingStairs(cost,i+2,minCost);
        minCost[i] = Math.min(one,two)+cost[i];
        return minCost[i];
        
        
    }


}

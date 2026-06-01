class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n+1]);
    }

    private int climbStairs(int n, int steps[]) {
        if(n==1 || n==2)
        return n;
        if(steps[n-1]!=0)
        return steps[n-1];
        int one = climbStairs(n-1,steps);
        int two = climbStairs(n-2,steps);
        steps[n-1]= one+two;
        return steps[n-1];
    }
}

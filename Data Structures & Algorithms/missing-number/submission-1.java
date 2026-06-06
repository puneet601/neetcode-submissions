class Solution {
    public int missingNumber(int[] nums) {
        int max = 0;
        int currSum = 0;
        boolean zero = false;

        for(int i:nums){
            if(i==0)
            zero=true;
            if(i>max)
            max=i;
            currSum+=i;
        }
        if(zero && max!=nums.length){
            max++;
        }
        int sum = max*(max+1)/2;
        return sum-currSum;
    }
}

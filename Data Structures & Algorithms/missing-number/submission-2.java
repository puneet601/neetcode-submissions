class Solution {
    public int missingNumber(int[] nums) {
        int max=0;
        int xor = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i>max)
            max=i;
            xor^=nums[i];
        }
        xor^=nums[0];
        int n = max > nums.length ? max : nums.length;
        
        for(int i=1;i<=n;i++){
            
                xor^=i;
        }
        return xor;
    }
}

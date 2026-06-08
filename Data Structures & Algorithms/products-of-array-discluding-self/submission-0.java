class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int suffix[] = new int[n];
        int product = 1;
        suffix[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i+1];
            System.out.println(suffix[i]);
        }

        product = 1;
        for(int i=1;i<n;i++){
            product*=nums[i-1];
            suffix[i] *= product;
        }
        return suffix;
    }
}  

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l =0;
        int r=n-1;
        int min = nums[l];
        while(l<r){
            int mid = l+r;
            mid/=2;
            min = min < nums[mid] ? min : nums[mid];
            min = min < nums[r] ? min : nums[r];
            if(nums[r]<nums[mid]){
                l=mid+1;
            }else if(nums[r]>nums[mid]){
                r=mid;
            }
        }
        return min;
    }
}

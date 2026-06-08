class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int len = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                len++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                max = max > len ? max : len;
                len = 1;
            }
        }
        max = max > len ? max : len;
        return max > 0 ? max : 0;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if(nums[i]>0)
            break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    j++;
                    
                }
            }
        }

        return res;
    }
}

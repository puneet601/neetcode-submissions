class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,new ArrayList<>(),0,0,target);
        return res;
    }

    void dfs(int[] nums, List<Integer> combo, int i, int sum, int t) {
        if (sum == t) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if (i >= nums.length)
            return;

        if (sum > t)
            return;

        

        combo.add(nums[i]);
        dfs(nums, combo, i , sum + nums[i], t);
        // dfs(nums, combo, i, sum + nums[i], t);

        combo.remove(combo.size() - 1);
        dfs(nums, combo, i + 1, sum , t);
    }
}

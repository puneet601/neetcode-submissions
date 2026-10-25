class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        subsets(nums, res, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    void subsets(int nums[], HashSet<List<Integer>> res, int i, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        if (i == nums.length)
            return;
        
        curr.add(nums[i]);
        subsets(nums, res, i + 1,curr);
        curr.remove(curr.size()-1);
        subsets(nums, res, i + 1,curr);
    }
}

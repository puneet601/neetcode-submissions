class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Boolean> used = new HashMap<>();
        for (int i : nums) {
            used.put(i, false);
        }
        permute(nums, res, new ArrayList<>(), used);
        return res;
    }

    void permute(int[] nums, List<List<Integer>> res, List<Integer> curr, HashMap<Integer, Boolean> used) {
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used.get(nums[i])) {
                curr.add(nums[i]);
                used.put(nums[i], true);

            permute(nums, res, curr, used);
            
                curr.remove(curr.size()-1);
                used.put(nums[i], false);
            }
        }
    }
}

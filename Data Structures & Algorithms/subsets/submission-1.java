class Solution {
    HashSet<String> subsets = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, new StringBuilder(), -1);
        for(String s: subsets){
            String setStr[] = s.split(",");
            List<Integer> curr = new ArrayList<>();
            for(String st: setStr){
                if(st.isEmpty())
                continue;
                curr.add(Integer.parseInt(st));
            }
            res.add(curr);
        }
        return res;
    }

    void subsets(int[] nums, StringBuilder set, int i) {
        if (i > nums.length)
            return;
        if (i < 0) {
            subsets.add(set.toString());
            subsets(nums, set, i + 1);
            return;
        }
        String s = set.toString();
        subsets.add(s);
        subsets(nums, set, i + 1);
        StringBuilder st = new StringBuilder(s);
        if(i<nums.length)
        st.append("," + nums[i]);
        subsets(nums, st, i + 1);
    }
}

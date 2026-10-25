public class Solution {
    

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        generateSubsets(candidates, target, 0, new ArrayList<>(), 0,res);
        return new ArrayList<>(res);
    }

    private void generateSubsets(int[] candidates, int target, int i, List<Integer> cur, int total,List<List<Integer>> res ) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (total > target || i == candidates.length || candidates[i]>target) {
            return;
        }

        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j-1]==candidates[j])
            continue;

            if(candidates[j]>target-total)
            break;
cur.add(candidates[j]);
        generateSubsets(candidates, target, j + 1, cur, total + candidates[j],res);
        cur.remove(cur.size() - 1);

        }

        

    }
}
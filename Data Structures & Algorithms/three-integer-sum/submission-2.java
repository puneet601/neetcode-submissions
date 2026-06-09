class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j=i+1;
                int k = n-1;
                while(j<k){
                    if(set.contains(nums[i]+","+nums[j]+","+nums[k])){
                    j++;
                    k = n-1;
                    continue;
                    }
                    if(nums[j]+nums[k]==-nums[i]){
                        set.add(nums[i]+","+nums[j]+","+nums[k]);
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                        res.add(temp);
                    }else if(nums[j]+nums[k]>-nums[i]){
                        k--;
                    }else
                    j++;
                }
            
        }

        return res;
    }
}

class Solution {
    class Pair{
        int val;
        int freq;

        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int distinct = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> Integer.compare(a.freq,b.freq));
        for (int key : map.keySet()) {
            if (k > q.size()) {
                q.add(new Pair(key,map.get(key)));
            } else {
                if (q.peek().freq < map.get(key)) {
                    q.poll();
                    q.add(new Pair(key,map.get(key)));
                }
            }
        }
        int res[] = new int[k];
        int i=0;
        while(!q.isEmpty()){
            res[i]=q.poll().val;
            i++;
        }
        return res;
    }
}

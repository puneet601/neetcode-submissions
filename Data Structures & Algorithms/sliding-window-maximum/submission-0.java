class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int res[] = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            q.offer(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int l = 0;

        for (int r = k; r < n; r++) {
            res[l] = q.peek();
            map.put(nums[l], map.get(nums[l]) - 1);
            l++;
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            q.offer(nums[r]);
            while (!q.isEmpty() && map.get(q.peek()) < 1) {
                q.poll();
            }
        }
        res[l] = q.peek();

        return res;
    }
}

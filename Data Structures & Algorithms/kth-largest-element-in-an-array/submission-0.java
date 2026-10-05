class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minK = new PriorityQueue<>();
        for (int i : nums) {
            if (minK.size() < k)
                minK.add(i);
            else {
                if (minK.peek() < i) {
                    minK.poll();
                    minK.add(i);
                }
            }
        }

        return minK.peek();
    }
}

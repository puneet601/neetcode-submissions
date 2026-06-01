class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap = new PriorityQueue<>();
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size()>k){
            minHeap.poll();
        }
        }

        

    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

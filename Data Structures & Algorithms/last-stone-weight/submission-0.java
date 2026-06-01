class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a,b)->b-a;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(c);

        for(int i: stones){
            maxHeap.add(i);
        }

        while(maxHeap.size()>1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x!=y){
                maxHeap.add(Math.abs(x-y));
            }

        }
        return maxHeap.size()>0 ? maxHeap.poll() : 0;
    }
}

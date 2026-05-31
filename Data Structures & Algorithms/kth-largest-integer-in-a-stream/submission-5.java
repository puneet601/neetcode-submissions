class KthLargest {
    int k;
    int nums[];
    int heap[];

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.heap = null;
        if(nums.length>k)
        heapifyK();
        else heapify();
    }

    public int add(int val) {
        
        int newNums[] = new int[nums.length + 1];
        int i=0;
        for (i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        newNums[i]=val;
        this.nums=newNums;
        if(heap==null){
            heapifyK();
        }
        else if(heap[0]<val){
            heap[0]=val;
            bubbleDown();
        }
        return heap[0];
    }

    private void bubbleDown() {
        
        int val = 0;
        while (val < k) {
            int left = 2*val+1;
            int right = 2*val+2;
            // System.out.println("k "+k);
            if (left<k && heap[val] > heap[left]) {
                // System.out.println(heap[val]+" > "+heap[left]);
                swap(val, left, heap);
            }
            if (right<k && heap[val] > heap[right]) {
                swap(val, right, heap);
            }

            val++;
        }
    }

    private void heapifyK() {
        int lastParent = (k - 2) / 2;
        int i = 0;
        while (lastParent >= 0) {
            int left = 2 * lastParent + 1;
            int right = 2 * lastParent + 2;
            if (left<k && nums[left] < nums[lastParent]) {
                swap(left, lastParent, nums);
            }
            if (right<k && nums[right] < nums[lastParent]) {
                swap(right, lastParent, nums);
            }
            lastParent--;
        }
        this.heap = new int[k];
        for (i = 0; i < k; i++) {
            heap[i] = nums[i];
        }
        for(i=k;i<nums.length;i++){
            if(heap[0]< nums[i]){
            heap[0]=nums[i];
            bubbleDown();
        }
        }
    }

    private void heapify() {
        int lastParent = (nums.length - 2) / 2;
        int i = 0;
        while (lastParent >= 0) {
            int left = 2 * lastParent + 1;
            int right = 2 * lastParent + 2;
            if (left< nums.length && nums[left] < nums[lastParent]) {
                swap(left, lastParent, nums);
            }
            if (right<nums.length && nums[right] < nums[lastParent]) {
                swap(right, lastParent, nums);
            }
            lastParent--;
        }
        
        }
    

    private void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

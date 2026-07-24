class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int mid=l;
        int index = bs(nums, target, 0, mid-1);
        System.out.println(index);
        if (index == -1)
            index = bs(nums, target, mid, n - 1);
        System.out.println(index);
        return index;
    }
    int bs(int nums[], int t, int l, int r) {
        int mid = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < t)
                l = mid + 1;
            else if (nums[mid] > t)
                r = mid-1;
            else
                return mid;
        }
        // if (l == r) {
        //     if (nums[l] == t)
        //         return l;
        // }
        return -1;
    }
}

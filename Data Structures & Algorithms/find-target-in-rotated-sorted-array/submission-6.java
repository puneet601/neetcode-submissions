class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        int mid = -1;
        if (nums[l] > nums[r]) {
            while (l < r) {
                mid = l + (r - l) / 2;
                if (mid > 0 && nums[mid] < nums[mid - 1]) {
                    mid=mid-1;
                    break;
                }
                if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
                    
                    break;
                }
                if (nums[mid] < nums[r])
                    r = mid;
                else if (nums[mid] > nums[l])
                    l = mid + 1;
            }
        }

        else if (l == r) {
            l = 0;
            mid = n - 1;
        }
        System.out.println(mid);
        int index = bs(nums, target, 0, mid);
        System.out.println(index);
        if (index == -1)
            index = bs(nums, target, mid+1, n - 1);
        System.out.println(index);
        return index;
    }
    int bs(int nums[], int t, int l, int r) {
        int mid = -1;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < t)
                l = mid + 1;
            else if (nums[mid] > t)
                r = mid;
            else
                return mid;
        }
        if (l == r) {
            if (nums[l] == t)
                return l;
        }
        return -1;
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i]++;
        while (i >= 0 && digits[i] == 10) {
            if (i == 0) {
                int[] nums = new int[digits.length + 1];
                nums[0] = 1;
                return nums;
            }
            digits[i] = 0;
            i--;
            digits[i]++;
        }

        return digits;
    }
}

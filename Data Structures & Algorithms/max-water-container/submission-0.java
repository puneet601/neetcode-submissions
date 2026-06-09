class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n-1;
        
        int max = 0;
        int curr = 0;

        while (i < j) {
            int width = j - i;
            if (heights[i] < heights[j]) {
                curr = heights[i] * width;
                i++;

            } else {
                curr = heights[j] * width;
                j--;
            }

            max = max > curr ? max : curr;
        }
        return max;
    }
}

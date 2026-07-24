class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = max > piles[i] ? max : piles[i];
        }

        if (h == n)
            return max;

        int l = 1;
        int r = max;
        int rate = max;
        // 1432 9
        while (l < r) {
            if (l == r)
                return rate;
            int mid = l + r;
            mid /= 2;
            if (timeToFinish(piles, mid, h)) {
                rate = rate > mid ? mid : rate;
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return rate;
    }

    boolean timeToFinish(int piles[], int k, int h) {
        int t = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % k != 0)
                t++;
            t += Math.ceil(piles[i] / k);
        }

        return t <= h;
    }
}

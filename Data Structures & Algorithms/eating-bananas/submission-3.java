class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n =piles.length;
        int max = Integer.MIN_VALUE;
        

        for(int i=0;i<n;i++){
            max = max > piles[i] ? max : piles[i];
        }

        if(h==n)
        return max;

        int l = 1;
        int r = max;

        int rate = max;
        int time = n;
        int prev = -1;

        //[3,6,7,11] h=8 n=4 max=11
        while(l<r){
            int mid = l+r;
            mid/=2;
            int t = timeToFinish(piles,mid);
            System.out.println("t: "+t+" mid: "+mid+" l: "+l+" r: "+r+"time: "+ time+"rate: "+rate );
            if(prev == mid)
            return rate;
            if(t<=h && time<=t && rate>mid){
                time = t;
                rate = mid;
            }
            if(t>h)
            l=mid;
            else
            r=mid;
            prev = mid;
        }
        return rate;
        
    }

    int timeToFinish(int piles[],int k){
        int t = 0;
        for(int i=0;i<piles.length;i++){
            // System.out.println("t: "+t+" add: "+Math.ceil(piles[i]/k));
            if(piles[i]%k!=0)
            t++;
            t+=Math.ceil(piles[i]/k);
        }

        return t;
    }

}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int res[] = new int [m+n];
        for(int i=0;i<m;i++){
            res[i]=nums1[i];
        }
        for(int i=m;i<m+n;i++){
            res[i]=nums2[i-m];
        }

        Arrays.sort(res);

        m+=n;
        if(m%2==0){
            double result = (res[m/2]+res[(m-1)/2])/2.0;
            return result;
        }else{
            return (double) res[m/2];
        }

    }
}

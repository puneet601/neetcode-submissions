class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int s= m+n;
        int med = s/2;
        

        int res[] = new int [s];
        
        m=0;n=0;
        for(int i=0;i<=med;i++){
            if(m<nums1.length && n<nums2.length)
            res[i]=nums1[m]>nums2[n] ? nums2[n++]:nums1[m++];
            else if(m<nums1.length)
            res[i]=nums1[m++];
            else if(n<nums2.length)
            res[i]=nums2[n++];
        }

        
        if(s%2==0){
            double result = (res[med]+res[med-1])/2.0;
            return result;
        }else{
            return (double) res[med];
        }

    }
}

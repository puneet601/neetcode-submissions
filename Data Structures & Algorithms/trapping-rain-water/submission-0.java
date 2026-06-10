class Solution {
    public int trap(int[] height) {
        int n =height.length;
        int suffix[] = new int[n];
        int prefix[] = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            if(height[i]<max)
            prefix[i]=max;
            else{
            max=height[i];
            prefix[i]=0;
            }
            // System.out.println(prefix[i]);
        }

        // System.out.println("-----");
max=0;
        for(int i=n-1;i>=0;i--){
            if(height[i]<max)
            suffix[i]=max;
            else{
            max=height[i];
            suffix[i]=0;
            }
           
        }

        int total = 0;

        for(int i=0;i<n;i++){
            // System.out.println("prefix :"+prefix[i]+" suffix "+suffix[i]+ " curr "+height[i]);
            int cap = Math.min(prefix[i],suffix[i]);
            if(cap>0)
            total += cap-height[i];
        }
        
        return total;
    }
}

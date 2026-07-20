class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix,i,matrix[i].length,target))
            return true;
        }
        return false;
    }

    boolean binarySearch(int[][] arr, int row,int n, int target){
        int l = 0;
        int r = n-1;

        while(l<=r){
            int curr = (l+r)/2;
            if(arr[row][curr]==target)
            return true;
            if(arr[row][curr]<target)
            l++;
            else
            r--;
        }
        return false;
    }
}

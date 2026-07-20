class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
            if self.binarySearch(matrix,i,len(matrix[i]),target):
                return True

        return False

    def binarySearch(self,arr:List[List[int]],row: int,n: int, target:int) -> bool:
        l = 0
        r = n-1
        while(l<=r):
            curr = l+r
            curr = curr//2
            if arr[row][curr] == target:
                return True
            if arr[row][curr] > target:
                r = curr-1
            else:
                l = curr+1
        
        return False

        
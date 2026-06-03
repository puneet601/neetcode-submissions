class Solution {
    public boolean isHappy(int n) {
        int slow=getSumOfSq(n);
        int fast=getSumOfSq(slow);
        if(slow==1 || fast==1)
            return true;
        while(slow!=fast){
            slow = getSumOfSq(slow);
            fast = getSumOfSq(getSumOfSq(fast));
            if(slow==1 || fast==1)
            return true;
        }
        return false;
    }

    int getSumOfSq(int n){
        if(n==0)
        return n;
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum+=digit*digit;
            n/=10;
        }
        return sum;
    }
}

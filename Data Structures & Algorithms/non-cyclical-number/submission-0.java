class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n!=1){
            List<Integer> digits = getDigits(n, new ArrayList<>());
            int sum = 0;
            for(int i=0;i<digits.size();i++){
                sum+=(digits.get(i)*digits.get(i));
            }
            if(sum==1)
            return true;

            if(set.contains(sum))
            return false;
            set.add(sum);
            n=sum;
        }
        return true;
    }

    List<Integer> getDigits(int n,List<Integer> digits ){
        if(n==0)
        return digits;
        digits.add(n%10);
        getDigits(n/10,digits);
        return digits;
    }
}

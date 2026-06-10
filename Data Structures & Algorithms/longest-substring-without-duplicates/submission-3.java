class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        
        int max = 0;int st = 0;int i=0;
        for( i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                int len = i-st;
                max = max > len ? max :len;
                while(s.charAt(st)!=c){
                    set.remove(s.charAt(st));
                    st++;
                }   
                st++;          
            }
            set.add(c);
        }
        int len = i-st;
        max = max > len ? max :len;
        return max;
    }
}

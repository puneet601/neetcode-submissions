class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int len = s.length();
        int end = len - 1;
        String str = s.toLowerCase();
        StringBuilder st = new StringBuilder();
        for (start = 0; start < len; start++) {
            if (isAlphanumeric(start, str))
                st.append(str.charAt(start));
        }
        end = st.length()-1;
        for (start = 0; start < st.length() / 2; start++) {
            if (st.charAt(start) != st.charAt(end)) {
                return false;
            }
            end--;
        }
    
    return true;
}

public boolean isAlphanumeric(int i, String s) {
    char c = s.charAt(i);

    if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
        return true;
    return false;
}
}
